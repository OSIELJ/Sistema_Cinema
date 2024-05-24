/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipo;

/**
 *
 * @author daniel rodrigues
 */

public class Pix {
    public boolean authenticate(String userId, String password) {
        // Lógica de autenticação do Pix
        System.out.println("Usuario autenticado no Pix.");
        return true;
    }

    public boolean checkBalance(String userId, double amount) {
        // Verifica saldo disponível no Pix
        System.out.println("Saldo verificado para transacao via Pix.");
        return true;
    }

    public void makePayment(String userId, double amount) {
        System.out.println("Pagamento de " + amount + " processado via Pix.");
    }

    public void logTransaction(String userId, double amount) {
        // Registra a transação no Pix
        System.out.println("Transacao registrada com sucesso via Pix.");
    }
}

