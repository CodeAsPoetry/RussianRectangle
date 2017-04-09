package com.chuxuezhe.repaint;

import java.awt.Color;

public class StorageShape {
	private Color color;
	
	private String type;
	
	private int[] data = new int[10]; 
	
	public StorageShape(String type,Color color,int[] data){
		this.type = type;
		this.color= color;
		this.data = data;
	}
	
	public Color getColor(){
		return color;
	}
	
	public String getType(){
		return type;
	}
	public int getdata(int i){
		return data[i];
	}

}
