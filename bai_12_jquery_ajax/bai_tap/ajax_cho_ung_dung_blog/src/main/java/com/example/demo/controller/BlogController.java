package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @GetMapping("/home")
    public ResponseEntity<Page<Blog>> getList(@PageableDefault(size = 2) Pageable pageable){
        Page<Blog> blogList =  iBlogService.findAll(pageable);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @GetMapping("/list")
    public ModelAndView getList1(@PageableDefault(size = 2) Pageable pageable){
        Page<Blog> blogPageable = iBlogService.findAll(pageable);
        return new ModelAndView("home", "listBlog", blogPageable);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> returnList(String Name ){
        List<Blog> list = iBlogService.findByName(Name);
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/load")
    public ResponseEntity<List<Blog>> loadBlog(Integer Count){
        List<Blog> blogList = iBlogService.selectLimit(Count+2);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}