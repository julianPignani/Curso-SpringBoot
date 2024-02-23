package com.cursospring.prueba.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Anotacion para que spring sepa que esta será nuesta clase controller
@RestController
public class HelloController {

    //En GetMapping le vamos a pasar la ruta para buscar los datos
    //Mapping con un parámetro
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name){
        return "Hello Spring boot, I'm " + name ;
    }

    //Mapping con 3 parámetros
    @GetMapping("/hello/{name}/{age}/{profession}")
    public String sayHello(@PathVariable String name,
                           @PathVariable Integer age,
                           @PathVariable String profession){
        return "Hello, My name is " + name + " " +
                "Age: " + age +
                " Profession: " + profession;
    }
    //RequestParam no se le pasan los datos por url, se usa para no mostrar información
    //Tiene el mismo funcionamiento que GetMapping
    @GetMapping("/hola")
    public String seyHello(@RequestParam String name,
                           @RequestParam Integer age,
                           @RequestParam String profession){

        return "Hello World. My name is " + name + ", Age: " + age + " and my profession is " + profession;
    }
    //Función que devuelve una suma para practicar GetMapping
    @GetMapping("/sum/{number1}/{number2}")
    public Integer sum(@PathVariable Integer number1,
                       @PathVariable Integer number2){
        return number1 + number2;
    }
    //Función que calcula el IMC de una persona
    @GetMapping("/imc")
    public String imc(@RequestParam float weigth,
                      @RequestParam float heigth){

        float imc = weigth / (heigth * heigth);

        if( imc < 18.5){
            return  imc + " es un peso insificiente";
        } else if (imc >= 18.5 && imc < 25) {
            return  imc + " es un peso normal";
        } else if (imc >= 25 && imc < 30) {
            return  imc + " es un sobrepeso";
        } else {
            return  imc + " estado de Obesidad";
        }

    }
}
