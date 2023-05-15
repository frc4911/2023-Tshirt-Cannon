// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.DefaultDriveCommand;

public class DriveSubsystem extends SubsystemBase {
  private final WPI_TalonSRX leftFront;
  private final WPI_TalonSRX leftMiddle;
  private final WPI_TalonSRX leftBack;
  private final WPI_TalonSRX rightFront;
  private final WPI_TalonSRX rightMiddle;
  private final WPI_TalonSRX rightBack;

  private final MotorControllerGroup left;
  private final MotorControllerGroup right;

  private final DifferentialDrive differentialDrive;

  private final AHRS gyro;

  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
    leftFront = new WPI_TalonSRX(Constants.FRONT_LEFT_DRIVE);
    leftMiddle = new WPI_TalonSRX(Constants.MIDDLE_LEFT_DRIVE);
    leftBack = new WPI_TalonSRX(Constants.BACK_LEFT_DRIVE);
    rightFront = new WPI_TalonSRX(Constants.FRONT_RIGHT_DRIVE);
    rightMiddle = new WPI_TalonSRX(Constants.MIDDLE_RIGHT_DRIVE);
    rightBack = new WPI_TalonSRX(Constants.BACK_RIGHT_DRIVE);

    configureMotors();

    left = new MotorControllerGroup(leftFront, leftMiddle, leftBack);
    right = new MotorControllerGroup(rightFront, rightMiddle, rightBack);
    
    differentialDrive = new DifferentialDrive(left, right);

    gyro = new AHRS(SPI.Port.kMXP);
    gyro.zeroYaw();
    gyro.resetDisplacement();
  }

  private void configureMotors() {
    TalonSRXConfiguration configuration = new TalonSRXConfiguration();
    configuration.peakCurrentLimit = 1;
    configuration.peakCurrentDuration = 1;
    configuration.continuousCurrentLimit = 1;
    leftFront.configAllSettings(configuration, Constants.LONG_CAN_TIMEOUTS_MS);
  }

  public void teleopDrive(double xSpeed, double zRotation) {
    differentialDrive.arcadeDrive(xSpeed, zRotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public CommandBase createDefaultCommand(
      DoubleSupplier translationSupplier, DoubleSupplier rotationSupplier) {
    return new DefaultDriveCommand(this, translationSupplier, rotationSupplier);
  }
}
