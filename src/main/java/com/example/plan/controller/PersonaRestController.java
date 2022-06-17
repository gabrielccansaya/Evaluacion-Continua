/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.controller;

import com.example.plan.model.Persona;
import com.example.plan.service.PersonaService;
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
@RequestMapping("/act2")
public class PersonaRestController {
    @Autowired
    private PersonaService postService;
    
    @GetMapping("/all")
    public List<Persona> getPosts() {
        return postService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPost(@PathVariable int id) {
        Persona post = postService.findById(id);
        return ResponseEntity.ok(post);
    }
    
     @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {        
        postService.deleteById(id);
    }
    
    @PostMapping("/add")
    public int addPost(@RequestBody Persona post) {  
        return postService.insert(post);
    }
    @PutMapping("/edit")
    public int editPost(@RequestBody Persona post) {  
        Persona pos = new Persona(post.getIdpersona(),post.getNombrepersona(),post.getApellidopersona(),post.getDnipersona(),post.getSexo(),post.getNacionalidad(),post.getDireccion(),post.getCorreo(),post.getTelefonopersona());
        return postService.update(post);
    }
    
}