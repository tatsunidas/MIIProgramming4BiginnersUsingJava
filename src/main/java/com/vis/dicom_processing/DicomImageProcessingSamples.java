package com.vis.dicom_processing;

public class DicomImageProcessingSamples {

	public static void main(String[] args) {

	}

	/*
	 * (0018, 0050) Slice Thickness：画像の厚み（mm）
	 * 
	 * (0018, 0088) Spacing Between
	 * Slices：画像スライスの連続方向において、ある画像のボクセル中心から、対応する次の画像のボクセル中心までの間隔（mm）
	 * 
	 * (0020, 0032) Image Position (Patient)：画像の左上隅の x, y, z 座標
	 * 
	 * (0020, 0037) Image Orientation (Patient)：患者を基準とした画像の最初の行と最初の列の方向余弦。x, y, z
	 * 軸のそれぞれの行の値と、x, y, z 軸のそれぞれの列の値
	 * 
	 * (0028, 0002) Samples per Pixel：ピクセルサンプル数（グレースケールなら1、カラーなら3）
	 * 
	 * (0028, 0004) Photometric Interpletation：ピクセルデータのタイプ（MONOCHROME2、RGBなど）。
	 * 
	 * (0028, 0006) Planar
	 * Configuration：カラーピクセルのエンコードタイプ。RRR…GGG…BBB…なのか、RGBRGB…なのかを示す（前者は1, 後者は0）。
	 * 
	 * (0028, 0008) Number of Frames：一連のフレーム（要するに動画）に含まれる画像の枚数。
	 * 
	 * (0028, 0010) Rows：行数
	 * 
	 * (0028, 0011) Columns：列数
	 * 
	 * (0028, 0030) Pixel Spacing：ピクセル（ボクセル）のx, yサイズ（値の順番は、row(y), column(x)）（mm）
	 * 
	 * (0028, 0100) Bits Allocated：割り当てビット（読み込まれるときに確保されるメモリ）
	 * 
	 * (0028, 0101) Bits Stored：格納ビット（ピクセルが表現されているデータ量）
	 * 
	 * (0028, 0102) High Bit：上位ビット（割り当てビットの中でピクセルが利用する最上位ビット位置。一般的に、Bits Stored -
	 * 1で表される。）
	 * 
	 * (0028, 0103) Pixel
	 * Representation：ピクセル値が符号なし（Unsigned）か符号つき（Signed）か（符号なしなら0、符号ありは1）
	 * 
	 * (7FE0, 0010) Pixel Data：OB, OWなピクセルデータ（8/16 bitのグレースケールまたはカラー画像）
	 * 
	 * (7FE0, 0008) Float Pixel Data：OFなピクセルデータ（32 bit グレースケール）
	 * 
	 * (7FE0, 0009) Double Float Pixel Data：ODなピクセルデータ（64 bit グレースケール）
	 */

}
