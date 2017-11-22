import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ColourSorts {
	
	static JFrame frame = new JFrame();

	public static void main(String[] args) {
		
		//Sorted array of integers
		int size = 255;
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++){
			array[i] = i + 1;
		}
		
		//Shuffle array
		shuffle(array);
		
		//Create buffered image
		int width = size;
		int height = 200;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//Colour the image in pixel-width columns, according to the shuffled array
		for (int x = 0; x < width; x++){
			
			img.setRGB(x, 0, Color.HSBtoRGB(array[x]/255f, 1.0f, 0.5f));
			
			for (int y = 1; y < height; y++){
				img.setRGB(x, y, Color.HSBtoRGB(array[x]/255f, 1.0f, 0.5f));
			}
		}
		
		//Show image in new window
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(new JLabel(new ImageIcon(img)));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private static void printImage(int[] array){
		int width = array.length;
		int height = 200;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++){
			img.setRGB(x, 0, Color.HSBtoRGB(array[x]/255f, 1.0f, 0.5f));
			for (int y = 1; y < height; y++){
				img.setRGB(x, y, Color.HSBtoRGB(array[x]/255f, 1.0f, 0.5f));
			}
		}
		frame.getContentPane().removeAll();
		frame.getContentPane().add(new JLabel(new ImageIcon(img)));
		frame.pack();
		frame.setVisible(true);
	}
	
	//Fisher-Yates shuffle function
	private static void shuffle(int[] a)
	{
	    int index, temp;
	    Random random = new Random();
	    for (int i = a.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = a[index];
	        a[index] = a[i];
	        a[i] = temp;
	    }
	}

}
