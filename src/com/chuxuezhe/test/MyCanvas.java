package com.chuxuezhe.test;

import java.awt.Color;
import java.awt.Graphics;

public class MyCanvas {
	private int[][] gamegrap = new int[33][20];
	private static int score=0; 

	public void Init(){
		for(int i=0;i<32;i++){
			for(int j=1;j<19;j++){
				gamegrap[i][j]=0;	
			}
		}
		for(int j=0;j<20;j++){
			gamegrap[32][j]=8;
		}
		for(int i=0;i<33;i++){
			gamegrap[i][0]=8;
			gamegrap[i][19]=8;
		}
		
	
		
	}
	
	public int[][] getGamegrap(){
		return gamegrap;
	}
	
	public void setGamegrap(int[][] gamegrap){
		this.gamegrap = gamegrap;
	}
	
	public void paint(Graphics g){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<33;i++){
			for(int j=0;j<20;j++){
				if(8==gamegrap[i][j]){
					g.setColor(Color.white);
				}
				if(0==gamegrap[i][j]){
					g.setColor(Color.black);
				}
				if(1==gamegrap[i][j]){
					g.setColor(Color.blue);
				}
				if(2==gamegrap[i][j]){
					g.setColor(Color.pink);
				}
				if(3==gamegrap[i][j]){
					g.setColor(Color.yellow);
				}
				if(4==gamegrap[i][j]){
					g.setColor(Color.orange);
				}
				if(5==gamegrap[i][j]){
					g.setColor(Color.cyan);
				}
				if(6==gamegrap[i][j]){
					g.setColor(Color.green);
				}
				if(7==gamegrap[i][j]){
					g.setColor(Color.red);
				}
				g.fillRect(20*j, 20*i, 20, 20);	
			}
		}	
	}	

	public int computeFreshen(){
		int i,j;
		for(i=31;i>0;i--){
			int num=0;
			for(j=1;j<19;j++){
				if(gamegrap[i][j]!=0){
					num++;
				}else{
					continue;
				}
			}
			if(num==18){	
				
				for(j=1;j<19;j++){
					for(int k=31;k>0;k--){
						gamegrap[k][j]=gamegrap[k-1][j];	
					}
					gamegrap[0][j]=0;
				}
				
				score+=10;	
				
			}
			
			
		}	
		return score;
	}
	
	public Boolean isGameOver(){
		if(gamegrap[0][8]!=0||gamegrap[0][9]!=0||gamegrap[0][10]!=0||gamegrap[0][11]!=0){
			return true;
		}
		return false;
	}
}
