package br.com.fatec.springbootpi.security;

import java.util.Date;
import br.com.fatec.springbootpi.entity.TipoUsuario;
import br.com.fatec.springbootpi.entity.Usuario;

public interface ServicoService {
    public Usuario criarUsuario(String nomeUsuario, String cpfUsuario, String tipoUsuario, Date dataCriado);
    public TipoUsuario criarTipoUsuario(String nome);
}