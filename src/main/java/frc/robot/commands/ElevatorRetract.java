// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Collectors.Elevator;

public class ElevatorRetract extends Command {
  Elevator s_Elevator = new Elevator();
  /** Creates a new ElevatorRetract. */
  public ElevatorRetract(Elevator s_Elevator) {
    this.s_Elevator = s_Elevator;
    addRequirements(s_Elevator);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    s_Elevator.retractElevator();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s_Elevator.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return s_Elevator.elevatorRetracted();
  }
}