package com.example.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class CallAdmin extends ListenerAdapter {



    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String messageSent = event.getMessage().getContentRaw();
        if(messageSent.equalsIgnoreCase("!owner")){
            event.getChannel().sendMessage("<@" + event.getGuild().getOwner().getId() + ">").queue();


        }
    }


}
