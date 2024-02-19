// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Collectors;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Feeder extends SubsystemBase {
  //TalonFX feederMotor = new TalonFX(11);
  WPI_TalonSRX leftOne = new WPI_TalonSRX(1);
  WPI_TalonSRX leftTwo = new WPI_TalonSRX(2);
  WPI_TalonSRX rightOne = new WPI_TalonSRX(3);
  WPI_TalonSRX rightTwo = new WPI_TalonSRX(4);

  private Slot0Configs slot0Configs = new Slot0Configs();

  Timer timer = new Timer();
  boolean timesUp = false;
  /** Creates a new Feeder. */
  public Feeder() {
    //feederMotor.getConfigurator().apply(new TalonFXConfiguration());
    configFeeder();
    
    timer.stop();
    timer.reset();
  }
  public void runFeeder(){
    //feederMotor.set(0.2);

    //Test
    rightOne.set(0.3);
    rightTwo.set(0.3);
  }

  public void runTimer(){
    timer.start();
    // if(timer.get()>3){
    //   timesUp = true;
    // }
    // return timesUp;
  }

  public void stopTimer(){
    timer.stop();
    timer.reset();
    timesUp = false;
  }
  public boolean getTimesUp(){
    if(timer.get()>3){
      return true;
    }
    return false;
  }

  public void stop(){
    // feederMotor.set(0);

    //Test
    leftOne.set(0);
    leftTwo.set(0);
    rightOne.set(0);
    rightTwo.set(0);
  }

  public void configFeeder(){
    // slot0Configs.kV = 0;
    // slot0Configs.kP = 0;
    // slot0Configs.kI = 0;
    // slot0Configs.kD = 0;
    // feederMotor.getConfigurator().apply(slot0Configs, 0.050);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
