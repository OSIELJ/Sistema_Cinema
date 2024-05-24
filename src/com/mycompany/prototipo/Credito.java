/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipo;

/**
 *
 * @author daniel rodrigues
 */

public class Credito {
    private static final double LIMIT = 10000.00; // Limite máximo para cartão de crédito

    public boolean authenticate(String userId, String password) {
        // Lógica de autenticação do cartão de crédito
        System.out.println("Usuario autenticado no cartao de credito.");
        return true;
    }

    public boolean checkBalance(String userId, double amount) {
        // Verifica se o limite do cartão de crédito é suficiente
        if (amount > LIMIT) {
            System.out.println("Valor excede o limite do cartao de credito.");
            return false;
        }
        System.out.println("Saldo verificado no cartao de credito.");
        return true;
    }

    public void makePayment(String userId, double amount) {
        makePayment(userId, amount, 1); // Por padrão, não parcela
    }

    public void makePayment(String userId, double amount, int installments) {
        double installmentAmount = amount / installments;
        System.out.println("Pagamento parcelado em " + installments + " vezes de " + installmentAmount + " processado pelo cartao de credito.");
    }

    public void logTransaction(String userId, double amount) {
        // Registra a transação do cartão de crédito
        System.out.println("Transacao registrada no cartao de credito.");
    }
}

