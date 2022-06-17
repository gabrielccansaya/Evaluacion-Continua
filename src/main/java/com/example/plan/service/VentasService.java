/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.service;

import com.example.plan.model.Ventas;
import java.util.List;

/**
 *
 * @author user
 */
public interface VentasService {
        public List<Ventas> findAll();
    public Ventas findById(long id);
    public int deleteById(long id);
    public int insert(Ventas ventas);
    public int update(Ventas ventas);
}