// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Collectors.Elevator;
import frc.robot.subsystems.Collectors.Feeder;
import frc.robot.subsystems.Collectors.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class IntakeAndShoot extends SequentialCommandGroup {
  Elevator s_Elevator = new Elevator();
  Feeder s_Feeder = new Feeder();
  Intake s_Intake = new Intake();

  
  /** Creates a new Shoot. */
  public IntakeAndShoot(Elevator s_Elevator, Feeder s_Feeder, Intake s_Intake) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    if(Intake.triggerPressed()){
      addCommands(
        new Collect(s_Intake),
        new ElevatorDeploy(s_Elevator), 
        new Feed(s_Feeder),
        new ElevatorRetract(s_Elevator)
        );
    }
  }
}

