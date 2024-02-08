// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Collectors.Intake;

public class Collect extends Command {
  Intake s_Intake = new Intake();
  /** Creates a new Collect. */
  public Collect(Intake s_Intake) {
    this.s_Intake = s_Intake;
    addRequirements(s_Intake);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    s_Intake.intake();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s_Intake.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return s_Intake.intakeDone();
  }
}
