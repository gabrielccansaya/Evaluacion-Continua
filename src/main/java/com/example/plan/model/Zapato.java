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
public class Zapato {
    private int idzapato;
    private String marca;
    private String talla;
    private String color;
    private Float preciozapato;
    private String descripcion;
    private int stock;
    private String estado;
    private int idcategoria;
}
