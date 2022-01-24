package com.example.events;

import com.example.Chuck;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetChuck extends ListenerAdapter {

    private Chuck getChuck() throws IOException {
        URL url = new URL("https://api.chucknorris.io/jokes/random");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("accept", "application/json");

        InputStream responseStream = connection.getInputStream();

        ObjectMapper mapper = new ObjectMapper();
        Chuck chuck = mapper.readValue(responseStream, Chuck.class);

        return chuck;
    }


    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        Chuck chuck = null;

        try {
            chuck = getChuck();
        } catch (IOException e) {
            e.printStackTrace();
        }


        String messageSent = event.getMessage().getContentRaw();

        if (messageSent.equalsIgnoreCase("!chuck")){
            event.getChannel().sendMessage(chuck.getValue()).queue();
        }
    }



}
