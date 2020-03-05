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
        public static XboxController    controllerXbox360       = new XboxController(Constants.Controller.controllerXbox360);
        // For Real
        public static Joystick          controllerLogitech_1    = new Joystick(Constants.Controller.controllerLogitech_1);   // Motorlar
        public static Joystick          controllerLogitech_2    = new Joystick(Constants.Controller.controllerLogitech_2);   // Mekanik Aksamlar

    //  Commands
        //Intake
        private final intakeStart       intakeStart    = new intakeStart        (subsysIntake);
        private final intakeStop        intakeStop     = new intakeStop         (subsysIntake);
        //Elevator
        private final elevatorStart     elevatorStart  = new elevatorStart      (subsysElevator);
        private final elevatorStop      elevatorStop   = new elevatorStop       (subsysElevator);
        //Shootgazin
        private final shootgazinBackward     shootgazinBackward  = new shootgazinBackward      (subsysShootgazin);
        private final shootgazinForward      shootgazinForward   = new shootgazinForward       (subsysShootgazin);
        private final shootgazinStop         shootgazinStop      = new shootgazinStop          (subsysShootgazin);


    public RobotContainer()
    {
        // Xbox360 P2                   Logitech F310                     //P1 Logitech F310   P0
        /*configureButton_Xbox();*/     configureButton_Logitech2();      //configureButton_Logitech1();
    }

    private void configureButton_Xbox()
    {
        // Intake: Çalıştır - A Tuşu
        Button X1 = new JoystickButton(controllerXbox360, 1); X1.whenPressed(intakeStart);
        // Intake: Durdur   - B Tuşu
        Button X2 = new JoystickButton(controllerXbox360, 2); X2.whenPressed(intakeStop);

        // Elevator Start    - X Tuşu
        Button X3 = new JoystickButton(controllerXbox360, 3); X3.whenPressed(elevatorStart);
        // Elevator Stop     - Y Tuşu
        Button X4 = new JoystickButton(controllerXbox360, 4); X4.whenPressed(elevatorStop);

        // Shootgazin: Forward   - RB Tuşu - Basılı
        Button X5_H = new JoystickButton(controllerXbox360, 5); X5_H.whenHeld(shootgazinForward);
        // Shootgazin: Stop      - RB Tuşu - Bırakıldı
        Button X5_R = new JoystickButton(controllerXbox360, 5); X5_R.whenReleased(shootgazinStop);

        // Shootgazin: Backward   - RB Tuşu - Basılı
        Button X6_H = new JoystickButton(controllerXbox360, 6); X6_H.whenHeld(shootgazinBackward);
        // Shootgazin: Stop       - RB Tuşu - Bırakıldı
        Button X6_R = new JoystickButton(controllerXbox360, 6); X6_R.whenReleased(shootgazinStop);
        
    }

    private void configureButton_Logitech1() {
        // Elevator: Start   - LB Tuşu
        Button L5 = new JoystickButton(controllerLogitech_1, 5); L5.whenPressed(elevatorStart);
        // Elevator: Start   - RB Tuşu
        Button L6 = new JoystickButton(controllerLogitech_1, 6); L6.whenReleased(elevatorStop);
    }

    private void configureButton_Logitech2() {
        // Intake: Çalıştır - A Tuşu
        Button L2 = new JoystickButton(controllerLogitech_2, 2); L2.whenPressed(intakeStart);
        // Intake: Durdur   - B Tuşu
        Button L3 = new JoystickButton(controllerLogitech_2, 3); L3.whenPressed(intakeStop);

        // Elevator Start    - X Tuşu
        Button L1 = new JoystickButton(controllerLogitech_2, 1); L1.whenPressed(elevatorStart);
        // Elevator Stop     - Y Tuşu
        Button L4 = new JoystickButton(controllerLogitech_2, 4); L4.whenPressed(elevatorStop);

        // Shootgazin: Forward   - RB Tuşu - Basılı
        Button L5_H = new JoystickButton(controllerLogitech_2, 5); L5_H.whenHeld(shootgazinForward);
        // Shootgazin: Stop      - RB Tuşu - Bırakıldı
        Button L5_R = new JoystickButton(controllerLogitech_2, 5); L5_R.whenReleased(shootgazinStop);

        // Shootgazin: Backward   - RB Tuşu - Basılı
        Button L6_H = new JoystickButton(controllerLogitech_2, 6); L6_H.whenHeld(shootgazinBackward);
        // Shootgazin: Stop       - RB Tuşu - Bırakıldı
        Button L6_R = new JoystickButton(controllerLogitech_2, 6); L6_R.whenReleased(shootgazinStop);
    }

}
