package com.diary.pokemoninfo.guihub;

import com.diary.pokemoninfo.helper.ChatCB;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.HoverEvent;

import java.time.LocalDateTime;

public class ChatCBHub {

    /**
     * 获取一个宝可梦信息悬停组件
     * <per>
     *     游戏聊天框中:
     *     [玩家1]: {@param format}
     *     鼠标移动至 {@param format} 显示内容如下
     *     ┏            ┓
     *      宝可梦名: xxx
     *     ┗            ┛
     *     待补全!
     * </per>
     */
    public static BaseComponent[] getHoverPokeInfo(String format, Pokemon pokemon){
        ChatCB hoverInfo = new ChatCB();
        hoverInfo.append("宝可梦名: " + pokemon.getLocalizedName());
        //待补充!


        HoverEvent event = new HoverEvent(HoverEvent.Action.SHOW_TEXT,hoverInfo.create());
        return new ChatCB(format).event(event).create();
    }
}
