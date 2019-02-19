/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Drive;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.RobotState;

/**
 * The Drive system, utilizing xbox controllers and tank drive to control the robot.
 * 
 * @see DriveSubsystem
 */
public class Drive extends Command {

  private final XboxController xbox = new XboxController(RobotMap.XBOX_CONTROLLER_PORT);

  public Drive() {
    requires(Robot.drivetrain);
    requires(Robot.limelight);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.drivetrain.stop();
    Robot.limelight.lightOff();
    Robot.limelight.driverMode();
  }

  @Override
  protected void execute() {
    
    if (RobotState.sensitive) {
      Robot.drivetrain.TankDrive(Constants.lowGear*xbox.getRawAxis(5), Constants.lowGear*xbox.getRawAxis(1));
    } else {
      Robot.drivetrain.TankDrive(Constants.highGear*xbox.getRawAxis(5), Constants.highGear*xbox.getRawAxis(1));
    }
    
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.drivetrain.stop();
  }

  @Override
  protected void interrupted() {
    Robot.drivetrain.stop();
  }
    
}

