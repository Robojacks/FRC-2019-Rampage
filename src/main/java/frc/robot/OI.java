/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.DriveToHatch.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  
	public static XboxController xbox = new XboxController(3);
	
	public static Button X = new JoystickButton(xbox, 1);
	
	public static Button Y = new JoystickButton(xbox, 2);
	
	public static Button A = new JoystickButton(xbox, 3);
	
	public static Button B = new JoystickButton(xbox, 4);
	
	public static Button LB = new JoystickButton(xbox, 5);
	
	public static Button RB = new JoystickButton(xbox, 6);
	
	public static Button LT = new JoystickButton(xbox, 7);
	
	public static Button RT = new JoystickButton(xbox, 8);
	
	public static Button back = new JoystickButton(xbox, 9);
	
	public static Button start = new JoystickButton(xbox, 10);
	
	public static Button LJoy = new JoystickButton(xbox, 11);
	
	public static Button RJoy = new JoystickButton(xbox, 12);

	public OI() {
		
	}
}
