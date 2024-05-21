/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import sistemadocinema.gereciamentoDeVendas.Venda;
import sistemadocinema.gereciamentoDeVendas.BalcaoDeAtendimento;
import java.util.ArrayList;
import java.util.List;
import Arquivo.Json;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import sistemadocinema.gereciamentoDeVendas.BalcaoAutomatico;
import sistemadocinema.gereciamentoDeVendas.GerenciarVendas;

/**
 *
 * @author Osiel Junior
 */
public class Sistema {

    private static BalcaoDeAtendimento[] balcoes = new BalcaoDeAtendimento[5];
    
    public static void main(String[] args) {
        
        Gerente myGerente = new Gerente("Osiel Junior", "13441301609", "Osiel", "Osiel123");
        Funcionario myFuncionario = new Funcionario("Daniel Rodrigues", "01602001506", "Daniel", "Daniel123");
        
        GerenciarVendas gerenciarVendas = new GerenciarVendas();
       
       
        balcoes[4] = new BalcaoAutomatico(5, myFuncionario, gerenciarVendas);
        
       

        //int totalClientes = Cliente.getTotalClientes();
        // System.out.println("Total de clientes: " + totalClientes);
        //totalClientes = Cliente.getTotalClientes();
        //System.out.println("Total de clientes metodo static: " + totalClientes);
        Alimenticios pipoca = new Alimenticios("Pipoca", LocalDate.of(2024, 12, 31), 5.0, 100);
        Alimenticios refrigerante = new Alimenticios("Refrigerante", LocalDate.of(2024, 12, 31), 3.0, 200);
        Alimenticios chocolate = new Alimenticios("Chocolate", LocalDate.of(2023, 12, 31), 3.0, 200);
        Filme filme = new Filme("Os Incríveis", "Animação", LocalDate.of(2024, 5, 1), 10.0, 100, "10 dias");

        Estoque myEstoque = new Estoque();
        myEstoque.adicionarProduto(pipoca);
        myEstoque.adicionarProduto(refrigerante);
        myEstoque.adicionarProduto(chocolate);
        myEstoque.adicionarProduto(filme);

        
    
        
        
       Scanner scanner = new Scanner(System.in);
        String nomeUsuario, senha;



        List<Cliente> listaClientes = new ArrayList<>();
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        GerenciarCadastros meusCadastros = new GerenciarCadastros(listaClientes, listaFuncionarios);

        myEstoque.verificarValidadeProdutos();

        Autenticar myAutenticar = new Autenticar();

        myAutenticar.adicionarUsuario(myFuncionario);
        myAutenticar.adicionarUsuario(myGerente);



        while (true) {
            System.out.print("Usuário: ");
            nomeUsuario = scanner.nextLine();

            System.out.print("Senha: ");
            senha = scanner.nextLine();

            Usuario usuarioLogado = myAutenticar.autenticar(nomeUsuario, senha);
            if (usuarioLogado != null) {
                Menu menu = new Menu(usuarioLogado, myEstoque,balcoes[4], listaClientes);
                menu.exibirMenu();
                break; // Sai do loop se o usuário for autenticado com sucesso
            } else {
                System.out.println("Usuário ou senha incorretos. Por favor, tente novamente.");
            }
        }

    }

}
