package com.example.shaleenslec.util.mapper;

import com.example.shaleenslec.dto.PostDTO;
import com.example.shaleenslec.dto.requestdto.RequestAvailablePostsDTO;
import com.example.shaleenslec.dto.responsedto.PostResponseDTO;
import com.example.shaleenslec.entity.Post;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-23T20:33:50+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.14 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post toPost(PostDTO postDTO) {
        if ( postDTO == null ) {
            return null;
        }

        Post post = new Post();

        post.setPropertyId( postDTO.getPropertyId() );
        post.setTitle( postDTO.getTitle() );
        ArrayList arrayList = postDTO.getKeywords();
        if ( arrayList != null ) {
            post.setKeywords( new ArrayList( arrayList ) );
        }
        post.setShortDescription( postDTO.getShortDescription() );
        post.setPublishedDate( postDTO.getPublishedDate() );
        post.setPriorityType( postDTO.getPriorityType() );
        ArrayList arrayList1 = postDTO.getSourceLinks();
        if ( arrayList1 != null ) {
            post.setSourceLinks( new ArrayList( arrayList1 ) );
        }
        ArrayList arrayList2 = postDTO.getDescription();
        if ( arrayList2 != null ) {
            post.setDescription( new ArrayList( arrayList2 ) );
        }
        post.setConsumerType( postDTO.getConsumerType() );
        post.setPropertyAvailability( postDTO.isPropertyAvailability() );
        ArrayList arrayList3 = postDTO.getOtherData();
        if ( arrayList3 != null ) {
            post.setOtherData( new ArrayList( arrayList3 ) );
        }

        return post;
    }

    @Override
    public List<PostResponseDTO> toPostResponseDtos(Page<Post> posts) {
        if ( posts == null ) {
            return null;
        }

        List<PostResponseDTO> list = new ArrayList<PostResponseDTO>();
        for ( Post post : posts ) {
            list.add( postToPostResponseDTO( post ) );
        }

        return list;
    }

    @Override
    public List<RequestAvailablePostsDTO> toPosts(List<Post> getAllRequestedPosts) {
        if ( getAllRequestedPosts == null ) {
            return null;
        }

        List<RequestAvailablePostsDTO> list = new ArrayList<RequestAvailablePostsDTO>( getAllRequestedPosts.size() );
        for ( Post post : getAllRequestedPosts ) {
            list.add( postToRequestAvailablePostsDTO( post ) );
        }

        return list;
    }

    protected PostResponseDTO postToPostResponseDTO(Post post) {
        if ( post == null ) {
            return null;
        }

        PostResponseDTO postResponseDTO = new PostResponseDTO();

        ArrayList arrayList = post.getKeywords();
        if ( arrayList != null ) {
            postResponseDTO.setKeywords( new ArrayList( arrayList ) );
        }
        postResponseDTO.setShortDescription( post.getShortDescription() );
        postResponseDTO.setPublishedDate( post.getPublishedDate() );
        if ( post.getPriorityType() != null ) {
            postResponseDTO.setPriorityType( post.getPriorityType().name() );
        }
        ArrayList arrayList1 = post.getSourceLinks();
        if ( arrayList1 != null ) {
            postResponseDTO.setSourceLinks( new ArrayList( arrayList1 ) );
        }
        ArrayList arrayList2 = post.getDescription();
        if ( arrayList2 != null ) {
            postResponseDTO.setDescription( new ArrayList( arrayList2 ) );
        }
        if ( post.getConsumerType() != null ) {
            postResponseDTO.setConsumerType( post.getConsumerType().name() );
        }
        ArrayList arrayList3 = post.getOtherData();
        if ( arrayList3 != null ) {
            postResponseDTO.setOtherData( new ArrayList( arrayList3 ) );
        }

        return postResponseDTO;
    }

    protected RequestAvailablePostsDTO postToRequestAvailablePostsDTO(Post post) {
        if ( post == null ) {
            return null;
        }

        RequestAvailablePostsDTO requestAvailablePostsDTO = new RequestAvailablePostsDTO();

        requestAvailablePostsDTO.setPropertyId( post.getPropertyId() );
        requestAvailablePostsDTO.setTitle( post.getTitle() );
        requestAvailablePostsDTO.setShortDescription( post.getShortDescription() );
        requestAvailablePostsDTO.setPublishedDate( post.getPublishedDate() );
        if ( post.getPriorityType() != null ) {
            requestAvailablePostsDTO.setPriorityType( post.getPriorityType().name() );
        }

        return requestAvailablePostsDTO;
    }
}
