package com.vitor.Lombok.PrjLombok.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitor.Lombok.PrjLombok.entities.Usuario;

public interface UsuarioRepositorio extends JpaRepository <Usuario, Long> {

}
