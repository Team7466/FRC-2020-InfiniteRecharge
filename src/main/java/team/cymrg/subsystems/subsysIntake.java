package team.cymrg.subsystems;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import team.cymrg.Constants;

public class subsysIntake extends SubsystemBase {
    private static subsysIntake INSTANCE;
    private Victor redlineIntake = new Victor(Constants.Systems.port_Intake);

    public static subsysIntake getInstance() {
        // Fast (non-synchronized) check to reduce overhead of acquiring a lock when it's not needed
        if (INSTANCE == null) {
            // Lock to make thread safe 
            synchronized (subsysIntake.class) {
                // check nullness again as multiple threads can reach above null check
                if (INSTANCE == null) {
                    INSTANCE = new subsysIntake();
                }
            }
        }
        return INSTANCE;
    }

    private subsysIntake() {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
        //       such as SpeedControllers, Encoders, DigitalInputs, etc.
    }

    public void intakeStart(){
        redlineIntake.set(0.750);
    }

    public void intakeStop(){
        redlineIntake.set(0.000);
    }
}

