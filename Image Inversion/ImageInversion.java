/**
 * Description of ImageInversion *
 *
 * ImageInversion is a program used to :
 * 
 * Select multiple images and invert them by replacing RGB values with their complemented values.
 * Save these images with a new file name by adding a 'inverted-' prefix.
 * Display the images.
 * 
 **/
 
import edu.duke.*;
import java.io.*;

public class ImageInversion
{
	public ImageResource makeInversion (ImageResource inImage)
	{
		ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
		for ( Pixel pixel: outImage.pixels() )
		{
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			pixel.setRed( 255-inPixel.getRed() );
			pixel.setGreen( 255-inPixel.getGreen() );
			pixel.setBlue( 255-inPixel.getBlue() );
		}
		return outImage;
	}

	public void testMulitpleImages()
	{
		DirectoryResource dr = new DirectoryResource();
		for ( File f : dr.selectedFiles() )
		{
			ImageResource inImage = new ImageResource(f);
			ImageResource invert = makeInversion(inImage);
			String fname = inImage.getFileName();
			String newName = "inverted-" + fname;
			invert.setFileName(newName);
			invert.save();
			invert.draw();
		}
	}
}