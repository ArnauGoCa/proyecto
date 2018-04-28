package proyecto;

public class Healer {

	public void healer(Pokemon[] p) {
		//curacion en el healer, cura la vida y restaura los pp de los ataques del Pokemon que le pasas
		for(int i=0; i<p.length; i++) {
			for(int j=0; j<4; j++) {
				p[i].ataques[j].pp = p[i].ataques[j].maxpp;
			}
			p[i].hp = p[i].maxhp;
			p[i].estado=1;
		}
		
	}
	
}
