package com.myblogapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myblogapi.entity.Post;
import com.myblogapi.exception.ResourceNotFoundException;
import com.myblogapi.mapper.PostMapper;
import com.myblogapi.payload.PostDto;
import com.myblogapi.payload.PostResponse;
import com.myblogapi.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{
	
	private PostRepository postRepo;
	
	private ModelMapper mapper;
	
	@Autowired
	public PostServiceImpl(PostRepository postRepo,ModelMapper mapper) {
		this.postRepo = postRepo;
		this.mapper = mapper;
	}

	@Override
	public PostDto createPost(PostDto postDto) {
		//Post p1 = PostMapper.mapToPost(postDto);
		Post p1 = mapper.map(postDto,Post.class);
		postRepo.save(p1);
		//PostDto p2 = PostMapper.mapToDto(p1);
		PostDto p2 = mapper.map(p1, PostDto.class);
		return p2;
	}

	@Override
	public PostResponse getAllPosts(int pageNo,int pageSize,String sortBy,String sortDir) {
		
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
		//sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
		Page<Post> pagePost = postRepo.findAll(pageable);
		List<Post> posts = pagePost.getContent();
		List<PostDto> postDtos = posts.stream().map(PostMapper :: mapToDto).collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		postResponse.setContents(postDtos);
		postResponse.setPageNo(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLast(pagePost.isLast());
		
		return postResponse;
	}

	@Override
	public PostDto getPostById(Long id) {
		Post post = postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
		//PostDto p1 = PostMapper.mapToDto(post);
		PostDto p1 = mapper.map(post, PostDto.class);
		return p1;
	}

	@Override
	public PostDto updatePost(PostDto postDto, Long id) {
		Post post = postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getTitle());
		
		Post p2 = postRepo.save(post);
		PostDto p3 = mapper.map(p2, PostDto.class);
		return p3;
	}

	@Override
	public PostDto deletePost(Long id) {
		Post post = postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
		postRepo.delete(post);
		return PostMapper.mapToDto(post);
	}

}
