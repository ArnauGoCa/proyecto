package proyecto;

import java.util.Timer;
import java.util.TimerTask;

public class Entrenador {

	static Pokemon[] equipo = new Pokemon[6];
	static int x;
	static int y;
	static int estado;
	
	public Entrenador(int numpoke) {
		
		this.estado=0;
		
		if(numpoke<=0||numpoke>6) {
			int random = (int) (1 + Math.random()*6);
		}
		
		
		String nombre="";
		
		for(int i=0; i<6; i++) {
			equipo[i] = new Pokemon();
		}
		
		for(int i=0; i<numpoke; i++) {
			
			int randomname= (int) (Math.random()*3);
			
			switch(randomname) {
			case 0:
				nombre="Pikachu";
				break;
			case 1:
				nombre="Pidgey";
				break;
			case 2:
				nombre="Growlithe";
				break;
			}
			
			equipo[i] = new Pokemon(nombre);
			
		}
		
	}
	
	public void combatesalvaje(Pokemon salvaje, Ataques ataque) {
		int contador=0;
		for(int j=0; j<5; j++) {
			if(equipo[j].hp>0&&contador==0) {
				equipo[j].turnocombate(salvaje, ataque);
				contador++;
			}
		}
	}
	
	public void combateentrenador(Entrenador rival) {
		
	}
	
	//hacer que funcione correctamente
	public void movimiento(char c, Mapa map, int nummap, int posi, int posj, char d) {
		
		switch(c) {
		case 'w': case 'W': case 's': case 'S': case 'a': case 'A': case 'd': case 'D':
			mover(c, nummap, posi, posj, map, d);
			break;
		case 'c': case 'C':
			//accion();
			break;
		case 'e': case 'E':
			this.estado=4;// equipo
			break;
		case 'r': case 'R':
			equipo[0].estado=4;
			break;
		}
		
		int[][] mapamundo = map.craermapa(posi, posj, nummap);
		
		String mapamundov = map.mostrarmapa(mapamundo);
		
		proyecto.t.setImgbackground("background.jpg");
		proyecto.t2.setImgbackground("backgroundopcion.jpg");
		proyecto.t.dibuixa(mapamundo);
		proyecto.t2.dibuixa(proyecto.segundapantalla);
		System.out.println(mapamundov);
		System.out.println(proyecto.segundapantallav);
		
	}

	private void mover(char c, int nummap, int posi, int posj, Mapa map, char d) {
		// TODO Auto-generated method stub
		
		int num1 = nummap;
		
		switch(nummap) {
		case 0:
			switch(d) {
			case 'd': case 'D':
				if(map.mapas[nummap][posi][posj+1]==4) {
					nummap++;
					map.mapas[nummap][posi][posj]=28;
					map = new Mapa(nummap);
					posi = 4; posj = 3;
					proyecto.auxp=28;
					map.mapas[nummap][posi][posj]=9;
				}
				break;
			}
			break;
		case 1:
			switch(d) {
			case 'a': case 'A':
				if(map.mapas[nummap][posi][posj-1]==4) {
					nummap--;
					map.mapas[nummap][posi][posj]=28;
					map = new Mapa(nummap);
					posi = 5; posj = 14;
					proyecto.auxp=28;
					map.mapas[nummap][4][4]=28;
					map.mapas[nummap][posi][posj]=8;
				}
				break;
			case 'd': case 'D':
				if(map.mapas[nummap][posi][posj+1]==4) {
					nummap++;
					map.mapas[nummap][posi][posj]=28;
					map = new Mapa(nummap);
					posi = 4; posj = 3;
					proyecto.auxp=28;
					map.mapas[nummap][posi][posj]=9;
				}
				break;
			}
			break;
		}
		
		int num2 = nummap;
		
		if(num1==num2) {
			
		
		if(c=='w'||c=='W') {
			if(map.mapas[nummap][posi-1][posj]==7||map.mapas[nummap][posi-1][posj]==5||map.mapas[nummap][posi-1][posj]==6||map.mapas[nummap][posi-1][posj]==11) {
				map.mapas[nummap][posi][posj]=10;
			}else {
				if(map.mapas[nummap][posi-1][posj]==2) {
					map.mapas[nummap][posi][posj]=proyecto.auxp;
					proyecto.auxp=map.mapas[nummap][posi-1][posj];
					map.mapas[nummap][posi-1][posj]=42;
					posi--;
				}else {
					map.mapas[nummap][posi][posj]=proyecto.auxp;
					proyecto.auxp=map.mapas[nummap][posi-1][posj];
					map.mapas[nummap][posi-1][posj]=10;
					posi--;
				}
				if(map.mapas[nummap][posi][posj]==39||map.mapas[nummap][posi][posj]==40||map.mapas[nummap][posi][posj]==41||map.mapas[nummap][posi][posj]==42) {
					int random = (int) (Math.random()*5);
					if(random%2==0&&equipo[0].hp>0) {
						proyecto.combates=true;
					}
				}
			}
		}
		if(c=='s'||c=='S') {
			if(map.mapas[nummap][posi+1][posj]==7||map.mapas[nummap][posi+1][posj]==6||map.mapas[nummap][posi+1][posj]==5) {
				map.mapas[nummap][posi][posj]=1;	
				}else {
					if(map.mapas[nummap][posi+1][posj]==11) {
						map.mapas[nummap][posi][posj]=proyecto.auxp;
						proyecto.auxp=map.mapas[nummap][posi+2][posj];
						map.mapas[nummap][posi+2][posj]=1;
						posi=posi+2;
					}else {
						if(map.mapas[nummap][posi+1][posj]==2) {
							map.mapas[nummap][posi][posj]=proyecto.auxp;
							proyecto.auxp=map.mapas[nummap][posi+1][posj];
							map.mapas[nummap][posi+1][posj]=39;
							posi++;
						}else {
							map.mapas[nummap][posi][posj]=proyecto.auxp;
							proyecto.auxp=map.mapas[nummap][posi+1][posj];
							map.mapas[nummap][posi+1][posj]=1;
							posi++;
						}
						if(map.mapas[nummap][posi][posj]==39||map.mapas[nummap][posi][posj]==40||map.mapas[nummap][posi][posj]==41||map.mapas[nummap][posi][posj]==42) {
							int random = (int) (Math.random()*5);
							if(random%2==0&&equipo[0].hp>0) {
								proyecto.combates=true;
							}
						}
					}}
		}
		if(c=='a'||c=='A') {
			if(map.mapas[nummap][posi][posj-1]==7||map.mapas[nummap][posi][posj-1]==5||map.mapas[nummap][posi][posj-1]==6||map.mapas[nummap][posi][posj-1]==11) {
				map.mapas[nummap][posi][posj]=8;	
				}else {
					if(map.mapas[nummap][posi][posj-1]==2) {
						map.mapas[nummap][posi][posj]=proyecto.auxp;
						proyecto.auxp=map.mapas[nummap][posi][posj-1];
						map.mapas[nummap][posi][posj-1]=40;
						posj--;
					}else {
						map.mapas[nummap][posi][posj]=proyecto.auxp;
						proyecto.auxp=map.mapas[nummap][posi][posj-1];
						map.mapas[nummap][posi][posj-1]=8;
						posj--;
					}
					if(map.mapas[nummap][posi][posj]==39||map.mapas[nummap][posi][posj]==40||map.mapas[nummap][posi][posj]==41||map.mapas[nummap][posi][posj]==42) {
						int random = (int) (Math.random()*5);
						if(random%2==0&&equipo[0].hp>0) {
							proyecto.combates=true;
						}
					}
				}
		}
		if(c=='d'||c=='D') {
			if(map.mapas[nummap][posi][posj+1]==7||map.mapas[nummap][posi][posj+1]==6||map.mapas[nummap][posi][posj+1]==5||map.mapas[nummap][posi][posj+1]==11) {
				map.mapas[nummap][posi][posj]=9;
			}else {
				
				 if(map.mapas[nummap][posi][posj+1]==2) {
						map.mapas[nummap][posi][posj]=proyecto.auxp;
						proyecto.auxp=map.mapas[nummap][posi][posj+1];
						map.mapas[nummap][posi][posj+1]=41;
						posj++;
				}else {
					map.mapas[nummap][posi][posj]=proyecto.auxp;
					proyecto.auxp=map.mapas[nummap][posi][posj+1];
					map.mapas[nummap][posi][posj+1]=9;
					posj++;
				}
				if(map.mapas[nummap][posi][posj]==39||map.mapas[nummap][posi][posj]==40||map.mapas[nummap][posi][posj]==41||map.mapas[nummap][posi][posj]==42) {
					int random = (int) (Math.random()*5);
					if(random%2==0&&equipo[0].hp>0) {
						proyecto.combates=true;
					}
				}
			}
		}
		
		}
		
		
		
	}
	
}
