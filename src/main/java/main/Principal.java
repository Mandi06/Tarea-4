/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import Modelo.GestionLibro;
import controlador.ControladorPortada;
import vista.GUIPortada;


/**
 *
 * @author acarr
 */
public class Principal {

    public static void main(String[] args) {
        
        
        GestionLibro modelo = new GestionLibro();
        GUIPortada portada = new GUIPortada();

        ControladorPortada control = new ControladorPortada(portada, modelo);
        control.iniciar();
    }
        
    }

