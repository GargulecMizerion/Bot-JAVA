package com.example.events;

import com.example.music.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class PlayCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        PlayerManager manager = PlayerManager.getInstance();
        String messageSent = event.getMessage().getContentRaw();
        StringBuilder url = new StringBuilder(messageSent);
        url.delete(0,6);



        if(messageSent.startsWith("!play ")){
            manager.loadAndPlay(event.getChannel(), url.toString());
            manager.getGuildMusicManager(event.getGuild()).player.setVolume(10);

        }

        if (messageSent.equalsIgnoreCase("!stop")){
            manager.getGuildMusicManager(event.getGuild()).player.stopTrack();
        }





    }

}
