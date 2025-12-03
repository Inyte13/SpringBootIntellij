package com.inyte.banco.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Constructor vacío protected
@Data
public class Administrador extends Persona {

  private Long idCreador;

  // Constructor privado
  private Administrador(Long idCreador, String nombre, String apellido, String dni, String direccion, String nroTelefono, String correo, String contrasena) {
    super(nombre, apellido, dni, direccion, nroTelefono, correo, contrasena);
    this.idCreador = idCreador;
  }

}
