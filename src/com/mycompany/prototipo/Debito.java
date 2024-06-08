/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.prototipo;

/**
 * Classe que representa a funcionalidade de um cartão de débito para o sistema de pagamento.
 * Fornece métodos para autenticação, verificação de saldo, processamento de pagamento e registro de transações.
 * 
 * @author daniel rodrigues
 */
public class Debito {
    /**
     * Realiza a autenticação do usuário no sistema de pagamento utilizando o cartão de débito.
     * 
     * @param userId ID do usuário.
     * @param password Senha do usuário.
     * @return true se a autenticação for bem-sucedida, false caso contrário.
     */
    public boolean authenticate(String userId, String password) {
        // Lógica de autenticação do cartão de débito
        System.out.println("Usuario autenticado no cartão de debito.");
        return true;
    }

    /**
     * Verifica se o saldo disponível na conta é suficiente para realizar a transação.
     * 
     * @param userId ID do usuário.
     * @param amount Valor da transação.
     * @return true se o saldo for suficiente, false caso contrário.
     */
    public boolean checkBalance(String userId, double amount) {
        // Verifica saldo disponível na conta
        System.out.println("Saldo verificado no cartao de debito.");
        return true;
    }

    /**
     * Realiza um pagamento utilizando o cartão de débito.
     * 
     * @param userId ID do usuário.
     * @param amount Valor do pagamento.
     */
    public void makePayment(String userId, double amount) {
        System.out.println("Pagamento de " + amount + " processado pelo cartao de debito.");
    }

    /**
     * Registra uma transação realizada com o cartão de débito.
     * 
     * @param userId ID do usuário.
     * @param amount Valor da transação.
     */
    public void logTransaction(String userId, double amount) {
        // Registra a transação do cartão de débito
        System.out.println("Transacao registrada no cartao de debito.");
    }

    /**
     * Retorna uma representação em string do objeto Debito.
     * 
     * @return Uma representação em string do objeto Debito.
     */
    @Override
    public String toString() {
        return "Debito{" + '}';
    }
}
