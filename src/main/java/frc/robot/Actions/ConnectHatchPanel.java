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
import frc.robot.DriveToHatch.GoToHatchPanel;
import frc.robot.DriveToHatch.RotateToHatchPanel;
import frc.robot.Neck.NeckOut;

/**
 * Drives up to target and places hatch panel on it
 * 
 * @see RotateToHatchPanel
 * @see GoToHatchPanel
 */
public class ConnectHatchPanel extends CommandGroup {

  public ConnectHatchPanel() {

    // Subsystem Requirements
    requires(Robot.drivetrain);
    requires(Robot.panelRotation);
    requires(Robot.hatchTracker);
    requires(Robot.limelight);
    requires(Robot.neck);
    requires(Robot.beak);

    // Run commands
    
    addSequential(new RotateToHatchPanel());

    addSequential(new GoToHatchPanel());

    addParallel(new NeckOut());

    addParallel(new BeakIn());

  }
}
