/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipo;

/**
 *
 * @author daniel rodrigues
 */
public class Debito {
    public boolean authenticate(String userId, String password) {
        // Lógica de autenticação do cartão de débito
        System.out.println("Usuario autenticado no cartão de debito.");
        return true;
    }

    public boolean checkBalance(String userId, double amount) {
        // Verifica saldo disponível na conta
        System.out.println("Saldo verificado no cartao de debito.");
        return true;
    }

    public void makePayment(String userId, double amount) {
        System.out.println("Pagamento de " + amount + " processado pelo cartao de debito.");
    }

    public void logTransaction(String userId, double amount) {
        // Registra a transação do cartão de débito
        System.out.println("Transacao registrada no cartao de debito.");
    }

    @Override
    public String toString() {
        return "Debito{" + '}';
    }
    
    
}
