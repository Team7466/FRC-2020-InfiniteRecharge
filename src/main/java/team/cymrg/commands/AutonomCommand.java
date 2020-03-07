/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team.cymrg.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.cymrg.subsystems.MesafeSensor;
import team.cymrg.subsystems.subsysDrivebase;
import team.cymrg.subsystems.subsysShootgazin;
import edu.wpi.first.wpilibj.Timer;

/**
 * An example command that uses an example subsystem.
 */
public class AutonomCommand extends CommandBase
{
    private final Timer timer = new Timer();
    private final MesafeSensor m_sensor;
    private final subsysDrivebase m_drive;
    private final subsysShootgazin m_mag;
    boolean situation;
    
    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public AutonomCommand()
    {
        m_sensor = MesafeSensor.getInstance();
        m_drive = subsysDrivebase.getInstance();
        m_mag = subsysShootgazin.getInstance();
        addRequirements(m_sensor, m_drive,m_mag);
        
        situation = false;

    }

    @Override
    public void initialize() {
        situation = false;
        timer.start();
    }

    @Override
    public void execute() {
        if(m_sensor.distanceGet() > 12.0){
            m_drive.Drive(-0.7, -0.7);

        }
        else if(m_sensor.distanceGet() <= 12.0){
            m_drive.Drive(0, 0);
            m_mag.shootgazinForward();

            if(timer.get() >= 10)
            {
                m_mag.shootgazinStop();
            }

        }


    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return this.situation;
    }

    @Override
    public void end(boolean interrupted) {
        m_drive.Drive(0, 0);
        m_mag.shootgazinStop();
        timer.stop();
    }
}
