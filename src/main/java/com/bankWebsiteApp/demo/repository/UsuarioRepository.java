package com.bankWebsiteApp.demo.repository;

import com.bankWebsiteApp.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario,Long> {
}
