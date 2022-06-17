/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.controller;

import com.example.plan.model.Zapato;
import com.example.plan.service.ZapatoService;
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



@RestController
@RequestMapping("/act3")
public class ZapatoRestController {
    @Autowired
    private ZapatoService postService;
    
    @GetMapping("/all")
    public List<Zapato> getPosts() {
        return postService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Zapato> getPost(@PathVariable int id) {
        Zapato post = postService.findById(id);
        return ResponseEntity.ok(post);
    }
    
     @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {        
        postService.deleteById(id);
    }
    
    @PostMapping("/add")
    public int addPost(@RequestBody Zapato post) {  
        return postService.insert(post);
    }
    @PutMapping("/edit")
    public int editPost(@RequestBody Zapato post) {  
        Zapato pos = new Zapato(post.getIdzapato(),post.getMarca(),post.getTalla(),post.getColor(),post.getPreciozapato(),post.getDescripcion(),post.getStock(),post.getEstado(),post.getIdcategoria());
        return postService.update(post);
    }
    
}
