
package com.mycompany.inventariojava;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.Scanner;


import dto.Marca;
import dto.Usuario;





public class InventarioJava {
    
    private static void serializarUsuario() throws JsonProcessingException{
        
        Usuario usuario= new Usuario(null, "Andres", "andres@email.com", "Activo");
                usuario.setNombre("Andres");
                usuario.setEmail("andres@email.com");
                usuario.setEstado("ACTIVO");         
                
        System.out.println("Serializar:");      
        System.out.println("objeto:");
        System.out.println(usuario);
         
        ObjectMapper objectMapper =new ObjectMapper();
        String jsonUsuario = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(usuario);
        
        System.out.println("-");
        System.out.println("json:");
        System.out.println(jsonUsuario);
    }
    
    private static void desSerializarUsuario() throws JsonProcessingException{
        String jsonUsuario="{\n" +
                                            "  \"nombre\" : \"Pedro\",\n" +
                                            "  \"email\" : \"Pedro@email.com\",\n" +
                                            "  \"estado\" : \"ACTIVO\"\n" +
                                         "}";
        System.out.println("Deserializar:");
        System.out.println("json:");
        System.out.println(jsonUsuario);
        
        ObjectMapper objectMapper =new ObjectMapper();
        Usuario usuario = objectMapper.readValue(jsonUsuario, new TypeReference<Usuario>(){});
        
        System.out.println("-");
        System.out.println("objeto:");
        System.out.println(usuario);
     }
    
    private static final String URLUsuario="http://localhost:4000/usuario/ ";

    private static void getAllUsuarios(RestTemplate restTemplate) {
        ResponseEntity<Usuario[]> response = restTemplate.getForEntity(URLUsuario, Usuario[].class);

        System.out.println();
        System.out.println("GET Body (object list): ");
        Arrays.asList(response.getBody()).forEach(info -> System.out.println("--> " + info));
    }
    
        private static void getOneUsuario(RestTemplate restTemplate) {
            String id="63574614bf32df14b2faf911";
        ResponseEntity<Usuario> response = restTemplate.getForEntity(URLUsuario + "{id}", Usuario.class, id);

        System.out.println();
        System.out.println("GET Body (object): " + response.getBody());
    }
        
        private static void postOneUsuario (RestTemplate restTemplate){
            Usuario nuevoUsuario= new Usuario("william","william@email.com","Activo");
                
                 ResponseEntity<Usuario> response = restTemplate.postForEntity(URLUsuario,nuevoUsuario, Usuario.class);
              
                System.out.println();
                System.out.println("POST executed");
                System.out.println("POST StatusCode = " + response.getStatusCode());
            
        }
        
        private static void putOneUsuario(RestTemplate restTemplate) {
            String id="63583e9b0399c1564f836bb8";
            
        Usuario actualizarUsuario= new Usuario( id,"will","will@email.com","Activo");
        restTemplate.put(URLUsuario + "{id}", actualizarUsuario, id);
        
        System.out.println();
        System.out.println("PUT executed");

         }
        
        private static void deleteOneUsuario(RestTemplate restTemplate) {
            String id="63574614bf32df14b2faf911";
            
        restTemplate.delete(URLUsuario + "{id}", id);
        
        System.out.println();
        System.out.println("DELETE executed");

         }

   //=======================================================================
    
        private static final String URLMarca="http://localhost:4000/marca/ ";
        
    private static void serializarMarca() throws JsonProcessingException{
        
        Marca marca= new Marca();
                marca.setNombre("Canon");
                marca.setEstado("ACTIVO");         
                
        System.out.println("Serializar:");      
        System.out.println("objeto:");
        System.out.println(marca);
         
        ObjectMapper objectMapper =new ObjectMapper();
        String jsonMarca = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(marca);
        
        System.out.println("-");
        System.out.println("json:");
        System.out.println(jsonMarca);
         
    }
    
    private static void desSerializarMarca() throws JsonProcessingException{
        String jsonMarca="{\n" +
                                            "  \"nombre\" : \"Huawei\",\n" +
                                            "  \"estado\" : \"ACTIVO\"\n" +
                                         "}";
        System.out.println("Deserializar:");
        System.out.println("json:");
        System.out.println(jsonMarca);
        
        ObjectMapper objectMapper =new ObjectMapper();
        Marca marca = objectMapper.readValue(jsonMarca, new TypeReference<Marca>(){});
        
        System.out.println("-");
        System.out.println("objeto:");
        System.out.println(marca);
     
     }
    
        private static void getAllMarcas(RestTemplate restTemplate) {
        ResponseEntity<Marca[]> response = restTemplate.getForEntity(URLMarca, Marca[].class);

        System.out.println();
        System.out.println("GET Body (object list): ");
        Arrays.asList(response.getBody()).forEach(info -> System.out.println("--> " + info));
    }
    
        private static void getOneMarca(RestTemplate restTemplate) {
            String id="632d3545a7dacadb625064e3";
        ResponseEntity<Marca> response = restTemplate.getForEntity(URLMarca + "{id}", Marca.class, id);

        System.out.println();
        System.out.println("GET Body (object): " + response.getBody());
    }
        
        private static void postOneMarca (RestTemplate restTemplate){
            Marca nuevoMarca= new Marca("vaio","Activo");
                
                 ResponseEntity<Marca> response = restTemplate.postForEntity(URLMarca,nuevoMarca, Marca.class);
              
                System.out.println();
                System.out.println("POST executed");
                System.out.println("POST StatusCode = " + response.getStatusCode());
            
        }
        
        private static void putOneMarca(RestTemplate restTemplate) {
            String id="632d3545a7dacadb625064e3";
            
        Marca actualizarMarca= new Marca( id,"willhem","Activo");
        restTemplate.put(URLMarca + "{id}", actualizarMarca, id);
        
        System.out.println();
        System.out.println("PUT executed");

         }
        
        private static void deleteOneMarca(RestTemplate restTemplate) {
            String id="632d3545a7dacadb625064e3";
            
        restTemplate.delete(URLMarca + "{id}", id);
        
        System.out.println();
        System.out.println("DELETE executed");

         }
    
    
    
  //=======================================================================
        public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        
        
        
        //menu       
        Scanner sn= new Scanner(System.in);        
        boolean SalirA=false;
        boolean SalirB=false;        
        int OpcionA;
        int OpcionB;
        
        while(!SalirA){
            SalirB=false;
            System.out.println("MENU");
                        System.out.println("------------------------");
            System.out.println("1. USUARIOS");
            System.out.println("2. MARCAS");
            System.out.println("3. SALIR");
            System.out.println("");
            System.out.println("Elige una opcion");
            OpcionA=sn.nextInt();
            
            switch(OpcionA){
                case 1 -> {
                    while(!SalirB){                        
                        System.out.println("USUARIOS");
                        System.out.println("------------------------");
                        System.out.println("1. LISTAR TODOS");
                        System.out.println("2. LISTAR UNO");
                        System.out.println("3. CREAR");
                        System.out.println("4. EDITAR");
                        System.out.println("5. ELIMINAR");
                        System.out.println("6. SALIR");
                        System.out.println("");
                        System.out.println("Elige una opcion");
                        OpcionB=sn.nextInt();                        
                        switch(OpcionB){
                            case 1 -> {
                                getAllUsuarios(restTemplate);
                            }
                            
                            case 2 -> {
                                getOneUsuario(restTemplate);
                            }
                            
                            case 3 -> {
                                postOneUsuario(restTemplate);    
                            }
                            
                            case 4 -> {
                                putOneUsuario(restTemplate);
                            }
                            
                            case 5 -> {
                                deleteOneUsuario(restTemplate);
                            }
                            
                            case 6 -> {
                                SalirB=true;
                            }
                            default -> { System.out.println("Elige entre las opciones del menu");
                            }
                        }                            
                    }                    
                }
                    
                case 2 -> {
                    while(!SalirB){                        
                        System.out.println("MARCAS");
                        System.out.println("------------------------");
                        System.out.println("1. LISTAR TODOS");
                        System.out.println("2. LISTAR UNO");
                        System.out.println("3. CREAR");
                        System.out.println("4. EDITAR");
                        System.out.println("5. ELIMINAR");
                        System.out.println("6. SALIR");
                        System.out.println("");
                        System.out.println("Elige una opcion");
                        OpcionB=sn.nextInt();                        
                        switch(OpcionB){
                            case 1 -> {
                                getAllMarcas(restTemplate);
                            }
                            
                            case 2 -> {
                                getOneMarca(restTemplate);
                            }
                            
                            case 3 -> {
                                postOneMarca(restTemplate);    
                            }
                            
                            case 4 -> {
                                putOneMarca(restTemplate);
                            }
                            
                            case 5 -> {
                                deleteOneMarca(restTemplate);
                            }
                            
                            case 6 -> {
                                SalirB=true;
                            }
                            default -> { System.out.println("Elige entre las opciones del menu");
                            }
                            
                        }                            
                    }            
                }
                    
               case 3 -> {
                   SalirA=true;
                }
                default -> { System.out.println("Elige entre las opciones del menu");
                }
            }
        }  
    }
}
