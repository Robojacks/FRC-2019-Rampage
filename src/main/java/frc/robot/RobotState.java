/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Keeps track of changing variables that track the state of the robot, such as whether the beak is
 * open or closed, if the neck is extended or retracted, or if the ramp has been deployed yet.
 */
public class RobotState {

    // State Variables

    public static boolean SandstormDeploy = true;

    public static boolean beakOut = false;

    public static boolean tailOut = false;

    public static boolean neckOut = false; 

    public static boolean sensitive = false; 

    public static boolean offensiveMode = true;

    public static boolean fullThrottle = false;

}
