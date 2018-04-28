package proyecto;

public class Mapa {

	static int[][][] mapas = new int[5][18][18];
	
	public Mapa(int nummapa){
		
		switch(nummapa) {
		case 0:
			for(int i=0; i<18; i++) {
				for(int j=0; j<18; j++) {
					mapas[0][i][j]=28;
				}
			}
			
			for(int i=0; i<18; i++) {
				for(int j=0; j<18; j++) {
					if(i==0||i==1||i==2||i==16||i==15||i==17||j==0||j==1||j==17||j==15||j==2||j==16) {
						mapas[0][i][j]=7;
					} else {
						if((i==8||i==7||i==6)) {
							mapas[0][i][j]=2;
						} else {
							mapas[0][i][j]=28;
						}	
					}
				}
			}
			
			
			mapas[0][4][7]=5;
			mapas[0][4][8]=6;
			mapas[0][6][4]=28; mapas[0][6][3]=28; mapas[0][6][13]=28; mapas[0][6][14]=28;
			mapas[0][7][4]=28; mapas[0][7][3]=28; mapas[0][7][13]=28; mapas[0][7][14]=28;
			mapas[0][8][4]=28; mapas[0][8][3]=28; mapas[0][8][13]=28; mapas[0][8][14]=28;
			mapas[0][12][6]=11; mapas[0][12][7]=11; mapas[0][12][8]=11; mapas[0][12][9]=11; mapas[0][12][10]=11; mapas[0][12][11]=11;
			
			mapas[0][5][15]=4;
			mapas[0][6][15]=4;
			
			break;
		case 1:
			
			for(int i=0; i<18; i++) {
				for(int j=0; j<18; j++) {
					mapas[1][i][j]=28;
					if((i==4||i==5)&&j<15&&j>4) {
						mapas[1][i][j]=2;
					}else {
						mapas[1][i][j]=7;
					}
				}
			}
			
			mapas[1][4][5]=28;
			mapas[1][4][4]=28;
			mapas[1][4][3]=28;
			mapas[1][5][5]=28;
			mapas[1][5][4]=28;
			mapas[1][5][3]=28;
			
			mapas[1][4][2]=4;
			mapas[1][5][2]=4;
			
			mapas[1][4][14]=4;
			mapas[1][5][14]=4;
			
			
			
			
			break;
		case 2:
			
			for(int i=0; i<18; i++) {
				for(int j=0; j<18; j++) {
					mapas[2][i][j]=28;
					
					if(i==0||i==1||i==2||i==17||i==16||i==15||j==0||j==1||j==2||j==16||j==15||j==17) {
						mapas[2][i][j]=7;
					}
					
				}
			}
			
			break;
		}
		
	}
	
	public int[][] craermapa(int posi, int posj, int nummapa){
		
		int[][] mapamov = new int[7][7];
		
		mapamov[0][0]=mapas[nummapa][posi-3][posj-3]; mapamov[0][1]=mapas[nummapa][posi-3][posj-2]; mapamov[0][2]=mapas[nummapa][posi-3][posj-1]; mapamov[0][3]=mapas[nummapa][posi-3][posj]; mapamov[0][4]=mapas[nummapa][posi-3][posj+1]; mapamov[0][5]=mapas[nummapa][posi-3][posj+2]; mapamov[0][6]=mapas[nummapa][posi-3][posj+3];
		mapamov[1][0]=mapas[nummapa][posi-2][posj-3]; mapamov[1][1]=mapas[nummapa][posi-2][posj-2]; mapamov[1][2]=mapas[nummapa][posi-2][posj-1]; mapamov[1][3]=mapas[nummapa][posi-2][posj]; mapamov[1][4]=mapas[nummapa][posi-2][posj+1]; mapamov[1][5]=mapas[nummapa][posi-2][posj+2]; mapamov[1][6]=mapas[nummapa][posi-2][posj+3]; 
		mapamov[2][0]=mapas[nummapa][posi-1][posj-3]; mapamov[2][1]=mapas[nummapa][posi-1][posj-2]; mapamov[2][2]=mapas[nummapa][posi-1][posj-1]; mapamov[2][3]=mapas[nummapa][posi-1][posj]; mapamov[2][4]=mapas[nummapa][posi-1][posj+1]; mapamov[2][5]=mapas[nummapa][posi-1][posj+2]; mapamov[2][6]=mapas[nummapa][posi-1][posj+3];
		mapamov[3][0]=mapas[nummapa][posi][posj-3]; mapamov[3][1]=mapas[nummapa][posi][posj-2]; mapamov[3][2]=mapas[nummapa][posi][posj-1]; mapamov[3][3]=mapas[nummapa][posi][posj]; mapamov[3][4]=mapas[nummapa][posi][posj+1]; mapamov[3][5]=mapas[nummapa][posi][posj+2]; mapamov[3][6]=mapas[nummapa][posi][posj+3]; 
		mapamov[4][0]=mapas[nummapa][posi+1][posj-3]; mapamov[4][1]=mapas[nummapa][posi+1][posj-2]; mapamov[4][2]=mapas[nummapa][posi+1][posj-1]; mapamov[4][3]=mapas[nummapa][posi+1][posj]; mapamov[4][4]=mapas[nummapa][posi+1][posj+1]; mapamov[4][5]=mapas[nummapa][posi+1][posj+2]; mapamov[4][6]=mapas[nummapa][posi+1][posj+3];
		mapamov[5][0]=mapas[nummapa][posi+2][posj-3]; mapamov[5][1]=mapas[nummapa][posi+2][posj-2]; mapamov[5][2]=mapas[nummapa][posi+2][posj-1]; mapamov[5][3]=mapas[nummapa][posi+2][posj]; mapamov[5][4]=mapas[nummapa][posi+2][posj+1]; mapamov[5][5]=mapas[nummapa][posi+2][posj+2]; mapamov[5][6]=mapas[nummapa][posi+2][posj+3];
		mapamov[6][0]=mapas[nummapa][posi+3][posj-3]; mapamov[6][1]=mapas[nummapa][posi+3][posj-2]; mapamov[6][2]=mapas[nummapa][posi+3][posj-1]; mapamov[6][3]=mapas[nummapa][posi+3][posj]; mapamov[6][4]=mapas[nummapa][posi+3][posj+1]; mapamov[6][5]=mapas[nummapa][posi+3][posj+2]; mapamov[6][6]=mapas[nummapa][posi+3][posj+3];
		
		return mapamov;
		
	}
	
	public String mostrarmapa(int[][] mapamov) {
		
		String mapamovv="";
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				mapamovv = mapamovv + mapamov[i][j];
			}
		}
		
		return mapamovv;
		
	}

	public void cambiomapa(int num) {
		
		
		
	}
	

	
}
