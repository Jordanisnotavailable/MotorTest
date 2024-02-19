// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LEDlights extends SubsystemBase {
  AddressableLED m_led = new AddressableLED(9); 
  AddressableLEDBuffer m_ledBuffer = new AddressableLEDBuffer(60);
  Timer timer = new Timer();
  int hue = 0;

  boolean atEnd = false;
 


  /** Creates a new LEDlights. */
  public LEDlights() {
  m_led.setLength(60);
  m_led.setData(m_ledBuffer);
  m_led.start();
  timer.start();
  }

  

  public void redLight(){
     for (int i = 0; i < m_ledBuffer.getLength(); i++) {
    // Sets the specified LED to the RGB values for red
        
          m_ledBuffer.setRGB(i, 255, 0, 0);
    }  
    
    m_led.setData(m_ledBuffer);
    

  }

  public void solidGreen(){
  // if(timer.get()%2 == 0){
    for (int i = 0; i < m_ledBuffer.getLength(); i++) {
    // Sets the specified LED to the RGB values for red
    m_ledBuffer.setRGB(i, 0, 255, 0);
    }
       m_led.setData(m_ledBuffer);
  }

 //}

 public void solidYellow(){
  // if(timer.get()%2 == 0){
    for (int i = 0; i < m_ledBuffer.getLength(); i++) {
    // Sets the specified LED to the RGB values for red
    m_ledBuffer.setRGB(i, 0, 255, 0);
    }
       m_led.setData(m_ledBuffer);
  }
 //}

  public void stopLED(){
  for (int i = 0; i < m_ledBuffer.getLength(); i++) {
    // Sets the specified LED to the RGB values for red
    m_ledBuffer.setRGB(i, 0, 0, 0);
    }

       m_led.setData(m_ledBuffer);
  }

 

  public void greenFlash(){
    int onConditionLEDMod = m_ledBuffer.getLength()/ 8;

    for(int i = 0; i < m_ledBuffer.getLength()/2; i++){
     if((int) (10 * timer.get()) % (onConditionLEDMod) == i /60){
      m_ledBuffer.setRGB(i, 0, 255, 0);
    //m_ledBuffer.setRGB((m_ledBuffer.getLength() - i), 0, 255, 0);
     }
     else{
      m_ledBuffer.setRGB(i, 0, 0, 0);
      //m_ledBuffer.setRGB((m_ledBuffer.getLength() - i), 0, 0, 0);
     }
       m_led.setData(m_ledBuffer);
    }

  }

  public void chaseLight(){
    for (int i = 0; i < m_ledBuffer.getLength(); i++) {
      // Calculate the hue - hue is easier for rainbows because the color
      // shape is a circle so only one value needs to precess
      int hue = (m_ledBuffer.getLength() + (i * 180 / m_ledBuffer.getLength())) % 180;
      // Set the value
      m_ledBuffer.setRGB(i, 0, 0, 0);
    }
    // Increase by to make the rainbow "move"
    hue +=2;
    hue %= 180;

  }

  public void bouncyLED(Color color){
    while (!atEnd){
      for(int i = 0; i < m_ledBuffer.getLength(); i++){
        //run led forward
        if(i == m_ledBuffer.getLength()-1){
          atEnd = true;
        }
      }
    }
    while(atEnd){
      for(int i = m_ledBuffer.getLength()-1; i > 0; i--){
        //run led backward
    
        if(i == 1){
          atEnd = false;
        }
      }
    }
  }

  



  @Override
  public void periodic() {
    
    // This method will be called once per scheduler run
  }
}
