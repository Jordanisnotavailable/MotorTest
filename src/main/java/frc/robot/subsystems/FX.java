// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.mechanisms.swerve.utility.PhoenixPIDController;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class FX extends SubsystemBase {

  TalonFX shooter = new TalonFX(5);
  TalonFX feeder = new TalonFX(14);
  Joystick joystick = new Joystick(0);
  double speed = 0;
  double feederSpeed = 0.4;
  
  private final VoltageOut m_volt = new VoltageOut(0);
  double maxOutput = 12;
  Slot0Configs slot0Configs = new Slot0Configs();
  private final VelocityVoltage m_velocity = new VelocityVoltage(0);
  
  /** Creates a new FXTest. */
  public FX() {
    shooter.getConfigurator().apply(new TalonFXConfiguration());
    shooter.setInverted(true);
    slot0Configs.kV = 0.113;
    slot0Configs.kP = 0.2;
    slot0Configs.kI = 0.001;
    slot0Configs.kD = 0.003;
    shooter.getConfigurator().apply(slot0Configs, 0.050);


    

  }
  public void playmusic(){

  }
  public void test(){
    // fx.set(speed);
    // fx.setControl(new DutyCycleOut(speed));
    //fx.setControl(m_volt.withOutput(speed*maxOutput));
    shooter.setControl(m_velocity.withVelocity(speed));
    //System.out.println(speed);
    System.out.println(shooter.get());

  }
  public void controlSpeed(){
    if(joystick.getRawButtonPressed(3)){
      speed += 10;
    }
    else if(joystick.getRawButtonPressed(2)){
      speed -= 10;
    }

    if(joystick.getRawButtonPressed(5)){
      speed -= 5;
    }
    else if(joystick.getRawButtonPressed(4)){
      speed+= 5;
    }

    if(joystick.getRawButtonPressed(6)){
      speed +=2.5;
    }
    else if(joystick.getRawButtonPressed(7)){
      speed-=2.5;
    }
  }

  public void shoot(){
    if(joystick.getRawButtonPressed(1)){
        feeder.set(feederSpeed);
    }
    else{
      feeder.set(0);
    }
  }

  public void resetSpeed(){
    speed = 0;
  }
  public void data(){
     SmartDashboard.putNumber("Set Speed", speed);
     //speed = SmartDashboard.getNumber("Set Speed", 0.1);
     SmartDashboard.putNumber("Motor output", shooter.get());
     SmartDashboard.putString("Motor Velocity", shooter.getVelocity().toString());
     SmartDashboard.putString("Motor Acceleration", shooter.getAcceleration().toString());
     
     
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
