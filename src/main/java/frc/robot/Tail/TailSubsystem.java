/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Tail;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotState;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class TailSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Compressor Airow = new Compressor(RobotMap.COMPRESSOR_MODULE); 
  Solenoid TailMover = new Solenoid(RobotMap.COMPRESSOR_MODULE, RobotMap.TAIL_SOLENOID_CHANNEL); 

  public TailSubsystem(){
    Airow.start();
  }

  public void in() {
    TailMover.set(false);
    RobotState.tailOut = false;
  }

  public void out() {
    if (Timer.getMatchTime() < 60 && DriverStation.getInstance().isOperatorControl()) {
      TailMover.set(true);
      RobotState.tailOut = true;
    }
  }

  public void switchState() {
    if (RobotState.tailOut) {
      this.in();

    } else {
      this.out();

    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
