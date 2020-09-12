package br.com.fatec.springbootpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.springbootpi.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}