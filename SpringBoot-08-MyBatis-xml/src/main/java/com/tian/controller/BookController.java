package com.tian.controller;

import com.tian.dao.BookMapper;
import com.tian.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookMapper bookMapper;
    @RequestMapping("/list")
    public List<Books> list(){
        return bookMapper.queryAllBook();
    }
    @RequestMapping("/select")
    public Books select(int id){
        return bookMapper.queryBookById(id);
    }
}
