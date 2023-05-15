package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public final class DefaultDriveCommand extends CommandBase {

    private final DriveSubsystem driveSubsystem;
    private final DoubleSupplier translationSupplier;
    private final DoubleSupplier rotationSupplier;

    public DefaultDriveCommand(
        DriveSubsystem driveSubsystem,
        DoubleSupplier translationSupplier,
        DoubleSupplier rotationSupplier
    ) {
        this.driveSubsystem = driveSubsystem;
        this.translationSupplier = translationSupplier;
        this.rotationSupplier = rotationSupplier;
        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        driveSubsystem.teleopDrive(-translationSupplier.getAsDouble(), -rotationSupplier.getAsDouble());
    }
    
    @Override
    public void end(boolean interrupted) {
        driveSubsystem.teleopDrive(0, 0);
    }
}
