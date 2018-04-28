package proyecto;

public class Ataques {

	String name;
	String type;
	int pwr;
	int acc;
	int cty;
	int pp;
	int maxpp;
	
	int probparalize;
	int probfrozen;
	int probpoison;
	int probconfuse;
	int probburn;
	int probsleep;
	
	public Ataques() {
		
		this.name="";
		this.type="";
		this.pwr=0;
		this.acc=0;
		this.cty=0;
		this.pp=0;
		this.maxpp=0;
		
		this.probparalize=0;
		this.probfrozen=0;
		this.probpoison=0;
		this.probconfuse=0;
		this.probburn=0;
		this.probsleep=0;
	}
	
	public Ataques(String nombre) {
		
		switch(nombre) {
		case "Placaje":
			this.name="Placaje";
			this.type="Normal";
			this.pwr=40;
			this.acc=100;
			this.cty=0;
			this.pp=35;
			this.maxpp=35;
			this.probparalize=0;
			this.probfrozen=0;
			this.probpoison=0;
			this.probconfuse=0;
			this.probburn=0;
			this.probsleep=0;
			break;
		case "Rayo":
			this.name="Rayo";
			this.type="Eléctrico";
			this.pwr=90;
			this.acc=100;
			this.cty=1;
			this.pp=15;
			this.maxpp=15;
			this.probparalize=2;
			this.probfrozen=0;
			this.probpoison=0;
			this.probconfuse=0;
			this.probburn=0;
			this.probsleep=0;
			break;
		case "Picotazo":
			this.name="Picotazo";
			this.type="Volador";
			this.pwr=35;
			this.acc=100;
			this.cty=0;
			this.pp=35;
			this.maxpp=35;
			this.probparalize=0;
			this.probfrozen=0;
			this.probpoison=0;
			this.probconfuse=0;
			this.probburn=0;
			this.probsleep=0;
			break;
		case "Ascuas":
			this.name="Ascuas";
			this.type="Fuego";
			this.pwr=40;
			this.acc=100;
			this.cty=1;
			this.pp=25;
			this.maxpp=25;
			this.probparalize=0;
			this.probfrozen=0;
			this.probpoison=0;
			this.probconfuse=0;
			this.probburn=2;
			this.probsleep=0;
			break;
		default:
			this.name=" ";
			this.type=" ";
			this.pwr=0;
			this.acc=0;
			this.cty=160;
			this.pp=0;
			this.maxpp=0;
			this.probparalize=0;
			this.probfrozen=0;
			this.probpoison=0;
			this.probconfuse=0;
			this.probburn=0;
			this.probsleep=0;
			break;
		}
		
	}
	
}
