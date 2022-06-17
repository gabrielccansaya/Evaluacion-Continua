/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.model;

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
public class Sucursal {
    private int idsucursal;
    private String nombresucursal;
    private String direccionsucursal;
    private String horarioatencion;
    private boolean estado;
}
