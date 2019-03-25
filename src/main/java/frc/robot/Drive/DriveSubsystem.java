/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.ghrobotics.lib.localization.Localization;
import org.ghrobotics.lib.localization.TankEncoderLocalization;
import org.ghrobotics.lib.mathematics.twodim.control.RamseteTracker;
import org.ghrobotics.lib.mathematics.twodim.control.TrajectoryTracker;
import org.ghrobotics.lib.mathematics.units.Length;
import org.ghrobotics.lib.subsystems.drive.TankDriveSubsystem;
import org.ghrobotics.lib.wrappers.FalconMotor;
import org.ghrobotics.lib.wrappers.ctre.FalconSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.RobotState;

/**
 * Contains all methods for control of the the drivetrain.
 * 
 * @see Drive
 * @see RotateToPanelSubsystem
 * @see TargetTrackingSubsystem
 */
public class DriveSubsystem extends TankDriveSubsystem {

  FalconSRX<Length> LeftFrontWheel;
  FalconSRX<Length> RightFrontWheel;

  private WPI_TalonSRX RRearWheel = new WPI_TalonSRX(RobotMap.RIGHT_REAR_WHEEL_PORT); // right rear wheel
  private WPI_TalonSRX RFrontWheel = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_WHEEL_PORT); // right front wheel
  private WPI_TalonSRX LRearWheel = new WPI_TalonSRX(RobotMap.LEFT_REAR_WHEEL_PORT); // left rear wheel
  private WPI_TalonSRX LFrontWheel = new WPI_TalonSRX(RobotMap.LEFT_FRONT_WHEEL_PORT); // left front wheel

  private SpeedControllerGroup right = new SpeedControllerGroup(RRearWheel, RFrontWheel); // right speed controller
                                                                                          // group
  private SpeedControllerGroup left = new SpeedControllerGroup(LRearWheel, LFrontWheel); // left speed controller group

  private DifferentialDrive roboDrive = new DifferentialDrive(left, right);

  RamseteTracker tracker = new RamseteTracker(0.2, 1);

  TankEncoderLocalization localization = new TankEncoderLocalization(null, null, null);

  public DriveSubsystem() {
    Robot.initTalon(RFrontWheel);
    Robot.initTalon(RRearWheel);
    Robot.initTalon(LFrontWheel);
    Robot.initTalon(LRearWheel);

    LRearWheel.follow(LeftFrontWheel);
    RRearWheel.follow(RightFrontWheel);
  }

  /**
   * Drives robot in TankDrive mode
   * 
   * @see Drive
   */
  public void TankDrive(double leftControl, double rightControl) {

    if (RobotState.fullThrottle) {
      roboDrive.tankDrive(leftControl, rightControl, false);

    } else if (RobotState.sensitive) {
      roboDrive.tankDrive(Constants.lowGear * leftControl, Constants.lowGear * rightControl, false);

    } else {
      roboDrive.tankDrive(Constants.highGear * leftControl, Constants.highGear * rightControl, false);

    }

  }

  /**
   * Switches between offensive and defensive mode when triggered
   * 
   * @see SwitchDrivingMode
   */
  public void setMode() {
    if (RobotState.offensiveMode) { // Set motors to offensive mode

      LFrontWheel.setNeutralMode(NeutralMode.Brake);
      LRearWheel.setNeutralMode(NeutralMode.Brake);

      RFrontWheel.setNeutralMode(NeutralMode.Brake);
      RRearWheel.setNeutralMode(NeutralMode.Brake);

      RobotState.fullThrottle = false;

    } else { // Set motors to defensive mode

      LFrontWheel.setNeutralMode(NeutralMode.Coast);
      LRearWheel.setNeutralMode(NeutralMode.Coast);

      RFrontWheel.setNeutralMode(NeutralMode.Coast);
      RRearWheel.setNeutralMode(NeutralMode.Coast);

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
   * Created primarily for {@link RotateToPanelSubsystem} when the robot is only
   * rotating with {@link RotateToHatchPanel}, takes an output to rotating a
   * certain amount
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
  public com.team254.lib.physics.DifferentialDrive getDifferentialDrive() {
    return null;
  }

  @Override
  public FalconMotor<Length> getLeftMotor() {
    return LeftFrontWheel;
  }

  @Override
  public FalconMotor<Length> getRightMotor() {
    return RightFrontWheel;
  }

  @Override
  public TrajectoryTracker getTrajectoryTracker() {
    return tracker;
  }

  @Override
  public Localization getLocalization() {
    return localization;
  }
}
