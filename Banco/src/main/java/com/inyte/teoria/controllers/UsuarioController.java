package com.inyte.teoria.controllers;

import com.inyte.teoria.entity.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/usuarios") // Establecemos la dirección de la API
public class UsuarioController {

  private List<Usuario> usuarios = new ArrayList<>();

  public UsuarioController() {
    usuarios.add(new Usuario(1,"Paula"));
    usuarios.add(new Usuario(2,"Oriana"));
  }

  @GetMapping // GET Cuando esta vacío "api/mensaje"
  public List<Usuario> mostrarUsuarios() {
    return usuarios;
  }

  @GetMapping("/{id}") // GET Se usa el parámetro id
  public Usuario getUsuarioPorID(@PathVariable int id) { // Usamos el parametro con @PathVariable
    return usuarios.stream()
        .filter(user -> user.getId() == id)
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @PostMapping // POST
  public Usuario crearUsuario(@RequestBody Usuario mensaje) { // RequestBody, es para pasarle un JSON
    usuarios.add(mensaje);
    return mensaje;
  }
  @DeleteMapping("/{id}") // DELETE
  public void eliminarUsuario(@PathVariable int id) {
    usuarios.removeIf(user -> user.getId() == id);

  }
}
