package me.zambie.asc.name;

import me.zambie.asc.language.LanguageManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

public class NameChangeManager implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onChat(PlayerChatEvent event) {
        Player player = event.getPlayer();
        if (NameChangeSession.hasSession(player)) {
            NameChangeSession session = NameChangeSession.getSession(player);
            Entity armorStand;
            if (session != null) {
                armorStand = session.getArmorStandSession().getArmorStand();

                event.setCancelled(true);

                if (event.getMessage().equalsIgnoreCase("remove")) {
                    armorStand.setCustomNameVisible(false);
                    armorStand.setCustomName("");
                    return;
                }
                session.getArmorStandSession().remove();
                session.remove();

                armorStand.setCustomNameVisible(true);
                armorStand.setCustomName(ChatColor.translateAlternateColorCodes('&', event.getMessage()));
                player.sendMessage(String.format(LanguageManager.getLanguage().getMessageCompleteNameChangeAction(), armorStand.getCustomName()));
            }
        }
    }

}
