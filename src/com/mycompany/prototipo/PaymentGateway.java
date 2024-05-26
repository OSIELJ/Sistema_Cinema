/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipo;

/**
 *
 * @author daniel rodrigues 
 */

public interface PaymentGateway {
    boolean authenticate(String userId, String password);
    boolean checkBalance(String userId, double amount);
    void processPayment(String userId, double amount);
    void logTransaction(String userId, double amount);
}

