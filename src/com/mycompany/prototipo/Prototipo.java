/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.prototipo;
import java.util.Scanner;

/**
 * Classe principal que demonstra o uso de diferentes tipos de pagamento em um sistema.
 * 
 * <p>O {@code Prototipo} é um programa Java simples que permite ao usuário realizar pagamentos
 * usando diferentes métodos de pagamento, como Pix, cartão de crédito e cartão de débito.</p>
 * 
 * <p>O programa solicita ao usuário que insira o tipo de pagamento desejado (Pix, Crédito ou Débito),
 * o ID do usuário, a senha e o valor da transação. Com base no tipo de pagamento escolhido, o programa
 * cria um adaptador correspondente para o método de pagamento selecionado e utiliza esse adaptador para
 * autenticar o usuário, verificar o saldo e processar o pagamento.</p>
 * 
 * <p>Os métodos definidos nesta classe são:</p>
 * <ul>
 *     <li>{@code main}: método principal que executa o programa e interage com o usuário.</li>
 *     <li>{@code getPaymentGateway}: método auxiliar que cria um adaptador de gateway de pagamento com
 *     base no tipo de pagamento selecionado.</li>
 * </ul>
 * 
 * <p>Este programa demonstra o uso de adaptação de objetos para integrar diferentes sistemas ou interfaces,
 * permitindo que eles sejam usados de maneira transparente em um contexto comum.</p>
 * 
 * @author daniel rodrigues
 */
public class Prototipo {
    
    /**
     * Método principal que executa o programa e interage com o usuário.
     * 
     * @param args Argumentos da linha de comando (não são utilizados neste programa).
     */
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

    /**
     * Cria um adaptador de gateway de pagamento com base no tipo de pagamento selecionado.
     * 
     * @param paymentType Tipo de pagamento selecionado pelo usuário.
     * @return Um adaptador de gateway de pagamento correspondente ao tipo de pagamento selecionado,
     *         ou {@code null} se o tipo de pagamento for inválido.
     */
    private static PaymentGateway getPaymentGateway(String paymentType) {
        return switch (paymentType) {
            case "Pix" -> new PixAdapter(new Pix());
            case "Credito" -> new CreditoAdapter(new Credito());
            case "Debito" -> new DebitoAdapter(new Debito());
            default -> null;
        };
    }
}
