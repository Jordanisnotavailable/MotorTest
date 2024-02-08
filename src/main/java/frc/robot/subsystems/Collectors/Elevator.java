// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Collectors;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
  TalonFX elevatorMotor = new TalonFX(13);

  private final double e_deploy = 0;
  private final double e_retract = 0;

  private final PositionDutyCycle m_position = new PositionDutyCycle(0);

  Joystick joystick = new Joystick(0);
  /** Creates a new Elevator. */
  public Elevator() {
    elevatorMotor.getConfigurator().apply(new TalonFXConfiguration());
  }

  public void deployElevator(){
    if(joystick.getRawButtonPressed(2)){
      elevatorMotor.setControl(m_position.withPosition(e_deploy));
    }
  }
  public void retractElevator(){
      elevatorMotor.setControl(m_position.withPosition(e_retract));
  }

  public boolean elevatorDeployed(){
    if (elevatorMotor.getPosition().getValue() >= e_deploy){
      return true;
    }
    return false;
  }
  public boolean elevatorRetracted(){
    if(elevatorMotor.getPosition().getValue() <= e_retract){
      return true;
    }
    return false;
  }
  public void stop(){
    elevatorMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
