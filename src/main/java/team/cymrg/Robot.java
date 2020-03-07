/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team.cymrg;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import team.cymrg.subsystems.*;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends TimedRobot
{
    private RobotContainer robotContainer;    

    public static subsysDrivebase   subsysDrivebase     = null;
    public static subsysElevator    subsysElevator      = null;
    public static subsysIntake      subsysIntake        = null;
    public static subsysShootgazin  subsysShootgazin    = null;

    private static Timer timer = new Timer();

    @Override
    public void robotInit()
    {
        robotContainer = new RobotContainer();
        subsysDrivebase     = team.cymrg.subsystems.subsysDrivebase     .getInstance();
        subsysElevator      = team.cymrg.subsystems.subsysElevator      .getInstance();
        subsysIntake        = team.cymrg.subsystems.subsysIntake        .getInstance();
        subsysShootgazin    = team.cymrg.subsystems.subsysShootgazin    .getInstance();


        subsysElevator.airComp.clearAllPCMStickyFaults();
        subsysElevator.airComp.setClosedLoopControl(true);
        subsysElevator.airComp.start();
    }

    @Override
    public void robotPeriodic() { 
        CommandScheduler.getInstance().run();

        SmartDashboard.putBoolean("SwitchP", subsysElevator.airComp.getPressureSwitchValue());
        SmartDashboard.putBoolean("getClosedLoopControl", subsysElevator.airComp.getClosedLoopControl());
        SmartDashboard.putBoolean("getCompressorNotConnectedFault", subsysElevator.airComp.getCompressorNotConnectedFault());
        SmartDashboard.putBoolean("getCompressorShortedFault", subsysElevator.airComp.getCompressorShortedFault());
        SmartDashboard.putBoolean("getCompressorCurrentTooHighFault", subsysElevator.airComp.getCompressorCurrentTooHighFault());
    }
    @Override public void disabledInit() { }
    @Override public void disabledPeriodic() { }

    @Override public void autonomousInit() { 
        if(robotContainer.getAutonom() != null){
            robotContainer.getAutonom().schedule();
        }
    }
    @Override public void autonomousPeriodic() {
    }

    @Override public void teleopInit() {
        robotContainer.getAutonom().cancel();
        subsysElevator.airComp.start();
    }
    @Override public void teleopPeriodic() {
        subsysDrivebase.Drive(RobotContainer.controllerXbox360.getRawAxis(1)     , RobotContainer.controllerXbox360.getRawAxis(5));
        //subsysDrivebase.Drive(RobotContainer.controllerLogitech.getRawAxis(1)  , RobotContainer.controllerLogitech.getRawAxis(3));
    }

    @Override public void testInit() { CommandScheduler.getInstance().cancelAll(); }
    @Override public void testPeriodic() { }
}
