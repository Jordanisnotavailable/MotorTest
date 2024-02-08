// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Collectors.Feeder;

public class Feed extends Command {
  Feeder s_Feeder = new Feeder();
  /** Creates a new Feed. */
  public Feed(Feeder s_Feeder) {
    this.s_Feeder = s_Feeder;
    addRequirements(s_Feeder);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    s_Feeder.runTimer();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    s_Feeder.runFeeder();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s_Feeder.stop();
    s_Feeder.stopTimer();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return s_Feeder.getTimesUp();
  }
}
