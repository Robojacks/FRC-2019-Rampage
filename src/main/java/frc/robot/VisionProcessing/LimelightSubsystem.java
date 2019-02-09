/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.VisionProcessing;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

/**
 * Configures limelight settings
 */
public class LimelightSubsystem extends Subsystem {

  NetworkTableEntry ledMode = Constants.ledMode;
  NetworkTableEntry camMode = Constants.camMode;
  NetworkTableEntry pipeline = Constants.pipeline;

  double validTarget = Constants.tv.getDouble(0.0);

  /**
   * Sets limelight to vision processing mode and sets vision pipeline to 0
   */
  public void init() {
    camMode.setNumber(0); // sets camera to vision processing mode
    pipeline.setNumber(0);
  }

  /**
   * Forces on light
   */
  public void lightOn() {
    ledMode.setNumber(3);
  }

  /**
   * Forces off light
   */
  public void lightOff() {
    ledMode.setNumber(1);
  }

  /**
   * Changes light settings according to how vision pipeline is set
   */
  public void lightAuto() {
    ledMode.setNumber(0);
  }

  /**
   * Checks if there is no valid targets, which is then sent to isFinsished() 
   */
  public boolean noValidTarget() {
    if (validTarget == 0) {
      System.out.println("Vision Target was lost");
      return true; 

    } else {
      return false;

    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
