package com.LuminousVector.Excersies.Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import com.LuminousVector.Graphics.UI.UIManager;

public class SudokuApp extends Canvas implements Runnable
{
	public String title = "Sudoku";
	public static int WIDTH = 1280;
	public static int HEIGHT = 720;
	public static int SCALE = 1;

	private Thread thread;
	private boolean isRunning = false;

	private GameBoard board;
	private Keyboard key;
	private JFrame frame;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	private static UIManager uiManager;

	private int[] frameLog = new int[120];
	private int curIndex = 0;
	private boolean isDebug = false;

	public SudokuApp()
	{
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(size);

		frame = new JFrame();
		key = new Keyboard();
		addKeyListener(key);
		uiManager = new UIManager();
		board = new GameBoard(-1, -1, 60, 6);

		Mouse m = new Mouse();
		addMouseListener(m);
		addMouseMotionListener(m);

		for(int i = 0; i < pixels.length; i++)
		{
			pixels[i] = 0x100010;
		}
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
		double deltaTime = 0;
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
				frameLog[curIndex] = frames;
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
		board.Update(key);
		uiManager.Update();
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
		//screen.Clear();
		//board.Render(screen, g);

		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		uiManager.Render(g);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args)
	{
		SudokuApp game = new SudokuApp();
		game.frame.setResizable(false);
		game.frame.setTitle(game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}
}
