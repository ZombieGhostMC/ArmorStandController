package me.zambie.asc.click.actions;

public final class UpdateRightLegAngleAction extends UpdateAngleAction {

    public UpdateRightLegAngleAction(int slot, double x, double y, double z) {
        super(slot, x, y, z, "getRightLegPose", "setRightLegPose");
    }
}
