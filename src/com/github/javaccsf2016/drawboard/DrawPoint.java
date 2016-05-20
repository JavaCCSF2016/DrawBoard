//LeoYulinLi, califoxco(Jiaming Yang), qixin liu, and Tsoek Yin Lee Liu
package com.github.javaccsf2016.drawboard;

import java.awt.Color;
import java.awt.Point;

public class DrawPoint {
	private Point point;
	private Color color;
	private int shapeID;
	
	public DrawPoint(Point point, Color color, int shapeID){
		this.point = point;
		this.color = color;
		this.shapeID = shapeID;
	}
	
	public DrawPoint(Point point, Color color){
		this.point = point;
		this.color = color;
		this.shapeID = 0;
	}
	
	public Point getPoint() {
		return this.point;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public int getX() {
		return (int)this.point.getX();
	}
	
	public int getY() {
		return (int)this.point.getY();
	}
	
	public int getShape() {
		return this.shapeID;
	}
}
