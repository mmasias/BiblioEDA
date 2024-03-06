package v000;

import java.util.Arrays;
import java.util.List;

class Libro extends Documento {
    public Libro(String titulo, List<String> autores, int anioPublicacion, List<String> palabrasClave) {
        super(titulo, autores, anioPublicacion, "Libro", palabrasClave);
    }
    public static void main(String[] args) {
        
        List<String> autores = Arrays.asList("Autor 1", "Autor 2");
        List<String> palabrasClave = Arrays.asList("PalabraClave1", "PalabraClave2");
        Libro libro = new Libro("Título del Libro", autores, 2021, palabrasClave);
        System.out.println(libro.toString());

    }    
}

