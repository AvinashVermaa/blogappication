package com.myblogapi.mapper;

import com.myblogapi.entity.Comment;
import com.myblogapi.payload.CommentDto;

public class CommentMapper {

	public static Comment mapToComment(CommentDto commentDto) {
		Comment comment = new Comment();
		comment.setId(commentDto.getId());
		comment.setName(commentDto.getName());
		comment.setEmail(commentDto.getEmail());
		comment.setBody(commentDto.getBody());
		
		return comment;
	}
	
	public static CommentDto mapToCommentDto(Comment comment) {
		CommentDto dto = new CommentDto(comment.getId(),comment.getName(),comment.getEmail(),comment.getBody());
		return dto;
	}
}
