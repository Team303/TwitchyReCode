package org.usfirst.frc.team303.robot;

import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.AxisCamera;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Camera {
	
	public Object imgLock = new Object();
	private Thread visionThread;
	private boolean runProcessing = false;
	private double centerXOne = 0.0;
	private double centerYOne = 0.0;
	private double centerXTwo = 0.0;
	private double centerYTwo = 0.0;
	private double centerXAvg = 0.0;
	private double centerYAvg = 0.0;
	private double rectangleArea=0.0;
	public int cameraResX = 480;
	public int cameraResY = 360;
	
	public Camera() {
		//enableVisionThread(); //outputs a processed feed to the dashboard (overlays the found boiler tape)
	}
}
/*	public void enableVisionThread() {
		AxisCamera camera = CameraServer.getInstance().addAxisCamera("10.3.3.8");
		camera.setResolution(cameraResX, cameraResY);
		
		CvSink cvSink = CameraServer.getInstance().getVideo(); //capture mats from camera
		CvSource outputStream = CameraServer.getInstance().putVideo("Stream", cameraResX, cameraResY); //send steam to CameraServer
		Mat mat = new Mat(); //define mat in order to reuse it
		
		runProcessing = true;
		
		visionThread = new Thread(() -> {
			
			while(!Thread.interrupted()) { //this should only be false when thread is disabled
				
				if(cvSink.grabFrame(mat)==0) { //fill mat with image from camera)
					outputStream.notifyError(cvSink.getError()); //send an error instead of the mat
					SmartDashboard.putString("Vision State", "Acquisition Error");
					continue; //skip to the next iteration of the thread
				}
				
				if(runProcessing) {		
					
					pipeline.process(mat); //process the mat (this does not change the mat, and has an internal output to pipeline)
					int contoursFound = pipeline.filterContoursOutput().size();
					SmartDashboard.putString("More Vision State","Saw "+contoursFound+" Contours");
					
					if(contoursFound>=2) {
						
						Rect rectOne = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0)); //get the first MatOfPoint (contour), calculate bounding rectangle
						Rect rectTwo = Imgproc.boundingRect(pipeline.filterContoursOutput().get(1)); //get the second MatOfPoint (contour)
						Rect rectThree = null;
						
						if(contoursFound==2) {
							Rect rectLeft = (rectOne.x<rectTwo.x) ? rectOne : rectTwo;
							Rect rectRight = (rectOne.x>rectTwo.x) ? rectOne : rectTwo;
							
							rectOne = rectRight;
	*/