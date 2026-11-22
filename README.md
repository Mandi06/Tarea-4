El minilibro tiene información sencilla y fácil de entender con el objetivo que los niños quienes son el público meta lo puedan entender 
luego de leer la información podrán pasar a una actividad donde podrán aplicar lo que aprendieron.

Para ejecutar el proyecto hay que descargar el zip y extraer todo, luego en Neatbeans buscar la opción que diga "Open proyect" y desde ahí
buscarlo, buscar el paquete que diga main y ejecutar la clase Principal.java y por ultimo tocar el botón run proyect, se abrirá una pantalla de una portada y darle inciar.

Pagina: Clase abstracta padre que define los atributos base título, número de página y contenido y el método abstracto mostrarContenido.
PaginaInformativa: Clase hija que hereda de Pagina para mostrar el contenido educativo de cada tema.
PaginaActiva: Clase hija que hereda de Pagina y tiene las preguntas de la actividad en un arreglo unidimensional.
GestionLibro: Administra las páginas del libro en un ArrayList, califica las respuestas usando arreglos unidimensionales y guarda hasta tres intentos en una matriz.
GUIPortada, GUIInfo y GUIActvidad: Ventanas gráficas (JFrame) del paquete vista que muestran la portada, las lecturas y la actividad interactiva.
ControladorPortada, ControladorInfo y ControladorActividad: Clases del paquete controlador que escuchan los botones y conectan las vistas con GestionLibro.
Principal: Arranca el programa.
