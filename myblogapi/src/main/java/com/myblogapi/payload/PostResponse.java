package com.myblogapi.payload;

import java.util.List;

public class PostResponse {

	private List<PostDto> contents;
	private int pageNo;
	private int pageSize;
	private long totalElements;
	private int totalPages;
	private boolean last;
	
	
	public PostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostResponse(List<PostDto> contents, int pageNo, int pageSize, long totalElements, int totalPages,
			boolean last) {
		super();
		this.contents = contents;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.last = last;
	}
	@Override
	public String toString() {
		return "PostResponse [contents=" + contents + ", pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", totalElements=" + totalElements + ", totalPages=" + totalPages + ", last=" + last + "]";
	}
	public List<PostDto> getContents() {
		return contents;
	}
	public void setContents(List<PostDto> contents) {
		this.contents = contents;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
}
