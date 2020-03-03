package team.cymrg.subsystems;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.cymrg.Constants;

public class subsysShootgazin extends SubsystemBase {
    private static subsysShootgazin INSTANCE;

    // Değişkenlerin Tanımlanması
    private Victor redlineShootgazin = new Victor(Constants.Systems.port_Shootgazin);

    public static subsysShootgazin getInstance() {
        // Fast (non-synchronized) check to reduce overhead of acquiring a lock when it's not needed
        if (INSTANCE == null) {
            // Lock to make thread safe 
            synchronized (subsysShootgazin.class) {
                // check nullness again as multiple threads can reach above null check
                if (INSTANCE == null) {
                    INSTANCE = new subsysShootgazin();
                }
            }
        }
        return INSTANCE;
    }

    private subsysShootgazin() {

    }

    public void shootgazinForward() {

    }

    public void shootgazinBackward() {

    }

    public void shootgazinStop() {

    }
}

