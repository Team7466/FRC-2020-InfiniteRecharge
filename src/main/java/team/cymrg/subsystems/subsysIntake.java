package team.cymrg.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.*;

import team.cymrg.Constants;

public class subsysIntake extends SubsystemBase {
    private static subsysIntake INSTANCE;
    public  WPI_VictorSPX redlineShootgazin = new WPI_VictorSPX(Constants.Systems.port_Shootgazin);
    private WPI_VictorSPX redlineIntake_1 = new WPI_VictorSPX(Constants.Systems.port_Intake1);
    private WPI_VictorSPX redlineIntake_2 = new WPI_VictorSPX(Constants.Systems.port_Intake2);

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
        // Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
        //       such as SpeedControllers, Encoders, DigitalInputs, etc.
    }

    public void intakeStart(){
        redlineIntake_1.set(0.500);
        redlineIntake_2.set(0.500);
    }

    public void intakeBackward(){
        redlineIntake_1.set(-0.500);
        redlineIntake_2.set(-0.500);
    }

    public void intakeStop(){
        redlineIntake_1.set(0.000);
        redlineIntake_2.set(0.000);
    }

    public void getThe_ball(){
        redlineIntake_1.set(0.550);
        redlineIntake_2.set(0.550);
        redlineShootgazin.set(0.600);

    }

    public void stop_ball(){
        redlineIntake_1.set(0);
        redlineIntake_2.set(0);
        redlineShootgazin.set(0);
    }
}

