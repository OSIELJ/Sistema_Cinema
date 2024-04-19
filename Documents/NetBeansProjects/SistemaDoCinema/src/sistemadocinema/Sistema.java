/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadocinema;

import java.util.ArrayList;
import java.util.List;
import Arquivo.Json;

/**
 *
 * @author Osiel Junior
 */
public class Sistema {
    
    public static void main(String[] args) {
        
       
        
        
        
        Cliente myCliente = new Cliente("osiel", "juniro", "13441301609", "tirand",
        "38998151249");
        
        Cliente myCliente1 = new Cliente("Maicon", "Douglas", "13441301609", "tirand",
        "38998151249");
        
        
        
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(myCliente);
        listaClientes.add(myCliente1);
      
       Json.salvarClientes(listaClientes);
       Json.salvarClientes(listaClientes);
       
       
       
       Gerente myGerente = new Gerente("Osiel", "Osieljunior123");
       Funcionario myFuncionario = new Funcionario("Daniel", "Danielrodrigues123");
       
       
       Autenticar.adicionarUsuario(myFuncionario);
       Autenticar.adicionarUsuario(myGerente);
       
       Autenticar.autenticar("Osiel", "Osieljunior123");
       
       
       
       

       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
        
        
    }
    
   
   
   
    
}
