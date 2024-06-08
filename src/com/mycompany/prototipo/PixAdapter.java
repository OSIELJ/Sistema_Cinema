/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.prototipo;

/**
 * Classe que representa um adaptador para integrar o sistema de pagamento Pix com outros sistemas.
 * 
 * <p>O {@code PixAdapter} permite que o sistema de pagamento Pix seja integrado com outros sistemas
 * de pagamento por meio da implementação da interface {@link com.mycompany.prototipo.PaymentGateway}.</p>
 * 
 * <p>Esta classe encapsula as funcionalidades do sistema Pix e as adapta para serem compatíveis com a
 * interface {@code PaymentGateway}, permitindo assim que o Pix seja usado como uma opção de pagamento
 * em sistemas que requerem uma abstração comum para processar pagamentos.</p>
 * 
 * <p>Os métodos definidos nesta classe são:</p>
 * <ul>
 *     <li>{@code authenticate}: para autenticar o usuário no sistema Pix.</li>
 *     <li>{@code checkBalance}: para verificar o saldo disponível na conta para uma transação.</li>
 *     <li>{@code processPayment}: para processar um pagamento via Pix.</li>
 *     <li>{@code logTransaction}: para registrar uma transação realizada no sistema Pix.</li>
 * </ul>
 * 
 * <p>Esta classe é usada para adaptar o sistema Pix para atuar como um {@code PaymentGateway} em
 * sistemas que requerem uma interface comum para processar pagamentos.</p>
 * 
 * <p>Para integrar o Pix com outros sistemas, basta criar uma instância desta classe passando um
 * objeto {@code Pix} como parâmetro e, em seguida, usar a instância criada para processar pagamentos.</p>
 * 
 * @author daniel rodrigues
 */
public class PixAdapter implements PaymentGateway {
    private Pix pix;

    /**
     * Cria um novo adaptador para o sistema Pix.
     * 
     * @param pix Objeto Pix a ser adaptado.
     */
    public PixAdapter(Pix pix) {
        this.pix = pix;
    }

    /**
     * Autentica o usuário no sistema Pix.
     * 
     * @param userId ID do usuário.
     * @param password Senha do usuário.
     * @return {@code true} se a autenticação for bem-sucedida, {@code false} caso contrário.
     */
    @Override
    public boolean authenticate(String userId, String password) {
        return pix.authenticate(userId, password);
    }

    /**
     * Verifica o saldo disponível na conta para uma transação via Pix.
     * 
     * @param userId ID do usuário.
     * @param amount Valor da transação.
     * @return {@code true} se o saldo for suficiente para a transação, {@code false} caso contrário.
     */
    @Override
    public boolean checkBalance(String userId, double amount) {
        return pix.checkBalance(userId, amount);
    }

    /**
     * Processa um pagamento via Pix.
     * 
     * @param userId ID do usuário.
     * @param amount Valor do pagamento.
     */
    @Override
    public void processPayment(String userId, double amount) {
        pix.makePayment(userId, amount);
    }

    /**
     * Registra uma transação realizada no sistema Pix.
     * 
     * @param userId ID do usuário.
     * @param amount Valor da transação.
     */
    @Override
    public void logTransaction(String userId, double amount) {
        pix.logTransaction(userId, amount);
    }

    /**
     * Retorna uma representação em formato de string do adaptador PixAdapter.
     * 
     * @return Uma string representando o adaptador PixAdapter.
     */
    @Override
    public String toString() {
        return "PixAdapter{" + "pix=" + pix + '}';
    }
}
