/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipo;

/**
 *
 * @author daniel rodrigues
 */

public class CreditoAdapter implements PaymentGateway {
    private Credito credito;

    public CreditoAdapter(Credito credito) {
        this.credito = credito;
    }

    @Override
    public boolean authenticate(String userId, String password) {
        return credito.authenticate(userId, password);
    }

    @Override
    public boolean checkBalance(String userId, double amount) {
        return credito.checkBalance(userId, amount);
    }

    @Override
    public void processPayment(String userId, double amount) {
        credito.makePayment(userId, amount);
    }

    @Override
    public void logTransaction(String userId, double amount) {
        credito.logTransaction(userId, amount);
    }
}
