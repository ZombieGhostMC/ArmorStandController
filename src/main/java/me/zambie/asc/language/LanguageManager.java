package me.zambie.asc.language;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedList;
import java.util.List;

public class LanguageManager {

    private static final List<Language> languages = new LinkedList<>();
    private static int i;

    public static void register(JavaPlugin plugin){
        languages.add(new English());
        languages.add(new Deutsche());
        languages.add(new Español());
        languages.add(new Français());
        languages.add(new Arabic());
        languages.add(new Português());

        i = plugin.getConfig().getInt("language", 0);
    }

    public static void disable(JavaPlugin plugin){
        plugin.getConfig().set("language", i);
        plugin.saveConfig();
    }

    public static void toggle(){
        if (i + 1 == languages.size()){
            i = 0;
        }else {
            i++;
        }
    }

    public static Language getLanguage(){
        return languages.get(i);
    }
}
