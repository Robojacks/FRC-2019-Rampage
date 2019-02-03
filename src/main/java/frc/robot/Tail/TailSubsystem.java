/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Tail;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class TailSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Compressor Airow = new Compressor(RobotMap.COMPRESSOR_MODULE); 
  DoubleSolenoid TailMover = new DoubleSolenoid(RobotMap.TAIL_SOLENOID_FOWARD_CHANNEL, RobotMap.TAIL_SOLENOID_REVERSE_CHANNEL); 

  public TailSubsystem(){
    Airow.start();
  }

  public void forward() {
    TailMover.set(Value.kForward);
  }

  public void backward() {
    TailMover.set(Value.kReverse);
  }

  public void off() {
    TailMover.set(Value.kOff);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

