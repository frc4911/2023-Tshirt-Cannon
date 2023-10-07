package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Arm extends SubsystemBase {
    private TalonSRX ArmTalon = new TalonSRX(0);
    private AnalogInput encoder = new AnalogInput(0);

    public void SetMotorSpeed(double speed) {
        ArmTalon.set(ControlMode.PercentOutput, speed);

    }

    public double ReadEncoder(){
        return encoder.getVoltage(); //probably not right
    }
    
}