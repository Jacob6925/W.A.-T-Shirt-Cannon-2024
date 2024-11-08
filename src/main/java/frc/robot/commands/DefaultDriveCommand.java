package frc.robot.commands;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swerve.DrivetrainSubsystem;

import java.util.function.DoubleSupplier;

public class DefaultDriveCommand extends Command {
    private final DrivetrainSubsystem m_drivetrainSubsystem;

    private final DoubleSupplier m_translationXSupplier;
    private final DoubleSupplier m_translationYSupplier;
    private final DoubleSupplier m_rotationSupplier;

    public DefaultDriveCommand(DrivetrainSubsystem drivetrainSubsystem,
                               DoubleSupplier translationXSupplier,
                               DoubleSupplier translationYSupplier,
                               DoubleSupplier rotationSupplier) {
        this.m_drivetrainSubsystem = drivetrainSubsystem;
        this.m_translationXSupplier = translationXSupplier;
        this.m_translationYSupplier = translationYSupplier;
        this.m_rotationSupplier = rotationSupplier;

        addRequirements(drivetrainSubsystem);
    }

    // FIXME might work, idk lol
    @Override
    public void execute() {
        // You can use `new ChassisSpeeds(...)` for robot-oriented movement instead of field-oriented movement
        m_drivetrainSubsystem.drive(
            new Translation2d(m_translationXSupplier.getAsDouble(), m_translationYSupplier.getAsDouble()),
            m_rotationSupplier.getAsDouble(),
            false
        );
    }

    // FIXME might not need this... not sure why its here
    @Override
    public void end(boolean interrupted) {
        m_drivetrainSubsystem.drive(new Translation2d(), 0, false);
    }
}
