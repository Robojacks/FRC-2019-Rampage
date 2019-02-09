/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Actions;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.VisionProcessing.GoToPanel;
import frc.robot.VisionProcessing.RotateToPanel;
import frc.robot.Neck.NeckOut;

/**
 * Goes to cargo port and deploys neck mechanism, shooting the loaded ball directly into the port
 */
public class DeployBallToCargoShip extends CommandGroup {
  
  public DeployBallToCargoShip() {

    // Subsystem Requirements
    requires(Robot.drivetrain);
    requires(Robot.panelRotation);
    requires(Robot.visionTracker);
    requires(Robot.limelight);
    requires(Robot.neck);

    // Run Commands

    addSequential(new RotateToPanel());

    addSequential(new GoToPanel());

    addSequential(new NeckOut());

  }
}
