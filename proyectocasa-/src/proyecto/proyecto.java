package proyecto;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class proyecto {
	
	
	//estadisticas augmentan correctamente, se puede quemar, paralizar y envenenar y tiene efecto en las peleas
	//el Pc es un Array de tres dimensiones, donde la primer aes la caja, la segunda son las filas y la tercera son las columnas
	   //para moverte de caja en caja hay que ir asando hacia un lado, el llegar a la ultima caja voveras a la priemra y viceversa.
	     // la clase healer es muy simple, solo cura completamente a los pokemon
	//el movimiento del Entrenador(que es el personaje principal) no funciona correctamenta, ya que hay problemeas al mostrar el mapa
	// se puede canviar de mapa pasando por los carteles (hay tres de prueba), a causa de esto, al no poder imprimir en el mapa el jugador,
	//sino que ir poniendolo en cuanto se mueve, al empezar el juego no aparece en el mapa, pero al moverte por primera vez ya funciona correctamente.
	
	static Pc pcpokemon = new Pc();
	// se puede combatir, se puede curar en combate, se puede capturar el enemigo
	///se puede cambiar de pokemon en combate o intentar huir
	//// se pueden guardar y sacar pokemon del pc 
	            
	////// se puede curar el equipo en el healer
	////////
	
	// w a s d para moverse
	//// c para interactuar (en el equipo se cambia el pokemon seleccionado a la primera posicion)
	////// e para volver al menu anterior (en caso de estar en el mapa abre el equipo)     
	
	static Entrenador personaje = new Entrenador(2);
	
	
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
	
	static int pcx=0;
	static int pcy=0;
	static int cajapc=0;
	
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
	//static int estado=0; 
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
	static int nummap=0;
	static Mapa map = new Mapa(nummap);
	
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
	    
	    // para no complicarme la vida igualo el array antigua del equipo al equipo del Entrenador
	    equipo = personaje.equipo;
	    
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
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<6; j++) {
				for(int k=0; k<6; k++) {
					pcpokemon.pc[i][j][k].npokedex=160;
				}
			}
		}
			
	
	}
	
	private static void doStuff() {
		
		switch(personaje.estado) {
		case 0: //el mapa principal
			mundo();
			break;
		case 1: //menu de combate
			numpoke=1;
			for(int i=0; i<6; i++) {
				
				if(equipo[i].estado!=0) {
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
			enemigo.estado=0;
			combates=false;
			boolean derrota = false;
			fincombate(derrota, enemigo);
			personaje.estado=0;
		}else if(vidamaxsalvaje<=vidasalvaje&&enemigo.hp>0) {
			personaje.estado=1;
			}
		
		
		
	}

	private static void mundo(){
		

		
		contador=0;
		/*mapav="";
		mapamov[0][0]=mapa[posi-3][posj-3]; mapamov[0][1]=mapa[posi-3][posj-2]; mapamov[0][2]=mapa[posi-3][posj-1]; mapamov[0][3]=mapa[posi-3][posj]; mapamov[0][4]=mapa[posi-3][posj+1]; mapamov[0][5]=mapa[posi-3][posj+2]; mapamov[0][6]=mapa[posi-3][posj+3];
		mapamov[1][0]=mapa[posi-2][posj-3]; mapamov[1][1]=mapa[posi-2][posj-2]; mapamov[1][2]=mapa[posi-2][posj-1]; mapamov[1][3]=mapa[posi-2][posj]; mapamov[1][4]=mapa[posi-2][posj+1]; mapamov[1][5]=mapa[posi-2][posj+2]; mapamov[1][6]=mapa[posi-2][posj+3]; 
		mapamov[2][0]=mapa[posi-1][posj-3]; mapamov[2][1]=mapa[posi-1][posj-2]; mapamov[2][2]=mapa[posi-1][posj-1]; mapamov[2][3]=mapa[posi-1][posj]; mapamov[2][4]=mapa[posi-1][posj+1]; mapamov[2][5]=mapa[posi-1][posj+2]; mapamov[2][6]=mapa[posi-1][posj+3];
		mapamov[3][0]=mapa[posi][posj-3]; mapamov[3][1]=mapa[posi][posj-2]; mapamov[3][2]=mapa[posi][posj-1]; mapamov[3][3]=mapa[posi][posj]; mapamov[3][4]=mapa[posi][posj+1]; mapamov[3][5]=mapa[posi][posj+2]; mapamov[3][6]=mapa[posi][posj+3]; 
		mapamov[4][0]=mapa[posi+1][posj-3]; mapamov[4][1]=mapa[posi+1][posj-2]; mapamov[4][2]=mapa[posi+1][posj-1]; mapamov[4][3]=mapa[posi+1][posj]; mapamov[4][4]=mapa[posi+1][posj+1]; mapamov[4][5]=mapa[posi+1][posj+2]; mapamov[4][6]=mapa[posi+1][posj+3];
		mapamov[5][0]=mapa[posi+2][posj-3]; mapamov[5][1]=mapa[posi+2][posj-2]; mapamov[5][2]=mapa[posi+2][posj-1]; mapamov[5][3]=mapa[posi+2][posj]; mapamov[5][4]=mapa[posi+2][posj+1]; mapamov[5][5]=mapa[posi+2][posj+2]; mapamov[5][6]=mapa[posi+2][posj+3];
		mapamov[6][0]=mapa[posi+3][posj-3]; mapamov[6][1]=mapa[posi+3][posj-2]; mapamov[6][2]=mapa[posi+3][posj-1]; mapamov[6][3]=mapa[posi+3][posj]; mapamov[6][4]=mapa[posi+3][posj+1]; mapamov[6][5]=mapa[posi+3][posj+2]; mapamov[6][6]=mapa[posi+3][posj+3];
		
		mapamovv="";
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				mapamovv = mapamovv + mapamov[i][j];
			}
		}
		*/
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
		
		// crea el mapa con la clase Mapa
		
		int[][] mapamundo = map.craermapa(posi, posj, nummap);
		
		String mapamundov = map.mostrarmapa(mapamundo);
		
		t.setImgbackground("background.jpg");
		t2.setImgbackground("backgroundopcion.jpg");
		t.dibuixa(mapamundo);
		t2.dibuixa(segundapantalla);
		t.overdibuixa(matriuover);
		System.out.println(mapamundov);
		System.out.println(segundapantallav);
		
		char movimiento = f.getActualChar();
		char mov = f.getUltimChar();
		
		//personaje.movimiento(movimiento, map, nummap, posi, posj, mov);
		
			switch(movimiento) {
			case 'w': case 'W': case 's': case 'S': case 'a': case 'A': case 'd': case 'D':
				movimiento(movimiento, map);
				
				break;
			case 'c': case 'C':
				accion();
				break;
			case 'e': case 'E':
				personaje.estado=4;// equipo
				break;
			}
			numpoke=0;
		 System.out.println("mundo");
		if(combates==true&&personaje.estado==0) {
			numpociones=10;
			enemigo =salvaje();
			poshudi=0; poshudj=1;
			personaje.estado=1; //combate
		}
		
	}
	
	private static void movimiento(char movimiento, Mapa map) {
		// redirección del movimiento en las cuatro direcciones
		
		int num1 = nummap;
		
		switch(nummap) {
		case 0:
			switch(f.getUltimChar()) {
			case 'd': case 'D':
				if(map.mapas[nummap][posi][posj+1]==4) {
					nummap++;
					map.mapas[nummap][posi][posj]=28;
					map = new Mapa(nummap);
					posi = 4; posj = 3;
					auxp=28;
					map.mapas[nummap][posi][posj]=9;
				}
				break;
			}
			break;
		case 1:
			switch(f.getUltimChar()) {
			case 'a': case 'A':
				if(map.mapas[nummap][posi][posj-1]==4) {
					nummap--;
					map.mapas[nummap][posi][posj]=28;
					map = new Mapa(nummap);
					posi = 5; posj = 14;
					auxp=28;
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
					auxp=28;
					map.mapas[nummap][posi][posj]=9;
				}
				break;
			}
			break;
		}
		
		int num2 = nummap;
		
		if(num1==num2) {
			
		
		if(movimiento=='w'||movimiento=='W') {
			if(map.mapas[nummap][posi-1][posj]==7||map.mapas[nummap][posi-1][posj]==5||map.mapas[nummap][posi-1][posj]==6||map.mapas[nummap][posi-1][posj]==11) {
				map.mapas[nummap][posi][posj]=10;
			}else {
				if(map.mapas[nummap][posi-1][posj]==2) {
					map.mapas[nummap][posi][posj]=auxp;
					auxp=map.mapas[nummap][posi-1][posj];
					map.mapas[nummap][posi-1][posj]=42;
					posi--;
				}else {
					map.mapas[nummap][posi][posj]=auxp;
					auxp=map.mapas[nummap][posi-1][posj];
					map.mapas[nummap][posi-1][posj]=10;
					posi--;
				}
				if(map.mapas[nummap][posi][posj]==39||map.mapas[nummap][posi][posj]==40||map.mapas[nummap][posi][posj]==41||map.mapas[nummap][posi][posj]==42) {
					int random = (int) (Math.random()*5);
					if(random%2==0&&equipo[0].hp>0) {
						combates=true;
					}
				}
			}
		}
		if(movimiento=='s'||movimiento=='S') {
			if(map.mapas[nummap][posi+1][posj]==7||map.mapas[nummap][posi+1][posj]==6||map.mapas[nummap][posi+1][posj]==5) {
				map.mapas[nummap][posi][posj]=1;	
				}else {
					if(map.mapas[nummap][posi+1][posj]==11) {
						map.mapas[nummap][posi][posj]=auxp;
						auxp=map.mapas[nummap][posi+2][posj];
						map.mapas[nummap][posi+2][posj]=1;
						posi=posi+2;
					}else {
						if(map.mapas[nummap][posi+1][posj]==2) {
							map.mapas[nummap][posi][posj]=auxp;
							auxp=map.mapas[nummap][posi+1][posj];
							map.mapas[nummap][posi+1][posj]=39;
							posi++;
						}else {
							map.mapas[nummap][posi][posj]=auxp;
							auxp=map.mapas[nummap][posi+1][posj];
							map.mapas[nummap][posi+1][posj]=1;
							posi++;
						}
						if(map.mapas[nummap][posi][posj]==39||map.mapas[nummap][posi][posj]==40||map.mapas[nummap][posi][posj]==41||map.mapas[nummap][posi][posj]==42) {
							int random = (int) (Math.random()*5);
							if(random%2==0&&equipo[0].hp>0) {
								combates=true;
							}
						}
					}}
		}
		if(movimiento=='a'||movimiento=='A') {
			if(map.mapas[nummap][posi][posj-1]==7||map.mapas[nummap][posi][posj-1]==5||map.mapas[nummap][posi][posj-1]==6||map.mapas[nummap][posi][posj-1]==11) {
				map.mapas[nummap][posi][posj]=8;	
				}else {
					if(map.mapas[nummap][posi][posj-1]==2) {
						map.mapas[nummap][posi][posj]=auxp;
						auxp=map.mapas[nummap][posi][posj-1];
						map.mapas[nummap][posi][posj-1]=40;
						posj--;
					}else {
						map.mapas[nummap][posi][posj]=auxp;
						auxp=map.mapas[nummap][posi][posj-1];
						map.mapas[nummap][posi][posj-1]=8;
						posj--;
					}
					if(map.mapas[nummap][posi][posj]==39||map.mapas[nummap][posi][posj]==40||map.mapas[nummap][posi][posj]==41||map.mapas[nummap][posi][posj]==42) {
						int random = (int) (Math.random()*5);
						if(random%2==0&&equipo[0].hp>0) {
							combates=true;
						}
					}
				}
		}
		if(movimiento=='d'||movimiento=='D') {
			if(map.mapas[nummap][posi][posj+1]==7||map.mapas[nummap][posi][posj+1]==6||map.mapas[nummap][posi][posj+1]==5||map.mapas[nummap][posi][posj+1]==11) {
				map.mapas[nummap][posi][posj]=9;
			}else {
				
				 if(map.mapas[nummap][posi][posj+1]==2) {
						map.mapas[nummap][posi][posj]=auxp;
						auxp=map.mapas[nummap][posi][posj+1];
						map.mapas[nummap][posi][posj+1]=41;
						posj++;
				}else {
					map.mapas[nummap][posi][posj]=auxp;
					auxp=map.mapas[nummap][posi][posj+1];
					map.mapas[nummap][posi][posj+1]=9;
					posj++;
				}
				if(map.mapas[nummap][posi][posj]==39||map.mapas[nummap][posi][posj]==40||map.mapas[nummap][posi][posj]==41||map.mapas[nummap][posi][posj]==42) {
					int random = (int) (Math.random()*5);
					if(random%2==0&&equipo[0].hp>0) {
						combates=true;
					}
				}
			}
		}
		
		}
		
		
		
	}
	
	private static void accion() {
		// diferentes opciones al pulsar la "c", como curar, o acceder al pc
		
		if((map.mapas[nummap][posi+1][posj]==6&&map.mapas[nummap][posi][posj]==1)||(map.mapas[nummap][posi-1][posj]==6&&map.mapas[nummap][posi][posj]==10)||(map.mapas[nummap][posi][posj+1]==6&&map.mapas[nummap][posi][posj]==9)||(map.mapas[nummap][posi][posj-1]==6&&map.mapas[nummap][posi][posj]==8)) {
			
			//mira la posicion del healer para saber donde modificarlo a la hora de curar
			
			if((map.mapas[nummap][posi+1][posj]==6&&map.mapas[nummap][posi][posj]==1)){
				healerx=posi+1;
				healery=posj;
			}
			
			if((map.mapas[nummap][posi-1][posj]==6&&map.mapas[nummap][posi][posj]==10)) {
				healerx=posi-1;
				healery=posj;
			}
			
			if((map.mapas[nummap][posi][posj+1]==6&&map.mapas[nummap][posi][posj]==9)) {
				healerx=posi;
				healery=posj+1;
			}
			
			if((map.mapas[nummap][posi][posj-1]==6&&map.mapas[nummap][posi][posj]==8)) {
				healerx=posi;
				healery=posj-1;
			}
			
			
			
			Healer h = new Healer();
			//reestablece vida y pps de los ataques del array de Pokemon que le pasas
			h.healer(equipo);
			
			personaje.estado=7;//healer
		
		} else {
			if(map.mapas[nummap][posi-1][posj]==5&&map.mapas[nummap][posi][posj]==10) {
				posmenupci=0;
				personaje.estado=9; // menu del pc
			}
		}
		
	}
	
	private static Pokemon salvaje() {
		// genera el pokemon salvaje
		
		Pokemon salvaje = new Pokemon();
		int numsalvaje = (int) ((Math.random())*3);
		switch(numsalvaje) {
		
		case 0:  //pikachu
			
			salvaje = new Pokemon("Pikachu");
			
			break;
		case 1:  //pidgey
			
			salvaje = new Pokemon("Pidgey");
			
			break;
		case 2:  //growlithe
			
			salvaje = new Pokemon("Growlithe");
			
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
		case 2: // growlithe
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
			
			numpoke=0;
			for(int i=0; i<6; i++) {
				if(equipo[i].hp<=0) {
					numpoke++;
				}
			}
			
			//calcula el numero de pokemons usables
			if(equipo[0].hp<=0) {
				equipo[0].debilitado();
				if(numpoke>0) {
					personaje.estado=4; // equipo
				}else {
					personaje.estado=0; //mundo
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
					if(equipo[0].ataques[0].pp==0&&equipo[0].ataques[1].pp==0&&equipo[0].ataques[2].pp==0&&equipo[0].ataques[3].pp==0) {
						enemigo.hp = enemigo.hp - ((equipo[0].atk+equipo[0].satk)/(2));
						if(enemigo.hp<=0) {
							personaje.estado=2; //mostrar vida
						}
						equipo[0].hp = equipo[0].hp - ((equipo[0].atk+equipo[0].satk)/(2));
						if(equipo[0].hp<=0) {
							equipo[0].debilitado();
							numpoke--;
							if(numpoke>0) {
								
								for(int i=0; i<10; i++) {
									for(int j=0; j<6; j++) {
										lvls[i][j]=28;
									}
								}
								t.dibuixa(lvls);
								
								personaje.estado=4; // equipo
							}else {
								personaje.estado=2;//mostrar vida
							}
						}
					}else {
						//caso que queden pps en algun ataque
						personaje.estado=5; // ataques
					}
				} else { ///entrar al menu de la bolsa
					if(poshudi==1&&poshudj==0) {
						personaje.estado=10; // bolsa
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
								personaje.estado=0; //mundo
							} else {
								
								equipo[0].turnocombate(enemigo, new Ataques());
								personaje.estado = 2;
								if(equipo[0].hp<=0) {
									equipo[0].debilitado();
									numpoke--;
									if(numpoke>0) {
										
										for(int i=0; i<10; i++) {
											for(int j=0; j<6; j++) {
												lvls[i][j] = 28;
											}
										}
										t.overdibuixa(lvls);
										
										personaje.estado=4; // equipo
									}else {
										personaje.estado=2; // mostrar vida
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
								
								personaje.estado=4;// equipo
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
				break;
			case 1:
				x1=0; y1=1;
				x2=1; y2=1;
				x3=2; y3=1;
				break;
			case 2:
				x1=3; y1=0;
				x2=4; y2=0;
				x3=5; y3=0;
				break;
			case 3:
				x1=3; y1=1;
				x2=4; y2=1;
				x3=5; y3=1;
				break;
			}
			
			ataque = equipo[0].ataques[i].name;
			type = equipo[0].ataques[i].type;
			pps = equipo[0].ataques[i].pp;
			
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
			
			if(posluchari==0&&poslucharj==0&&equipo[0].ataques[0].pp>0) {
				ataqueescojido=0;
				equipo[0].ataques[0].pp--;
				matriuover[0][0] = 28;
				matriuover[0][1] = 28;
				matriuover[1][0] = 28;
				matriuover[1][1] = 28;
				t2.overdibuixa(matriuover);
				personaje.estado=6;
			}
			if(posluchari==0&&poslucharj==1&&equipo[0].ataques[1].pp>0) {
				ataqueescojido=1;
				equipo[0].ataques[1].pp--;
				matriuover[0][0] = 28;
				matriuover[0][1] = 28;
				matriuover[1][0] = 28;
				matriuover[1][1] = 28;
				t2.overdibuixa(matriuover);
				personaje.estado=6;
			}
			if(posluchari==3&&poslucharj==0&&equipo[0].ataques[2].pp>0) {
				ataqueescojido=2;
				equipo[0].ataques[2].pp--;
				matriuover[0][0] = 28;
				matriuover[0][1] = 28;
				matriuover[1][0] = 28;
				matriuover[1][1] = 28;
				t2.overdibuixa(matriuover);
				personaje.estado=6;
			}
			if(posluchari==3&&poslucharj==1&&equipo[0].ataques[2].pp>0) {
				ataqueescojido=3;
				equipo[0].ataques[2].pp--;
				matriuover[0][0] = 28;
				matriuover[0][1] = 28;
				matriuover[1][0] = 28;
				matriuover[1][1] = 28;
				t2.overdibuixa(matriuover);
				personaje.estado=6;
			}
			break;
		case 'e': case 'E':
			/// vuelve el menu de combate
			matriuover[0][0] = 28;
			matriuover[0][1] = 28;
			matriuover[1][0] = 28;
			matriuover[1][1] = 28;
			t2.overdibuixa(matriuover);
			personaje.estado=1; //combate
			break;
		}
		
	}
	
	private static Pokemon daño(Pokemon enemigo, int prioridad) {
		// orden de ataque en funcion de la prioridad (funcion verrapidez)
		

		vidamaxpoke=((equipo[0].hp*100)/equipo[0].maxhp);
		vidamaxsalvaje=((enemigo.hp*100)/enemigo.maxhp);
		
		equipo[0].turnocombate(enemigo, equipo[0].ataques[ataqueescojido]);
		
		personaje.estado=2; // mostrar vida
		if(enemigo.hp<=0) {
			enemigo.debilitado();
		}
		if(equipo[0].hp<=0) {
			equipo[0].debilitado();
			numpoke--;
			if(numpoke>0) {
				personaje.estado=4; // equipo	
			}
		}
		
		vidapoke=((equipo[0].hp*100)/equipo[0].maxhp);
		vidasalvaje=((enemigo.hp*100)/enemigo.maxhp);
		
		
		return enemigo;
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
					personaje.estado=11;
				}else {
					if(accionbolsa==1) {
						if(numpociones>0) {
							
							equipo[0].curar(200);
							numpociones--;
							
							//combate en el que solo ataca el rival al pasarle como ataque el numero 0
							equipo[0].turnocombate(enemigo, new Ataques());
							
							if(equipo[0].hp<=0) {
								equipo[0].hp=0;
								numpoke--;
								if(numpoke>0) {
									personaje.estado=4;
									//equipo();
								}else {
									personaje.estado=2;//mostrar como baja la vida
								}
							}
						}
						personaje.estado=1;
					}
				}
				break;
			case 'e': case 'E':
				//para salir del menu de la bolsa al menu de combate
				personaje.estado=1;
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

				//combate en el que solo ataca el rival al pasarle como ataque el numero 0
				equipo[0].turnocombate(enemigo, new Ataques());
				
				if(equipo[0].hp<=0) {
					equipo[0].hp=0;
					numpoke--;
					if(numpoke>0) {
						personaje.estado=4; // equipo
					}else {
						personaje.estado=2;
					}
				}else {
					personaje.estado=1;
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

				//combate en el que solo ataca el rival al pasarle como ataque el numero 0
				equipo[0].turnocombate(enemigo, new Ataques());
				
				if(equipo[0].hp<=0) {
					equipo[0].debilitado();
					numpoke--;
					if(numpoke>0) {
						personaje.estado=4; // equipo
					}else {
						personaje.estado=2;
					}
				}else {
					personaje.estado=1;
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

				//combate en el que solo ataca el rival al pasarle como ataque el numero 0
				equipo[0].turnocombate(enemigo, new Ataques());
				
				if(equipo[0].hp<=0) {
					equipo[0].debilitado();
					numpoke--;
					if(numpoke>0) {
						personaje.estado=4; // equipo
					}else {
						personaje.estado=2;
					}
				}else {
					personaje.estado=1;
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
			pcpokemon.guardar(pcpokemon, enemigo);
			t2.setImgbackground("background.jpg");
			combates=false;
			boolean derrota = false;
			fincombate(derrota, enemigo);
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
				if(equipo[i].npokedex>=0&&equipo[0].maxhp>0) {
						if (equipo[i].hp>0) {
							porcentaje = (equipo[i].hp * 100);
							porcentaje = porcentaje / equipo[i].maxhp;
						}else {
							porcentaje=0;
						}
					menuequipo[x2][y2]=fotoshp[porcentaje];
				}else if(equipo[i].maxhp<=0) {
					porcentaje=0;
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
					
					pcpokemon.guardar(pcpokemon, equipo[posicion]);
					contador++;		
							
							
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
									System.out.println(posicioncambio+" "+posicioncambio2);
									pcpokemon.cambio(equipo[posicioncambio2], equipo[posicioncambio]);
									posicioncambio++;
									posicioncambio2++;
									contadorc--;
								}
							}
						}
						//salida del menu y limpieza de la matriz overdraw
						guardar=false;
						personaje.estado=9;
						int[][] matriuover2 =
				        	{
				            		{28,28,},
				            		{28,28,},
				            		{28,28,},
				        	};
				        t2.overdibuixa(matriuover2);
						
					}else {
						guardar=false;
						personaje.estado=9;
						
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
							pcpokemon.cambio(equipo[0], equipo[posicion]);
							
					}else {
					//// en caso de combate se recibira daño
						// y se comprovara el estado de derrota, etc
					if(combates) {
						System.out.println("hola");
						numpoke=0;
						for(int i=0; i<6; i++) {
							if(equipo[i].hp>0) {
								numpoke++;
							}
						}
						
						if(numpoke==0) {
							personaje.estado=0; // mundo
						}
						

						//combate en el que solo ataca el rival al pasarle como ataque el numero 0
						equipo[0].turnocombate(enemigo, new Ataques());
						
						if(equipo[0].hp<=0) {
							equipo[0].debilitado();
							numpoke--;
							if(numpoke>0) {
								equipo();
							}else {
								personaje.estado=2;
							}
						}personaje.estado=2;//combate
					}
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
					
					numpoke=0;
					for(int i=0; i<6; i++) {
						if(equipo[i].hp>0) {
							numpoke++;
						}
					}
					
					if(numpoke==0) {
						combates=false;
						personaje.estado=0; // mundo
					}else {
						if(equipo[posicion].hp>0) {

							//combate en el que solo ataca el rival al pasarle como ataque el numero 0
							equipo[0].turnocombate(enemigo, new Ataques());
							
							if(equipo[0].hp<=0) {
								equipo[0].debilitado();
								numpoke--;
								if(numpoke>0) {
									equipo();
								}else {
									personaje.estado=2;
								}
							}personaje.estado=2;//combate
						}
						
						personaje.estado=2;//combate
					}
					int[][] matriuover2 =
			        	{
			            		{28,28,},
			            		{28,28,},
			            		{28,28,},
			        	};
			        t2.overdibuixa(matriuover2);
				}else {
					if (guardar) {
						personaje.estado = 9;//menu pc
						int[][] matriuover2 = { 
								{ 28, 28, }, 
								{ 28, 28, }, 
								{ 28, 28, }, 
						};
						t2.overdibuixa(matriuover2);
					}else {
						personaje.estado=0;
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
			
			
			equipo[0].exp = (int) (equipo[0].exp + ((enemigo.nivel*enemigo.getExpbase())/(7))); 
			
			if(equipo[0].exp==equipo[0].totexp) {
				equipo[0].exp=0;
				
				//calculo de la experiencia total respecto al nivel
				for(int j=0; j<2; j++) {
					equipo[0].totexp = equipo[0].totexp + (equipo[0].nivel*equipo[0].nivel);  
				}
				equipo[0].lvlup();
				
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
							
							equipo[0].lvlup();
							
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
		personaje.estado=0;//mostrar vida
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
					posmenuequipoi=0;
					posmenuequipoj=0;
					guardar=true;
					posicion=0;
					personaje.estado=4;//equipo (para guardar)
					bmenupc=false;
					break;
				case 1:
					possacari=0;
					possacarj=0;
					pcx=0;
					pcy=0;
					cajapc=0;
					personaje.estado=8;//sacar del pc
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
				
				personaje.estado=0;
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
			for(int j=0; j<6; j++) {
				for(int k=0; k<6; k++) {
					if(pcpokemon.pc[i][j][k].nivel>0&&lista.size()<360) {
						lista.add(pcpokemon.pc[i][j][k].npokedex);
						lista2.add(i);
					}else {
						lista2.add(160);
						lista.add(160);
					}
				}
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
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				matriuover[i][j]=28;
			}
		}
		
		pokemonspc = pcpokemon.crearcaja(pcpokemon, cajapc);
		pokemonspcv="";
		pokemonspcv = pcpokemon.mostrarcaja(pokemonspc);
		
		matriuover[possacari][possacarj]=131;
		
		switch(cajapc) {
		case 0:
			t.setImgbackground("caja1.png");
			break;
		case 1:
			t.setImgbackground("caja2.png");
			break;
		case 2:
			t.setImgbackground("caja3.png");
			break;
		case 3:
			t.setImgbackground("caja4.png");
			break;
		case 4:
			t.setImgbackground("caja5.png");
			break;
		case 5:
			t.setImgbackground("caja6.png");
			break;
		case 6:
			t.setImgbackground("caja7.png");
			break;
		case 7:
			t.setImgbackground("caja8.png");
			break;
		case 8:
			t.setImgbackground("caja9.png");
			break;
		case 9:
			t.setImgbackground("caja10.png");
			break;
		
		
		}
		t.overdibuixa(matriuover);
		t.dibuixa(pokemonspc);
		System.out.println(pokemonspcv);
		
		
		//moverse por el pc
			char opcionpc = f.getActualChar();
			switch(opcionpc) {
			case 'w': case 'W':
				if(possacari==0) {
					
				}else {
					possacari--;
				}
				break;
			case 's': case 'S':
				if(possacari==5) {
					
				}else {
					possacari++;
				}
				break;
			case 'a': case 'A':
				if(possacarj==0) {
					cajapc--;
					if(cajapc==-1) {
						cajapc=9;
					}
					possacarj+=5;
				}else {
					possacarj--;
				}
				break;
			case 'd': case 'D':
				if(possacarj==5) {
					cajapc++;
					if(cajapc==10) {
						cajapc=0;
					}
					possacarj-=5;
				}else {
					possacarj++;
				}
				break;
			case 'c': case 'C':
				int contadorpc=0;
				//// coje la posicion del pc de la lista respecto a la posicion de la matriz
				// siempre que se haya seleccionado un pokemon y no un lugar en blanco
				
				for (int i = 0; i < 6; i++) {
					if (pokemonspc[possacari][possacarj] != 160 && contadorpc == 0 && equipo[i].nivel==0) {
						System.out.println("esto funciona");
						pcpokemon.cambio(equipo[i], pcpokemon.pc[0][possacari][possacarj]);
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
					t.setImgbackground("background.jpg");
					personaje.estado=9;//mundo
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
				personaje.estado=9;//mundo
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
				map.mapas[nummap][healerx][healery]=132;
				contadorh++;
				break;
			case 1:
				map.mapas[nummap][healerx][healery]=133;
				contadorh++;
				break;
			case 2:
				map.mapas[nummap][healerx][healery]=134;
				contadorh++;
				break;
			case 3:
				map.mapas[nummap][healerx][healery]=135;
				contadorh++;
				break;
			case 4:
				map.mapas[nummap][healerx][healery]=136;
				contadorh++;
				break;
			case 5:
				map.mapas[nummap][healerx][healery]=137;
				contadorh++;
				break;
			}
			
		}else {
			map.mapas[nummap][healerx][healery]=6;
			personaje.estado=0;
			contadorh=0;
		}
		
		mapamov = map.craermapa(posi, posj, nummap);
		
		mapamovv = map.mostrarmapa(mapamov);
		
		t.dibuixa(mapamov);
		System.out.println(mapamovv);
	}

}
