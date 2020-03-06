package com.jjb.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

import org.springframework.util.FileCopyUtils;


public class UploadFileUtils {
	public static String profileFile(String uploadPath, String originalName, byte[] fileData) throws Exception{
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString()+"_"+originalName;
		String savedPath = File.separator+"profile";
		//uploadPath+savedPath ��� �̸��� ���� �����ȿ� savedName ������ ����
		File target = new File(uploadPath+savedPath, savedName);
		//���� ������� ��� : fileData ������ ����µ� �ʿ��� ����, target �̷��� �������� ������ �����ڴ� 
		FileCopyUtils.copy(fileData,  target);
		
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);//���������� .�� ã�Ƽ� �� ��ġ�� ��ȯ(+1�� �����μ� �ڿ� jpg��� �͸� ����) -> ������ ������ �˱� ����
		
		String uploadedFileName= null;
		//System.out.println("����� Ȯ�ο�"+MimeMediaUtil.getMediaType(formatName));
		
		uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		
		
		return uploadedFileName;
	}
	//uploadPath : servlet-context.xml�� ������ ���ε带 ���� ���
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception{
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString()+"_"+originalName;
		String savedPath = calcPath(uploadPath);
		//uploadPath+savedPath ��� �̸��� ���� �����ȿ� savedName ������ ����
		File target = new File(uploadPath+savedPath, savedName);
		//���� ������� ��� : fileData ������ ����µ� �ʿ��� ����, target �̷��� �������� ������ �����ڴ� 
		FileCopyUtils.copy(fileData,  target);
		
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);//���������� .�� ã�Ƽ� �� ��ġ�� ��ȯ(+1�� �����μ� �ڿ� jpg��� �͸� ����) -> ������ ������ �˱� ����
		
		String uploadedFileName= null;
		//System.out.println("����� Ȯ�ο�"+MimeMediaUtil.getMediaType(formatName));
		
		uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		
		
		return uploadedFileName;
	}
	
	private static String calcPath(String uploadPath) {
		
		Calendar cal = Calendar.getInstance(); // CalendarŬ�������� ��¥�� �������� �޼ҵ�
		String yearPath = File.separator+cal.get(Calendar.YEAR);// -> /2020
		String monthPath = yearPath+
				File.separator+
				new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);// DecimalFormat�� 2�ڸ��� ä��� ��(���ڸ��� 0���� ä���� .format���� ���� �� ���) , 1���� 0�̱� ������ +1 -> /2020/01
		String datePath = monthPath+
				File.separator+
				new DecimalFormat("00").format(cal.get(Calendar.DATE));// -> /2020/01/07
		
		makeDir(uploadPath,yearPath,monthPath,datePath);//���� ����� ���� �޼ҵ�
		System.out.println("datepath = "+datePath);
		
		return datePath;
	}
	
	private static void makeDir(String uploadPath, String... paths) {//String... �����迭 -> �迭�� ��Ȯ�� ���̸� �� �� ���
		
		if(new File(paths[paths.length-1]).exists()) {//�Ȱ��� ������ ������ �����ؼ� �ѱ�
			return;
		}
		
		for(String path : paths) {//paths�� ������ŭ ����
			File dirPath = new File(uploadPath+path);
			
			if(! dirPath.exists()) {//exists ���翩�� Ȯ�ο�
				dirPath.mkdir();//�Ȱ��� ������ ������ ������ ������
			}
		}
	}
	
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception{
		
		//BufferedImage ����� ���鶧 �ַ� ���(�����̹��� -> buffer(�ӽ� ������ġ:�����̹����� �ӽ÷� ���� ����) -> ����� �̹����� ��ȯ )
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));//ImageIO���� �о� ���δ��� buffer�ʿ� �ӽ� ����
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100);//������� ���� 100���� �ٲ㼭 ����
		
		String thumbnailName = uploadPath + path + File.separator + "s_"+ fileName;//����� �̸��� s_ �ٿ��� ����
		
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		
		return thumbnailName.substring(uploadPath.length()).replace(File.separator, "/");//replace ġȯ���ִ� �Լ�(File.separator \�̰� replace�� \�� /�� �ٲ��� -> ������ �νĽ�Ű�� ����)
	}
	
	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception{
		
		String iconName = uploadPath + path + File.separator + fileName;
		
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
}
