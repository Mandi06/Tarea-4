/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Modelo.GestionLibro;
import Modelo.Pagina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.GUIActvividad;
import vista.GUIInfo;
import vista.GUIPortada;

/**
 *
 * @author acarr
 */
public class ControladorPortada implements ActionListener{

    private GUIPortada vistaPortada;
    private GestionLibro modelo;

    public ControladorPortada(GUIPortada vistaPortada, GestionLibro modelo) {
        this.vistaPortada = vistaPortada;
        this.modelo = modelo;
        this.vistaPortada.addMenuListener(this);
    }

    public void iniciar() {
        vistaPortada.setLocationRelativeTo(null);
        vistaPortada.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String op = e.getActionCommand();

        switch (op) {
            case "INICIO":
                vistaPortada.dispose();
                GUIInfo vistaInfo = new GUIInfo();
                ControladorInfo controlInfo = new ControladorInfo(vistaInfo, modelo);
                controlInfo.iniciar();
                break;

            case "SALIR":
                vistaPortada.dispose();
                System.exit(0);
                break;
        }
        
    }
    
    
    
}
