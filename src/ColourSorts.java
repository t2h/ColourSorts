import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;


public class ColourSorts {

	public static void main(String[] args) {
		
		//Sorted array of integers
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
		
		//File object
		File f = null;
		
		//Colour the image in pixel-width columns, according to the shuffled array
		for (int x = 0; x < width; x++){
			
			img.setRGB(x, 0, Color.HSBtoRGB(array[x]/255f, 1.0f, 0.5f));
			
			for (int y = 1; y < height; y++){
				img.setRGB(x, y, Color.HSBtoRGB(array[x]/255f, 1.0f, 0.5f));
			}
			
		}
		
		//Write image to file
		try {
			f = new File("Output.png");
			ImageIO.write(img, "png", f);
		} catch (IOException e){
			System.out.println("Error: " + e);
		}
		
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
