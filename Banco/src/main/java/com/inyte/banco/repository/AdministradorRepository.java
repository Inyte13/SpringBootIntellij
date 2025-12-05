package com.inyte.banco.repository;

import com.inyte.banco.entity.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
  Optional<Administrador> findByCorreo(String correo);


}

