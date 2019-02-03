/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Drive;

import frc.robot.DriveToHatch.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * Contains all methods for control of the the drivetrain.
 * 
 * @see Drive
 * @see RotateToPanelSubsystem 
 * @see TargetTrackingSubsystem
 */
public class DriveSubsystem extends Subsystem {

  private DifferentialDrive roboDrive = RobotMap.roboDrive;

  /**
   * Drives robot in TankDrive mode
   * 
   * @see Drive
   */
  public void TankDrive(double leftControl, double rightControl) {
    roboDrive.tankDrive(leftControl, rightControl);
  }

  /**
   * Created primarily for {@link TargetTrackingSubsystem}, takes two outputs to for driving forward
   * and rotation with curvatureDrive rather than arcadeDrive, with a boolean isRotating for quick 
   * adjustments.
   * 
   * @see TargetTrackingSubsystem
   */
  public void driftDrive(double speedForward, double rotation, boolean isRotating) {
    roboDrive.curvatureDrive(speedForward, rotation, isRotating);
  }

  /**
   * Created primarily for {@link RotateToPanelSubsystem} when the robot is only rotating with 
   * {@link RotateToHatchPanel}, takes an output to rotating a certain amount
   * 
   * @see RotateToPanelSubsystem
   * @see RotateToHatchPanel
   */
  public void rotate(double output) { 
    roboDrive.arcadeDrive(0, output); // positive is right, negative is left
  }

  /**
   * Stops the drivetrain
   */
  public void stop() {
    roboDrive.tankDrive(0, 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Drive());
  }
}
