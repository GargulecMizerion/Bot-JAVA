package com.example.events;

import com.example.Joke;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.dv8tion.jda.api.hooks.ListenerAdapter;



public class GetJoke extends ListenerAdapter {

    private Joke getJoke() throws IOException {

        // Adres zapytania
        URL url =  new URL("https://official-joke-api.appspot.com/random_joke");

        // Połączenie z adresem
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Właściwości połączenia
        connection.setRequestProperty("accept", "application/json");

        // Właściwe zapytanie
        InputStream responseStream = connection.getInputStream();

        // Konwersja odpowiedzi na obiekt
        ObjectMapper mapper = new ObjectMapper();
        Joke joke = mapper.readValue(responseStream, Joke.class);

        // Finally we have the response
        return joke;
    }


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        Joke joke = null;

        try {
            joke = getJoke();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String messageSent = event.getMessage().getContentRaw();
        if (messageSent.equalsIgnoreCase("!joke")){

            event.getChannel().sendMessage(joke.getSetup()).queue();
            event.getChannel().sendMessage(joke.getPunchline()).queue();


        }
    }

}
