package br.com.fatec.springbootpi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.fatec.springbootpi.entity.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

   // @Query("select a from Atividade a inner join a.usuario u where a.nome_atividade = ?1")
   // public Atividade buscarAtividadesDeUsuario(String nome);
   
   @Query("select a from Atividade a inner join a.usuarios u where u.idUsuario = ?1")
    public List<Atividade> getAtividadesPorUsuario(Long idUsuario);
}