package com.inyte.banco.controllers;

import com.inyte.banco.entity.Administrador;
import com.inyte.banco.service.AdministradorService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdministradorController {

  private final AdministradorService administradorService; // Siempre el mismo nombre
  public AdministradorController(AdministradorService administradorService) {
    this.administradorService = administradorService;
  }

  @PostMapping("/crear")
  public Administrador crearAdmin(@RequestBody Administrador admin, @AuthenticationPrincipal Administrador creador) {
    return administradorService.registrarAdmin(admin, creador.getIdPersona());
  }

}
