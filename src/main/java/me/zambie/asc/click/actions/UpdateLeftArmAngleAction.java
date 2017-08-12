package me.zambie.asc.click.actions;

public final class UpdateLeftArmAngleAction extends UpdateAngleAction {

    public UpdateLeftArmAngleAction(int slot, double x, double y, double z) {
        super(slot, x, y, z, "getLeftArmPose", "setLeftArmPose");
    }
}
