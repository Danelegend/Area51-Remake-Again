package me.dane.area51;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Random;

import me.dane.area51.events.KeyInput;
import me.dane.area51.framework.Camera;
import me.dane.area51.framework.ObjectId;
import me.dane.area51.objects.Player;
import me.dane.area51.zone.Area51Zone;
import me.dane.area51.zone.SafeZone;
import me.dane.area51.zone.TrackingZone;
import me.dane.area51.objects.Score;

public class Main extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	
	private boolean running = false;
	private Thread thread;
	
	public static int WIDTH;
	public static int HEIGHT;
	
	
	ScreenHandler sh;
	GameHandler gh;
	Camera cam;
	
	Area51Zone az;
	TrackingZone tz;
	SafeZone sz;
	
	Score score;
	
	public Main() {
		sh = new ScreenHandler();
		sz = new SafeZone();
		tz = new TrackingZone();
		az = new Area51Zone();
		score = new Score(WIDTH);
	}
	
	public static void main(String[] args) {
		
		Window w = new Window(800, 600, "Area-51", new Main());
		
		EventQueue.invokeLater(new Runnable() {
		
			@Override
			public void run() {
				w.checker();
			}
			
		});
	}

	private void init() {
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		gh = new GameHandler();
		
		cam = new Camera(0, 0);
		Random rand = new Random();
		
		for (int i = 0; i <= 10; i++) {
			
			int x = rand.nextInt(800*2-64);
			
			if (x < 64) {
				x = 64;
			}
			
			gh.addObject(new Player(x, 100, ObjectId.Player, gh, i));
		}
		
		gh.createLevel();
		
		this.addKeyListener(new KeyInput(gh, cam));
	}
	
	@Override
	public void run() {
		init();
		this.requestFocus();

		//Tick system not done by me

		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta = delta + ((now - lastTime) / ns);
			lastTime = now;
			
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}	
		}
	}
	
	private void tick() {
		gh.tick();
		for (int i = 0; i < gh.obj.size(); i++) {
			if (gh.obj.get(i).getId() == ObjectId.Player) {
				Player p = (Player) gh.obj.get(i);
				if (p.isControlled()) {
					cam.tick(gh.obj.get(i));
				}
			}
		}
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		//---------------------
		//Constant Background for game. Will draw over this
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g2d.translate(cam.getX(), cam.getY());
		
		sz.display(g);
		tz.display(g);
		az.display(g);
		score.display(g);
		
		gh.render(g);
		
		g2d.translate(cam.getX(), cam.getY());
		
		//----------------------
		g.dispose();
		bs.show();
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public ScreenHandler getScreenHandler() {
		return sh;
	}
	
}
