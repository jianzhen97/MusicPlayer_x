package com.lenovo.vo;

public class GridMainMenu {
	private String num;
	private String text;
	private int image;

	
	

	public GridMainMenu(String num, String text, int image) {
		this.num = num;
		this.text = text;
		this.image = image;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}
}
