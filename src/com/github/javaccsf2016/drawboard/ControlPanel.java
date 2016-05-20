//LeoYulinLi, califoxco(Jiaming Yang), qixin liu, and Tsoek Yin Lee Liu
package com.github.javaccsf2016.drawboard;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControlPanel extends JPanel { 

	private JButton redPenButton;
	private JButton bluePenButton;
	private JButton greenPenButton;
	private JButton eraserButton;
	private JButton clearAllButton;
	private JButton drawRectButton;
	private DrawBoardDisplay drawingPanel;

	public ControlPanel(DrawBoardDisplay drawingPanel)  {
		// set the background color
		setBackground(Color.cyan);
		
		this.drawingPanel = drawingPanel;		
		
		redPenButton = new JButton("Red Pen");
		this.add(redPenButton);
		redPenButton.addActionListener(new ButtonListener());
	
		bluePenButton = new JButton("Blue Pen");
		this.add(bluePenButton);
		bluePenButton.addActionListener(new ButtonListener());
		
		greenPenButton = new JButton("Green Pen");
		this.add(greenPenButton);
		greenPenButton.addActionListener(new ButtonListener());
		
		eraserButton = new JButton("Eraser");
		this.add(eraserButton);
		eraserButton.addActionListener(new ButtonListener());
		
		drawRectButton = new JButton("Rectangle Flash");
		this.add(drawRectButton);
		drawRectButton.addActionListener(new ButtonListener());
		
		clearAllButton = new JButton("Clear All");
		this.add(clearAllButton);
		clearAllButton.addActionListener(new ButtonListener());
		
	}
	
	


	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {				
			if(event.getSource()==redPenButton) {
				drawingPanel.redPen(); } 
			else if(event.getSource()==bluePenButton) {
				drawingPanel.bluePen();} 
			else if (event.getSource()==greenPenButton){
					drawingPanel.greenPen();}					
			else if(event.getSource()==eraserButton) {
				drawingPanel.eraser();} 
			else if(event.getSource()==drawRectButton) {
				drawingPanel.drawRect();}
			else if(event.getSource()==clearAllButton) {
				drawingPanel.clearAll();}
			
		}
	}
}