package com.LuminousVector.CSCI151.Excersies.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import com.LuminousVector.CSCI151.Excersies.Sudoku.Mouse;
import com.LuminousVector.CSCI151.Excersies.Sudoku.Keyboard;
import com.LuminousVector.Graphics.UI.UIManager;

public class CalculatorApp extends  Canvas implements Runnable
{
	public String title = "Calculator";
	public static int WIDTH = 1280;
	public static int HEIGHT = 720;
	public static int SCALE = 1;
	public static double deltaTime;

	private Thread thread;
	private boolean isRunning = false;

	private Keyboard key;
	private JFrame frame;
	private CalculatorUI calc;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	private static UIManager uiManager;

	private int curIndex = 0;

	public CalculatorApp()
	{
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(size);

		//screen = new Screen(WIDTH, HEIGHT);
		frame = new JFrame();
		key = new Keyboard();
		addKeyListener(key);
		uiManager = new UIManager();
		calc = new CalculatorUI();

		Mouse m = new Mouse();
		addMouseListener(m);
		addMouseMotionListener(m);
	}

	public static int GetWidth()
	{
		return WIDTH * SCALE;
	}

	public static int GetHeight()
	{
		return HEIGHT * SCALE;
	}

	public static UIManager getUIManager()
	{
		return uiManager;
	}

	public synchronized void start()
	{
		isRunning = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop()
	{
		isRunning = false;
		try
		{
			thread.join();
		}catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void run()
	{
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0; //Update Rate
		deltaTime = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while (isRunning)
		{
			long now = System.nanoTime();
			deltaTime += (now - lastTime) / ns;
			lastTime = now;

			while (deltaTime >= 1)
			{
				Update();
				updates++;
				deltaTime--;
				Render();
				frames++;
			}

			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				curIndex++;
				if(curIndex > 119)
					curIndex = 0;
				frame.setTitle(title + " | " + frames + "fps, " + updates + "ups");
				updates = 0;
				frames = 0;

			}
		}
		stop();
	}

	public void Update()
	{
		key.Update();
		uiManager.Update();
		calc.Update(key);
	}

	public void Render()
	{
		BufferStrategy bs = getBufferStrategy();
		if (bs == null)
		{
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		/*screen.Clear();
		for(int i = 0; i < pixels.length; i++)
		{
			pixels[i] = screen.pixels[i];
		}*/
		//g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		uiManager.Render(g);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args)
	{
		CalculatorApp game = new CalculatorApp();
		game.frame.setResizable(false);
		game.frame.setTitle(game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}
}
