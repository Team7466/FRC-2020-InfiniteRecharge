package team.cymrg.subsystems;
import edu.wpi.first.wpilibj.Compressor;
import team.cymrg.Constants;
import edu.wpi.first.wpilibj.Solenoid;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class subsysElevator extends SubsystemBase {
    private static subsysElevator INSTANCE;
    
    public static  Solenoid solenoidElevator = new Solenoid(Constants.Systems.port_Solenoid);
    public Compressor airComp = new Compressor();

    public static subsysElevator getInstance() {
        // Fast (non-synchronized) check to reduce overhead of acquiring a lock when it's not needed
        if (INSTANCE == null) {
            // Lock to make thread safe 
            synchronized (subsysElevator.class) {
                // check nullness again as multiple threads can reach above null check
                if (INSTANCE == null) {
                    INSTANCE = new subsysElevator();
                }
            }
        }
        return INSTANCE;
    }

    private subsysElevator() {
        airComp.setClosedLoopControl(true);
    }

    public void elevatorStart(){
        solenoidElevator.set(true);
    }

    public void elevatorStop(){
        solenoidElevator.set(false);
    }

    public void runCompress(){

    }
}

