// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Collectors;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  //Intake 11
  TalonFX intakeMotor = new TalonFX(14);
  public static Joystick joystick = new Joystick(0);

  WPI_TalonSRX leftOne = new WPI_TalonSRX(1);
  WPI_TalonSRX leftTwo = new WPI_TalonSRX(2);
  WPI_TalonSRX rightOne = new WPI_TalonSRX(3);
  WPI_TalonSRX rightTwo = new WPI_TalonSRX(4);
  DigitalInput ir_sensor;
  //AnalogInput ir_sensor = new AnalogInput(4);

  Slot0Configs slot0Configs = new Slot0Configs();

  
  
  private final VoltageOut m_volt = new VoltageOut(0);
  private final double maxVolt = 11; 

  boolean ir_wasFalse = false;
  /** Creates a new Intak. */
  public Intake() {
    intakeMotor.getConfigurator().apply(new TalonFXConfiguration());
    configFeeder();
    //Press button, Intake goes to IR sensor, stops, pressed another button, the elevator goes to another position, and feeder? runs
    ir_sensor = new DigitalInput(1);

    SmartDashboard.putBoolean("IR", false);
  }
  public void intake(){
    // if(joystick.getRawButton(1)){
    //   intakeMotor.setControl(m_volt.withOutput(maxVolt*0.2));
    // }
    // else{
    //   stop();
    // }
//Test
    if(joystick.getRawButton(1)){
      leftOne.set(0.3);
      leftTwo.set(0.3);
    }
    else{
      stop();
    }
  }
  public void stop(){
      //intakeMotor.setControl(m_volt.withOutput(0));

      //Test
      leftOne.set(0);
      leftTwo.set(0);
      rightOne.set(0);
      rightTwo.set(0);

  }
  // public boolean intakeDone(){
  //   // if(ir_sensor.get()){
  //   //   ir_wasFalse = true;
  //   //   }
  //   // if(ir_sensor.get() == true && ir_wasFalse){
  //   //     return true;
  //   // }
  //     //return false;

  //     if(joystick.getRawButton(7)){
  //       return true;
  //     }
  //     return false; 
  // }
  public static boolean triggerPressed(){
    if(joystick.getRawButton(1)){
      return true;
    }
    return false;
  }

  //Run feeder for 2 second, then retract, run timer in command?

  public void configFeeder(){
    slot0Configs.kV = 0;
    slot0Configs.kP = 0;
    slot0Configs.kI = 0;
    slot0Configs.kD = 0;
    intakeMotor.getConfigurator().apply(slot0Configs, 0.050);
  }


    
 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("IR", ir_sensor.get());
    if(ir_sensor.get()){
      leftOne.set(0.3);
    }
    else if(joystick.getRawButton(1)){
      leftOne.set(0.3);
    }
    else{
      stop();
    }
  }
}
