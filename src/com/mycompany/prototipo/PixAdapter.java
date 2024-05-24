/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipo;

/**
 *
 * @author daniel rodrigues
 */

public class PixAdapter implements PaymentGateway {
    private Pix pix;

    public PixAdapter(Pix pix) {
        this.pix = pix;
    }

    @Override
    public boolean authenticate(String userId, String password) {
        return pix.authenticate(userId, password);
    }

    @Override
    public boolean checkBalance(String userId, double amount) {
        return pix.checkBalance(userId, amount);
    }

    @Override
    public void processPayment(String userId, double amount) {
        pix.makePayment(userId, amount);
    }

    @Override
    public void logTransaction(String userId, double amount) {
        pix.logTransaction(userId, amount);
    }
}
