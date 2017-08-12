package me.zambie.asc.name;

import me.zambie.asc.stand.ArmorStandSession;
import org.bukkit.entity.Player;

import java.util.LinkedList;
import java.util.List;

public class NameChangeSession {

    private static final List<NameChangeSession> list = new LinkedList<>();

    public static NameChangeSession registerSession(ArmorStandSession session){
        NameChangeSession nameChangeSession = new NameChangeSession(session);
        list.add(nameChangeSession);
        return nameChangeSession;
    }

    public static NameChangeSession getSession(Player player){
        for (NameChangeSession session : list){
            if (session.getArmorStandSession().getPlayer().getUniqueId().equals(player.getUniqueId())){
                return session;
            }
        }
        return null;
    }

    public static boolean hasSession(Player player){
        return getSession(player) != null;
    }

    private final ArmorStandSession armorStandSession;

    public NameChangeSession(ArmorStandSession armorStandSession) {
        this.armorStandSession = armorStandSession;
    }

    public ArmorStandSession getArmorStandSession() {
        return armorStandSession;
    }

    public void remove(){
        list.remove(this);
    }
}
