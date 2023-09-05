package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class SighterIOReal implements SighterIO {
    private final AnalogPotentiometer encoder;
    public SighterIOReal() {
        encoder = new AnalogPotentiometer(1, 1, 1);
    }
}
