/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema.gereciamentoDeVendas;

import Arquivo.Json;
import com.mycompany.prototipo.PaymentGateway;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import sistemadocinema.Cliente;
import sistemadocinema.Produto;

/**
 * Representa uma venda de produtos realizada em um balcão de atendimento.
 * Cada venda contém informações sobre o cliente, os produtos vendidos,
 * o valor total da venda, a data e hora da venda, o balcão de atendimento
 * onde a venda foi realizada e o método de pagamento utilizado.
 * Também fornece métodos para adicionar itens à venda, calcular o valor total,
 * gerar um extrato da venda e processar o pagamento.
 * 
 */
public class Venda {
    private Cliente cliente;
    private List<Produto> itensVendidos;
    private double valorTotal;
    private LocalDateTime dataHora;
    private BalcaoDeAtendimento balcao;
    private final PaymentGateway paymentGateway;

     /**
     * Constrói uma nova instância de Venda com base no cliente, balcão de atendimento
     * e método de pagamento especificados.
     * 
     * @param cliente o cliente que realizou a venda
     * @param balcao o balcão de atendimento onde a venda foi realizada
     * @param paymentGateway o método de pagamento utilizado na venda
     */
    public Venda(Cliente cliente, BalcaoDeAtendimento balcao, PaymentGateway paymentGateway) {
        this.cliente = cliente;
        this.itensVendidos = new ArrayList<>();
        this.dataHora = LocalDateTime.now();
        this.balcao = balcao;
        this.paymentGateway = paymentGateway;
    }

    /**
     * Adiciona um produto à lista de itens vendidos nesta venda.
     * 
     * @param produto o produto a ser adicionado à venda
     */
    public void adicionarItem(Produto produto) {
        itensVendidos.add(produto);
    }

    /**
     * Calcula o valor total da venda somando os valores de todos os itens vendidos.
     * 
     * @return o valor total da venda
     */
    public double calcularTotal() {
        valorTotal = 0.0;
        for (Produto produto : itensVendidos) {
            valorTotal += produto.getValor();
        }
        return valorTotal;
    }

    
    /**
     * Gera um extrato da venda contendo informações sobre o cliente, a data e hora,
     * o balcão de atendimento, os itens vendidos e o valor total da venda.
     * 
     * @return uma representação em formato de String do extrato da venda
     */
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
    
       
    /**
     * Processa o pagamento da venda verificando a autenticação do usuário e o saldo disponível.
     * 
     * @param userId o ID do usuário para autenticação
     * @param password a senha do usuário para autenticação
     * @return true se o pagamento for processado com sucesso, false caso contrário
     */
    public boolean processarPagamento(String userId, String password) {
        if (paymentGateway.authenticate(userId, password) && paymentGateway.checkBalance(userId, valorTotal)) {
            paymentGateway.processPayment(userId, valorTotal);
            paymentGateway.logTransaction(userId, valorTotal);
            return true;
        } else {
            System.out.println("Autenticacao, saldo insuficiente ou valor fora do limite.");
            return false;
        }
    }

       /**
     * Obtém o cliente associado à venda.
     * 
     * @return o cliente associado à venda
     */
    public Cliente getCliente() {
        return cliente;
    }

        /**
     * Define o cliente associado à venda.
     * 
     * @param cliente o cliente a ser associado à venda
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    /**
     * Obtém a lista de produtos vendidos nesta venda.
     * 
     * @return a lista de produtos vendidos nesta venda
     */
    public List<Produto> getItensVendidos() {
        return itensVendidos;
    }
    /**
     * Define a lista de produtos vendidos nesta venda.
     * 
     * @param itensVendidos a lista de produtos a ser definida para esta venda
     */
    public void setItensVendidos(List<Produto> itensVendidos) {
        this.itensVendidos = itensVendidos;
    }
    /**
     * Obtém o valor total da venda.
     * 
     * @return o valor total da venda
     */
    public double getValorTotal() {
        return valorTotal;
    }
    /**
     * Define o valor total da venda.
     * 
     * @param valorTotal o valor total a ser definido para esta venda
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    /**
     * Obtém a data e hora da venda.
     * 
     * @return a data e hora da venda
     */
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    /**
     * Define a data e hora da venda.
     * 
     * @param dataHora a data e hora a ser definida para esta venda
     */
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    /**
     * Obtém o balcão de atendimento onde a venda foi realizada.
     * 
     * @return o balcão de atendimento onde a venda foi realizada
     */
    public BalcaoDeAtendimento getBalcao() {
        return balcao;
    }
    /**
     * Define o balcão de atendimento onde a venda foi realizada.
     * 
     * @param balcao o balcão de atendimento a ser definido para esta venda
     */
    public void setBalcao(BalcaoDeAtendimento balcao) {
        this.balcao = balcao;
    }
    /**
     * Obtém o método de pagamento utilizado na venda.
     * 
     * @return o método de pagamento utilizado na venda
     */
    @Override
    public String toString() {
        return "Venda{"
                + "cliente=" + cliente
                + ", itensVendidos=" + itensVendidos
                + ", valorTotal=" + valorTotal
                + ", dataHora=" + dataHora
                + ", balcao=" + balcao
                + '}';
    }
}