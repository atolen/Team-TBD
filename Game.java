import java.io.*;
import java.util.*;

public class Game {

    //Instance Vars
    private Jedi luke = new Jedi(); //character
    
    //change these constants to choose which topics to focus on
    public final static int kinQs = 2; // Kinematics
    public final static int proQs = 2; // Projectiles

    private boolean gameOver; // hp at 0? answer all questions?
    private ArrayList<String> find = new ArrayList<String>(); // what must the user find?
    private double userAns; // holds user answer

    private int hintCount = 0;
    private final int hintCap = 5;

    private InputStreamReader isr;
    private BufferedReader in;

    public Game() {
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
    }

    //====================================================

    public void newGame() {
	String prt = "";
	String name = "";
	//==============INTRODUCTION=====================
	prt = "\n";
	System.out.print( prt );
	/*
	pause(1000);

	prt = "\t\tA long time ago in a galaxy far,\n\t\tfar away...\n\n";
	System.out.print( prt );

	pause(2000);

	prt =
	    "\t        ________________.  ___     .______  \n" +
	    "\t       /                | /   \\    |   _  \\ \n" +
	    "\t      |   (-----|  |----`/  ^  \\   |  |_)  | \n" +
	    "\t       \\   \\    |  |    /  /_\\  \\  |      / \n" +
	    "\t  .-----)   |   |  |   /  _____  \\ |  |\\  \\-------. \n" +
	    "\t  |________/    |__|  /__/     \\__\\| _| `.________| \n" +
	    "\t   ____    __    ____  ___     .______    ________. \n" +
	    "\t   \\   \\  /  \\  /   / /   \\    |   _  \\  /        | \n" +
	    "\t    \\   \\/    \\/   / /  ^  \\   |  |_)  ||   (-----` \n" +
	    "\t     \\            / /  /_\\  \\  |      /  \\   \\ \n" +
	    "\t      \\    /\\    / /  _____  \\ |  |\\  \\---)   | \n" +
	    "\t       \\__/  \\__/ /__/     \\__\\|__| `._______/ \n\n" ;

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
	    "\t\t     the evil Galactic Empire.\n"+
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
	
	System.out.println("Greetings, young one! What do you call yourself?");
	name();
	System.out.println("Welcome, " + luke.getName() +".\n");
	pause(1000);

	prt = "You are about to embark on a journey throughout the galaxy, learning the ways of the Force and other vectors to battle the Empire.\n";
	prt += "In order to proceed and follow your destiny to become a physics BOSS, you must apply the laws of the universe (mechanical equations) in every given scenario, and find the missing component correctly.\n";
	System.out.print( prt + "\n" );
	pause(15000);

	prt = "PLEASE NOTE: The point of this game is to help people practice physics!\n";
	prt += "If for some reason our program gives you the wrong answer, you have the option of overriding it.\n";
	prt += "But have caution! The practice is for your own good, so the only person who will suffer most certain death is not you the Jedi, but you the student.\n";
	System.out.print( prt + "\n" );
	pause(5000);

	System.out.println("Good luck! May the Force be with you."); */
	//================END OF INTRO================
	kinSec();
	
	//==================THE MEAT==================
	/*
	prt = "\nFar off in a distant galaxy, the starship belonging to Princess Leia, a young member of the Imperial Senate,\n @-_-@ \n";
	prt += " is intercepted in the course of a secret mission by a massive Imperial Star Destroyer. An imperial boarding party blasts its way onto the captured vessel, and after a fierce firefight the crew of Leia’s ship is subdued.\n";
	prt += "The dark, forbidding figure of Darth Vader appears\n";
prt += 
"\n         _.-'~~~~~~`-._                    " +
"\n        /      ||      \\                   " + 
"\n       /       ||       \\                  " +
"\n      |        ||        |                 " +
"\n      | _______||_______ |                 " + 
"\n      |/ ----- \\/ ----- \\|                 " +
"\n     /  (     )  (     )  \\                " +
"\n    / \\  ----- () -----  / \\               " +
"\n   /   \\      /||\\      /   \\              " +
"\n  /     \\    /||||\\    /     \\             " +
"\n /       \\  /||||||\\  /       \\            " +
"\n/_        \\o========o/        _\\           " +
"\n  `--...__|`-._  _.-'|__...--'             " +
"\n          |    `'    |                     " +
"\n\n";
System.out.print( prt );
pause(2000);

prt = "brutally interrogating the crew and ordering his stormtroopers to search the ship for the secret documents he believes it is carrying: the technical readouts for the Empire’s mightiest weapon—a planet-sized battle station called the Death Star. In the confusion, Princess Leia slips away and hides the secret documents, as well as a recorded plea for help, in the memory of R2-D2, a maintenance droid.Leia is taken prisoner, but R2 gets away in an escape pod, along with his best friend, the protocol droid C-3PO.\n";
prt += 
"                  .-.                                \n" +
"                 /_ _\\                              \n" +
"                 |o^o|                               \n" +
"                 \\ _ /                              \n" +
"                .-'-'-.                              \n" +
"              /`)  .  (`\\                           \n" +
"             / /|.-'-.|\\ \\                         \n" +
"             \\ \\| (_) |/ /  .-\"\"-.               \n" +
"              \\_\\'-.-'/_/  /[] _ _\\               \n" +
"              /_/ \\_/ \\_\\ _|_o_LII|_              \n" +
"                |'._.'|  / | ==== | \\               \n" +
"                |  |  |  |_| ==== |_|                \n" +
"                 \\_|_/    ||\" ||  ||               \n" +
"                 |-|-|    ||LI  o ||                 \n" +
"                 |_|_|    ||'----'||                 \n" +
"                /_/ \\_\\  /__|    |__\\             ";
System.out.println(prt);
pause(1500); */
    }//end of newGame()
    //====================================================

    //pause(int time) pauses program for time milliseconds
    public static void pause(int time) {
	try {
	    Thread.sleep(time);//time in milliseconds
	} catch(InterruptedException e) {
	    Thread.currentThread().interrupt();
	}
    }//end of pause()

    //fingFind() finds what the user has to find
    public String findFind(Question ques) {
	Set<String> poo = ques.unknowns.keySet();
	for(String key : poo) {
	    find.add(key);
	}
	String ret = "";
	for(String s : find) {
	    ret += s + " ";
	}
	return ret;
    }//end of findFind()

    //compareAnswer() checks if input answer is deemed "close enough"
    public boolean compareAnswer(Question q, String key) {
	if( q instanceof Kinematics ) { ((Kinematics)q).calculate(); }
	else if( q instanceof Projectiles) { ((Projectiles)q).calculate(); }
	return Question.compare(userAns, q, key);
    }//end of compareAnswer()

    //getAnswer() gets the inputed answer to question
    public void getUserAnswer(Question q) {
	//	findFind(q);
	for(int i = 0; i <= find.size(); i++) {
	    System.out.print(find.get(i) + ": ");
	    try {
		userAns = Double.parseDouble( in.readLine() );
	    }
	    catch (IOException e) {}
	    boolean isRight = compareAnswer(q,find.get(i));
	    if( !isRight ) {
		wrongAns();
	    }
	}
    }//end of getUserAnswer
	   
    //wrongAns() allows user to override game & deducts HP 
    public boolean wrongAns() {
	System.out.println("Your answer does not match. Would you like to proceed unharmed? (y/n)");
	boolean b = true;
	//	if((getYN().toLowerCase()).equals("n") || (getYN().toLowerCase()).equals("no")) { b = false; }
	//	else if( (getYN().toLowerCase()).equals("y") || (getYN().toLowerCase()).equals("yes")) { b = true; }
	//	else {
	//	    System.out.println("Invalid input");
	//	    b = wrongAns();
	//	}
	if( !b ) {
	    luke.setHP(luke.getHP() - 10);
	}
	else {}
	return b;
    }//end of wrongAns()

    //getBool() gets user input
    public String getYN() {
	String temp = "";
	try {
	    temp = in.readLine();
	}
	catch( IOException e ) {}
	if((getYN().toLowerCase()).equals("n") || (getYN().toLowerCase()).equals("no")) { b = false; }
	else if( (getYN().toLowerCase()).equals("y") || (getYN().toLowerCase()).equals("yes")) { b = true; }
	else {
	    System.out.println("Invalid input");
	    getYN();
	}
	return retBool;
    }

    //getName() gets name of user for Jedi
    public void name() {
	try {
	    luke.setName( in.readLine() );
	}
	catch (IOException e) {}
    }//end of name()

    public void kinSec() { //calls Kinematics questions
	for( int c = 0; c < kinQs; c++ ) {
	    Question q = new Kinematics();
	    findFind(q);
	    System.out.println(q.vars);
	    getUserAnswer(q);
	}
    }//end of kinSec

    public void projSec() { //calls Projectiles questions
	for( int c = 0; c < proQs; c++ ) {
	    Question q = new Projectiles();
	    findFind(q);
	    System.out.println(q.vars);
	    getUserAnswer(q);
	}
    }//end of projSec

    public static void main(String[] args) {
	Game game = new Game();
	game.newGame();

    }//end of main

}//end of Driver
