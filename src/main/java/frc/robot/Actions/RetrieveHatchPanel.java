/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Actions;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.Beak.BeakClose;
import frc.robot.DriveToHatch.GoToHatchPanel;
import frc.robot.DriveToHatch.RotateToHatchPanel;
import frc.robot.Neck.NeckOpen;

/**
 * Drives up to target and takes hatch panel from it
 * 
 * @see RotateToHatchPanel
 * @see GoToHatchPanel
 */
public class RetrieveHatchPanel extends CommandGroup {

  public RetrieveHatchPanel() {
    
    // Subsystem Requirements
    requires(Robot.drivetrain);
    requires(Robot.panelRotation);
    requires(Robot.hatchTracker);
    requires(Robot.limelight);
    requires(Robot.neck);
    requires(Robot.beak);

    // Run commands

    addSequential(new RotateToHatchPanel());

    addParallel(new GoToHatchPanel());

    addParallel(new NeckOpen());

    addSequential(new BeakClose());

  }
}
