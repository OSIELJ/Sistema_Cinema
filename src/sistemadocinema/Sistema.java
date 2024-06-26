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
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import sistemadocinema.gereciamentoDeVendas.BalcaoAutomatico;
import sistemadocinema.gereciamentoDeVendas.ComparatorDataHoraVenda;
import sistemadocinema.gereciamentoDeVendas.ComparatorValorVenda;
import sistemadocinema.gereciamentoDeVendas.GerenciarVendas;

/**
 * Representa o sistema de cinema, responsável por gerenciar operações como cadastro de clientes,
 * funcionários, filmes, vendas, entre outras.
 *
 * @author Osiel Junior
 */
public class Sistema {

    private static final BalcaoDeAtendimento[] balcoes = new BalcaoDeAtendimento[5];

    /**
     * Método principal que inicia o sistema de cinema.
     *
     * @param args os argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        
       

 
  

                Cliente c = new Cliente("nome", "sobrenome", "13441301609", "endereco", "telefone");
                Cliente cliente1 = new Cliente("João", "Silva", "98765432100", "Rua A, 123", "123456789");
                Cliente cliente2 = new Cliente("Maria", "Souza", "12345678901", "Rua B, 456", "987654321");
                 Cliente cliente3 = new Cliente("Ana", "Oliveira", "45678901234", "Rua C, 789", "987654321");
                Cliente cliente4 = new Cliente("Pedro", "Santos", "67890123456", "Rua D, 1011", "123456789");

        List<Venda> listVendas = new ArrayList<>();
        List<Cliente> listaClientes = new ArrayList<>();
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        List<Filme> listaFilmes = new ArrayList<>();
        List<Alimenticios> listaAlimenticios = new ArrayList<>();
        
        
        
        

        GerenciarCadastros gerenciarCadastros = new GerenciarCadastros(listaClientes, listaFuncionarios);

        Gerente myGerente = new Gerente("Osiel Junior", "13441301609", "Osiel", "Osiel123");
        Funcionario myFuncionario = new Funcionario("Daniel Rodrigues", "01602001506", "Daniel", "Daniel123");
        
        Funcionario myFuncionario2 = new Funcionario("Arthur Abreu", "01602001000", "arthur", "123");
        
        Funcionario myFuncionario3 = new Funcionario("Enzo velozo", "01602000000", "Enzo", "123");

        listaFuncionarios.add(myFuncionario);
        listaFuncionarios.add(myFuncionario2);
        listaFuncionarios.add(myFuncionario3);
        
        
        

        GerenciarVendas gerenciarVendas = new GerenciarVendas(listVendas);
        balcoes[4] = new BalcaoAutomatico(5, myFuncionario, gerenciarVendas);
        balcoes[3] = new BalcaoAutomatico(4, myFuncionario, gerenciarVendas);
        balcoes[2] = new BalcaoAutomatico(3, myFuncionario, gerenciarVendas);
        balcoes[1] = new BalcaoAutomatico(2, myFuncionario, gerenciarVendas);
        balcoes[0] = new BalcaoAutomatico(1, myFuncionario, gerenciarVendas);
        
        
        
        Alimenticios pipoca = new Alimenticios("Pipoca", LocalDate.of(2024, 12, 31), 5.0, 100);
        Alimenticios refrigerante = new Alimenticios("Refrigerante", LocalDate.of(2024, 12, 31), 3.0, 200);
        Alimenticios chocolate = new Alimenticios("Chocolate", LocalDate.of(2023, 12, 31), 3.0, 200);
        Alimenticios biscoitos = new Alimenticios("Biscoitos", LocalDate.of(2023, 10, 15), 2.5, 150);
        Alimenticios sorvete = new Alimenticios("Sorvete", LocalDate.of(2024, 12, 31), 6.0, 120);
        Alimenticios salgadinho = new Alimenticios("Salgadinho", LocalDate.of(2024, 12, 31), 4.0, 180);
        Alimenticios doce = new Alimenticios("Doce", LocalDate.of(2024, 12, 31), 3.5, 200); 
        Alimenticios sucoVencido = new Alimenticios("Suco de Laranja", LocalDate.of(2024, 4, 30), 4.0, 50);
        Alimenticios salgadinhoVencido = new Alimenticios("Salgadinho", LocalDate.of(2024, 3, 15), 3.0, 80);        
        
        listaAlimenticios.add(pipoca);
        listaAlimenticios.add(refrigerante);
        listaAlimenticios.add(chocolate);
        listaAlimenticios.add(sorvete);
        listaAlimenticios.add(salgadinho);
        listaAlimenticios.add(doce);        
        listaAlimenticios.add(sucoVencido);
        listaAlimenticios.add(salgadinhoVencido);          
        
        
        
        Filme filme = new Filme("Os Incríveis", "Animação", LocalDate.of(2024, 5, 1), 10.0, 100, "10 dias");
        Filme filme2 = new Filme("O Senhor dos Anéis", "Fantasia", LocalDate.of(2024, 6, 15), 12.0, 150, "15 dias");
        Filme filme3 = new Filme("Matrix", "Ficção Científica", LocalDate.of(2024, 7, 30), 11.0, 120, "12 dias");
        Filme filme4 = new Filme("Harry Potter e a Pedra Filosofal", "Fantasia", LocalDate.of(2024, 8, 10), 15.0, 180, "14 dias");
        Filme filme5 = new Filme("Interestelar", "Ficção Científica", LocalDate.of(2024, 9, 25), 13.0, 160, "13 dias");
        Filme filme6 = new Filme("Forrest Gump", "Drama", LocalDate.of(2024, 10, 20), 11.0, 140, "10 dias");
        Filme filme7 = new Filme("O Poderoso Chefão", "Drama", LocalDate.of(2024, 3, 10), 11.0, 120, "10 dias");
        Filme filme8 = new Filme("Crepúsculo", "Romance", LocalDate.of(2024, 2, 5), 9.0, 100, "8 dias");
        
        
        listaFilmes.add(filme4);
        listaFilmes.add(filme5);
        listaFilmes.add(filme6);        
        listaFilmes.add(filme);
        listaFilmes.add(filme2);
        listaFilmes.add(filme3);
        listaFilmes.add(filme7);
        listaFilmes.add(filme8);
        
        

        Sala sala1 = new Sala(filme, 80);
        Sala sala2 = new Sala(filme2, 100);
        Sala sala3 = new Sala(filme3, 90);
        Sala sala4 = new Sala(filme4, 120);
        Sala sala5 = new Sala(filme5, 150);
        Sala sala6 = new Sala(filme6, 100);

        List<Sala> salas = new ArrayList<>();
        salas.add(sala1);
        salas.add(sala2);
        salas.add(sala3);
        salas.add(sala4);
        salas.add(sala5);
        salas.add(sala6);

        

        Estoque myEstoque = new Estoque();
        myEstoque.adicionarProduto(pipoca);
        myEstoque.adicionarProduto(refrigerante);
        myEstoque.adicionarProduto(chocolate);
        myEstoque.adicionarProduto(filme);
        myEstoque.adicionarProduto(filme2);
        myEstoque.adicionarProduto(filme3);
        myEstoque.adicionarProduto(biscoitos);
        myEstoque.adicionarProduto(sorvete);
        myEstoque.adicionarProduto(salgadinho);
        myEstoque.adicionarProduto(doce);
        myEstoque.adicionarProduto(filme4);
        myEstoque.adicionarProduto(filme5);
        myEstoque.adicionarProduto(filme6);
        myEstoque.adicionarProduto(filme7);
        myEstoque.adicionarProduto(filme8);
        myEstoque.adicionarProduto(sucoVencido);
        myEstoque.adicionarProduto(salgadinhoVencido);        
        
        
        

        Scanner scanner = new Scanner(System.in);
        String nomeUsuario, senha;

        listaClientes.add(c);

        System.out.println("-------------------------------------------------------------------");        
        myEstoque.verificarValidadeProdutos();
        System.out.println("-------------------------------------------------------------------");
                
                
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
        Na linha 30 dessa classe tem esse código:
        private static final BalcaoDeAtendimento[] balcoes = new BalcaoDeAtendimento[5];
 
        Na linha 51 há 55 de classe Sistema tem esse código:
        balcoes[4] = new BalcaoAutomatico(5, myFuncionario, gerenciarVendas);
        balcoes[3] = new BalcaoAutomatico(5, myFuncionario, gerenciarVendas);
        balcoes[2] = new BalcaoAutomatico(5, myFuncionario, gerenciarVendas);
        balcoes[1] = new BalcaoAutomatico(5, myFuncionario, gerenciarVendas);
        balcoes[0] = new BalcaoAutomatico(5, myFuncionario, gerenciarVendas);
                
      
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



                
                listaClientes.add(cliente1);
                listaClientes.add(cliente2);
                listaClientes.add(cliente3);
                listaClientes.add(cliente4);                
                

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
                
                
                Venda venda3 = new Venda(cliente3, balcoes[3], gateway);
                venda3.adicionarItem(filme7);
                venda3.adicionarItem(salgadinho);
                balcoes[3].confirmarVenda(venda3);
                myEstoque.removerProduto(filme7);
                myEstoque.removerProduto(salgadinho);
                listVendas.add(venda3);
                System.out.println("Venda realizada com sucesso.");
                
                

                Venda venda4 = new Venda(cliente4, balcoes[2], gateway);
                venda4.adicionarItem(filme8);
                venda4.adicionarItem(chocolate);
                balcoes[2].confirmarVenda(venda4);
                myEstoque.removerProduto(filme8);
                myEstoque.removerProduto(chocolate);
                listVendas.add(venda4);
                System.out.println("Venda realizada com sucesso.");                

                gerenciarVendas.imprimirRelatorioVendas();
                System.out.println("-------------------------------------------------------------------");

                /*Questão 9:
                 Os produtos, filmes e os clientes devem ser salvos de forma dinâmica no sistema.
                
                
                clientes dinamicamente:

                Dentro do método main da classe Sistema, instâncias de Cliente são
                criadas e adicionadas à lista listaClientes
                através do método cadastrarCliente do objeto gerenciarCadastros (instância de GerenciarCadastros).
                
                    public GerenciarCadastros(List<Cliente> listaClientes, List<Funcionario> listaFuncionarios) {
                        this.listaClientes = new ArrayList<>();
                        this.listaFuncionarios = new ArrayList<>();
                    }

                
                    public void cadastrarCliente(Cliente cliente) {
                        if (!existe(cliente.getCpf(), cliente)) {
                             listaClientes.add(cliente);
                             System.out.println("Cliente cadastrado com sucesso!");
                        } else {
                        System.out.println("Cliente já esta cadastrado!");
                        }
                    }
                
                
                
                
                
                Produtos e Filmes dinamicamente
                
                Filmes e clientes são adicionados de forma dinâmica ao sistema através do método
                adicionarProduto da classe Estoque e da criação de instâncias de Alimenticios e Filmes
                por que os dois herdam de Produto
                dentro do método main da classe Sistema
                
                    public Estoque() {
                        this.produtos = new ArrayList<>();
                    }
    
    


                    public void adicionarProduto(Produto produto) {
                        produtos.add(produto);
                        System.out.println("Produto adicionado com sucesso!");
                    }
        
                
                 
                
                 */


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
                    
                    
                    
                    
                  
                   /*Questão 13:
                        Implementar a interface Comparator para as classes Filme e Venda e fazer comparações por diferentes atributos.

                   */
                    System.out.println("-------------------------------------------------------------------");
                    
                     
                     Collections.sort(listaFilmes, new ComparatorFilmeValor());
                     System.out.println("\nFilmes ordenados por Valor:");
                        for (Filme meuFilme : listaFilmes) {
                            System.out.println(meuFilme);
                        }                     
                     
                        
                     System.out.println("-------------------------------------------------------------------");    
                     
                     
                     
                     Collections.sort(listaFilmes, new ComparatorEstiloFilme());
                     System.out.println("\nFilmes ordenados por estilo:");
                        for (Filme meuFilme : listaFilmes) {
                            System.out.println(meuFilme);
                        }
                        
                        
                     
                     System.out.println("-------------------------------------------------------------------");                    
                     
                     
                     
   
                     Collections.sort(listVendas, new ComparatorValorVenda());
                        System.out.println("Vendas ordenadas por valor:");
                        for (Venda minhaVenda : listVendas) {
                            System.out.println(minhaVenda);
                        }                    
                     
                    System.out.println("-------------------------------------------------------------------");                  
                    
                    
                    
                     
                     Collections.sort(listVendas, new ComparatorDataHoraVenda());
                         System.out.println("Vendas ordenadas pela Data:");
                        for (Venda minhaVenda : listVendas) {
                            System.out.println(minhaVenda);
                        }                         
                     
                    
                    
                    System.out.println("-------------------------------------------------------------------");
                    
                    
                    
               
                   /*Questão 14:
                        Salve e recupere todas as informações dos Clientes, Filmes, Produtos, Vendas, Colaboradores e Estoque
                    em um arquivo de texto. Utilizem classes já prontas na internet que trabalhem com o formato json.
                    Ao manipular um arquivo utilize os conceitos aprendidos em aula para alocar e desalocar recursos com segurança. 
                   */
                   
                    System.out.println("-------------------------------------------------------------------");

                    
                    Json.salvarClientes(listaClientes);
                    Json.salvarFuncionario(listaFuncionarios);
                    Json.salvarVendas(listVendas);
                    Json.salvarFilme(listaFilmes);
                    Json.salvarAlimenticios(listaAlimenticios);
                    Json.salvarEstoque(myEstoque);
                    
                    
                    
                    System.out.println("-------------------------------------------------------------------");   
                    
                    
                    
                                   
                     /*Questão 15:
                        Gerar um JavaDoc de todo o seu projeto.
                   */
                     
                     
                    
                    
                     /*Questão 15:
                        Instaciar um iterator para a arraylist de pessoas/funcionario/cliente (qual estiver usando)
                        Fazer testes no main em pecorrer o arraylist com chamadas usando o código: 
                        while(iterator.hasnext())
                        { 
                            imprimir(iterator.next());
                        }

                        Explicar como isso está acontecendo.
                        Qual relação do código acima com o foreach em java?

                        Testar o foreach.
                   */
                    System.out.println("-------------------------------------------------------------------");
                    

                    Iterator<Cliente> iterator1 = listaClientes.iterator();
                    
                    System.out.println("Detalhes dos clientes:");
                    while (iterator1.hasNext()) {
                        Cliente cliente = iterator1.next();
                        System.out.println(cliente); // Utiliza o método toString() para imprimir os detalhes do cliente
                    }
                    
                     /*Relação com o foreach em Java:
                     O foreach em Java é uma construção de loop conveniente e simplificada para percorrer coleções de elementos, como listas, arrays, conjuntos, entre outros.
                     Internamente, ele utiliza um Iterator para percorrer a coleção, facilitando a iteração.
                     No código anterior, a utilização do Iterator segue uma abordagem mais tradicional para percorrer e acessar os elementos de uma lista.
                     O Iterator permite a iteração segura e a manipulação de elementos durante a iteração.
                      A mesma operação de percorrer a lista de clientes utilizando o foreach:
                     */
                     
                     
                    System.out.println();
                    System.out.println("Detalhes dos clientes utilizando foreach:");
                    for (Cliente cliente : listaClientes) {
                        System.out.println(cliente);
                    }

                    
                    System.out.println("-------------------------------------------------------------------");                    
                    
                    
                    
                      /*Questão 16:
                    
                    Apresentar no main testes do comparator implementado.

                    Utilizar e apresentar no main a aplicação do método sort da classe collections passando o comparator criado
                    para ordenar a lista de pessoas/usuario/cliente (qual estiver usando) com dois paramêtros diferentes.
                    Ou seja, rodar duas vezes.

                   */
                    System.out.println("-------------------------------------------------------------------");
                    
                            Collections.sort(listaClientes, new ComparatorNomeCliente());
                            System.out.println("Clientes ordenados por nome:");
                            for (Cliente cliente : listaClientes) {
                                 System.out.println(cliente);
                              }

                    System.out.println("-------------------------------------------------------------------");                     
                            
                            
                            Collections.sort(listaClientes, new ComparatorCpfCliente());
                            System.out.println("\nClientes ordenados por CPF:");
                            for (Cliente cliente : listaClientes) {
                                System.out.println(cliente);
                            }                               
                            
                            
                    System.out.println("-------------------------------------------------------------------");     
                    
                    
                    
                    

                    /*Questão 17:
                        
                        Criar um método find para clientes utilizando o interator e comparator. Apresentar testes do método implementado.
                    
                   */
                    System.out.println("-------------------------------------------------------------------");
                    
                    ControleClientes controle = new ControleClientes(listaClientes);
                    Comparator<Cliente> comparatorPorNome = new ComparatorNomeCliente();
                    Cliente primeiroClientePorNome = controle.find(comparatorPorNome);
                        if (primeiroClientePorNome != null) {
                             System.out.println("Primeiro cliente por nome encontrado: " + primeiroClientePorNome);
                        } else {
                            System.out.println("Nenhum cliente encontrado por nome.");
                     }


                    
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
                        
                        System.out.println("Selecione qual balcão |0 1 2 3 4| "); 
                        int balcaoSelecionado = scanner.nextInt();                        
                        
                        
                        Menu menu = new Menu(usuarioLogado, myEstoque, balcoes[balcaoSelecionado], listaClientes,
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

/**
 * Retorna o gateway de pagamento correspondente ao tipo de pagamento fornecido.
 *
 * @param tipoPagamento O tipo de pagamento para o qual obter o gateway.
 * @return O gateway de pagamento correspondente ao tipo fornecido, ou null se o tipo não for reconhecido.
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
}
