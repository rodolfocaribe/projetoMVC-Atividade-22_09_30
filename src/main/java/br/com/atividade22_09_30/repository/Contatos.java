package br.com.atividade22_09_30.repository;

import lombok.Data;

@Data
public class Contatos {
        Long id;
        String nome, telefone, endereco;
        public Contatos(Long id, String nome, String telefone, String endereco) {
            this.id = id;
            this.nome = nome;
            this.telefone = telefone;
            this.endereco = endereco;
        }
    }

