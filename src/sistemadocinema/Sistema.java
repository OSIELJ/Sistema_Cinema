/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import Arquivo.Json;
import com.mycompany.prototipo.Credito;
import com.mycompany.prototipo.CreditoAdapter;
import com.mycompany.prototipo.Debito;
import com.mycompany.prototipo.DebitoAdapter;
import com.mycompany.prototipo.PaymentGateway;
import com.mycompany.prototipo.Pix;
import com.mycompany.prototipo.PixAdapter;
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
        myEstoque.adicionarProduto(filme2);
        myEstoque.adicionarProduto(filme3);

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


                /*Questão 8:
                    Verificar e imprimir dados das vendas e dos clientes;
                 */
                System.out.println("-------------------------------------------------------------------");

                Cliente cliente1 = new Cliente("João", "Silva", "98765432100", "Rua A, 123", "123456789");
                Cliente cliente2 = new Cliente("Maria", "Souza", "12345678901", "Rua B, 456", "987654321");

                System.out.println("Escolha o método de pagamento: credito, debito, pix");
                String metodoPagamento = "pix";
                PaymentGateway gateway = getPaymentGateway(metodoPagamento);

                if (gateway == null) {
                    System.out.println("Método de pagamento inválido.");
                    return;
                }

                Venda venda1 = new Venda(cliente1, balcoes[4], gateway);
                venda1.adicionarItem(filme);
                venda1.adicionarItem(filme2);
                venda1.adicionarItem(pipoca);
                balcoes[4].confirmarVenda(venda1);
                myEstoque.removerProduto(filme);
                myEstoque.removerProduto(filme2);
                myEstoque.removerProduto(pipoca);
                listVendas.add(venda1);
                System.out.println("Venda realizada com sucesso.");

                Venda venda2 = new Venda(cliente2, balcoes[4], gateway);
                venda2.adicionarItem(filme3);
                venda2.adicionarItem(refrigerante);
                balcoes[4].confirmarVenda(venda2);
                myEstoque.removerProduto(filme3);
                myEstoque.removerProduto(refrigerante);
                listVendas.add(venda2);
                System.out.println("Venda realizada com sucesso.");

                gerenciarVendas.imprimirRelatorioVendas();
                System.out.println("-------------------------------------------------------------------");

                /*Questão 9:
                    Os produtos, filmes e os clientes devem ser salvos de forma dinâmica no sistema.
                 */
                System.out.println("-------------------------------------------------------------------");

                    
                
                
                
                
                System.out.println("-------------------------------------------------------------------");

                /*Questão 10:
                    Cada venda efetuada vai gerar um extrato que deverá ser impresso e salvo junto com a informação do cliente que fez a compra.
                
                    Nas linhas 49 ha 65 da classe venda onde gera o extrato: Código abaixo
                
                    public String getExtrato() {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    StringBuilder extrato = new StringBuilder();
                    extrato.append("Cliente: ").append(cliente.getNome()).append("\n");
                    extrato.append("CPF: ").append(cliente.getCpf()).append("\n");
                    extrato.append("Data e Hora: ").append(dataHora.format(formatter)).append("\n");
                    extrato.append("Balcão: ").append(balcao.getId()).append("\n");
                    extrato.append("Itens vendidos:\n");
                    for (Produto produto : itensVendidos) {
                         extrato.append("- ").append(produto.getNome()).append(": R$").append(produto.getValor()).append("\n");
                    }
                        extrato.append("Total: R$").append(calcularTotal());
        
                        return extrato.toString();
        
                   }
                
                    na linha 22 ha 27 tem o código onde salvo esse extrato no meu arqivo Json.
                
                    public void confirmarVenda(Venda venda) {
                    venda.calcularTotal(); // Calcula o total da venda
                    this.vendasConfirmadas.add(venda);
                    System.out.println("Venda realizada com sucesso!");
                    Json.salvarExtratoVenda(venda.getExtrato());
                }
                
                Exemplo de como esta salvando no meu arquivo extratoVenda.json
                
                "Cliente: João\nCPF: 98765432100\nData e Hora: 06/06/2024 11:07:45\nBalcão: 5\n
                Itens vendidos:\n- Os Incríveis: R$10.0\n- O Senhor dos Anéis: R$12.0\n- Pipoca: R$5.0\nTotal: R$27.0"
          
                 */
                
                
                
                
                  /*Questão 11:
                    
                    Criar duas variáveis de classe (static) que irão armazenar quantas instâncias foram criadas dos tipos Cliente dentro da classe Sistema usando duas soluções diferentes:
                    Uma delas utilizando o enfoque de encapsulamento de acordo com a engenharia de software (atributo private static e métodos get e set);
                    Na segunda estratégia, implementar usando o controle de acesso do tipo protect;
                    Explique quais são as vantagens e desvantagens de cada uma das duas estratégias.
                
                
                  Nas linhas 25 e 26 da classe Cliente tem o código:
                    
                        protected static int contadorClientes = 0;
                        private static int totalClientes = 0;
                
                
                            public Cliente(String nome, String sobrenome, String cpf, String endereco, String telefone) {
                                this.id = ++ultimoId;
                                this.nome = nome;
                                this.sobrenome = sobrenome;
                                this.cpf = cpf;
                                this.endereco = endereco;
                                this.telefone = telefone;
                            //  this.preferencias = preferencias;
                                totalClientes++;
                                contadorClientes++;
                           }
                
                    public static int getTotalClientes() {
                        return totalClientes;
                    }

                    public static void setTotalClientes(int totalClientes) {
                        Cliente.totalClientes = totalClientes;
                    }
                
                    Encapsulamento:

                    Vantagens:
                    Maior controle sobre o acesso às variáveis de classe. Os métodos get e set permitem uma manipulação segura dos valores.
                    Permite a validação de dados antes de serem atribuídos às variáveis.
                    Facilita a manutenção do código, pois quaisquer alterações internas na implementação das variáveis podem ser feitas sem afetar
                    o restante do código que as acessa.
                
                    Desvantagens:
                    Pode adicionar um pouco de sobrecarga devido à necessidade de escrever métodos get e set para cada variável,
                    o que pode ser redundante em alguns casos.
                    A necessidade de criar métodos get e set para cada variável pode aumentar a complexidade do código em classes com muitos atributos.
                
                    Controle de acesso do tipo protected:

                    Vantagens:
                    Mais flexibilidade no acesso às variáveis. Variáveis protegidas podem ser acessadas por subclasses,
                    o que pode ser útil em hierarquias de classes.
                    Evita a necessidade de escrever métodos get e set para cada variável, o que pode simplificar o código.
                
                    Desvantagens:
                    Menos controle sobre o acesso às variáveis, pois elas podem ser acessadas diretamente por subclasses.
                    Pode resultar em acoplamento mais forte entre classes, pois as subclasses têm acesso direto às variáveis protegidas.

          
                 */
                  
                  
                  /*Questão 12:
                        Criar um método de classe para classe Sistema que deverá retornar quantas instâncias foram criadas dos tipos Cliente e Produtos;
                   */
                    System.out.println("-------------------------------------------------------------------");

                    int totalClientes = Cliente.getTotalClientes();
                    System.out.println("Total de clientes: " + totalClientes);
                        
                    int totalAlimento = Alimenticios.getContadorProdutos();
                    System.out.println("Total de podruto do tipo alimentos: " + totalAlimento);
 
                    int totalFilme = Filme.getContadorProdutos();
                    System.out.println("Total de podruto do tipo Filme: " + totalFilme);
                    
                    
                    
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
}
