/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.controller;


import com.example.plan.model.Stock;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.plan.service.StockService;


@RestController
@RequestMapping("/act")
public class StockRestController {
    @Autowired
    private StockService postService;
    
    @GetMapping("/all")
    public List<Stock> getPosts() {
        return postService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Stock> getPost(@PathVariable int id) {
        Stock post = postService.findById(id);
        return ResponseEntity.ok(post);
    }
    
     @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {        
        postService.deleteById(id);
    }
    
    @PostMapping("/add")
    public int addPost(@RequestBody Stock post) {  
        return postService.insert(post);
    }
    @PutMapping("/edit")
    public int editPost(@RequestBody Stock post) {  
        Stock pos = new Stock(post.getIdproducto(),post.getMarca(),post.getColor(),post.getTalla());
        return postService.update(post);
    }
    
}
