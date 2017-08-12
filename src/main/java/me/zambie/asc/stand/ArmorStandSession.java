package me.zambie.asc.stand;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.LinkedList;
import java.util.List;

public class ArmorStandSession {

    private final static List<ArmorStandSession> sessions = new LinkedList<>();

    public static ArmorStandSession getSession(Player player){
        for (ArmorStandSession session : sessions) {
            if (session.getPlayer().getUniqueId().equals(player.getUniqueId())){
                return session;
            }
        }
        return null;
    }

    public static boolean hasSession(Player player){
        return getSession(player) != null;
    }

    public static ArmorStandSession registerSession(Player player, ArmorStand armorStand){
        ArmorStandSession old = getSession(player);
        if (old != null){
            old.remove();
        }

        ArmorStandSession standSession = new ArmorStandSession(player, armorStand);
        sessions.add(standSession);
        return standSession;
    }

    public static List<ArmorStandSession> getSessions() {
        return sessions;
    }

    private final Player player;
    private final ArmorStand armorStand;

    private int repositioningRange = 7;
    private boolean repositioning = false;

    private boolean xLock = false, yLock = false, zLock = false, pitchLock = false, yawLock = false;
    private double x, y, z;
    private float pitch, yaw;

    private ArmorStandSession(Player player, ArmorStand armorStand) {
        this.player = player;
        this.armorStand = armorStand;
    }

    public Player getPlayer() {
        return player;
    }

    public ArmorStand getArmorStand() {
        return armorStand;
    }

    public boolean isRepositioning() {
        return repositioning;
    }

    public void setRepositioning(boolean repositioning) {
        this.repositioning = repositioning;
    }

    public int getRepositioningRange() {
        return repositioningRange;
    }

    public void setRepositioningRange(int repositioningRange) {
        this.repositioningRange = repositioningRange;
    }

    public boolean isXLock() {
        return xLock;
    }

    public void setXLock(boolean xLock) {
        this.xLock = xLock;
    }

    public boolean isYLock() {
        return yLock;
    }

    public void setYLock(boolean yLock) {
        this.yLock = yLock;
    }

    public boolean isZLock() {
        return zLock;
    }

    public void setZLock(boolean zLock) {
        this.zLock = zLock;
    }

    public boolean isPitchLock() {
        return pitchLock;
    }

    public void setPitchLock(boolean pitchLock) {
        this.pitchLock = pitchLock;
    }

    public boolean isYawLock() {
        return yawLock;
    }

    public void setYawLock(boolean yawLock) {
        this.yawLock = yawLock;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public ArmorStand clone(){
        Location location = this.armorStand.getLocation();
        World world = location.getWorld();
        ArmorStand clone = world.spawn(location, ArmorStand.class);

        clone.setHeadPose(getArmorStand().getHeadPose());
        clone.setBodyPose(getArmorStand().getBodyPose());
        clone.setRightArmPose(getArmorStand().getRightArmPose());
        clone.setRightLegPose(getArmorStand().getRightLegPose());
        clone.setLeftArmPose(getArmorStand().getLeftArmPose());
        clone.setLeftLegPose(getArmorStand().getLeftLegPose());

        clone.setHelmet(getArmorStand().getHelmet());
        clone.setChestplate(getArmorStand().getChestplate());
        clone.setLeggings(getArmorStand().getLeggings());
        clone.setBoots(getArmorStand().getBoots());

        clone.setArms(getArmorStand().hasArms());
        clone.setBasePlate(getArmorStand().hasBasePlate());
        clone.setSmall(getArmorStand().isSmall());
        clone.setVisible(getArmorStand().isVisible());

        clone.setCustomNameVisible(getArmorStand().isCustomNameVisible());
        clone.setCustomName(getArmorStand().getCustomName());

        clone.setGravity(false);

        return clone;
    }

    public void copy(){
        this.remove();

        ArmorStandSession copySession = registerSession(player, clone());
        copySession.setRepositioning(true);

        player.closeInventory();
    }

    public void remove(){
        sessions.remove(this);
    }
}
