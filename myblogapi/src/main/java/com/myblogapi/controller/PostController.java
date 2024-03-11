package com.myblogapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myblogapi.payload.PostDto;
import com.myblogapi.payload.PostResponse;
import com.myblogapi.service.impl.PostService;
import com.myblogapi.utilies.AppConstants;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("createPost")
	public ResponseEntity<PostDto> createPost(@Valid  @RequestBody PostDto postDto){
		PostDto p1 = postService.createPost(postDto);
		return new ResponseEntity<PostDto>(p1, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllPosts")
	public PostResponse getAllPosts(@RequestParam(value = "pageNo",required = false,defaultValue = AppConstants.pageNo) int pageNo,
			@RequestParam(value="pageSize",required=false,defaultValue = AppConstants.pageSize) int pageSize,
			@RequestParam(value="sortBy",required=false,defaultValue = AppConstants.sortBy) String sortBy,
			@RequestParam(value="sortDir",required=false,defaultValue=AppConstants.sortDir) String sortDir
			){
		 PostResponse postResponse = postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);
		return postResponse;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable("id") Long id){
		PostDto postDto = postService.getPostById(id);
		return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto,@PathVariable("id") Long id){
		PostDto postDto1 = postService.updatePost(postDto, id);
		return new ResponseEntity<PostDto>(postDto1, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<PostDto> deletePost(@PathVariable("id") Long id){
		PostDto postDto = postService.deletePost(id);
		return new ResponseEntity<PostDto>(postDto, HttpStatus.GONE);
	}
	
}
