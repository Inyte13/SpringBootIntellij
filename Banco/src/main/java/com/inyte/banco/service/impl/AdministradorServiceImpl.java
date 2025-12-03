package com.inyte.banco.service.impl;

import com.inyte.banco.entity.Administrador;
import com.inyte.banco.repository.AdministradorRepository;
import com.inyte.banco.service.AdministradorService;
import org.springframework.stereotype.Service;


@Service
public class AdministradorServiceImpl implements AdministradorService {

  private final AdministradorRepository adminRepository;

  public AdministradorServiceImpl(AdministradorRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

  @Override
  public Administrador registrarAdmin(Administrador admin, Long idCreador) {
    admin.setIdCreador(idCreador);
    return adminRepository.save(admin);
  }
}
