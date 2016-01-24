import java.io.*;
import java.util.*;
import physics.*;

public class Game {

    //Instance Vars

    //change these constants to choose which topics to focus on
    public final static int kinQs = 2; // Kinematics
    public final static int motQs = 2; // Motion
    public final static int proQs = 2; // Projectiles
    public final static int forQs = 2; // Force
    public final static int momQs = 2; // Momentum
    public final static int eneQs = 2; // Energy
    public final static int cirQs = 2; // Circular

    private boolean gameOver; // hp at 0? answer all questions?

    private InputStreamReader isr;
    private BufferedReader in;

    public Game() {
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }

    //====================================================

    public static void newGame() {

	String prt = "";
	String name = "";
	//==============INTRODUCTION=====================
	prt = "\n";
	System.out.print( prt );

	pause(1000);

	prt = "\t\tA long time ago in a galaxy far,\n\t\tfar away...\n\n";
	System.out.print( prt );

	pause(3000);

	prt =
"\n                    8888888888  888    88888" +
"\n                   88     88   88 88   88  88" +
"\n                    8888  88  88   88  88888" +
"\n                       88 88 888888888 88   88" +
"\n                88888888  88 88     88 88    888888" +
"\n " +
"\n                88  88  88   888    88888    888888" +
"\n                88  88  88  88 88   88  88  88" +
"\n                88 8888 88 88   88  88888    8888" +
"\n                 888  888 888888888 88   88     88" +
"\n                  88  88  88     88 88    8888888";
	prt += "\n\n\n";

    System.out.print( prt );
    pause(1000);
    prt =
"                            EPISODE IV\n\n" + 
"                            A NEW HOPE" +
	"\n\n";
    System.out.print(prt);
    pause(2000);
    prt = 
"\t\t    It is a period of civil war.\n" +
"\t\t     Rebel spaceships, striking\n" +
"\t\t    from a hidden base, have won\n" +
"\t\t    their first victory against\n" +
"\t\t      the evil Galactic Empire.\n"+
	"\n\n";
    System.out.print(prt);
    pause(5000);
    prt =
"\t\t      During the battle, Rebel\n" +
"\t\t    spies managed to steal secret\n" +
"\t\t        plans to the Empire's\n" +
"\t\t     ultimate weapon, the DEATH\n" +
"\t\t       STAR, an armored space\n" +
"\t\t      station with enough power\n" +
"\t\t     to destroy an entire planet." +
	"\n\n";
    System.out.print(prt);
    pause(5000);
    prt = 
"\t\t       Pursued by the Empire's\n" +
"\t\t      sinister agents, Princess\n" +
"\t\t      Leia races home aboard her\n" +
"\t\t      starship, custodian of the\n" +
"\t\t    stolen plans that can save her\n" +
"\t\t         people and restore\n" +
"\t\t      freedom to the galaxy...." +
	"\n\n";
    System.out.print(prt);
    pause(5000);
	//================END OF INTRO================
    }//end of newGame()
    //====================================================

    public static void pause(int time) {
	try {
	    Thread.sleep(time);//1000 milliseconds
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
    }//end of pause()

    public void kinSec() { //calls Kinematics questions
	while(kinQs > 0) {
	    Kinematics question = new Kinematics();
	}
    }//enf of kinSec

    public static void main(String[] args){
	newGame();
    }//end of main

}//end of Driver
