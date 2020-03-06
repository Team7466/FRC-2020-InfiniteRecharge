package team.cymrg.commands.shootgazin;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.cymrg.subsystems.subsysShootgazin;


public class shootgazinBackward extends CommandBase {
    private final subsysShootgazin subsysShootgazin = team.cymrg.subsystems.subsysShootgazin.getInstance();

    public shootgazinBackward(team.cymrg.subsystems.subsysShootgazin subsysShootgazin) {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.subsysShootgazin);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        subsysShootgazin.shootgazinBackward();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
