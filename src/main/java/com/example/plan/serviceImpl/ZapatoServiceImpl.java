/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.model.Zapato;
import com.example.plan.repository.ZapatoRepository;
import com.example.plan.service.ZapatoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ZapatoServiceImpl implements ZapatoService{
    @Autowired
    private ZapatoRepository batisRepository;

    @Override
    public List<Zapato> findAll() {
        return batisRepository.findAll();
    }

    @Override
    public Zapato findById(long id) {
        return batisRepository.findById(id);
    }

    @Override
    public int deleteById(long id) {
         return batisRepository.deleteById(id);
    }

    @Override
    public int insert(Zapato persona) {
        return batisRepository.insert(persona);
    }

    @Override
    public int update(Zapato persona) {
         return batisRepository.update(persona);
    }
}
