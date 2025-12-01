package com.inyte.teoria.controllers;

import com.inyte.teoria.entity.Mensaje;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/mensaje")
public class MensajeController {
  private List<Mensaje> mensajes = new ArrayList<>();

  public MensajeController() {
    mensajes.add(new Mensaje(1,"Mensaje 1"));
    mensajes.add(new Mensaje(2,"Mensaje 2"));
  }
  @GetMapping
  public List<Mensaje> mostrarMensajes() {
    return mensajes;
  }
  @GetMapping("/{id}")
  public Mensaje getMensajePorID(@PathVariable int id) {
    return mensajes.get(id-1);
  }
}
