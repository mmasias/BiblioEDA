package v000;

import java.util.Arrays;
import java.util.List;

class Libro extends Documento {
    public Libro(String titulo, List<String> autores, int anioPublicacion, List<String> palabrasClave) {
        super(titulo, autores, anioPublicacion, "Libro", palabrasClave);
    }
}

