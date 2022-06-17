/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.model.Stock;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.plan.repository.StockRepository;
import com.example.plan.service.StockService;

/**
 *
 * @author 
 */
@Service
public class StockServiceImpl implements StockService{
    @Autowired
    private StockRepository batisRepository;

    @Override
    public List<Stock> findAll() {
        return batisRepository.findAll();
    }

    @Override
    public Stock findById(long id) {
        return batisRepository.findById(id);
    }

    @Override
    public int deleteById(long id) {
         return batisRepository.deleteById(id);
    }

    @Override
    public int insert(Stock actor) {
        return batisRepository.insert(actor);
    }

    @Override
    public int update(Stock actor) {
         return batisRepository.update(actor);
    }
}
