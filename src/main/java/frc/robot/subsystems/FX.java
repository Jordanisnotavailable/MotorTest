// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FX extends SubsystemBase {
TalonFX fx = new TalonFX(5);
Joystick joystick = new Joystick(0);
double speed = 0;
  /** Creates a new FXTest. */
  public FX() {
    fx.setInverted(true);
    

  }

  public void test(){
    fx.set(speed);
    System.out.println(speed);
    System.out.println(fx.get());
  }
  public void controlSpeed(){
    if(joystick.getRawButtonPressed(3) == true){
      speed += 0.1;
    }
    else if(joystick.getRawButtonPressed(2) == true){
      speed -= 0.1;
    }

    if(joystick.getRawButtonPressed(5)){
      speed -= 0.05;
    }
    else if(joystick.getRawButtonPressed(4)){
      speed+= 0.05;
    }
  }

  public StatusSignal<Double> getSpeed(){
    return (fx.getVelocity());
  }
  public void resetSpeed(){
    speed = 0;
  }
  public void data(){
     SmartDashboard.putNumber("Set Speed", speed);
     //speed = SmartDashboard.getNumber("Set Speed", 0.1);
     SmartDashboard.putNumber("Motor output", fx.get());
     SmartDashboard.putString("Motor Velocity", fx.getVelocity().toString());
     
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
