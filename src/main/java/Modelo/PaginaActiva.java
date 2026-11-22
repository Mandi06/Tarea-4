/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author acarr
 */
public class PaginaActiva extends Pagina {

   private String[] listaPreguntas;
   
   public PaginaActiva(String titulo, int numeroPagina, String contenido, String[] listaPreguntas){
       super(titulo, numeroPagina, contenido);
       this.listaPreguntas = listaPreguntas;
   }
   
   public String[] getListaPreguntas(){
       return listaPreguntas;
   }
   
   public void setListaPreguntas(String[] listaPreguntas){
       this.listaPreguntas = listaPreguntas;
   }
   
    @Override
    public String mostrarContenido() {
        String texto = "--- Actividad de preguntas ---"
                + "\nTitulo: " +getTitulo()
                + "\nPagina: " +getNumeroPagina()
                + "\nContenido: " +getContenido();
        
        for(int i = 0; i < listaPreguntas.length; i++){
            texto += "\n\nPregunta " +(i+1)+ ": " +listaPreguntas[i];
        }
          return texto;      
    }
}
