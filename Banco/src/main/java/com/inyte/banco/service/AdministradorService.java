package com.inyte.banco.service;

import com.inyte.banco.entity.Administrador;
import org.springframework.stereotype.Service;


@Service
public interface AdministradorService {

  Administrador registrarAdmin(Administrador admin, Long idCreador);



}
