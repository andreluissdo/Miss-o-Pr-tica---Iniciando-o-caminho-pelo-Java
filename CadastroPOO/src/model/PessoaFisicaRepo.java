/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<>();
    private int id;

    public void inserir(PessoaFisica pessoa) {
        pessoasFisicas.add(pessoa);
    }

    public void alterar(PessoaFisica novaPessoa) {
        PessoaFisica pessoa = obter(id);
        if (pessoa != null) {
            pessoa.setNome(novaPessoa.getNome());
            pessoa.setCpf(novaPessoa.getCpf());
            pessoa.setIdade(novaPessoa.getIdade());
        }
    }

    public void excluir(int id) {
        PessoaFisica pessoa = obter(id);
        if (pessoa != null) {
            pessoasFisicas.remove(pessoa);
        }
    }

    public PessoaFisica obter(int id) {
        return pessoasFisicas.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return pessoasFisicas;
    }

    public void persistir(String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(pessoasFisicas);
        }
    }

    public void recuperar(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            pessoasFisicas = (ArrayList<PessoaFisica>) ois.readObject();
        }
    }
}

