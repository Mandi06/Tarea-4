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

/**
 *
 * @author acarr
 */
public class ControladorActividad implements ActionListener{

     private GUIActvividad vistaActividad;
    private GestionLibro modelo;
    private int[] respuestasUsuario = new int[3];
    private int preguntaActual = 0;

    public ControladorActividad(GUIActvividad vistaActividad, GestionLibro modelo) {
        this.vistaActividad = vistaActividad;
        this.modelo = modelo;
        this.vistaActividad.addActividadListener(this);

        Pagina act = modelo.consultarPagina(4);
        if (act != null) {
            vistaActividad.setTextoActividad(act.mostrarContenido());
        }
    }

    public void iniciar() {
        vistaActividad.setLocationRelativeTo(null);
        vistaActividad.setVisible(true);
    }

    private void responder(int opcion) {
        if (preguntaActual < 3) {
            respuestasUsuario[preguntaActual] = opcion;
            preguntaActual++;
            JOptionPane.showMessageDialog(vistaActividad, "Opción " + opcion + " guardada para la pregunta " + preguntaActual);

            if (preguntaActual == 3) {
                int aciertos = modelo.procesarIntento(respuestasUsuario);
                JOptionPane.showMessageDialog(vistaActividad, "¡Intento terminado! Acertaste " + aciertos + " de 3.");
            }
        } else {
            JOptionPane.showMessageDialog(vistaActividad, "Ya respondiste las 3 preguntas. Presiona 'Volver a Intentarlo'.");
        }
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
         String op = e.getActionCommand();

        switch (op) {
            case "OPCION1":
                responder(1);
                break;
            case "OPCION2":
                responder(2);
                break;
            case "OPCION3":
                responder(3);
                break;
            case "REINTENTAR":
                if (modelo.getNumeroIntentoActual() < 3) {
                    preguntaActual = 0;
                    respuestasUsuario = new int[3];
                    JOptionPane.showMessageDialog(vistaActividad, "Nuevo intento listo. Elige tu respuesta para la Pregunta 1");
                } else {
                    JOptionPane.showMessageDialog(vistaActividad, "Ya alcanzaste el máximo de 3 intentos.");
                }
                break;
            case "INTENTOS":
            case "RESULTADOS":
                JOptionPane.showMessageDialog(vistaActividad, modelo.obtenerHistorialCompleto());
                break;
            case "VOLVER_INFO":
                vistaActividad.dispose();
                GUIInfo vistaInfo = new GUIInfo();
                ControladorInfo controlInfo = new ControladorInfo(vistaInfo, modelo);
                controlInfo.iniciar();
                break;
        }
        
    }
    
    
    
}
