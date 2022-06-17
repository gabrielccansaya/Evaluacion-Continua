/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author user
 */
    @Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ventas {
    private int idventa;
    private Date fecha;
    private int idusuario;
    private int idcliente;
    private int idsucursal;
    private String tipocomprobante;
    private String seriecomprobante;
    private String numerocomprobante;
}
