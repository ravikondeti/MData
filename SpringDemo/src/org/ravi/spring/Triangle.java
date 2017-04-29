package org.ravi.spring;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware {
////	String message;
////	int height;
////	public Triangle(String message){
////		this.message=message;
////	}
////	
////	public Triangle(int height){
////		this.height=height;
////	}
////	
////	public Triangle(String message, int height){
////		this.message=message;
////		this.height=height;
////	}
////	
//////	public void setMessage(String message){
//////		this.message=message;
//////	}
////	
////	public int getHeight() {
////		return height;
////	}
////
////	public String getMessage(){
////		return message;
////	}
//	
//	private Point pointA;
//	private Point pointB;
//	private Point pointC;
//	
//	public Point getPointA() {
//		return pointA;
//	}
//
//	public void setPointA(Point pointA) {
//		this.pointA = pointA;
//	}
//
//	public Point getPointB() {
//		return pointB;
//	}
//
//	public void setPointB(Point pointB) {
//		this.pointB = pointB;
//	}
//
//	public Point getPointC() {
//		return pointC;
//	}
//
//	public void setPointC(Point pointC) {
//		this.pointC = pointC;
//	}
	
//	private List<Point> points;
//
//	public List<Point> getPoints() {
//		return points;
//	}
//
//	public void setPoints(List<Point> points) {
//		this.points = points;
	// }
//	public void draw(){
//		for(Point point:points){
//			System.out.println("Point = ( " +point.getX() +","+point.getY() +")");
//		}
	
	private Map<Object, Point> points;
	
	private ApplicationContext context= null;

public Map<Object, Point> getPoints() {
		return points;
	}


	public void setPoints(Map<Object, Point> points) {
		this.points = points;
	}


public void draw(){

	for(Map.Entry<Object, Point> entry : points.entrySet())	{	
			System.out.println("Point = ( " +entry.getValue().getX() +","+entry.getValue().getY() +")");
		}
		
}


@Override
public void setApplicationContext(ApplicationContext context) throws BeansException {
	
	this.context=context;
}

private ContextTest contestTestA;
private ContextTest contestTestB;
private ContextTest contestTestC;

public ContextTest getContestTestA() {
	return contestTestA;
}


public void setContestTestA(ContextTest contestTestA) {
	this.contestTestA = contestTestA;
}


public ContextTest getContestTestB() {
	return contestTestB;
}


public void setContestTestB(ContextTest contestTestB) {
	this.contestTestB = contestTestB;
}


public ContextTest getContestTestC() {
	return contestTestC;
}


public void setContestTestC(ContextTest contestTestC) {
	this.contestTestC = contestTestC;
}


public void testContext(){
	ContextTest contTest =(ContextTest) context.getBean("ContextTest");
	System.out.println("Id : "+contTest.getId()+" "+"name :"+contestTestA.getName());
	
}



}

