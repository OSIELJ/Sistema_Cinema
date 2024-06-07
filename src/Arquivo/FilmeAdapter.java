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
 * JsonSerializer for Filme class
 * 
 * @author Osiel
 */
public class FilmeAdapter implements JsonSerializer<Filme> {

    @Override
    public JsonElement serialize(Filme filme, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        
        json.addProperty("titulo", filme.getTitulo());
        json.addProperty("estilo", filme.getEstilo());
        json.addProperty("dataValidade", filme.getDataValidade().toString());
        json.addProperty("valor", filme.getValor());
        json.addProperty("quantidadeEmEstoque", filme.getQuantidadeEmEstoque());
        json.addProperty("periodoExibicao", filme.getPeriodoExibicao());

        return json;
    }
}
