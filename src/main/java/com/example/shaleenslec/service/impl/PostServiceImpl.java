package com.example.shaleenslec.service.impl;

import com.example.shaleenslec.dto.PostDTO;
import com.example.shaleenslec.dto.core.GeneratedIdentificationDTO;
import com.example.shaleenslec.dto.paginateddto.PaginatedPostResponseDTO;
import com.example.shaleenslec.dto.requestdto.PostRequestDTO;
import com.example.shaleenslec.dto.requestdto.RequestAvailablePostsDTO;
import com.example.shaleenslec.entity.Post;
import com.example.shaleenslec.enums.ConsumerType;
import com.example.shaleenslec.enums.PriorityTypes;
import com.example.shaleenslec.exceptions.EntryDuplicationException;
import com.example.shaleenslec.repo.PostRepo;
import com.example.shaleenslec.service.PostService;
import com.example.shaleenslec.util.Generator;
import com.example.shaleenslec.util.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private Generator generator;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private PostMapper postMapper;

    @Override
    public String savePost(PostRequestDTO dto) {
        GeneratedIdentificationDTO generatorId = generator.createId();
        ConsumerType consumerType = ConsumerType.valueOf(dto.getConsumerType());
        PriorityTypes priorityTypes = PriorityTypes.valueOf(dto.getPriorityType());

        PostDTO postDTO = new PostDTO(
                generatorId.getPrefix() + "-POST-" + generatorId.getId(),
                dto.getTitle(),
                dto.getKeywords(),
                dto.getShortDescription(),
                dto.getPublishedDate(),
                priorityTypes,
                dto.getSourceLinks(),
//               new ArrayList(), his wa ywanne mehema
                dto.getDescription(),
                consumerType,
                true,
                dto.getOtherData()
        );
        if (!postRepo.existsById(postDTO.getPropertyId())) {
            return postRepo.save(postMapper.toPost(postDTO)).getPropertyId();
        } else {
            throw new EntryDuplicationException("Already exits");
        }

    }

    @Override
    public boolean updatePost(String id, String title) {
        Optional<Post> postUpdated = postRepo.findById(id);
        if (postUpdated.isPresent()) {
            postUpdated.get().setTitle(title);
            postRepo.save(postUpdated.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePost(String propertyId) {
        if (postRepo.existsById(propertyId)) {
            postRepo.deleteById(propertyId);
            return true;
        }

        return false;
    }

    @Override
    public PaginatedPostResponseDTO getAllPost(int page, int size, String searchText) {
        Page<Post> all = postRepo.getAll(searchText, PageRequest.of(page, size));
        System.out.println(searchText + page + " " + size);
        System.out.println();
        return new PaginatedPostResponseDTO(
                postMapper.toPostResponseDtos(all),
                postRepo.countDataCount(searchText)
        );
    }

    @Override
    public List<RequestAvailablePostsDTO> getAllAvailablePostsByPostIdList(ArrayList<String> propertyIds) {

        List<RequestAvailablePostsDTO> requestAvailablePostsDTO = new ArrayList<>();

        List<Post> getAllRequestedPosts = postRepo.findAllByPropertyIdIn(propertyIds);

        return postMapper.toPosts(getAllRequestedPosts);


    }


}
