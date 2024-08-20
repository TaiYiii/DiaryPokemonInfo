package com.diary.pokemoninfo.helper;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;

public class ChatCB {
    public ComponentBuilder cache;
    public ComponentBuilder builder;

    public ChatCB(String text) {
        this.builder = new ComponentBuilder(text);
    }

    public ChatCB() {
        this("");
    }

    public ChatCB append(String text) {
        if (this.cache == null) {
            this.cache = this.builder;
        }else{
            this.cache.append(this.builder.create(), ComponentBuilder.FormatRetention.NONE);
        }
        this.builder = new ComponentBuilder(text);
        return this;
    }

    public ChatCB event(ClickEvent event){
        this.builder.event(event);
        return this;
    }

    public ChatCB event(HoverEvent event){
        this.builder.event(event);
        return this;
    }

    public BaseComponent[] create(){
        if (this.cache == null) {
            return this.builder.create();
        }
        return this.cache.append(this.builder.create(), ComponentBuilder.FormatRetention.NONE).create();
    };
}
