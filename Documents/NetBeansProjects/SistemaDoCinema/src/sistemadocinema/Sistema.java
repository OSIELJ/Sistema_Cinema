/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.ArrayList;
import java.util.List;
import Arquivo.Json;
import java.util.Scanner;

/**
 *
 * @author Osiel Junior
 */
public class Sistema {

    public static void main(String[] args) {


       
           
      
  
        
        Scanner scanner = new Scanner(System.in);
        String nomeUsuario, senha;

        Gerente myGerente = new Gerente("Osiel Junior", "13441301609", "Osiel", "Osieljunior123");
        Funcionario myFuncionario = new Funcionario("Daniel Rodrigues","01602001506","Daniel", "Danielrodrigues123");
        
        List<Cliente> listaClientes = new ArrayList<>();
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        
        
        Cliente myCliente1 = new Cliente("osiel", "juniro", "13441301609", "tirand",
        "38998151249");
        Cliente myCliente2 = new Cliente("Maicon", "Douglas", "13441301612", "tirand",
        "38998151249");
        Cliente myCliente3 = new Cliente("dfdsdf", "fffffff", "000000000", "tirand",
        "38998151249");
        
        
        Cadastro myCadastro = new Cadastro(listaClientes,listaFuncionarios);
        
        myCadastro.cadastrarCliente(myCliente1);
        myCadastro.cadastrarCliente(myCliente2);
        myCadastro.cadastrarCliente(myCliente3);
        
        myCadastro.excluirCliente("000000000");
        
        

      /*  Autenticar myAutenticar = new Autenticar();

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
