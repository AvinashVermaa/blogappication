package com.myblogapi.service.impl;

import java.util.List;

import com.myblogapi.exception.BlogApiException;
import com.myblogapi.payload.CommentDto;

public interface CommentService {

	public CommentDto createComment(Long postId,CommentDto commentDto);
	
	public CommentDto getCommentsById(Long commentId,Long postId) throws BlogApiException;
	
	public List<CommentDto> getCommentsByPostId(Long postId);
	
	public CommentDto updateComment(Long postId,Long commentId,CommentDto commentDto) throws Exception;
	
	public String deleteComment(Long postId,Long commentId) throws Exception;
}
