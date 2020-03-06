/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team.cymrg.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.cymrg.subsystems.ExampleSubsystem;

/**
 * An example command that uses an example subsystem.
 */
public class ExampleCommand extends CommandBase
{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField", "FieldCanBeLocal"})
    private final ExampleSubsystem subsystem;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public ExampleCommand(ExampleSubsystem subsystem)
    {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }
}
