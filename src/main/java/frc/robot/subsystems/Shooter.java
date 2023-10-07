package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private TalonSRX inputvalve = new TalonSRX(0);
    private TalonSRX outputvalve = new TalonSRX(0);
    
    public void openinput() {
        inputvalve.set(ControlMode.PercentOutput, 100);
    }
    public void closevalve() {
        inputvalve.set(ControlMode.PercentOutput, 0);
    } 
    public void openoutput() {
        outputvalve.set(ControlMode.PercentOutput, 100);
    }
    public void closeoutput() {
        outputvalve.set(ControlMode.PercentOutput, 0);
    }
    
}
