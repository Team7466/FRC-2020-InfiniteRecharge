package team.cymrg.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.cymrg.subsystems.subsysIntake;


public class intakeBackward extends CommandBase {
    private final subsysIntake subsysIntake = team.cymrg.subsystems.subsysIntake.getInstance();

    public intakeBackward(team.cymrg.subsystems.subsysIntake subsysIntake) {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.subsysIntake);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        subsysIntake.intakeBackward();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
