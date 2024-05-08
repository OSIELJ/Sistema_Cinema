/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.Scanner;

/**
 *
 * @author Osiel
 */
public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final Usuario usuarioLogado;

    public Menu(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public void exibirMenu() {
        switch (usuarioLogado) {
            case Gerente gerente ->
                exibirMenuGerente(gerente);
            case Funcionario funcionario ->
                exibirMenuFuncionario(funcionario);
            default -> {
            }
        }
    }

    private void exibirMenuGerente(Gerente gerente) {
        String opcao;
        while (true) {
            System.out.println("Bem-vindo, Gerente " + gerente.getNome() + "!");
            System.out.println("O que você deseja fazer?");
            System.out.println("1. Gerar relatório de vendas");
            System.out.println("2. Adicionar novo funcionário");
            System.out.println("3. Sair");

            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> {
                }
                case "2" -> {
                    
                    
                    System.out.println("Informe o nome do novo funcionário:");
                    String nome = scanner.nextLine();
                    System.out.println("Informe o CPF do novo funcionário:");
                    String cpf = scanner.nextLine();
                    System.out.println("Informe o nome de usuário do novo funcionário:");
                    String nomeUsuario = scanner.nextLine();
                    System.out.println("Informe a senha do novo funcionário:");
                    String senha = scanner.nextLine();

                    // Criar instância de Funcionario com as informações fornecidas
                   Gerente novoGerente = new Gerente(nome, cpf, nomeUsuario, senha);
                
                // Adicionar o novo gerente ao sistema
                    gerente.adicionarGerente(novoGerente);
                    

                }
                case "3" -> {
                    System.out.println("Sessão encerrada.");
                    return;
                }
                default ->
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
            // Lógica para gerar relatório de vendas
            // Lógica para adicionar novo funcionário
        }
    }

    private void exibirMenuFuncionario(Funcionario funcionario) {
        String opcao;
        while (true) {
            System.out.println("Bem-vindo, Funcionário " + funcionario.getNome() + "!");
            System.out.println("O que você deseja fazer?");
            System.out.println("1. Realizar venda");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Verificar estoque");
            System.out.println("4. Verificar rendimento diário ou mensal dos balcões");
            System.out.println("5. Sair");

            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> {
                }
                case "2" -> {
                }
                case "3" -> {
                }
                case "4" -> {
                }
                case "5" -> {
                    System.out.println("Sessão encerrada.");
                    return;
                }
                default ->
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
            // Lógica para realizar venda
            // Lógica para cadastrar cliente
            // Lógica para verificar estoque
            // Lógica para verificar rendimento diário ou mensal dos balcões
        }
    }
}
