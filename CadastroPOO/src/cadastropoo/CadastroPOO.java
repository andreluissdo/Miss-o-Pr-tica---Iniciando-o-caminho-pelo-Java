/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.util.Scanner;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class CadastroPOO {
    public static void main(String[] args) {
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Exibir menu formatado
            System.out.println("\n======= Sistema de Cadastro =======");
            System.out.println("1 - Incluir nova pessoa");
            System.out.println("2 - Alterar dados de pessoa");
            System.out.println("3 - Excluir pessoa");
            System.out.println("4 - Exibir pessoa por ID");
            System.out.println("5 - Exibir todas as pessoas");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Sair");
            System.out.println("===================================\n");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1: // Incluir
                    System.out.println("\n*** Inclusão de nova pessoa ***");
                    System.out.print("Escolha o tipo (1 - Física, 2 - Jurídica): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    if (tipo == 1) { // Pessoa Física
                        System.out.print("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite o nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Digite a idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();

                        PessoaFisica pessoaFisica = new PessoaFisica(id, nome, cpf, idade);
                        repoFisica.inserir(pessoaFisica);
                        System.out.println("Pessoa física adicionada com sucesso!");

                    } else if (tipo == 2) { // Pessoa Jurídica
                        System.out.print("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite o nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o CNPJ: ");
                        String cnpj = scanner.nextLine();

                        PessoaJuridica pessoaJuridica = new PessoaJuridica(id, nome, cnpj);
                        repoJuridica.inserir(pessoaJuridica);
                        System.out.println("Pessoa jurídica adicionada com sucesso!");
                    }
                    break;

                case 2: // Alterar
                    System.out.println("\n*** Alteração de dados de pessoa ***");
                    System.out.print("Escolha o tipo (1 - Física, 2 - Jurídica): ");
                    tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    if (tipo == 1) { // Pessoa Física
                        System.out.print("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        PessoaFisica pessoaFisica = repoFisica.obter(id);
                        if (pessoaFisica != null) {
                            System.out.println("Dados atuais: " + pessoaFisica);
                            System.out.print("Digite o novo nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("Digite o novo CPF: ");
                            String cpf = scanner.nextLine();
                            System.out.print("Digite a nova idade: ");
                            int idade = scanner.nextInt();
                            scanner.nextLine();

                            pessoaFisica.setNome(nome);
                            pessoaFisica.setCpf(cpf);
                            pessoaFisica.setIdade(idade);
                            repoFisica.alterar(pessoaFisica);
                            System.out.println("Pessoa física alterada com sucesso!");
                        } else {
                            System.out.println("Pessoa física não encontrada.");
                        }
                    } else if (tipo == 2) { // Pessoa Jurídica
                        System.out.print("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        PessoaJuridica pessoaJuridica = repoJuridica.obter(id);
                        if (pessoaJuridica != null) {
                            System.out.println("Dados atuais: " + pessoaJuridica);
                            System.out.print("Digite o novo nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("Digite o novo CNPJ: ");
                            String cnpj = scanner.nextLine();

                            pessoaJuridica.setNome(nome);
                            pessoaJuridica.setCnpj(cnpj);
                            repoJuridica.alterar(pessoaJuridica);
                            System.out.println("Pessoa jurídica alterada com sucesso!");
                        } else {
                            System.out.println("Pessoa jurídica não encontrada.");
                        }
                    }
                    break;

                case 3: // Excluir
                    System.out.println("\n*** Exclusão de pessoa ***");
                    System.out.print("Escolha o tipo (1 - Física, 2 - Jurídica): ");
                    tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    System.out.print("Digite o ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    if (tipo == 1) { // Pessoa Física
                        repoFisica.excluir(id);
                        System.out.println("Pessoa física excluída com sucesso!");
                    } else if (tipo == 2) { // Pessoa Jurídica
                        repoJuridica.excluir(id);
                        System.out.println("Pessoa jurídica excluída com sucesso!");
                    }
                    break;

                case 4: // Exibir por ID
                    System.out.println("\n*** Exibir pessoa por ID ***");
                    System.out.print("Escolha o tipo (1 - Física, 2 - Jurídica): ");
                    tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    System.out.print("Digite o ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    if (tipo == 1) { // Pessoa Física
                        PessoaFisica pessoaFisica = repoFisica.obter(id);
                        if (pessoaFisica != null) {
                            System.out.println(pessoaFisica);
                        } else {
                            System.out.println("Pessoa física não encontrada.");
                        }
                    } else if (tipo == 2) { // Pessoa Jurídica
                        PessoaJuridica pessoaJuridica = repoJuridica.obter(id);
                        if (pessoaJuridica != null) {
                            System.out.println(pessoaJuridica);
                        } else {
                            System.out.println("Pessoa jurídica não encontrada.");
                        }
                    }
                    break;

                case 5: // Exibir todos
                    System.out.println("\n*** Exibir todas as pessoas ***");
                    System.out.print("Escolha o tipo (1 - Física, 2 - Jurídica): ");
                    tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    if (tipo == 1) { // Pessoa Física
                        for (PessoaFisica p : repoFisica.obterTodos()) {
                            System.out.println(p);
                        }
                    } else if (tipo == 2) { // Pessoa Jurídica
                        for (PessoaJuridica p : repoJuridica.obterTodos()) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 6: // Salvar dados
                    System.out.println("\n*** Salvando dados ***");
                    System.out.print("Digite o prefixo do arquivo: ");
                    String prefixo = scanner.nextLine();

                    try {
                        repoFisica.persistir(prefixo + ".fisica.bin");
                        repoJuridica.persistir(prefixo + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar dados: " + e.getMessage());
                    }
                    break;

                case 7: // Recuperar dados
                    System.out.println("\n*** Recuperando dados ***");
                    System.out.print("Digite o prefixo do arquivo: ");
                    prefixo = scanner.nextLine();

                    try {
                        repoFisica.recuperar(prefixo + ".fisica.bin");
                        repoJuridica.recuperar(prefixo + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao recuperar dados: " + e.getMessage());
                    }
                    break;

                case 0: // Sair
                    System.out.println("\nFinalizando o programa. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}
