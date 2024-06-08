/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipo;

/**
 * Representa uma classe que lida com transações de cartão de crédito.
 * Possui métodos para autenticação, verificação de saldo, processamento de pagamento e registro de transações.
 * 
 * Este é um protótipo simplificado e os métodos têm implementações simuladas.
 * 
 */

public class Credito {
    private static final double LIMIT = 10000.00; // Limite máximo para cartão de crédito

     /**
     * Realiza a autenticação do usuário no cartão de crédito.
     * 
     * @param userId ID do usuário.
     * @param password Senha do usuário.
     * @return true se a autenticação for bem-sucedida, false caso contrário.
     */
    public boolean authenticate(String userId, String password) {
        // Lógica de autenticação do cartão de crédito
        System.out.println("Usuario autenticado no cartao de credito.");
        return true;
    }

     /**
     * Verifica se o saldo disponível no cartão de crédito é suficiente para a transação.
     * 
     * @param userId ID do usuário.
     * @param amount Valor da transação.
     * @return true se o saldo for suficiente, false caso contrário.
     */
    public boolean checkBalance(String userId, double amount) {
        // Verifica se o limite do cartão de crédito é suficiente
        if (amount > LIMIT) {
            System.out.println("Valor excede o limite do cartao de credito.");
            return false;
        }
        System.out.println("Saldo verificado no cartao de credito.");
        return true;
    }

     /**
     * Realiza um pagamento único no cartão de crédito.
     * 
     * @param userId ID do usuário.
     * @param amount Valor do pagamento.
     */
    public void makePayment(String userId, double amount) {
        makePayment(userId, amount, 1); // Por padrão, não parcela
    }

     /**
     * Realiza um pagamento parcelado no cartão de crédito.
     * 
     * @param userId ID do usuário.
     * @param amount Valor total da transação.
     * @param installments Número de parcelas.
     */
    public void makePayment(String userId, double amount, int installments) {
        double installmentAmount = amount / installments;
        System.out.println("Pagamento parcelado em " + installments + " vezes de " + installmentAmount + " processado pelo cartao de credito.");
    }

     /**
     * Registra a transação no cartão de crédito.
     * 
     * @param userId ID do usuário.
     * @param amount Valor da transação.
     */
    public void logTransaction(String userId, double amount) {
        // Registra a transação do cartão de crédito
        System.out.println("Transacao registrada no cartao de credito.");
    }

    /**
     * Retorna uma representação em string do objeto Credito.
     * 
     * @return Uma representação em string do objeto Credito.
     */
    @Override
    public String toString() {
        return "Credito{" + '}';
    }
    
    
}

