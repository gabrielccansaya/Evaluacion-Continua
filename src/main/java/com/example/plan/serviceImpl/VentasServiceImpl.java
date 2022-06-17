/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.model.Ventas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.example.plan.repository.VentasRepository;

import com.example.plan.service.VentasService;

/**
 *
 * @author 
 */
@Service
public class VentasServiceImpl implements VentasService{
    @Autowired
    private VentasRepository batisRepository;

    @Override
    public List<Ventas> findAll() {
        return batisRepository.findAll();
    }

    @Override
    public Ventas findById(long id) {
        return batisRepository.findById(id);
    }

    @Override
    public int deleteById(long id) {
         return batisRepository.deleteById(id);
    }

    @Override
    public int insert(Ventas actor) {
        return batisRepository.insert(actor);
    }

    @Override
    public int update(Ventas actor) {
         return batisRepository.update(actor);
    }
}
