package sistemadocinema;

import java.util.List;

/**
 * A classe Funcionario representa um funcionário do sistema de cinema.
 * Herda propriedades da classe Usuario e inclui funcionalidades adicionais específicas para funcionários.
 * 
 * @author Osiel Junior
 */
public class Funcionario extends Usuario {
    
    /**
     * Construtor da classe Funcionario.
     * @param nome O nome do funcionário.
     * @param cpf O CPF do funcionário.
     * @param nomeUsuario O nome de usuário do funcionário.
     * @param senha A senha do funcionário.
     */
    public Funcionario(String nome, String cpf, String nomeUsuario, String senha) {
        super(nome, cpf, nomeUsuario, senha);
    }
    
    /**
     * Obtém a senha do funcionário.
     * @return A senha do funcionário.
     */
    public String setSenha(){
        return super.getSenha();
    }
    
    /**
     * Obtém o nome do funcionário.
     * @return O nome do funcionário.
     */
    @Override
    public String getNome() {
        return super.getNome();
    }
    
    /**
     * Obtém o CPF do funcionário.
     * @return O CPF do funcionário.
     */
    public String getCpf() {
        return super.getCpf();
    }

    /**
     * Retorna uma representação em string do objeto.
     * @return Uma representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Funcionario{" + '}';
    }
}
