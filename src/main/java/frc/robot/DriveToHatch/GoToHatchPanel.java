/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.DriveToHatch;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Starts {@link RotateToPanelSubsystem} and {@link TargetTrackingSubsystem} PID loops and initializes
 * the limelight. Once finished, this disables the PID loops since they have finished their jobs.
 * 
 * @see RotateToPanelSubsystem 
 * @see TargetTrackingSubsystem
 * @see LimelightSubsystem
 */
public class GoToHatchPanel extends Command {
  public GoToHatchPanel() {
    // Use requires() here to declare subsystem dependencies
    
    requires(Robot.drivetrain);

    requires(Robot.panelRotation);

    requires(Robot.hatchTracker);
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Robot.panelRotation.dependent = true;

    Robot.drivetrain.stop(); // makes sure nothing is moving before the correction begins

    Robot.limelight.lightAuto();
    Robot.limelight.init();

    Robot.hatchTracker.enable();
    Robot.panelRotation.enable();
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() { // in order for the command to finish,
    // it must either have both subsystems agreeing that it is on target, or find the target was lost 
    return Robot.hatchTracker.onTarget() && Robot.panelRotation.onTarget() || Robot.limelight.noValidTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    // disabling pid subsystems - they have finished their jobs, no need to continue moving
    Robot.panelRotation.disable();
    Robot.hatchTracker.disable();

    Robot.drivetrain.stop(); // stops any last motion from drivetrain to keep the target position
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
