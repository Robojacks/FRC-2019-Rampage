/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Drive;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * The Drive system, utilizing xbox controllers and tank drive to control the robot.
 * 
 * @see DriveSubsystem
 */
public class Drive extends Command {

  private final XboxController xbox = new XboxController(0);

  public Drive() {
    requires(Robot.drivetrain);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.drivetrain.stop();
  }

  @Override
  protected void execute() {
    Robot.drivetrain.TankDrive(-xbox.getRawAxis(1), -xbox.getRawAxis(5));
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

