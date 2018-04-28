package proyecto;

public class Tablatipos {

	private double[][] tabla = new double[18][18];
	
		public Tablatipos(){
		
		//la tabla esta creada como la original, las filas representan el tipo del atacante y las columnas del atacado, donde el valor
			// de las casillas es la efectividad del tipo del atacado y el tipo del ataque del atacante
				//0=Acero, 1=Agua, 2=Bicho, 3=Dragón, 4=Eléctrico, 5=Fantasma, 6=Fuego, 7=Hada, 8=Hielo
				//9=Lucha, 10=Normal, 11=Planta, 12=Psíquico, 13=Roca, 14=Siniestro, 15=Tierra, 16=Veneno, 17=Volador
			//ejemplo: tabla[0][1] es la efectividad de Acero contra Agua,
			
			
			//////////////////////////////////TIPO-DEFENSOR///////////////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//////////////////Acero Agua Bicho Dragón Eléctrico Fantasma Fuego Hada Hielo Lucha Normal Planta Písquico Roca Siniestro Tierra Veneno Volador///
			//TIPO-ATAQUE/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//	Acero     //////0.5  0.5  1     1      0.5      1        0.5    2    2    1      1     1      1        2     1          1     1      1		//
			//	Agua      //////1    0.5  1     0.5    1        1        2      1    1    1      1     0.5    1        2     1          2     1      1		//
			//	Bicho     //////0.5  1    1     1      1        0.5      0.5    0.5  1    0.5    1     2      2        1     2          1     0.5    0.5	//
			//	Dragón    //////0.5  1    1     2      1        1        1      0    1    1      1     1      1        1     1          1     1      1		//
			//	Eléctrico //////1    2    1     0.5    0.5      1        1      1    1    1      1     0.5    1        1     1          0     1      2		//
			//	Fantasma  //////1    1    1     1      1        2        1      1    1    1      0     1      2        1     0.5        1     1      1		//
			//	Fuego     //////2    0.5  2     0.5    1        1        0.5    1    2    1      1     2      1        0.5   1          1     1      1 		//
			//	Hada      //////0.5  1    1     2      1        1        0.5    1    1    2      1     1      1        1     2          1     0.5    1 		//
			//	Hielo     //////0.5  0.5  1     2      1        1        0.5    1    0.5  1      1     2      1        1     1          2     1      2 		//
			//	Lucha     //////2    1    0.5   1      1        0        1      0.5  2    1      2     1      0.5      2     2          1     0.5    0.5 	//
			//	Normal    //////0.5  1    1     1      1        0        1      1    1    1      1     1      1        0.5   1          1     1      1		//
			//	Planta    //////0.5  2    0.5   0.5    1        1        0.5    1    1    1      1     0.5    1        2     1          2     0.5    0.5 	//
			//	Psíquico  //////0.5  1    1     1      1        1        1      1    1    2      1     1      0.5      1     0          1     2      1 		//
			//	Roca      //////0.5  1    2     1      1        1        2      1    2    0.5    1     1      1        1     1          0.5   1      2 		//
			//	Siniestro //////1    1    1     1      1        2        1      0.5  1    0.5    1     1      2        1     0.5        1     1      1 		//
			//	Tierra    //////2    1    0.5   1      2        1        2      1    1    1      1     0.5    1        2     1          1     2      0 		//
			//	Veneno    //////0    1    1     1      1        0.5      1      2    1    1      1     2      1        0.5   1          0.5   0.5    1 		//
			//	Volador   //////0.5  1    2     1      0.5      1        1      1    1    2      1     2      1        0.5   1          1     1      1		//
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
			
		tabla[0][0]=0.5; tabla[0][1]=0.5; tabla[0][2]=1; tabla[0][3]=1; tabla[0][4]=0.5; tabla[0][5]=1; tabla[0][6]=0.5; tabla[0][7]=2; tabla[0][8]=2; tabla[0][9]=1; tabla[0][10]=1; tabla[0][11]=1; tabla[0][12]=1; tabla[0][13]=2; tabla[0][14]=1; tabla[0][15]=1; tabla[0][16]=1; tabla[0][17]=1;
		tabla[1][0]=1; tabla[1][1]=0.5; tabla[1][2]=1; tabla[1][3]=0.5; tabla[1][4]=1; tabla[1][5]=1; tabla[1][6]=2; tabla[1][7]=1; tabla[1][8]=1; tabla[1][9]=1; tabla[1][10]=1; tabla[1][11]=0.5; tabla[1][12]=1; tabla[1][13]=2; tabla[1][14]=1; tabla[1][15]=2; tabla[1][16]=1; tabla[1][17]=1; 
		tabla[2][0]=0.5; tabla[2][1]=1; tabla[2][2]=1; tabla[2][3]=1; tabla[2][4]=1; tabla[2][5]=0.5; tabla[2][6]=0.5; tabla[2][7]=0.5; tabla[2][8]=1; tabla[2][9]=0.5; tabla[2][10]=1; tabla[2][11]=2; tabla[2][12]=2; tabla[2][13]=1; tabla[2][14]=2; tabla[2][15]=1; tabla[2][16]=0.5; tabla[2][17]=0.5;
		tabla[3][0]=0.5; tabla[3][1]=1; tabla[3][2]=1; tabla[3][3]=2; tabla[3][4]=1; tabla[3][5]=1; tabla[3][6]=1; tabla[3][7]=0; tabla[3][8]=1; tabla[3][9]=1; tabla[3][10]=1; tabla[3][11]=1; tabla[3][12]=1; tabla[3][13]=1; tabla[3][14]=1; tabla[3][15]=1; tabla[3][16]=1; tabla[3][17]=1; 
		tabla[4][0]=1; tabla[4][1]=2; tabla[4][2]=1; tabla[4][3]=0.5; tabla[4][4]=0.5; tabla[4][5]=1; tabla[4][6]=1; tabla[4][7]=1; tabla[4][8]=1; tabla[4][9]=1; tabla[4][10]=1; tabla[4][11]=0.5; tabla[4][12]=1; tabla[4][13]=1; tabla[4][14]=1; tabla[4][15]=0; tabla[4][16]=1; tabla[4][17]=2; 
		tabla[5][0]=1; tabla[5][1]=1; tabla[5][2]=1; tabla[5][3]=1; tabla[5][4]=1; tabla[5][5]=2; tabla[5][6]=1; tabla[5][7]=1; tabla[5][8]=1; tabla[5][9]=1; tabla[5][10]=0; tabla[5][11]=1; tabla[5][12]=2; tabla[5][13]=1; tabla[5][14]=0.5; tabla[5][15]=1; tabla[5][16]=1; tabla[5][17]=1; 
		tabla[6][0]=2; tabla[6][1]=0.5; tabla[6][2]=2; tabla[6][3]=0.5; tabla[6][4]=1; tabla[6][5]=1; tabla[6][6]=0.5; tabla[6][7]=1; tabla[6][8]=2; tabla[6][9]=1; tabla[6][10]=1; tabla[6][11]=2; tabla[6][12]=1; tabla[6][13]=0.5; tabla[6][14]=1; tabla[6][15]=1; tabla[6][16]=1; tabla[6][17]=1; 
		tabla[7][0]=0.5; tabla[7][1]=1; tabla[7][2]=1; tabla[7][3]=2; tabla[7][4]=1; tabla[7][5]=1; tabla[7][6]=0.5; tabla[7][7]=1; tabla[7][8]=1; tabla[7][9]=2; tabla[7][10]=1; tabla[7][11]=1; tabla[7][12]=1; tabla[7][13]=1; tabla[7][14]=2; tabla[7][15]=1; tabla[7][16]=0.5; tabla[7][17]=1; 
		tabla[8][0]=0.5; tabla[8][1]=0.5; tabla[8][2]=1; tabla[8][3]=2; tabla[8][4]=1; tabla[8][5]=1; tabla[8][6]=0.5; tabla[8][7]=1; tabla[8][8]=0.5; tabla[8][9]=1; tabla[8][10]=1; tabla[8][11]=2; tabla[8][12]=1; tabla[8][13]=1; tabla[8][14]=1; tabla[8][15]=2; tabla[8][16]=1; tabla[8][17]=2; 
		tabla[9][0]=2; tabla[9][1]=1; tabla[9][2]=0.5; tabla[9][3]=1; tabla[9][4]=1; tabla[9][5]=0; tabla[9][6]=1; tabla[9][7]=0.5; tabla[9][8]=2; tabla[9][9]=1; tabla[9][10]=2; tabla[9][11]=1; tabla[9][12]=0.5; tabla[9][13]=2; tabla[9][14]=2; tabla[9][15]=1; tabla[9][16]=0.5; tabla[9][17]=0.5; 
		tabla[10][0]=0.5; tabla[10][1]=1; tabla[10][2]=1; tabla[10][3]=1; tabla[10][4]=1; tabla[10][5]=0; tabla[10][6]=1; tabla[10][7]=1; tabla[10][8]=1; tabla[10][9]=1; tabla[10][10]=1; tabla[10][11]=1; tabla[10][12]=1; tabla[10][13]=0.5; tabla[10][14]=1; tabla[10][15]=1; tabla[10][16]=1; tabla[10][17]=1;
		tabla[11][0]=0.5; tabla[11][1]=2; tabla[11][2]=0.5; tabla[11][3]=0.5; tabla[11][4]=1; tabla[11][5]=1; tabla[11][6]=0.5; tabla[11][7]=1; tabla[11][8]=1; tabla[11][9]=1; tabla[11][10]=1; tabla[11][11]=0.5; tabla[11][12]=1; tabla[11][13]=2; tabla[11][14]=1; tabla[11][15]=2; tabla[11][16]=0.5; tabla[11][17]=0.5;
		tabla[12][0]=1; tabla[12][1]=1; tabla[12][2]=1; tabla[12][3]=1; tabla[12][4]=1; tabla[12][5]=1; tabla[12][6]=1; tabla[12][7]=1; tabla[12][8]=1; tabla[12][9]=2; tabla[12][10]=1; tabla[12][11]=1; tabla[12][12]=0.5; tabla[12][13]=1; tabla[12][14]=0; tabla[12][15]=1; tabla[12][16]=2; tabla[12][17]=1; 
		tabla[13][0]=0.5; tabla[13][1]=1; tabla[13][2]=2; tabla[13][3]=1; tabla[13][4]=1; tabla[13][5]=1; tabla[13][6]=2; tabla[13][7]=1; tabla[13][8]=2; tabla[13][9]=0.5; tabla[13][10]=1; tabla[13][11]=1; tabla[13][12]=1; tabla[13][13]=1; tabla[13][14]=1; tabla[13][15]=0.5; tabla[13][16]=1; tabla[13][17]=2; 
		tabla[14][0]=1; tabla[14][1]=1; tabla[14][2]=1; tabla[14][3]=1; tabla[14][4]=1; tabla[14][5]=2; tabla[14][6]=1; tabla[14][7]=0.5; tabla[14][8]=1; tabla[14][9]=0.5; tabla[14][10]=1; tabla[14][11]=1; tabla[14][12]=2; tabla[14][13]=1; tabla[14][14]=0.5; tabla[14][15]=1; tabla[14][16]=1; tabla[14][17]=1; 
		tabla[15][0]=2; tabla[15][1]=1; tabla[15][2]=0.5; tabla[15][3]=1; tabla[15][4]=2; tabla[15][5]=1; tabla[15][6]=2; tabla[15][7]=1; tabla[15][8]=1; tabla[15][9]=1; tabla[15][10]=1; tabla[15][11]=0.5; tabla[15][12]=1; tabla[15][13]=2; tabla[15][14]=1; tabla[15][15]=1; tabla[15][16]=2; tabla[15][17]=0; 
		tabla[16][0]=0; tabla[16][1]=1; tabla[16][2]=1; tabla[16][3]=1; tabla[16][4]=1; tabla[16][5]=0.5; tabla[16][6]=1; tabla[16][7]=2; tabla[16][8]=1; tabla[16][9]=1; tabla[16][10]=1; tabla[16][11]=2; tabla[16][12]=1; tabla[16][13]=0.5; tabla[16][14]=1; tabla[16][15]=0.5; tabla[16][16]=0.5; tabla[16][17]=1; 
		tabla[17][0]=0.5; tabla[17][1]=1; tabla[17][2]=2; tabla[17][3]=1; tabla[17][4]=0.5; tabla[17][5]=1; tabla[17][6]=1; tabla[17][7]=1; tabla[17][8]=1; tabla[17][9]=2; tabla[17][10]=1; tabla[17][11]=2; tabla[17][12]=1; tabla[17][13]=0.5; tabla[17][14]=1; tabla[17][15]=1; tabla[17][16]=1; tabla[17][17]=1; 
		
		
		}

		public double verdebilidad(String ta, Pokemon p) {
			//debilidad que tiene el Pokemon "p" si le atacan con el ataque de tipo "ta"
			
			double debilidad=0;
			int x=0; int y1=0; int y2=0;
			int y=0;
			int cont=0;
			String tipo;
			
			String td1=p.type1;
			String td2=p.type2;
			
			if(td2==" ") {
				cont=1;
			}else {
				cont=2;
			}
			
			switch(ta) {
			case "Acero": x = 0; break;
			case "Agua": x = 1; break;
			case "Bicho": x = 2; break;
			case "Dragón": x = 3; break;
			case "Eléctrico": x = 4; break;
			case "Fantasma": x = 5; break;
			case "Fuego": x = 6; break;
			case "Hada": x = 7; break;
			case "Hielo": x = 8; break;
			case "Lucha": x = 9; break;
			case "Normal": x = 10; break;
			case "Planta": x = 11; break;
			case "Psíquico": x = 12; break;
			case "Roca": x = 13; break;
			case "Siniestro": x = 14; break;
			case "Tierra": x = 15; break;
			case "Veneno": x = 16; break;
			case "Volador": x = 17; break;
			}
			
			for(int i=0; i<cont; i++) {
				
				if(i==0) {
					tipo=td1;
				}else {
					tipo=td2;
				}
				
				switch(tipo) {
				case "Acero": y = 0; break;
				case "Agua": y = 1; break;
				case "Bicho": y = 2; break;
				case "Dragón": y = 3; break;
				case "Eléctrico": y = 4; break;
				case "Fantasma": y = 5; break;
				case "Fuego": y = 6; break;
				case "Hada": y = 7; break;
				case "Hielo": y = 8; break;
				case "Lucha": y = 9; break;
				case "Normal": y = 10; break;
				case "Planta": y = 11; break;
				case "Psíquico": y = 12; break;
				case "Roca": y = 13; break;
				case "Siniestro": y = 14; break;
				case "Tierra": y = 15; break;
				case "Veneno": y = 16; break;
				case "Volador": y = 17; break;
				}
				
				if(i==0) {
					y1=y;
				}else {
					y2=y;
				}
				
			}
			
			debilidad = this.tabla[x][y1];
			debilidad = debilidad + this.tabla[x][y2];
			
			if(this.tabla[x][y1]==0||this.tabla[x][y2]==0) {
				debilidad = 0;
			}
			
			return debilidad;
			
		}
		
}
