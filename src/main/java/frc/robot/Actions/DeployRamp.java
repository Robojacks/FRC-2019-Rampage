/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Actions;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.Tail.*;

public class DeployRamp extends CommandGroup {
  /**
   * Add your docs here.
   */
  public DeployRamp() {
    requires(Robot.tail);

    addSequential(new TailOpen());

    Timer.delay(2.0);

    addSequential(new TailClose());
  }
}
