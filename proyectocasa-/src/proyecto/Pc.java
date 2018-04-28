package proyecto;

public class Pc {

	//matriz de 3 de: cajas, filas caja, columnas caja
	
	Pokemon[][][] pc = new Pokemon[10][6][6];
	
	public Pc() {
		for(int i=0; i<10; i++) {
			for(int j=0; j<6; j++) {
				for(int k=0; k<6; k++) {
					pc[i][j][k] = new Pokemon();
				}
			}
		}
	}
	
	public void cambio(Pokemon p1, Pokemon p2) {
		
		int aux1 = p1.npokedex; p1.npokedex = p2.npokedex; p2.npokedex = aux1;
		String aux2 = p1.nombre; p1.nombre = p2.nombre; p2.nombre = aux2;
		String aux3 = p1.type1; p1.type1 = p2.type1; p2.type1 = aux3;
		String aux4 = p1.type2; p1.type2 = p2.type2; p2.type2 = aux4;
		int aux5 = p1.nivel; p1.nivel = p2.nivel; p2.nivel = aux5;
		int aux6 = p1.maxhp; p1.maxhp = p2.maxhp; p2.maxhp = aux6;
		int aux7 = p1.hp; p1.hp = p2.hp; p2.hp = aux7;
		int aux8 = p1.totexp; p1.totexp = p2.totexp; p2.totexp = aux8;
		int aux9 = p1.exp; p1.exp = p2.exp; p2.exp = aux9;
		int aux10 = p1.atk; p1.atk = p2.atk; p2.atk = aux10;
		int aux11 = p1.satk; p1.satk = p2.satk; p2.satk = aux11;
		int aux12 = p1.def; p1.def = p2.def; p2.def = aux12;
		int aux13 = p1.sdef; p1.sdef = p2.sdef; p2.sdef = aux13;
		int aux14 = p1.spd; p1.spd = p2.spd; p2.spd = aux14;
		Ataques[] aux15 = p1.ataques; p1.ataques = p2.ataques; p2.ataques = aux15;
		int aux43 = p1.hpbase; p1.hpbase = p2.hpbase; p2.hpbase = aux43;
		int aux44 = p1.atkbase; p1.atkbase = p2.atkbase; p2.atkbase = aux44;
		int aux45 = p1.satkbase; p1.satkbase = p2.satkbase; p2.satkbase = aux45;
		int aux46 = p1.defbase; p1.defbase = p2.defbase; p2.defbase = aux46;
		int aux47 = p1.sdefbase; p1.sdefbase = p2.sdefbase; p2.sdefbase = aux47;
		int aux48 = p1.spdbase; p1.spdbase = p2.spdbase; p2.spdbase = aux48;
		int aux49 = p1.expbase; p1.expbase = p2.expbase; p2.expbase = aux49;
		int aux50 = p1.ivhp; p1.ivhp = p2.ivhp; p2.ivhp = aux50;
		int aux51 = p1.ivatk; p1.ivatk = p2.ivatk; p2.ivatk = aux51;
		int aux52 = p1.ivsatk; p1.ivsatk = p2.ivsatk; p2.ivsatk = aux52;
		int aux53 = p1.ivdef; p1.ivdef = p2.ivdef; p2.ivdef = aux53;
		int aux54 = p1.ivsdef; p1.ivsdef = p2.ivsdef; p2.ivsdef = aux54;
		int aux55 = p1.ivspd; p1.ivspd = p2.ivspd; p2.ivspd = aux55;
		int aux56 = p1.naturaleza; p1.naturaleza = p2.naturaleza; p2.naturaleza = aux56;
		
	}
	
	public void guardar(Pc pc, Pokemon p1) {
		
		int contador=0;
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<6; j++) {
				for(int k=0; k<6; k++) {
					if(contador==0&&pc.pc[i][j][k].nivel==0) {
						this.cambio(pc.pc[i][j][k], p1);
						contador++;
					}
				}
			}
		}
		
	}
	
	public void sacar(Pc p1, Pokemon[] equipo, int caja, int x, int y) {
		// se le pasa el pc, el equipo, y la posicion en el pc del Pokemon que queremos sacar
		
		int contador=0;
		
		for(int i=0; i<6; i++) {
			if(contador==0&&equipo[i].nivel==0) {
				this.cambio(p1.pc[caja][x][y], equipo[i]);
				contador++;
			}
		}
		
	}
	
	public int[][] crearcaja(Pc p1, int caja){
		// le envias el Pc, la caja en la que estas y te crea una matriz de 2 dimensiones de la caja 
		 // para poderla mostrar con la clase Tulell
		
		int[][] mostrar = new int[6][6];
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				mostrar[i][j]=28;//28 es para que sea vea vacio
			}
		}
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				mostrar[i][j] = p1.pc[caja][i][j].npokedex;
			}
		}
		
		
		
		return mostrar;
	}
	
	public String mostrarcaja(int[][] mostrar) {
		// le envias la matriz de la caja creada en la funcion crearcaja y te devuelve un String listo para mostrarlo
		  // con la clase taulell
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				switch(mostrar[i][j]) {
				case 0:
					mostrar[i][j]=30;
					break;
				case 1:
					mostrar[i][j]=31;
					break;
				case 2:
					mostrar[i][j]=32;
					break;
				case 160:
					mostrar[i][j]=28;
					break;
				}
			}
		}
		
		String mostrarv="";
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				mostrarv = mostrarv + mostrar[i][j];
			}
		}
		
		return mostrarv;
		
	}
	
}
