package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Marca {

    public Marca() {
    }

    @JsonProperty("_id")    
    private String id;
    private String nombre;
    private String estado;
    private String fechaCreacion;
    private String fechaActualizacion;

    
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public Marca(String id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Marca(String nombre, String estado) {
        this.nombre = nombre;
        this.estado = estado;
    }
    
    @Override
    public 
        String toString() {
        return " Marca{\n" +
                                "  \"id\" : "+id+" \n "+
                                "  \"nombre\" : "+nombre+" \n "+
                                "  \"estado\" : "+estado+"\n" +
                                "  \"fechaCreacion\" : "+fechaCreacion+"\n" +
                                "  \"fechaActualizacion\" : "+fechaActualizacion+"\n" +
                                 "}";
        }
}