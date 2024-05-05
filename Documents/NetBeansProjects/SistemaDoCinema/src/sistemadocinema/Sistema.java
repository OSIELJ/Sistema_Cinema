/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.ArrayList;
import java.util.List;
import Arquivo.Json;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Osiel Junior
 */
public class Sistema {

    // private static BalcaoDeAtendimento[] balcoes = new BalcaoDeAtendimento[5];
    public static void main(String[] args) {

        Cliente myCliente1 = new Cliente("osiel", "juniro", "13441301609", "tirand",
                "38998151249");

        int totalClientes = Cliente.getTotalClientes();
        System.out.println("Total de clientes: " + totalClientes);

        totalClientes = Cliente.getTotalClientes();
        System.out.println("Total de clientes metodo static: " + totalClientes);

        Alimenticios pipoca = new Alimenticios("Pipoca", LocalDate.of(2024, 12, 31), 5.0, 100);
        Alimenticios refrigerante = new Alimenticios("Refrigerante", LocalDate.of(2024, 12, 31), 3.0, 200);
        Filme filme = new Filme("Os Incríveis", "Animação", LocalDate.of(2024, 5, 1), 10.0, 100, "10 dias");

        Venda venda = new Venda(myCliente1);

        venda.adicionarItem(pipoca);
        venda.adicionarItem(refrigerante);
        venda.adicionarItem(filme);

        venda.calcularTotal();

        System.out.println("Venda realizada com sucesso:");
        System.out.println("Cliente: " + myCliente1.getNome());
        System.out.println("Itens vendidos:");
        for (Produto produto : venda.getItensVendidos()) {
            System.out.println("- " + produto.getNome() + ": R$" + produto.getValor());
        }
        System.out.println("Valor total: R$" + venda.calcularTotal());
        System.out.println("Data e hora da venda: " + venda.getDataHora());
        System.out.println("Extrato da venda:");
        System.out.println(venda.getExtrato());

        /*
        for (int i = 0; i < 5; i++) {
           balcoes[i] = new BalcaoDeAtendimento(i + 1, null);
        }
        
        
        
        
        
        
        
        
        
        
        
       
        Scanner scanner = new Scanner(System.in);
        String nomeUsuario, senha;

        Gerente myGerente = new Gerente("Osiel Junior", "13441301609", "Osiel", "Osieljunior123");
        Funcionario myFuncionario = new Funcionario("Daniel Rodrigues", "01602001506", "Daniel", "Danielrodrigues123");

        List<Cliente> listaClientes = new ArrayList<>();
        List<Funcionario> listaFuncionarios = new ArrayList<>();

       Cliente myCliente1 = new Cliente("osiel", "juniro", "13441301609", "tirand",
                "38998151249");
        Cliente myCliente2 = new Cliente("Maicon", "Douglas", "13441301612", "tirand",
                "38998151249");
        Cliente myCliente3 = new Cliente("dfdsdf", "fffffff", "000000000", "tirand",
                "38998151249");

        /*Cadastro myCadastro = new Cadastro(listaClientes,listaFuncionarios);
        
        myCadastro.cadastrarCliente(myCliente1);
        myCadastro.cadastrarCliente(myCliente2);
        myCadastro.cadastrarCliente(myCliente3);
        
        myCadastro.excluirCliente("000000000");
        
         
        
        
        
        /*Alimenticios pipoca = new Alimenticios("Pipoca", LocalDate.of(2024, 12, 31), 5.0, 100);
        Alimenticios refrigerante = new Alimenticios("Refrigerante", LocalDate.of(2024, 12, 31), 3.0, 200);
        Alimenticios chocolate = new Alimenticios("Chocolate", LocalDate.of(2024, 4, 28), 2.0, 150);


        Estoque myEstoque = new Estoque();
        myEstoque.adicionarProduto(pipoca);
        myEstoque.adicionarProduto(refrigerante);
        myEstoque.adicionarProduto(chocolate);
        
        myEstoque.verificarValidadeProdutos();
        
        
      
        

          Autenticar myAutenticar = new Autenticar();

        myAutenticar.adicionarUsuario(myFuncionario);
        myAutenticar.adicionarUsuario(myGerente);

        Usuario autenticarUsuario = null;

        while (autenticarUsuario == null) {

            System.out.println("Bem-vindo ao sistema de cinema!");
            System.out.println("Por favor, faça login para continuar.");

            System.out.print("Usuário: ");
            nomeUsuario = scanner.nextLine();

            System.out.print("Senha: ");
            senha = scanner.nextLine();

            autenticarUsuario = myAutenticar.autenticar(nomeUsuario, senha);

            if (autenticarUsuario == null) {

                System.out.println("Usuário ou senha incorretos. Por favor, tente novamente.\n");

            } else {

                if (autenticarUsuario instanceof Gerente) {

                    System.out.println("Bem-vindo, Gerente " + nomeUsuario + "!");

                    while (true) {
                        System.out.println("O que você deseja fazer? (Digite 'sair' para encerrar a sessão)");
                        System.out.println("1. Gerar relatório de vendas");
                        System.out.println("2. Adicionar novo funcionário");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                            case "1" -> {
                            }
                            case "2" -> {
                            }
                            case "sair" ->
                                autenticarUsuario = null; // Deslogar usuário
                            default ->
                                System.out.println("Opção inválida. Por favor, escolha novamente.");
                        }
                        // Lógica para gerar relatório de vendas
                        // Lógica para adicionar novo funcionário

                        if (autenticarUsuario == null) {
                            break; // Sai do loop interno e volta para o login
                        }
                    }

                } else if (autenticarUsuario instanceof Funcionario) {

                    System.out.println("Bem-vindo, Funcionário " + nomeUsuario + "!");

                    while (true) {
                        System.out.println("O que você deseja fazer? (Digite 'sair' para encerrar a sessão)");
                        System.out.println("1. Verificar estoque");
                        System.out.println("2. Realizar venda de ingressos");
                        System.out.println("3. Cancelar venda de ingressos");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                            case "1" -> {
                            }
                            case "2" -> {
                            }
                            case "3" -> {
                            }
                            case "sair" ->
                                autenticarUsuario = null; // Deslogar usuário
                            default ->
                                System.out.println("Opção inválida. Por favor, escolha novamente.");
                        }
                        // Lógica para verificar estoque
                        // Lógica para realizar venda de ingressos
                        // Lógica para cancelar venda de ingressos

                        if (autenticarUsuario == null) {
                            break; // Sai do loop interno e volta para o login
                        }
                    }
                }

            }

        }
         */
    }

}
