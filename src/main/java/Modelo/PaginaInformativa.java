/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author acarr
 */
public class PaginaInformativa extends Pagina {

    public PaginaInformativa(String titulo, int numeroPagina, String contenido){
        super (titulo, numeroPagina, contenido);
    }
    
    //el metodo abstracto va a servir para mostrar la informcaion heredada
    //de la clase padre y mostrarla
    @Override
    public String mostrarContenido() {
        
        return "---Información---" 
                + "\nTitulo: " +getTitulo()
                + "\nPagina: " +getNumeroPagina()
                + "\nContenido: " +getContenido();
        
    }
   
   
    
}
