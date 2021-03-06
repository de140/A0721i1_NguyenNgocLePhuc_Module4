package com.codegym.blog_managerment.service.impl;

import com.codegym.blog_managerment.model.Blog;
import com.codegym.blog_managerment.repository.BlogRepository;
import com.codegym.blog_managerment.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findBlogById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAllBlogById(int id) {
        return blogRepository.findAllBlogById(id);
    }

    @Override
    public Page<Blog> findAllBlogById(int id, Pageable pageable) {
        return blogRepository.findAllBlogById(id, pageable);
    }

    @Override
    public Page<Blog> findByContent(String content,Pageable pageable) {
        return blogRepository.findByContent(content, pageable);
    }
}