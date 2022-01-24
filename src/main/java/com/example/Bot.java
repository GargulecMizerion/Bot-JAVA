package com.example;

import com.example.events.*;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class Bot {

    public static void main(String[] args) throws LoginException {

        JDABuilder builder = JDABuilder
                .createDefault(
                        "ODIyMDg1OTI3Nzg5Nzg5MjQ0.YFNJLg.GJs1aSHTqNj1LrdjiLVi4Tg7DGw",
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.GUILD_VOICE_STATES);

        builder.addEventListeners(new HelloEvent());
        builder.addEventListeners(new CallAdmin());
//        builder.addEventListeners(new Parrot());
        builder.addEventListeners(new GetJoke());
        builder.addEventListeners(new Help());
        builder.addEventListeners(new PlayCommand());
        builder.addEventListeners(new JoinEvent());
        builder.addEventListeners(new VolumeCommand());
        builder.addEventListeners(new GetChuck());
        builder.addEventListeners(new AddTxtChannel());
        builder.addEventListeners(new MakaryDiss());
        builder.addEventListeners(new DawidDiss());


        builder.disableCache(EnumSet.of(
                CacheFlag.CLIENT_STATUS,
                CacheFlag.ACTIVITY,
                CacheFlag.EMOTE));

        builder.enableCache(CacheFlag.VOICE_STATE);

        builder.setActivity(Activity.listening("you"));



        builder.build();

    }




}
