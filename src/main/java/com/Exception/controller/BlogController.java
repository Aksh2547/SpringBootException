package com.Exception.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Exception.exception.BlogAlreadyExistsException;
import com.Exception.exception.BlogNotFoundException;
import com.Exception.model.Blog;
import com.Exception.service.BlogService;

@RestController
@RequestMapping("api/v1")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@PostMapping("/blog")
	public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) throws BlogAlreadyExistsException {

		Blog savedBlog = blogService.saveBlog(blog);
		return new ResponseEntity<>(savedBlog, HttpStatus.CREATED);
	}

	@GetMapping("/blogs")
	public ResponseEntity<List<Blog>> getAllBlogs() throws BlogNotFoundException {
		
		return new ResponseEntity<List<Blog>>(blogService.getAllBlogs(), HttpStatus.OK);
	}

	@GetMapping("blog/{id}")
	public ResponseEntity<Blog> getBlogById(@PathVariable("id") int id) throws BlogNotFoundException {

		return new ResponseEntity<Blog>(blogService.getBlogById(id), HttpStatus.OK);
	}
}