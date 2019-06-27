/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import frc.robot.RobotMap;
import frc.robot.OI;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem implements RobotMap{
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static DriveTrain instance;
  private Talon back_left, back_right, front_left, front_right;

  private DriveTrain() {
    back_left = new Talon(BACK_LEFT_DRIVE);
    back_right = new Talon(BACK_RIGHT_DRIVE);
    front_left = new Talon(FRONT_LEFT_DRIVE);
    front_right = new Talon(FRONT_RIGHT_DRIVE);
  }

  public static DriveTrain getInstance() {
    if (instance == null) {
      instance = new DriveTrain();
    }
    return instance;
  }

  public void ManualDrive() {
    front_left.set(0.6 * OI.getInstance().getJoystick().getZ() - OI.getInstance().getJoystick().getY());
    back_left.set(0.6 * OI.getInstance().getJoystick().getZ() - OI.getInstance().getJoystick().getY());
    front_right.set(0.6 * OI.getInstance().getJoystick().getZ() + OI.getInstance().getJoystick().getY());
    back_right.set(0.6 * OI.getInstance().getJoystick().getZ() + OI.getInstance().getJoystick().getY());
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
