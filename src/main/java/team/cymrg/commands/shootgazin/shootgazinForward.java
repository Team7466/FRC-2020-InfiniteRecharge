package team.cymrg.commands.shootgazin;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.cymrg.subsystems.subsysShootgazin;


public class shootgazinForward extends CommandBase {
    private final subsysShootgazin subsysShootgazin = team.cymrg.subsystems.subsysShootgazin.getInstance();

    public shootgazinForward(team.cymrg.subsystems.subsysShootgazin subsysShootgazin) {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.subsysShootgazin);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        subsysShootgazin.shootgazinForward();
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
