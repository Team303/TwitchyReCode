package org.usfirst.frc.team303.robot;

import org.usfirst.frc.team303.robot.RobotMap;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.I2C;
import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;
public class Drivebase {
	CANTalon FL;
	CANTalon FR;
	CANTalon BL; //swagmoney
	CANTalon BR;
	RobotDrive drivebase;
	AHRS navX;
	public Drivebase() {
		FL = new CANTalon(RobotMap.FL);
		FR = new CANTalon(RobotMap.FR);
		BL = new CANTalon(RobotMap.BL);
		BR = new CANTalon(RobotMap.BR);
		drivebase = new RobotDrive(FL, BL, FR, BR);
		drivebase.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, RobotMap.FL_INV);
		drivebase.setInvertedMotor(RobotDrive.MotorType.kFrontRight, RobotMap.FR_INV);
		drivebase.setInvertedMotor(RobotDrive.MotorType.kRearLeft, RobotMap.BL_INV);
		drivebase.setInvertedMotor(RobotDrive.MotorType.kRearRight, RobotMap.BR_INV);
		drivebase.setSafetyEnabled(true);	
	}
	
	public void drive(double left, double right) {
		drivebase.tankDrive(left, right);
	}
	
	public void zeroEncoders() {
		FL.setEncPosition(0);
		BR.setEncPosition(0);
	}
	
	public int getLeftEncoder() {
		return FL.getEncPosition();
	}
	
	public int getRightEncoder() {
		return BR.getEncPosition();
	}
}
