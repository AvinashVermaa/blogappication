package com.myblogapi.payload;

import java.util.Objects;

public class CommentDto {

	private Long id;
	private String name;
	private String email;
	private String body;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public int hashCode() {
		return Objects.hash(body, email, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentDto other = (CommentDto) obj;
		return Objects.equals(body, other.body) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "CommentDto [id=" + id + ", name=" + name + ", email=" + email + ", body=" + body + "]";
	}
	public CommentDto(Long id, String name, String email, String body) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.body = body;
	}
	public CommentDto(String name, String email, String body) {
		super();
		this.name = name;
		this.email = email;
		this.body = body;
	}
	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
