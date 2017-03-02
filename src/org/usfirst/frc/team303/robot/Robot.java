package org.usfirst.frc.team303.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	//static Camera camera;
	static Drivebase drivebase;
	static Timer timer;
	static Autonomous auto;
	//static PowerDistributionPanel pdp;
	static Intake intake;
	static double clawSetpoint = 0, intakeSetpoint = 0, clawWheelSetpoint = 0, clawRotation = 0;
	static OI oi = new OI();
	static Solenoid shifter = new Solenoid(62, 1);
	/*
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		//pdp = new PowerDistributionPanel(RobotMap.PDP);
		drivebase = new Drivebase();
		timer = new Timer();
		//	chooser.addDefault("Default Auto", defaultAuto);
		//chooser.addObject("My Auto", customAuto);
		//SmartDashboard.putData("Auto choices", chooser);
		shifter.set(true);
		
	}
	
	@Override
	public void robotPeriodic() {
		OI.update();
		
		
	}
	
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		//autoSelected = chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		//System.out.println("Auto selected: " + autoSelected);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		//switch (autoSelected) {
		//case customAuto:
			// Put custom auto code here
		//	break;
		//case defaultAuto:
		//default:
			// Put default auto code here
		//	break;
		}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		drivebase.drive(OI.lY, OI.rY);
		//intake.control();
		if(OI.lBtn[1]){
			shifter.set(true);
		}
		else{
			shifter.set(false);
		}
		
		if(OI.lBtn[2]){
			intake.set(1.0);
		}
		else if(OI.lBtn[3]){
			intake.set(-1.0);
		}
		else {
			intake.set(0);
		}
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}

