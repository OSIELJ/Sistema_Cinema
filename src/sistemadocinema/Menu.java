/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import com.mycompany.prototipo.Credito;
import com.mycompany.prototipo.CreditoAdapter;
import com.mycompany.prototipo.Debito;
import com.mycompany.prototipo.DebitoAdapter;
import com.mycompany.prototipo.PaymentGateway;
import com.mycompany.prototipo.Pix;
import com.mycompany.prototipo.PixAdapter;
import java.util.List;
import java.util.Scanner;
import sistemadocinema.gereciamentoDeVendas.BalcaoDeAtendimento;
import sistemadocinema.gereciamentoDeVendas.GerenciarVendas;
import sistemadocinema.gereciamentoDeVendas.Venda;

/**
 * A classe Menu representa o menu principal do sistema de cinema.
 * Ela permite a interação do usuário com diversas funcionalidades, como a realização de vendas,
 * cadastro de clientes, verificação de estoque e geração de relatórios.
 * 
 * @see Usuario
 * @see Estoque
 * @see BalcaoDeAtendimento
 * @see Cliente
 * @see Sala
 * @see Funcionario
 * @see Venda
 */
public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final Usuario usuarioLogado;
    private final Estoque meuEstoque;
    private final BalcaoDeAtendimento balcaoAutomatico;
    private final List<Cliente> listaClientes;
    private final List<Sala> salas;
    private List<Funcionario> listaFuncionarios;
    private List<Venda> listaVendas;

    /**
     * Construtor da classe Menu.
     * 
     * @param usuarioLogado O usuário que está logado no sistema.
     * @param meuEstoque O estoque do cinema.
     * @param balcaoAutomatico O balcão de atendimento automático.
     * @param listaClientes A lista de clientes cadastrados.
     * @param salas A lista de salas de cinema.
     * @param ListaFuncionarios A lista de funcionários cadastrados.
     * @param listaVendas A lista de vendas realizadas.
     */
    public Menu(Usuario usuarioLogado, Estoque meuEstoque, BalcaoDeAtendimento balcaoAutomatico, List<Cliente> listaClientes,
            List<Sala> salas, List<Funcionario> ListaFuncionarios, List<Venda> listaVendas) {
        this.usuarioLogado = usuarioLogado;
        this.meuEstoque = meuEstoque;
        this.balcaoAutomatico = balcaoAutomatico;
        this.listaClientes = listaClientes;
        this.salas = salas;
        this.listaFuncionarios = listaFuncionarios;
        this.listaVendas = listaVendas;
    }

    
    /**
     * Exibe o menu principal de acordo com o tipo de usuário logado (Gerente ou Funcionario).
     */
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

    /**
     * Exibe o menu específico para o Gerente.
     * 
     * @param gerente O gerente logado.
     */
    private void exibirMenuGerente(Gerente gerente) {
        String opcao;
        while (true) {
            System.out.println("Bem-vindo, Gerente " + gerente.getNome() + "!");
            System.out.println("O que você deseja fazer?");
            System.out.println("1. Realizar venda");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Alterar Cliente");
            System.out.println("2. Excluir Cliente");
            System.out.println("5. Verificar estoque");
            System.out.println("6. Verificar rendimento diário ou mensal dos balcões");
            System.out.println("7. Cadastar Funcionario");
            System.out.println("8. Editar Funcionario");
            System.out.println("9. Sair");

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
                            break;
                        }
                    }

                    if (clienteSelecionado == null) {
                        System.out.println("Cliente não encontrado.");
                        return;
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
                                break;
                            }
                        }
                    }

                    if (filmeEscolhido == null) {
                        System.out.println("Filme não encontrado.");
                        return;
                    }

                    Sala salaDisponivel = null;
                    for (Sala sala : salas) {
                        if (sala.getFilme().equals(filmeEscolhido) && sala.getPoltronasDisponiveis() > 0) {
                            salaDisponivel = sala;
                            break;
                        }
                    }

                    if (salaDisponivel == null) {
                        System.out.println("Não há salas disponíveis para o filme selecionado.");
                        return;
                    }

                    salaDisponivel.reservarPoltrona();

                    System.out.println("Escolha o método de pagamento: credito, debito, pix");
                    String metodoPagamento = scanner.nextLine();
                    PaymentGateway gateway = getPaymentGateway(metodoPagamento);

                    if (gateway == null) {
                        System.out.println("Método de pagamento inválido.");
                        return;
                    }

                    System.out.println("Informe o usuário:");
                    String userId = scanner.nextLine();
                    System.out.println("Informe a senha:");
                    String password = scanner.nextLine();

                    Venda venda = new Venda(clienteSelecionado, balcaoAutomatico, gateway);
                    venda.adicionarItem(filmeEscolhido);
                    venda.calcularTotal();

                    if (venda.processarPagamento(userId, password)) {
                        balcaoAutomatico.confirmarVenda(venda);
                        meuEstoque.removerProduto(filmeEscolhido);
                        listaVendas.add(venda);
                        System.out.println("Venda realizada com sucesso.");
                    } else {
                        System.out.println("Falha no processamento do pagamento.");
                    }
                }

                case "2" -> {

                    System.out.println("Digite o Nome: ");
                    String nome = scanner.nextLine();

                    System.out.println("Digite o sobrenome: ");
                    String sobrenome = scanner.nextLine();

                    System.out.println("Informe o CPF do novo funcionário: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Informe o endereco: ");
                    String endereco = scanner.nextLine();

                    System.out.println("Informe o Telefone: ");
                    String telefone = scanner.nextLine();

                    Cliente ususario = new Cliente(nome, sobrenome, cpf, endereco, telefone);
                    
                     GerenciarCadastros gerenciarCadastros = new GerenciarCadastros(listaClientes, listaFuncionarios);
                     
                     gerenciarCadastros.cadastrarCliente(ususario);                
                        
                }
                case "3" -> {

                    GerenciarCadastros gerenciarCadastros = new GerenciarCadastros(listaClientes, listaFuncionarios);
                    System.out.println("Alterar Cliente:");

                    System.out.println("Informe o CPF do novo funcionário: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Informe o endereco: ");
                    String novoEndereco = scanner.nextLine();

                    System.out.println("Informe o Telefone: ");
                    String novoTelefone = scanner.nextLine();

                    gerenciarCadastros.editarCliente(cpf, novoTelefone, novoEndereco);

                }
                case "4" -> {

                    GerenciarCadastros gerenciarCadastros = new GerenciarCadastros(listaClientes, listaFuncionarios);
                    System.out.println("Excluir Cliente:");

                    System.out.println("Informe o CPF do novo funcionário: ");
                    String cpf = scanner.nextLine();

                    gerenciarCadastros.excluirCliente(cpf);

                }
                case "5" -> {
                    System.out.println("Verificação de Estoque:");
                    meuEstoque.verificarValidadeProdutos();
                }
                case "6" -> {

                    GerenciarVendas gerenciarVendas = new GerenciarVendas(listaVendas);

                    System.out.println("Verificar rendimento diário dos balcões:");
                    double rendimentoDiario = gerenciarVendas.calcularRendimentoDiario();
                    System.out.println("Rendimento diário: " + rendimentoDiario);

                }
                case "7" -> {
                    
                    GerenciarCadastros gerenciarCadastros = new GerenciarCadastros(listaClientes, listaFuncionarios);
                    System.out.println("Informe o nome do novo funcionário:");
                    String nome = scanner.nextLine();
                    System.out.println("Informe o CPF do novo funcionário:");
                    String cpf = scanner.nextLine();
                    System.out.println("Informe o nome de usuário do novo funcionário:");
                    String nomeUsuario = scanner.nextLine();
                    System.out.println("Informe a senha do novo funcionário:");
                    String senha = scanner.nextLine();

                    Funcionario novFuncionario = new Funcionario(nome, cpf, nomeUsuario, senha);
                    
                    gerenciarCadastros.cadastrarFuncionario(novFuncionario);
                    
                }
                case "8" -> {
                    
                    GerenciarCadastros gerenciarCadastros = new GerenciarCadastros(listaClientes, listaFuncionarios);
                    
                     System.out.println("8. Editar Funcionario");
                     
                    System.out.println("Informe o CPF do novo funcionário:");
                    String cpf = scanner.nextLine();
                    System.out.println("Informe o nome de usuário do novo funcionário:");
                    String nomeUsuario = scanner.nextLine();
                    System.out.println("Informe a senha do novo funcionário:");
                    String senha = scanner.nextLine();
                    
                    gerenciarCadastros.editarFuncionario(cpf, senha, nomeUsuario);
                    
                }
                case "9" -> {
                    System.out.println("Sessão encerrada.");
                    return;
                    
                }
                
                default ->
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

       /**
     * Exibe o menu específico para o Funcionario.
     * 
     * @param funcionario O funcionário logado.
     */
    private void exibirMenuFuncionario(Funcionario funcionario) {
        String opcao;
        while (true) {
            System.out.println("Bem-vindo, Funcionário " + funcionario.getNome() + "!");
            System.out.println("O que você deseja fazer?");
            System.out.println("1. Realizar venda");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Alterar Cliente");
            System.out.println("2. Excluir Cliente");
            System.out.println("5. Verificar estoque");
            System.out.println("6. Verificar rendimento diário ou mensal dos balcões");
            System.out.println("7. Sair");

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
                            break;
                        }
                    }

                    if (clienteSelecionado == null) {
                        System.out.println("Cliente não encontrado.");
                        return;
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
                                break;
                            }
                        }
                    }

                    if (filmeEscolhido == null) {
                        System.out.println("Filme não encontrado.");
                        return;
                    }

                    Sala salaDisponivel = null;
                    for (Sala sala : salas) {
                        if (sala.getFilme().equals(filmeEscolhido) && sala.getPoltronasDisponiveis() > 0) {
                            salaDisponivel = sala;
                            break;
                        }
                    }

                    if (salaDisponivel == null) {
                        System.out.println("Não há salas disponíveis para o filme selecionado.");
                        return;
                    }

                    salaDisponivel.reservarPoltrona();

                    System.out.println("Escolha o método de pagamento: credito, debito, pix");
                    String metodoPagamento = scanner.nextLine();
                    PaymentGateway gateway = getPaymentGateway(metodoPagamento);

                    if (gateway == null) {
                        System.out.println("Método de pagamento inválido.");
                        return;
                    }

                    System.out.println("Informe o usuário:");
                    String userId = scanner.nextLine();
                    System.out.println("Informe a senha:");
                    String password = scanner.nextLine();

                    Venda venda = new Venda(clienteSelecionado, balcaoAutomatico, gateway);
                    venda.adicionarItem(filmeEscolhido);
                    venda.calcularTotal();

                    if (venda.processarPagamento(userId, password)) {
                        balcaoAutomatico.confirmarVenda(venda);
                        meuEstoque.removerProduto(filmeEscolhido);
                        listaVendas.add(venda);
                        System.out.println("Venda realizada com sucesso.");
                    } else {
                        System.out.println("Falha no processamento do pagamento.");
                    }
                }

                case "2" -> {

                    System.out.println("Digite o Nome: ");
                    String nome = scanner.nextLine();

                    System.out.println("Digite o sobrenome: ");
                    String sobrenome = scanner.nextLine();

                    System.out.println("Informe o CPF do novo funcionário: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Informe o endereco: ");
                    String endereco = scanner.nextLine();

                    System.out.println("Informe o Telefone: ");
                    String telefone = scanner.nextLine();

                    Cliente ususario = new Cliente(nome, sobrenome, cpf, endereco, telefone);

                    listaClientes.add(ususario);

                }
                case "3" -> {

                    GerenciarCadastros gerenciarCadastros = new GerenciarCadastros(listaClientes, listaFuncionarios);
                    System.out.println("Alterar Cliente:");

                    System.out.println("Informe o CPF do novo funcionário: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Informe o endereco: ");
                    String novoEndereco = scanner.nextLine();

                    System.out.println("Informe o Telefone: ");
                    String novoTelefone = scanner.nextLine();

                    gerenciarCadastros.editarCliente(cpf, novoTelefone, novoEndereco);

                }
                case "4" -> {

                    GerenciarCadastros gerenciarCadastros = new GerenciarCadastros(listaClientes, listaFuncionarios);
                    System.out.println("Excluir Cliente:");

                    System.out.println("Informe o CPF do novo funcionário: ");
                    String cpf = scanner.nextLine();

                    gerenciarCadastros.excluirCliente(cpf);

                }
                case "5" -> {
                    System.out.println("Verificação de Estoque:");
                    meuEstoque.verificarValidadeProdutos();
                }
                case "6" -> {

                    GerenciarVendas gerenciarVendas = new GerenciarVendas(listaVendas);

                    System.out.println("Verificar rendimento diário dos balcões:");
                    double rendimentoDiario = gerenciarVendas.calcularRendimentoDiario();
                    System.out.println("Rendimento diário: " + rendimentoDiario);

                }
                case "7" -> {
                    System.out.println("Sessão encerrada.");
                    return;
                }
                default ->
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    /**
     * Obtém o adaptador de gateway de pagamento com base no tipo de pagamento.
     * 
     * @param tipoPagamento O tipo de pagamento (credito, debito, pix).
     * @return O adaptador de gateway de pagamento correspondente.
     */
    private static PaymentGateway getPaymentGateway(String tipoPagamento) {
        return switch (tipoPagamento.toLowerCase()) {
            case "credito" ->
                new CreditoAdapter(new Credito());
            case "debito" ->
                new DebitoAdapter(new Debito());
            case "pix" ->
                new PixAdapter(new Pix());
            default ->
                null;
        };
    }

    @Override
    public String toString() {
        return "Menu{" + "scanner=" + scanner + ", usuarioLogado=" + usuarioLogado + ", meuEstoque=" + meuEstoque + ", balcaoAutomatico=" + balcaoAutomatico + ", listaClientes=" + listaClientes + ", salas=" + salas + ", listaFuncionarios=" + listaFuncionarios + ", listaVendas=" + listaVendas + '}';
    }
    
    
}
