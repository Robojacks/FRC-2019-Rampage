/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.VisionProcessing;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Starts {@link RotateToPanelSubsystem} PID loop, initiates limelight, and disables the PID loop 
 * once finished.
 * 
 * @see RotateToPanelSubsystem
 * @see LimelightSubsystem
 */
public class RotateToPanel extends Command {
  
  public RotateToPanel() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivetrain);

    requires(Robot.panelRotation);

    requires(Robot.limelight);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
    Robot.limelight.lightAuto();
    Robot.limelight.init();

    Robot.panelRotation.dependent = false;

    Robot.drivetrain.stop();
    Robot.panelRotation.enable();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.panelRotation.onTarget() || Robot.limelight.noValidTarget(); 
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.panelRotation.disable();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

