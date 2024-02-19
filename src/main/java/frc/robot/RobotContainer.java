// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.DoNothing;
import frc.robot.commands.E_DeployRetract;
import frc.robot.commands.ElevatorDeploy;
import frc.robot.commands.ElevatorRetract;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeAndShoot;
import frc.robot.commands.LEDon;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IR;
import frc.robot.subsystems.LEDlights;
import frc.robot.subsystems.Collectors.Feeder;
import frc.robot.subsystems.Collectors.Elevator;
import frc.robot.subsystems.Collectors.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final static Elevator s_Elevator = new Elevator();
  private final static Intake s_Intake = new Intake();
  private final static Feeder s_Feeder = new Feeder();

  private static final LEDlights s_led = new LEDlights();
  //private final static IR s_IR = new IR();

  private final E_DeployRetract c_deployRetract = new E_DeployRetract(s_Elevator);

  private final IntakeAndShoot sc_InAndShoot = new IntakeAndShoot(s_Elevator, s_Feeder);
  private final DoNothing c_idle = new DoNothing();

  private final ElevatorDeploy c_eDeploy = new ElevatorDeploy(s_Elevator);
  private final ElevatorRetract c_eRetract = new ElevatorRetract(s_Elevator);
  public static CommandJoystick commandJoystick = new CommandJoystick(0);
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();



  private final LEDon c_ledOn = new LEDon(s_led);


  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //s_Elevator.setDefaultCommand(c_eDeploy);
    // Configure the trigger bindings
    configureBindings();

    //s_led.setDefaultCommand(c_ledOn);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // new Trigger(m_exampleSubsystem::exampleCondition)
    //     .onTrue(new ExampleCommand(m_exampleSubsystem));

    

    commandJoystick.button(2).onTrue(sc_InAndShoot).onFalse(c_idle);

    //commandJoystick.button(2).onTrue(c_deployRetract);

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
