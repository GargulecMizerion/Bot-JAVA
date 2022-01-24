package com.example.events;

import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

@SuppressWarnings("ConstantConditions")
public class JoinEvent extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String messageSent = event.getMessage().getContentRaw();
        final TextChannel channel = event.getChannel();
        final Member self = event.getGuild().getSelfMember();
        final GuildVoiceState selfVoiceState = self.getVoiceState();

        if (messageSent.equalsIgnoreCase("!join1")) {

            if (selfVoiceState.inVoiceChannel()) {
                channel.sendMessage("Jestem już na innym kanale :(").queue();
                return; // XXXXXXXXXXXXXXXXXXX
            }

            final Member member = event.getMember();
            final GuildVoiceState memberVoiceState = member.getVoiceState();

            if (!memberVoiceState.inVoiceChannel()) {
                channel.sendMessage("Aby dodać bota musisz byc w kanale głosowym").queue();
                return; // XXXXXXXXXXXXXXXXXXX
            }

            final AudioManager audioManager = event.getGuild().getAudioManager();
            final VoiceChannel memberChannel = memberVoiceState.getChannel();
            audioManager.openAudioConnection(memberChannel);
            channel.sendMessage("Witam na kanale głosowym!").queue();
        }

        if (messageSent.equalsIgnoreCase("!disconnect")){
            final AudioManager audioManager = event.getGuild().getAudioManager();
            audioManager.closeAudioConnection();
            event.getChannel().sendMessage("Do zobaczenia!").queue();
        }



    }

}
