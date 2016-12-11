package com.hm.birthday.utils;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.util.StringUtils;

public class ImgUtils {
	
	private final static Integer default_x=225;
	private final static Integer default_y=170;
	
	/**
	 * 按尺寸缩小图片
	 * 
	 * @param srcpath 原始文件路径
	 * @param targetPath 目标文件路径
	 * @param oldName 原文件名
	 * @param newName 新文件名
	 * @param destWidth 宽
	 * @param destHeight 高
	 */
	public static void shrinkImgWithSize(String srcpath, String targetPath,
			String oldName, String newName, 
			Integer destWidth, Integer destHeight) {
		try {
			BufferedImage src = ImageIO.read(new File(srcpath + "/" + oldName)); // 读入文件
			int width = src.getWidth(); // 得到源图宽
			int height = src.getHeight(); // 得到源图长
			destWidth = destWidth == null ? default_x : destWidth;
			destHeight = destHeight == null ? default_y : destHeight;
			newName = StringUtils.isEmpty(newName) ? oldName: newName;
			
			// 第一步，压缩
			if (width >= destWidth && height >= destHeight) {
				if (width > height) {
					height = height * destWidth / width;
					width = destWidth;
				} else {
					width = width * destHeight / height;
					height = destHeight;
				}
			} else if (width >= destWidth && height < destHeight) {
				height = height * destWidth / width;
				width = destWidth;
			} else if (width < destWidth && height >= destHeight) {
				width = width * destHeight / height;
				height = destHeight;
			}
			
			Image image = src.getScaledInstance(width, height, Image.SCALE_DEFAULT);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			File targetFile =  new File(targetPath + "/" + newName);
			if (!targetFile.getParentFile().exists()) {
				targetFile.mkdirs();
			}
			final String suffix = newName.substring(newName.indexOf(".")+ 1);
			ImageIO.write(tag, suffix, targetFile);// 输出到文件流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
