package com.myblogapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myblogapi.exception.BlogApiException;
import com.myblogapi.payload.CommentDto;
import com.myblogapi.service.impl.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping("/posts/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@PathVariable("postId") Long postId,@RequestBody CommentDto commentDto){
		CommentDto dto = commentService.createComment(postId, commentDto);
		return new ResponseEntity<CommentDto>(dto, HttpStatus.CREATED);
	}
	
	@GetMapping("comments/{commentId}")
	public ResponseEntity<List<CommentDto>> getCommentsByPostId(@PathVariable("commentId") Long commentId){
		//List<CommentDto> commentDtos = commentService.getCommentsById(commentId);
		List<CommentDto> commentDtos = commentService.getCommentsByPostId(commentId);
		return new ResponseEntity<List<CommentDto>>(commentDtos, HttpStatus.OK);
	}
	
	@GetMapping("posts/{postId}/comments/{commentId}")
	public ResponseEntity<CommentDto> getCommentByCommentId(@PathVariable("postId") Long postId,
			@PathVariable("commentId") Long commentId
			) throws BlogApiException{
		CommentDto commentDto = commentService.getCommentsById(commentId, postId);
		
		return new ResponseEntity<CommentDto>(commentDto, HttpStatus.OK);
	}
	
	@PutMapping("posts/{postId}/comments/{commentId}")
	public ResponseEntity<CommentDto> updateComment(@PathVariable("postId") Long postId,@PathVariable("commentId")
			Long commentId,@RequestBody CommentDto commentDto
			) throws Exception{
		CommentDto dto = commentService.updateComment(postId, commentId, commentDto);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@DeleteMapping("posts/{postId}/comments/{commentId}")
	public ResponseEntity<String> deleteComment(@PathVariable("postId") Long postId,
			@PathVariable("commentId") Long commentId
			
			) throws Exception{
		String message = commentService.deleteComment(postId, commentId);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	
}
