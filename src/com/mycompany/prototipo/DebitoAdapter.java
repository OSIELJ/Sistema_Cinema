/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipo;

/**
 *
 * @author daniel rodrigues
 */

public class DebitoAdapter implements PaymentGateway {
    private Debito debito;

    public DebitoAdapter(Debito debito) {
        this.debito = debito;
    }

    @Override
    public boolean authenticate(String userId, String password) {
        return debito.authenticate(userId, password);
    }

    @Override
    public boolean checkBalance(String userId, double amount) {
        return debito.checkBalance(userId, amount);
    }

    @Override
    public void processPayment(String userId, double amount) {
        debito.makePayment(userId, amount);
    }

    @Override
    public void logTransaction(String userId, double amount) {
        debito.logTransaction(userId, amount);
    }
}
