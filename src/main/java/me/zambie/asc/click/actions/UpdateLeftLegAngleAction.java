package me.zambie.asc.click.actions;

public final class UpdateLeftLegAngleAction extends UpdateAngleAction {

    public UpdateLeftLegAngleAction(int slot, double x, double y, double z) {
        super(slot, x, y, z, "getLeftLegPose", "setLeftLegPose");
    }
}
