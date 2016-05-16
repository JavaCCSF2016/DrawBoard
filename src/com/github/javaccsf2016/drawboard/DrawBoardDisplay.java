package com.github.javaccsf2016.drawboard;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class DrawBoardDisplay extends JPanel {
	private boolean isDrawing;
	private static Color color = Color.black;
	private ArrayList<Point> pointList;
	
	
	public DrawBoardDisplay() {
		isDrawing = false;
		setBackground(Color.PINK);
		this.addMouseMotionListener(new MouseMovementListener());	
		this.addMouseListener(new MouseListener());
		pointList = new ArrayList<>();
	}
			
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
				JFrame frame = new JFrame("Draw On Me");
				frame.setSize(800,600);
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
			System.out.println(pointList);
			System.out.println(isDrawing);
		}
	}

	public class MouseMovementListener extends MouseAdapter{
		@Override
		public void mouseMoved(MouseEvent event) {
			if(isDrawing) {
				Point mostRecentPosition = event.getPoint();
				pointList.add(mostRecentPosition);
				repaint();
			}			
		}
	}

	@Override
	public void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		pen.setColor(color);

		for(Point p : pointList) {
			int x = (int) p.getX();
			int y = (int) p.getY();
			pen.fillOval((int)x, (int)y, 10, 10);
			repaint();
			
		}
	}

	public void redPen() {
		color = Color.RED; 	}

	public void bluePen() {
		color = Color.BLUE;	}

	public void greenPen() {
		color = Color.GREEN;	}

	public void eraser() {
		color = Color.PINK;	}

	public void clearAll() {
		pointList.clear();}

}
