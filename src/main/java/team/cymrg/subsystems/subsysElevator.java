package team.cymrg.subsystems;
import team.cymrg.Constants;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class subsysElevator extends SubsystemBase {
    private static subsysElevator INSTANCE;
    Compressor airCompressor = new Compressor(1);
    public static Solenoid solenoidElevator = new Solenoid(Constants.Systems.port_Solenoid);

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
        airCompressor = new Compressor(1);
        airCompressor.start();
    }

    public void elevatorStart(){
        solenoidElevator.set(true);
    }

    public void elevatorStop(){
        solenoidElevator.set(false);
    }
}

