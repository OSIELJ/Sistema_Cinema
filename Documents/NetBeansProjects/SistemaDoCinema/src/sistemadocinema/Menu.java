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
    private BalcaoDeAtendimento balcaoAutomatico;
    private List<Cliente> listaClientes;

    public Menu(Usuario usuarioLogado, Estoque meuEstoque, BalcaoDeAtendimento balcaoAutomatico, List<Cliente> listaClientes) {
        this.usuarioLogado = usuarioLogado;
        this.meuEstoque = meuEstoque;
        this.balcaoAutomatico = balcaoAutomatico;
        this.listaClientes = listaClientes;
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

                    for (Cliente cliente : listaClientes) {
                        if (cliente.getCpf().equals(cpf)) {
                            return cliente; // Retorna o cliente encontrado
                        }
                    }

                    Cliente clienteSelecionado = selecionarCliente();
                    if (clienteSelecionado != null) {
                        System.out.println("Lista de produtos disponíveis:");
                        meuEstoque.listarProdutosDisponiveis();
                        // Aqui você precisará selecionar os produtos a serem vendidos
                        List<Produto> produtosSelecionados = selecionarProdutos();
                        if (!produtosSelecionados.isEmpty()) {
                            Venda venda = new Venda(clienteSelecionado, balcaoAutomatico);
                            for (Produto produto : produtosSelecionados) {
                                venda.adicionarItem(produto);
                            }

                            // Confirmar a venda
                            balcaoAutomatico.confirmarVenda(venda);
                            // Atualizar o estoque
                            for (Produto produto : produtosSelecionados) {
                                meuEstoque.removerProduto(produto);
                            }
                        } else {
                            System.out.println("Nenhum produto selecionado. Cancelando venda.");
                        }
                    } else {
                        System.out.println("Nenhum cliente selecionado. Cancelando venda.");
                    }
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
