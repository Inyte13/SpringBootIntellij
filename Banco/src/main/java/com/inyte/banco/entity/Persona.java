package com.inyte.banco.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Una tabla para la superclase y para cada subclase
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Obligatorio por JPA
@Getter
public abstract class Persona {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Para incrementar el ID autómaticamente
  private Long idPersona;

  @Column(nullable = false, length = 50)
  private String nombre;

  @Column(nullable = false, length = 50)
  private String apellido;

  @Column(nullable = false, length = 15)
  private String dni;

  @Column(nullable = false, length = 150)
  private String direccion;

  @Column(nullable = false, length = 20)
  private String nroTelefono;

  @Column(nullable = false, length = 100)
  private String correo;

  @Column(nullable = false, length = 100)
  private String contrasena;

  public Persona(
      String nombre,
      String apellido,
      String dni,
      String direccion,
      String nroTelefono,
      String correo,
      String contrasena
  ) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.direccion = direccion;
    this.nroTelefono = nroTelefono;
    this.correo = correo;
    this.contrasena=contrasena;
  }

}
