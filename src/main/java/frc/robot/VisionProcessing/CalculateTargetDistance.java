/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.VisionProcessing;

import frc.robot.Constants;

/** 
 * Uses angles and field measurements to estimate the distance from a target. These calculations will be 
 * used with the TargetTrackingSubsystem to move the robot towards the goal with the distance estimate.
 * More information here: {@linkplain http://docs.limelightvision.io/en/latest/cs_estimating_distance.html}
 * 
 * @see Constants
 * @see TargetTrackingSubsystem
 */
public class CalculateTargetDistance {

  private static double mountingRadians = Math.toRadians(Constants.cameraMountingAngle); // a1, converted to radians

  // find result of h2 - h1
  private static double differenceOfHeights = Constants.visionTapeHeightFt - Constants.cameraHeightInches;
  
  /** 
   * D = (h2 - h1) / tan(a1 + a2). This equation, along with known numbers, helps find the distance
   * from a target.
   */
  public static double getDistance() {

    // a2, converted to radians
    double radiansToTarget = Math.toRadians(Constants.ty.getDouble(0.0)); 

    // find result of a1 + a2
    double angleInRadians = mountingRadians + radiansToTarget;

    // find the tangent of a1 + a2
    double tangentOfAngle = Math.tan(angleInRadians); 

    // Divide the two results ((h2 - h1) / tan(a1 + a2)) for the distance to target
    double distance = differenceOfHeights/tangentOfAngle;

    // outputs the distance calculated
    return distance; 
  }

  /** 
   * a1 = arctan((h2 - h1) / d - tan(a2)). This equation, with a known distance input, helps find the 
   * mounted camera angle.
   */
  public static double getCameraMountingAngle(double measuredDistance) {

    // convert a2 to radians
    double radiansToTarget = Math.toRadians(Constants.ty.getDouble(0.0));

    // find result of (h2 - h1) / d
    double heightOverDistance = differenceOfHeights/measuredDistance;

    // find result of tan(a2)
    double tangentOfAngle = Math.tan(radiansToTarget);

    // (h2-h1)/d - tan(a2) subtract two results for the tangent of the two sides
    double TangentOfSides = heightOverDistance - tangentOfAngle; // feel free to change my name!

    // invert tangent operation to get the camera mounting angle in radians
    double newMountingRadians = Math.atan(TangentOfSides);

    // change result into degrees
    double cameraMountingAngle = Math.toDegrees(newMountingRadians);
    
    return cameraMountingAngle; // output result
  }

}
