package br.com.fatec.springbootpi.model;

public class UsuarioForm {

    private Long idTipoUsuario;

    private String nomeUsuario;

    private String cpfUsuario;

    public Long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setIdTipoUsuario(Long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }
}