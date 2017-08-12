package me.zambie.asc.stand;

import com.intellectualcrafters.plot.api.PlotAPI;
import com.intellectualcrafters.plot.object.Plot;
import com.plotsquared.bukkit.BukkitMain;
import me.zambie.asc.Main;
import me.zambie.asc.language.LanguageManager;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashSet;

public class ArmorStandManager implements Listener{

    private final Main plugin;

    public ArmorStandManager(Main plugin) {
        this.plugin = plugin;
    }

    private Main getPlugin() {
        return plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteractEntity(PlayerInteractAtEntityEvent event){
        if (event.isCancelled())return;
        if (event.getPlayer().hasPermission("armorstandcontroller.access")) {
            Entity entity = event.getRightClicked();
            if (entity instanceof ArmorStand) {
                getPlugin().getControllerManager().register(event.getPlayer(), (ArmorStand) entity);
                event.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if (player.hasPermission("armorstandcontroller.access")) {
            if (ArmorStandSession.hasSession(player)) {
                ArmorStandSession session = ArmorStandSession.getSession(player);
                if (session != null && session.isRepositioning()) {
                    ArmorStand armorStand = session.getArmorStand();

                    Location location = player.getTargetBlock((HashSet<Byte>) null, session.getRepositioningRange()).getLocation().add(0, 1, 0);

                    float pitch = player.getLocation().getPitch();
                    float yaw = player.getLocation().getYaw();

                    location.setPitch(pitch);
                    location.setYaw(yaw);

                    if (session.isXLock()){
                        location.setX(session.getX());
                    }

                    if (session.isYLock()){
                        location.setY(session.getY());
                    }

                    if (session.isZLock()){
                        location.setZ(session.getZ());
                    }

                    if (session.isPitchLock()){
                        location.setPitch(session.getPitch());
                    }

                    if (session.isYawLock()){
                        location.setYaw(session.getYaw());
                    }

                    if (plugin.isPlotSquaredSupport()){
                        PlotAPI api = plugin.getPlotAPI();

                        Plot plot = api.getPlot(location);
                        if (plot == null){
                            return;
                        }

                        if (!plot.isAdded(event.getPlayer().getUniqueId())){
                            return;
                        }
                    }

                    armorStand.teleport(location);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(PlayerChatEvent event){
        Player player = event.getPlayer();
        if (ArmorStandSession.hasSession(player)) {
            ArmorStandSession session = ArmorStandSession.getSession(player);
            if (session != null && session.isRepositioning()) {
                event.setCancelled(true);

                if (NumberUtils.isNumber(event.getMessage())){
                    int range = Integer.parseInt(event.getMessage());

                    if (range <= 0 || range >= 100){
                        player.sendMessage(String.format("§c%s", LanguageManager.getLanguage().getMessageInvalidRepositionRange()));
                        return;
                    }

                    session.setRepositioningRange(range);
                    return;
                }

                ArmorStand armorStand = session.getArmorStand();
                switch (event.getMessage().toLowerCase()){
                    case "x":{
                        session.setX(session.isXLock() ? 0 : armorStand.getLocation().getX());
                        session.setXLock(!session.isXLock());
                        player.sendMessage(String.format("§6%s",
                                String.format(LanguageManager.getLanguage().getMessageRepositionLock(), "X", session.isXLock())));

                        break;
                    }
                    case "y":{
                        session.setY(session.isYLock() ? 0 : armorStand.getLocation().getY());
                        session.setYLock(!session.isYLock());
                        player.sendMessage(String.format("§6%s",
                                String.format(LanguageManager.getLanguage().getMessageRepositionLock(), "Y", session.isYLock())));

                        break;
                    }
                    case "z":{
                        session.setZ(session.isZLock() ? 0 : armorStand.getLocation().getZ());
                        session.setZLock(!session.isZLock());
                        player.sendMessage(String.format("§6%s",
                                String.format(LanguageManager.getLanguage().getMessageRepositionLock(), "Z", session.isZLock())));

                        break;
                    }
                    case "pitch":{
                        session.setPitch(session.isPitchLock() ? 0 : armorStand.getLocation().getPitch());
                        session.setPitchLock(!session.isPitchLock());
                        player.sendMessage(String.format("§6%s",
                                String.format(LanguageManager.getLanguage().getMessageRepositionLock(), "Pitch", session.isPitchLock())));


                        break;
                    }
                    case "yaw":{
                        session.setYaw(session.isYawLock() ? 0 : armorStand.getLocation().getYaw());
                        session.setYawLock(!session.isYawLock());
                        player.sendMessage(String.format("§6%s",
                                String.format(LanguageManager.getLanguage().getMessageRepositionLock(), "Yaw", session.isYawLock())));
                        break;
                    }default:{
                        session.remove();
                        player.sendMessage(String.format("§a%s", LanguageManager.getLanguage().getMessageRepositionSuccess()));
                    }
                }
            }
        }
    }

}
