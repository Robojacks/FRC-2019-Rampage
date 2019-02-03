/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.DriveToHatch;

import frc.robot.Constants;

/** 
 * Uses angles and field measurements to estimate the distance from a target. These calculations will be 
 * used with the TargetTrackingSubsystem to move the robot towards the goal with the distance estimate.
 * More information here: {@linkplain http://docs.limelightvision.io/en/latest/cs_estimating_distance.html}
 * 
 * @see TargetTrackingSubsystem
 */
public class CalculateTargetDistance {

  private static double angleToTarget;

  private static double cameraMountingAngle;

  private static double mountingAngleInRadians;

  private static double angleToTargetInRadians;

  private static double tangentOfAngle;

  private static double differenceOfHeights;

  private static double distance;
  
  /** 
   * D = (h2 - h1) / tan(a1 + a2). This equation, along with known numbers, helps find the distance
   * from a target.
   */
  public static double getDistance() {
    angleToTarget = Constants.ty.getDouble(0.0);

    cameraMountingAngle = Constants.cameraMountingAngle;

    mountingAngleInRadians = Math.toRadians(cameraMountingAngle); // a1, converted to radians

    angleToTargetInRadians = Math.toRadians(angleToTarget); // a2, converted to radians

    // find result of a1 + a2
    double angleInRadians = mountingAngleInRadians + angleToTargetInRadians;

    // find the tangent of a1 + a2
    tangentOfAngle = Math.tan(angleInRadians); 

    // find result of h2 - h1
    differenceOfHeights = Constants.visionTapeHeightFt - Constants.cameraHeightFt;

    // Divide the two results ((h2 - h1) / tan(a1 + a2)) for the distance to target
    distance = differenceOfHeights/tangentOfAngle;

    return distance; // outputs the distance calculated
  }

  /** 
   * a1 = arctan((h2 - h1) / d - tan(a2)). This equation, with a known distance input, helps find the 
   * mounted camera angle.
   */
  public static double getCameraMountingAngle(double measuredDistance) {
    
    distance = measuredDistance; // d

    angleToTarget = Constants.ty.getDouble(0.0); // a2

    // convert a2 to radians
    angleToTargetInRadians = Math.toRadians(angleToTarget);

    // find result of (h2 - h1) for hatch vision tape
    differenceOfHeights = Constants.visionTapeHeightFt - Constants.cameraHeightFt;

    // find result of (h2 - h1) / d
    double heightOverDistance = differenceOfHeights/distance;

    // find result of tan(a2)
    tangentOfAngle = Math.tan(angleToTargetInRadians);

    // (h2-h1)/d - tan(a2) subtract two results for the tangent of the two sides
    double TangentOfSides = heightOverDistance - tangentOfAngle; // feel free to change my name!

    // subtract two results for the camera mounting angle in radians
    mountingAngleInRadians = Math.atan(TangentOfSides);

    // change result into degrees
    cameraMountingAngle = Math.toDegrees(mountingAngleInRadians);
    
    return cameraMountingAngle; // output result
  }

}
