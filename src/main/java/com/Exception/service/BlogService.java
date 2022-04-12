package com.Exception.service;

import com.Exception.exception.BlogAlreadyExistsException;
import com.Exception.exception.BlogNotFoundException;
import com.Exception.model.Blog;

import antlr.collections.List;

public interface BlogService {
	
	Blog saveBlog(Blog blog) throws BlogAlreadyExistsException;

	java.util.List getAllBlogs() throws BlogNotFoundException;

	Blog getBlogById(int id) throws BlogNotFoundException;

}
