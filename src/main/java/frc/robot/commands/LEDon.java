// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LEDlights;

public class LEDon extends Command {
  LEDlights s_led;
   Timer timer = new Timer();
   Joystick joystick = new Joystick(0);
   


  /** Creates a new LEDon. */
  public LEDon(LEDlights s_led) {
    this.s_led = s_led;
    addRequirements(s_led);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    s_led.greenFlash();
    s_led.chaseLight();
}
    // if((Math.round(timer.get()*10)/10 % 0.4) == 0){
    //   s_led.solidGreen();
    // }
    // else{
    //   s_led.stopLED();
    // }
    // if((int)timer.get()%2 == 0){
    //   s_led.greenPattern1();
    // }
    // else{
    // // s_led.greenPattern2();
    // s_led.stopLED();
    

    // if((int)timer.get()%2 == 0){
    //   s_led.solidGreen();
    // }
    // else{
    // s_led.stopLED();
    // }

    // if(joystick.getRawButton(2)){
    //  s_led.solidGreen();
    // }
    // else{
    //   s_led.stopLED();
    // }
    // s_led.redLight();
    //SmartDashboard.putNumber("LEDTime", timer.get());
//}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
