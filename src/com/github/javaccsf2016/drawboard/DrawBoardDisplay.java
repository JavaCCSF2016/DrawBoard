//LeoYulinLi, califoxco(Jiaming Yang), qixin liu, and Tsoek Yin Lee Liu
package com.github.javaccsf2016.drawboard;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class DrawBoardDisplay extends JPanel {
	public static final int RECTANGLE = 1;
	public static final int POINT_SIZE = 10;
	public static final int WINDOW_W = 800;
	public static final int WINDOW_L = 600;
	public static final int COLOR_RANGE = 256;
	public static final int RECT_W = 50;
	public static final int RECT_L = 70;
	private boolean isDrawing, drawRect;
	private static Color color = Color.black;
	private ArrayList<DrawPoint> pointList;
	
	
	public DrawBoardDisplay() {
		isDrawing = false;
		drawRect = false;
		setBackground(Color.PINK);
		this.addMouseMotionListener(new MouseMovementListener());	
		this.addMouseListener(new MouseListener());
		pointList = new ArrayList<>();
	}
			
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
				JFrame frame = new JFrame("Draw On Me");
				frame.setSize(WINDOW_W,WINDOW_L);
				DrawBoardDisplay drawingPanel = new DrawBoardDisplay();
				ControlPanel controlPanel = new ControlPanel(drawingPanel);
				frame.getContentPane().add(drawingPanel, BorderLayout.CENTER);
				frame.getContentPane().add(controlPanel, BorderLayout.SOUTH);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		   });
	}
	
	public class MouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			if(isDrawing) {
				isDrawing = false;
			} else {
				isDrawing = true;
			}
		}
	}

	public class MouseMovementListener extends MouseAdapter{
		@Override
		public void mouseMoved(MouseEvent event) {
			if(isDrawing) {
				DrawPoint newPoint = new DrawPoint(event.getPoint(), color);
				pointList.add(newPoint);
				repaint();
			}			
		}
	}

	@Override
	public void paintComponent(Graphics pen) {
		super.paintComponent(pen);
			for(DrawPoint p : pointList) {
				pen.setColor(p.getColor());
				if (p.getShape() == 1) {
					pen.fillRect(p.getX(), p.getY(), RECT_W, RECT_L);
				} else {
					pen.fillOval(p.getX(), p.getY(), POINT_SIZE, POINT_SIZE);
				}
				repaint();	
			}
		}
		
	

	public void redPen() {
		color = Color.RED; 
		drawRect = false;}

	public void bluePen() {
		color = Color.BLUE;	
		drawRect = false;}

	public void greenPen() {
		color = Color.GREEN;	
		drawRect = false;}

	public void eraser() {
		color = Color.PINK;	
		drawRect = false;}

	public void clearAll() {
		pointList.clear();
		drawRect = false;}

	public void drawRect() {
		Random randomGenerator = new Random();
		int red = randomGenerator.nextInt(COLOR_RANGE);
		int green = randomGenerator.nextInt(COLOR_RANGE);
		int blue = randomGenerator.nextInt(COLOR_RANGE);
		Color randomColor = new Color(red, green, blue);
		int randomX = randomGenerator.nextInt(WINDOW_W);
		int randomY =randomGenerator.nextInt(WINDOW_L);
		repaint();
		pointList.add(new DrawPoint(new Point(randomX, randomY), randomColor, RECTANGLE));
	}

}