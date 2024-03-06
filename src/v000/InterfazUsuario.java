package v000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InterfazUsuario {
    private final GestorDocumentos gestorDocumentos;
    private final Scanner scanner;

    public InterfazUsuario() {
        this.gestorDocumentos = new GestorDocumentos();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("\nBiblioteca Digital");
            System.out.println("1. Gestionar Libros");
            System.out.println("2. Buscar Libros");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    gestionarLibros();
                    break;
                case 2:
                    buscarLibros();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }

    private void gestionarLibros() {
        while (true) {
            System.out.println("\nGestión de Libros");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Mostrar Todos los Libros");
            System.out.println("3. Buscar y Mostrar Libro por Título");
            System.out.println("4. Actualizar Libro por Título");
            System.out.println("5. Eliminar Libro por Título");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    mostrarTodosLosLibros();
                    break;
                case 3:
                    mostrarLibroPorTitulo();
                    break;
                case 4:
                    actualizarLibroPorTitulo();
                    break;
                case 5:
                    eliminarLibroPorTitulo();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }

    private void agregarLibro() {
        System.out.print("Ingrese título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese año de publicación: ");
        int anio = scanner.nextInt();
        scanner.nextLine();
        List<String> autores = new ArrayList<>();
        System.out.print("Ingrese autores (separados por coma): ");
        String[] autoresArray = scanner.nextLine().split(",");
        for (String autor : autoresArray) {
            autores.add(autor.trim());
        }
        List<String> palabrasClave = new ArrayList<>();
        System.out.print("Ingrese palabras clave (separadas por coma): ");
        String[] palabrasClaveArray = scanner.nextLine().split(",");
        for (String palabra : palabrasClaveArray) {
            palabrasClave.add(palabra.trim());
        }

        Libro nuevoLibro = new Libro(titulo, autores, anio, palabrasClave);
        gestorDocumentos.agregarDocumento(nuevoLibro);

        System.out.println("Libro agregado exitosamente.");
    }

    private void mostrarTodosLosLibros() {
        System.out.println("\nLista de todos los libros:");
        gestorDocumentos.mostrarDocumentos();
    }

    private void mostrarLibroPorTitulo() {
        System.out.print("Ingrese el título del libro a buscar: ");
        String titulo = scanner.nextLine();
    
        List<Documento> resultados = gestorDocumentos.buscarPorTitulo(titulo);
    
        if (!resultados.isEmpty()) {
            System.out.println("Libro(s) encontrado(s):");
            resultados.forEach(System.out::println);
        } else {
            System.out.println("No se encontró un libro con ese título.");
        }
    }

private void actualizarLibroPorTitulo() {
    System.out.print("Ingrese el título del libro a actualizar: ");
    String tituloAntiguo = scanner.nextLine();


    System.out.print("Ingrese el nuevo título del libro: ");
    String nuevoTitulo = scanner.nextLine();
    System.out.print("Ingrese el nuevo año de publicación: ");
    int nuevoAnio = scanner.nextInt();
    scanner.nextLine(); 
    System.out.print("Ingrese los nuevos autores (separados por coma): ");
    List<String> nuevosAutores = Arrays.asList(scanner.nextLine().split(","));
    System.out.print("Ingrese las nuevas palabras clave (separadas por coma): ");
    List<String> nuevasPalabrasClave = Arrays.asList(scanner.nextLine().split(","));

    Libro libroActualizado = new Libro(nuevoTitulo, nuevosAutores, nuevoAnio, nuevasPalabrasClave);

    if (gestorDocumentos.actualizarLibroPorTitulo(tituloAntiguo, libroActualizado)) {
        System.out.println("Libro actualizado exitosamente.");
    } else {
        System.out.println("No se encontró un libro con el título proporcionado para actualizar.");
    }
}


    private void eliminarLibroPorTitulo() {
        System.out.print("Ingrese el título del libro a eliminar: ");
        String titulo = scanner.nextLine();
        if (gestorDocumentos.eliminarDocumento(titulo)) {
            System.out.println("Libro eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un libro con ese título.");
        }
    }

    private void buscarLibros() {
        System.out.println("\nBuscar Libros");
        System.out.println("1. Por Autor");
        System.out.println("2. Por Palabra Clave");
        System.out.print("Seleccione una opción de búsqueda: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcion) {
            case 1:
                buscarPorAutor();
                break;
            case 2:
                buscarPorPalabraClave();
                break;
            default:
                System.out.println("Opción no válida, por favor intente de nuevo.");
        }
    }

    private void buscarPorAutor() {
        System.out.print("Ingrese el nombre del autor: ");
        String autor = scanner.nextLine();
        List<Documento> resultados = gestorDocumentos.buscarPorAutor(autor);
        resultados.forEach(System.out::println);
    }

    private void buscarPorPalabraClave() {
        System.out.print("Ingrese la palabra clave: ");
        String palabraClave = scanner.nextLine();
        List<Documento> resultados = gestorDocumentos.buscarPorPalabraClave(palabraClave);
        resultados.forEach(System.out::println);
    }

    public static void main(String[] args) {
        InterfazUsuario ui = new InterfazUsuario();
        ui.mostrarMenuPrincipal();
    }
}
