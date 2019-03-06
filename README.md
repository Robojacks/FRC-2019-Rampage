# FRC-2019-Rampage
Command based code for our 2019 robot, Rampage. 

## [Drive](/src/main/java/frc/robot/Drive)

* ### Drive Subsystem
Accessed through Robot.drivetrain, provides basis for all wheel movements, whether through teleOp with Drive(), or when autonomously moving with the vision tracking system system

* ### Drive (Command)
Utilizing drivetrain (DriveSubsystem), this drives the robot around based on the two joystick inputs from a Logitech Xbox Controller on X mode.

* ### Sensitivity Subsystem
Switches drivetrain between lowGear speed and highGear speed (although highGear is not technically the fastest speed, this
will be updated for consistency later)

* ### Change Sensitivity (Command)
Utilizes the Sensitivity Subsystem to switch sensitivity indirectly, while the Drive Subsystem switches the speed.

* ### Driver Mode Subsystem
Switches a value that can make the drivetrain go max speed (as fast as driver is willing to go) and switch motors to cruise (to reduce tipping), and back to normal again when necessary. This is primarily for defensive purposes, as qualification matches have shown that most alliances have one defensive bot.

* ### Switch Driving Mode (Command)
Utilizes Driver Mode Subsystem to switch between "offensive" and "defensive" mode. Drive Subsystem uses the values this changes to switch the mode.

## [Beak](/src/main/java/frc/robot/Beak)
Opens and closes the hatch holding mechanism

## [Neck](/src/main/java/frc/robot/Neck)
Extends and retracts the beak

## [Tail](/src/main/java/frc/robot/Tail)
Helps open up, hold up, or fold down ramp extension

## [Vision Processing](/src/main/java/frc/robot/VisionProcessing)

* ### LimelightSubsystem
Accessed through Robot.limelight, this controls the basic systems of the limelight besides the values, such as the ledMode, which configures light settings, the pipline, which tells the limelight what to look for, and camMode, whether the camera is currently being used for vision processing or driver viewing.

* ### RotateToPanelSubsystem
Accessed through Robot.panelRotation, this subsystem uses a built-in PID controller, which will rotate to the hatch panel using the vision tape as a guide, and Limelight x-angle differences as feedback. This can run alone through the RotateToHatchPanlel() command, or as an extra guidance mechanism through the TargetTrackingSubsystem into the GoToHatchPanel() command, where it can adjust to any small errors while the robot is moving forward.

* ### RotateToPanel (Command)
Utilizes drivetrain (DriveSubsystem), limelight (LimelightSubsystem), and panelRotation (RotateToPanelSubsystem). This enables the RotateToPanelSubsystem PID loop, initiates limelight settings, and stops the drivetrain once the initialize() method is called. The isFinished() method is called when the RotateToPanelSubsystem declares that it has successfully rotated to the target with the onTarget() method, or found that it lost the target with the noValidTarget() method. After the command has done its job, it stops the drivetrain to keep the position and disables the PID loop since there is no more need for calculations.

* ### CalculateTargetDistance
A simple file that calculates distance from a target using known heights and angles taken from Constants and the Limelight. Currently retired due to an inconsistency in distance updating.

* ### TargetTrackingSubsystem
Accessed through Robot.visionTracker, this subsystem uses a built-in PID controller, which will move the robot up to the hatch panel using the vision tape area as feedback. This subsystem also utilizes the RotateToPanelSubsystem to keep the robot on track. This passes both of these outputs to curvatureDrive, where quick adjustments can be made with IsRotating as necessary, although there are few cases that would knock the robot askew enough to use IsRotating.

* ### GoToPanel (Command)
Utilizes drivetrain (DriveSubsystem), limelight (LimelightSubsystem), panelRotation (RotateToPanelSubsystem), and visionTracker (TargetTrackingSubsystem). In the initialize() method, the value of dependent is changed to true for the RotateToPanelSubsystem to make it cooperate with the TargetTrackingSubsystem by outputting values rather than sending them to rotation(), the drivetrain is stopped, limelight settings are initialized, and both the TargetTrackingSubsystem and RotateToPanelSubsystem's PID loops are enabled. The isFinished() method is more complicated, as both subsystems need to be on target in order to stop the command. The end() method disables both of the PID loops and stops the drivetrain to keep the position. 

* ### GoToRocketShootingPosition
Utilizes drivetrain (DriveSubsystem), limelight (LimelightSubsystem), panelRotation (RotateToPanelSubsystem), and visionTracker (TargetTrackingSubsystem). Goes to a position to shoot a ball into the rocket utilizing similar settings to the GoToPanel() command.

## [Other Files](/src/main/java/frc/robot)

* ### Main
Initiates program, something that is not touched

* ### Robot
Controls state of robot by controlling commands and subsystems through the scheduler and being the liason between subsystems and commands

* ### Constants
Keeps track of limelight values and settings through NetworkTables and constant values, namely heights of various things in the field and the mounted camera angle, for use with the CalculateTargetDistance class.

* ### OI (Operator Interface)
Initializes and maps the xbox controller and its various buttons, along with mapping buttons to specific commands

* ### RobotMap
Initializes and maps all of the motors on the robot
