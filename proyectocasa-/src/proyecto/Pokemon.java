package proyecto;

public class Pokemon {
	
	public int npokedex;
	public String nombre;
	public String type1;
	public String type2;
	public int nivel;
	public int maxhp;
	public int hp;
	public int totexp;
	public int exp;
	public int atk;
	public int def;
	public int satk;
	public int sdef;
	public int spd;
	public String a1name;
	public String a2name;
	public String a3name;
	public String a4name;
	public String a1type;
	public String a2type;
	public String a3type;
	public String a4type;
	public int a1pwr;
	public int a2pwr;
	public int a3pwr;
	public int a4pwr;
	public int a1acc;
	public int a2acc;
	public int a3acc;
	public int a4acc;
	public int a1maxpp;
	public int a2maxpp;
	public int a3maxpp;
	public int a4maxpp;
	public int a1pp;
	public int a2pp;
	public int a3pp;
	public int a4pp;
	public int a1cty;
	public int a2cty;
	public int a3cty;
	public int a4cty;
	

	public Pokemon(){
		npokedex=0;
		nombre="";
		type1="";
		type2="";
		nivel=0;
		maxhp=0;
		hp=0;
		totexp=0;
		exp=0;
		atk=0;
		def=0;
		satk=0;
		sdef=0;
		spd=0;
		a1name="";
		a2name="";
		a3name="";
		a4name="";
		a1type="";
		a2type="";
		a3type="";
		a4type="";
		a1pwr=0;
		a2pwr=0;
		a3pwr=0;
		a4pwr=0;
		a1acc=0;
		a2acc=0;
		a3acc=0;
		a4acc=0;
		a1maxpp=0;
		a2maxpp=0;
		a3maxpp=0;
		a4maxpp=0;
		a1pp=0;
		a2pp=0;
		a3pp=0;
		a4pp=0;
		a1cty=0;
		a2cty=0;
		a3cty=0;
		a4cty=0;
	}
	
	public Pokemon(int np, String no, String ty1, String ty2, int nl, int mh, int h, int ex, int mex, int at, int sat, int de, int sde, int ve, String n1, String n2, String n3, String n4, String t1, String t2, String t3, String t4, int ac1, int ac2, int ac3, int ac4, int pw1, int pw2, int pw3, int pw4, int pp1, int pp2, int pp3, int pp4, int mpp1, int mpp2, int mpp3, int mpp4, int cty1, int cty2, int cty3, int cty4){
		this.npokedex=np;
		this.nombre=no;
		this.type1=ty1;
		this.type2=ty2;
		this.nivel=nl;
		this.maxhp=mh;
		this.hp=h;
		this.totexp=mex;
		this.exp=ex;
		this.atk=at;
		this.def=de;
		this.satk=sat;
		this.sdef=sde;
		this.spd=ve;
		this.a1name=n1;
		this.a2name=n2;
		this.a3name=n3;
		this.a4name=n4;
		this.a1type=t1;
		this.a2type=t2;
		this.a3type=t3;
		this.a4type=t4;
		this.a1pwr=pw1;
		this.a2pwr=pw2;
		this.a3pwr=pw3;
		this.a4pwr=pw4;
		this.a1acc=ac1;
		this.a2acc=ac2;
		this.a3acc=ac3;
		this.a4acc=ac4;
		this.a1maxpp=mpp1;
		this.a2maxpp=mpp2;
		this.a3maxpp=mpp3;
		this.a4maxpp=mpp4;
		this.a1pp=pp1;
		this.a2pp=pp2;
		this.a3pp=pp3;
		this.a4pp=pp4;
		this.a1cty=cty1;
		this.a2cty=cty2;
		this.a3cty=cty3;
		this.a4cty=cty4;
	}
	
	
}