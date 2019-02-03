/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  
  // Drive
  public static final WPI_TalonSRX RRearWheel = new WPI_TalonSRX(1); // right rear wheel
  public static final WPI_TalonSRX RFrontWheel = new WPI_TalonSRX(0); // right front wheel
  public static final WPI_TalonSRX LRearWheel = new WPI_TalonSRX(3); // left rear wheel
  public static final WPI_TalonSRX LFrontWheel = new WPI_TalonSRX(2); // left front wheel

  public static final SpeedControllerGroup right = new SpeedControllerGroup(RRearWheel, RFrontWheel); // right speed controller group 
  public static final SpeedControllerGroup left = new SpeedControllerGroup(LRearWheel, LFrontWheel); // left speed controller group 

  public static final DifferentialDrive roboDrive = new DifferentialDrive(left, right); // making both speed controllers part of the overall drive

  // Phenumatics
  public static final Compressor BigChungus = new Compressor(0);
  public static final Solenoid NeckPusher = new Solenoid(0, 0);
  public static final Solenoid BeakPusher = new Solenoid(0, 4);
  public static final Solenoid TailMover = new Solenoid(0, 2);

}
