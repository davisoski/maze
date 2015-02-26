package maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Tablero extends JPanel implements ActionListener {

	private Timer timer;

	private Map m;

	private Player p;

	TecladoController entradasTeclado;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Tablero() {

		m = new Map();
		p = new Player();

		// Activo el controlador para el teclado
		addKeyListener();

		// Activo el doble buffer
		setDoubleBuffered(true);
		timer = new Timer(25, this);
		// timer.start();
	}

	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}

	/**
	 * Este metodo se activa cada vez que se pinta la pantalla, se minimiza, se
	 * cambia de tamanio, etc..
	 */
	public void paint(Graphics g) {
		super.paint(g);
		if (m != null) {
			for (int y = 0; y < 28; y++) {
				for (int x = 0; x < 28; x++) {
					if (m.getMap(x, y).equals("g")) {
						g.drawImage(m.getGrass(), x * 16, y * 16, null);
					}
					if (m.getMap(x, y).equals("h")) {
						g.drawImage(m.getHorizontal(), x * 16, y * 16, null);
					}
					if (m.getMap(x, y).equals("v")) {
						g.drawImage(m.getVertical(), x * 16, y * 16, null);
					}
					if (m.getMap(x, y).equals("1")) {
						g.drawImage(m.getL1(), x * 16, y * 16, null);
					}
					if (m.getMap(x, y).equals("2")) {
						g.drawImage(m.getL2(), x * 16, y * 16, null);
					}
					if (m.getMap(x, y).equals("3")) {
						g.drawImage(m.getL3(), x * 16, y * 16, null);
					}
					if (m.getMap(x, y).equals("4")) {
						g.drawImage(m.getL4(), x * 16, y * 16, null);
					}
					if (m.getMap(x, y).equals("d")) {
						g.drawImage(m.getDot(), x * 16, y * 16, null);
					}

					if (m.getMap(x, y).equals("p")) {
						g.drawImage(m.getPowerPellet(), x * 16, y * 16, null);
					}

					// Muros Laterales, superiores y T
					if (m.getMap(x, y).equals("5")) {
						g.drawImage(m.gethSuperior(), x * 16, y * 16, null);
					}
					if (m.getMap(x, y).equals("6")) {
						g.drawImage(m.gethInferior(), x * 16, y * 16, null);
					}
					if (m.getMap(x, y).equals("7")) {
						g.drawImage(m.getvIzquierda(), x * 16, y * 16, null);
					}
					if (m.getMap(x, y).equals("8")) {
						g.drawImage(m.getvDerecha(), x * 16, y * 16, null);
					}
					if (m.getMap(x, y).equals("0")) {
						g.drawImage(m.getCero(), x * 16, y * 16, null);
					}

				}
			}

			System.out.println("Paint(), p.getX: " + p.getX() + " p.getY: "
					+ p.getY());
			g.drawImage(p.getPlayer(), p.getX(), p.getY(), null);
		} else {
			System.out.println("m == null");
		}
	}

	private void addKeyListener() {
		entradasTeclado = new TecladoController(p);
		this.addKeyListener(entradasTeclado);
		setFocusable(true);

	}

	public class A1 extends KeyAdapter {

		public void KeyPressed(KeyEvent e) {

			int keycode = e.getKeyCode();

			if (keycode == KeyEvent.VK_LEFT) {
				System.out.println("LEFT");
				p.move(0, -16, 0, -1);
			}
			if (keycode == KeyEvent.VK_RIGHT) {
				System.out.println("RIGHT");
				p.move(0, -16, 0, -1);
			}
			if (keycode == KeyEvent.VK_UP)
				System.out.println("UP");
			{
				p.move(0, -16, 0, -1);
			}
			if (keycode == KeyEvent.VK_DOWN) {
				System.out.println("DOWN");
				p.move(0, 16, 0, 1);
			}

			switch (keycode) {
			case 32:
				System.out.println("TAB.PAUSA");
				break;
			}

		}

		public void KeyReleased(KeyEvent e) {

		}

		public void KeyTyped(KeyEvent e) {

		}

	}
}
