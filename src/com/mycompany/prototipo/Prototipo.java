/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prototipo;
import java.util.Scanner;

/**
 *
 * @author daniel rodrigues 
 */

public class Prototipo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tipo de pagamento (Pix/Credito/Debito): ");
        String paymentType = scanner.nextLine();

        System.out.println("Digite o ID do usuario: ");
        String userId = scanner.nextLine();

        System.out.println("Digite a senha: ");
        String password = scanner.nextLine();

        System.out.println("Digite o valor: ");
        double amount = scanner.nextDouble();

        PaymentGateway paymentGateway = getPaymentGateway(paymentType);

        if (paymentGateway == null) {
            System.out.println("Tipo de pagamento invalido.");
            return;
        }

        if (paymentGateway.authenticate(userId, password) && paymentGateway.checkBalance(userId, amount)) {
            paymentGateway.processPayment(userId, amount);
            paymentGateway.logTransaction(userId, amount);
        } else {
            System.out.println("Autenticacao, saldo insuficiente ou valor fora do limite.");
        }
    }

    private static PaymentGateway getPaymentGateway(String paymentType) {
        return switch (paymentType) {
            case "Pix" -> new PixAdapter(new Pix());
            case "Credito" -> new CreditoAdapter(new Credito());
            case "Debito" -> new DebitoAdapter(new Debito());
            default -> null;
        };
    }
}


