package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Usuario {

    public Usuario() {
    }
    
    @JsonProperty("_id")    
    private String id;
    private String nombre;
    private String email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Usuario(String nombre, String email, String estado) {
        this.nombre = nombre;
        this.email = email;
        this.estado = estado;
    }    

    public Usuario(String _id, String nombre, String email, String estado) {
        this.id = _id;
        this.nombre = nombre;
        this.email = email;
        this.estado = estado;
    }

    @Override
    public 
        String toString() {
        return " usuario{\n" +
                                "  \"id\" : "+id+" \n "+
                                "  \"nombre\" : "+nombre+" \n "+
                                "  \"email\" : "+email+",\n" +
                                "  \"estado\" : "+estado+"\n" +
                                "  \"fechaCreacion\" : "+fechaCreacion+"\n" +
                                "  \"fechaActualizacion\" : "+fechaActualizacion+"\n" +
                                 "}";
    }
}
