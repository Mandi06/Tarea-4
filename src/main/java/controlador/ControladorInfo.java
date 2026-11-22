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
public class ControladorInfo implements ActionListener {

    private GUIInfo vistaInfo;
    private GestionLibro modelo;
    private int paginaActual = 1;

    public ControladorInfo(GUIInfo vistaInfo, GestionLibro modelo) {
        this.vistaInfo = vistaInfo;
        this.modelo = modelo;
        this.vistaInfo.addInfoListener(this);
        actualizarPagina();
    }

    public void iniciar() {
        vistaInfo.setLocationRelativeTo(null);
        vistaInfo.setVisible(true);
    }

    private void actualizarPagina() {
        Pagina p = modelo.consultarPagina(paginaActual);
        if (p != null) {
            vistaInfo.setTextoInfo(p.mostrarContenido());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String op = e.getActionCommand();

        switch (op) {
            case "SIGUIENTE":
                if (paginaActual < 3) {
                    paginaActual++;
                    actualizarPagina();
                } else {
                    JOptionPane.showMessageDialog(vistaInfo, "Ya leíste las 3 páginas. Presiona 'Ir a la Actividad'.");
                }
                break;

            case "ANTERIOR":
                if (paginaActual > 1) {
                    paginaActual--;
                    actualizarPagina();
                } else {
                    JOptionPane.showMessageDialog(vistaInfo, "Estás en la primera página.");
                }
                break;

            case "ACTIVIDAD":
                vistaInfo.dispose();
                GUIActvividad vistaAct = new GUIActvividad();
                ControladorActividad controlAct = new ControladorActividad(vistaAct, modelo);
                controlAct.iniciar();
                break;

            case "VOLVER_MENU":
                vistaInfo.dispose();
                GUIPortada vistaPortada = new GUIPortada();
                ControladorPortada controlPortada = new ControladorPortada(vistaPortada, modelo);
                controlPortada.iniciar();
                break;
        }
    }

}
