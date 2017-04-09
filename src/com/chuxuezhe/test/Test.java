package com.chuxuezhe.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;












import javax.swing.JButton;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;











import com.chuxuezhe.repaint.StorageShape;
import com.chuxuezhe.shape.BaseShape;


@SuppressWarnings("serial")
public class Test extends JFrame {
	private Graphics g ;
	private Boolean flag_Start=false;
	private ArrayList<StorageShape> list = new ArrayList<StorageShape>();
	private StorageShape storageshape;
	private MyCanvas canvas;
	private BaseShape baseshape;
	
	public Boolean getFlag_Start(){
		return flag_Start;
	}
	private JPanel jpGame = new JPanel(){
		public void paint(Graphics g) {
			super.paint(g);
			if(list.size()!=0){
				Iterator<StorageShape> ite = list.iterator();
				while(ite.hasNext()){
					storageshape = (StorageShape) ite.next();
					switch (storageshape.getType()) {
					case "line":
						g.setColor(storageshape.getColor());
						g.drawLine(storageshape.getdata(0), storageshape.getdata(1), storageshape.getdata(2), storageshape.getdata(3));

					case "circle":

					case "rectangle":

					}
				}	
			}
			
			if(canvas!=null){
				canvas.paint(g);
			}


		}
	};
	private JPanel jpSetting = new JPanel();
	
	private JButton jbuLeft = new JButton("Left");
	private JButton jbuRight = new JButton("Right");
	private JButton jbuDown = new JButton("Down");
	private JButton jbuChange = new JButton("Change");
	private JButton jbuPlay = new JButton("Play");
	private JLabel showScore = new JLabel("0");
	
	
	
	


	public static void main(String[] args) {
		Test test = new Test();
		test.CreateGameUI();
		test.Draw();
		test.play();
		


	}


	public void CreateGameUI(){
		this.setTitle("RussianRectange");
		this.setSize(600, 700);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);

		jpGame.setSize(new Dimension(420, 700));
		jpGame.setBackground(Color.black);
		jpGame.setPreferredSize(new Dimension(420,700));

		jpSetting.setSize(new Dimension(180,700));
		jpSetting.setBackground(Color.GRAY);
		jpSetting.setPreferredSize(new Dimension(180,700));

		this.add(jpGame,BorderLayout.CENTER);
		this.add(jpSetting,BorderLayout.EAST);
		
		
		jpSetting.add(jbuLeft);
		jpSetting.add(jbuRight);
		jpSetting.add(jbuDown);
		jpSetting.add(jbuChange);
		jpSetting.add(showScore);
		jpSetting.add(jbuPlay);
		
		ActionListener myActionListener = new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				if("Left".equals(e.getActionCommand())){
					baseshape.moveLeft();
				}
				if("Right".equals(e.getActionCommand())){
					baseshape.moveRight();
				}
				if("Down".equals(e.getActionCommand())){
					baseshape.moveDown();
				}
				if("Change".equals(e.getActionCommand())){
					baseshape.changeStyle();
				}
				if("Play".equals(e.getActionCommand())){
					
				}
				
			}
		};
		
		jbuLeft.addActionListener(myActionListener);
		jbuRight.addActionListener(myActionListener);
		jbuDown.addActionListener(myActionListener);
		jbuChange.addActionListener(myActionListener);
		jbuPlay.addActionListener(myActionListener);
		
		

		this.setDefaultCloseOperation(3);
		this.setVisible(true);


		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		g = jpGame.getGraphics();

	}

	public void Draw(){
		canvas = new MyCanvas();
		canvas.Init();
		g.setColor(Color.black);
		System.out.println(list);
		for(int i=0;i<=400;i+=20){
			g.drawLine(i, 0, i, 700);
			int[] data = {i,0,i,700,0,0,0,0,0,0};
			storageshape = new StorageShape("line",Color.black, data);
			list.add(storageshape);
		}
		for(int j=0;j<=700;j+=20){
			g.drawLine(0, j, 400, j);
			int[] data = {0,j,400,j,0,0,0,0,0,0};
			storageshape = new StorageShape("line", Color.black,data);
			list.add(storageshape);
		}	
	}

	public void play(){
		while(true){
			
			int score=0;
			int dalei = (int) (Math.random()*7+1);
			
			
			
			baseshape = new BaseShape(dalei,1, canvas,g); 

			for(int i=0;i<50;i++){

				baseshape.moveDown();
				
			}
			for(int i=0;i<32;i++){
				score =canvas.computeFreshen();
				
			}
			showScore.setText(Integer.toString(score));
			canvas.paint(g);
			if(canvas.isGameOver()){
				System.out.println(score);
				System.out.println("Game Over!");
				break;
			}
			
		
			
			
			
		
		

		
		}
		

		
	}

}
