package me.zambie.asc.click.actions;

public final class UpdateBodyAngleAction extends UpdateAngleAction {

    public UpdateBodyAngleAction(int slot, double x, double y, double z) {
        super(slot, x, y, z, "getBodyPose", "setBodyPose");
    }
}
