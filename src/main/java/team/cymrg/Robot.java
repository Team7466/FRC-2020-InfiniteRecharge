/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team.cymrg;
import team.cymrg.subsystems.*;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot
{
    private RobotContainer robotContainer;

    public static subsysDrivebase   subsysDrivebase     = null;
    public static subsysElevator    subsysElevator      = null;
    public static subsysIntake      subsysIntake        = null;
    public static subsysShootgazin  subsysShootgazin    = null;

    @Override
    public void robotInit()
    {
        robotContainer = new RobotContainer();
        subsysDrivebase     = team.cymrg.subsystems.subsysDrivebase     .getInstance();
        subsysElevator      = team.cymrg.subsystems.subsysElevator      .getInstance();
        subsysIntake        = team.cymrg.subsystems.subsysIntake        .getInstance();
        subsysShootgazin    = team.cymrg.subsystems.subsysShootgazin    .getInstance();
    }

    @Override
    public void robotPeriodic() { CommandScheduler.getInstance().run(); }
    @Override public void disabledInit() { }
    @Override public void disabledPeriodic() { }

    @Override public void autonomousInit() { }
    @Override public void autonomousPeriodic() { }

    @Override public void teleopInit() { }
    @Override public void teleopPeriodic() { }

    @Override public void testInit() { CommandScheduler.getInstance().cancelAll(); }
    @Override public void testPeriodic() { }
}
