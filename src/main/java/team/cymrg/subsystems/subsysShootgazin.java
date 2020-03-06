package team.cymrg.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.*;
import team.cymrg.Constants;

public class subsysShootgazin extends SubsystemBase {
    private static subsysShootgazin INSTANCE;

    // Değişkenlerin Tanımlanması
    public WPI_VictorSPX redlineShootgazin = new WPI_VictorSPX(Constants.Systems.port_Shootgazin);

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

    /* Intake motorunun çalışma hızı belirlendi
       1.00  = Motor: 100%
       0.75  = Motor: 75%
       0.50  = Motor: 50%
       0.25  = Motor: 25%
       0.00  = Motor: 00%
    */
    // Motor değerleri kaptanın isteği üzerine yüzde 50 yapıldı

    private subsysShootgazin() {

    }

    public void shootgazinForward() {
        redlineShootgazin.set(0.500);
    }

    public void shootgazinBackward() {
        redlineShootgazin.set(-0.500);
    }

    public void shootgazinStop() {
        redlineShootgazin.set(0.000);
    }
}

