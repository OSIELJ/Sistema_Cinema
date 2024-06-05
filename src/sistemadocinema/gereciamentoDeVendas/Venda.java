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
 *
 * @author Osiel Junior e Daniel Rodrigues
 */
public class Venda {
    private Cliente cliente;
    private List<Produto> itensVendidos;
    private double valorTotal;
    private LocalDateTime dataHora;
    private BalcaoDeAtendimento balcao;
    private final PaymentGateway paymentGateway;

    public Venda(Cliente cliente, BalcaoDeAtendimento balcao, PaymentGateway paymentGateway) {
        this.cliente = cliente;
        this.itensVendidos = new ArrayList<>();
        this.dataHora = LocalDateTime.now();
        this.balcao = balcao;
        this.paymentGateway = paymentGateway;
    }

    public void adicionarItem(Produto produto) {
        itensVendidos.add(produto);
    }

    public double calcularTotal() {
        valorTotal = 0.0;
        for (Produto produto : itensVendidos) {
            valorTotal += produto.getValor();
        }
        return valorTotal;
    }

   public String getExtrato() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        StringBuilder extrato = new StringBuilder();
        extrato.append("Cliente: ").append(cliente.getNome()).append("\n");
        extrato.append("Data e Hora: ").append(dataHora.format(formatter)).append("\n");
        extrato.append("Balcão: ").append(balcao.getId()).append("\n");
        extrato.append("Itens vendidos:\n");
        for (Produto produto : itensVendidos) {
            extrato.append("- ").append(produto.getNome()).append(": R$").append(produto.getValor()).append("\n");
        }
        extrato.append("Total: R$").append(calcularTotal());
        Json.salvarExtratoVenda(extrato.toString());
        return extrato.toString();
    }
    
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getItensVendidos() {
        return itensVendidos;
    }

    public void setItensVendidos(List<Produto> itensVendidos) {
        this.itensVendidos = itensVendidos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public BalcaoDeAtendimento getBalcao() {
        return balcao;
    }

    public void setBalcao(BalcaoDeAtendimento balcao) {
        this.balcao = balcao;
    }

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