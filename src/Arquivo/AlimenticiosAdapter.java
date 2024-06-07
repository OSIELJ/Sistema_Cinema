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
 * JsonSerializer for Alimenticios class
 * 
 * @author Osiel
 */
public class AlimenticiosAdapter implements JsonSerializer<Alimenticios> {

    @Override
    public JsonElement serialize(Alimenticios alimenticios, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        
        json.addProperty("nome", alimenticios.getNome());
        json.addProperty("dataValidade", alimenticios.getDataValidade().toString());
        json.addProperty("valor", alimenticios.getValor());
        json.addProperty("quantidadeEmEstoque", alimenticios.getQuantidadeEmEstoque());

        return json;
    }
}
