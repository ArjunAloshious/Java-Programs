/**
 * Description of GrayScaleConverter *
 *
 * GrayScaleConverter is a program used to :
 * 
 * Select multiple images and for each image, take the average of each pixel's RGB values and set this for all pixels' RGB values of the new image.
 * Save these grayscale images with a new file name by adding a 'copy-' prefix.
 * Display the images.
 * 
 **/

import edu.duke.*;
import java.io.*;

public class GrayScaleConverter
{
	public ImageResource makeGray(ImageResource inImage)
	{
		ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
		for ( Pixel pixel: outImage.pixels() )
		{
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());		// returns a corresponding pixel of inImage
			int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) / 3;
			pixel.setRed(average);
			pixel.setGreen(average);
			pixel.setBlue(average);
		}
		return outImage;
	}

	public void testMultipleImages()
	{
		DirectoryResource dr = new DirectoryResource();
		for ( File f : dr.selectedFiles() )
		{
			ImageResource inImage = new ImageResource(f);
			ImageResource gray = makeGray(inImage);
			String fname = inImage.getFileName();
			String newName = "gray-" + fname;
			gray.setFileName(newName);
			gray.save();
			gray.draw();
		}
	}
}