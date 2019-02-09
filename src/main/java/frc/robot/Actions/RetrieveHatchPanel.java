/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Actions;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.Beak.BeakIn;
import frc.robot.Beak.BeakOut;
import frc.robot.VisionProcessing.GoToPanel;
import frc.robot.VisionProcessing.RotateToPanel;
import frc.robot.Neck.NeckOut;

/**
 * Goes to a loading station and connects to the hatch panel for retrieval
 * 
 * @see RotateToPanel
 * @see GoToPanel
 */
public class RetrieveHatchPanel extends CommandGroup {

  public RetrieveHatchPanel() {
    
    // Subsystem Requirements
    requires(Robot.drivetrain);
    requires(Robot.panelRotation);
    requires(Robot.visionTracker);
    requires(Robot.limelight);
    requires(Robot.neck);
    requires(Robot.beak);

    // Run commands

    addSequential(new RotateToPanel());

    addSequential(new GoToPanel());

    addParallel(new NeckOut());

    addParallel(new BeakIn());

    addSequential(new BeakOut());

  }
}
