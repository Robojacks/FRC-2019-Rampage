/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Drive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.RobotState;

/**
 * Contains all methods for control of the the drivetrain.
 * 
 * @see Drive
 * @see RotateToPanelSubsystem 
 * @see TargetTrackingSubsystem
 */
public class DriveSubsystem extends Subsystem {

  private CANSparkMax RRearWheel = new CANSparkMax(RobotMap.RIGHT_REAR_WHEEL_PORT, MotorType.kBrushless); // right rear wheel
  private CANSparkMax RFrontWheel = new CANSparkMax(RobotMap.RIGHT_FRONT_WHEEL_PORT, MotorType.kBrushless); // right front wheel
  private CANSparkMax LRearWheel = new CANSparkMax(RobotMap.LEFT_REAR_WHEEL_PORT, MotorType.kBrushless); // left rear wheel
  private CANSparkMax LFrontWheel = new CANSparkMax(RobotMap.LEFT_FRONT_WHEEL_PORT, MotorType.kBrushless); // left front wheel

  private SpeedControllerGroup right = new SpeedControllerGroup(RRearWheel, RFrontWheel); // right speed controller group 
  private SpeedControllerGroup left = new SpeedControllerGroup(LRearWheel, LFrontWheel); // left speed controller group 

  private DifferentialDrive roboDrive = new DifferentialDrive(left, right);

  /**
   * Drives robot in TankDrive mode
   * 
   * @see Drive
   */
  public void TankDrive(double leftControl, double rightControl) {

    if (RobotState.fullThrottle) {
      roboDrive.tankDrive(leftControl, rightControl, false);

    } else if (RobotState.sensitive) {
      roboDrive.tankDrive(Constants.lowGear*leftControl, Constants.lowGear*rightControl, false);

    } else {
      roboDrive.tankDrive(Constants.highGear*leftControl, Constants.highGear*rightControl, false);

    }
    
  }

  /**
   * Switches between offensive and defensive mode when triggered
   * 
   * @see SwitchDrivingMode
   */
  public void setMode() {
    if (RobotState.offensiveMode) { // Set motors to offensive mode
      RobotState.fullThrottle = false;

    } else { // Set motors to defensive mode
      RobotState.fullThrottle = true;

    }
  }
  
  /**
   * Drives robot in ArcadeDrive mode
   * 
   * @see Drive
   */
  public void ArcadeDrive(double speedForward, double rotation) {
    roboDrive.arcadeDrive(speedForward, rotation);
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
