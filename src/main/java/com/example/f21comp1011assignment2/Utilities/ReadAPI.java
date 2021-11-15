package com.example.f21comp1011assignment2.Utilities;

import com.example.f21comp1011assignment2.Models.Hero;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



import java.io.IOException;
import java.util.ArrayList;

public class ReadAPI {
    public static ArrayList<Hero> getHeroes() throws IOException {
        Gson gson = new Gson();
        ArrayList<Hero> heroes = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://superhero-search.p.rapidapi.com/api/?hero=Spiderman")
                .get()
                .addHeader("x-rapidapi-host", "superhero-search.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "0dc6df9401msh50066983c384323p17c0ffjsn1221c38f1c1f")
                .build();
        Response response = client.newCall(request).execute();
        heroes.add(new Hero("Wonder Woman"));
        heroes.add(new Hero("Shazam"));
        return heroes;
    }
}
