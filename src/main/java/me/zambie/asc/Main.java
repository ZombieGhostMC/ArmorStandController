package me.zambie.asc;

import com.intellectualcrafters.plot.api.PlotAPI;
import me.zambie.asc.color.ColorManager;
import me.zambie.asc.controller.ControllerManager;
import me.zambie.asc.language.*;
import me.zambie.asc.name.NameChangeManager;
import me.zambie.asc.stand.ArmorStandManager;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private ColorManager colorManager;
    private ArmorStandManager armorStandManager;
    private ControllerManager controllerManager;
    private NameChangeManager nameChangeManager;

    private boolean plotSquaredSupport;
    private PlotAPI plotAPI;

    //TODO Fix Issue With Name Change canceling out any further movement change

    @Override
    public void onEnable() {
        this.colorManager = new ColorManager();
        this.nameChangeManager = new NameChangeManager();
        this.controllerManager = new ControllerManager(this);
        this.armorStandManager = new ArmorStandManager(this);

        Bukkit.getPluginManager().registerEvents(colorManager, this);
        Bukkit.getPluginManager().registerEvents(nameChangeManager, this);
        Bukkit.getPluginManager().registerEvents(controllerManager, this);
        Bukkit.getPluginManager().registerEvents(armorStandManager, this);

        LanguageManager.register(this);

        if (Bukkit.getPluginManager().getPlugin("PlotSquared") != null){
            setPlotSquaredSupport(true);
            this.plotAPI = new PlotAPI();
        }
    }

    @Override
    public void onDisable() {
        LanguageManager.disable(this);
    }

    public ColorManager getColorManager() {
        return colorManager;
    }

    public ArmorStandManager getArmorStandManager() {
        return armorStandManager;
    }

    public ControllerManager getControllerManager() {
        return controllerManager;
    }

    public NameChangeManager getNameChangeManager() {
        return nameChangeManager;
    }

    public boolean isPlotSquaredSupport() {
        return plotSquaredSupport;
    }

    public void setPlotSquaredSupport(boolean plotSquaredSupport) {
        this.plotSquaredSupport = plotSquaredSupport;
    }

    public PlotAPI getPlotAPI() {
        return plotAPI;
    }
}