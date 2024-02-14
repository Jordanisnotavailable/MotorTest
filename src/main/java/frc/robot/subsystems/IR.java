// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IR extends SubsystemBase {
  public DigitalInput ir;
  WPI_TalonSRX leftOne = new WPI_TalonSRX(1);
  /** Creates a new IR. */
  public IR() {
    ir = new DigitalInput(1);
    SmartDashboard.putBoolean("IR", false);
  }

  public void stop(){
    //intakeMotor.setControl(m_volt.withOutput(0));

    //Test
    leftOne.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("IR", ir.get());
    if(ir.get()){
      leftOne.set(0.3);
    }
    else{
      stop();
    }
  }
}
