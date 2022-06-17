/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.controller;

import com.example.plan.model.Ventas;
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

import com.example.plan.service.VentasService;


@RestController
@RequestMapping("/ac")
public class VentasRestController {
    @Autowired
    private VentasService postService;
    
    @GetMapping("/all")
    public List<Ventas> getPosts() {
        return postService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Ventas> getPost(@PathVariable int id) {
        Ventas post = postService.findById(id);
        return ResponseEntity.ok(post);
    }
    
     @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {        
        postService.deleteById(id);
    }
    
    @PostMapping("/add")
    public int addPost(@RequestBody Ventas post) {  
        return postService.insert(post);
    }
    @PutMapping("/edit")
    public int editPost(@RequestBody Ventas post) {  
        Ventas pos = new Ventas(post.getIdventa(),post.getFecha(),post.getIdusuario(),post.getIdcliente(),post.getIdsucursal(),post.getTipocomprobante(),post.getSeriecomprobante(),post.getNumerocomprobante());
        return postService.update(post);
    }
}
    