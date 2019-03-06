/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Drive;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotState;

/**
 * Switches robot between a precise and slower offense mode and a fast cruising defense mode
 */
public class DriverModeSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public void switchMode() {

    if (RobotState.offensiveMode) { // if offensive, change motors to defensive mode
      RobotState.offensiveMode = false;

    } else { // if defensive, set motors to offensive mode
      RobotState.offensiveMode = true;

    }

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
