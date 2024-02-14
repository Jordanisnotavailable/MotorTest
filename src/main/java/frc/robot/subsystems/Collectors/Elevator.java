// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Collectors;

import javax.swing.text.StyleContext.SmallAttributeSet;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
  TalonFX elevatorMotor = new TalonFX(13);
  WPI_TalonSRX leftOne = new WPI_TalonSRX(1);
  WPI_TalonSRX leftTwo = new WPI_TalonSRX(2);
  WPI_TalonSRX rightOne = new WPI_TalonSRX(3);
  WPI_TalonSRX rightTwo = new WPI_TalonSRX(4);

  private final double e_deploy = 0;
  private final double e_retract = 0;

  private final PositionDutyCycle m_position = new PositionDutyCycle(0);

  private Slot0Configs slot0Configs = new Slot0Configs();




  Joystick joystick = new Joystick(0);
  /** Creates a new Elevator. */
  public Elevator() {
    elevatorMotor.getConfigurator().apply(new TalonFXConfiguration());
    configElevator();

    
  }

  public void deployElevator(){
     //if(joystick.getRawButtonPressed(2)){
      //elevatorMotor.setControl(m_position.withPosition(e_deploy));

      //Test
      leftTwo.set(0.3);
    //}
  }
  public void retractElevator(){
      // elevatorMotor.setControl(m_position.withPosition(e_retract));

      //Test
      leftTwo.set(-0.3);
      
  }

  public boolean elevatorDeployed(){
    // if (elevatorMotor.getPosition().getValue() >= e_deploy){
    //   return true;
    // }
    // return false;

    //Test
    if(joystick.getRawButton(8)){
      return true;
    }
    return false;
  }
  public boolean elevatorRetracted(){
    // if(elevatorMotor.getPosition().getValue() <= e_retract){
    //   return true;
    // }
    // return false;

    //Test
    if(joystick.getRawButton(9)){
      return true;
    }
    return false;
  }
  public void stop(){
    // elevatorMotor.set(0);

    //test
    leftOne.set(0);
    leftTwo.set(0);
    rightOne.set(0);
    rightTwo.set(0);
  }

  public void configElevator(){
    slot0Configs.kV = 0;
    slot0Configs.kP = 0;
    slot0Configs.kI = 0;
    slot0Configs.kD = 0;
    elevatorMotor.getConfigurator().apply(slot0Configs, 0.050);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
