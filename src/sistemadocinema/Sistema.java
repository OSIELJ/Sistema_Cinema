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

    private static final BalcaoDeAtendimento[] balcoes = new BalcaoDeAtendimento[5];
    
    public static void main(String[] args) {
        
        
        Cliente c = new Cliente("nome", "sobrenome", "13441301609", "endereco", "telefone");
        
        

        
        
       
        
        
        
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
        Filme filme1 = new Filme("Os Incríveis", "Animação", LocalDate.of(2024, 5, 1), 10.0, 100, "10 dias");
        Filme filme2 = new Filme("O Senhor dos Anéis", "Fantasia", LocalDate.of(2024, 6, 15), 12.0, 150, "15 dias");
        Filme filme3 = new Filme("Matrix", "Ficção Científica", LocalDate.of(2024, 7, 30), 11.0, 120, "12 dias");

       
        
        Sala sala1 = new Sala(filme, 80);
        Sala sala2 = new Sala(filme2, 100);
        Sala sala3 = new Sala(filme3, 90);

          List<Sala> salas = new ArrayList<>();
        salas.add(sala1);
        salas.add(sala2);
        salas.add(sala3);
        
        
        Estoque myEstoque = new Estoque();
        myEstoque.adicionarProduto(pipoca);
        myEstoque.adicionarProduto(refrigerante);
        myEstoque.adicionarProduto(chocolate);
        myEstoque.adicionarProduto(filme);

        
 
       Scanner scanner = new Scanner(System.in);
        String nomeUsuario, senha;



        List<Cliente> listaClientes = new ArrayList<>();
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        
        listaClientes.add(c);

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
                Menu menu = new Menu(usuarioLogado, myEstoque,balcoes[4], listaClientes,  salas);
                menu.exibirMenu();
                break; // Sai do loop se o usuário for autenticado com sucesso
            } else {
                System.out.println("Usuário ou senha incorretos. Por favor, tente novamente.");
            }
        }

    }
    
    

}
