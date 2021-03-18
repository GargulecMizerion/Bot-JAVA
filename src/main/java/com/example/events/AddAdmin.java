package com.example.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AddAdmin extends ListenerAdapter {

    List<String> admins = new ArrayList<>();

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
//        String messageSent = event.getMessage().getContentRaw();
//        if (messageSent.contains("!add")){
//            admins.add()
//        }
    }

}
