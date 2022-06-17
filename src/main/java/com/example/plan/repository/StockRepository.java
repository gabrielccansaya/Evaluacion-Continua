/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.repository;


import com.example.plan.model.Stock;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author 
 */
@Mapper
public interface StockRepository {
    @Select("select * from stock")
    public List<Stock> findAll();
    
    @Select("SELECT * FROM stock WHERE idproducto = #{id}")
    public Stock findById(long id);
    
    @Delete("DELETE FROM stock WHERE idproducto = #{id}")
    public int deleteById(long id);
    
    @Insert("INSERT INTO stock(marca, color, talla) " +
        " VALUES (#{marca}, #{color}, #{talla})")
    public int insert(Stock post);
    
    @Update("Update stock SET marca=#{marca}, color=#{color}, talla=#{talla} where idproducto=#{idproducto}")
    public int update(Stock post);
}
