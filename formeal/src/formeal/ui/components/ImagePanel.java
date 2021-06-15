package formeal.ui.components;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	public static final String DEF_NAME = "no_name.png";
	private Image bgImg; // �г� ���� ��� �̹���
	private String imgFilename; // ����̹��� ���ϰ��
	private int width;
	private int height;
	//
	
	// JComponent::���� ������ 
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if( this.bgImg != null ) {
			g.drawImage(bgImg, 0, 0, this);
		}
	}
	
	//
	public ImagePanel() {}

	public ImagePanel(Image bgImg) {
		this(bgImg, DEF_NAME);
	}
	
	public ImagePanel(Image bgImg, String imgFilename) {
		super();
		this.bgImg = bgImg;
		this.imgFilename = imgFilename;
		this.width = this.bgImg.getWidth(this); // �̹��� ũ�⸦ ���
		this.height = this.bgImg.getHeight(this);
		System.out.println(">> ImagePanel ������ " + imgFilename 
				+ " w = " + width + ", h = " + height);		
	}
	
	public ImagePanel(Image bgImg, String imgFilename, 
			int width, int height) {
		super();
//		this.bgImg = bgImg;   
		// ũ�� w, h �̹��� ũ�⸦ ������
		this.bgImg = bgImg.getScaledInstance(
				width, height, Image.SCALE_SMOOTH);
		this.imgFilename = imgFilename;
		this.width = width;
		this.height = height;
		System.out.println(">> ImagePanel ������ " + imgFilename 
				+ " w = " + width + ", h = " + height);
	}



	//
	public Image getBgImg() {
		return bgImg;
	}
	public void setBgImg(Image bgImg) {
		this.bgImg = bgImg;
	}
	public String getImgFilename() {
		return imgFilename;
	}
	public void setImgFilename(String imgFilename) {
		this.imgFilename = imgFilename;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
}
