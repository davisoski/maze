package maze;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Map {

	private static final String ruta = "C://google-drive//eclipse-proyectos//Maze//images//16x16//";
	private Scanner m;

	private String Map[] = new String[28];

	private Image grass;

	// Muros en forma de esquinas
	private Image L1, L2, L3, L4;

	// Muros horizontales, verticales y T (tes para las uniones)
	private Image hInferior, hSuperior, vIzquierda, vDerecha, horizontal,
			vertical;

	// Puntos y Power Pellets
	private Image dot, powerPellet;

	// PUnto de prueba
	private Image cero;

	public Map() {

		System.out.println("Map()");

		ImageIcon img = new ImageIcon(ruta + "grass.png");
		if (img != null) {
			System.out.println("Parece que ha cargado la imagen");
		} else {
			System.out.println("Parece que NO ha cargado la imagen");
		}
		grass = img.getImage();

		img = new ImageIcon(ruta + "horizontal.png");
		horizontal = img.getImage();

		img = new ImageIcon(ruta + "vertical.png");
		vertical = img.getImage();

		// Muros en forma de esquinas
		img = new ImageIcon(ruta + "L1.png");
		L1 = img.getImage();
		img = new ImageIcon(ruta + "L2.png");
		L2 = img.getImage();
		img = new ImageIcon(ruta + "L3.png");
		L3 = img.getImage();
		img = new ImageIcon(ruta + "L4.png");
		L4 = img.getImage();

		// Puntos y Power Pellets (Punto grande)
		img = new ImageIcon(ruta + "dot.png");
		dot = img.getImage();
		img = new ImageIcon(ruta + "pellet.png");
		powerPellet = img.getImage();

		// Muros horizontales, verticales y T
		img = new ImageIcon(ruta + "HInferior.png");
		hInferior = img.getImage();
		img = new ImageIcon(ruta + "HSuperior.png");
		hSuperior = img.getImage();
		img = new ImageIcon(ruta + "VIzquierda.png");
		vIzquierda = img.getImage();
		img = new ImageIcon(ruta + "VDerecha.png");
		vDerecha = img.getImage();

		img = new ImageIcon(ruta + "cero.png");
		cero = img.getImage();

		openFile();
		readFile();
		closeFile();

	}

	public void openFile() {
		try {
			m = new Scanner(
					new File(
							"C://google-drive//eclipse-proyectos//Maze//src//resources//mapa.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("error cargando el mapa");
		}
		System.out.println("Mapa Cargado");
	}

	public void readFile() {

		System.out.println("readFile()");
		while (m.hasNext()) {

			for (int i = 0; i < 28; i++) {
				Map[i] = m.next();
			}
		}
	}

	public void closeFile() {
		m.close();
	}

	public Image getGrass() {
		return grass;
	}

	public Image getL1() {
		return L1;
	}

	public Image getL2() {
		return L2;
	}

	public Image getL3() {
		return L3;
	}

	public Image getL4() {
		return L4;
	}

	public Image getDot() {
		return dot;
	}

	public Image getPowerPellet() {
		return powerPellet;
	}

	public Image gethInferior() {
		return hInferior;
	}

	public Image gethSuperior() {
		return hSuperior;
	}

	public Image getvIzquierda() {
		return vIzquierda;
	}

	public Image getvDerecha() {
		return vDerecha;
	}

	public Image getCero() {
		return cero;
	}

	public Image getHorizontal() {
		return horizontal;
	}

	public Image getVertical() {
		return vertical;
	}

	public String getMap(int x, int y) {
		String index = Map[y].substring(x, x + 1);
		return index;
	}

}
