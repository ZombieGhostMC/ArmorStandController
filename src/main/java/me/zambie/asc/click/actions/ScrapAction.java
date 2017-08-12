package me.zambie.asc.click.actions;

import me.zambie.asc.click.ClickAction;
import me.zambie.asc.controller.ControllerSession;
import me.zambie.asc.language.LanguageManager;
import me.zambie.asc.stand.ArmorStandSession;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public final class ScrapAction implements ClickAction {
    @Override
    public int getSlot() {
        return 28;
    }

    @Override
    public void execute(InventoryClickEvent event, ControllerSession session) {
        ArmorStandSession armorStandSession = session.getSession();
        Player player = armorStandSession.getPlayer();

        player.closeInventory();
        player.sendMessage("§6ArmorStand scrapped.");

        player.sendMessage(LanguageManager.getLanguage().getMessageScrap());

        armorStandSession.getArmorStand().remove();
    }
}
