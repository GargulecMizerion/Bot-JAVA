package com.example.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Parrot extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        StringBuilder messageSent = new StringBuilder(event.getMessage().getContentRaw());
        if (messageSent.toString().contains("!parrot")){
            messageSent.delete(0,8);
            event.getChannel().sendMessage(messageSent).queue();
        }

    }
}
