/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.prototipo;

/**
 * Classe que adapta a funcionalidade do cartão de crédito para o sistema de pagamento.
 * Implementa a interface PaymentGateway para fornecer métodos padronizados de autenticação, verificação de saldo,
 * processamento de pagamento e registro de transações.
 * 
 */
public class CreditoAdapter implements PaymentGateway {
    private Credito credito;

    /**
     * Construtor da classe CreditoAdapter.
     * 
     * @param credito Instância da classe Credito que será adaptada.
     */
    public CreditoAdapter(Credito credito) {
        this.credito = credito;
    }

    /**
     * Autentica o usuário no sistema de pagamento utilizando o cartão de crédito.
     * 
     * @param userId ID do usuário.
     * @param password Senha do usuário.
     * @return true se a autenticação for bem-sucedida, false caso contrário.
     */
    @Override
    public boolean authenticate(String userId, String password) {
        return credito.authenticate(userId, password);
    }

    /**
     * Verifica se o saldo disponível no cartão de crédito é suficiente para a transação.
     * 
     * @param userId ID do usuário.
     * @param amount Valor da transação.
     * @return true se o saldo for suficiente, false caso contrário.
     */
    @Override
    public boolean checkBalance(String userId, double amount) {
        return credito.checkBalance(userId, amount);
    }

    /**
     * Processa um pagamento utilizando o cartão de crédito.
     * 
     * @param userId ID do usuário.
     * @param amount Valor do pagamento.
     */
    @Override
    public void processPayment(String userId, double amount) {
        credito.makePayment(userId, amount);
    }

    /**
     * Registra a transação de pagamento utilizando o cartão de crédito.
     * 
     * @param userId ID do usuário.
     * @param amount Valor da transação.
     */
    @Override
    public void logTransaction(String userId, double amount) {
        credito.logTransaction(userId, amount);
    }

    /**
     * Retorna uma representação em string do objeto CreditoAdapter.
     * 
     * @return Uma representação em string do objeto CreditoAdapter.
     */
    @Override
    public String toString() {
        return "CreditoAdapter{" + "credito=" + credito + '}';
    }
}
