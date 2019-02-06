/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.DriveToHatch;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;

/**
 * Utilizing the PID loop from the {@link RotateToPanelSubsystem} and its own PID loop judging how fast
 * to go with the given distance, this subsystem moves towards the target until it is at a precise theshold
 * that the robot can place the hatch. 
 * 
 * @see RotateToPanelSubsystem 
 * @see CalculateTargetDistance 
 * @see GoToHatchPanel
 */
public class TargetTrackingSubsystem extends PIDSubsystem {
  
  //double area = Constants.ta.getDouble(0.0);

  public TargetTrackingSubsystem() {

    // Insert a subsystem name and PID values here
    super("Hatch Tracker", 1, 2, 3);

    // Use these to get going:
    setSetpoint(0.5); // half a foot from target

    setInputRange(0, 1);

    setOutputRange(0, 1);

    setAbsoluteTolerance(0.2);

    enable(); // Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    return CalculateTargetDistance.getDistance();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use both outputs in drive
    Robot.drivetrain.driftDrive(output, Robot.panelRotation.PIDOut, !Robot.panelRotation.onTarget());
  }
}
