package maze;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Controlador para detectar las entradas desde el teclado
 * 
 * @author david
 * 
 */
public class TecladoController implements KeyListener {

	Player p;

	public TecladoController(Player p) {
		this.p = p;
	}


	public void keyTyped(KeyEvent e) {
		System.out.println("TecladoController.keyTyped");
	}

	
	public void keyPressed(KeyEvent e) {
		System.out.println("TecladoController.keyPressed");

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			System.out.println("VK_LEFT");
			p.move(0, -32, 0, -1);
			System.out.println("TecladoController.keyPressed(), p.getX: "
					+ p.getX() + " p.getY: " + p.getY());
		}
		if (key == KeyEvent.VK_RIGHT) {
			p.move(0, 32, 0, -1);
			System.out.println("VK_RIGHT");
		}
		if (key == KeyEvent.VK_UP) {
			p.move(-32, 0, -1, 0);
			System.out.println("VK_UP");
		}
		if (key == KeyEvent.VK_DOWN) {
			p.move(32, 0, 32, 0);
			System.out.println("VK_DOWN");
		}

		switch (key) {
		case 32:

			System.out.println("TAB.PAUSA");
			break;
		}

		System.out.println("TecladoController.keyPressed: " + key);

	}

	
	public void keyReleased(KeyEvent e) {
		System.out.println("TecladoController.keyReleased");
	}

}
