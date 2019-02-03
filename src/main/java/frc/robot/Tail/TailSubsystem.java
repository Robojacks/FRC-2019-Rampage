/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Tail;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class TailSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Compressor BigChungus = RobotMap.BigChungus; 
  Solenoid TailMover = RobotMap.TailMover; 

  public TailSubsystem(){
    BigChungus.start();
  }

  public void open() {
    TailMover.set(true);
    Constants.tailOut = true;
  }

  public void close() {
    TailMover.set(false);
    Constants.tailOut = false;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
