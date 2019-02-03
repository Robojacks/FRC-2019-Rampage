/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  
  // Controllers
  public static final int XBOX_CONTROLLER_PORT = 0;

  // Axes

  public static final int LEFT_STICK_Y = 1;

  public static final int RIGHT_STICK_Y = 5;

  // Buttons (X Mode)

  public static final int A_BUTTON = 1;

  public static final int B_BUTTON = 2;

  public static final int X_BUTTON = 3;

  public static final int Y_BUTTON = 4;

  public static final int LEFT_BUMPER = 5;

  public static final int RIGHT_BUMPER = 6;

  public static final int LEFT_TRIGGER = 7;

  public static final int RIGHT_TRIGGER = 8;

  public static final int BACK_BUTTON = 9;

  public static final int START_BUTTON = 10;

  public static final int LEFT_JOYSTICK_TRIGGER = 11;

  public static final int RIGHT_JOYSTICK_TRIGGER = 12;

  // Drive
  public static final int RIGHT_REAR_WHEEL_PORT = 1;

  public static final int RIGHT_FRONT_WHEEL_PORT = 0;

  public static final int LEFT_REAR_WHEEL_PORT = 3;

  public static final int LEFT_FRONT_WHEEL_PORT = 2;

  // Phenumatics
  public static final int COMPRESSOR_MODULE = 0;

  public static final int NECK_SOLENOID_CHANNEL = 0;

  public static final int BEAK_SOLENOID_CHANNEL = 4;

  public static final int TAIL_SOLENOID_FOWARD_CHANNEL = 1;

  public static final int TAIL_SOLENOID_REVERSE_CHANNEL = 2;

}
