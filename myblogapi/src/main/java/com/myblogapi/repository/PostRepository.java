package com.myblogapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myblogapi.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
