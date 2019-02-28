/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Contains all methods for control of the the drivetrain.
 * 
 * @see Drive
 * @see RotateToPanelSubsystem 
 * @see TargetTrackingSubsystem
 */
public class DriveSubsystem extends Subsystem {

  private WPI_TalonSRX RRearWheel = new WPI_TalonSRX(RobotMap.RIGHT_REAR_WHEEL_PORT); // right rear wheel
  private WPI_TalonSRX RFrontWheel = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_WHEEL_PORT); // right front wheel
  private WPI_TalonSRX LRearWheel = new WPI_TalonSRX(RobotMap.LEFT_REAR_WHEEL_PORT); // left rear wheel
  private WPI_TalonSRX LFrontWheel = new WPI_TalonSRX(RobotMap.LEFT_FRONT_WHEEL_PORT); // left front wheel

  private SpeedControllerGroup right = new SpeedControllerGroup(RRearWheel, RFrontWheel); // right speed controller group 
  private SpeedControllerGroup left = new SpeedControllerGroup(LRearWheel, LFrontWheel); // left speed controller group 

  private DifferentialDrive roboDrive = new DifferentialDrive(left, right);

  public DriveSubsystem() {
    Robot.initTalon(RFrontWheel);
    Robot.initTalon(RRearWheel);
    Robot.initTalon(LFrontWheel);
    Robot.initTalon(LRearWheel);
  }

  /**
   * Drives robot in TankDrive mode
   * 
   * @see Drive
   */
  public void TankDrive(double leftControl, double rightControl) {
    roboDrive.tankDrive(leftControl, rightControl, false);
  }

  /**
   * Creates a more precise drive control for use with VelocityDrive()
   * 
   * @see VelocityDrive
   */
  public void VelocityDrive(double leftControl, double rightControl) {

    double leftVelocity = Constants.Left_Kv * Constants.MAX_VELOCITY * leftControl;

    double rightVelocity = Constants.Right_Kv * Constants.MAX_VELOCITY * rightControl;

    // Set follower motors
    LRearWheel.follow(LFrontWheel);
    RRearWheel.follow(LFrontWheel);

    // Set left side

    if (leftControl > 0) {
      LFrontWheel.set(ControlMode.Current, Constants.Left_VIntercept + leftVelocity);

    } else if (leftControl < 0) { // Switch sign of VIntercept
      LFrontWheel.set(ControlMode.Current, -1.0 * Constants.Left_VIntercept + leftVelocity);

    } else {
      LFrontWheel.stopMotor();

    }

    // Set right side

    if (rightControl > 0) {
      RFrontWheel.set(ControlMode.Current, Constants.Right_VIntercept + rightVelocity);

    } else if (rightControl < 0) { // Switch sign of VIntercept
      RFrontWheel.set(ControlMode.Current, -1.0 * Constants.Right_VIntercept + rightVelocity);

    } else {
      RFrontWheel.stopMotor();

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
