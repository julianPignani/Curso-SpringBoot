package com.pruebaDTO.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter @Setter
public class PropiedadDTO implements Serializable {
    private Long id_propiedad;
    private  String tipo;
    private String direccion;
    private Double valor_alquiler;
    private String nombre_inquilino;
    private String apellido_inquilino;
}
