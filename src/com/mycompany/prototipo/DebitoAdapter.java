/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.prototipo;

/**
 * Classe que adapta a funcionalidade do cartão de débito para o sistema de pagamento,
 * implementando a interface PaymentGateway.
 * 
 * <p>Fornece métodos para autenticação, verificação de saldo, processamento de pagamento
 * e registro de transações.</p>
 * 
 */
public class DebitoAdapter implements PaymentGateway {
    private Debito debito;

    /**
     * Construtor da classe DebitoAdapter.
     * 
     * @param debito Instância da classe Debito a ser adaptada.
     */
    public DebitoAdapter(Debito debito) {
        this.debito = debito;
    }

    /**
     * Autentica o usuário no sistema de pagamento utilizando o cartão de débito.
     * 
     * @param userId ID do usuário.
     * @param password Senha do usuário.
     * @return true se a autenticação for bem-sucedida, false caso contrário.
     */
    @Override
    public boolean authenticate(String userId, String password) {
        return debito.authenticate(userId, password);
    }

    /**
     * Verifica se o saldo disponível na conta é suficiente para realizar a transação.
     * 
     * @param userId ID do usuário.
     * @param amount Valor da transação.
     * @return true se o saldo for suficiente, false caso contrário.
     */
    @Override
    public boolean checkBalance(String userId, double amount) {
        return debito.checkBalance(userId, amount);
    }

    /**
     * Processa um pagamento utilizando o cartão de débito.
     * 
     * @param userId ID do usuário.
     * @param amount Valor do pagamento.
     */
    @Override
    public void processPayment(String userId, double amount) {
        debito.makePayment(userId, amount);
    }

    /**
     * Registra uma transação realizada com o cartão de débito.
     * 
     * @param userId ID do usuário.
     * @param amount Valor da transação.
     */
    @Override
    public void logTransaction(String userId, double amount) {
        debito.logTransaction(userId, amount);
    }

    /**
     * Retorna uma representação em string do objeto DebitoAdapter.
     * 
     * @return Uma representação em string do objeto DebitoAdapter.
     */
    @Override
    public String toString() {
        return "DebitoAdapter{" + "debito=" + debito + '}';
    }
}
