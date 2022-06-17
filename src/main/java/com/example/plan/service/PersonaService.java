/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.service;
import com.example.plan.model.Persona;
import java.util.List;
/**
 *
 * @author user
 */
public interface PersonaService {
            public List<Persona> findAll();
    public Persona findById(long id);
    public int deleteById(long id);
    public int insert(Persona persona);
    public int update(Persona persona);
}
