package com.chuxuezhe.shape;

import java.awt.Graphics;

import com.chuxuezhe.test.MyCanvas;

public class BaseShape {
	

	private int[][] gamegrap = new int[34][20];
	private int dalei;
	private int xiaolei=1;
	private Point[] location = new Point[4];
	private MyCanvas canvas;
	private Graphics g;
	
    public void lieZengSort(){

		for(int i=0;i<4;i++){
			for(int j=i+1;j<4;j++){
				if(location[i].getN()>location[j].getN()){
					Point p = new Point(0,0);
					p=location[j];
					location[j]=location[i];
					location[i]=p;
				}
			}
		}
		
		
		
	} 
	
	public void lieJianSort(){
		for(int i=0;i<4;i++){
			for(int j=i+1;j<4;j++){
				if(location[i].getN()<location[j].getN()){
					Point p = new Point(0,0);
					p=location[j];
					location[j]=location[i];
					location[i]=p;
				}
			}
		}
	}
	
	public BaseShape(int dalei,int xiaolei,MyCanvas canvas,Graphics g) {
		this.dalei = dalei;
		this.xiaolei=xiaolei;
		this.canvas = canvas;
		this.g=g;
		this.gamegrap = canvas.getGamegrap();	
		location =this.initLocation();
		this.createShape();
	}

	public int[][] getgamegrap(){
		return gamegrap;
	}

	public Point[] initLocation(){
		if(dalei==1){
			location[0]=new Point(0,8);
			location[1]=new Point(0,9);
			location[2]=new Point(0,10);
			location[3]=new Point(0,11);

		}
		if(dalei==2){
			location[0]=new Point(0,8);
			location[1]=new Point(0,9);
			location[2]=new Point(1,8);
			location[3]=new Point(1,9);

		}
		if(dalei==3){
			location[0]=new Point(0,10);
			location[1]=new Point(1,8);
			location[2]=new Point(1,9);
			location[3]=new Point(1,10);

		}
		if(dalei==4){
			location[0]=new Point(0,9);
			location[1]=new Point(1,8);
			location[2]=new Point(1,9);
			location[3]=new Point(1,10);

		}
		if(dalei==5){
			location[0]=new Point(0,8);
			location[1]=new Point(1,8);
			location[2]=new Point(1,9);
			location[3]=new Point(1,10);


		}
		if(dalei==6){
			location[0]=new Point(0,8);
			location[1]=new Point(0,9);
			location[2]=new Point(1,9);
			location[3]=new Point(1,10);


		}
		if(dalei==7){
			location[0]=new Point(0,9);
			location[1]=new Point(0,10);
			location[2]=new Point(1,8);
			location[3]=new Point(1,9);

		}
		return location;
	}

	public void createShape(){

		if(dalei==1){
			gamegrap[0][8] = 1;
			gamegrap[0][9] = 1;
			gamegrap[0][10] = 1;
			gamegrap[0][11] = 1;		
		}

		if(dalei==2){
			gamegrap[0][8] = 2;
			gamegrap[0][9] = 2;
			gamegrap[1][8] = 2;
			gamegrap[1][9] = 2;


		}

		if(dalei==3){
			gamegrap[0][10] = 3;
			gamegrap[1][8] = 3;
			gamegrap[1][9] = 3;
			gamegrap[1][10] = 3;


		}

		if(dalei==4){
			gamegrap[0][9] = 4;
			gamegrap[1][8] = 4;
			gamegrap[1][9] = 4;
			gamegrap[1][10] = 4;


		}

		if(dalei==5){
			gamegrap[0][8] = 5;
			gamegrap[1][8] = 5;
			gamegrap[1][9] = 5;
			gamegrap[1][10] = 5;


		}

		if(dalei==6){
			gamegrap[0][8] = 6;
			gamegrap[0][9] = 6;
			gamegrap[1][9] = 6;
			gamegrap[1][10] = 6;


		}

		if(dalei==7){
			gamegrap[0][9] = 7;
			gamegrap[0][10] = 7;
			gamegrap[1][8] = 7;
			gamegrap[1][9] = 7;


		}

		canvas.paint(g);



	}

	public void fallDown(){
		int[] memory = {5,5,5,5};
		Boolean[] flagPerRe={null,null,null,null};

		Boolean flagRe = null;
		Boolean flagDown=null ;
		Boolean[] flag={null,null,null,null} ;
		while(true){
			for(int i=0;i<4;i++){
				for(int j=i-1;j>=0;j--){
					if(location[i].getM()+1==location[j].getM()&&location[i].getN()==location[j].getN()){
						flagPerRe[j]=false;


						memory[i]=j;
					}else{
						flagPerRe[j]=true;
					}

				}

				for(int j=i+1;j<4;j++){
					if(location[i].getM()+1==location[j].getM()&&location[i].getN()==location[j].getN()){
						flagPerRe[j]=false;
						memory[i]=j;

					}else{
						flagPerRe[j]=true;
					}
				}


				location[i].setM(location[i].getM()+1);


				for(int j=0;j<4;j++){
					if(flagPerRe[j]==null){
						flagPerRe[j]=true;
					}
				}
				flagRe = flagPerRe[0]&&flagPerRe[1]&&flagPerRe[2]&&flagPerRe[3];
				if(flagRe){
					if(gamegrap[location[i].getM()][location[i].getN()]==0){

						flag[i]=true;
					}else{
						flag[i]=false;

					}
				}else{
					flag[i]=true;
					System.out.println("执行continue");
					
					continue;

				}

			}
			
			for(int i=0;i<4;i++){
				if(flag[i]==null){
					flag[i]=false;
				}
			}
			System.out.println(flag[0]+"|"+flag[1]+"|"+flag[2]+"|"+flag[3]);
			if(flag[0]&&flag[1]&&flag[2]&&flag[3]){
				flagDown = true;
			}else{
				System.out.println("执行break");
				break;
			}
			if(flagDown==true){

				for(int i=0;i<4;i++){
					if(memory[i]==5){
						gamegrap[location[i].getM()][location[i].getN()]=gamegrap[location[i].getM()-1][location[i].getN()];
						gamegrap[location[i].getM()-1][location[i].getN()]=0;
					}
				}
				for(int i=0;i<4;i++){
					if(memory[i]!=5){
						gamegrap[location[memory[i]].getM()-1][location[i].getN()]=gamegrap[location[i].getM()-1][location[i].getN()];
						gamegrap[location[i].getM()-1][location[i].getN()]=0;
					}
				}




			}

			canvas.paint(g);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}




	}

	public void hangJianSort(){
		for(int i=0;i<4;i++){
			for(int j=i+1;j<4;j++){
				if(location[i].getM()<location[j].getM()){
					Point p = new Point(0,0);
					p=location[j];
					location[j]=location[i];
					location[i]=p;
				}
			}
		}
		
		
	}
	public void hangZengSort(){
		for(int i=0;i<4;i++){
			for(int j=i+1;j<4;j++){
				if(location[i].getM()>location[j].getM()){
					Point p = new Point(0,0);
					p=location[j];
					location[j]=location[i];
					location[i]=p;
				}
			}
		}
		
		
	}
	
    public void moveLeft(){
		Boolean flag[] = {null,null,null,null};
		Boolean flagRe[] = {null,null,null,null};
		Boolean flagperRe[][] = new Boolean[4][4];
		Boolean flagLeft;
		lieZengSort();
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				flagperRe[i][j]=null;
			}
		}
		
		for(int i=0;i<4;i++){
			for(int j=i-1;j>=0;j--){
				if(location[i].getM()==location[j].getM()&&location[i].getN()-1==location[j].getN()){
					flagperRe[i][j]=true;
				}else{
					flagperRe[i][j]=false;
				}
			}
			for(int j=i+1;j<4;j++){
				if(location[i].getM()==location[j].getM()&&location[i].getN()-1==location[j].getN()){
					flagperRe[i][j]=true;
				}else{
					flagperRe[i][j]=false;
				}
			}
		}
		
		for(int i=0;i<4;i++){
			if(!(location[i].getN()-1>0)){
				return;
			}
		}
		
		for(int i=0;i<4;i++){
			flagperRe[i][i]=false;	
		}
		
		for(int i=0;i<4;i++){
			
			flagRe[i]=!(flagperRe[i][0]||flagperRe[i][1]||flagperRe[i][2]||flagperRe[i][3]);
			
			if(flagRe[i]){
				if(gamegrap[location[i].getM()][location[i].getN()-1]==0){
					flag[i]=true;
				}else{
					flag[i]=false;
					
					return;
					
				}
			}
		}
		for(int i=0;i<4;i++){
			if(flag[i]==null){
				flag[i]=true;
			}
		}
		flagLeft = flag[0]&&flag[1]&&flag[2]&&flag[3];
		
		if(flagLeft){
			
		
			
			
			for(int i=0;i<4;i++){
				    
				    
				
					gamegrap[location[i].getM()][location[i].getN()-1]=gamegrap[location[i].getM()][location[i].getN()];
					gamegrap[location[i].getM()][location[i].getN()]=0;
					
					
				
			}
		}
		
		for(int i=0;i<4;i++){
			
				location[i].setN(location[i].getN()-1);
			
		}
		
		canvas.paint(g);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		


	}

	public void moveRight(){
		Boolean flag[] = {null,null,null,null};
		Boolean flagRe[] = {null,null,null,null};
		Boolean flagperRe[][] = new Boolean[4][4];
		Boolean flagLeft;
		lieJianSort();
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				flagperRe[i][j]=null;
			}
		}
		
		for(int i=0;i<4;i++){
			for(int j=i-1;j>=0;j--){
				if(location[i].getM()==location[j].getM()&&location[i].getN()+1==location[j].getN()){
					flagperRe[i][j]=true;
				}else{
					flagperRe[i][j]=false;
				}
			}
			for(int j=i+1;j<4;j++){
				if(location[i].getM()==location[j].getM()&&location[i].getN()+1==location[j].getN()){
					flagperRe[i][j]=true;
				}else{
					flagperRe[i][j]=false;
				}
			}
		}
		
		for(int i=0;i<4;i++){
			if(!(location[i].getN()+1<19)){
			
				return;
			}
			
		}
		
		for(int i=0;i<4;i++){
			flagperRe[i][i]=false;	
		}
		
		for(int i=0;i<4;i++){
			
			flagRe[i]=!(flagperRe[i][0]||flagperRe[i][1]||flagperRe[i][2]||flagperRe[i][3]);
		
			if(flagRe[i]){
				if(gamegrap[location[i].getM()][location[i].getN()+1]==0){
					flag[i]=true;
				}else{
					flag[i]=false;
					
					return;
					
				}
			}
		}
		for(int i=0;i<4;i++){
			if(flag[i]==null){
				flag[i]=true;
			}
		}
		flagLeft = flag[0]&&flag[1]&&flag[2]&&flag[3];
		
		if(flagLeft){
			for(int i=0;i<4;i++){
				
					gamegrap[location[i].getM()][location[i].getN()+1]=gamegrap[location[i].getM()][location[i].getN()];
					gamegrap[location[i].getM()][location[i].getN()]=0;
					
					
				
			}
		}
		
		for(int i=0;i<4;i++){
			
				location[i].setN(location[i].getN()+1);
			
			
		}
		
		canvas.paint(g);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		


	}

    public void moveDown(){
    	Boolean flag[] = {null,null,null,null};
		Boolean flagRe[] = {null,null,null,null};
		Boolean flagperRe[][] = new Boolean[4][4];
		Boolean flagDown;
		hangJianSort();
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				flagperRe[i][j]=null;
			}
		}
		
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(i==j){
					flagperRe[i][i]=false;
				}
				if(location[i].getM()+1==location[j].getM()&&location[i].getN()==location[j].getN()){
					flagperRe[i][j]=true;
				}else{
					flagperRe[i][j]=false;
				}
			}
//			for(int j=i-1;j>=0;j--){
//				if(location[i].getM()+1==location[j].getM()&&location[i].getN()==location[j].getN()){
//					flagperRe[i][j]=true;
//				}else{
//					flagperRe[i][j]=false;
//				}
//			}
//			for(int j=i+1;j<4;j++){
//				if(location[i].getM()+1==location[j].getM()&&location[i].getN()==location[j].getN()){
//					flagperRe[i][j]=true;
//				}else{
//					flagperRe[i][j]=false;
//				}
//			}
		}
		
		for(int i=0;i<4;i++){
			if(!(location[i].getM()+1<33)){
				return;
			}
		}
		
//		for(int i=0;i<4;i++){
//			flagperRe[i][i]=false;	
//		}
		
		for(int i=0;i<4;i++){
			
			flagRe[i]=!(flagperRe[i][0]||flagperRe[i][1]||flagperRe[i][2]||flagperRe[i][3]);
			
			if(flagRe[i]){
				if(gamegrap[location[i].getM()+1][location[i].getN()]==0){
					flag[i]=true;
				}else{
					flag[i]=false;
					
					return;
					
				}
			}
		}
		for(int i=0;i<4;i++){
			if(flag[i]==null){
				flag[i]=true;
			}
		}
//		System.out.println(flag[0]+"|"+flag[1]+"|"+flag[2]+"|"+flag[3]);
		flagDown = flag[0]&&flag[1]&&flag[2]&&flag[3];
		
		if(flagDown){
			
			
			for(int i=0;i<4;i++){
				
				
					gamegrap[location[i].getM()+1][location[i].getN()]=gamegrap[location[i].getM()][location[i].getN()];
					gamegrap[location[i].getM()][location[i].getN()]=0;
					
					
				
			}
		}
		
		
		
		for(int i=0;i<4;i++){
			location[i].setM(location[i].getM()+1);
		}
		canvas.paint(g);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
    }

    public void changeStyle(){
    	if(dalei==1){
    		if(xiaolei==1){
    			System.out.println("变换前:"+11);
    			xiaolei=2;
    			System.out.println("变换后:"+12);
    			lieZengSort();
    			if(location[0].getM()+3<33){
    				if(gamegrap[location[0].getM()+1][location[0].getN()]==0&&gamegrap[location[0].getM()+2][location[0].getN()]==0&&gamegrap[location[0].getM()+3][location[0].getN()]==0){
    					for(int i=1;i<4;i++){
    						gamegrap[location[0].getM()+i][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
        				    gamegrap[location[i].getM()][location[i].getN()]=0;
        				    location[i].setM(location[0].getM()+i);
        				    location[i].setN(location[0].getN());
        				    
    					}
    					return;
    				}
    				else{
    					return;
    				}
    			}else{
    				return;
    			}
    			
    		}
    		if(xiaolei==2){
    			System.out.println("变换前:"+12);
    			xiaolei=1;
    			System.out.println("变换后:"+11);
    			hangZengSort();
    			if(location[0].getN()+3<19){
    				if(gamegrap[location[0].getM()][location[0].getN()+1]==0&&gamegrap[location[0].getM()][location[0].getN()+2]==0&&gamegrap[location[0].getM()][location[0].getN()+3]==0){
    					for(int i=1;i<4;i++){
    						gamegrap[location[0].getM()][location[0].getN()+i]=gamegrap[location[0].getM()][location[0].getN()];
        				    gamegrap[location[i].getM()][location[i].getN()]=0;
        				    location[i].setM(location[0].getM());
        				    location[i].setN(location[0].getN()+i);
        				    
    					}
    					return;
        			}else{
        				return;
        			}
    			}else{
    				return;
    			}
    			
    			
    		}
    		
    	}
    	if(dalei==2){
    		
			return;
    	}
    	if(dalei==3){
    		if(xiaolei==1){
    			System.out.println("变换前:"+31);
    			xiaolei=2;
    			System.out.println("变换后:"+32);
    			lieZengSort();
    			if(location[0].getM()+1<33){
    				if(gamegrap[location[0].getM()-1][location[0].getN()]==0&&gamegrap[location[0].getM()+1][location[0].getN()]==0&&gamegrap[location[0].getM()+1][location[0].getN()+1]==0){
    					gamegrap[location[0].getM()-1][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+1][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+1][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					for(int i=1;i<4;i++){
    						gamegrap[location[i].getM()][location[i].getN()]=0;
    					}
    					location[1].setM(location[0].getM()-1);
    				    location[1].setN(location[0].getN());
    				    location[2].setM(location[0].getM()+1);
    				    location[2].setN(location[0].getN());
    				    location[3].setM(location[0].getM()+1);
    				    location[3].setN(location[0].getN()+1);
    					return;
    				}else{
    					return;
    				}
    			}else{
    				return;
    			}
    			
    			
    		}
    		if(xiaolei==2){
    			System.out.println("变换前:"+32);
    			xiaolei=3;
    			System.out.println("变换后:"+33);
    			hangZengSort();
    			if(location[0].getN()+2<19){
    				if(gamegrap[location[0].getM()][location[0].getN()+1]==0&&gamegrap[location[0].getM()][location[0].getN()+2]==0){
    					for(int i=1;i<4;i++){
    						gamegrap[location[i].getM()][location[i].getN()]=0;
    					}
    					gamegrap[location[0].getM()][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()][location[0].getN()+2]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+1][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
    					location[1].setM(location[0].getM());
    				    location[1].setN(location[0].getN()+1);
    				    location[2].setM(location[0].getM());
    				    location[2].setN(location[0].getN()+2);
    				    location[3].setM(location[0].getM()+1);
    				    location[3].setN(location[0].getN());
    					return;
    				}else{
    					return;
    				}
    			}else{
    				return;
    			}
    		}
    		if(xiaolei==3){
    			System.out.println("变换前:"+33);
    			xiaolei=4;
    			System.out.println("变换后:"+34);
    			lieJianSort();
    			if(location[0].getM()+2<33){
    				for(int i=1;i<4;i++){
						gamegrap[location[i].getM()][location[i].getN()]=0;
					}
    				System.out.println("("+location[0].getM()+","+location[0].getN()+")");
    				if(gamegrap[location[0].getM()+1][location[0].getN()-1]==0&&gamegrap[location[0].getM()+2][location[0].getN()-1]==0){
    					gamegrap[location[0].getM()][location[0].getN()-1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()][location[0].getN()-2]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+1][location[0].getN()-1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+2][location[0].getN()-1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()][location[0].getN()]=0;
    					for(int i=0;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    					
    					location[1].setM(location[0].getM());
    				    location[1].setN(location[0].getN()-2);
    				    location[2].setM(location[0].getM()+1);
    				    location[2].setN(location[0].getN()-1);
    				    location[3].setM(location[0].getM()+2);
    				    location[3].setN(location[0].getN()-1);
    				    location[0].setM(location[0].getM());
    				    location[0].setN(location[0].getN()-1);
    				    System.out.println(123);
    				    for(int i=0;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    				    return;
    				}else{
    					return;
    				}
    			}else{
    				return;
    			}
    			
    		}
    		if(xiaolei==4){
    			System.out.println("变换前:"+34);
    			xiaolei=1;
    			System.out.println("变换后:"+31);
    			hangJianSort();
    			if(location[0].getN()+1<19){
    				for(int i=1;i<4;i++){
						gamegrap[location[i].getM()][location[i].getN()]=0;
					}
    				System.out.println("("+location[0].getM()+","+location[0].getN()+")");
    				if(gamegrap[location[0].getM()-1][location[0].getN()-1]==0&&gamegrap[location[0].getM()-1][location[0].getN()+1]==0&&gamegrap[location[0].getM()-2][location[0].getN()+1]==0){
    					gamegrap[location[0].getM()-1][location[0].getN()-1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()-1][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()-1][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()-2][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()][location[0].getN()]=0;
    					for(int i=0;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    					
    					location[1].setM(location[0].getM()-1);
    				    location[1].setN(location[0].getN()-1);
    				    location[2].setM(location[0].getM()-1);
    				    location[2].setN(location[0].getN()+1);
    				    location[3].setM(location[0].getM()-1);
    				    location[3].setN(location[0].getN());
    				    location[0].setM(location[0].getM()-2);
    				    location[0].setN(location[0].getN()+1);
    				    System.out.println(123);
    				    for(int i=0;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    				    return;
    				}else{
    					return;
    				}
    			}else{
    				return;
    			}
    			
    			
    		}
    	}
    	if(dalei==4){
    		if(xiaolei==1){
    			System.out.println("变换前:"+41);
    			xiaolei=2;
    			System.out.println("变换后:"+42);
    			lieZengSort();
    			if(location[0].getM()+1<33){
    				for(int i=1;i<4;i++){
						gamegrap[location[i].getM()][location[i].getN()]=0;
					}
    				System.out.println("("+location[0].getM()+","+location[0].getN()+")");
    				if(gamegrap[location[0].getM()-1][location[0].getN()]==0&&gamegrap[location[0].getM()+1][location[0].getN()]==0){
    					gamegrap[location[0].getM()-1][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+1][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					for(int i=1;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    					
    					location[1].setM(location[0].getM()-1);
    				    location[1].setN(location[0].getN());
    				    location[2].setM(location[0].getM()+1);
    				    location[2].setN(location[0].getN());
    				    location[3].setM(location[0].getM());
    				    location[3].setN(location[0].getN()+1);
    				    System.out.println(123);
    				    for(int i=0;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    				    return;
    				}else{
    					return;
    				}
    			}else{
    				return;
    			}
    			
    			
    		}
    		if(xiaolei==2){
    			System.out.println("变换前:"+42);
    			xiaolei=3;
    			System.out.println("变换后:"+43);
    			hangZengSort();
    			if(location[0].getN()+2<19){
    				for(int i=1;i<4;i++){
						gamegrap[location[i].getM()][location[i].getN()]=0;
					}
    				System.out.println("("+location[0].getM()+","+location[0].getN()+")");
    				if(gamegrap[location[0].getM()][location[0].getN()+1]==0&&gamegrap[location[0].getM()][location[0].getN()+2]==0){
    					gamegrap[location[0].getM()][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()][location[0].getN()+2]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+1][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					for(int i=1;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    					
    					location[1].setM(location[0].getM());
    				    location[1].setN(location[0].getN()+1);
    				    location[2].setM(location[0].getM());
    				    location[2].setN(location[0].getN()+2);
    				    location[3].setM(location[0].getM()+1);
    				    location[3].setN(location[0].getN()+1);
    				    System.out.println(123);
    				    for(int i=0;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    				    return;
    				}else{
    					return;
    				}
    			}else{
    				return;
    			}
    			

    		}
    		if(xiaolei==3){
    			System.out.println("变换前:"+43);
    			xiaolei=4;
    			System.out.println("变换后:"+44);
    			hangJianSort();
    			if(location[0].getM()+1<33){
    				for(int i=1;i<4;i++){
						gamegrap[location[i].getM()][location[i].getN()]=0;
					}
    				System.out.println("("+location[0].getM()+","+location[0].getN()+")");
    				if(gamegrap[location[0].getM()][location[0].getN()-1]==0&&gamegrap[location[0].getM()+1][location[0].getN()]==0){
    					gamegrap[location[0].getM()][location[0].getN()-1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+1][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()-1][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
    					for(int i=1;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    					
    					location[1].setM(location[0].getM());
    				    location[1].setN(location[0].getN()-1);
    				    location[2].setM(location[0].getM()-1);
    				    location[2].setN(location[0].getN());
    				    location[3].setM(location[0].getM()+1);
    				    location[3].setN(location[0].getN());
    				    System.out.println(123);
    				    for(int i=0;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    				    return;
    				}else{
    					return;
    				}
    			}else{
    				return;
    			}
    			
    			

    		}
    		if(xiaolei==4){
    			System.out.println("变换前:"+44);
    			xiaolei=1;
    			System.out.println("变换后:"+41);
    			lieZengSort();
    			if(location[0].getN()+2<19){
    				for(int i=1;i<4;i++){
						gamegrap[location[i].getM()][location[i].getN()]=0;
					}
    				System.out.println("("+location[0].getM()+","+location[0].getN()+")");
    				if(gamegrap[location[0].getM()][location[0].getN()+2]==0){
    					gamegrap[location[0].getM()][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()][location[0].getN()+2]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()-1][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					for(int i=1;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    					
    					location[1].setM(location[0].getM());
    				    location[1].setN(location[0].getN()+1);
    				    location[2].setM(location[0].getM());
    				    location[2].setN(location[0].getN()+2);
    				    location[3].setM(location[0].getM()-1);
    				    location[3].setN(location[0].getN()+1);
    				    System.out.println(123);
    				    for(int i=0;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    				    return;
    				}else{
    					return;
    				}
    			}else{
    				return;
    			}
    			
    			
    			

    		}
    		
    	}
    	if(dalei==5){
    		if(xiaolei==1){
    			System.out.println("变换前:"+51);
    			xiaolei=2;
    			System.out.println("变换后:"+52);
    			hangZengSort();
    			if(location[0].getM()+2<33){
    				for(int i=1;i<4;i++){
						gamegrap[location[i].getM()][location[i].getN()]=0;
					}
    				System.out.println("("+location[0].getM()+","+location[0].getN()+")");
    				if(gamegrap[location[0].getM()][location[0].getN()+1]==0&&gamegrap[location[0].getM()+2][location[0].getN()]==0){
    					
    					gamegrap[location[0].getM()][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+1][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+2][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
    					
    					for(int i=1;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    					
    					location[1].setM(location[0].getM());
    				    location[1].setN(location[0].getN()+1);
    				    location[2].setM(location[0].getM()+1);
    				    location[2].setN(location[0].getN());
    				    location[3].setM(location[0].getM()+2);
    				    location[3].setN(location[0].getN());
    				    System.out.println(123);
    				    for(int i=0;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    				    return;
    				}else{
    					return;
    				}
    			}else{
    				return;
    			}
    			

    		}
    		if(xiaolei==2){
    			System.out.println("变换前:"+52);
    			xiaolei=3;
    			System.out.println("变换后:"+53);
    			lieJianSort();
    			if(location[0].getN()+1<19){
    				for(int i=1;i<4;i++){
						gamegrap[location[i].getM()][location[i].getN()]=0;
					}
    				System.out.println("("+location[0].getM()+","+location[0].getN()+")");
    				if(gamegrap[location[0].getM()][location[0].getN()+1]==0&&gamegrap[location[0].getM()+1][location[0].getN()+1]==0){
    					
    					gamegrap[location[0].getM()][location[0].getN()-1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+1][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					
    					for(int i=1;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    					
    					location[1].setM(location[0].getM());
    				    location[1].setN(location[0].getN()-1);
    				    location[2].setM(location[0].getM());
    				    location[2].setN(location[0].getN()+1);
    				    location[3].setM(location[0].getM()+1);
    				    location[3].setN(location[0].getN()+1);
    				    System.out.println(123);
    				    for(int i=0;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    				    return;
    				}else{
    					return;
    				}
    			}else{
    				return;
    			}
    			
    			

    		}
    		if(xiaolei==3){
    			System.out.println("变换前:"+53);
    			xiaolei=4;
    			System.out.println("变换后:"+54);
    			hangJianSort();
    			if(location[0].getM()+1<33){
    				for(int i=1;i<4;i++){
						gamegrap[location[i].getM()][location[i].getN()]=0;
					}
    				System.out.println("("+location[0].getM()+","+location[0].getN()+")");
    				if(gamegrap[location[0].getM()][location[0].getN()-1]==0&&gamegrap[location[0].getM()+1][location[0].getN()-1]==0&&gamegrap[location[0].getM()+1][location[0].getN()-2]==0){
    					
    					gamegrap[location[0].getM()][location[0].getN()-1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+1][location[0].getN()-1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+1][location[0].getN()-2]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()-1][location[0].getN()-1]=gamegrap[location[0].getM()][location[0].getN()];
    					
    					gamegrap[location[0].getM()][location[0].getN()]=0;
    					for(int i=1;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    					
    					location[1].setM(location[0].getM());
    				    location[1].setN(location[0].getN()-1);
    				    location[2].setM(location[0].getM()+1);
    				    location[2].setN(location[0].getN()-1);
    				    location[3].setM(location[0].getM()+1);
    				    location[3].setN(location[0].getN()-2);
    				    location[0].setM(location[0].getM()-1);
    				    location[0].setN(location[0].getN()-1);
    				    System.out.println(123);
    				    for(int i=0;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    				    return;
    				}else{
    					return;
    				}
    			}else{
    				return;
    			}
    			

    		}
    		if(xiaolei==4){
    			System.out.println("变换前:"+54);
    			xiaolei=1;
    			System.out.println("变换后:"+51);
    			lieZengSort();
    			if(location[0].getN()+2<19){
    				for(int i=1;i<4;i++){
						gamegrap[location[i].getM()][location[i].getN()]=0;
					}
    				System.out.println("("+location[0].getM()+","+location[0].getN()+")");
    				if(gamegrap[location[0].getM()-1][location[0].getN()]==0&&gamegrap[location[0].getM()-2][location[0].getN()]==0&&gamegrap[location[0].getM()-1][location[0].getN()+2]==0){
    					
    					gamegrap[location[0].getM()-1][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()-2][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()-1][location[0].getN()+2]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()-1][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					
    					gamegrap[location[0].getM()][location[0].getN()]=0;
    					for(int i=1;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    					
    					location[1].setM(location[0].getM()-1);
    				    location[1].setN(location[0].getN());
    				    location[2].setM(location[0].getM()-2);
    				    location[2].setN(location[0].getN());
    				    location[3].setM(location[0].getM()-1);
    				    location[3].setN(location[0].getN()+2);
    				    location[0].setM(location[0].getM()-1);
    				    location[0].setN(location[0].getN()+1);
    				    System.out.println(123);
    				    for(int i=0;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    				    return;
    				}else{
    					return;
    				}
    			}else{
    				return;
    			}
    			

    		}
    		
    	}
    	if(dalei==6){
    		if(xiaolei==1){
    			System.out.println("变换前:"+61);
    			xiaolei=2;
    			System.out.println("变换后:"+62);
    			lieZengSort();
    			if(location[0].getM()+2<33){
    				for(int i=1;i<4;i++){
						gamegrap[location[i].getM()][location[i].getN()]=0;
					}
    				System.out.println("("+location[0].getM()+","+location[0].getN()+")");
    				if(gamegrap[location[0].getM()+1][location[0].getN()]==0&&gamegrap[location[0].getM()+2][location[0].getN()]==0){
    					
    					gamegrap[location[0].getM()+1][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+2][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+1][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					
    					gamegrap[location[0].getM()][location[0].getN()]=0;
    					for(int i=1;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    					
    					location[1].setM(location[0].getM()+1);
    				    location[1].setN(location[0].getN());
    				    location[2].setM(location[0].getM()+2);
    				    location[2].setN(location[0].getN());
    				    location[3].setM(location[0].getM()+1);
    				    location[3].setN(location[0].getN()+1);
    				    location[0].setM(location[0].getM());
    				    location[0].setN(location[0].getN()+1);
    				    System.out.println(123);
    				    for(int i=0;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    				    return;
    				}else{
    					return;
    				}
    			}else{
    				return;
    			}
    			

    		}
    		if(xiaolei==2){
    			System.out.println("变换前:"+62);
    			xiaolei=1;
    			System.out.println("变换后:"+61);
    			hangJianSort();
    			if(location[0].getN()+2<19){
    				for(int i=1;i<4;i++){
						gamegrap[location[i].getM()][location[i].getN()]=0;
					}
    				System.out.println("("+location[0].getM()+","+location[0].getN()+")");
    				if(gamegrap[location[0].getM()-2][location[0].getN()]==0&&gamegrap[location[0].getM()-1][location[0].getN()+2]==0){
    					
    					gamegrap[location[0].getM()-2][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()-1][location[0].getN()+2]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()-1][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()-2][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					
    					gamegrap[location[0].getM()][location[0].getN()]=0;
    					for(int i=1;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    					
    					location[1].setM(location[0].getM()-2);
    				    location[1].setN(location[0].getN());
    				    location[2].setM(location[0].getM()-1);
    				    location[2].setN(location[0].getN()+2);
    				    location[3].setM(location[0].getM()-1);
    				    location[3].setN(location[0].getN()+1);
    				    location[0].setM(location[0].getM()-2);
    				    location[0].setN(location[0].getN()+1);
    				    System.out.println(123);
    				    for(int i=0;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    				    return;
    				}else{
    					return;
    				}
    			}else{
    				return;
    			}
    			
    			

    		}
    		
    	}
    	if(dalei==7){
    		if(xiaolei==1){
    			System.out.println("变换前:"+71);
    			xiaolei=2;
    			System.out.println("变换后:"+72);
    			lieZengSort();
    			if(location[0].getM()+1<33){
    				for(int i=1;i<4;i++){
						gamegrap[location[i].getM()][location[i].getN()]=0;
					}
    				System.out.println("("+location[0].getM()+","+location[0].getN()+")");
    				if(gamegrap[location[0].getM()-1][location[0].getN()]==0&&gamegrap[location[0].getM()+1][location[0].getN()+1]==0&&gamegrap[location[0].getM()+1][location[0].getN()-2]==0){
    					
    					gamegrap[location[0].getM()-1][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+1][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					
    					
    					
    					for(int i=1;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    					
    					location[1].setM(location[0].getM()-1);
    				    location[1].setN(location[0].getN());
    				    location[2].setM(location[0].getM()+1);
    				    location[2].setN(location[0].getN()+1);
    				    location[3].setM(location[0].getM());
    				    location[3].setN(location[0].getN()+1);
    				    
    				    System.out.println(123);
    				    for(int i=0;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    				    return;
    				}else{
    					return;
    				}
    			}else{
    				return;
    			}
    			
    			

    		}
    		if(xiaolei==2){
    			System.out.println("变换前:"+72);
    			xiaolei=1;
    			System.out.println("变换后:"+71);
    			hangZengSort();
    			if(location[0].getN()+2<19){
    				for(int i=1;i<4;i++){
						gamegrap[location[i].getM()][location[i].getN()]=0;
					}
    				System.out.println("("+location[0].getM()+","+location[0].getN()+")");
    				if(gamegrap[location[0].getM()][location[0].getN()+1]==0&&gamegrap[location[0].getM()][location[0].getN()+2]==0){
    					
    					gamegrap[location[0].getM()][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()][location[0].getN()+2]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+1][location[0].getN()]=gamegrap[location[0].getM()][location[0].getN()];
    					gamegrap[location[0].getM()+1][location[0].getN()+1]=gamegrap[location[0].getM()][location[0].getN()];
    					
    					gamegrap[location[0].getM()][location[0].getN()]=0;
    					for(int i=1;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    					
    					location[1].setM(location[0].getM());
    				    location[1].setN(location[0].getN()+1);
    				    location[2].setM(location[0].getM());
    				    location[2].setN(location[0].getN()+2);
    				    location[3].setM(location[0].getM()+1);
    				    location[3].setN(location[0].getN());
    				    location[0].setM(location[0].getM()+1);
    				    location[0].setN(location[0].getN()+1);
    				    System.out.println(123);
    				    for(int i=0;i<4;i++){
    						System.out.println("("+location[i].getM()+","+location[i].getN()+")");
    					}
    				    return;
    				}else{
    					return;
    				}
    			}else{
    				return;
    			}
    			

    		}
    	}
    }
}
