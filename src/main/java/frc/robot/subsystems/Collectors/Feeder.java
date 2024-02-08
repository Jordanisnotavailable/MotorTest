// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Collectors;


import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Feeder extends SubsystemBase {
  TalonFX feederMotor = new TalonFX(11);

  Timer timer = new Timer();
  boolean timesUp = false;
  /** Creates a new Feeder. */
  public Feeder() {
    feederMotor.getConfigurator().apply(new TalonFXConfiguration());
    timer.stop();
    timer.reset();
  }
  public void runFeeder(){
    feederMotor.set(0.3);
  }

  public boolean runTimer(){
    timer.start();
    if(timer.get()>3){
      timesUp = true;
    }
    return timesUp;
  }

  public boolean stopTimer(){
    timer.stop();
    timer.reset();
    timesUp = false;
    return timesUp;
  }
  public boolean getTimesUp(){
    return timesUp;
  }

  public void stop(){
    feederMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
