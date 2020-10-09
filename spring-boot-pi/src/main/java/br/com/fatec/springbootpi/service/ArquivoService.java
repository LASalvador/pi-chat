package br.com.fatec.springbootpi.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.springbootpi.entity.Arquivo;
import br.com.fatec.springbootpi.repository.ArquivoRepository;

@Service
public class ArquivoService {
    
    @Autowired
    private ArquivoRepository arquivoRepository;

    @Transactional
    public Arquivo criarArquivo(String nome, String descricao) {
        Date dataCriado = new Date();

        Arquivo arquivo = new Arquivo();

        arquivo.setDataCriado(dataCriado);
        arquivo.setDescArquivo(descricao);
        arquivo.setNomeArquivo(nome);

        arquivoRepository.save(arquivo);

        return arquivo;
    }
}