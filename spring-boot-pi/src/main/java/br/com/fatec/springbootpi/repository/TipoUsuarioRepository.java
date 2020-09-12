package br.com.fatec.springbootpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.springbootpi.entity.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {
    public TipoUsuario findByNome(String nome);
}