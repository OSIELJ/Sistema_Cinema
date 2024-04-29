/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arquivo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import sistemadocinema.Cliente;
import sistemadocinema.Produto;
import sistemadocinema.Filme;

/**
 *
 * @author Osiel Junior
 */
public class Json {
    
    public static final String arqCliente = "C:/Users/Osiel/Documents/NetBeansProjects/Sistema_Cinema/Documents/NetBeansProjects/SistemaDoCinema/src/Arquivo/cliente.json";
    public static final String arqProdutos = "./src/main/java/Arquivo/produtos.json";
    public static final String arqFilmes = "./src/main/java/Arquivo/filmes.json";
    
    
    
    public Json() {
        
    }
    
        public static void salvarClientes(List<Cliente> listaCliente){
            
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(listaCliente);
            
            
            try (FileWriter writer = new FileWriter(arqCliente)) {
            writer.write(json);
            } catch (IOException e) {
                
            e.printStackTrace();
            }
            System.out.println("Clientes salvos. ");
    }
        
        
        
    public static List<Cliente> lerClientes() {
        ArrayList<Cliente> listaCliente = new ArrayList();


        try (FileReader reader = new FileReader(arqCliente)) {
            Gson gson = new Gson();
            Type tipoListaClientes = new TypeToken<List<Cliente>>() {}.getType();
            listaCliente = gson.fromJson(reader, tipoListaClientes);
        } catch (IOException e) {
        }


        return listaCliente;
    }
    
    
        public static void salvarProdutos(List<Produto> listaProduto) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(listaProduto);


        try (FileWriter writer = new FileWriter(arqProdutos)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Produtos salvos. ");
    }

    
        
    public static List<Produto> lerProdutos() {
        ArrayList<Produto> listaProduto = new ArrayList();


        try (FileReader reader = new FileReader(arqProdutos)) {
            Gson gson = new Gson();
            Type tipoListaProduto = new TypeToken<List<Produto>>() {}.getType();
            listaProduto = gson.fromJson(reader, tipoListaProduto);
        } catch (IOException e) {
        }

        return listaProduto;
    }


    
    public static void salvarFilme(List<Filme> listaFilmes) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(listaFilmes);


        try (FileWriter writer = new FileWriter(arqFilmes)) {
            writer.write(json);
        } catch (IOException e) {
        }
        System.out.println("Filmes salvos. ");
    }

    
    public static List<Filme> lerFilmes() {
        ArrayList<Filme> listaFilme = new ArrayList();


        try (FileReader reader = new FileReader(arqFilmes)) {
            Gson gson = new Gson();
            Type tipoListaNotaFiscal = new TypeToken<List<Filme>>() {}.getType();
            listaFilme = gson.fromJson(reader, tipoListaNotaFiscal);
        } catch (IOException e) {
        }

        return listaFilme;
    }

        
}
    
    
