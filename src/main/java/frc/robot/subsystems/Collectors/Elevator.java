// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Collectors;

import javax.swing.text.StyleContext.SmallAttributeSet;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//soid red, turn off, blinking yellow, blinking green 

public class Elevator extends SubsystemBase {
  TalonFX elevatorMotor = new TalonFX(11);
  // WPI_TalonSRX leftOne = new WPI_TalonSRX(1);
  // WPI_TalonSRX leftTwo = new WPI_TalonSRX(2);
  // WPI_TalonSRX rightOne = new WPI_TalonSRX(3);
  // WPI_TalonSRX rightTwo = new WPI_TalonSRX(4);

  Slot0Configs slot0Config;
  TalonFXConfiguration elevatorConfig;
  MotionMagicConfigs motionMagicConfigs;  
  MotionMagicVoltage m_position;
  

  private final double e_deploy = 50;
  private final double e_retract = 0;

  boolean retracted;

  Joystick joystick = new Joystick(0);
  /** Creates a new Elevator. */
  public Elevator() {
    elevatorMotor.getConfigurator().apply(new TalonFXConfiguration());
    configElevator();

    retracted = false;

  // elevatorConfigs = talonFXConfig.MotionMagicConfigs;

  }

  public void deployElevator(){
      elevatorMotor.setControl(m_position.withPosition(e_deploy));

    // //Test
      // leftTwo.set(0.3);
  }
  public void 
  retractElevator(){
      elevatorMotor.setControl(m_position.withPosition(e_retract));

      // //Test
      // leftTwo.set(-0.3);
      
  }

  public boolean elevatorDeployed(){
    // if (elevatorMotor.getPosition().getValue() >= e_deploy){
    //   return true;
    // }
    // return false;
//  ...
    if(elevatorMotor.getPosition().getValue() > e_deploy + 1 || elevatorMotor.getPosition().getValue() > e_deploy - 1){
        retracted = false;
    }
    return !retracted;

    // if(joystick.getRawButton(4)){
    //   return true;
    // }
    // return false;
  }
  public boolean elevatorRetracted(){
    // if(elevatorMotor.getPosition().getValue() <= e_retract){
    //   return true;
    // }
    // return false;

    // //Test
    //  if(joystick.getRawButton(5)){
    //    return true;
    //  }
    //  return false;

   if(elevatorMotor.getPosition().getValue() < e_retract + 1 || elevatorMotor.getPosition().getValue() < e_retract - 1){
       retracted = true;
    }
    return retracted;
  }
  public void stop(){
    elevatorMotor.stopMotor();;

    //test
    // leftOne.set(0);
    // leftTwo.set(0);
    // rightOne.set(0);
    // rightTwo.set(0);
  }

  public void configElevator(){
    elevatorConfig = new TalonFXConfiguration();

    m_position = new MotionMagicVoltage(0);

    slot0Config = elevatorConfig.Slot0;

    slot0Config.kS = 0;
    slot0Config.kV = 1.1;
    slot0Config.kA = 0;
    slot0Config.kP = 1.2;
    slot0Config.kI = 0;
    slot0Config.kD = 0.01;

    motionMagicConfigs = elevatorConfig.MotionMagic;

    motionMagicConfigs.MotionMagicCruiseVelocity = 10;
    motionMagicConfigs.MotionMagicAcceleration = 3;
    motionMagicConfigs.MotionMagicExpo_kV = 2.9;
    motionMagicConfigs.MotionMagicJerk = 2.70;

    elevatorMotor.getConfigurator().apply(elevatorConfig);

  }



  @Override
  public void periodic() {
    SmartDashboard.putNumber("E_Position", elevatorMotor.getPosition().getValue());

    SmartDashboard.putBoolean("Retracted", elevatorRetracted());
    SmartDashboard.putBoolean("Deployed?", elevatorDeployed());

    SmartDashboard.putBoolean("Boolean Retract", retracted);
    // This method will be called once per scheduler run
  }
}
//