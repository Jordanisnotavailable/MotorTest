// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Collectors;


import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  //Intake 11
  TalonFX intakeMotor = new TalonFX(12);
  TalonFX elevatorMotor =  new TalonFX(13);
  public static Joystick joystick = new Joystick(0);
  DigitalInput ir_sensor = new DigitalInput(0);

  
  
  private final VoltageOut m_volt = new VoltageOut(0);
  private final double maxVolt = 11;
 

  boolean ir_wasFalse = false;
  /** Creates a new Intak. */
  public Intake() {
    intakeMotor.getConfigurator().apply(new TalonFXConfiguration());
    elevatorMotor.getConfigurator().apply(new TalonFXConfiguration());
    //Press button, Intake goes to IR sensor, stops, pressed another button, the elevator goes to another position, and feeder? runs

  }
  public void intake(){
    if(joystick.getRawButtonPressed(1)){
      intakeMotor.setControl(m_volt.withOutput(maxVolt*0.4));
    }
    else{
      intakeMotor.setControl(m_volt.withOutput(0));
    }
  }
  public void stop(){
    intakeMotor.set(0);
  }
  public boolean intakeDone(){
    if(ir_sensor.get() == false){
      ir_wasFalse = true;
      }
    if(ir_sensor.get() == true && ir_wasFalse){
        return true;
    }
    return false;
  }
  public static boolean triggerPressed(){
    if(joystick.getRawButtonPressed(1)){
      return true;
    }
    return false;
  }

  //Run feeder for 2 second, then retract, run timer in command?



    
 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
