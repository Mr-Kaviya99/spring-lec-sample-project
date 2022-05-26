package com.example.shaleenslec.service;

import com.example.shaleenslec.dto.paginateddto.PaginatedPostResponseDTO;
import com.example.shaleenslec.dto.requestdto.PostRequestDTO;
import com.example.shaleenslec.dto.requestdto.RequestAvailablePostsDTO;

import java.util.ArrayList;
import java.util.List;

public interface PostService {
    String savePost(PostRequestDTO dto);

    boolean updatePost(String id, String title);

    boolean deletePost(String id);

    PaginatedPostResponseDTO getAllPost(int page, int size, String searchText);

    List<RequestAvailablePostsDTO> getAllAvailablePostsByPostIdList(ArrayList<String> propertyIds);
}
