package v000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GestorDocumentos {
    private List<Documento> documentos;

    public GestorDocumentos() {
        this.documentos = new ArrayList<>();
    }

    public void agregarDocumento(Documento doc) {
        documentos.add(doc);
    }

    public void mostrarDocumentos() {
        documentos.forEach(documento -> System.out.println(documento));
    }

    public List<Documento> buscarPorAutor(String autor) {
        return documentos.stream()
                .filter(doc -> doc.getAutores().contains(autor))
                .collect(Collectors.toList());
    }

    public List<Documento> buscarPorPalabraClave(String palabraClave) {
        return documentos.stream()
                .filter(doc -> doc.getPalabrasClave().contains(palabraClave))
                .collect(Collectors.toList());
    }

    public boolean eliminarDocumento(String titulo) {
        return documentos.removeIf(doc -> doc.getTitulo().equals(titulo));
    }

    public List<Documento> buscarPorTitulo(String titulo) {
        return documentos.stream()
                .filter(doc -> doc.getTitulo().equalsIgnoreCase(titulo) && doc instanceof Libro)
                .collect(Collectors.toList());
    }

    public boolean actualizarLibroPorTitulo(String tituloAntiguo, Libro libroActualizado) {

        int libroIndex = -1;
        for (int i = 0; i < documentos.size(); i++) {
            Documento doc = documentos.get(i);
            if (doc instanceof Libro && doc.getTitulo().equalsIgnoreCase(tituloAntiguo)) {
                libroIndex = i;
                break;
            }
        }
    
        if (libroIndex != -1) {
            documentos.set(libroIndex, libroActualizado);
            return true; 
        }

        return false;
    }
    
    public static void main(String[] args) {
        
        GestorDocumentos gestor = new GestorDocumentos();

        List<String> autoresLibro1 = Arrays.asList("Autor 1", "Autor 2");
        List<String> palabrasClaveLibro1 = Arrays.asList("Java", "Programación");
        Libro libro1 = new Libro("Programando en Java", autoresLibro1, 2020, palabrasClaveLibro1);
        gestor.agregarDocumento(libro1);

        List<String> autoresLibro2 = Arrays.asList("Autor 3", "Autor 4");
        List<String> palabrasClaveLibro2 = Arrays.asList("Python", "Programación");
        Libro libro2 = new Libro("Aprendiendo Python", autoresLibro2, 2021, palabrasClaveLibro2);
        gestor.agregarDocumento(libro2);

        System.out.println("Documentos en el gestor:");
        gestor.mostrarDocumentos();

        System.out.println("\nBuscando libros del autor 'Autor 1':");
        List<Documento> resultados = gestor.buscarPorAutor("Autor 1");
        resultados.forEach(System.out::println);
    }    

}
