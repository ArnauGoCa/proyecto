package proyecto;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class proyecto {
	
	//la experiencia ganada en combate ya es igual que el juego real,
	/// la experiencia total de los pokemon ya es igual que en juego real
	////el calculo de daño tambien
	/////las estadisticas aumentan de manera random a cada nivel
	
	
	// se puede combatir, se puede curar en combate, se puede capturar el enemigo
	///se puede cambiar de pokemon en combate o intentar huir
	//// se pueden guardar y sacar pokemon del pc 
	               //(el pc tiene un maximo de 500 pokemon pero solo se mostraran los 36 primeros de momento)
	////// se puede curar el equipo en el healer
	////////
	
	// w a s d para moverse
	//// c para interactuar (en el equipo se cambia el pokemon seleccionado a la primera posicion)
	////// e para volver al menu anterior (en caso de estar en el mapa abre el equipo)     
	
	static int vidapoke=0;
	static int vidasalvaje=0;
	
	static int vidamaxpoke=0;
	static int vidamaxsalvaje=0;
	
static Scanner sc = new Scanner(System.in);

	static boolean fin=true;
	static boolean mapa1=true;
	static boolean bmenupc=false;
	static boolean combates;
	
	//auxiliar de movimiento que varia cada vez que te mueves
	static int auxp=28;
	
	static int[] fotospp = new int[41];
	static int[] fotoslvl = new int[100];
	static int[] fotoshp = new int[101];
	
	//array de la segunda pantalla
	static int[][] segundapantalla = new int[3][3];
	static String segundapantallav="";

	static int contador=0; //contador auxiliar para solo actuar una vez en bucles
	                        //que solo tiene que hacer una cosa una vez, por ejemplo al guardar pokemon,
							 // al sacar pokemon del pc o al capturar
	
	//array del pc, y del menu del pc
	static Pokemon[] pc = new Pokemon[500];
	static int[][] menupc = new int[2][2];
	static String menupcv="";
	
	static int a=0;
	//array con los pokemon del quipo
	static Pokemon[] equipo = new Pokemon[6];
	
	//array qeu forma el mapa global y el mapa que se muestra al jugador
	static int[][] mapa = new int[18][18];
	static String mapav ="";
	static int[][] mapamov = new int[7][7];
	static String mapamovv="";
	
	//posicion del jugador en el mundo
	static int posi = 3;
	static int posj = 3;
	
	//ataque escojido en el menu de lucahr
	static int ataqueescojido=0;
	//numero de pociones disponibles
	static int numpociones=0;
	//numero de pokemons vivos en el equipo
	static int numpoke=0;
	
	//enemigo en el combate
	static Pokemon enemigo = new Pokemon();
	
	//menu en el combate
	static int[][] menuopcioncombate = new int[1][1];
	
	//menu de los ataques de tu pokemon en combate
	static String[][] menuluchar = new String[2][2];
	
	//posicion en el menu del pc, como es una array vertical solo tiene una variable de posicion
	static int posmenupci = 0;
	
	//posicion en el menu del combate
	static int poshudi=0;
	static int poshudj=1;
	static int imgcombate=28;
	
	//diferents Arrays de combate que varian en diferentes funciones
	static int[][] combate3 = new int[3][3];
	static int[][] combate2 = new int[3][3];
	
	
	static Taulell t = new Taulell();
	static Taulell t2 = new Taulell();
	static Finestra f = new Finestra(t, t2);
	
	// variable para cambiar de menu, etc en el timer
	static int estado=0; 
	/* 
	 * 0= mundo, 
	 * 1= menu combate, 
	 * 4= equipo o guardar en el pc, 
	 * 5= menu de ataques, 
	 * 6= daño a pokemon propio y a pokemon enemigo, 
	 * 7= mostrar la variacion del healer de manera visual, 
	 * 8= menu de sacar pokemon del pc, 
	 * 9= menu del pc para selccionar si guardar o sacar pokemon, 
	 * 10= menu de la bolsa, 
	 * 11= mostrar de manera visual la captura   
	 * */
	
	/// para el menu de ataques en combate ////////////
	//////posicion en el menu de ataques
	
	static int posluchari=0; static int poslucharj=0;
	
	////////////////////////////////////////////////////
	//para el healer
	/////posicion del healer en el mapa respecto al jugador 
	   //////para modificar el lugar correcto al curar
	//////contador de los pokemon del equipo para saber cuantas pokeball mostrar en la curacion
	
	static int healerx=0;
	static int healery=0;
	static int contadorh=0;
	
	////para el equipo /////////////
	//////posicion del jugador en el menu del equipo, o al sacar del pc, 
	////////boolean para activar el guardar pokemon del equipo
	
	static int posmenuequipoi=0;
	static int posmenuequipoj=0;
	static int posicion=0;
	static int x=0;
	static int y=0;
	static int x2=1;
	static int y2=0;
	
	
	static boolean guardar = false;
	
	//////////////////////////////////////
	///////sacar del pc////////
	//posicion en el lo que se mustra del pc
	///posicion real en el array del pc
	
	static int posicionpc = 0;
	
	static int possacari=0;
	static int possacarj=0;
	
	//////////////////////////
	//////bolsa
	//posicion del pc donde esta el jugador
	////que accion esta seleccionada en la bolsa
	/////contador de control de captura, para mostrar en el timer el movimiento de la pokeball
	
	static int posbolsai=0;
	static int posbolsaj=0;
	static int accionbolsa=1;
	
	static int contadorcaptura=0;
	/////////////////////////
	
	public static void main(String[] args) {

		/////init interficie grafica
		///////////////////////////////////////////////////////t.setActimatges(true);
		//String[] imatges= {"path.jpg","path2.jpg","..."}
		//t.setImatges(imatges);
		String[] imatges= {"suelo.jpg"/*0*/, "pj.jpg"/*1*/, "hierbaalta.jpg"/*2*/, "corte.jpg"/*3*/, "cartel.jpg"/*4*/, "pc.jpg"/*5*/, "healer.jpg"/*6*/, "arbol.jpg"/*7*/, "pj2.jpg"/*8*/, "pj3.jpg"/*9*/, "pj4.jpg"/*10*/, "borde.png"/*11*/, 
				"vida.jpg"/*12*/, "fondomenu.jpg"/*13*/, "derecha.jpg"/*14*/, "luchar1.jpg"/*15*/, "combateluchar2.jpg"/*16*/, "bolsa1.jpg"/*17*/, "combatebolsa2.jpg"/*18*/, "huir1.jpg"/*19*/, "combatehuir2.jpg"/*20*/, "equipo1.jpg"/*21*/, "combateequipo2.jpg"/*22*/,
				"menubolsa1.jpg"/*23*/, "menubolsa2.jpg"/*24*/, "menubolsa3.jpg"/*25*/, "menubolsa4.jpg"/*26*/, ""/*27vacio*/, ""/*28 para vacio*/,""/*29 vacio*/, 
				"pikachu.jpg"/*30*/, "pidgey.jpg"/*31*/, "growlithe.jpg"/*32*/, "pikachuback.jpg"/*33*/, "pidgeyback.jpg"/*34*/, "growlitheback.jpg"/*35*/, "vidaverde.jpg"/*36*/, "vidaamarillo.jpg"/*37*/, "vidarojo.jpg"/*38*/,
				"pjhierba.jpg"/*39*/, "pj2hierba.jpg"/*40*/, "pj3hierba.jpg"/*41*/, "pj4hierba.jpg"/*42*/, 
				"vida0.jpg"/*43*/, "vida10.jpg"/*44*/, "vida20.jpg"/*45*/, "vida30.jpg"/*46*/, "vida40.jpg"/*47*/, "vida50.jpg"/*48*/, "vida60.jpg"/*49*/, "vida70.jpg"/*50*/, "vida80.jpg"/*51*/, "vida90.jpg"/*52*/, "vida100.jpg"/*53*/, 
				"placaje.jpg"/*54*/, "placaje2.jpg"/*55*/, "normal.png"/*56*/, "fisico.jpg"/*57*/, "especial.jpg"/*58*/, " "/*59  VACIO  */, "pp.jpg"/*60*/, 
				/*TIPOS    */"acero.png"/*61*/, "agua.png"/*62*/, "fuego.png"/*63*/, "siniestro.png"/*64*/, "psiquico.png"/*65*/, "bicho.png"/*66*/, "hada.png"/*67*/, "tierra.png"/*68*/, "roca.png"/*69*/, "fantasma.png"/*70*/, "dragon.png"/*71*/, "hielo.png"/*72*/, "volador.png"/*73*/, "planta.png"/*74*/, "veneno.png"/*75*/, "electrico.png"/*76*/, "lucha.png"/*77*/, 
				"pp0.jpg"/*78*/,  "pp1.jpg"/*79*/,  "pp2.jpg"/*80*/,  "pp3.jpg"/*81*/,  "pp4.jpg"/*82*/,  "pp5.jpg"/*83*/,  "pp6.jpg"/*84*/,  "pp7.jpg"/*85*/,  "pp8.jpg"/*86*/,  "pp9.jpg"/*86*/,  "pp10.jpg"/*88*/,  "pp11.jpg"/*89*/,  "pp12.jpg"/*90*/,  "pp13.jpg"/*91*/,  "pp14.jpg"/*92*/,  "pp15.jpg"/*93*/,  "pp16.jpg"/*94*/,  "pp17.jpg"/*95*/,  "pp18.jpg"/*96*/,  "pp19.jpg"/*97*/,  "pp20.jpg"/*98*/,  
				"pp21.jpg"/*99*/,  "pp22.jpg"/*100*/,  "pp23.jpg"/*101*/,  "pp24.jpg"/*102*/,  "pp25.jpg"/*103*/,  "pp26.jpg"/*104*/,  "pp27.jpg"/*105*/,  "pp28.jpg"/*106*/,  "pp29.jpg"/*107*/,  "pp30.jpg"/*108*/,  "pp31.jpg"/*109*/,  "pp32.jpg"/*110*/,  "pp33.jpg"/*111*/,  "pp34.jpg"/*112*/,  "pp35.jpg"/*113*/,  "pp36.jpg"/*114*/,  "pp37.jpg"/*115*/,  "pp38.jpg"/*116*/,  "pp39.jpg"/*117*/,  "pp40.jpg"/*118*/, 
				"impactrueno.jpg"/*119*/, "  "/*120  VACIO*/, "picotazo.jpg"/*121*/, " "/*122  VACIO*/, "gruñido.jpg"/*123*/, " "/*124  VACIO*/, "rayo.jpg"/*125*/, " "/*126  VACIO*/, "ataqueala.jpg"/*127*/, " "/*128  VACIO*/, "ascuas.jpg"/*129*/, " "/*130  VACIO*/, 
				"marco.png"/*131*/, "healer1.jpg"/*132*/, "healer2.jpg"/*133*/, "healer3.jpg"/*134*/, "healer4.jpg"/*135*/, "healer5.jpg"/*136*/, "healer6.jpg"/*137*/, 
				"guardar.jpg"/*138*/, "sacar.jpg"/*139*/, "pokeball.png"/*140*/, "pokeball2.png"/*141*/, "pokeball3.png"/*142*/, "pokeball4.png"/*143*/, 
				"lvl1.jpg"/*144*/, "lvl2.jpg"/*145*/, "lvl3.jpg"/*146*/, "lvl4.jpg"/*147*/, "lvl5.jpg"/*148*/, "lvl6.jpg"/*149*/, "lvl7.jpg"/*150*/, "lvl8.jpg"/*151*/, "lvl9.jpg"/*145*/, "lvl10.jpg"/*145*/, "lvl11.jpg"/*145*/, "lvl12.jpg"/*145*/, "lvl13.jpg"/*145*/, "lvl14.jpg"/*145*/, "lvl15.jpg"/*145*/, "lvl16.jpg"/*145*/, "lvl17.jpg"/*145*/, "lvl18.jpg"/*145*/, "lvl19.jpg"/*145*/, "lvl20.jpg"/*145*/
				, "lvl21.jpg"/*164*/, "lvl22.jpg"/*165*/, "lvl23.jpg"/*166*/, "lvl24.jpg"/*167*/, "lvl25.jpg"/*168*/, "lvl26.jpg"/*169*/, "lvl27.jpg"/*170*/, "lvl28.jpg"/*171*/, "lvl29.jpg"/*172*/, "lvl30.jpg"/*173*/, "lvl31.jpg"/*174*/, "lvl32.jpg"/*175*/, "lvl33.jpg"/*176*/, "lvl34.jpg"/*177*/, "lvl35.jpg"/*178*/, "lvl36.jpg"/*179*/, "lvl37.jpg"/*180*/, "lvl38.jpg"/*181*/, "lvl39.jpg"/*182*/, "lvl40.jpg"/*183*/
				, "lvl41.jpg"/*184*/, "lvl42.jpg"/*185*/, "lvl43.jpg"/*186*/, "lvl44.jpg"/*187*/, "lvl45.jpg"/*188*/, "lvl46.jpg"/*189*/, "lvl47.jpg"/*190*/, "lvl48.jpg"/*191*/, "lvl49.jpg"/*192*/, "lvl50.jpg"/*193*/, "lvl51.jpg"/*194*/, "lvl52.jpg"/*195*/, "lvl53.jpg"/*196*/, "lvl54.jpg"/*197*/, "lvl55.jpg"/*198*/, "lvl56.jpg"/*199*/, "lvl57.jpg"/*200*/, "lvl58.jpg"/*201*/, "lvl59.jpg"/*202*/, "lvl60.jpg"/*203*/
				, "lvl61.jpg"/*204*/, "lvl62.jpg"/*205*/, "lvl63.jpg"/*206*/, "lvl64.jpg"/*207*/, "lvl65.jpg"/*208*/, "lvl66.jpg"/*209*/, "lvl67.jpg"/*210*/, "lvl68.jpg"/*211*/, "lvl69.jpg"/*212*/, "lvl70.jpg"/*213*/, "lvl71.jpg"/*214*/, "lvl72.jpg"/*215*/, "lvl73.jpg"/*216*/, "lvl74.jpg"/*217*/, "lvl75.jpg"/*218*/, "lvl76.jpg"/*219*/, "lvl77.jpg"/*220*/, "lvl78.jpg"/*221*/, "lvl79.jpg"/*222*/, "lvl80.jpg"/*223*/
				, "lvl81.jpg"/*224*/, "lvl82.jpg"/*225*/, "lvl83.jpg"/*226*/, "lvl84.jpg"/*227*/, "lvl85.jpg"/*228*/, "lvl86.jpg"/*229*/, "lvl87.jpg"/*230*/, "lvl88.jpg"/*131*/, "lvl89.jpg"/*232*/, "lvl90.jpg"/*233*/, "lvl91.jpg"/*234*/, "lvl92.jpg"/*235*/, "lvl93.jpg"/*236*/, "lvl94.jpg"/*237*/, "lvl95.jpg"/*238*/, "lvl96.jpg"/*239*/, "lvl97.jpg"/*240*/, "lvl98.jpg"/*241*/, "lvl99.jpg"/*242*/, "lvl100.jpg"/*243*/ 
				, "vida0.jpg"/*244*/, "vida1.jpg"/*245*/, "vida2.jpg"/*246*/, "vida3.jpg"/*247*/, "vida4.jpg"/*248*/, "vida5.jpg"/*249*/, "vida6.jpg"/*250*/, "vida7.jpg"/*251*/, "vida8.jpg"/*252*/, "vida9.jpg"/*253*/, "vida10.jpg"/*254*/, "vida11.jpg"/*255*/, "vida12.jpg"/*256*/, "vida13.jpg"/*257*/, "vida14.jpg"/*258*/, "vida15.jpg"/*259*/, "vida16.jpg"/*260*/, "vida17.jpg"/*261*/, "vida18.jpg"/*262*/, "vida19.jpg"/*263*/, "vida20.jpg"/*264*/
				, "vida21.jpg"/*265*/, "vida22.jpg"/*266*/, "vida23.jpg"/*267*/, "vida24.jpg"/*268*/, "vida25.jpg"/*269*/, "vida26.jpg"/*270*/, "vida27.jpg"/*271*/, "vida28.jpg"/*272*/, "vida29.jpg"/*273*/, "vida30.jpg"/*274*/, "vida31.jpg"/*275*/, "vida32.jpg"/*276*/, "vida33.jpg"/*277*/, "vida34.jpg"/*278*/, "vida35.jpg"/*279*/, "vida36.jpg"/*280*/, "vida37.jpg"/*281*/, "vida38.jpg"/*282*/, "vida39.jpg"/*283*/, "vida40.jpg"/*284*/
				, "vida41.jpg"/*285*/, "vida42.jpg"/*286*/, "vida43.jpg"/*287*/, "vida44.jpg"/*288*/, "vida45.jpg"/*289*/, "vida46.jpg"/*290*/, "vida47.jpg"/*291*/, "vida48.jpg"/*292*/, "vida49.jpg"/*293*/, "vida50.jpg"/*294*/, "vida51.jpg"/*293*/, "vida52.jpg"/*296*/, "vida53.jpg"/*297*/, "vida54.jpg"/*298*/, "vida55.jpg"/*299*/, "vida56.jpg"/*300*/, "vida57.jpg"/*301*/, "vida58.jpg"/*302*/, "vida59.jpg"/*303*/, "vida60.jpg"/*304*/
				, "vida61.jpg"/*305*/, "vida62.jpg"/*306*/, "vida63.jpg"/*307*/, "vida64.jpg"/*308*/, "vida65.jpg"/*309*/, "vida66.jpg"/*310*/, "vida67.jpg"/*311*/, "vida68.jpg"/*312*/, "vida69.jpg"/*313*/, "vida70.jpg"/*314*/, "vida71.jpg"/*315*/, "vida72.jpg"/*316*/, "vida73.jpg"/*317*/, "vida74.jpg"/*318*/, "vida75.jpg"/*319*/, "vida76.jpg"/*320*/, "vida77.jpg"/*321*/, "vida78.jpg"/*322*/, "vida79.jpg"/*323*/, "vida80.jpg"/*324*/
				, "vida81.jpg"/*325*/, "vida82.jpg"/*326*/, "vida83.jpg"/*327*/, "vida84.jpg"/*328*/, "vida85.jpg"/*329*/, "vida86.jpg"/*330*/, "vida87.jpg"/*331*/, "vida88.jpg"/*332*/, "vida89.jpg"/*333*/, "vida90.jpg"/*334*/, "vida91.jpg"/*335*/, "vida92.jpg"/*336*/, "vida93.jpg"/*337*/, "vida94.jpg"/*338*/, "vida95.jpg"/*339*/, "vida96.jpg"/*340*/, "vida97.jpg"/*341*/, "vida98.jpg"/*342*/, "vida99.jpg"/*343*/, "vida100.jpg"/*344*/};
		t.setImgbackground("background.jpg");
		t.setImatges(imatges);
		t.setActimatges(true);
		t.setActimgbackground(true);
		t2.setImgbackground("backgroundopcion.jpg");
		t2.setImatges(imatges);
		t2.setActimatges(true);
		t2.setActimgbackground(true);
		/////
		

		Timer timer = new Timer();
	    timer.schedule(new TimerTask() {

	        @Override
	        public void run() {
	            doStuff();
	        }

	    }, 0, 500);
	    
	  ////array fotos pps
		int pps=78;
		
		for(int i=0; i<41; i++) {
			fotospp[i]=pps;
			pps++;
		}
		
		///array fotos vida
		int hps=244;
		
		for(int i=0; i<101; i++) {
			fotoshp[i]=hps;
			hps++;
		}
		
		
		//array fotos niveles
		int lvls=144;
		
		
		
		for(int i=0; i<100; i++) {
			fotoslvl[i]=lvls;
			lvls++;
		}
		
		///inicializaciones
		for(int i=0; i<3;i++) {
			for(int j=0; j<3; j++) {
				segundapantalla[i][j]=28;
			}
		}
		
		for(int i=0; i<3;i++) {
			for(int j=0; j<3; j++) {
				segundapantallav = segundapantallav + segundapantalla[i][j];
			}
		}
		
		for(int i=0; i<500; i++) {
			int np=160;
			String no = " ";
			String ty1=" "; String ty2=" ";
			int nl=0; 
			int h=0; int mh=0;
			int ex=0; int mex=0;
			int at=0; int sat=0;
			int de=0; int sde=0;
			int ve=0; 
			String n1=" "; String n2=" "; String n3=" "; String n4=" ";  
			String t1=" "; String t2=" "; String t3=" "; String t4=" ";  
			int ac1=0; int ac2=0; int ac3=0; int ac4=0;
			int pw1=0; int pw2=0; int pw3=0; int pw4=0;
			int pp1=0; int pp2=0; int pp3=0; int pp4=0;
			int mpp1=0; int mpp2=0; int mpp3=0; int mpp4=0;
			int cty1=3; int cty2=3; int cty3=3; int cty4=3; 
			pc[i] = new Pokemon(np, no, ty1, ty2, nl, mh, h, ex, mex, at, sat, de, sde, ve, n1, n2, n3, n4, t1, t2, t3, t4, ac1, ac2, ac3, ac4, pw1, pw2, pw3, pw4, pp1, pp2, pp3, pp4, mpp1, mpp2, mpp3, mpp4, cty1, cty2, cty3, cty4);
			
		}
		
		for(int i=0; i<6; i++) {
			if(i==0) {
				int np=0;
				String no = "Pikachu";
				String ty1="Eléctrico"; String ty2=" ";
				int nl=1; 
				int h=100; int mh=h;
				int ex=0; int mex=0;
				for(int j=0; j<2; j++) {
					mex = mex + (nl*nl);  
				}
				
				int at=20; int sat=20;
				int de=12; int sde=13;
				int ve=14; 
				String n1="Rayo"; String n2="Placaje"; String n3="Placaje"; String n4=" ";  
				String t1="Eléctrico"; String t2="Normal"; String t3="Normal"; String t4=" ";  
				int ac1=20; int ac2=20; int ac3=20; int ac4=0;
				int pw1=20; int pw2=20; int pw3=20; int pw4=0;
				int pp1=35; int pp2=35; int pp3=35; int pp4=0;
				int mpp1=35; int mpp2=35; int mpp3=35; int mpp4=0;
				int cty1=1; int cty2=0; int cty3=0; int cty4=3; 
				equipo[i] = new Pokemon(np, no, ty1, ty2, nl, mh, h, ex, mex, at, sat, de, sde, ve, n1, n2, n3, n4, t1, t2, t3, t4, ac1, ac2, ac3, ac4, pw1, pw2, pw3, pw4, pp1, pp2, pp3, pp4, mpp1, mpp2, mpp3, mpp4, cty1, cty2, cty3, cty4);
				
			} else {
				if(i==1) {
					int np=1;
					String no = "Pidgey";
					String ty1="Normal"; String ty2="Volador";
					int nl=7; 
					int h=40; int mh=h;
					int ex=0; int mex=0;
					for(int j=0; j<2; j++) {
						mex = mex + (nl*nl);  
					}
					int at=20; int sat=11;
					int de=12; int sde=13;
					int ve=14; 
					String n1="Picotazo"; String n2="Placaje"; String n3=" "; String n4=" ";  
					String t1="Volador"; String t2="Normal"; String t3=" "; String t4=" ";  
					int ac1=20; int ac2=20; int ac3=20; int ac4=20;
					int pw1=20; int pw2=20; int pw3=20; int pw4=20;
					int pp1=20; int pp2=20; int pp3=20; int pp4=20;
					int mpp1=20; int mpp2=20; int mpp3=20; int mpp4=20;
					int cty1=0; int cty2=0; int cty3=3; int cty4=3;
					equipo[i] = new Pokemon(np, no, ty1, ty2, nl, mh, h, ex, mex, at, sat, de, sde, ve, n1, n2, n3, n4, t1, t2, t3, t4, ac1, ac2, ac3, ac4, pw1, pw2, pw3, pw4, pp1, pp2, pp3, pp4, mpp1, mpp2, mpp3, mpp4, cty1, cty2, cty3, cty4);
					
				}else {
				int np2=160;
				String no2 = " ";
				String ty12=" "; String ty22=" ";
				int nl2=0; 
				int h2=0; int mh2=0;
				int ex2=0; int mex2=0;
				int at2=0; int sat2=0;
				int de2=0; int sde2=0;
				int ve2=0; 
				String n12=" "; String n22=" "; String n32=" "; String n42=" ";  
				String t12=" "; String t22=" "; String t32=" "; String t42=" ";  
				int ac12=0; int ac22=0; int ac32=0; int ac42=0;
				int pw12=0; int pw22=0; int pw32=0; int pw42=0;
				int pp12=0; int pp22=0; int pp32=0; int pp42=0;
				int mpp12=0; int mpp22=0; int mpp32=0; int mpp42=0;
				int cty1=3; int cty2=3; int cty3=3; int cty4=3;
				equipo[i] = new Pokemon(np2, no2, ty12, ty22, nl2, mh2, h2, ex2, mex2, at2, sat2, de2, sde2, ve2, n12, n22, n32, n42, t12, t22, t32, t42, ac12, ac22, ac32, ac42, pw12, pw22, pw32, pw42, pp12, pp22, pp32, pp42, mpp12, mpp22, mpp32, mpp42, cty1, cty2, cty3, cty4);
				
			}}
		}
			
		
		if(mapa1==true) {
			
			for(int i=0; i<18; i++) {
				for(int j=0; j<18; j++) {
					mapa[i][j]=28;
				}
			}
			
			for(int i=0; i<18; i++) {
				for(int j=0; j<18; j++) {
					if(i==0||i==1||i==2||i==16||i==15||i==17||j==0||j==1||j==17||j==15||j==2||j==16) {
						mapa[i][j]=7;
					} else {
						if((i==8||i==7||i==6)) {
							mapa[i][j]=2;
						} else {
							mapa[i][j]=28;
						}	
					}
				}
			}
			
			mapa[posi][posj]=1;
			mapa[4][7]=5;
			mapa[4][8]=6;
			mapa[6][4]=28; mapa[6][3]=28; mapa[6][13]=28; mapa[6][14]=28;
			mapa[7][4]=28; mapa[7][3]=28; mapa[7][13]=28; mapa[7][14]=28;
			mapa[8][4]=28; mapa[8][3]=28; mapa[8][13]=28; mapa[8][14]=28;
			mapa[12][6]=11; mapa[12][7]=11; mapa[12][8]=11; mapa[12][9]=11; mapa[12][10]=11; mapa[12][11]=11; 
			 
			
			for(int i=0; i<18; i++) {
				for(int j=0; j<18; j++) {
					mapav = mapav + mapa[i][j];
				}mapav = mapav + "\n";
			}
			
			}
	
	}
	
	private static void doStuff() {
		
		
		switch(estado) {
		case 0: //el mapa principal
			mundo();
			break;
		case 1: //menu de combate
			numpoke=1;
			for(int i=0; i<6; i++) {
				if(equipo[i].hp>0) {
					numpoke++;
				}
			}
			a=0;
			opcioncombate();
			break;//mostrar el descenso de vida
		case 2:
			int prioridad2 = verrapidez(enemigo);
			mostrarvida(prioridad2);
			break;
		case 3: 
			
			break;
		case 4: //equipo fuera de combate, en combate o para guardar pokemon en pc
			equipo();
			break;
		case 5: //menu de ataques en combate
			ataques();
			break;
		case 6: //daño a pokemon enemigo i a pokemon propio
			int prioridad = verrapidez(enemigo);
			daño(enemigo, prioridad);
			break;
		case 7: //curar en el healer
			healer();
			break;
		case 8: //sacar pokemon del pc
			sacarpc();
			break;
		case 9: //menu pc para guardar o sacar pokemon
			menupc();
			break;
		case 10: //bolsa
			bolsa(enemigo);
			break;
		case 11: //captura en combate
			captura();
			break;
		}
		
	}
	
	private static void mostrarvida(int prioridad2) {
		// mostrar el descenso de vida en combate
		
		String combatev = "";
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				combatev = combatev + combate2[i][j];
			}
		}
		t.dibuixa(combate2);
		System.out.println(combatev);
		
		switch(prioridad2) {
		case 1:
			if(vidasalvaje<vidamaxsalvaje&&vidamaxsalvaje>=8) {
				vidamaxsalvaje-=8; //hacer que baje mas
				 combate2[1][2]=fotoshp[vidamaxsalvaje];
			}else if(vidapoke<vidamaxpoke&&vidamaxpoke>=8) {
				vidamaxpoke-=8;
				combate2[2][0]=fotoshp[vidamaxpoke];
			}
			break;
		case 2:
			if(vidapoke<vidamaxpoke&&vidamaxpoke>=8) {
				vidamaxpoke-=8;
				combate2[2][0]=fotoshp[vidamaxpoke];
			}else if(vidasalvaje<vidamaxsalvaje&&vidamaxsalvaje>=8) {
				vidamaxsalvaje-=8;
				 combate2[1][2]=fotoshp[vidamaxsalvaje];
			}
			break;
		}
		if(vidamaxsalvaje<=8) {
			vidamaxsalvaje=0;
		}
		
		System.out.println(vidamaxsalvaje);
		System.out.println(vidasalvaje);
		System.out.println(enemigo.hp);
		
		if(vidamaxsalvaje<=vidasalvaje&&enemigo.hp<=0) {
			System.out.println("acabar");
			combates=false;
			boolean derrota = false;
			fincombate(derrota, enemigo);
			estado=0;
		}else if(vidamaxsalvaje<=vidasalvaje&&enemigo.hp>0) {
			System.out.println("seguir");
				estado=1;
			}
		
		
		
	}

	private static void mundo(){
		
		
		contador=0;
		mapav="";
		mapamov[0][0]=mapa[posi-3][posj-3]; mapamov[0][1]=mapa[posi-3][posj-2]; mapamov[0][2]=mapa[posi-3][posj-1]; mapamov[0][3]=mapa[posi-3][posj]; mapamov[0][4]=mapa[posi-3][posj+1]; mapamov[0][5]=mapa[posi-3][posj+2]; mapamov[0][6]=mapa[posi-3][posj+3];
		mapamov[1][0]=mapa[posi-2][posj-3]; mapamov[1][1]=mapa[posi-2][posj-2]; mapamov[1][2]=mapa[posi-2][posj-1]; mapamov[1][3]=mapa[posi-2][posj]; mapamov[1][4]=mapa[posi-2][posj+1]; mapamov[1][5]=mapa[posi-2][posj+2]; mapamov[1][6]=mapa[posi-2][posj+3]; 
		mapamov[2][0]=mapa[posi-1][posj-3]; mapamov[2][1]=mapa[posi-1][posj-2]; mapamov[2][2]=mapa[posi-1][posj-1]; mapamov[2][3]=mapa[posi-1][posj]; mapamov[2][4]=mapa[posi-1][posj+1]; mapamov[2][5]=mapa[posi-1][posj+2]; mapamov[2][6]=mapa[posi-1][posj+3];
		mapamov[3][0]=mapa[posi][posj-3]; mapamov[3][1]=mapa[posi][posj-2]; mapamov[3][2]=mapa[posi][posj-1]; mapamov[3][3]=mapa[posi][posj]; mapamov[3][4]=mapa[posi][posj+1]; mapamov[3][5]=mapa[posi][posj+2]; mapamov[3][6]=mapa[posi][posj+3]; 
		mapamov[4][0]=mapa[posi+1][posj-3]; mapamov[4][1]=mapa[posi+1][posj-2]; mapamov[4][2]=mapa[posi+1][posj-1]; mapamov[4][3]=mapa[posi+1][posj]; mapamov[4][4]=mapa[posi+1][posj+1]; mapamov[4][5]=mapa[posi+1][posj+2]; mapamov[4][6]=mapa[posi+1][posj+3];
		mapamov[5][0]=mapa[posi+2][posj-3]; mapamov[5][1]=mapa[posi+2][posj-2]; mapamov[5][2]=mapa[posi+2][posj-1]; mapamov[5][3]=mapa[posi+2][posj]; mapamov[5][4]=mapa[posi+2][posj+1]; mapamov[5][5]=mapa[posi+2][posj+2]; mapamov[5][6]=mapa[posi+2][posj+3];
		mapamov[6][0]=mapa[posi+3][posj-3]; mapamov[6][1]=mapa[posi+3][posj-2]; mapamov[6][2]=mapa[posi+3][posj-1]; mapamov[6][3]=mapa[posi+3][posj]; mapamov[6][4]=mapa[posi+3][posj+1]; mapamov[6][5]=mapa[posi+3][posj+2]; mapamov[6][6]=mapa[posi+3][posj+3];
		
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				mapamovv = mapamovv + mapamov[i][j];
			}
		}
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				segundapantalla[i][j]=28;
			}
		}
		segundapantallav="";
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				segundapantallav = segundapantallav + segundapantalla[i][j];
			}
		}
		
		int[][] matriuover = new int[3][3];
		String matriuoverv="";
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++) {
				matriuover[i][j]=28;
			}
		}
		
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++) {
				matriuoverv = matriuoverv + matriuover[i][j];
			}
		}
		
		t.setImgbackground("background.jpg");
		t2.setImgbackground("backgroundopcion.jpg");
		t.dibuixa(mapamov);
		t2.dibuixa(segundapantalla);
		t.overdibuixa(matriuover);
		System.out.println(mapamovv);
		System.out.println(segundapantallav);
		System.out.println(matriuoverv);
		
		char movimiento = f.getActualChar();
		
			switch(movimiento) {
			case 'w': case 'W': case 's': case 'S': case 'a': case 'A': case 'd': case 'D':
				movimiento(movimiento);
				break;
			case 'c': case 'C':
				accion();
				break;
			case 'e': case 'E':
				estado=4;// equipo
				break;
			}
			numpoke=0;
		 
		if(combates==true&&estado==0) {
			numpociones=10;
			enemigo =salvaje();
			poshudi=0; poshudj=1;
			estado=1; //combate
		}
			
		
	}
	
	private static void movimiento(char movimiento) {
		// redirección del movimiento en las cuatro direcciones
		
		if(movimiento=='w'||movimiento=='W') {
			if(mapa[posi-1][posj]==7||mapa[posi-1][posj]==5||mapa[posi-1][posj]==6||mapa[posi-1][posj]==11) {
				mapa[posi][posj]=10;
			}else {
				if(mapa[posi-1][posj]==2) {
					mapa[posi][posj]=auxp;
					auxp=mapa[posi-1][posj];
					mapa[posi-1][posj]=42;
					posi--;
				}else {
					mapa[posi][posj]=auxp;
					auxp=mapa[posi-1][posj];
					mapa[posi-1][posj]=10;
					posi--;
				}
				if(mapa[posi][posj]==39||mapa[posi][posj]==40||mapa[posi][posj]==41||mapa[posi][posj]==42) {
					int random = (int) (Math.random()*5);
					if(random%2==0&&equipo[0].hp>0) {
						combates=true;
					}
				}
			}
		}
		if(movimiento=='s'||movimiento=='S') {
			if(mapa[posi+1][posj]==7||mapa[posi+1][posj]==6||mapa[posi+1][posj]==5) {
				mapa[posi][posj]=1;	
				}else {
					if(mapa[posi+1][posj]==11) {
						mapa[posi][posj]=auxp;
						auxp=mapa[posi+2][posj];
						mapa[posi+2][posj]=1;
						posi=posi+2;
					}else {
						if(mapa[posi+1][posj]==2) {
							mapa[posi][posj]=auxp;
							auxp=mapa[posi+1][posj];
							mapa[posi+1][posj]=39;
							posi++;
						}else {
							mapa[posi][posj]=auxp;
							auxp=mapa[posi+1][posj];
							mapa[posi+1][posj]=1;
							posi++;
						}
						if(mapa[posi][posj]==39||mapa[posi][posj]==40||mapa[posi][posj]==41||mapa[posi][posj]==42) {
							int random = (int) (Math.random()*5);
							if(random%2==0&&equipo[0].hp>0) {
								combates=true;
							}
						}
					}}
		}
		if(movimiento=='a'||movimiento=='A') {
			if(mapa[posi][posj-1]==7||mapa[posi][posj-1]==5||mapa[posi][posj-1]==6||mapa[posi][posj-1]==11) {
				mapa[posi][posj]=8;	
				}else {
					if(mapa[posi][posj-1]==2) {
						mapa[posi][posj]=auxp;
						auxp=mapa[posi][posj-1];
						mapa[posi][posj-1]=40;
						posj--;
					}else {
						mapa[posi][posj]=auxp;
						auxp=mapa[posi][posj-1];
						mapa[posi][posj-1]=8;
						posj--;
					}
					if(mapa[posi][posj]==39||mapa[posi][posj]==40||mapa[posi][posj]==41||mapa[posi][posj]==42) {
						int random = (int) (Math.random()*5);
						if(random%2==0&&equipo[0].hp>0) {
							combates=true;
						}
					}
				}
		}
		if(movimiento=='d'||movimiento=='D') {
			if(mapa[posi][posj+1]==7||mapa[posi][posj+1]==6||mapa[posi][posj+1]==5||mapa[posi][posj+1]==11) {
				mapa[posi][posj]=9;
			}else {
				if(mapa[posi][posj+1]==2) {
					mapa[posi][posj]=auxp;
					auxp=mapa[posi][posj+1];
					mapa[posi][posj+1]=41;
					posj++;
				}else {
					mapa[posi][posj]=auxp;
					auxp=mapa[posi][posj+1];
					mapa[posi][posj+1]=9;
					posj++;
				}
				if(mapa[posi][posj]==39||mapa[posi][posj]==40||mapa[posi][posj]==41||mapa[posi][posj]==42) {
					int random = (int) (Math.random()*5);
					if(random%2==0&&equipo[0].hp>0) {
						combates=true;
					}
				}
			}
		}
	}
	
	private static void accion() {
		// diferentes opciones al pulsar la "c", como curar, o acceder al pc
		
		if((mapa[posi+1][posj]==6&&mapa[posi][posj]==1)||(mapa[posi-1][posj]==6&&mapa[posi][posj]==10)||(mapa[posi][posj+1]==6&&mapa[posi][posj]==9)||(mapa[posi][posj-1]==6&&mapa[posi][posj]==8)) {
			
			//mira la posicion del healer para saber donde modificarlo a la hora de curar
			
			if((mapa[posi+1][posj]==6&&mapa[posi][posj]==1)){
				healerx=posi+1;
				healery=posj;
			}
			
			if((mapa[posi-1][posj]==6&&mapa[posi][posj]==10)) {
				healerx=posi-1;
				healery=posj;
			}
			
			if((mapa[posi][posj+1]==6&&mapa[posi][posj]==9)) {
				healerx=posi;
				healery=posj+1;
			}
			
			if((mapa[posi][posj-1]==6&&mapa[posi][posj]==8)) {
				healerx=posi;
				healery=posj-1;
			}
			
			//reestablece vida y pps de los ataques de todo el equipo
			
			for(int i=0; i<6; i++) {
				equipo[i].hp=equipo[i].maxhp;
				equipo[i].a1pp=equipo[0].a1maxpp;
				equipo[i].a2pp=equipo[0].a2maxpp;
				equipo[i].a3pp=equipo[0].a3maxpp;
				equipo[i].a4pp=equipo[0].a4maxpp;
			}
			
			estado=7;//healer
		
		} else {
			if(mapa[posi-1][posj]==5&&mapa[posi][posj]==10) {
				posmenupci=0;
				estado=9; // menu del pc
			}
		}
		
	}
	
	private static Pokemon salvaje() {
		// genera el pokemon salvaje
		
		Pokemon salvaje = new Pokemon();
		salvaje.npokedex = (int) ((Math.random())*3);
		switch(salvaje.npokedex) {
		
		case 0:  //pikachu
			
			salvaje.nivel = (int) (4 + Math.random()*5);
			salvaje.hp = 10;
			salvaje.atk = 5;
			salvaje.satk = 5;
			salvaje.def = 5;
			salvaje.sdef = 5;
			salvaje.spd = 5;
			
			for(int i=0; i<salvaje.nivel; i++) {
				salvaje.hp = (int) (salvaje.hp + 5 + Math.random()*5);
				salvaje.atk = (int) (salvaje.atk + Math.random()*3);
				salvaje.satk =(int) (salvaje.satk + Math.random()*3);
				salvaje.def = (int) (salvaje.def + Math.random()*3);
				salvaje.sdef = (int) (salvaje.sdef + Math.random()*3);
				salvaje.spd = (int) (salvaje.spd + Math.random()*3);
			}
			
			for(int i=0; i<2; i++) {
				salvaje.totexp = salvaje.totexp + (salvaje.nivel*salvaje.nivel);  
			}
			
			salvaje.maxhp = salvaje.hp;
			salvaje.exp = 0;
			salvaje.nombre = "Pikachu";
			salvaje.type1 = "Eléctrico";
			salvaje.type2 = " ";
			salvaje.a1name = "Impactrueno";
			salvaje.a1type = "Eléctrico";
			salvaje.a1pwr = 40;
			salvaje.a1acc = 100;
			salvaje.a1maxpp = 20;
			salvaje.a1pp = salvaje.a1maxpp;
			salvaje.a1cty = 1;
			salvaje.a2name = "Placaje";
			salvaje.a2type = "Eléctrico";
			salvaje.a2pwr = 40;
			salvaje.a2acc = 100;
			salvaje.a2maxpp = 20;
			salvaje.a2pp = salvaje.a1maxpp; 
			salvaje.a2cty = 1;
			salvaje.a3name = "Gruñido";
			salvaje.a3type = "Eléctrico";
			salvaje.a3pwr = 40;
			salvaje.a3acc = 100;
			salvaje.a3maxpp = 20;
			salvaje.a3pp = salvaje.a1maxpp;
			salvaje.a3cty = 1;
			salvaje.a4name = "Rayo";
			salvaje.a4type = "Eléctrico";
			salvaje.a4pwr = 40;
			salvaje.a4acc = 100;
			salvaje.a4maxpp = 20;
			salvaje.a4pp = salvaje.a1maxpp; 
			salvaje.a4cty = 1;
			break;
		case 1:  //pidgey
			salvaje.nivel = (int) (4 + Math.random()*5);
			salvaje.hp = 10;
			salvaje.atk = 5;
			salvaje.satk = 5;
			salvaje.def = 5;
			salvaje.sdef = 5;
			salvaje.spd = 5;
			
			for(int i=0; i<salvaje.nivel; i++) {
				salvaje.hp = (int) (salvaje.hp + 5 + Math.random()*5);
				salvaje.atk = (int) (salvaje.atk + Math.random()*3);
				salvaje.satk =(int) (salvaje.satk + Math.random()*3);
				salvaje.def = (int) (salvaje.def + Math.random()*3);
				salvaje.sdef = (int) (salvaje.sdef + Math.random()*3);
				salvaje.spd = (int) (salvaje.spd + Math.random()*3);
			}
			
			for(int i=0; i<2; i++) {
				salvaje.totexp = salvaje.totexp + (salvaje.nivel*salvaje.nivel);  
			}
			
			salvaje.maxhp = salvaje.hp;
			salvaje.exp = 0;
			salvaje.nombre = "Pidgey";
			salvaje.type1 = "Normal";
			salvaje.type2 = "Volador";
			salvaje.a1name = "Placaje";
			salvaje.a1type = "Normal";
			salvaje.a1pwr = 40;
			salvaje.a1acc = 100;
			salvaje.a1maxpp = 20;
			salvaje.a1pp = salvaje.a1maxpp;
			salvaje.a1cty = 1;
			salvaje.a2name = "Gruñido";
			salvaje.a2type = "Normal";
			salvaje.a2pwr = 40;
			salvaje.a2acc = 100;
			salvaje.a2maxpp = 20;
			salvaje.a2pp = salvaje.a1maxpp; 
			salvaje.a2cty = 1;
			salvaje.a3name = "Ataque ala";
			salvaje.a3type = "Volador";
			salvaje.a3pwr = 40;
			salvaje.a3acc = 100;
			salvaje.a3maxpp = 20;
			salvaje.a3pp = salvaje.a1maxpp; 
			salvaje.a3cty = 1;
			salvaje.a4name = "Picotazo";
			salvaje.a4type = "Volador";
			salvaje.a4pwr = 40;
			salvaje.a4acc = 100;
			salvaje.a4maxpp = 20;
			salvaje.a4pp = salvaje.a1maxpp;
			salvaje.a4cty = 1;
			break;
		case 2:  //growlithe
			salvaje.nivel = (int) (4 + Math.random()*5);
			salvaje.hp = 10;
			salvaje.atk = 5;
			salvaje.satk = 5;
			salvaje.def = 5;
			salvaje.sdef = 5;
			salvaje.spd = 5;
			
			for(int i=0; i<salvaje.nivel; i++) {
				salvaje.hp = (int) (salvaje.hp + 5 + Math.random()*5);
				salvaje.atk = (int) (salvaje.atk + Math.random()*3);
				salvaje.satk =(int) (salvaje.satk + Math.random()*3);
				salvaje.def = (int) (salvaje.def + Math.random()*3);
				salvaje.sdef = (int) (salvaje.sdef + Math.random()*3);
				salvaje.spd = (int) (salvaje.spd + Math.random()*3);
			}
			
			for(int i=0; i<2; i++) {
				salvaje.totexp = salvaje.totexp + (salvaje.nivel*salvaje.nivel);  
			}
			
			salvaje.maxhp = salvaje.hp;
			salvaje.exp = 0;
			salvaje.nombre = "Growlithe";
			salvaje.type1 = "Fuego";
			salvaje.type2 = " ";
			salvaje.a1name = "Placaje";
			salvaje.a1type = "Normal";
			salvaje.a1pwr = 40;
			salvaje.a1acc = 100;
			salvaje.a1maxpp = 20;
			salvaje.a1pp = salvaje.a1maxpp;
			salvaje.a1cty = 1;
			salvaje.a2name = "Gruñido";
			salvaje.a2type = "Normal";
			salvaje.a2pwr = 40;
			salvaje.a2acc = 100;
			salvaje.a2maxpp = 20;
			salvaje.a2pp = salvaje.a1maxpp; 
			salvaje.a2cty = 1;
			salvaje.a3name = "Ascuas";
			salvaje.a3type = "Fuego";
			salvaje.a3pwr = 40;
			salvaje.a3acc = 100;
			salvaje.a3maxpp = 20;
			salvaje.a3pp = salvaje.a1maxpp; 
			salvaje.a3cty = 1;
			salvaje.a4name = " ";
			salvaje.a4type = " ";
			salvaje.a4pwr = 0;
			salvaje.a4acc = 0;
			salvaje.a4maxpp = 0;
			salvaje.a4pp = salvaje.a1maxpp; 
			salvaje.a4cty = 1;
			break;
		}
		return salvaje;
	}
	
	private static int[][] mostrarcombate(Pokemon enemigo, int[][] combate2) {
		// creacion del hud de combate
		String p;
		String v2="";
		t.setActimatges(true);
		t.setActimgbackground(true);
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				combate2[i][j]=28;
			}
		}
		
		switch(enemigo.npokedex) {
		case 0: // pikachu
			combate2[0][2]=30;
			break;
		case 1: // pidgey
			combate2[0][2]=31;
			break;
		case 2: //growlithe
			combate2[0][2]=32;
			break;
		}
		switch(equipo[0].npokedex) {
		case 0: // pikachu
			combate2[1][0]=33;
			break;
		case 1: // pidgey
			combate2[1][0]=34;
			break;
		case 2: //growlithe
			combate2[1][0]=35;
			break;
		}
		
		int porcentajepoke=0;
		int porcentajesalvaje=0;
		porcentajepoke = (equipo[0].hp*100);
		porcentajepoke = porcentajepoke / equipo[0].maxhp;
		
		porcentajesalvaje = (enemigo.hp*100);
		porcentajesalvaje = porcentajesalvaje / enemigo.maxhp;
		
		int porcentaje=0;
		int x=0;
		int y=0;
		int vida=0;
		
		for(int i=0; i<2; i++) {
			
			if(i==0) {
				porcentaje=porcentajepoke;
				x=2; y=0;
				
			}else {
				if(i==1) {
					porcentaje=porcentajesalvaje;
					x = 1; y = 2;
					
				}
			}
			
			
			combate2[x][y]=fotoshp[porcentaje];
				
		}
		
		v2="";
		
		for(int c=0; c<3; c++) {
			for(int b=0; b<3; b++) {
				v2 = v2 + combate2[c][b];
			}
		}
		
		a++;

		return combate2;
	}
	
	private static void opcioncombate() {
		// menu para elejir la opcion en combate (luchar, bolsa, huir o equipo)
		
			if(poshudi==0&&poshudj==1) {
				menuopcioncombate[0][0]=28;
				t2.setImgbackground("combateluchar2.jpg");
			}
			if(poshudi==1&&poshudj==0) {
				menuopcioncombate[0][0]=28;
				t2.setImgbackground("combatebolsa2.jpg");
			}
			if(poshudi==1&&poshudj==1) {
				menuopcioncombate[0][0]=28;
				t2.setImgbackground("combatehuir2.jpg");
			}
			if(poshudi==1&&poshudj==2) {
				menuopcioncombate[0][0]=28;
				t2.setImgbackground("combateequipo2.jpg");
			}
			
			//calcula el numero de pokemons usables
			if(equipo[0].hp<=0) {
				equipo[0].hp=0;
				numpoke--;
				if(numpoke>0) {
					estado=4; // equipo
				}else {
					estado=0; //mundo
				}
			}
			
			
			String lucharv="";
			for(int i=0; i<1; i++) {
				for(int j=0; j<1; j++) {
					lucharv = lucharv + menuopcioncombate[i][j]+" ";
				}lucharv = lucharv + "\n";
			}
			
			combate2 = mostrarcombate(enemigo, combate3);
			String combate2v="";
			
			for(int d=0; d<3; d++) {
				for(int s=0; s<3; s++) {
					combate2v = combate2v + combate2[d][s];
				}
			}
			
			int[][] lvls = new int[10][6];
			String lvlsv="";
			for(int i=0; i<10; i++) {
				for(int j=0; j<6; j++) {
					lvls[i][j]=28;
				}
			}
			
			lvls[7][1] = fotoslvl[equipo[0].nivel-1];
			lvls[4][5] = fotoslvl[enemigo.nivel-1];
			
			for(int i=0; i<10; i++) {
				for(int j=0; j<6; j++) {
					lvlsv = lvlsv + lvls[i][j];
				}
			}
			
			t.setImgbackground("backgroundcombate.jpg");
			t2.dibuixa(menuopcioncombate);
			t.dibuixa(combate2);
			t.overdibuixa(lvls);
			System.out.println(lucharv);
			System.out.println(combate2v);
			System.out.println(lvlsv);
			int prioridad=0;
			
			// moverse por el menu
			char poshud = f.getActualChar();
			switch(poshud) {
			case 'w': case 'W':
				if(poshudi==1) {
					poshudi=0; poshudj=1;
				} else {
					if(poshudi==0) {
						
					}
				}
				break;
			case 's': case 'S':
				if(poshudi==1) {
					
				} else {
					if(poshudi==0) {
						poshudi=1; poshudj=0;
					}
				}
				break;
			case 'a': case 'A':
				if(poshudi==0) {
					poshudi=1; poshudj=0;
				} else {
					if(poshudi==1&&poshudj==2) {
						poshudi=1; poshudj=1;
					} else {
						if(poshudi==1&&poshudj==1) {
							poshudi=1; poshudj=0;
						} else {
							if(poshudi==1&&poshudj==0) {
								
							}
						}
					}
				}
				break;
			case 'd': case 'D':
				if(poshudi==0) {
					poshudi=1; poshudj=2;
				} else {
					if(poshudi==1&&poshudj==0) {
						poshudi=1; poshudj=1;
					} else {
						if(poshudi==1&&poshudj==1) {
							poshudi=1; poshudj=2;
						} else {
							if(poshudi==1&&poshudj==2) {
								
							}
						}
					}
				}
				break;
			case 'c': case 'C':
				a=0;
				ataqueescojido=0;
				if(poshudi==0) {
					
					// caso que no queden pps en ningun ataque
					if(equipo[0].a1pp==0&&equipo[0].a2pp==0&&equipo[0].a3pp==0&&equipo[0].a4pp==0) {
						enemigo.hp = enemigo.hp - ((equipo[0].atk+equipo[0].satk)/(2));
						if(enemigo.hp<=0) {
							estado=2; //mostrar vida
						}
						equipo[0].hp = equipo[0].hp - ((equipo[0].atk+equipo[0].satk)/(2));
						if(equipo[0].hp<=0) {
							equipo[0].hp=0;
							numpoke--;
							if(numpoke>0) {
								
								for(int i=0; i<10; i++) {
									for(int j=0; j<6; j++) {
										lvls[i][j]=28;
									}
								}
								t.dibuixa(lvls);
								
								estado=4; // equipo
							}else {
								estado=2;//mostrar vida
							}
						}
					}else {
						//caso que queden pps en algun ataque
						estado=5; // ataques
					}
				} else { ///entrar al menu de la bolsa
					if(poshudi==1&&poshudj==0) {
						estado=10; // bolsa
					} else { // intentar huir
						if(poshudi==1&&poshudj==1) {
							int huir = (int) (Math.random()*3);
							if(huir==1) {
								
								for(int i=0; i<10; i++) {
									for(int j=0; j<6; j++) {
										lvls[i][j]=28;
									}
								}
								t.dibuixa(lvls);
								
								combates=false;
								estado=0; //mundo
							} else {
								dañoapoke(enemigo);
								if(equipo[0].hp<=0) {
									equipo[0].hp=0;
									numpoke--;
									if(numpoke>0) {
										
										for(int i=0; i<10; i++) {
											for(int j=0; j<6; j++) {
												lvls[i][j] = 28;
											}
										}
										t.overdibuixa(lvls);
										
										estado=4; // equipo
									}else {
										estado=2; // mostrar vida
									}
								}
							}
							
						} else {// cambiar de pokemon en el equipo
							if(poshudi==1&&poshudj==2) {
								
								for(int i=0; i<10; i++) {
									for(int j=0; j<6; j++) {
										lvls[i][j] = 28;
									}
								}
								t.overdibuixa(lvls);
								
								estado=4;// equipo
							}
						}
					}
				}
				break;
			}
			
	}
	
	private static int verrapidez(Pokemon enemigo) {
		// mirar la prioridad del atacante
		// prioridad=1, el pokemon propio es mas rapido que el salvaje
		// prioridad=2, el pokemon salvaje es mas rapido que el pokemon propio
		// en caso de empate se hace un random
		int prioridad = 0;
		int spdpoke = equipo[0].spd;
		int spdsalvaje = enemigo.spd;
		if(spdpoke>spdsalvaje) {
			prioridad=1;
		}else {
			if(spdpoke<spdsalvaje) {
				prioridad=2;
			}else {
				if(spdpoke==spdsalvaje) {
					int random = (int) (Math.random()*2);
					if(random==0) {
						prioridad=1;
					}else {
						if(random==1) {
							prioridad=2;
						}
					}
				}
			}
		}
		return prioridad;
	}
	
	private static void ataques() {
		// seleccion de ataques en combate
		
		int[][] atques = new int[6][2];
		
		int x1=0; int x2=0; int x3=0;
		int y1=0; int y2=0; int y3=0;
		
		String ataque = "";
		String type = "";
		int pps = 0;
		//inicializacion de los array
		for(int i=0; i<6; i++) {
			for(int j=0; j<2; j++) {
				atques[i][j]=28;
			}
		}
		
		// mostrar ataques
		for(int i=0; i<4; i++) {
			
			switch(i) {
			case 0:
				x1=0; y1=0;
				x2=1; y2=0;
				x3=2; y3=0;
				ataque = equipo[0].a1name;
				type = equipo[0].a1type;
				pps = equipo[0].a1pp;
				break;
			case 1:
				x1=0; y1=1;
				x2=1; y2=1;
				x3=2; y3=1;
				ataque = equipo[0].a2name;
				type = equipo[0].a2type;
				pps = equipo[0].a2pp;
				break;
			case 2:
				x1=3; y1=0;
				x2=4; y2=0;
				x3=5; y3=0;
				ataque = equipo[0].a3name;
				type = equipo[0].a3type;
				pps = equipo[0].a3pp;
				break;
			case 3:
				x1=3; y1=1;
				x2=4; y2=1;
				x3=5; y3=1;
				ataque = equipo[0].a4name;
				type = equipo[0].a4type;
				pps = equipo[0].a4pp;
				break;
			}
			
			switch(ataque) {
			case "Placaje":
				atques[x1][y1]=54;
				break;
			case "Impactrueno":
				atques[x1][y1]=119;
				break;
			case "Picotazo":
				atques[x1][y1]=121;
				break;
			case "Gruñido":
				atques[x1][y1]=123;
				break;
			case "Rayo":
				atques[x1][y1]=125;
				break;
			case "Ataque ala":
				atques[x1][y1]=127;
				break;
			case "Ascuas":
				atques[x1][y1]=129;
				break;
			}
			
			switch(type) {
			case "Normal": atques[x2][y2]=56; break;
			case "Acero": atques[x2][y2]=61; break;
			case "Agua": atques[x2][y2]=62; break;
			case "Fuego": atques[x2][y2]=63; break;
			case "Siniestro": atques[x2][y2]=64; break;
			case "Psíquico": atques[x2][y2]=65; break;
			case "Bicho": atques[x2][y2]=66; break;
			case "Hada": atques[x2][y2]=67; break;
			case "Tierra": atques[x2][y2]=68; break;
			case "Roca": atques[x2][y2]=69; break;
			case "Fantasma": atques[x2][y2]=70; break;
			case "Dragón": atques[x2][y2]=71; break;
			case "Hielo": atques[x2][y2]=72; break;
			case "Volador": atques[x2][y2]=73; break;
			case "Planta": atques[x2][y2]=74; break;
			case "Veneno": atques[x2][y2]=75; break;
			case "Eléctrico": atques[x2][y2]=76; break;
			case "Lucha": atques[x2][y2]=77; break;
			}
			
			atques[x3][y3]=fotospp[pps];
			
		}
		
		String atquesv = "";
		for(int i=0; i<6; i++) {
			for(int j=0; j<2; j++) {
				atquesv = atquesv + atques[i][j];
			}
		}
		// ver posicion
		int seleccion1=28; int seleccion2=28; int seleccion3=28; int seleccion4=28;
		
		if(posluchari==0&&poslucharj==0) {
			seleccion1=131;
		}
		if(posluchari==0&&poslucharj==1) {
			seleccion2=131;
		}
		if(posluchari==3&&poslucharj==0) {
			seleccion3=131;
		}
		if(posluchari==3&&poslucharj==1) {
			seleccion4=131;
		}
		
		int[][] matriuover =
        	{
            		{seleccion1,seleccion2,},
            		{seleccion3,seleccion4,},
        	};
	 
		t2.overdibuixa(matriuover);
		t2.setImgbackground("backgroundopcion.jpg");
		t2.dibuixa(atques);
		
		System.out.println(atquesv);
		
		
		// movimiento por el menu deataques
		char menuataques = f.getActualChar();
		
		switch(menuataques) {
		case 'w': case 'W':
			if(posluchari==0) {
				
			}else {
				if(posluchari==3) {
					posluchari = posluchari - 3;
				}
			}
			break;
		case 's': case 'S':
			if(posluchari==3) {
				
			}else {
				if((posluchari==0&&poslucharj==0&&(atques[posluchari+3][poslucharj]!=28))||(posluchari==0&&poslucharj==1&&(atques[posluchari+3][poslucharj]!=28))) {
					posluchari = posluchari + 3;
				}
			}
			
			break;
		case 'a': case 'A':
			if(poslucharj==0) {
				
			}else {
				if(poslucharj==1) {
					poslucharj--;
				}
			}
			break;
		case 'd': case 'D':
			if(poslucharj==1) {
				
			}else {
				if(poslucharj==0&&atques[posluchari][poslucharj+1]!=28) {
					poslucharj++;
				}
			}
			break;
		case 'c': case 'C':
			
			if(posluchari==0&&poslucharj==0&&equipo[0].a1pp>0) {
				ataqueescojido=1;
				equipo[0].a1pp--;
				matriuover[0][0] = 28;
				matriuover[0][1] = 28;
				matriuover[1][0] = 28;
				matriuover[1][1] = 28;
				t2.overdibuixa(matriuover);
				estado=6;
			}
			if(posluchari==0&&poslucharj==1&&equipo[0].a2pp>0) {
				ataqueescojido=2;
				equipo[0].a2pp--;
				matriuover[0][0] = 28;
				matriuover[0][1] = 28;
				matriuover[1][0] = 28;
				matriuover[1][1] = 28;
				t2.overdibuixa(matriuover);
				estado=6;
			}
			if(posluchari==3&&poslucharj==0&&equipo[0].a3pp>0) {
				ataqueescojido=3;
				equipo[0].a3pp--;
				matriuover[0][0] = 28;
				matriuover[0][1] = 28;
				matriuover[1][0] = 28;
				matriuover[1][1] = 28;
				t2.overdibuixa(matriuover);
				estado=6;
			}
			if(posluchari==3&&poslucharj==1&&equipo[0].a4pp>0) {
				ataqueescojido=4;
				equipo[0].a4pp--;
				matriuover[0][0] = 28;
				matriuover[0][1] = 28;
				matriuover[1][0] = 28;
				matriuover[1][1] = 28;
				t2.overdibuixa(matriuover);
				estado=6;
			}
			break;
		case 'e': case 'E':
			/// vuelve el menu de combate
			matriuover[0][0] = 28;
			matriuover[0][1] = 28;
			matriuover[1][0] = 28;
			matriuover[1][1] = 28;
			t2.overdibuixa(matriuover);
			estado=1; //combate
			break;
		}
		
	}
	
	private static Pokemon daño(Pokemon enemigo, int prioridad) {
		// orden de ataque en funcion de la prioridad (funcion verrapidez)
		
		switch(prioridad) {
		case 1:
			vidamaxsalvaje=((enemigo.hp*100)/enemigo.maxhp);
			dañoasalvaje(enemigo);
			vidasalvaje=((enemigo.hp*100)/enemigo.maxhp);
			if(vidasalvaje<0) {
				vidasalvaje=0;
			}
			if(enemigo.hp<=0) {
				combates=false;
				estado=2;//mostrar como baja la vida
			}else {
				vidamaxpoke=((equipo[0].hp*100)/equipo[0].maxhp);
				dañoapoke(enemigo);
				vidapoke=((equipo[0].hp*100)/equipo[0].maxhp);
				if(vidapoke<0) {
					vidapoke=0;
				}
				if(equipo[0].hp<=0) {
					equipo[0].hp=0;
					numpoke--;
					if(numpoke>0) {
						estado=4;//equipo
					}else {
						combates=false;
						estado=2;//mostrar como baja la vida
					}
					
				}
			}
			
			break;
		case 2:
			vidamaxpoke=((equipo[0].hp*100)/equipo[0].maxhp);
			dañoapoke(enemigo);
			vidapoke=((equipo[0].hp*100)/equipo[0].maxhp);
			if(vidapoke<0) {
				vidapoke=0;
			}
			if(equipo[0].hp<=0) {
				equipo[0].hp=0;
				numpoke--;
				if(numpoke>0) {
					estado=4;//equipo
				}else {
					
					estado=2;//mostrar como baja la vida
				}
			}else {
				vidamaxsalvaje=((enemigo.hp*100)/enemigo.maxhp);
				dañoasalvaje(enemigo);
				vidasalvaje=((enemigo.hp*100)/enemigo.maxhp);
				if(vidasalvaje<0) {
					vidasalvaje=0;
				}
				if(enemigo.hp<=0&&estado!=2) {
					combates=false;
					estado=2;//mostrar como baja la vida
				}
			}
			break;
		}
		
		if(enemigo.hp>0) {
			estado=2;//mostrar como baja la vida
		}
		return enemigo;
	}
	
	private static void dañoapoke(Pokemon enemigo) {
		// daño que recibe tu pokemon
		
		String anameescojido="";
		String atypeescojido="";
		int apwrescojido=0;
		int amaxppescojido=0;
		int appescojido=0;
		int aaccescojido=0;
		int actyescojido=0;
		double daño=0;
		double stab=0;
		
		int ataqueescojidosalvaje = (int) (Math.random()*4);
		
		// random dle ataque dle salvaje
		while((ataqueescojidosalvaje==0&&(enemigo.a1name==" "||enemigo.a1name==""))||(ataqueescojidosalvaje==1&&(enemigo.a2name==" "||enemigo.a2name==""))||(ataqueescojidosalvaje==2&&(enemigo.a3name==" "||enemigo.a3name==""))||(ataqueescojidosalvaje==3&&(enemigo.a4name==" "||enemigo.a4name==""))){
			ataqueescojidosalvaje = (int) (Math.random()*4);
		}
		
			switch(ataqueescojidosalvaje) {
			case 0:
				anameescojido=enemigo.a1name;
				atypeescojido=enemigo.a1type;
				apwrescojido=enemigo.a1pwr;
				appescojido=enemigo.a1pp;
				amaxppescojido=enemigo.a1maxpp;
				aaccescojido=enemigo.a1acc;
				actyescojido=enemigo.a1cty;
				break;
			case 1:
				anameescojido=enemigo.a2name;
				atypeescojido=enemigo.a2type;
				apwrescojido=enemigo.a2pwr;
				appescojido=enemigo.a2pp;
				amaxppescojido=enemigo.a2maxpp;
				aaccescojido=enemigo.a2acc;
				actyescojido=enemigo.a2cty;
				break;
			case 2:
				anameescojido=enemigo.a3name;
				atypeescojido=enemigo.a3type;
				apwrescojido=enemigo.a3pwr;
				appescojido=enemigo.a3pp;
				amaxppescojido=enemigo.a3maxpp;
				aaccescojido=enemigo.a3acc;
				actyescojido=enemigo.a3cty;
				break;
			case 3:
				anameescojido=enemigo.a4name;
				atypeescojido=enemigo.a4type;
				apwrescojido=enemigo.a4pwr;
				appescojido=enemigo.a4pp;
				amaxppescojido=enemigo.a4maxpp;
				aaccescojido=enemigo.a4acc;
				actyescojido=enemigo.a4cty;
				break;
			}
			
			// calculo daño
			if(atypeescojido==enemigo.type1||atypeescojido==enemigo.type2) {
				stab = 1.5;
			}
			
			int ruta = 2;
			double debilidad = tabladetipos(enemigo, ruta, atypeescojido);
			
			daño = debilidad + stab;
			int dañorealizado=0;
			
			if(actyescojido==0) {
				dañorealizado= (int) ((enemigo.atk-equipo[0].def)*daño);
			}else {
				if(actyescojido==1) {
					dañorealizado= (int) ((enemigo.satk-equipo[0].sdef)*daño);
				}
			}
			
			if(dañorealizado<=0) {
				dañorealizado=(int) (1*daño);
			}
				
				equipo[0].hp = (int) (equipo[0].hp - dañorealizado);
				
	
	}

	private static Pokemon dañoasalvaje(Pokemon enemigo) {
		// lo mismo que en la funion de dañoapoke pero al reves
		
		String anameescojido="";
		String atypeescojidosalvaje="";
		int apwrescojido=0;
		int amaxppescojido=0;
		int appescojido=0;
		int aaccescojido=0;
		int actyescojido=0;
		double daño=0;
		double stab=0;
		
		switch(ataqueescojido) {
		case 1:
			anameescojido=equipo[0].a1name;
			atypeescojidosalvaje=equipo[0].a1type;
			apwrescojido=equipo[0].a1pwr;
			amaxppescojido=equipo[0].a1maxpp;
			appescojido=equipo[0].a1pp;
			aaccescojido=equipo[0].a1acc;
			actyescojido=equipo[0].a1cty;
			break;
		case 2:
			anameescojido=equipo[0].a2name;
			atypeescojidosalvaje=equipo[0].a2type;
			apwrescojido=equipo[0].a2pwr;
			amaxppescojido=equipo[0].a2maxpp;
			appescojido=equipo[0].a2pp;
			aaccescojido=equipo[0].a2acc;
			actyescojido=equipo[0].a2cty;
			break;
		case 3:
			anameescojido=equipo[0].a3name;
			atypeescojidosalvaje=equipo[0].a3type;
			apwrescojido=equipo[0].a3pwr;
			amaxppescojido=equipo[0].a3maxpp;
			appescojido=equipo[0].a3pp;
			aaccescojido=equipo[0].a3acc;
			actyescojido=equipo[0].a3cty;
			break;
		case 4:
			anameescojido=equipo[0].a4name;
			atypeescojidosalvaje=equipo[0].a4type;
			apwrescojido=equipo[0].a4pwr;
			amaxppescojido=equipo[0].a4maxpp;
			appescojido=equipo[0].a4pp;
			aaccescojido=equipo[0].a4acc;
			actyescojido=equipo[0].a4cty;
			break;
		}
		
		if(equipo[0].type1==atypeescojidosalvaje||equipo[0].type2==atypeescojidosalvaje) {
			stab = 1.5;
		}
		
		int ruta=1;
		double debilidad = tabladetipos(enemigo, ruta, atypeescojidosalvaje);
		
		daño = debilidad + stab;
		int dañorealizado=0;
		if(actyescojido==0) {
			dañorealizado= (int) ((equipo[0].atk-enemigo.def)*daño);
		}else {
			if(actyescojido==1) {
				dañorealizado= (int) ((equipo[0].satk-enemigo.sdef)*daño);
			}
		}
		
		if(dañorealizado<=0) {
			dañorealizado=(int) (1*daño);
		}
			
			enemigo.hp = (int) (enemigo.hp - dañorealizado);
			
		
		return enemigo;

	}

	private static double tabladetipos(Pokemon enemigo, int ruta, String atypeescojido) {
		// tabla de tipos para ver debilidades
		
		String typeataqueatacante="";
		String type1defensor="";
		String type2defensor="";
		double debilidad=1;
		int x=0;
		int y=0;
		int y2=0;
		
		switch(ruta) {
		case 1:///para mirar la tabla en contra de el enemigo
			typeataqueatacante=atypeescojido;
			type1defensor=enemigo.type1;
			type2defensor=enemigo.type2;
			break;
		case 2:///para mirar la tabla en contra de tu pokemon
			typeataqueatacante=atypeescojido;
			type1defensor=equipo[0].type1;
			type2defensor=equipo[0].type2;
			break;
		}
		
		Tablatipos tipo = new Tablatipos();
		
		switch(typeataqueatacante) {
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
		
		switch(type1defensor) {
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
		
		switch(type2defensor) {
		case "Acero": y2 = 0; break;
		case "Agua": y2 = 1; break;
		case "Bicho": y2 = 2; break;
		case "Dragón": y2 = 3; break;
		case "Eléctrico": y2 = 4; break;
		case "Fantasma": y2 = 5; break;
		case "Fuego": y2 = 6; break;
		case "Hada": y2 = 7; break;
		case "Hielo": y2 = 8; break;
		case "Lucha": y2 = 9; break;
		case "Normal": y2 = 10; break;
		case "Planta": y2 = 11; break;
		case "Psíquico": y2 = 12; break;
		case "Roca": y2 = 13; break;
		case "Siniestro": y2 = 14; break;
		case "Tierra": y2 = 15; break;
		case "Veneno": y2 = 16; break;
		case "Volador": y2 = 17; break;
		}
		
		//si el salvaje tiene u  tipo o dos
		for(int i=0; i<2; i++) {
			if(i==0) {
				debilidad = tipo.tabla[x][y];
			}else {
				if(i==1) {
					if((enemigo.type2!=""||enemigo.type2!=" ")) {
						debilidad = debilidad * tipo.tabla[x][y2];
					}
				}
			}
		}
		
		return debilidad;
	}
	
	private static void bolsa(Pokemon enemigo) {
		//opciones de bolsa 
		
		int[][] bolsa = new int[1][1];
		String bolsav="";
		
		
		
			if(accionbolsa==1) {
				bolsa[0][0]=28;
				t2.setImgbackground("menubolsa1.jpg");
			}
			if(accionbolsa==2) {
				bolsa[0][0]=28;
				t2.setImgbackground("menubolsa2.jpg");
			}
			if(accionbolsa==3) {
				bolsa[0][0]=28;
				t2.setImgbackground("menubolsa3.jpg");
			}
			if(accionbolsa==4) {
				bolsa[0][0]=28;
				t2.setImgbackground("menubolsa4.jpg");
			}
			for(int i=0; i<1; i++) {
				bolsav = bolsav + bolsa[i];
			}
			t2.dibuixa(bolsa);
			
			//movimiento por el menu de la bolsa
			char opcionbolsa=f.getActualChar();
			switch(opcionbolsa) {
			case 'w': case 'W':
				if(posbolsai==0) {
					
				}else {
					if(posbolsaj==0) {
						accionbolsa=1;
						posbolsai--;
					}else {
						if(posbolsaj==1) {
							accionbolsa=2;
							posbolsai--;
						}
					}
				}
				break;
			case 's': case 'S':
				if(posbolsai==1) {
					
				}else {
					if(posbolsaj==0) {
						accionbolsa=3;
						posbolsai++;
					}else {
						if(posbolsaj==1) {
							accionbolsa=4;
							posbolsai++;
						}
					}
				}
				break;
			case 'a': case 'A':
				if(posbolsaj==0) {
					
				}else {
					if(posbolsai==0) {
						accionbolsa=1;
						posbolsaj--;
					}else {
						if(posbolsai==1) {
							accionbolsa=3;
							posbolsaj--;
						}
					}
				}
				break;
			case 'd': case 'D':
				if(posbolsaj==1) {
					
				}else {
					if(posbolsai==0) {
						accionbolsa=2;
						posbolsaj++;
					}else {
						if(posbolsai==1) {
							accionbolsa=4;
							posbolsaj++;
						}
					}
				}
				break;
			case 'c': case 'C':
				/// de momento solo funcionan dos apartdos
				/// en el 1 cura el pokemon con un maxmo de 20 veces por combate
				/// en el dos cambia al estado 11, donde esta la funcion de captura
				if(accionbolsa==2) {
					contadorcaptura=0;
					estado=11;
				}else {
					if(accionbolsa==1) {
						if(numpociones>0) {
							equipo[0].hp = equipo[0].hp + 20;
							numpociones--;
							dañoapoke(enemigo);
							if(equipo[0].hp<=0) {
								equipo[0].hp=0;
								numpoke--;
								if(numpoke>0) {
									estado=4;
									//equipo();
								}else {
									estado=2;//mostrar como baja la vida
								}
							}
						}
						estado=1;
					}
				}
				break;
			case 'e': case 'E':
				//para salir del menu de la bolsa al menu de combate
				estado=1;
				break;
			}
		
	}
	
	private static void captura() {
		// con el timer y randoms hago tres random seguidos
		//// intercalando imagenes, 
		//////si los tres son "1" el pokemon salvaje se captura
		
		int captura=(int) (Math.random()*2);
		
		if(contadorcaptura<5){
			combate2[0][2]=140;
		}
		
		switch(contadorcaptura) {
		case 0:
			if(((100*enemigo.hp)/enemigo.maxhp)<40) {
				contadorcaptura++;
				combate2[0][2]=141;
			}else if(captura==1) {
				contadorcaptura++;
				combate2[0][2]=141;
			}else {
				dañoapoke(enemigo);
				if(equipo[0].hp<=0) {
					equipo[0].hp=0;
					numpoke--;
					if(numpoke>0) {
						estado=4; // equipo
					}else {
						estado=2;
					}
				}else {
					estado=1;
				}
			}
			break;
		case 1:
			contadorcaptura++;
			break;
		case 2:
			if(((100*enemigo.hp)/enemigo.maxhp)<20) {
				contadorcaptura++;
				combate2[0][2]=142;
			}else if(captura==1) {
				contadorcaptura++;
				combate2[0][2]=142;
			}else {
				dañoapoke(enemigo);
				if(equipo[0].hp<=0) {
					equipo[0].hp=0;
					numpoke--;
					if(numpoke>0) {
						estado=4; // equipo
					}else {
						estado=2;
					}
				}else {
					estado=1;
				}
			}
			break;
		case 3:
			contadorcaptura++;
			break;
		case 4:
			if(captura==1) {
				contadorcaptura++;
				combate2[0][2]=143;
			}else {
				dañoapoke(enemigo);
				if(equipo[0].hp<=0) {
					equipo[0].hp=0;
					numpoke--;
					if(numpoke>0) {
						estado=4; // equipo
					}else {
						estado=2;
					}
				}else {
					estado=1;
				}
			}
			
		break;
		case 5:
			contadorcaptura++;
			break;
		case 6:
			contadorcaptura++;
			break;
		}
		
		if(contadorcaptura==7) {
			for(int i=0; i<500; i++) {
				if(pc[i].nivel==0&&contador==0) {
					contador++;
					pc[i].nombre = enemigo.nombre;
					pc[i].nivel = enemigo.nivel;
					pc[i].type1 = enemigo.type1;
					pc[i].type2 = enemigo.type2;
					pc[i].npokedex = enemigo.npokedex;
					pc[i].hp = enemigo.hp;
					pc[i].maxhp = enemigo.maxhp;
					pc[i].exp = enemigo.exp;
					pc[i].totexp = enemigo.totexp;
					pc[i].atk = enemigo.atk;
					pc[i].satk = enemigo.satk;
					pc[i].def = enemigo.def;
					pc[i].sdef = enemigo.sdef;
					pc[i].spd = enemigo.spd;
					pc[i].a1name = enemigo.a1name;
					pc[i].a2name = enemigo.a2name;
					pc[i].a3name = enemigo.a3name;
					pc[i].a4name = enemigo.a4name;
					pc[i].a1type = enemigo.a1type;
					pc[i].a2type = enemigo.a2type;
					pc[i].a3type = enemigo.a3type;
					pc[i].a4type = enemigo.a4type;
					pc[i].a1pwr = enemigo.a1pwr;
					pc[i].a2pwr = enemigo.a2pwr;
					pc[i].a3pwr = enemigo.a3pwr;
					pc[i].a4pwr = enemigo.a4pwr;
					pc[i].a1acc = enemigo.a1acc;
					pc[i].a2acc = enemigo.a2acc;
					pc[i].a3acc = enemigo.a3acc;
					pc[i].a4acc = enemigo.a4acc;
					pc[i].a1cty = enemigo.a1cty;
					pc[i].a2cty = enemigo.a2cty;
					pc[i].a3cty = enemigo.a3cty;
					pc[i].a4cty = enemigo.a4cty;
					pc[i].a1pp = enemigo.a1pp;
					pc[i].a2pp = enemigo.a2pp;
					pc[i].a3pp = enemigo.a3pp;
					pc[i].a4pp = enemigo.a4pp;
					pc[i].a1maxpp = enemigo.a1maxpp;
					pc[i].a2maxpp = enemigo.a2maxpp;
					pc[i].a3maxpp = enemigo.a3maxpp;
					pc[i].a4maxpp = enemigo.a4maxpp;
					t2.setImgbackground("background.jpg");
					combates=false;
					boolean derrota = false;
					fincombate(derrota, enemigo);
				}
			}
		}
		
		String combate2v="";
		
		for(int d=0; d<3; d++) {
			for(int s=0; s<3; s++) {
				combate2v = combate2v + combate2[d][s];
			}
		}
		
		t.dibuixa(combate2);
		
		System.out.println(combate2v);
	}

	private static void equipo() {
		// funcion para cambiar el pokemon de posicion, fuera y dentro del combate
		///// o para guardar pokemon al pc
		
		String menuequipov="";
		int[][] menuequipo = new int[3][4];
		int segundaequipo[][] = new int[3][3];
		String segundaequipov="";
		
	
		menuequipov="";
		for(int i2=0; i2<3; i2++) {
			for(int j2=0; j2<4; j2++) {
				menuequipo[i2][j2]=28;
			}
		}
		
		for(int ir=0; ir<3; ir++) {
			for(int jr=0; jr<3; jr++) {
				segundaequipo[ir][jr]=28;
			}
		}
		
			// for de 6 para cada pokemon del equipo
			for(int i=0; i<6; i++) {
				
				switch(i) {
				case 0:
					x=0; y=0;
					x2=0; y2=1;
					break;
				case 1:
					x=0; y=2;
					x2=0; y2=3;
					break;
				case 2:
					x=1; y=0;
					x2=1; y2=1;
					break;
				case 3:
					x=1; y=2;
					x2=1; y2=3;
					break;
				case 4:
					x=2; y=0;
					x2=2; y2=1;
					break;
				case 5:
					x=2; y=2;
					x2=2; y2=3;
					break;
				}
				
				switch(equipo[i].npokedex) {
				case 0:
					menuequipo[x][y]=30;
					break;
				case 1:
					menuequipo[x][y]=31;
					break;
				case 2:
					menuequipo[x][y]=32;
				break;
				default:
					menuequipo[x][y]=28;
					break;
				}
				
				int porcentaje = 0;
				if(equipo[i].npokedex>=0) {
						if (equipo[i].hp>0) {
							porcentaje = (equipo[i].hp * 100);
							porcentaje = porcentaje / equipo[i].maxhp;
						}else {
							porcentaje=0;
						}
					menuequipo[x2][y2]=fotoshp[porcentaje];
				}
			}
			
			segundaequipov="";
			
			for(int i4=0; i4<3; i4++) {
				for(int j4=0; j4<3; j4++) {
					segundaequipov = segundaequipov + segundaequipo[i4][j4];
				}
			}
			
			menuequipov="";
			
			for(int i5=0; i5<3; i5++) {
				for(int j5=0; j5<4; j5++) {
					menuequipov = menuequipov + menuequipo[i5][j5];
				}
			}
			
			int seleccion1=28; int seleccion2=28; int seleccion3=28; 
			int seleccion4=28; int seleccion5=28; int seleccion6=28; 
			
			// ver posicion
			switch(posicion) {
			case 0:
				seleccion1=131; seleccion2=28; seleccion3=28;
				seleccion4=28; seleccion5=28; seleccion6=28;
				break;
			case 1:
				seleccion1=28; seleccion2=131; seleccion3=28;
				seleccion4=28; seleccion5=28; seleccion6=28;
				break;
			case 2:
				seleccion1=28; seleccion2=28; seleccion3=131;
				seleccion4=28; seleccion5=28; seleccion6=28;
				break;
			case 3:
				seleccion1=28; seleccion2=28; seleccion3=28;
				seleccion4=131; seleccion5=28; seleccion6=28;
				break;
			case 4:
				seleccion1=28; seleccion2=28; seleccion3=28;
				seleccion4=28; seleccion5=131; seleccion6=28;
				break;
			case 5:
				seleccion1=28; seleccion2=28; seleccion3=28;
				seleccion4=28; seleccion5=28; seleccion6=131;
				break;
			}
			
			int[][] matriuover =
	        	{
	            		{seleccion1,seleccion2,},
	            		{seleccion3,seleccion4,},
	            		{seleccion5,seleccion6,},
	        	};
		 
	        t2.overdibuixa(matriuover);
	       
			t.setImgbackground("backgroundopcion.jpg");
			t2.setImgbackground("backgroundcombate.jpg");
			t.dibuixa(segundaequipo);
			t2.dibuixa(menuequipo);
			System.out.println(segundaequipov);
			System.out.println(menuequipov);
			
			//movimiento por el equipo
			char opcionequipo = f.getActualChar();
			switch(opcionequipo) {
			case 'w': case 'W':
				if(posmenuequipoi==0) {
					
				}else {
					if(posmenuequipoi==2&&posmenuequipoj==0) {
						posmenuequipoi--;
						posicion=2;
					}else {
						if(posmenuequipoi==2&&posmenuequipoj==2) {
							posmenuequipoi--;
							posicion=3;
						}else {
							if(posmenuequipoi==1&&posmenuequipoj==0) {
								posmenuequipoi--;
								posicion=0;
							}else {
								if(posmenuequipoi==1&&posmenuequipoj==2) {
									posmenuequipoi--;
									posicion=1;
								}
							}
						}
					}
				}
				break;
			case 's': case 'S':
				if(posmenuequipoi==2) {
					
				}else {
					if(posmenuequipoi==1&&posmenuequipoj==0) {
						posmenuequipoi++;
						posicion=4;
					}else {
						if(posmenuequipoi==1&&posmenuequipoj==2) {
							posmenuequipoi++;
							posicion=5;
						}else {
							if(posmenuequipoi==0&&posmenuequipoj==0) {
								posmenuequipoi++;
								posicion=2;
							}else {
								if(posmenuequipoi==0&&posmenuequipoj==2) {
									posmenuequipoi++;
									posicion=3;
								}
							}
						}
					}
				}
				break;
			case 'a': case 'A':
				if(posmenuequipoj==0) {
					
				}else {
					if(posmenuequipoj==2&&posmenuequipoi==0) {
						posmenuequipoj=posmenuequipoj-2;
						posicion=0;
					}else {
						if(posmenuequipoj==2&&posmenuequipoi==1) {
							posmenuequipoj=posmenuequipoj-2;
							posicion=2;
						}else {
							if(posmenuequipoj==2&&posmenuequipoi==2) {
								posmenuequipoj=posmenuequipoj-2;
								posicion=4;
							}
						}
					}
				}
				break;
			case 'd': case 'D':
				if(posmenuequipoj==2) {
					
				}else {
					if(posmenuequipoj==0&&posmenuequipoi==0) {
						posmenuequipoj=posmenuequipoj+2;
						posicion=1;
					}else {
						if(posmenuequipoj==0&&posmenuequipoi==1) {
							posmenuequipoj=posmenuequipoj+2;
							posicion=3;
						}else {
							if(posmenuequipoj==0&&posmenuequipoi==2) {
								posmenuequipoj=posmenuequipoj+2;
								posicion=5;
							}
						}
					}
				}
				break;
			case 'c': case 'C':
				contador=0;
				//for para guardar pokemon en el pc si accedes al pc
				if(guardar&&equipo[0].nivel>0&&equipo[1].nivel>0) {
					for(int i=0; i<500; i++) {
						if(pc[i].nivel==0&contador==0) {
							int aux1 = equipo[posicion].npokedex; equipo[posicion].npokedex = pc[i].npokedex; pc[i].npokedex = aux1;
							String aux2 = equipo[posicion].nombre; equipo[posicion].nombre = pc[i].nombre; pc[i].nombre = aux2;
							int aux3 = equipo[posicion].nivel; equipo[posicion].nivel = pc[i].nivel; pc[i].nivel = aux3;
							String aux4 = equipo[posicion].type1; equipo[posicion].type1 = pc[i].type1; pc[i].type1 = aux4;
							String aux5 = equipo[posicion].type2; equipo[posicion].type2 = pc[i].type2; pc[i].type2 = aux5;
							int aux6 = equipo[posicion].hp; equipo[posicion].hp = pc[i].hp; pc[i].hp = aux6;
							int aux7 = equipo[posicion].maxhp; equipo[posicion].maxhp = pc[i].maxhp; pc[i].maxhp = aux7;
							int aux8 = equipo[posicion].exp; equipo[posicion].exp = pc[i].exp; pc[i].exp = aux8;
							int aux9 = equipo[posicion].totexp; equipo[posicion].totexp = pc[i].totexp; pc[i].totexp = aux9;
							int aux10 = equipo[posicion].atk; equipo[posicion].atk = pc[i].atk; pc[i].atk = aux10;
							int aux11 = equipo[posicion].satk; equipo[posicion].satk = pc[i].satk; pc[i].satk = aux11;
							int aux12 = equipo[posicion].def; equipo[posicion].def = pc[i].def; pc[i].def = aux12;
							int aux13 = equipo[posicion].sdef; equipo[posicion].sdef = pc[i].sdef; pc[i].sdef = aux13;
							int aux14 = equipo[posicion].spd; equipo[posicion].spd = pc[i].spd; pc[i].spd = aux14;
							String aux15 = equipo[posicion].a1name; equipo[posicion].a1name = pc[i].a1name; pc[i].a1name = aux15;
							String aux16 = equipo[posicion].a2name; equipo[posicion].a2name = pc[i].a2name; pc[i].a2name = aux16;
							String aux17 = equipo[posicion].a3name; equipo[posicion].a3name = pc[i].a3name; pc[i].a3name = aux17;
							String aux18 = equipo[posicion].a4name; equipo[posicion].a4name = pc[i].a4name; pc[i].a4name = aux18;
							String aux19 = equipo[posicion].a1type; equipo[posicion].a1type = pc[i].a1type; pc[i].a1type = aux19;
							String aux20 = equipo[posicion].a2type; equipo[posicion].a2type = pc[i].a2type; pc[i].a2type = aux20;
							String aux21 = equipo[posicion].a3type; equipo[posicion].a3type = pc[i].a3type; pc[i].a3type = aux21;
							String aux22 = equipo[posicion].a4type; equipo[posicion].a4type = pc[i].a4type; pc[i].a4type = aux22;
							int aux23 = equipo[posicion].a1pwr; equipo[posicion].a1pwr = pc[i].a1pwr; pc[i].a1pwr = aux23;
							int aux24 = equipo[posicion].a2pwr; equipo[posicion].a2pwr = pc[i].a2pwr; pc[i].a2pwr = aux24;
							int aux25 = equipo[posicion].a3pwr; equipo[posicion].a3pwr = pc[i].a3pwr; pc[i].a3pwr = aux25;
							int aux26 = equipo[posicion].a4pwr; equipo[posicion].a4pwr = pc[i].a4pwr; pc[i].a4pwr = aux26;
							int aux27 = equipo[posicion].a1acc; equipo[posicion].a1acc = pc[i].a1acc; pc[i].a1acc = aux27;
							int aux28 = equipo[posicion].a2acc; equipo[posicion].a2acc = pc[i].a2acc; pc[i].a2acc = aux28;
							int aux29 = equipo[posicion].a3acc; equipo[posicion].a3acc = pc[i].a3acc; pc[i].a3acc = aux29;
							int aux30 = equipo[posicion].a4acc; equipo[posicion].a4acc = pc[i].a4acc; pc[i].a4acc = aux30;
							int aux31 = equipo[posicion].a1pp; equipo[posicion].a1pp = pc[i].a1pp; pc[i].a1pp = aux31;
							int aux32 = equipo[posicion].a2pp; equipo[posicion].a2pp = pc[i].a2pp; pc[i].a2pp = aux32;
							int aux33 = equipo[posicion].a3pp; equipo[posicion].a3pp = pc[i].a3pp; pc[i].a3pp = aux33;
							int aux34 = equipo[posicion].a4pp; equipo[posicion].a4pp = pc[i].a4pp; pc[i].a4pp = aux34;
							int aux35 = equipo[posicion].a1maxpp; equipo[posicion].a1maxpp = pc[i].a1maxpp; pc[i].a1maxpp = aux35;
							int aux36 = equipo[posicion].a2maxpp; equipo[posicion].a2maxpp = pc[i].a2maxpp; pc[i].a2maxpp = aux36;
							int aux37 = equipo[posicion].a3maxpp; equipo[posicion].a3maxpp = pc[i].a3maxpp; pc[i].a3maxpp = aux37;
							int aux38 = equipo[posicion].a4maxpp; equipo[posicion].a4maxpp = pc[i].a4maxpp; pc[i].a4maxpp = aux38;
							int aux39 = equipo[posicion].a1cty; equipo[posicion].a1cty = pc[i].a1cty; pc[i].a1cty = aux39;
							int aux40 = equipo[posicion].a2cty; equipo[posicion].a2cty = pc[i].a2cty; pc[i].a2cty = aux40;
							int aux41 = equipo[posicion].a3cty; equipo[posicion].a3cty = pc[i].a3cty; pc[i].a3cty = aux41;
							int aux42 = equipo[posicion].a4cty; equipo[posicion].a4cty = pc[i].a4cty; pc[i].a4cty = aux42;
							contador++;
						}
					}
					int contadorc=0;
					//dependiendo del pokemon que guardes en el equipo se
					//recolocara el equipo para llenar los primeros sitios
					
					//dependiendo de la posicion y del numero de pokemons en el 
					//equipo un contador sumara para saber cuantas veces
					//mover los pokemon por el equipo
					switch(posicion) {
					case 0:
						if(equipo[1].nivel!=0) {
							contadorc++;
						}
						if(equipo[2].nivel!=0) {
							contadorc++;
						}
						if(equipo[3].nivel!=0) {
							contadorc++;
						}
						if(equipo[4].nivel!=0) {
							contadorc++;
						}
						if(equipo[5].nivel!=0) {
							contadorc++;
						}
						break;
					case 1:
						if(equipo[2].nivel!=0) {
							contadorc++;
						}
						if(equipo[3].nivel!=0) {
							contadorc++;
						}
						if(equipo[4].nivel!=0) {
							contadorc++;
						}
						if(equipo[5].nivel!=0) {
							contadorc++;
						}
						break;
					case 2:
						if(equipo[2].nivel!=0) {
							contadorc++;
						}
						if(equipo[3].nivel!=0) {
							contadorc++;
						}
						if(equipo[4].nivel!=0) {
							contadorc++;
						}
						break;
					case 3:
						if(equipo[2].nivel!=0) {
							contadorc++;
						}
						if(equipo[3].nivel!=0) {
							contadorc++;
						}
						break;
					case 4:
						if(equipo[2].nivel!=0) {
							contadorc++;
						}
						break;
					}
					
					
					if(contador==1) {
						int posicioncambio=posicion;
						int posicioncambio2=posicioncambio+1;
						//mira si hay pokmeon en la posicion siguiente y lo coloca en la actual hasta 
						///////que no queden pokmeon o llegue al final del equipo
						while(contadorc>0) {
							if(posicioncambio2==6) {
								
							}else {
							if (equipo[posicioncambio2].nivel > 0) {
								int auxnumpokedex = equipo[posicioncambio2].npokedex; equipo[posicioncambio2].npokedex = equipo[posicioncambio].npokedex; equipo[posicioncambio].npokedex = auxnumpokedex;
								String auxnombre = equipo[posicioncambio2].nombre; equipo[posicioncambio2].nombre = equipo[posicioncambio].nombre; equipo[posicioncambio].nombre = auxnombre;
								int auxnivel = equipo[posicioncambio2].nivel; equipo[posicioncambio2].nivel = equipo[posicioncambio].nivel; equipo[posicioncambio].nivel = auxnivel; String auxty1 = equipo[posicioncambio2].type1; equipo[posicioncambio2].type1 = equipo[posicioncambio].type1; equipo[posicioncambio].type1 = auxty1;
								String auxty2 = equipo[posicioncambio2].type2; equipo[posicioncambio2].type2 = equipo[posicioncambio].type2; equipo[posicioncambio].type2 = auxty2;
								int auxhp = equipo[posicioncambio2].hp; equipo[posicioncambio2].hp = equipo[posicioncambio].hp; equipo[posicioncambio].hp = auxhp;
								int auxmaxhp = equipo[posicioncambio2].maxhp; equipo[posicioncambio2].maxhp = equipo[posicioncambio].maxhp; equipo[posicioncambio].maxhp = auxmaxhp;
								int auxexp = equipo[posicioncambio2].exp; equipo[posicioncambio2].exp = equipo[posicioncambio].exp; equipo[posicioncambio].exp = auxexp;
								int auxtotexp = equipo[posicioncambio2].totexp; equipo[posicioncambio2].totexp = equipo[posicioncambio].totexp; equipo[posicioncambio].totexp = auxtotexp;
								int auxatk = equipo[posicioncambio2].atk; equipo[posicioncambio2].atk = equipo[posicioncambio].atk; equipo[posicioncambio].atk = auxatk;
								int auxsatk = equipo[posicioncambio2].satk; equipo[posicioncambio2].satk = equipo[posicioncambio].satk; equipo[posicioncambio].satk = auxsatk;
								int auxdef = equipo[posicioncambio2].def; equipo[posicioncambio2].def = equipo[posicioncambio].def; equipo[posicioncambio].def = auxdef;
								int auxsdef = equipo[posicioncambio2].sdef; equipo[posicioncambio2].sdef = equipo[posicioncambio].sdef; equipo[posicioncambio].sdef = auxsdef;
								int auxspd = equipo[posicioncambio2].spd; equipo[posicioncambio2].spd = equipo[posicioncambio].spd; equipo[posicioncambio].spd = auxspd;
								String auxa1name = equipo[posicioncambio2].a1name; equipo[posicioncambio2].a1name = equipo[posicioncambio].a1name; equipo[posicioncambio].a1name = auxa1name;
								String auxa2name = equipo[posicioncambio2].a2name; equipo[posicioncambio2].a2name = equipo[posicioncambio].a2name; equipo[posicioncambio].a2name = auxa2name;
								String auxa3name = equipo[posicioncambio2].a3name; equipo[posicioncambio2].a3name = equipo[posicioncambio].a3name; equipo[posicioncambio].a3name = auxa3name;
								String auxa4name = equipo[posicioncambio2].a4name; equipo[posicioncambio2].a4name = equipo[posicioncambio].a4name; equipo[posicioncambio].a4name = auxa4name;
								String auxa1type = equipo[posicioncambio2].a1type; equipo[posicioncambio2].a1type = equipo[posicioncambio].a1type; equipo[posicioncambio].a1type = auxa1type;
								String auxa2type = equipo[posicioncambio2].a2type; equipo[posicioncambio2].a2type = equipo[posicioncambio].a2type; equipo[posicioncambio].a2type = auxa2type;
								String auxa3type = equipo[posicioncambio2].a3type; equipo[posicioncambio2].a3type = equipo[posicioncambio].a3type; equipo[posicioncambio].a3type = auxa3type;
								String auxa4type = equipo[posicioncambio2].a4type; equipo[posicioncambio2].a4type = equipo[posicioncambio].a4type; equipo[posicioncambio].a4type = auxa4type;
								int auxa1pwr = equipo[posicioncambio2].a1pwr; equipo[posicioncambio2].a1pwr = equipo[posicioncambio].a1pwr; equipo[posicioncambio].a1pwr = auxa1pwr;
								int auxa2pwr = equipo[posicioncambio2].a2pwr; equipo[posicioncambio2].a2pwr = equipo[posicioncambio].a2pwr; equipo[posicioncambio].a2pwr = auxa2pwr;
								int auxa3pwr = equipo[posicioncambio2].a3pwr; equipo[posicioncambio2].a3pwr = equipo[posicioncambio].a3pwr; equipo[posicioncambio].a3pwr = auxa3pwr;
								int auxa4pwr = equipo[posicioncambio2].a4pwr; equipo[posicioncambio2].a4pwr = equipo[posicioncambio].a4pwr; equipo[posicioncambio].a4pwr = auxa4pwr;
								int auxa1acc = equipo[posicioncambio2].a1acc; equipo[posicioncambio2].a1acc = equipo[posicioncambio].a1acc; equipo[posicioncambio].a1acc = auxa1acc;
								int auxa2acc = equipo[posicioncambio2].a2acc; equipo[posicioncambio2].a2acc = equipo[posicioncambio].a2acc; equipo[posicioncambio].a2acc = auxa2acc;
								int auxa3acc = equipo[posicioncambio2].a3acc; equipo[posicioncambio2].a3acc = equipo[posicioncambio].a3acc; equipo[posicioncambio].a3acc = auxa3acc;
								int auxa4acc = equipo[posicioncambio2].a4acc; equipo[posicioncambio2].a4acc = equipo[posicioncambio].a4acc; equipo[posicioncambio].a4acc = auxa4acc;
								int auxa1pp = equipo[posicioncambio2].a1pp; equipo[posicioncambio2].a1pp = equipo[posicioncambio].a1pp; equipo[posicioncambio].a1pp = auxa1pp;
								int auxa2pp = equipo[posicioncambio2].a2pp; equipo[posicioncambio2].a2pp = equipo[posicioncambio].a2pp; equipo[posicioncambio].a2pp = auxa2pp;
								int auxa3pp = equipo[posicioncambio2].a3pp; equipo[posicioncambio2].a3pp = equipo[posicioncambio].a3pp; equipo[posicioncambio].a3pp = auxa3pp;
								int auxa4pp = equipo[posicioncambio2].a4pp; equipo[posicioncambio2].a4pp = equipo[posicioncambio].a4pp; equipo[posicioncambio].a4pp = auxa4pp;
								int auxa1maxpp = equipo[posicioncambio2].a1maxpp; equipo[posicioncambio2].a1maxpp = equipo[posicioncambio].a1maxpp; equipo[posicioncambio].a1maxpp = auxa1maxpp;
								int auxa2maxpp = equipo[posicioncambio2].a2maxpp; equipo[posicioncambio2].a2maxpp = equipo[posicioncambio].a2maxpp; equipo[posicioncambio].a2maxpp = auxa2maxpp;
								int auxa3maxpp = equipo[posicioncambio2].a3maxpp; equipo[posicioncambio2].a3maxpp = equipo[posicioncambio].a3maxpp; equipo[posicioncambio].a3maxpp = auxa3maxpp;
								int auxa4maxpp = equipo[posicioncambio2].a4maxpp; equipo[posicioncambio2].a4maxpp = equipo[posicioncambio].a4maxpp; equipo[posicioncambio].a4maxpp = auxa4maxpp;
								int auxa1cty = equipo[posicioncambio2].a1cty; equipo[posicioncambio2].a1cty = equipo[posicioncambio].a1cty; equipo[posicioncambio].a1cty = auxa1cty;
								int auxa2cty = equipo[posicioncambio2].a2cty; equipo[posicioncambio2].a2cty = equipo[posicioncambio].a2cty; equipo[posicioncambio].a2cty = auxa2cty;
								int auxa3cty = equipo[posicioncambio2].a3cty; equipo[posicioncambio2].a3cty = equipo[posicioncambio].a3cty; equipo[posicioncambio].a3cty = auxa3cty;
								int auxa4cty = equipo[posicioncambio2].a4cty; equipo[posicioncambio2].a4cty = equipo[posicioncambio].a4cty; equipo[posicioncambio].a4cty = auxa4cty;
								posicioncambio++;
								posicioncambio2++;
								contadorc--;
							} 
						}}
						//salida del menu y limpieza de la matriz overdraw
						guardar=false;
						estado=9;
						int[][] matriuover2 =
				        	{
				            		{28,28,},
				            		{28,28,},
				            		{28,28,},
				        	};
				        t2.overdibuixa(matriuover2);
						
					}else {
						guardar=false;
						estado=9;
						
						int[][] matriuover2 =
				        	{
				            		{28,28,},
				            		{28,28,},
				            		{28,28,},
				        	};
				        t2.overdibuixa(matriuover2);
						
					}
					
				}else {
				///// en caso que entres al menu del equipo des de fuera dle combate y fuera del pc
						if(equipo[posicion].nombre!=" "&&equipo[posicion].hp>0) {
							int auxnumpokedex = equipo[0].npokedex; equipo[0].npokedex=equipo[posicion].npokedex; equipo[posicion].npokedex = auxnumpokedex;
							String auxnombre = equipo[0].nombre; equipo[0].nombre=equipo[posicion].nombre; equipo[posicion].nombre=auxnombre;
							int auxnivel = equipo[0].nivel; equipo[0].nivel=equipo[posicion].nivel; equipo[posicion].nivel=auxnivel;
							String auxty1 = equipo[0].type1; equipo[0].type1=equipo[posicion].type1; equipo[posicion].type1=auxty1;
							String auxty2 = equipo[0].type2; equipo[0].type2=equipo[posicion].type2; equipo[posicion].type2=auxty2;
							int auxhp = equipo[0].hp; equipo[0].hp=equipo[posicion].hp; equipo[posicion].hp=auxhp;
							int auxmaxhp = equipo[0].maxhp; equipo[0].maxhp=equipo[posicion].maxhp; equipo[posicion].maxhp=auxmaxhp;
							int auxexp = equipo[0].exp; equipo[0].exp=equipo[posicion].exp; equipo[posicion].exp=auxexp;
							int auxtotexp = equipo[0].totexp; equipo[0].totexp=equipo[posicion].totexp; equipo[posicion].totexp=auxtotexp;
							int auxatk = equipo[0].atk; equipo[0].atk=equipo[posicion].atk; equipo[posicion].atk=auxatk;
							int auxsatk = equipo[0].satk; equipo[0].satk=equipo[posicion].satk; equipo[posicion].satk=auxsatk;
							int auxdef = equipo[0].def; equipo[0].def=equipo[posicion].def; equipo[posicion].def=auxdef;
							int auxsdef = equipo[0].sdef; equipo[0].sdef=equipo[posicion].sdef; equipo[posicion].sdef=auxsdef;
							int auxspd = equipo[0].spd; equipo[0].spd=equipo[posicion].spd; equipo[posicion].spd=auxspd;
							String auxa1name = equipo[0].a1name; equipo[0].a1name=equipo[posicion].a1name; equipo[posicion].a1name=auxa1name;
							String auxa2name = equipo[0].a2name; equipo[0].a2name=equipo[posicion].a2name; equipo[posicion].a2name=auxa2name;
							String auxa3name = equipo[0].a3name; equipo[0].a3name=equipo[posicion].a3name; equipo[posicion].a3name=auxa3name;
							String auxa4name = equipo[0].a4name; equipo[0].a4name=equipo[posicion].a4name; equipo[posicion].a4name=auxa4name;
							String auxa1type = equipo[0].a1type; equipo[0].a1type=equipo[posicion].a1type; equipo[posicion].a1type=auxa1type;
							String auxa2type = equipo[0].a2type; equipo[0].a2type=equipo[posicion].a2type; equipo[posicion].a2type=auxa2type;
							String auxa3type = equipo[0].a3type; equipo[0].a3type=equipo[posicion].a3type; equipo[posicion].a3type=auxa3type;
							String auxa4type = equipo[0].a4type; equipo[0].a4type=equipo[posicion].a4type; equipo[posicion].a4type=auxa4type;
							int auxa1pwr = equipo[0].a1pwr; equipo[0].a1pwr=equipo[posicion].a1pwr; equipo[posicion].a1pwr=auxa1pwr;
							int auxa2pwr = equipo[0].a2pwr; equipo[0].a2pwr=equipo[posicion].a2pwr; equipo[posicion].a2pwr=auxa2pwr;
							int auxa3pwr = equipo[0].a3pwr; equipo[0].a3pwr=equipo[posicion].a3pwr; equipo[posicion].a3pwr=auxa3pwr;
							int auxa4pwr = equipo[0].a4pwr; equipo[0].a4pwr=equipo[posicion].a4pwr; equipo[posicion].a4pwr=auxa4pwr;
							int auxa1acc = equipo[0].a1acc; equipo[0].a1acc=equipo[posicion].a1acc; equipo[posicion].a1acc=auxa1acc;
							int auxa2acc = equipo[0].a2acc; equipo[0].a2acc=equipo[posicion].a2acc; equipo[posicion].a2acc=auxa2acc;
							int auxa3acc = equipo[0].a3acc; equipo[0].a3acc=equipo[posicion].a3acc; equipo[posicion].a3acc=auxa3acc;
							int auxa4acc = equipo[0].a4acc; equipo[0].a4acc=equipo[posicion].a4acc; equipo[posicion].a4acc=auxa4acc;
							int auxa1pp = equipo[0].a1pp; equipo[0].a1pp=equipo[posicion].a1pp; equipo[posicion].a1pp=auxa1pp;
							int auxa2pp = equipo[0].a2pp; equipo[0].a2pp=equipo[posicion].a2pp; equipo[posicion].a2pp=auxa2pp;
							int auxa3pp = equipo[0].a3pp; equipo[0].a3pp=equipo[posicion].a3pp; equipo[posicion].a3pp=auxa3pp;
							int auxa4pp = equipo[0].a4pp; equipo[0].a4pp=equipo[posicion].a4pp; equipo[posicion].a4pp=auxa4pp;
							int auxa1maxpp = equipo[0].a1maxpp; equipo[0].a1maxpp=equipo[posicion].a1maxpp; equipo[posicion].a1maxpp=auxa1maxpp;
							int auxa2maxpp = equipo[0].a2maxpp; equipo[0].a2maxpp=equipo[posicion].a2maxpp; equipo[posicion].a2maxpp=auxa2maxpp;
							int auxa3maxpp = equipo[0].a3maxpp; equipo[0].a3maxpp=equipo[posicion].a3maxpp; equipo[posicion].a3maxpp=auxa3maxpp;
							int auxa4maxpp = equipo[0].a4maxpp; equipo[0].a4maxpp=equipo[posicion].a4maxpp; equipo[posicion].a4maxpp=auxa4maxpp;
							int auxa1cty = equipo[0].a1cty; equipo[0].a1cty=equipo[posicion].a1cty; equipo[posicion].a1cty=auxa1cty;
							int auxa2cty = equipo[0].a2cty; equipo[0].a2cty=equipo[posicion].a2cty; equipo[posicion].a2cty=auxa2cty;
							int auxa3cty = equipo[0].a3cty; equipo[0].a3cty=equipo[posicion].a3cty; equipo[posicion].a3cty=auxa3cty;
							int auxa4cty = equipo[0].a4cty; equipo[0].a4cty=equipo[posicion].a4cty; equipo[posicion].a4cty=auxa4cty;
					}
					//// en caso de combate se recibira daño
						// y se comprovara el estado de derrota, etc
					if(combates) {
						dañoapoke(enemigo);
						if(equipo[0].hp<=0) {
							equipo[0].hp=0;
							numpoke--;
							if(numpoke>0) {
								equipo();
							}else {
								estado=2;
							}
						}estado=2;//combate
						
						int[][] matriuover2 =
				        	{
				            		{28,28,},
				            		{28,28,},
				            		{28,28,},
				        	};
				        t2.overdibuixa(matriuover2);
						
					}
					
				}
				break;
			case 'e': case 'E':
				//salir del menu del equipo
				if(combates) {
					estado=1;//combate
					int[][] matriuover2 =
			        	{
			            		{28,28,},
			            		{28,28,},
			            		{28,28,},
			        	};
			        t2.overdibuixa(matriuover2);
				}else {
					if (guardar) {
						estado = 9;//menu pc
						int[][] matriuover2 = { 
								{ 28, 28, }, 
								{ 28, 28, }, 
								{ 28, 28, }, 
						};
						t2.overdibuixa(matriuover2);
					}else {
						estado=0;
						int[][] matriuover2 = { 
								{ 28, 28, }, 
								{ 28, 28, }, 
								{ 28, 28, }, 
						};
						t2.overdibuixa(matriuover2);
					}
				}				
				break;
			}
		
	}
	
	private static void fincombate(boolean derrota, Pokemon enemigo) {
		// mirar derrota o victoria y lo que conlleva
		//// la derrota no influye en nada aun
		
		// derrota
		if(derrota==true) {
			combates=false;
			t.setImgbackground("background.jpg");
			t2.setImgbackground("backgroundopcion.jpg");
		}
		
		// victoria
		if(derrota==false&&equipo[0].nivel<100) {
			combates=false;
			System.out.println("exp antes "+equipo[0].exp);
			t.setImgbackground("background.jpg");
			t2.setImgbackground("backgroundopcion.jpg");
			
			int experienciabase=0;
			
			//experiencia ganada dependiendo del pokemon rival
			switch(enemigo.nombre) {
			case "Pikachu":
				experienciabase=82;
				break;
			case "Pidgey":
				experienciabase=55;
				break;
			case "Growlithe":
				experienciabase=91;
				break;
			
			}
			
			
			equipo[0].exp = (int) (equipo[0].exp + ((enemigo.nivel*experienciabase)/(7))); 
			
			if(equipo[0].exp==equipo[0].totexp) {
				equipo[0].exp=0;
				
				//calculo de la experiencia total respecto al nivel
				for(int j=0; j<2; j++) {
					equipo[0].totexp = equipo[0].totexp + (equipo[0].nivel*equipo[0].nivel);  
				}
				
				equipo[0].nivel++;
				equipo[0].maxhp = (int) (equipo[0].maxhp + (equipo[0].maxhp * 0.1));
				equipo[0].hp = (int) (equipo[0].hp + (equipo[0].hp * 0.1));
				equipo[0].atk = (int) (equipo[0].atk + (Math.random()*3));
				equipo[0].satk = (int) (equipo[0].satk + (Math.random()*3));
				equipo[0].def = (int) (equipo[0].def + (Math.random()*3));
				equipo[0].sdef = (int) (equipo[0].sdef + (Math.random()*3));
				equipo[0].spd = (int) (equipo[0].spd + (Math.random()*3));
			}else {
				//////////////////////////
					int resto;
					
					if (equipo[0].exp>equipo[0].totexp) {
						resto = equipo[0].totexp + 1;
						while (resto > equipo[0].totexp&&equipo[0].nivel<100) {
							resto = equipo[0].exp - equipo[0].totexp;
							equipo[0].exp=0;
							equipo[0].exp = equipo[0].exp + resto;
							
							//calculo de la experiencia total respecto al nivel
							for(int j=0; j<2; j++) {
								equipo[0].totexp = equipo[0].totexp + (equipo[0].nivel*equipo[0].nivel);  
							}
							
							equipo[0].nivel++;
							equipo[0].maxhp = (int) (equipo[0].maxhp + (equipo[0].maxhp * 0.1));
							equipo[0].hp = (int) (equipo[0].hp + (equipo[0].hp * 0.1));
							equipo[0].atk = (int) (equipo[0].atk + (Math.random() * 3));
							equipo[0].satk = (int) (equipo[0].satk + (Math.random() * 3));
							equipo[0].def = (int) (equipo[0].def + (Math.random() * 3));
							equipo[0].sdef = (int) (equipo[0].sdef + (Math.random() * 3));
							equipo[0].spd = (int) (equipo[0].spd + (Math.random() * 3));
						} 
						equipo[0].exp = equipo[0].exp + resto;
					}else {
						
					}
				
			}
			
		}
		
		//control por si se supera el nivel 100
		if(equipo[0].nivel>=100) {
			equipo[0].nivel=100;
			equipo[0].exp=1;
			equipo[0].totexp=1;
		}
		combates=false;
		estado=0;//mostrar vida
	}
	
	private static void menupc() {
		// menu del pc para elejir si guardar pokemon o sacar un pokemon
		
		for(int i=0; i<2; i++) {
			for (int j=0; j<2; j++) {
				menupc[i][j] = 28;
			}
		}
			menupcv="";
			
			
			for(int i=0; i<2; i++) {
				for (int j=0; j<2; j++) {
					menupcv = menupcv + menupc[i][j];
				}
			}
			
			if(posmenupci==0) {
				menupc[0][1]=138;
			}else {
				menupc[0][1]=139;
			}
			
			t.setImgbackground("background.jpg");
			t.dibuixa(mapamov);
			t2.setImgbackground("backgroundopcion.jpg");
			t2.dibuixa(segundapantalla);
			t.overdibuixa(menupc);
			System.out.println(mapamovv);
			System.out.println(menupcv);
			System.out.println(segundapantallav);
			
			//menu del pc
			char opcionpc = f.getActualChar();
			switch(opcionpc) {
			case 'w': case 'W':
				if(posmenupci==0) {
					
				} else {
					if(posmenupci==1) {
						posmenupci--;
					} 
				}
				break;
			case 's': case 'S':
				if(posmenupci==1) {
					
				} else {
					if(posmenupci==0) {
						posmenupci++;
					} 
				}
				break;
			case 'c': case 'C':
				for(int i=0; i<2; i++) {
					for (int j=0; j<2; j++) {
						menupc[i][j] = 28;
					}
				}
				
				for(int i=0; i<2; i++) {
					for (int j=0; j<2; j++) {
						menupcv = menupcv + menupc[i][j];
					}
				}
				
				switch(posmenupci) {
				case 0:
					System.out.println("?");
					posmenuequipoi=0;
					posmenuequipoj=0;
					guardar=true;
					posicion=0;
					estado=4;//equipo (para guardar)
					bmenupc=false;
					break;
				case 1:
					possacari=0;
					possacarj=0;
					posicionpc=0;
					estado=8;//sacar del pc
					bmenupc=false;
					break;
				}
				break;
			case 'e': case 'E':
				//salir del menu del pc
				for(int i=0; i<2; i++) {
					for (int j=0; j<2; j++) {
						menupc[i][j] = 28;
					}
				}
				
				for(int i=0; i<2; i++) {
					for (int j=0; j<2; j++) {
						menupcv = menupcv + menupc[i][j];
					}
				}
				
				t.overdibuixa(menupc);
				System.out.println(menupcv);
				t.setImgbackground("background.jpg");
				
				estado=0;
				bmenupc=false;
				break;
			}
			for(int i=0; i<2; i++) {	
					menupcv = menupcv + menupc[i] + "\n";
			}
		
	}

	private static void sacarpc() {
		// sacar pokemon del pc
		/// si el equipo esta lleno te sacara del pc pero no sucede nada
		
		t.setImgbackground("backgroundcombate.jpg");
		
		int[][] pokemonspc = new int[6][6];
		int[][] matriuover = new int[6][6];
		String pokemonspcv="";
		String segundapantallapc="";
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		ArrayList<Integer> lista2 = new ArrayList<Integer>();
		
		//h2 listas, npokedex para la foto y posicion en el pc
		for(int i=0; i<500; i++) {
			if(pc[i].nivel>0&&lista.size()<36) {
				lista.add(pc[i].npokedex);
				lista2.add(i);
			}else {
				lista2.add(160);
				lista.add(160);
			}
		}
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				pokemonspc[i][j]=28;
			}
		}
		
		int c=0;
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if (c<lista.size()) {
					pokemonspc[i][j] = lista.get(c);
					c++;
				}
			}
		}
		
		//for para fotos
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				switch(pokemonspc[i][j]) {
				case 0:
					pokemonspc[i][j] = 30;
					break;
				case 1:
					pokemonspc[i][j] = 31;
					break;
				case 2:
					pokemonspc[i][j] = 32;
					break;
				default:
					pokemonspc[i][j] = 28;
					break;
				}
			}
		}
		
		pokemonspcv="";
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
	        pokemonspcv = pokemonspcv + pokemonspc[i][j];
			}
		}
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				matriuover[i][j]=28;
			}
		}
		
		matriuover[possacari][possacarj]=131;
		t.overdibuixa(matriuover);
		t.dibuixa(pokemonspc);
		System.out.println(pokemonspcv);
		
		
		//moverse por el pc
			char opcionpc = f.getActualChar();
			switch(opcionpc) {
			case 'w': case 'W':
				if(possacari==0) {
					
				}else {
					possacari++;
					posicionpc = posicionpc - 6;
				}
				break;
			case 's': case 'S':
				if(possacari==5) {
					
				}else {
					possacari++;
					posicionpc = posicionpc + 6;
				}
				break;
			case 'a': case 'A':
				if(possacarj==0) {
					
				}else {
					possacarj--;
					posicionpc--;
				}
				break;
			case 'd': case 'D':
				if(possacarj==5) {
					
				}else {
					possacarj++;
					posicionpc++;
				}
				break;
			case 'c': case 'C':
				int contadorpc=0;
				//// coje la posicion del pc de la lista respecto a la posicion de la matriz
				// siempre que se haya seleccionado un pokemon y no un lugar en blanco
				for (int i = 0; i < 6; i++) {
					if (lista2.get(posicionpc) != 160 && contadorpc == 0 && equipo[i].nivel==0) {
						int aux = pc[posicionpc].npokedex; pc[posicionpc].npokedex = equipo[i].npokedex; equipo[i].npokedex = aux;
						String aux2 = pc[posicionpc].nombre; pc[posicionpc].nombre = equipo[i].nombre; equipo[i].nombre = aux2;
						String aux3 = pc[posicionpc].type1; pc[posicionpc].type1 = equipo[i].type1; equipo[i].type1 = aux3;
						String aux4 = pc[posicionpc].type2; pc[posicionpc].type2 = equipo[i].type2; equipo[i].type2 = aux4;
						int aux5 = pc[posicionpc].nivel; pc[posicionpc].nivel = equipo[i].nivel; equipo[i].nivel = aux5;
						int aux6 = pc[posicionpc].hp; pc[posicionpc].hp = equipo[i].hp; equipo[i].hp = aux6;
						int aux7 = pc[posicionpc].maxhp; pc[posicionpc].maxhp = equipo[i].maxhp; equipo[i].maxhp = aux7;
						int aux8 = pc[posicionpc].exp; pc[posicionpc].exp = equipo[i].exp; equipo[i].exp = aux8;
						int aux9 = pc[posicionpc].totexp; pc[posicionpc].totexp = equipo[i].totexp; equipo[i].totexp = aux9;
						int aux10 = pc[posicionpc].atk; pc[posicionpc].atk = equipo[i].atk; equipo[i].atk = aux10;
						int aux11 = pc[posicionpc].satk; pc[posicionpc].satk = equipo[i].satk; equipo[i].satk = aux11;
						int aux12 = pc[posicionpc].def; pc[posicionpc].def = equipo[i].def; equipo[i].def = aux12;
						int aux13 = pc[posicionpc].sdef; pc[posicionpc].sdef = equipo[i].sdef; equipo[i].sdef = aux13;
						int aux14 = pc[posicionpc].spd; pc[posicionpc].spd = equipo[i].spd; equipo[i].spd = aux14;
						String aux15 = pc[posicionpc].a1name; pc[posicionpc].a1name = equipo[i].a1name; equipo[i].a1name = aux15;
						String aux16 = pc[posicionpc].a2name; pc[posicionpc].a2name = equipo[i].a2name; equipo[i].a2name = aux16;
						String aux17 = pc[posicionpc].a3name; pc[posicionpc].a3name = equipo[i].a3name; equipo[i].a3name = aux17;
						String aux18 = pc[posicionpc].a4name; pc[posicionpc].a4name = equipo[i].a4name; equipo[i].a4name = aux18;
						String aux19 = pc[posicionpc].a1type; pc[posicionpc].a1type = equipo[i].a1type; equipo[i].a1type = aux19;
						String aux20 = pc[posicionpc].a2type; pc[posicionpc].a2type = equipo[i].a2type; equipo[i].a2type = aux20;
						String aux21 = pc[posicionpc].a3type; pc[posicionpc].a3type = equipo[i].a3type; equipo[i].a3type = aux21;
						String aux22 = pc[posicionpc].a4type; pc[posicionpc].a4type = equipo[i].a4type; equipo[i].a4type = aux22;
						int aux23 = pc[posicionpc].a1pwr; pc[posicionpc].a1pwr = equipo[i].a1pwr; equipo[i].a1pwr = aux23;
						int aux24 = pc[posicionpc].a2pwr; pc[posicionpc].a2pwr = equipo[i].a2pwr; equipo[i].a2pwr = aux24;
						int aux25 = pc[posicionpc].a3pwr; pc[posicionpc].a3pwr = equipo[i].a3pwr; equipo[i].a3pwr = aux25;
						int aux26 = pc[posicionpc].a4pwr; pc[posicionpc].a4pwr = equipo[i].a4pwr; equipo[i].a4pwr = aux26;
						int aux27 = pc[posicionpc].a1acc; pc[posicionpc].a1acc = equipo[i].a1acc; equipo[i].a1acc = aux27;
						int aux28 = pc[posicionpc].a2acc; pc[posicionpc].a2acc = equipo[i].a2acc; equipo[i].a2acc = aux28;
						int aux29 = pc[posicionpc].a3acc; pc[posicionpc].a3acc = equipo[i].a3acc; equipo[i].a3acc = aux29;
						int aux30 = pc[posicionpc].a4acc; pc[posicionpc].a4acc = equipo[i].a4acc; equipo[i].a4acc = aux30;
						int aux31 = pc[posicionpc].a1pp; pc[posicionpc].a1pp = equipo[i].a1pp; equipo[i].a1pp = aux31;
						int aux32 = pc[posicionpc].a2pp; pc[posicionpc].a2pp = equipo[i].a2pp; equipo[i].a2pp = aux32;
						int aux33 = pc[posicionpc].a3pp; pc[posicionpc].a3pp = equipo[i].a3pp; equipo[i].a3pp = aux33;
						int aux34 = pc[posicionpc].a4pp; pc[posicionpc].a4pp = equipo[i].a4pp; equipo[i].a4pp = aux34;
						int aux35 = pc[posicionpc].a1maxpp; pc[posicionpc].a1maxpp = equipo[i].a1maxpp; equipo[i].a1maxpp = aux35;
						int aux36 = pc[posicionpc].a2maxpp; pc[posicionpc].a2maxpp = equipo[i].a2maxpp; equipo[i].a2maxpp = aux36;
						int aux37 = pc[posicionpc].a3maxpp; pc[posicionpc].a3maxpp = equipo[i].a3maxpp; equipo[i].a3maxpp = aux37;
						int aux38 = pc[posicionpc].a4maxpp; pc[posicionpc].a4maxpp = equipo[i].a4maxpp; equipo[i].a4maxpp = aux38;
						int aux39 = pc[posicionpc].a1cty; pc[posicionpc].a1cty = equipo[i].a1cty; equipo[i].a1cty = aux39;
						int aux40 = pc[posicionpc].a2cty; pc[posicionpc].a2cty = equipo[i].a2cty; equipo[i].a2cty = aux40;
						int aux41 = pc[posicionpc].a3cty; pc[posicionpc].a3cty = equipo[i].a3cty; equipo[i].a3cty = aux41;
						int aux42 = pc[posicionpc].a4cty; pc[posicionpc].a4cty = equipo[i].a4cty; equipo[i].a4cty = aux42;
						contadorpc++;
					} 
				}
				
				int[][] matriuover2 = new int[3][3];
				
					for(int i=0; i<3; i++) {
						for(int g=0; g<3; g++) {
							matriuover2[i][g] = 28;
						}
					}
					
					lista.clear();
					lista2.clear();
					t.overdibuixa(matriuover2);
					estado=9;//mundo
				break;
			case 'e': case 'E':
				// salir del pc
				int[][] matriuover3 = new int[3][3];
				
				for(int i=0; i<3; i++) {
					for(int g=0; g<3; g++) {
						matriuover3[i][g] = 28;
					}
				}
				
				lista.clear();
				lista2.clear();
				t.overdibuixa(matriuover3);
				estado=9;//mundo
				break;
			}
		lista.clear();
		lista2.clear();
	}
	
	private static void healer() {
		// mostrar las pokeballs del healer 
		////dependiendo del numero de pokemons en el equipo
		////// y la posicion del healer
		
		int numequipo=0;
		for(int i=0; i<6; i++) {
			if(equipo[i].nivel>0) {
				numequipo++;
			}
		}
		
		if(contadorh<numequipo) {
			
			switch(contadorh) {
			case 0:
				mapa[healerx][healery]=132;
				contadorh++;
				break;
			case 1:
				mapa[healerx][healery]=133;
				contadorh++;
				break;
			case 2:
				mapa[healerx][healery]=134;
				contadorh++;
				break;
			case 3:
				mapa[healerx][healery]=135;
				contadorh++;
				break;
			case 4:
				mapa[healerx][healery]=136;
				contadorh++;
				break;
			case 5:
				mapa[healerx][healery]=137;
				contadorh++;
				break;
			}
			
		}else {
			mapa[healerx][healery]=6;
			estado=0;
			contadorh=0;
		}
		
		mapamov[0][0]=mapa[posi-3][posj-3]; mapamov[0][1]=mapa[posi-3][posj-2]; mapamov[0][2]=mapa[posi-3][posj-1]; mapamov[0][3]=mapa[posi-3][posj]; mapamov[0][4]=mapa[posi-3][posj+1]; mapamov[0][5]=mapa[posi-3][posj+2]; mapamov[0][6]=mapa[posi-3][posj+3];
		mapamov[1][0]=mapa[posi-2][posj-3]; mapamov[1][1]=mapa[posi-2][posj-2]; mapamov[1][2]=mapa[posi-2][posj-1]; mapamov[1][3]=mapa[posi-2][posj]; mapamov[1][4]=mapa[posi-2][posj+1]; mapamov[1][5]=mapa[posi-2][posj+2]; mapamov[1][6]=mapa[posi-2][posj+3]; 
		mapamov[2][0]=mapa[posi-1][posj-3]; mapamov[2][1]=mapa[posi-1][posj-2]; mapamov[2][2]=mapa[posi-1][posj-1]; mapamov[2][3]=mapa[posi-1][posj]; mapamov[2][4]=mapa[posi-1][posj+1]; mapamov[2][5]=mapa[posi-1][posj+2]; mapamov[2][6]=mapa[posi-1][posj+3];
		mapamov[3][0]=mapa[posi][posj-3]; mapamov[3][1]=mapa[posi][posj-2]; mapamov[3][2]=mapa[posi][posj-1]; mapamov[3][3]=mapa[posi][posj]; mapamov[3][4]=mapa[posi][posj+1]; mapamov[3][5]=mapa[posi][posj+2]; mapamov[3][6]=mapa[posi][posj+3]; 
		mapamov[4][0]=mapa[posi+1][posj-3]; mapamov[4][1]=mapa[posi+1][posj-2]; mapamov[4][2]=mapa[posi+1][posj-1]; mapamov[4][3]=mapa[posi+1][posj]; mapamov[4][4]=mapa[posi+1][posj+1]; mapamov[4][5]=mapa[posi+1][posj+2]; mapamov[4][6]=mapa[posi+1][posj+3];
		mapamov[5][0]=mapa[posi+2][posj-3]; mapamov[5][1]=mapa[posi+2][posj-2]; mapamov[5][2]=mapa[posi+2][posj-1]; mapamov[5][3]=mapa[posi+2][posj]; mapamov[5][4]=mapa[posi+2][posj+1]; mapamov[5][5]=mapa[posi+2][posj+2]; mapamov[5][6]=mapa[posi+2][posj+3];
		mapamov[6][0]=mapa[posi+3][posj-3]; mapamov[6][1]=mapa[posi+3][posj-2]; mapamov[6][2]=mapa[posi+3][posj-1]; mapamov[6][3]=mapa[posi+3][posj]; mapamov[6][4]=mapa[posi+3][posj+1]; mapamov[6][5]=mapa[posi+3][posj+2]; mapamov[6][6]=mapa[posi+3][posj+3];
		
		for(int i8=0; i8<7; i8++) {
			for(int j8=0; j8<7; j8++) {
				mapamovv = mapamovv + mapamov[i8][j8];
			}
		}
		
		t.dibuixa(mapamov);
		
	}

}
