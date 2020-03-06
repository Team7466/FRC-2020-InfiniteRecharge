package team.cymrg.subsystems;
import team.cymrg.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.*;

// Ben burayı nasıl açıklıycam acaba neyse
/*
 * 1 Mart 2020 Saat 00.30'dan beri Logitech'i test edicez diye kanser olduğumuzdan dolayı
 * en bol kaynağı bulundurduğundan ve hiç bir kütüphane fark etmediğinden dolayı burada
 * Victor kullandık değiştirmenize gerek yok ancak isterseniz tabii
 */

import edu.wpi.first.wpilibj.SpeedControllerGroup;


public class subsysDrivebase extends SubsystemBase {
    private static subsysDrivebase INSTANCE;

    public static subsysDrivebase getInstance() {
        // Fast (non-synchronized) check to reduce overhead of acquiring a lock when it's not needed
        if (INSTANCE == null) {
            // Lock to make thread safe 
            synchronized (subsysDrivebase.class) {
                // check nullness again as multiple threads can reach above null check
                if (INSTANCE == null) {
                    INSTANCE = new subsysDrivebase();
                }
            }
        }
        return INSTANCE;
    }

    private subsysDrivebase() { }


    // Sol taraf için driverlar
    public static SpeedControllerGroup cymrgMotorLeft = new SpeedControllerGroup(
            new WPI_VictorSPX(Constants.Drive.portMotorLeftFront),
            new WPI_VictorSPX(Constants.Drive.portMotorLeftBack)
    );
    // Sağ taraf için driverlar
    public static SpeedControllerGroup cymrgMotorRight = new SpeedControllerGroup(
            new WPI_VictorSPX(Constants.Drive.portMotorRightFront),
            new WPI_VictorSPX(Constants.Drive.portMotorRightBack)
    );



    private double scaleLeft(double left) { return 0.2 * left; }
    private double scaleRight(double right) { return 0.2 * right; }



    public void setMotors(double left, double right) {
        left = scaleLeft(left);
        right = scaleRight(right);

        setMotorsRaw(left, right);
    }

    public void setMotorsRaw(double left, double right) {
        cymrgMotorLeft.set(left);
        cymrgMotorRight.set(right);
    }

    public static DifferentialDrive cymrgDrive = new DifferentialDrive(cymrgMotorLeft, cymrgMotorRight);
    public void Drive(double fwd, double rot) {
        cymrgDrive.tankDrive(-fwd, -rot);
    }
}

