package org.usfirst.frc.team303.robot;

import edu.wpi.first.wpilibj.smartdashboard.*;

public class DashboardVision {
	static double navXSetpoint;
	static double encoderSetpoint;
	double iGain=0;
	double dGain=0;
	double oldError=0;
	boolean solvedX = false;
	boolean solvedY=false;
	boolean resetIGain=false;
	
	boolean log1=false;
	boolean log2=false;
	boolean current=false;
	
	public DashboardVision(){
		
	}
	public double[] calculateSetpoints(int rectLeft, int rectRight, int rectTop, int rectBottom){
		int xIdealPixel=150;
		int yIdealPixel=26;
		navXSetpoint=(((xIdealPixel-(rectLeft+rectRight)/2))*-.18659375)+Robot.drivebase.navX.getYaw();
		return null;
	}
}
