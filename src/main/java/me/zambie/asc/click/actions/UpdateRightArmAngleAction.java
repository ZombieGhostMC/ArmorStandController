package me.zambie.asc.click.actions;

public final class UpdateRightArmAngleAction extends UpdateAngleAction {

    public UpdateRightArmAngleAction(int slot, double x, double y, double z) {
        super(slot, x, y, z, "getRightArmPose", "setRightArmPose");
    }
}
