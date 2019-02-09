/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.VisionProcessing;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * Rotates the robot towards the hatch panel, which can work conjunction with the 
 * {@link TargetTrackingSubsystem} to get to the hatch panel.
 * 
 * @see TargetTrackingSubsystem
 * @see RotateToPanel
 * @see GoToPanel
 */
public class RotateToPanelSubsystem extends PIDSubsystem {
  
  NetworkTableEntry tx = Constants.tx;
  NetworkTableEntry ta = Constants.ta;

  // difference in x how far away from the target the robot is.
  double x = tx.getDouble(0.0);

  public double PIDOut; 

  public boolean dependent = false;

  public RotateToPanelSubsystem() {
    // Intert a subsystem name and PID values here
    super("Rotate towards target", 1, 2, 3);
    // Use these to get going:
    
    setSetpoint(0); // Sets where the PID controller should move the system

    setInputRange(-27, 27); // Lowest value is -27 degrees (to the left), highest value is 27 degrees (to the right)

    setOutputRange(-1, 1); // The outputs sent to the motors, which ranges from -1 to 1.

    setAbsoluteTolerance(Constants.rotationalErrorTolerance); 
    
    enable(); // - Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    x = tx.getDouble(0.0); // updates x value
    return x;
  }

  @Override
  protected void usePIDOutput(double output) {
    if (dependent) {
      PIDOut = output; // Sends output to the FollowLineSubsystem, which keeps it on target
    } else {
      Robot.drivetrain.rotate(output); // If all on its own, rotate until on target
    }
  }
}
