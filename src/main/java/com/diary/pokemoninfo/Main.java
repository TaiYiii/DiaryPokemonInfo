package com.diary.pokemoninfo;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main plugin;
    public static final String[] logo = new String[]{
            "",
            "§3   ___      ___      ___      ___   §b   ___      ___      ___      ___   ",
            "§3  /\\  \\    /\\  \\    /\\__\\    /\\  \\  §b  /\\  \\    /\\__\\    /\\  \\    /\\  \\  ",
            "§3 /::\\  \\  /::\\  \\  /:/ _/_  /::\\  \\ §b _\\:\\  \\  /:| _|_  /::\\  \\  /::\\  \\ ",
            "§3/::\\:\\__\\/:/\\:\\__\\/::-\"\\__\\/::\\:\\__\\§b/\\/::\\__\\/::|/\\__\\/::\\:\\__\\/:/\\:\\__\\",
            "§3\\/\\::/  /\\:\\/:/  /\\;:;-\",-\"\\:\\:\\/  /§b\\::/\\/__/\\/|::/  /\\/\\:\\/__/\\:\\/:/  /",
            "§3   \\/__/  \\::/  /  |:|  |   \\:\\/  / §b \\:\\__\\    |:/  /    \\/__/  \\::/  / ",
            "§3           \\/__/    \\|__|    \\/__/  §b  \\/__/    \\/__/             \\/__/  ",
            ""
    };

    @Override
    public void onEnable() {
        plugin = this;
        say(logo);
        say("§3DiaryPokemonInfoV" + this.getDescription().getVersion() + " by Taiyi&GSQ_FI §a@onLoad");
        try {
            Class.forName("com.pixelmonmod.pixelmon.Pixelmon");
        } catch (ClassNotFoundException var2) {
            say("§4  未检测到§e宝可梦MOD§4: " + var2);
            say("§4  已卸载插件!");
            Bukkit.getScheduler().cancelTasks(this);
            say(" ");
            say("§3DiaryPokemonInfoV" + this.getDescription().getVersion() + " by Taiyi&GSQ/FullIdle §4@onError");
            say("§4  Code: 插件加载错误!");
            say(" ");
            this.getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this);
        say(logo);
        say("§3DiaryPokemonInfoV" + this.getDescription().getVersion() + " by Taiyi&GSQ_FI §c@onDisable");
        say("§7  Code: 插件卸载成功,感谢使用!");
        say(" ");
    }

    public static void say(String... s) {
        Bukkit.getConsoleSender().sendMessage(s);
    }
}
