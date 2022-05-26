package com.example.shaleenslec.controller;

import com.example.shaleenslec.dto.paginateddto.PaginatedPostResponseDTO;
import com.example.shaleenslec.dto.requestdto.PostRequestDTO;
import com.example.shaleenslec.dto.requestdto.RequestAvailablePostsDTO;
import com.example.shaleenslec.service.PostService;
import com.example.shaleenslec.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/post")
public class PostController {
    private final Logger LOGGER = LoggerFactory.getLogger(PostController.class);
    @Autowired
    private PostService postService;

    @PostMapping(path = "create/post", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<StandardResponse> savePost(@Valid @RequestBody PostRequestDTO dto) {
        String savePostId = postService.savePost(dto);
        LOGGER.info("Property Successfully Saved!, Id:" + savePostId);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,
                "Post Saved!",
                savePostId),
                HttpStatus.CREATED);
    }

    @PutMapping(path = "modify/post", params = {"PropertyId", "title"})
    public ResponseEntity<StandardResponse> updatePost(@RequestParam(value = "PropertyId") String id,
                                                       @RequestParam(value = "title") String title) {
        boolean isUpdate = postService.updatePost(id, title);
        LOGGER.info("Property Successfully Updated!, Id:" + isUpdate);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,
                "Post Updated!",
                isUpdate),
                HttpStatus.CREATED);
    }

    @DeleteMapping(path = "delete/{propertyId}")
    public ResponseEntity<StandardResponse> deletePost(@PathVariable String propertyId) {
        boolean isDelete = postService.deletePost(propertyId);

        LOGGER.info("Property Successfully Deleted!, Id:" + isDelete);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,
                "Post Deleted!",
                isDelete),
                HttpStatus.CREATED);
    }


    @GetMapping(path = "/getAll", params = {"page", "size", "searchText"})
    public ResponseEntity<StandardResponse> getAllPost(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size,
            @RequestParam(value = "searchText") String searchText) {

        PaginatedPostResponseDTO paginatedPostResponseDTO = postService.getAllPost(page, size, searchText);
//        System.out.println("come", paginatedPostResponseDTO.getList());

        LOGGER.info("Here All Posts! =>" + paginatedPostResponseDTO);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,
                "Here All Posts!",
                paginatedPostResponseDTO),
                HttpStatus.CREATED);
    }


    @GetMapping(path = "/getByIds", params = {"propertyIds"})
    public ResponseEntity<StandardResponse> getAllByPropertyIds(
            @RequestParam(value = "propertyIds") ArrayList<String> propertyIds) {

        List<RequestAvailablePostsDTO> requestAvailablePostsDTO = postService.getAllAvailablePostsByPostIdList(propertyIds);

        if (requestAvailablePostsDTO.size() == 0) {
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(250, "Property Not Available", requestAvailablePostsDTO),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200, "Success", requestAvailablePostsDTO),
                    HttpStatus.OK);

        }
    }

}

