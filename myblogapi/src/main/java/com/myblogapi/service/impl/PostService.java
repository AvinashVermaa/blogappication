package com.myblogapi.service.impl;

import com.myblogapi.payload.PostDto;
import com.myblogapi.payload.PostResponse;

import java.util.*;

public interface PostService {

	PostDto createPost(PostDto postDto);
	
	PostResponse getAllPosts(int pageNo,int pageSize,String sortBy,String sortDir);
	
	PostDto getPostById(Long id);
	
	PostDto updatePost(PostDto postDto,Long id);
	
	PostDto deletePost(Long id);
}
