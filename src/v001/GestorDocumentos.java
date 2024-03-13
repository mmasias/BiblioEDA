package v001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorDocumentos {
    private Map<Integer, Libro> libros = new HashMap<>();
    private Map<Integer, Autor> autores = new HashMap<>();
    private List<LibroAutor> relacionesLibroAutor = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        libros.put(libro.getId(), libro);
    }

    public void agregarAutor(Autor autor) {
        autores.put(autor.getId(), autor);
    }

    public void relacionarLibroAutor(int libroId, int autorId) {
        if (libros.containsKey(libroId) && autores.containsKey(autorId)) {
            relacionesLibroAutor.add(new LibroAutor(libroId, autorId));
        } else {
            System.out.println("Libro o Autor no encontrado.");
        }
    }

    // Métodos para buscar libros por autor, etc.
}
