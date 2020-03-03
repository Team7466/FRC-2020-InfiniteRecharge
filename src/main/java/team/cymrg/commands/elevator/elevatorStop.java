package team.cymrg.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.cymrg.subsystems.subsysElevator;


public class elevatorStop extends CommandBase {
    private final subsysElevator subsysElevator = team.cymrg.subsystems.subsysElevator.getInstance();

    public elevatorStop() {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.subsysElevator);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        subsysElevator.elevatorStop();
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
