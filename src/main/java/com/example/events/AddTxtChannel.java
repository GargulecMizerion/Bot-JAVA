package com.example.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Locale;

public class AddTxtChannel extends ListenerAdapter {


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();

        if (messageSent.equalsIgnoreCase("!newTxt")){
            event.getGuild().createTextChannel("ebebe");
            event.getChannel().sendMessage("Kanał dodany").queue();
        }
    }
}
