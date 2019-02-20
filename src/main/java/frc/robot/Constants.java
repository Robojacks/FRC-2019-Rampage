/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Stores all of the variables outside of those needed for operator controls ({@link OI}) or motor 
 * controllers ({@link RobotMap}).
 * 
 * @see LimelightSubsystem
 * @see CalculateTargetDistance
 */
public class Constants {

    // Network Tables for Vision

    public static final NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        
    public static final NetworkTableEntry tx = table.getEntry("tx");
    public static final NetworkTableEntry ty = table.getEntry("ty");
    public static final NetworkTableEntry ta = table.getEntry("ta");
    public static final NetworkTableEntry tv = table.getEntry("tv");

    public static final NetworkTableEntry ledMode = table.getEntry("ledMode");
    public static final NetworkTableEntry camMode = table.getEntry("camMode");
    public static final NetworkTableEntry pipeline = table.getEntry("pipeline");

    // Vision Tape Height

    public static final double visionTapeHeightFt = 2 + 7.5/12; // 2 feet, 7.5 inches

    // Camera height and angle

    // from top of camera
    public static final double cameraHeightFt = 1.0 + 3/12; // 0 feet, 5 inches

    public static final double cameraMountingAngle = 17.2; // 15.0 degrees

    // Distance setpoints

    public static final double HATCH_CONNECTION_AREA = 8.8; 
	
    public static final double ROCKET_SHOOTING_AREA = 7.5; 

    // Error tolerance

    public static final double rotationalErrorTolerance = 0.5f; // 0.5 degree error tolerance 

    public static final double fowardErrorTolerance = 1.0f; // 1 percent area error tolerance

    // Sensitivity set

    public static final double highGear = 0.5;

    public static final double lowGear = 0.25;

}

