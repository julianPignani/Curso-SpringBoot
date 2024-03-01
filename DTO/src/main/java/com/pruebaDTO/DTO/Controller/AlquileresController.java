package com.pruebaDTO.DTO.Controller;

import com.pruebaDTO.DTO.Inquilino;
import com.pruebaDTO.DTO.Propiedad;
import com.pruebaDTO.DTO.PropiedadDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlquileresController {

    @GetMapping("/propiedad/{id}")
        @ResponseBody
        public PropiedadDTO devolverPropiedad(@PathVariable Long id){

        //supongamos que obtenemos una propiedad por su id y su inquilino
        //desde una base de datos
        Inquilino inquilino = new Inquilino(1L,"39614001","Julián","Pignani","Estudiante");
        Propiedad propiedad = new Propiedad(2L,"Casa de 2 plantas","Italia 598",25.0,110000.0);

        //Unificamos dentro del DTO los datos que necesitamos de inquilino y prop en un solo objeto
        PropiedadDTO propDTO = new PropiedadDTO();
        propDTO.setId_propiedad(propiedad.getId_propiedad());
        propDTO.setTipo(propiedad.getTipo_propiedad());
        propDTO.setDireccion(propiedad.getDireccion());
        propDTO.setValor_alquiler(propiedad.getValor_alquiler());
        propDTO.setNombre_inquilino(inquilino.getNombre());
        propDTO.setApellido_inquilino(inquilino.getApellido());

        return propDTO;
    }
}
