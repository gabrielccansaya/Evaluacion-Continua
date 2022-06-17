/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.repository;

import com.example.plan.model.Zapato;
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
public interface ZapatoRepository {
    @Select("select * from zapato")
    public List<Zapato> findAll();
    
    @Select("SELECT * FROM zapato WHERE idzapato = #{id}")
    public Zapato findById(long id);
    
    @Delete("DELETE FROM zapato WHERE idzapato = #{id}")
    public int deleteById(long id);
    
    @Insert("INSERT INTO zapato(marca, talla, color, preciozapato, descripcion, stock, estado, idcategoria) " +
        " VALUES (#{marca}, #{ talla}, #{color}, #{preciozapato}, #{descripcion}, #{stock}, #{estado}, #{ idcategoria})")
    public int insert(Zapato post);
    
    @Update("Update zapato SET marca=#{marca}, talla=#{talla}, color=#{color}, preciozapato=#{preciozapato}, descripcion=#{descripcion}, stock=#{stock}, estado=#{estado}, idcategoria=#{idcategoria} where idzapato=#{idzapato}")
    public int update(Zapato post);
}