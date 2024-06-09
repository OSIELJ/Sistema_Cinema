/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arquivo;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import sistemadocinema.Alimenticios;
import java.lang.reflect.Type;

/**
 * Classe responsável por adaptar objetos do tipo Alimenticios para JSON utilizando o Gson.
 * Esta classe implementa a interface JsonSerializer para fornecer a lógica de serialização personalizada.
 * 
 * @author Osiel Junior
 */
public class AlimenticiosAdapter implements JsonSerializer<Alimenticios> {

    /**
     * Método que realiza a serialização de objetos Alimenticios para JSON.
     * 
     * @param alimenticios O objeto Alimenticios a ser serializado.
     * @param typeOfSrc O tipo do objeto de origem.
     * @param context O contexto de serialização.
     * @return O JsonElement que representa o objeto Alimenticios em formato JSON.
     */
    @Override
    public JsonElement serialize(Alimenticios alimenticios, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        
        
        json.addProperty("nome", alimenticios.getNome()); 
        json.addProperty("dataValidade", alimenticios.getDataValidade().toString()); 
        json.addProperty("valor", alimenticios.getValor()); // Adiciona o valor do produto
        json.addProperty("quantidadeEmEstoque", alimenticios.getQuantidadeEmEstoque()); 

        return json; 
    }
}
