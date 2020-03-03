package team.cymrg.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.cymrg.subsystems.subsysIntake;


public class intakeStart extends CommandBase {
    private final subsysIntake subsysIntake = team.cymrg.subsystems.subsysIntake.getInstance();

    public intakeStart() {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.subsysIntake);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        subsysIntake.intakeStart();
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
