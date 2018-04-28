package proyecto;

public class Pokemon {
	
	public int estado; //0 debilitado, 1 normal, 2 paralizado, 3 congelado, 4 envenenado, 5 confuso, 6 dormido, 7 quemado
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
	public Ataques[] ataques = new Ataques[4];
	public int hpbase;
	public int atkbase;
	public int satkbase;
	public int defbase;
	public int sdefbase;
	public int spdbase;
	public int expbase;
	public int ivhp;
	public int ivatk;
	public int ivsatk;
	public int ivdef;
	public int ivsdef;
	public int ivspd;
	public int naturaleza;
	

	public int getExpbase() {
		return expbase;
	}

	public Pokemon(){
		estado=0;
		npokedex=160;//numero para saber que esta vacio
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
		for(int i=0; i<4; i++) {
			ataques[i] = new Ataques();
		}
		
		hpbase=0;
		atkbase=0;
		satkbase=0;
		defbase=0;
		sdefbase=0;
		spdbase=0;
		
		ivhp=0;
		ivatk=0;
		ivsatk=0;
		ivdef=0;
		ivsdef=0;
		ivspd=0;
		
		naturaleza=0;
	}
	
	
	
	// Constructor de Pokemon segun el nombre
	public Pokemon(String nombre) {
		
		int nivel=0;
		nombre = nombre.toUpperCase();
		
		switch(nombre) {
		case "PIKACHU":
			this.nombre="Pikachu";
			this.estado=1;
			nivel = (int) (1 + Math.random()*5);
			this.type1="Eléctrico";
			this.type2=" ";
			this.npokedex=0;
			this.hpbase=35;
			this.atkbase=55;
			this.satkbase=40;
			this.defbase=50;
			this.sdefbase=50;
			this.spdbase=90;
			this.ivhp=(int) (Math.random()*31); this.hp = this.hpbase; this.maxhp = this.hp;
			this.ivatk=(int) (Math.random()*31); this.atk = this.atkbase;
			this.ivsatk=(int) (Math.random()*31); this.satk = this.satkbase;
			this.ivdef=(int) (Math.random()*31); this.def = this.defbase;
			this.ivsdef=(int) (Math.random()*31); this.sdef = this.sdefbase;
			this.ivspd=(int) (Math.random()*31); this.spd = this.spdbase;
			this.naturaleza= (int) (Math.random()*25);
			this.expbase=82;
			this.ataques[0] = new Ataques("Placaje");
			this.ataques[1] = new Ataques("Rayo");
			this.ataques[2] = new Ataques();
			this.ataques[3] = new Ataques();
			
			for(int j=0; j<2; j++) {
				this.totexp = this.totexp + (nivel*nivel);  
			}
			break;
		case "PIDGEY":
			this.nombre="Pidgey";
			this.estado=1;
			nivel = (int) (1 + Math.random()*5);
			this.type1="Normal";
			this.type2="Volador";
			this.npokedex=1;
			this.hpbase=40;
			this.atkbase=45;
			this.satkbase=40;
			this.defbase=35;
			this.sdefbase=35;
			this.spdbase=56;
			this.ivhp=(int) (Math.random()*31); this.hp = this.hpbase; this.maxhp = this.hp;
			this.ivatk=(int) (Math.random()*31); this.atk = this.atkbase;
			this.ivsatk=(int) (Math.random()*31); this.satk = this.satkbase;
			this.ivdef=(int) (Math.random()*31); this.def = this.defbase;
			this.ivsdef=(int) (Math.random()*31); this.sdef = this.sdefbase;
			this.ivspd=(int) (Math.random()*31); this.spd = this.spdbase;
			this.naturaleza= (int) (Math.random()*25);
			this.expbase=55;
			this.ataques[0] = new Ataques("Placaje");
			this.ataques[1] = new Ataques("Picotazo");
			this.ataques[2] = new Ataques();
			this.ataques[3] = new Ataques();
			
			for(int j=0; j<2; j++) {
				this.totexp = this.totexp + (nivel*nivel);  
			}
			break;
		case "GROWLITHE":
			this.nombre="Growlithe";
			this.estado=1;
			nivel = (int) (1 + Math.random()*5);
			this.type1="Fuego";
			this.type2=" ";
			this.npokedex=2;
			this.hpbase=55;
			this.atkbase=70;
			this.satkbase=45;
			this.defbase=70;
			this.sdefbase=50;
			this.spdbase=60;
			this.ivhp=(int) (Math.random()*31); this.hp = this.hpbase; this.maxhp = this.hp;
			this.ivatk=(int) (Math.random()*31); this.atk = this.atkbase;
			this.ivsatk=(int) (Math.random()*31); this.satk = this.satkbase;
			this.ivdef=(int) (Math.random()*31); this.def = this.defbase;
			this.ivsdef=(int) (Math.random()*31); this.sdef = this.sdefbase;
			this.ivspd=(int) (Math.random()*31); this.spd = this.spdbase;
			this.naturaleza= (int) (Math.random()*25);
			this.expbase=91;
			this.ataques[0] = new Ataques("Placaje");
			this.ataques[1] = new Ataques("Ascuas");
			this.ataques[2] = new Ataques();
			this.ataques[3] = new Ataques();
			
			for(int j=0; j<2; j++) {
				this.totexp = this.totexp + (nivel*nivel);  
			}
			break;
		default:
			this.estado=0;
			this.npokedex=160;
			this.nivel=0;
			this.hpbase=0;
			this.atkbase=0;
			this.satkbase=0;
			this.defbase=0;
			this.sdefbase=0;
			this.spdbase=0;
			this.ivhp=0; this.hp = this.hpbase; this.maxhp = this.hp;
			this.ivatk=0; this.atk = this.atkbase;
			this.ivsatk=0; this.satk = this.satkbase;
			this.ivdef=0; this.def = this.defbase;
			this.ivsdef=0; this.sdef = this.sdefbase;
			this.ivspd=0; this.spd = this.spdbase;
			this.naturaleza=160;
			this.expbase=0; this.exp=0; this.totexp=0;
			
			for(int i=0; i<4; i++) {
				this.ataques[i] = new Ataques();
			}
			
			break;
		}
		
		for(int i=0; i<nivel; i++) {
			lvlup();
		}
		
	}
	
	public void curar(int cura) {
		//curacion con un objeto que cura el numero de ps indicado por la variable "cura"
		
		if(this.estado!=0) {
		
			this.hp = this.hp + cura;
			
			if(this.hp>this.maxhp) {
				this.hp=this.maxhp;
			}
		}
	}
	
	public void curatotal(Pokemon p) {
		//si solamente pasas el pokemon se curara al completo
		
		if(this.estado!=0) {
			this.hp=this.maxhp;
		}
		
	}
	
	public void debilitado() {
		
		this.hp=0;
		this.estado=0;
		
	}
	
	public void turnocombate(Pokemon enemigo, Ataques ataque) {
		// funcion para calcular el de un Pokemon a otro
		 // aplicas la funcion sobre el Pokemon atacante y 
		  // le pasas el Pokemon defensor y el numero del ataque que usas (1, 2, 3 o 4)
		
		System.out.println("el estado "+this.estado);
		
		if(this.estado!=0) {
		
		int prioridad = prioridad(this, enemigo);
		
		System.out.println("estado "+this.estado);
		
		int ataquesalvaje=(int) (Math.random()*4);
		
		while(enemigo.ataques[ataquesalvaje].pp<=0) {
			
			ataquesalvaje = (int) (Math.random()*4);
			
			
		}
		
		//0 debilitado, 1 normal, 2 paralizado, 3 congelado, 4 envenenado, 5 confuso, 6 dormido, 7 quemado
		switch(prioridad) {
		case 0:
			int random=0;
			if(this.estado==2||this.estado==3||this.estado==5||this.estado==6) {
				random = (int) (1 + Math.random()*5);
			}
			if(random==3) {
				random=0;
				this.estado=1;
			}else {
				random = (int) (Math.random()*2);
			}
			if(random==0) {
				this.damage(enemigo, this, ataque);
			}
			random=0;
			
			if(enemigo.hp>0) {
				if(enemigo.estado==2||enemigo.estado==3||enemigo.estado==5||enemigo.estado==6) {
					random = (int) (1 + Math.random()*5);
				}
				if(random==3) {
					random=0;
					enemigo.estado=1;
				}else {
					random = (int) (Math.random()*2);
				}
				if(random==0) {
					enemigo.damage(this, enemigo, enemigo.ataques[ataquesalvaje]);
				}
			}
			break;
		case 1:
			random=0;
			if(enemigo.estado==2||enemigo.estado==3||enemigo.estado==5||enemigo.estado==6) {
				random = (int) (1 + Math.random()*5);
			}
			if(random==3) {
				random=0;
				enemigo.estado=1;
			}else {
				random = (int) (Math.random()*2);
			}
			if(random==0) {
				enemigo.damage(this, enemigo, enemigo.ataques[ataquesalvaje]);
			}
			random=0;
			
			if(this.hp>0) {
				if(this.estado==2||this.estado==3||this.estado==5||this.estado==6) {
					random = (int) (1 + Math.random()*5);
				}
				if(random==3) {
					random=0;
					this.estado=1;
				}else {
					random = (int) (Math.random()*2);
				}
				if(random==0) {
					this.damage(enemigo, this, ataque);
				}
			}
			break;
		}
		
		/// restar vida por veneno
		System.out.println("vida "+this.hp);
		if(this.estado==4/*envenenado*/||this.estado==7/*quemado*/) {
			this.hp = this.hp - (this.hp / 10);
		}
		if(this.hp<=0) {
			this.hp=0;
			this.estado=0;
		}
		if(enemigo.estado==4/*envenenado*/||enemigo.estado==7/*quemado*/) {
			enemigo.hp = enemigo.hp - (enemigo.hp / 10);
		}
		if(enemigo.hp<=0) {
			enemigo.hp=0;
			enemigo.estado=0;
		}
		System.out.println("vida "+this.hp);
		
		}
	}
	
	private int prioridad(Pokemon equipo, Pokemon enemigo) {
		// devuelve 0 si el Pokemon 1 es mas rapido que el Pokemon 2
		  // devuelve 1 si el Pokemon 2 es mas rapido que el Pokemon 1
		    // si tienen la misma velocidad se devolvera 0 o 1 de manera aleatoria
		
		int num=0;
		int spd1=equipo.spd;
		int spd2=enemigo.spd;
		
		if(equipo.estado==2/*paralizado*/) {
			spd1 = (int) (spd1 - (spd1 * 0.4));
		}
		if(enemigo.estado==2/*paralizado*/) {
			spd2 = (int) (spd2 - (spd2 * 0.4));
		}
		
		if(spd1>spd2) {
			num = 0;
		}else if(spd1<spd2) {
			num = 1;
		}else if(spd1==spd2) {
			num = (int) (Math.random()*2);
		}
		
		return num;
	}
	
	private void damage(Pokemon rival, Pokemon equipo, Ataques ataque) {
		// le pasas un Pokemon i el numero del ataque
		 // a aprtir de aqui calcula el daño que hace el Pokemon sobre el que haces
		  // la funcion con el ataque de numero "ataque"(1, 2, 3, o 4) hacia el Pokemon "p"
		
		if(ataque.pwr>0) {
		
			double debilidad=1;
			double damage=0;
			double stab=0;
			double donedamage=0;
			
			int atkd=equipo.atk; int defd=equipo.def;
			int satkd=equipo.satk; int sdefd=equipo.sdef;
			int spdd=equipo.spd;
			
			switch(equipo.estado) {
			case 7://quemado
				atkd= atkd / 2;
				satkd= satkd / 2;
				break;
			}
			
			Tablatipos ta = new Tablatipos();
			
				if(equipo.type1==ataque.type||equipo.type2==ataque.type) {
					damage = 1.5;
				}
				debilidad = ta.verdebilidad(ataque.type, rival);
				damage+=debilidad;
				if(debilidad==0) {
					damage=0;
				}
				if(ataque.cty==0) {
					 donedamage = (int) ((atkd-rival.def)*damage);
				}
				if(ataque.cty==1) {
					donedamage = (int) ((satkd-rival.sdef)*damage);
				}
				if(donedamage<=0) {
					donedamage = damage+1;
				}
				rival.hp = (int) (rival.hp - ((donedamage)/**(this.a4pwr/100)*/));
				
		}
		
		if(rival.hp<=0) {
			rival.estado=0;
		}else {
			//0 debilitado, 1 normal, 2 paralizado, 3 congelado, 4 envenenado, 5 confuso, 6 dormido, 7 quemado
			if(ataque.probparalize>=(1 + Math.random()*10)) {
				rival.estado=2;
			}
			if(ataque.probfrozen>=(1 + Math.random()*10)) {
				rival.estado=3;
			}
			if(ataque.probpoison>=(1 + Math.random()*10)) {
				rival.estado=4;
			}
			if(ataque.probconfuse>=(1 + Math.random()*10)) {
				rival.estado=5;
			}
			if(ataque.probsleep>=(1 + Math.random()*10)) {
				rival.estado=6;
			}
			if(ataque.probburn>=(1 + Math.random()*10)) {
				rival.estado=7;
			}
			
		}
		
		
	}
	
	// subida de estadisticas segun la naturaleza
	public void lvlup() {
		this.nivel++;
		
		switch(this.naturaleza) {
		case 0: // Fuerte
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * (1);
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * (1);
			break;
		case 1: // Osada
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * ((90/100));
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * ((110/100));
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * (1);
			break;
		case 2: // Miedosa
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * ((90/100));
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * ((110/100));
			break;
		case 3: // Modesta
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * ((90/100));
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * ((110/100));
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * (1);
			break;
		case 4: // Serena
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * ((90/100));
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * ((110/100));
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * (1);
			break;
		case 5: // Huraña
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * ((110/100));
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * ((90/100));
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * (1);
			break;
		case 6: // Dócil
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * (1);
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * (1);
			break;
		case 7: // Activa
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * (1);
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * ((90/100));
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * ((110/100));
			break;
		case 8: // Afable
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * (1);
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * ((110/100));
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * ((90/100));
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * (1);
			break;
		case 9: // Amable
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * (1);
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * ((90/100));
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * ((110/100));
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * (1);
			break;
		case 10: // Audaz
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * ((110/100));
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * ((90/100));
			break;
		case 11: // Plácida
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * (1);
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * ((110/100));
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * ((90/100));
			break;
		case 12: // Seria
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * (1);
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * (1);
			break;
		case 13: // Mansa 
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * (1);
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * ((110/100));
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * ((90/100));
			break;
		case 14: // Grosera
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * (1);
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * ((110/10));
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * ((90/100));
			break;
		case 15: // Firme
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * ((110/100));
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * ((90/100));
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * (1);
			break;
		case 16: // Agitada
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * (1);
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * ((90/100));
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * ((110/100));
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * (1);
			break;
		case 17: // Alegre
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * (1);
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * ((90/100));
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * ((110/100));
			break;
		case 18: // Tímida
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * (1);
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * (1);
			break;
		case 19: // Cauta
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * (1);
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * ((90/100));
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * ((110/100));
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * (1);
			break;
		case 20: // Pícara
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * ((110/100));
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * ((90/100));
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * (1);
			break;
		case 21: // Floja
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * (1);
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * ((110/100));
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * ((90/100));
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * (1);
			break;
		case 22: // Ingenua
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * (1);
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * (1 + 1);
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * ((90/100));
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * ((110/100));
			break;
		case 23: // Alocada
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1 + (110/100));
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * ((90/100));
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * (1);
			break;
		case 24: // Rara
			this.maxhp = ((((this.hpbase + this.ivhp)*2)*this.nivel)/100) + this.nivel + 10;
			this.hp = this.maxhp;
			this.atk = (((((this.ivatk + this.atkbase) * 2/*faltaria añadir ((raiz(EV))/4)*/) * (this.nivel))/100) + 5) * (1);
			this.satk = (((((this.ivsatk + this.satkbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.def = (((((this.ivdef + this.defbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.sdef = (((((this.ivsdef + this.sdefbase) * 2) * (this.nivel))/100) + 5) * (1);
			this.spd = (((((this.ivspd + this.spdbase) * 2) * (this.nivel))/100) + 5) * (1);
			break;
		}
		
		
	}

	
	
	
	
}
