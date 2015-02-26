package maze;

import javax.swing.JFrame;

public class Maze {

	public static void main(String[] args) {

		new Maze();
	}

	public Maze() {

		JFrame f = new JFrame();
		f.setTitle("Maze");
		//Board tiene los tiles de 32x32
//		f.add(new Board());
		f.add(new Tablero());
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
