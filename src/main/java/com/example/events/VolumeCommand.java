package com.example.events;

import com.example.music.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class VolumeCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        PlayerManager manager = PlayerManager.getInstance();
        String messageSent = event.getMessage().getContentRaw();
        StringBuilder volume = new StringBuilder(messageSent);
        volume.delete(0,8);

        if (messageSent.startsWith("!volume ")){
            boolean flag = true;

            for (int i = 0; i < volume.length() ; i++) {
                Character c = volume.charAt(i);
                if(!Character.isDigit(c)){
                    flag = false;
                }
            }



            if (flag){
                manager.getGuildMusicManager(event.getGuild()).player.setVolume(Integer.parseInt(volume.toString()));
                event.getChannel().sendMessage("Ustawiono głośność na: " + volume.toString()).queue();
            } else {
                event.getChannel().sendMessage("Zły format głośności dźwięku").queue();
            }

        }


    }


}
