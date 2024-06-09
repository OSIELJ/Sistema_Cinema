/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arquivo;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import sistemadocinema.Filme;

import java.lang.reflect.Type;

/**
 * Classe responsável por adaptar objetos do tipo Filme para JSON utilizando o Gson.
 * Implementa a interface JsonSerializer para fornecer uma forma personalizada de serializar o Filme.
 * 
 * @author Osiel Junior
 */
public class FilmeAdapter implements JsonSerializer<Filme> {

    /**
     * Método que realiza a serialização de objetos Filme para JSON.
     * 
     * @param filme O objeto Filme a ser serializado.
     * @param typeOfSrc O tipo do objeto de origem.
     * @param context O contexto de serialização.
     * @return O JsonElement que representa o objeto Filme em formato JSON.
     */
    @Override
    public JsonElement serialize(Filme filme, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        
        // Assuming these methods are correctly defined in the Filme class.
        json.addProperty("titulo", filme.getTitulo()); 
        json.addProperty("estilo", filme.getEstilo()); 
        json.addProperty("dataValidade", filme.getDataValidade().toString()); 
        json.addProperty("valor", filme.getValor()); 
        json.addProperty("quantidadeEmEstoque", filme.getQuantidadeEmEstoque()); 
        json.addProperty("periodoExibicao", filme.getPeriodoExibicao()); 

        return json; 
    }
}
