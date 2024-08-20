package com.diary.pokemoninfo;

import com.google.common.collect.Lists;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.List;
import java.util.Objects;


public class CommandBase implements TabExecutor {
    private final Main plugin;

    public CommandBase(Main plugin) {
        this.plugin = plugin;
    }

    //命令实现
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        switch (strings.length) {
            case 0:
                commandSender.sendMessage(" ");
                commandSender.sendMessage("§3@" + commandSender.getName() + "§8 欢迎使用DiaryPokemonInfo!");
                commandSender.sendMessage(" ");
                commandSender.sendMessage(" ");
                commandSender.sendMessage("§7[命令]:§f/DiaryPokemonInfo:diapi §8[...]");
                commandSender.sendMessage("  §7- §fopen <player> <gui_tags>");
                commandSender.sendMessage("    §7打开玩家随行宝可梦信息Gui界面");
                commandSender.sendMessage("  §7- §fshow <slot>");
                commandSender.sendMessage("    §7展示玩家随行指定槽位的宝可梦到聊天栏");
                commandSender.sendMessage("    §7无<slot>展示随行所有槽位的宝可梦到聊天栏");
                commandSender.sendMessage("  §7- §freload");
                commandSender.sendMessage("    §7重载插件");
                commandSender.sendMessage(" ");
                return true;
            case 1:
                if (strings[0].equalsIgnoreCase("reload") && commandSender.hasPermission("diarypokemoninfo.reload")) {

                    commandSender.sendMessage("");
                    commandSender.sendMessage("§3插件重载成功!");
                    commandSender.sendMessage("");
                }  //show  无<slot>展示随行所有槽位的宝可梦到聊天栏
                else if(strings[0].equalsIgnoreCase("show") && commandSender.hasPermission("diarypokemoninfo.show")){

                    commandSender.sendMessage("");
                    commandSender.sendMessage("§4已展示随行宝可梦信息!");
                    commandSender.sendMessage("");
                }
                return true;
            case 2:  //show <slot>  展示玩家随行指定槽位的宝可梦到聊天栏
                if (strings[0].equalsIgnoreCase("show") && commandSender.hasPermission("diarypokemoninfo.show")) {

                    commandSender.sendMessage("");
                    commandSender.sendMessage("§4已展示宝可梦"+""+"的信息!");
                    commandSender.sendMessage("");
                }
                return true;
            case 3:  //open <player> <gui_tags>  打开玩家随行宝可梦信息Gui界面
                if (strings[0].equalsIgnoreCase("set") && commandSender.hasPermission("diarypokemoninfo.open")) {

                }
                return true;
        }
        commandSender.sendMessage(" ");
        commandSender.sendMessage("§3@" + commandSender.getName() + "§8 欢迎使用DiaryPokemonInfo!");
        commandSender.sendMessage(" ");
        commandSender.sendMessage(" ");
        commandSender.sendMessage("§7[命令]:§f/DiaryPokemonInfo:diapi §8[...]");
        commandSender.sendMessage("  §7- §fopen <player> <gui_tags>");
        commandSender.sendMessage("    §7打开玩家随行宝可梦信息Gui界面");
        commandSender.sendMessage("  §7- §fshow <slot>");
        commandSender.sendMessage("    §7展示玩家随行指定槽位的宝可梦到聊天栏");
        commandSender.sendMessage("    §7无<slot>展示随行所有槽位的宝可梦到聊天栏");
        commandSender.sendMessage("  §7- §freload");
        commandSender.sendMessage("    §7重载插件");
        commandSender.sendMessage(" ");
        return false;
    }


    public static List<String > subCmd = Lists.newArrayList(
            "open","show","reload"
    );
    //命令提示
    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] strings) {
        switch (strings.length) {
            case 0:
                return subCmd;
            case 1:
                if (Objects.equals(strings[0], "show")) {

                }
            default:
                return null;
        }
    }
}
