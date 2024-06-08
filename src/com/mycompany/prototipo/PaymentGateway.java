/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.prototipo;

/**
 * Interface que define os métodos necessários para um gateway de pagamento.
 * 
 * <p>Implementações desta interface devem fornecer funcionalidades para autenticação
 * do usuário, verificação de saldo, processamento de pagamento e registro de transações.</p>
 * 
 * <p>Essa interface é usada para padronizar o acesso aos diferentes tipos de gateway de pagamento,
 * permitindo que o sistema de pagamento interaja de forma consistente com diferentes sistemas de
 * pagamento, como cartões de crédito, cartões de débito, Pix, entre outros.</p>
 * 
 * <p>Os métodos definidos nesta interface são:</p>
 * <ul>
 *     <li>{@code authenticate}: para autenticar o usuário no sistema de pagamento.</li>
 *     <li>{@code checkBalance}: para verificar se o saldo disponível na conta é suficiente.</li>
 *     <li>{@code processPayment}: para processar um pagamento.</li>
 *     <li>{@code logTransaction}: para registrar uma transação.</li>
 * </ul>
 * 
 * <p>Implementações desta interface devem ser capazes de lidar com diferentes tipos de transações
 * e sistemas de pagamento.</p>
 * 
 * @author daniel rodrigues
 */
public interface PaymentGateway {
    /**
     * Autentica o usuário no sistema de pagamento.
     * 
     * @param userId ID do usuário.
     * @param password Senha do usuário.
     * @return {@code true} se a autenticação for bem-sucedida, {@code false} caso contrário.
     */
    boolean authenticate(String userId, String password);

    /**
     * Verifica se o saldo disponível na conta é suficiente para realizar a transação.
     * 
     * @param userId ID do usuário.
     * @param amount Valor da transação.
     * @return {@code true} se o saldo for suficiente, {@code false} caso contrário.
     */
    boolean checkBalance(String userId, double amount);

    /**
     * Processa um pagamento.
     * 
     * @param userId ID do usuário.
     * @param amount Valor do pagamento.
     */
    void processPayment(String userId, double amount);

    /**
     * Registra uma transação realizada.
     * 
     * @param userId ID do usuário.
     * @param amount Valor da transação.
     */
    void logTransaction(String userId, double amount);
}
