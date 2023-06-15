package com.vis.dicom_processing;

import java.io.File;

import ij.ImagePlus;
import ij.util.DicomTools;

public class DicomImageProcessingSamples {

	public static void main(String[] args) {
		DicomImageProcessingSamples dips = new DicomImageProcessingSamples();
		
		//load sample
		ClassLoader classLoader = dips.getClass().getClassLoader();
		File file = new File(classLoader.getResource("samples/CT_LEE_IR6a.dcm").getFile());
		ImagePlus imp = new ImagePlus(file.getAbsolutePath());
		
		dips.getValueFromHeader(imp, "0018,0050");
	}

	/*
	 * Dicom meta information commonly used for image processing.
	 * 
	 * (0018, 0050) Slice Thickness
	 * (0018, 0088) Spacing Between Slices
	 * (0020, 0032) Image Position (Patient)：left upper voxel coordinates of x, y, z
	 * (0020, 0037) Image Orientation (Patient)：patient basis direction cosine of row and col (x, y, z)
	 * (0028, 0002) Samples per Pixel：grayscale is 1, color is 3）
	 * (0028, 0004) Photometric Interpletation：MONOCHROME2, RGB etc
	 * (0028, 0006) Planar Configuration：color pixel encode type. type1::RRR…GGG…BBB… or type0::RGBRGB…
	 * (0028, 0008) Number of Frames
	 * (0028, 0010) Rows
	 * (0028, 0011) Columns
	 * (0028, 0030) Pixel Spacing：x, y size (row(y), column(x)) [mm]
	 * (0028, 0100) Bits Allocated：pixel memory size when reading
	 * (0028, 0101) Bits Stored：Amount of data in which pixels are represented
	 * (0028, 0102) High Bit：Bits Stored -1
	 * (0028, 0103) Pixel Representation：Unsigned0 or Signed1
	 * 
	 * Following tags hold bulk pixel dataset, so do not show contents of attributes here.
	 * (7FE0, 0010) Pixel Data：OB, OW pixel data (8/16 bit grayscale or RGB）
	 * (7FE0, 0008) Float Pixel Data：OF pixel data（32 bit grayscale）
	 * (7FE0, 0009) Double Float Pixel Data：OD pixel data（64 bit grayscale）
	 */
	
	/*
	 * imagej can only read uncompressed dicom image (with (7FE0, 0010) Pixel Data).
	 */
	
	/**
	 * 
	 * @param dcm
	 * @param tag : e.g., "0018,0088"
	 */
	public void getValueFromHeader(ImagePlus dcm, String tag) {
		System.out.println(DicomTools.getTag(dcm, tag.toLowerCase().replace(" ", "")));
	}

}
