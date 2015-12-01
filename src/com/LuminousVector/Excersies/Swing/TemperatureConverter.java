package com.LuminousVector.Excersies.Swing;

import com.LuminousVector.Utils.MathV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Arc2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureConverter extends Canvas
{
	private JLabel fahrenheitLabel;
	private JLabel celsiusLabel;
	private JTextField input;
	private JLabel output;
	private JButton convertButton;
	private JPanel mainPanel;

	public TemperatureConverter()
	{

		convertButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				Convert();
			}
		});
		input.addPropertyChangeListener(new PropertyChangeListener()
		{
			@Override
			public void propertyChange(PropertyChangeEvent propertyChangeEvent)
			{
				Convert();
			}
		});
		input.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyTyped(KeyEvent keyEvent)
			{
				super.keyTyped(keyEvent);
				Convert();
			}
		});
	}

	public void Convert()
	{
		String inS = input.getText();
		if(inS.length() == 0)
			return;
		double in = Double.parseDouble(inS);
		double out = MathV.Round(in * 1.8 + 32, 1000);
		output.setText(out + "C");

	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("TemperatureConverter");
		frame.setContentPane(new TemperatureConverter().mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
