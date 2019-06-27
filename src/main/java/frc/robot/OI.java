/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  private static OI instance;
  private Joystick stick;
  private JoystickButton shoot;
  private JoystickButton tiltUp;
  private JoystickButton tiltDown;

  public static OI getInstance() {
    if (instance == null) {
      instance = new OI();
    }
    return instance;
  }

  public OI() {
    stick = new Joystick(0);
    buttons();
  }

  public void buttons() {
    shoot = new JoystickButton(stick, 1);
    tiltUp = new JoystickButton(stick, 4);
    tiltDown = new JoystickButton(stick, 3);
    tieButtons();
  }

  public void tieButtons() {
    tiltUp.whileHeld(new TiltUp());
    tiltDown.whileHeld(new TiltDown());
    shoot.whenPressed(new Shoot());
  }

  public Joystick getJoystick() {
    return stick;
  }
}
