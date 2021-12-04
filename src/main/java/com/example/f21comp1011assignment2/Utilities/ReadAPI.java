package com.example.f21comp1011assignment2.Utilities;

import com.example.f21comp1011assignment2.Models.Hero;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;

/**
 * Use the API to search for the term on the superhero name field and returns an array of results
 */
public class ReadAPI {
    public static Hero[] getHeroes(String searchTerm) throws UnirestException {
        Hero[] heroes = null;

        // stores each characters to a char array
        char[] charArray = searchTerm.toCharArray();
        boolean foundSpace = true;

        for(int i = 0; i < charArray.length; i++) {

            // if the array element is a letter
            if(Character.isLetter(charArray[i])) {

                // check space is present before the letter
                if(foundSpace) {

                    // change the letter into uppercase
                    charArray[i] = Character.toUpperCase(charArray[i]);
                    foundSpace = false;
                }
            }

            else {
                // if the new character is not character
                foundSpace = true;
            }
        }
        // convert the char array to the string
        searchTerm = String.valueOf(charArray);
        //put %20 in the place of spaces
        searchTerm = searchTerm.trim().replace(" ", "%20");
        String uri = "https://superhero-search.p.rapidapi.com/api/?regex=" + searchTerm;
        HttpResponse<String> response = Unirest.get(uri)
                .header("x-rapidapi-host", "superhero-search.p.rapidapi.com")
                .header("x-rapidapi-key", "0dc6df9401msh50066983c384323p17c0ffjsn1221c38f1c1f")
                .asString();

        String jsonString = response.getBody();
        Gson gson = new Gson();
        try{
            heroes = gson.fromJson(jsonString, Hero[].class);
        }catch (Exception e) {}
        return heroes;
    }
}
