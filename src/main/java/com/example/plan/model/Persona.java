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
public class Persona {
    private int idpersona;
    private String nombrepersona;
    private String apellidopersona;
    private String dnipersona;
    private String sexo;
    private String nacionalidad;
    private String direccion;
    private String correo;
    private String telefonopersona;
    
}
