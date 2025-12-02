package com.inyte.teoria.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*
  @RestController:
    - es un controlador Web en APIs REST
    - expone rutas HTTP (URLs
    - combina @Controller y @ReponseBody (JSON)
 */
@RequestMapping("/api/saludo")
/*
  @RequestMapping:
    - el identificador de este controller/endpoint

 */

public class SaludoController {

  @GetMapping("/saludar")
  public String saludar() {
    return "Hola desde API";
  }

}
