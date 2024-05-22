/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DesignPatterns;

/**
 *
 * @author daniel rodrigues
 */
public class SamsungPayAdapter implements PaymentGateway {
    private SamsungPay samsungpay;

    public SamsungPayAdapter(SamsungPay samsungpay) {
        this.samsungpay = samsungpay;
    }
    
    
    @Override
    public void processPayment(String amount) {
        samsungpay.makePayment(amount);
    }
    
}
