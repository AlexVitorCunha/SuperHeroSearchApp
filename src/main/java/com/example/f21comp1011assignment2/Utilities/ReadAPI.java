package com.example.f21comp1011assignment2.Utilities;

import com.example.f21comp1011assignment2.Models.ApiResponse;
import com.example.f21comp1011assignment2.Models.Hero;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;





import java.io.IOException;
import java.lang.reflect.Type;


public class ReadAPI {
    public static Hero[] getHeroes(String searchTerm) throws IOException, UnirestException {
        Hero[] heroes = null;
        searchTerm = searchTerm.trim().replace(" ", "%20");
        String uri = "https://superhero-search.p.rapidapi.com/api/?regex=" + searchTerm;
        HttpResponse<String> response = Unirest.get(uri)
                .header("x-rapidapi-host", "superhero-search.p.rapidapi.com")
                .header("x-rapidapi-key", "0dc6df9401msh50066983c384323p17c0ffjsn1221c38f1c1f")
                .asString();

        String jsonString = response.getBody();
        System.out.println(jsonString);
        Gson gson = new Gson();
        try{
            heroes = gson.fromJson(jsonString, Hero[].class);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return heroes;
    }
}
