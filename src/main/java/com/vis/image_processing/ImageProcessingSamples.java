package com.vis.image_processing;

import java.awt.Rectangle;
import java.io.File;

import javax.swing.JOptionPane;

import ij.IJ;
import ij.ImagePlus;
import ij.gui.ImageRoi;
import ij.measure.Calibration;
import ij.plugin.LutLoader;
import ij.process.ByteProcessor;
import ij.process.ColorProcessor;
import ij.process.FloatProcessor;
import ij.process.ImageProcessor;
import ij.process.ShortProcessor;
import ij3d.Image3DUniverse;

public class ImageProcessingSamples {
	
	public static void main(String[] args) {
		// test these methods
		
		ImageProcessingSamples ips = new ImageProcessingSamples();
		
		//load sample
		ClassLoader classLoader = ips.getClass().getClassLoader();
		File file = new File(classLoader.getResource("samples/flybrain.tif").getFile());
		
		new ImageProcessingSamples().view3d(file.getAbsolutePath());
	}
	
	//pixel handling
	public float getPixelValue(ImagePlus imp, int row, int col) {
		if(imp != null) {
			return imp.getProcessor().getPixelValue(col, row);//(x,y)	
//			return imp.getProcessor().getf(col, row);//(x,y)//faster	
		}
		return Float.NaN;
	}
	
	//accessing pixels
	public void accessAllPixels(ImagePlus imp) {
		if (imp != null) {
			int w = imp.getWidth();
			int h = imp.getHeight();
			for (int j = 0; j < h; j++) {
				for (int i = 0; i < w; i++) {
					//do something
					//for example
					@SuppressWarnings("unused")
					float v = imp.getProcessor().getPixelValue(i, j);
				}
			}
		}
	}
	
	// accessing pixels faster.
	@SuppressWarnings("unused")
	public void accessAllPixelsBooster(ImagePlus imp) {
		if (imp != null) {
			int w = imp.getWidth();
			int h = imp.getHeight();
			ImageProcessor ip = imp.getProcessor();
			if (ip instanceof ByteProcessor) {
				byte[] pixels = (byte[]) ip.getPixels();
				for(int j = 0; j<h;j++) {
					for(int i = 0; i<w;i++) {
						int index = i + j*w;
						byte v = pixels[index];
					}
				}
			} else if (ip instanceof ShortProcessor) {
				short[] pixels = (short[]) ip.getPixels();
				for(int j = 0; j<h;j++) {
					for(int i = 0; i<w;i++) {
						int index = i + j*w;
						short v = pixels[index];
					}
				}
			} else if (ip instanceof FloatProcessor) {
				float[] pixels = (float[]) ip.getPixels();
				for(int j = 0; j<h;j++) {
					for(int i = 0; i<w;i++) {
						int index = i + j*w;
						float v = pixels[index];
					}
				}
			} else if (ip instanceof ColorProcessor) {
				int[] pixels = (int[]) ip.getPixels();
				for(int j = 0; j<h;j++) {
					for(int i = 0; i<w;i++) {
						int index = i + j*w;
						int v = pixels[index];
						int r = (v&0xff0000)>>16;
						int g = (v&0xff00)>>8;
						int b = v&0xff;
					}
				}
			} else {
				// do nothing
			}
		}
	}
	
	/**
	 * density calibration example using CT value.
	 * row_ct : no calibrated ct image
	 */
	public void densityCalibrationExample(ImagePlus row_ct) {
		Calibration cal = row_ct.getCalibration().copy();
		if(cal.getCoefficients() != null) {
			System.out.println("intercept:" + cal.getCoefficients()[0]);
			System.out.println("slope:" + cal.getCoefficients()[1]);
		}else {
			cal.setFunction(Calibration.STRAIGHT_LINE,//STRAIGHT_LINE=0,POLY2=1,POLY3=2,POLY4=3,EXPONENTIAL=4,POWER=5,LOG=6...etc
							new double[] {-1024, 1},//coefficients{intercept, slope}, 
							"HU");//unit
			row_ct.setCalibration(cal);
			row_ct.updateImage();
			
			System.out.println("Raw pixel:"+row_ct.getProcessor().getPixel(100, 100));
			System.out.println("Calibrated pixel:"+row_ct.getProcessor().getPixelValue(100, 100));
		}
	}
	
	/**
	 * If you want to adjust FOV, use voxel calibration.
	 * @param imp
	 */
	public void voxelSpacingCalibration(ImagePlus imp) {
//		check x-y-z
		Calibration cal = imp.getCalibration().copy();
		/*
		 * At first, check current voxel sizes.
		 */
		System.out.println("x:(pre)"+cal.pixelWidth);
		System.out.println("y:(pre)"+cal.pixelHeight);
		System.out.println("z:(pre)"+cal.pixelDepth);//slice thickness or spacing between slices
		/*
		 * specify voxel size unit.
		 * dicom default is "mm"
		 * (or, μm, mm, cm, m, pixel etc)
		 * "pixel" unit is a default for no calibrated images.
		 */
		cal.setUnit("mm");
		/*
		 * set voxle sizes
		 * default is 1*1*1.
		 */
		cal.pixelWidth = 500d/320d;
		cal.pixelHeight = 500d/320d;
		cal.pixelDepth = 1.0;
				
		/*
		 * set calibration to imp
		 */
		imp.setCalibration(cal);
		
		//validation
		System.out.println("x:(post)"+imp.getCalibration().pixelWidth);
		System.out.println("y:(post)"+imp.getCalibration().pixelHeight);
		System.out.println("z:(post)"+imp.getCalibration().pixelDepth);//slice thickness
		
		imp.updateImage();
//		imp.updateAndRepaintWindow();//if you showing image, use it.
		
		/*
		 * if you need saving images with voxel calibrated information,
		 * you should use one of tiff/tiff, DICOM, Analyze file format.
		 * general image formats such as jpeg or png etc, can not hold these information.
		 */
	}
	
	//access to Roi
	public void accessToRoi(ImagePlus imp) {
		ImageProcessor ip = imp.getProcessor();
		Rectangle bounds = ip.getRoi();
		ImageProcessor mask = imp.getMask();
		int sum = 0;
		int count = 0;
		for (int y = 0; y < bounds.height; y++) {
			for (int x = 0; x < bounds.width; x++) {
				if (mask == null || mask.getPixel(x, y) != 0) {
					sum += ip.getf(x + bounds.x, y + bounds.y);
					count++;
				}
			}
		}
		System.out.println("mean intensity and pixels count: " + IJ.d2s(sum / count, 4) + " " + count);
	}
	
	
	/*
	 * Image filtering examples
	 * 
	 * Convolution filter：Convolve3*3(or Use the Convolver class)
	 * Sharpen
	 * Smooth
	 * GaussianBlur
	 */
	public void imageFilter(ImagePlus imp) {
		
		if(!imp.isVisible()) {
			imp.show();
		}
		
		//Convolution3*3（smoothing）
//		imp.getProcessor().convolve3x3(new int[] {0,1,0,1,4,1,0,1,0});		
		
		//sharpen
		imp.getProcessor().sharpen();
		
		//Smooth
//		imp.getProcessor().smooth();
		
		//GaussianBlur
//		GaussianBlur blur = new GaussianBlur();
//		blur.blurGaussian(imp.getProcessor(), 3.0);//sigma:0.0～5.0
		
		imp.updateAndRepaintWindow();
		
		/*
		 * （note）
		 * Convolver class can process convolution filtering.
		 */
//		 ImageProcessor ip = imp.getProcessor();
//	     float[] H = {1,0,1,2,0,2,1,0,1};
//	     Convolver cv = new Convolver();
//	     cv.setNormalize(false);
//	     cv.convolve(ip,H,3,3); 
//		 imp.show();
	}
	
	/*
	 * Image Fusion Example.
	 * 
	 */
	/**
	 * 
	 * @param imp
	 * @param overlay
	 * @param path2lut : "Rainbow RGB.lut" etc.
	 */
	public void fusion(ImagePlus imp, ImagePlus overlay, String lutPath) {
		ByteProcessor bp = (ByteProcessor) overlay.getProcessor().convertToByte(true);
		bp.setLut(LutLoader.openLut(lutPath));
		ImageRoi imageRoi = new ImageRoi(0, 0, bp);
		imageRoi.setOpacity(0.25);
		imp.setRoi(imageRoi);
	}
	
	/*
	 * View 3D with flybrain.tiff
	 */
	public void view3d(String path2flybrain) {
		
		workaroundIntelGraphicsBug();
		
		File file = new File(path2flybrain);
		
		if(!file.exists() || !file.isFile()) {
			JOptionPane.showMessageDialog(null, file.getAbsolutePath()+"\nthis file not exists.", "image file load error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		ImagePlus flybrain = new ImagePlus(path2flybrain);
		
		//convert to 8-bit grayscale, if you need.
//		new StackConverter(imp).convertToGray8();
		
		Image3DUniverse univ = new Image3DUniverse();
		univ.show();
		
		//start as usual
		univ.getExecuter().addContent(flybrain, new File(path2flybrain));
	}
	
	/*
	 * https://forum.image.sc/t/java3d-based-plugin-crashes-with-com-jogamp-opengl-glexception-not-a-gl2-implementation/57960
	 */
	protected static void workaroundIntelGraphicsBug() { // FIXME: This should go away with jogl 2.40?
		/*
		 * In a fresh install of ubuntu 20.04 displaying a 3DViewer triggers a
		 * ```com.jogamp.opengl.GLException: Profile GL4bc is not available on
		 * X11GraphicsDevice (...)``` The workaround discussed here works:
		 * https://github.com/processing/processing/issues/5476. Since it has no
		 * (apparent) side effects, we'll use it here for all platforms
		 */
		System.setProperty("jogl.disable.openglcore", System.getProperty("jogl.disable.openglcore", "false"));
	}
}
