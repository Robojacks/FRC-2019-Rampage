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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Actions.*;
import frc.robot.Beak.*;
import frc.robot.DriveToHatch.*;
import frc.robot.Neck.*;
import frc.robot.Tail.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  
	private static final XboxController xbox = new XboxController(RobotMap.XBOX_CONTROLLER_PORT);
	
	public static Button X = new JoystickButton(xbox, RobotMap.X_BUTTON);
	
	public static Button Y = new JoystickButton(xbox, RobotMap.Y_BUTTON);
	
	public static Button A = new JoystickButton(xbox, RobotMap.A_BUTTON);
	
	public static Button B = new JoystickButton(xbox, RobotMap.B_BUTTON);
	
	public static Button LB = new JoystickButton(xbox, RobotMap.LEFT_BUMPER);
	
	public static Button RB = new JoystickButton(xbox, RobotMap.RIGHT_BUMPER);
	
	public static Button LT = new JoystickButton(xbox, RobotMap.LEFT_TRIGGER);
	
	public static Button RT = new JoystickButton(xbox, RobotMap.RIGHT_TRIGGER);
	
	public static Button back = new JoystickButton(xbox, RobotMap.BACK_BUTTON);
	
	public static Button start = new JoystickButton(xbox, RobotMap.START_BUTTON);
	
	public static Button LJoy = new JoystickButton(xbox, RobotMap.LEFT_JOYSTICK_TRIGGER);
	
	public static Button RJoy = new JoystickButton(xbox, RobotMap.RIGHT_JOYSTICK_TRIGGER);

	public OI() {

		// Shuffleboard/SmartDashboard testing

		SmartDashboard.putData("Move Neck", new NeckMove());

		SmartDashboard.putData("Move Tail", new TailMove());

		SmartDashboard.putData("Move Beak", new BeakMove());

		SmartDashboard.putData("Go to Hatch Panel", new GoToHatchPanel());

		SmartDashboard.putData("Rotate to Hatch Panel", new RotateToHatchPanel());

		// Commands attached

		start.whenPressed(new GoToHatchPanel());

		back.whenPressed(new RetrieveHatchPanel()); 
		
		X.whenPressed(new DeployRamp());

		Y.whenPressed(new MoveTail());

		A.whenPressed(new MoveBeak());
		
		B.whenPressed(new NeckOut());
		
	}
}
