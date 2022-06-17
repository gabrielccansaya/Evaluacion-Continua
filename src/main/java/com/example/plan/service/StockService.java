/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.service;

import com.example.plan.model.Stock;
import java.util.List;

/**
 *
 * @author user
 */
public interface StockService {
        public List<Stock> findAll();
    public Stock findById(long id);
    public int deleteById(long id);
    public int insert(Stock ventas);
    public int update(Stock ventas);
}
