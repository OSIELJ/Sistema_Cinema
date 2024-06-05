/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import sistemadocinema.gereciamentoDeVendas.Venda;
import sistemadocinema.gereciamentoDeVendas.BalcaoDeAtendimento;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
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

        List<Venda> listVendas = new ArrayList<>();
        List<Cliente> listaClientes = new ArrayList<>();
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        
        
        GerenciarCadastros gerenciarCadastros = new GerenciarCadastros(listaClientes, listaFuncionarios);

        Gerente myGerente = new Gerente("Osiel Junior", "13441301609", "Osiel", "Osiel123");
        Funcionario myFuncionario = new Funcionario("Daniel Rodrigues", "01602001506", "Daniel", "Daniel123");
        
        listaFuncionarios.add(myFuncionario);

        GerenciarVendas gerenciarVendas = new GerenciarVendas(listVendas);
        balcoes[4] = new BalcaoAutomatico(5, myFuncionario, gerenciarVendas);

        Alimenticios pipoca = new Alimenticios("Pipoca", LocalDate.of(2024, 12, 31), 5.0, 100);
        Alimenticios refrigerante = new Alimenticios("Refrigerante", LocalDate.of(2024, 12, 31), 3.0, 200);
        Alimenticios chocolate = new Alimenticios("Chocolate", LocalDate.of(2023, 12, 31), 3.0, 200);
        Filme filme = new Filme("Os Incríveis", "Animação", LocalDate.of(2024, 5, 1), 10.0, 100, "10 dias");
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

        listaClientes.add(c);
        

        myEstoque.verificarValidadeProdutos();

        Autenticar myAutenticar = new Autenticar();
        myAutenticar.adicionarUsuario(myFuncionario);
        myAutenticar.adicionarUsuario(myGerente);
        
        
        /*Questão 1:
        
                Todas implementadas e adicionamos outras que não estava anteriormente.
        */

        /*Questão 2:
        
                Apenas funcionario e administrador tem acesso ao sistema.
        */
        
        /*Questão 3:
        
               Todas contem o metodo ToString.
        */
        
        /*Questão 4:
        
                Usar a palavra-chave super
        
                Na linha 18 da classe Filme:  
                public Filme(String titulo, String estilo, LocalDate dataValidade, double valor, int quantidadeEmEstoque, String periodoExibicao) {
                super(titulo, dataValidade, valor, quantidadeEmEstoque);
                
                Na liinha 15 na classe Alimenticios:
                public Alimenticios(String nome, LocalDate dataValidade, double valor, int quantidadeEmEstoque) {
                super(nome, dataValidade, valor, quantidadeEmEstoque);
      
        */
        
        /*Questão 5:
        
                
      
        */        
          
        

        while (true) {
            System.out.println("Escolha o modo de operação:");
            System.out.println("1. Modo Manual");
            System.out.println("2. Modo Automático");
            System.out.print("Opção: ");
            String escolha = scanner.nextLine();

            if (escolha.equals("1")) {
                // Modo Manual
                System.out.println("Modo Manual selecionado.");
                // Adicione aqui o código para testes manuais, se necessário
                
                /*Questão 6:
                    cadastrar os colaboradores no sistema, alterar ou editar seus atributos;
                */ 
                
                System.out.println("-------------------------------------------------------------------");
                gerenciarCadastros.imprimirListaFuncionarios();
                // Cadastrar Colaborador/Funcionario
                gerenciarCadastros.cadastrarFuncionario(new Funcionario("Marshal", "01602001503", "Marshal", "123"));
                gerenciarCadastros.cadastrarFuncionario(new Funcionario("Andre", "01602001504", "Andre", "123"));
                gerenciarCadastros.imprimirListaFuncionarios();
                
                // Editar Colaborador/Funcionario
                gerenciarCadastros.editarFuncionario("01602001503", "1234", "MarshallDaBmW");
                gerenciarCadastros.imprimirListaFuncionarios();
                
                // Excluir Colaborador/Funcionario
                gerenciarCadastros.excluirFuncionario("01602001504");
                gerenciarCadastros.imprimirListaFuncionarios();
                System.out.println("-------------------------------------------------------------------");
                
                
                /*Questão 7:
                    Cadastrar, alterar ou excluir clientes;
                */
                
                System.out.println("-------------------------------------------------------------------");
                gerenciarCadastros.imprimirListaClientes();
                // Cadastrar Cliente
                gerenciarCadastros.cadastrarCliente(new Cliente("Arthur", "Abreu", "00000000000", "Rio grande", "38998121594"));
                gerenciarCadastros.imprimirListaClientes();
                
                // Editar Cliente
                gerenciarCadastros.editarCliente("00000000000", "38000000000", "Pedra Grande");
                gerenciarCadastros.imprimirListaClientes();
                
                // Excluir Cliente
                gerenciarCadastros.excluirCliente("00000000000");
                gerenciarCadastros.imprimirListaClientes();
                System.out.println("-------------------------------------------------------------------");
                
                
                break;
            } else if (escolha.equals("2")) {
                // Modo Automático
                System.out.println("Modo Automático selecionado.");
                while (true) {
                    System.out.print("Usuário: ");
                    nomeUsuario = scanner.nextLine();

                    System.out.print("Senha: ");
                    senha = scanner.nextLine();

                    Usuario usuarioLogado = myAutenticar.autenticar(nomeUsuario, senha);
                    if (usuarioLogado != null) {
                        Menu menu = new Menu(usuarioLogado, myEstoque, balcoes[4], listaClientes,
                                salas, listaFuncionarios, listVendas);
                        menu.exibirMenu();
                        break;
                    } else {
                        System.out.println("Usuário ou senha incorretos. Por favor, tente novamente.");
                    }
                }
                break;
            } else {
                System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }
}