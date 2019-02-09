/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Tail;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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

  public void deploy() {
    TailMover.set(Value.kForward);

    Timer.delay(2.0);

    TailMover.set(Value.kReverse);
    
    RobotState.notDeployed = false;
  }

  public void switchState() {
    if (RobotState.tailOut) {
      this.backward();

    } else {
      this.forward();

    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
