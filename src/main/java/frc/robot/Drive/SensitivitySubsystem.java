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
 * Add your docs here.
 */
public class SensitivitySubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public void changeSensitivity() {
    if (RobotState.sensitive) {
      RobotState.sensitive = false;

    } else {
      RobotState.sensitive = true;
      
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
