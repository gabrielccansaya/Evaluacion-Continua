/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.repository;

import com.example.plan.model.Persona;
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
public interface PersonaRepository {
    @Select("select * from persona")
    public List<Persona> findAll();
    
    @Select("SELECT * FROM persona WHERE idpersona = #{id}")
    public Persona findById(long id);
    
    @Delete("DELETE FROM persona WHERE idpersona = #{id}")
    public int deleteById(long id);
    
    @Insert("INSERT INTO persona(nombrepersona, apellidopersona, dnipersona, sexo, nacionalidad, direccion, correo, telefonopersona) " +
        " VALUES (#{nombrepersona}, #{apellidopersona}, #{dnipersona}, #{sexo}, #{nacionalidad}, #{direccion}, #{correo}, #{telefonopersona})")
    public int insert(Persona post);
    
    @Update("Update persona SET nombrepersona=#{nombrepersona}, apellidopersona=#{apellidopersona}, dnipersona=#{dnipersona}, sexo=#{sexo}, nacionalidad=#{nacionalidad}, direccion=#{direccion}, correo=#{correo}, telefonopersona=#{telefonopersona} where idpersona=#{idpersona}")
    public int update(Persona post);
}