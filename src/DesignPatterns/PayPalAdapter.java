/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DesignPatterns;

/**
 *
 * @author danie
 */
public class PayPalAdapter implements PaymentGateway {
    private PayPal paypal;
    
    public PayPalAdapter(PayPal paypal) {
        this.paypal = paypal;
    }
    
    @Override
    public void processPayment(String amount) {
        paypal.sendPayment(amount);
    }
    
}
