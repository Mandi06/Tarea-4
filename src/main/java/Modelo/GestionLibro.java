/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author acarr
 */
public class GestionLibro {
    
     
    private ArrayList<Pagina> listaPaginas;

    // unidimensionales
    private int[] claveCorrecta;
    private int[] respuestasNino;

    //
    private int[][] registroIntentos;
    private int numeroIntentoActual;

    public GestionLibro() {
        listaPaginas = new ArrayList<>();
        claveCorrecta = new int[]{2, 1, 3};
        respuestasNino = new int[3];
        registroIntentos = new int[3][3];
        numeroIntentoActual = 0;

        cargarContenidoLibro();
    }

    
    private void cargarContenidoLibro() {
        PaginaInformativa portada = new PaginaInformativa("Aventuras en el Mundo del Código", 0, "Tema: Programación Básica para Niños\nAutora: Amanda\nCurso: TM-2100");
        PaginaInformativa pagina1 = new PaginaInformativa("Qué es un Algoritmo?", 1, "Un algoritmo es como una receta de cocina o los pasos para lavarte los dientes.\nSon instrucciones ordenadas paso a paso que le damos a una computadora para resolver un problema");
        PaginaInformativa pagina2 = new PaginaInformativa("Qué son las Variables?", 2, "Imagina una cajit con una etiqueta donde puedes guardar tus juguetes o puntos de un juego.\nEn programación una variable es ese espacio donde guardamos datos que pueden cambiar");
        PaginaInformativa pagina3 = new PaginaInformativa("Qué son los Ciclos o Bucles?", 3, "Cuando saltas la cuerda 5 veces seguidas, estás repitiendo una acción.\nUn ciclo sirve para que la computadora repita una tarea muchas veces sin tener que escribirla de nuevo");

        String[] preguntasNinos = {
            "A que se parece un algoritmo?\n   1) A un dibujo  2) A una receta paso a paso  3) A un teclado",
            "Que es una variable en programación?\n   1) Una cajita para guardar datos  2) Un virus  3) Una pantalla",
            "Para qué sirve un ciclo o bucle?\n   1) Para apagar la compu  2) Para borrar todo  3) Para repetir una acción"
        };

        PaginaActiva pagina4 = new PaginaActiva("¡Pon a prueba lo aprendido!", 4, "Elige la opción correcta (1, 2 o 3) para cada pregunta:", preguntasNinos);

        listaPaginas.add(portada);
        listaPaginas.add(pagina1);
        listaPaginas.add(pagina2);
        listaPaginas.add(pagina3);
        listaPaginas.add(pagina4);
    }

    //metodos

    public void agregarPagina(Pagina pagina) {
        listaPaginas.add(pagina);
    }

    // Busca una página por su número de posición en la lista con un try carch
    public Pagina consultarPagina(int posicion) {
        try {
            return listaPaginas.get(posicion);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Esa página no existe en el libro.");
            return null;
        }
    }
    
      // Recorre todas las páginas para mostrar un indice
    public String recorrerPaginas() {
        String indice = "Índice del Libro:\n";
        for (int i = 0; i < listaPaginas.size(); i++) {
            indice += "Página " + listaPaginas.get(i).getNumeroPagina() + ": " + listaPaginas.get(i).getTitulo() + "\n";
        }
        return indice;
    }
    
     // Cuantas p[aginas hay
    public int obtenerCantidadPaginas() {
        return listaPaginas.size();
    }
    

    // Guarda las 3 respuestas del niño cuenta las buenas y registra el intento en la tabla
    public int procesarIntento(int[] respuestasSeleccionadas) {
        this.respuestasNino = respuestasSeleccionadas;

        int aciertos = 0;
        for (int i = 0; i < claveCorrecta.length; i++) {
            if (respuestasNino[i] == claveCorrecta[i]) {
                aciertos++;
            }
        }
         try {
            for (int col = 0; col < 3; col++) {
                registroIntentos[numeroIntentoActual][col] = respuestasNino[col];
            }
            numeroIntentoActual++;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ya alcanzaste el límite máximo de 3 intentos.");
        }

        return aciertos;
    }

     // Consulta un intento específico 1, 2 o 3 de la tabla
    public String consultarIntento(int intentoBuscar) {
        try {
            int fila = intentoBuscar - 1;
            if (fila < 0 || fila >= numeroIntentoActual) {
                JOptionPane.showMessageDialog(null, "Ese intento aún no se ha realizado.");
                return "";
            }

            int aciertos = 0;
            String detalle = "Intento #" + intentoBuscar + " -> Respuestas: ";
            for (int i = 0; i < 3; i++) {
                int dato = registroIntentos[fila][i];
                detalle += dato + " ";
                if (dato == claveCorrecta[i]) {
                    aciertos++;
                }
            }
            detalle += " | Aciertos: " + aciertos + " de 3";
            return detalle;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Número de intento fuera de rango.");
            return "";
        }
    }

    // mostrara los intentos si el usurio le da a ver intentos
    public String obtenerHistorialCompleto() {
        if (numeroIntentoActual == 0) {
            return "Todavía no has realizado ningún intento.";
        }
        String reporte = "--- RESULTADOS REGISTRADOS ---\n";
        for (int i = 1; i <= numeroIntentoActual; i++) {
            reporte += consultarIntento(i) + "\n";
        }
        return reporte;
    }

    public int getNumeroIntentoActual() {
        return numeroIntentoActual;
    }
    
    
}

    
    
