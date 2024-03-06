package v000;

import java.util.ArrayList;
import java.util.List;

public abstract class Documento {
    protected String titulo;
    protected List<String> autores;
    protected int anioPublicacion;
    protected String tipo;
    protected List<String> palabrasClave;

    public Documento(String titulo, List<String> autores, int anioPublicacion, String tipo, List<String> palabrasClave) {
        this.titulo = titulo;
        this.autores = new ArrayList<>(autores);
        this.anioPublicacion = anioPublicacion;
        this.tipo = tipo;
        this.palabrasClave = new ArrayList<>(palabrasClave);
    }

    public String getTitulo() {
        return titulo;
    }

    public List<String> getAutores() {
        return new ArrayList<>(autores);
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public List<String> getPalabrasClave() {
        return new ArrayList<>(palabrasClave); 
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutores(List<String> autores) {
        this.autores = new ArrayList<>(autores); 
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPalabrasClave(List<String> palabrasClave) {
        this.palabrasClave = new ArrayList<>(palabrasClave);
    }

    @Override
    public String toString() {
        return "Documento{" +
                "titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", anioPublicacion=" + anioPublicacion +
                ", tipo='" + tipo + '\'' +
                ", palabrasClave=" + palabrasClave +
                '}';
    }

}
