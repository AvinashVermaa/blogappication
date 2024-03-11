package com.myblogapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.myblogapi.entity.Comment;
import com.myblogapi.entity.Post;
import com.myblogapi.exception.BlogApiException;
import com.myblogapi.exception.ResourceNotFoundException;
import com.myblogapi.mapper.CommentMapper;
import com.myblogapi.payload.CommentDto;
import com.myblogapi.repository.CommentRepository;
import com.myblogapi.repository.PostRepository;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private ModelMapper mapper;

	
	@Override
	public CommentDto createComment(Long postId,CommentDto commentDto) {
		// TODO Auto-generated method stub
		Post post = postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));
		if(post.getTitle()!="" && post.getTitle()!=null)
		{
			Comment comment = CommentMapper.mapToComment(commentDto);
			comment.setPost(post);
			Comment savedComment = commentRepo.save(comment);
			//return CommentMapper.mapToCommentDto(savedComment);
			return mapper.map(savedComment, CommentDto.class);
		}
		else {
			return new CommentDto();
		}
	}


	@Override
	public CommentDto getCommentsById(Long commentId,Long postId) throws BlogApiException{
		Post post = postRepo.findById(postId).orElseThrow(
				()-> new ResourceNotFoundException("Post","id",postId));
		
		Comment comment = commentRepo.findById(commentId).orElseThrow(
				()-> new ResourceNotFoundException("Comments","id",commentId)
				);
		
		if(!(comment.getPost().getId().equals(post.getId()))) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST.toString(), "Comment does not belong to post");
		}
		else {
			//return CommentMapper.mapToCommentDto(comment);
			return mapper.map(comment, CommentDto.class);
		}
		
	}


	@Override
	public List<CommentDto> getCommentsByPostId(Long postId) {
		List<Comment> comments = commentRepo.findCommentByPostId(postId);
		List<CommentDto> commentDtos = comments.stream().map(CommentMapper :: mapToCommentDto).collect(Collectors.toList());
		return commentDtos;
	}


	@Override
	public CommentDto updateComment(Long postId, Long commentId, CommentDto commentDto) throws Exception{
		Post post = postRepo.findById(postId).orElseThrow(
				()-> new ResourceNotFoundException("Posts","id",postId)
				);
		
		Comment comment = commentRepo.findById(commentId).orElseThrow(
				()-> new ResourceNotFoundException("comments","id",commentId)
				);
		
		if(!(comment.getPost().getId().equals(post.getId()))) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST.toString(),"Comment does not belong to the post");
			
		}
		else {
			comment.setName(commentDto.getName());
			comment.setEmail(commentDto.getEmail());
			comment.setBody(commentDto.getBody());
			
			commentRepo.save(comment);
			
			//return CommentMapper.mapToCommentDto(comment);
			return mapper.map(comment, CommentDto.class);
		}
	
	}


	@Override
	public String deleteComment(Long postId, Long commentId) throws Exception {
		
		Post post = postRepo.findById(postId).orElseThrow(
				()->
					new ResourceNotFoundException("Posts","id",postId)
				);
		
		Comment comment = commentRepo.findById(commentId).orElseThrow(
				()-> new ResourceNotFoundException("comments","id",commentId)
				);
		
		if(!(comment.getPost().getId().equals(post.getId()))) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST.toString(),"Comment does not belong to Posts");
		}
		else {
			commentRepo.deleteById(commentId);
			return "Comment is deleted successfully";
		}
		
		
	}

}
