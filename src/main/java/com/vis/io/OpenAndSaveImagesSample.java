package com.vis.io;

import java.io.File;
import java.io.IOException;

import com.pixelmed.dicom.DicomException;
import com.pixelmed.dicom.ImageToDicom;

import ij.ImagePlus;
import ij.WindowManager;
import ij.io.FileSaver;
import ij.io.Opener;
import ij.io.SaveDialog;
import ij.plugin.FolderOpener;

public class OpenAndSaveImagesSample {

	public static void main(String[] args) {

	}
	
	private final String basePath = System.getProperty("user.home")+File.separator+"Desktop";

	// load image, open file
	public ImagePlus openImage() {

		/*
		 * using ij.io.Opener
		 */
		Opener opener = new Opener();
		opener.open();
		ImagePlus imp = WindowManager.getCurrentImage();
		if (imp == null) {
			System.out.println("can not load image !");
		}
		return imp;
	}

	public ImagePlus showImage(String path2file) {
		ImagePlus imp = new ImagePlus(path2file);
		imp.show();
		return imp;
	}
	
	public ImagePlus showStack(String path2folder) {
		ImagePlus imp = FolderOpener.open(path2folder, "stacks");
		imp.show();
		return imp;
	}

	// Output single image
	public void saveImage(ImagePlus imp) {
		SaveDialog saveDialog = new SaveDialog("Save", basePath, "outputImage", ".tif");
		FileSaver saver = new FileSaver(imp);
		saver.saveAsTiff(saveDialog.getDirectory() + saveDialog.getFileName());		
	}
	
	public void saveImageStack(ImagePlus imp) {
		SaveDialog saveDialog = new SaveDialog("Save", basePath, "outputImage", ".tif");
		FileSaver saver = new FileSaver(imp);
		saver.saveAsTiffStack(saveDialog.getDirectory() + saveDialog.getFileName());
	}

	// Create sample DICOM image (secondary capture)
	public void saveJpegToDICOM(ImagePlus imp) {
		String imgPath = imp.getOriginalFileInfo().directory + File.separator + imp.getOriginalFileInfo().fileName
				+ imp.getOriginalFileInfo().fileType;
		imgPath = imgPath.substring(0, imgPath.length() - 1);
		System.out.println("Output:" + imgPath);
		SaveDialog saveDialog = new SaveDialog("Save", basePath, "outputDCM", ".dcm");

		try {
			new ImageToDicom(imgPath, // input Jpeg
					saveDialog.getDirectory() + saveDialog.getFileName(), // output path
					"I2WI^I2WI", // Person name
					"1234567890", // Patient ID
					"2018072101", // Study Instance UID
					"0721130001", // Series Instance UID
					"0001");// Image Instance number
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DicomException e) {
			e.printStackTrace();
		}
	}

}
