package br.com.fatec.springbootpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.springbootpi.entity.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem,Long> {       
}