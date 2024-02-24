package com.prueba.prueba_POST.Controller;


import com.prueba.prueba_POST.Customer;
import com.prueba.prueba_POST.Plate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
@PostMapping("/customer")
    public void create_customer(@RequestBody Customer cli){

    System.out.println("El cliente se creó correctamente");
    System.out.println("Name: " + cli.getName() +
            " LastName: "+ cli.getLastname());

    }

    //Ahora utilizamos el @GETMapping y el @ResponseBody para devolver un JSON

    @GetMapping("/customer/collect")
    @ResponseBody
    public List<Customer> collectCustomers(){

        List<Customer> listCustomers = new ArrayList<Customer>();
        listCustomers.add(new Customer(1L,"Julián","Pignani"));
        listCustomers.add(new Customer(2L,"Lionel", "Messi"));
        listCustomers.add(new Customer(3L,"Cristiano", "Ronaldo"));

        return listCustomers; //Devolemos la lista de clientes mediante el ResponseBody
    }

    //Ahora vamos a utilizar una clase especial, ResponseEntity para devolver datos.
    @GetMapping("/pruebaresponse")
    ResponseEntity<String> traerRespuesta(){
        return new ResponseEntity<>("Esto es un mensaje Response Entity", HttpStatus.OK);
    }

 //Ejercicio práctico para poner en practica lo aprendido.
    @GetMapping("/plates/{plateNumber}")
    public Plate getPlateByNumber(@PathVariable int plateNumber){
        //Al no tener una base de datos creamos una lista para mantener los datos.
        List<Plate> plates = new ArrayList<Plate>();

        plates.add(new Plate(1,"Carne asada",6400,"Vacio a la parrilla"));
        plates.add(new Plate(2,"Pollo asado",8400,"Pollo a la parrilla"));
        plates.add(new Plate(3,"Fideos",3400,"Con salsa a elegir"));
        plates.add(new Plate(4,"Ensalada",2400,"Armada a gusto"));
        plates.add(new Plate(5,"Menú diario",5400,"Varia según el dia."));

        //Buscamos el plato en la lista por el número de plato que llega por parametro
        for (Plate plate : plates){
            if(plate.getPlateNumber() == plateNumber ){
                return plate;
            }
        }
        //Si no se encuentra el plato, puede devolver null o lanzar una excepción
        return null;
    }

  }

