/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team.cymrg.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogInput;

public class MesafeSensor extends SubsystemBase {
  /**
   * Creates a new MesafeSensor.
   */
  private static MesafeSensor INSTANCE;
  
  public static MesafeSensor getInstance() {
    // Fast (non-synchronized) check to reduce overhead of acquiring a lock when it's not needed

    if (INSTANCE == null) {
        // Lock to make thread safe 
        synchronized (MesafeSensor.class) {
            // check nullness again as multiple threads can reach above null check
            if (INSTANCE == null) {
                INSTANCE = new MesafeSensor();
            }
        }
    }
    return INSTANCE;
}

  public AnalogInput ultra = new AnalogInput(0);

  public MesafeSensor() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public double distanceGet()
  {
    return(ultra.getValue() * 0.3175);
  }
}
