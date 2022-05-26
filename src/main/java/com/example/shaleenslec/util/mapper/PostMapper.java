package com.example.shaleenslec.util.mapper;

import com.example.shaleenslec.dto.PostDTO;
import com.example.shaleenslec.dto.requestdto.RequestAvailablePostsDTO;
import com.example.shaleenslec.dto.responsedto.PostResponseDTO;
import com.example.shaleenslec.entity.Post;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post toPost(PostDTO postDTO);

    List<PostResponseDTO> toPostResponseDtos(Page<Post> posts);

    List<RequestAvailablePostsDTO> toPosts(List<Post> getAllRequestedPosts);
}


