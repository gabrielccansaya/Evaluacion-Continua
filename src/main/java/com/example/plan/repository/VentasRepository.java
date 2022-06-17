/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.repository;

import com.example.plan.model.Ventas;
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
public interface VentasRepository {
    @Select("select * from venta")
    public List<Ventas> findAll();
    
    @Select("SELECT * FROM venta WHERE idventa = #{id}")
    public Ventas findById(long id);
    
    @Delete("DELETE FROM venta WHERE idventa = #{id}")
    public int deleteById(long id);
    
    @Insert("INSERT INTO venta(fecha,idusuario,idcliente,idsucursal,tipocomprobante,seriecomprobante,numerocomprobante) " +
        " VALUES (#{fecha}, #{idusuario}, #{idcliente},#{idsucursal},#{tipocomprobante},#{seriecomprobante},#{numerocomprobante})")
    public int insert(Ventas post);
    
    @Update("Update venta SET fecha=#{fecha}, idusuario=#{idusuario}, idcliente=#{idcliente} , idsucursal=#{idsucursal}, tipocomprobante=#{tipocomprobante} , seriecomprobante=#{seriecomprobante} , numerocomprobante=#{numerocomprobante}  where idventa=#{idventa}")
    public int update(Ventas post);
}
