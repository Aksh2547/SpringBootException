package com.Exception.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Exception.dao.BlogRepository;
import com.Exception.exception.BlogAlreadyExistsException;
import com.Exception.exception.BlogNotFoundException;
import com.Exception.model.Blog;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Override
	public Blog saveBlog(Blog blog) {

		if (blogRepository.existsById(blog.getBlogId())) {
			
			throw new BlogAlreadyExistsException();
		}
		Blog savedBlog = blogRepository.save(blog);
		return savedBlog;
	}

	@Override
	public List<Blog> getAllBlogs() {
		return (List<Blog>) blogRepository.findAll();
	}

	@Override
	public Blog getBlogById(int id) throws BlogNotFoundException {
		Blog blog;
		if (blogRepository.findById(id).isEmpty()) {
			
			throw new BlogNotFoundException();
		} 
		else 
		{
			blog = blogRepository.findById(id).get();
		}
		return blog;
	}

}
