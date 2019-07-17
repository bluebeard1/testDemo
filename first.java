import java.io.*;

public class first{
	public static void main(String[] args)throws Exception{
		System.out.println("欢迎游玩五子棋！");
		gobang go = new gobang();
		go.initialize();
		go.output();
		int i = 0;
		while(i==0){
			
			System.out.println("请输入x,y坐标值，用,隔开");
			go.playChess();
			go.output();
			i = go.ergodic();
		}
	}
}
class gobang{
	String[][] Checkerboard = new String[12][12];
	//棋盘的初始化方法
	public void initialize(){
		for(int i = 0; i< 12; i++){
			for(int j = 0; j< 12; j++){
				Checkerboard[i][j] = "十";
			}
		}
	}
	//打印棋盘
	public void output(){
		for(int i = 0; i< 12; i++){
			for(int j = 0; j< 12; j++){
				System.out.print(Checkerboard[i][j]);
			}
			System.out.println();
		}
	}
	//获取用户输入的坐标值
	public void playChess()throws Exception{
		String[] black = new String[2];
		while(true){
			BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
			String xy = rd.readLine();
			black = xy.split(",");
			int blackx = Integer.parseInt(black[0]);
			int blacky = Integer.parseInt(black[1]);
			if(Checkerboard[blackx][blacky] == "十"){
				Checkerboard[blackx][blacky] = "●";
				break;
			}
			else{
				System.out.println("该处以落子，请从新输入坐标值");
			}
		}
		while(true){
			int whitex = (int)(Math.random()*11);
			int whitey = (int)(Math.random()*11);
			if(Checkerboard[whitex][whitey] == "十"){
				Checkerboard[whitex][whitey] = "○";
				break;
			}
		}
	}
	//棋盘的遍历
	public int ergodic(){
		//遍历行
		int k = 1;
		for(int i=0;i<12;i++){
			
			for(int j=0;j<11;j++){
				if((Checkerboard[i][j] == Checkerboard[i][j+1])&&(Checkerboard[i][j]=="●"||Checkerboard[i][j]=="○")){
					k++;
					if(k==5){
						System.out.println("胜利");
						return 1;
					}
				}
				else{
					k=1;
					continue;
				}
			}
		}
		//遍历列
		for(int i=0;i<12;i++){
			for(int j=0;j<11;j++){
				if((Checkerboard[j][i] == Checkerboard[j+1][i])&&(Checkerboard[j][i]=="●"||Checkerboard[j][i]=="○")){
					k++;
					if(k==5){
						System.out.println("胜利");
						return 1;
					}
				}
				else{
					k=1;
					continue;
				}
			}
		}
		//遍历左斜线
		for(int i=0;i<11;i++){
			for(int j=0,x=i;j<11&&x<11;j++,x++){
				if((Checkerboard[x][j] == Checkerboard[x+1][j+1])&&(Checkerboard[x][j]=="●"||Checkerboard[x][j]=="○")){
					k++;
					if(k==5){
						System.out.println("胜利");
						return 1;
					}
				}
				else{
					k=1;
					continue;
				}
			}
			for(int j=0,x=i;j<11&&x<11;j++,x++){
				if((Checkerboard[j][x] == Checkerboard[j+1][x+1])&&(Checkerboard[j][x]=="●"||Checkerboard[x][j]=="○")){
					k++;
					if(k==5){
						System.out.println("胜利");
						return 1;
					}
				}
				else{
					k=1;
					continue;
				}
			}
		}
		//遍历右斜线
		int z=0;
		for(int i=11;i>0;i--){
			for(int j=0,x=i;j<11&&x>0;j++,x--){
				if((Checkerboard[x][j] == Checkerboard[x-1][j+1])&&(Checkerboard[x][j]=="●"||Checkerboard[x][j]=="○")){
					k++;
					if(k==5){
						System.out.println("胜利");
						return 1;
					}
				}
				else{
					k=1;
					continue;
				}
			}
			for(int j=z,x=11;j<11&&x>0;j++,x--){
				if((Checkerboard[x][j] == Checkerboard[x-1][j+1])&&(Checkerboard[j][x]=="●"||Checkerboard[x][j]=="○")){
					k++;
					if(k==5){
						System.out.println("胜利");
						return 1;
					}
				}
				else{
					k=1;
					continue;
				}
			}
			z+=1;
		}
		return 0;
	}
}