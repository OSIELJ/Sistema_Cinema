/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;


import java.util.List;
/**
 *
 * @author 
 */
public class BalcaoDeAtendimento {
    
    private Cliente cliente;
    private int id;
    private Funcionario funcionarioResponsavel;
    private List<Venda> vendas;
    private List<Filme> filmes;

    public BalcaoDeAtendimento(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void bemVindo(){
        
        if(this.cliente != null){
            System.out.println("Bem vindo");
        }
    }


}
