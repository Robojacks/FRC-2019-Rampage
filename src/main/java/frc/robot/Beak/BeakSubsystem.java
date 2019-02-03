/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Beak;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class BeakSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Compressor Airow = new Compressor(RobotMap.COMPRESSOR_MODULE);
  Solenoid BeakPusher = new Solenoid(RobotMap.COMPRESSOR_MODULE, RobotMap.BEAK_SOLENOID_CHANNEL); 

  public BeakSubsystem(){
    Airow.start(); 
  }

  public void out(){
    Constants.beakOut = true;
    BeakPusher.set(true);
  }
  
  public void in(){
    Constants.beakOut = false;
    BeakPusher.set(false);

  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
