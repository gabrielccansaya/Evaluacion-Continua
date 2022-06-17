/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.service;

import com.example.plan.model.Zapato;
import java.util.List;
/**
 *
 * @author user
 */
public interface ZapatoService {
            public List<Zapato> findAll();
    public Zapato findById(long id);
    public int deleteById(long id);
    public int insert(Zapato persona);
    public int update(Zapato persona);
}