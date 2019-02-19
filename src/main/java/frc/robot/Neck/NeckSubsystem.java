/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Neck;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotState;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class NeckSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Compressor Airow = new Compressor(RobotMap.COMPRESSOR_MODULE);

  Solenoid NeckPusher = new Solenoid(RobotMap.COMPRESSOR_MODULE, RobotMap.NECK_SOLENOID_CHANNEL);

  public NeckSubsystem() {
    Airow.start();
   
  }

  public void out() {
    NeckPusher.set(true);
    RobotState.neckOut = true; 
  }

  public void in() {

    if (RobotState.beakOut == false) {
      NeckPusher.set(false);
      RobotState.neckOut = false;

    } 

  }

  public void switchState() {
    if (RobotState.neckOut) {
      this.in();

    } else {
      this.out();
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
