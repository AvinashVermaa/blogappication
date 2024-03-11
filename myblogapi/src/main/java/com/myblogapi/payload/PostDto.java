package com.myblogapi.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PostDto {

	private Long id;
	
	@NotNull
	@NotEmpty
	@Size(min = 2,message = "Post title must have atleast 2 character")
	private String title;
	
	@NotNull
	@NotEmpty
	@Size(min=10,message ="Post description must have atleast 10 character")
	private String description;
	
	@NotNull
	@NotEmpty
	private String content;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "PostDto [id=" + id + ", title=" + title + ", description=" + description + ", content=" + content + "]";
	}
	public PostDto(Long id, String title, String description, String content) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
	}
	public PostDto(String title, String description, String content) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
	}
	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
