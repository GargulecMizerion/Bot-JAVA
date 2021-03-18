package com.example.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Help extends ListenerAdapter
{

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String messageSent = event.getMessage().getContentRaw();

        if (messageSent.equalsIgnoreCase("!help")){
            event.getChannel().sendMessage("!joke - sypnij żartem brachu\n!hello - przywitaj sie \n!owner - zawołaj własciciela").queue();
        }

    }

}
