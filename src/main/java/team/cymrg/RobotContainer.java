/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package team.cymrg;
import team.cymrg.subsystems.*;

import team.cymrg.commands.intake.*;
import team.cymrg.commands.elevator.*;
import team.cymrg.commands.shootgazin.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class RobotContainer
{
    //  Subsystems
        private final subsysIntake          subsysIntake        = team.cymrg.subsystems.subsysIntake        .getInstance();
        private final subsysElevator        subsysElevator      = team.cymrg.subsystems.subsysElevator      .getInstance();
        private final subsysShootgazin      subsysShootgazin    = team.cymrg.subsystems.subsysShootgazin    .getInstance();

    //  Controllers
        // For Test
        public static XboxController    controllerXbox360       = new XboxController(Constants.Controller.controllerXbox360); // Aksamlar
        // For Real
        public static Joystick          controllerLogitech    = new Joystick(Constants.Controller.controllerLogitech);   // Motorlar

    //  Commands
        //Intake
        private final intakeStart       intakeStart    = new intakeStart        (subsysIntake);
        private final intakeStop        intakeStop     = new intakeStop         (subsysIntake);
        private final intakeBackward    intakeBackward = new intakeBackward     (subsysIntake);
        private final getThe_ball       getThe_ball    = new getThe_ball        (subsysIntake);
        private final stop_ball         stop_ball      = new stop_ball          (subsysIntake);
        //Elevator
        private final elevatorStart     elevatorStart  = new elevatorStart      (subsysElevator);
        private final elevatorStop      elevatorStop   = new elevatorStop       (subsysElevator);
        //Shootgazin
        private final shootgazinBackward     shootgazinBackward  = new shootgazinBackward      (subsysShootgazin);
        private final shootgazinForward      shootgazinForward   = new shootgazinForward       (subsysShootgazin);
        private final shootgazinStop         shootgazinStop      = new shootgazinStop          (subsysShootgazin);


    public RobotContainer()
    {
        // Xbox360 P2
        configureButton_Logi(); configureButton_Xbox();
    }

    private void configureButton_Xbox(){
        // Elevator Start    - B Tuşu
        Button X6 = new JoystickButton(controllerXbox360, 6); X6.whenPressed(elevatorStart);
        // Elevator Stop     - B Tuşu
        Button X5 = new JoystickButton(controllerXbox360, 5); X5.whenPressed(elevatorStop);

    }

    private void configureButton_Logi()
    {
        // Get Ball - X Tuşu H
        Button L1_H   = new JoystickButton(controllerLogitech, 1); L1_H.whenHeld(getThe_ball);
        // Get Ball - X Tuşu R
        Button L1_R   = new JoystickButton(controllerLogitech, 1); L1_R.whenReleased(stop_ball);


        // Intake: Çalıştır - LB Tuşu
        Button X1_1 = new JoystickButton(controllerLogitech, 5); X1_1.whenHeld(intakeStart);
        // Intake: Durdur   - LB Tuşu
        Button X1_2 = new JoystickButton(controllerLogitech, 5); X1_2.whenReleased(intakeStop);

        // Intake: Geri     - LT Tuşu
        Button X2_1 = new JoystickButton(controllerLogitech, 7); X2_1.whenHeld(intakeBackward);
        // Intake: Durdur   - LT Tuşu
        Button X2_2 = new JoystickButton(controllerLogitech, 7); X2_2.whenReleased(intakeStop);

        // Shootgazin: Forward   - RB Tuşu - Basılı
        Button X6_H = new JoystickButton(controllerLogitech, 6); X6_H.whenHeld(shootgazinForward);
        // Shootgazin: Stop      - RB Tuşu - Bırakıldı
        Button X6_R = new JoystickButton(controllerLogitech, 6); X6_R.whenReleased(shootgazinStop);

        // Shootgazin: Backward   - RB Tuşu - Basılı
        Button X8_H = new JoystickButton(controllerLogitech, 8); X8_H.whenHeld(shootgazinBackward);
        // Shootgazin: Stop       - RB Tuşu - Bırakıldı
        Button X8_R = new JoystickButton(controllerLogitech, 8); X8_R.whenReleased(shootgazinStop);
        
    }

}
