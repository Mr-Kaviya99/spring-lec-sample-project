package com.example.shaleenslec.repo;

import com.example.shaleenslec.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface PostRepo extends JpaRepository<Post, String> {

    @Query(value = "select * from post where title like ?1%",nativeQuery = true)
    Page<Post> getAll(String searchText,Pageable pageable);

    @Query(value = "select COUNT(*) from post where title like ?1%",nativeQuery = true)
    long countDataCount(String searchText);

    List<Post> findAllByPropertyIdIn(ArrayList<String> propertyIds);

}
