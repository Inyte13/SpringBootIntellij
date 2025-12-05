package com.inyte.banco.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Constructor vacío protected
@Data
public class Administrador extends Persona implements UserDetails { // Implemento un UserDetails (mi super admin)

  private Long idCreador;

  public Administrador(Long idCreador, String nombre, String apellido, String dni, String direccion, String nroTelefono, String correo, String contrasena) {
    super(nombre, apellido, dni, direccion, nroTelefono, correo, contrasena);
    this.idCreador = idCreador;
  }

  // Evita que la contraseña se serialice en respuestas JSON
  @Override
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  public String getContrasena() {
    return super.getContrasena();
  }

  // Metodos de UserDetails
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
  }

  @Override
  public String getPassword() {
    return getContrasena();
  }

  @Override
  public String getUsername() {
    return getCorreo();
  }

  @Override public boolean isAccountNonExpired() { return true; }
  @Override public boolean isAccountNonLocked() { return true; }
  @Override public boolean isCredentialsNonExpired() { return true; }
  @Override public boolean isEnabled() { return true; }

}
