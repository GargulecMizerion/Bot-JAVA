package com.example;

import com.example.events.*;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bot {

    public static void main(String[] args) throws LoginException {

        JDABuilder builder = JDABuilder.createDefault("ODIyMDg1OTI3Nzg5Nzg5MjQ0.YFNJLg.2NvXbj3JcU1hLT451_U09NzpQCs");

        builder.addEventListeners(new HelloEvent());
        builder.addEventListeners(new CallAdmin());
//        builder.addEventListeners(new Parrot());
        builder.addEventListeners(new GetJoke());
        builder.addEventListeners(new Help());

        builder.setActivity(Activity.watching("You"));



        builder.build();

    }




}
