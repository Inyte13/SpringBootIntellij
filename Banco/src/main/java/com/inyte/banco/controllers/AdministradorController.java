package com.inyte.banco.controllers;

import com.inyte.banco.entity.Administrador;
import com.inyte.banco.service.AdministradorService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@PreAuthorize("denyAll()") // Con las anotaciones
public class AdministradorController {

  private final AdministradorService administradorService; // Siempre el mismo nombre
  public AdministradorController(AdministradorService administradorService) {
    this.administradorService = administradorService;
  }

  @PostMapping("/crear")
  public Administrador crearAdmin(@RequestBody Administrador admin, @AuthenticationPrincipal Administrador creador) {
    return administradorService.registrarAdmin(admin, creador.getIdPersona());
  }

  @PreAuthorize("hasAuthority('READ')") // Con las anotaciones
  @GetMapping("/hola")
  public String hola() {
    return "Hola mundo";
  }

  @GetMapping("/protected") // Con las anotaciones
  @PreAuthorize("hasAuthority('CREATE')")
  public String holaSecured() {
    return "Hola mundo asegurado";
  }

}
