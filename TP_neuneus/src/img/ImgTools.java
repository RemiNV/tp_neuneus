package img;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImgTools {

	public static Image loadImage(String filename) {
		try {
			return ImageIO.read(new File(filename));
		}
		catch(IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Erreur d'ouverture de l'image : " + filename);
		}
	}
}
