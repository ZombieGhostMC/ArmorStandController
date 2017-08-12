package me.zambie.asc.click.actions;

public final class UpdateHeadAngleAction extends UpdateAngleAction {

    public UpdateHeadAngleAction(int slot, double x, double y, double z) {
        super(slot, x, y, z, "getHeadPose", "setHeadPose");
    }
}
