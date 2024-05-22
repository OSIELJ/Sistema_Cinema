/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.List;
import java.util.Scanner;
import sistemadocinema.gereciamentoDeVendas.BalcaoDeAtendimento;
import sistemadocinema.gereciamentoDeVendas.Venda;

/**
 *
 * @author Osiel
 */
public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final Usuario usuarioLogado;
    private final Estoque meuEstoque;
    private final BalcaoDeAtendimento balcaoAutomatico;
    private final List<Cliente> listaClientes;
    private final List<Sala> salas;

    public Menu(Usuario usuarioLogado, Estoque meuEstoque, BalcaoDeAtendimento balcaoAutomatico, List<Cliente> listaClientes, List<Sala> salas) {
        this.usuarioLogado = usuarioLogado;
        this.meuEstoque = meuEstoque;
        this.balcaoAutomatico = balcaoAutomatico;
        this.listaClientes = listaClientes;
        this.salas = salas;
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

                    System.out.println("Qual relatorio voce deseja: Mensal ou Anual");

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
                    System.out.println("Realizar Venda:");
                    System.out.println("Informe o CPF do cliente:");
                    String cpf = scanner.nextLine();

                    Cliente clienteSelecionado = null;
                    for (Cliente cliente : listaClientes) {
                        if (cliente.getCpf().equals(cpf)) {
                            clienteSelecionado = cliente;
                            break; // Cliente encontrado, encerra o loop
                        }
                    }

                    if (clienteSelecionado == null) {
                        System.out.println("Cliente não encontrado.");
                        return; // Encerra o método caso o cliente não seja encontrado
                    }

                    System.out.println("Escolha qual filme deseja ver: ");
                    meuEstoque.listarFilmesDisponivel();

                    String tituloFilmeEscolhido = scanner.nextLine();
                    Filme filmeEscolhido = null;
                    for (Produto produto : meuEstoque.getProdutos()) {
                        if (produto instanceof Filme) {
                            Filme filme = (Filme) produto;
                            if (filme.getTitulo().equals(tituloFilmeEscolhido)) {
                                filmeEscolhido = filme;
                                break; // Filme encontrado, encerra o loop
                            }
                        }
                    }

                    if (filmeEscolhido == null) {
                        System.out.println("Filme não encontrado.");
                        return; // Encerra o método caso o filme não seja encontrado
                    }

                    Sala salaDisponivel = null;
                    for (Sala sala : salas) {
                        if (sala.getFilme().equals(filmeEscolhido) && sala.getPoltronasDisponiveis() > 0) {
                            salaDisponivel = sala;
                            break; // Sala encontrada, encerra o loop
                        }
                    }

                    if (salaDisponivel == null) {
                        System.out.println("Não há salas disponíveis para o filme selecionado.");
                        return; // Encerra o método caso não haja sala disponível
                    }

                    salaDisponivel.reservarPoltrona();

                    Venda venda = new Venda(clienteSelecionado, balcaoAutomatico);
                    venda.adicionarItem(filmeEscolhido);

                    // Confirmar a venda
                    balcaoAutomatico.confirmarVenda(venda);
                    // Atualizar o estoque
                    meuEstoque.removerProduto(filmeEscolhido);
                }

                case "2" -> {

                }

                case "3" -> {

                    System.out.println("Verificação de Estoque:");
                    meuEstoque.verificarValidadeProdutos();
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
