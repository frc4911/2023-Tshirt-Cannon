package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private TalonSRX Left1 = new TalonSRX(0);
    private TalonSRX Left2 = new TalonSRX(0);
    private TalonSRX Right1 = new TalonSRX(0);
    private TalonSRX Right2 = new TalonSRX(0);
    

    public void Drive(double speed, double rotate) {
        Right1.setInverted(true);
        Right2.setInverted(true);

    }
}