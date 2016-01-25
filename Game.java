import java.io.*;
import java.util.*;

public class Game {

    //Instance Vars
    private Jedi luke = new Jedi(); //character
    
    //change these constants to choose which topics to focus on
    public final static int kinQs = 5; // Kinematics
    public final static int proQs = 5; // Projectiles

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
	luke = new Jedi();
	String prt = "";
	String name = "";
	//==============INTRODUCTION=====================
	prt = "\n";
	System.out.print( prt );
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
	    "                          EPISODE III.I-IV\n\n" + 
	    "                           THE FORCE RENEWED" +
	    "\n\n";
	System.out.print(prt);
	pause(2000);
	prt = 
	    "\t\t      It is a period of civil war.\n" +
	    "\t\t       Rebel spaceships, dwelling\n" +
	    "\t\t     from a hidden base, are planning\n" +
	    "\t\t      their first victory against\n" +
	    "\t\t       the evil Galactic Empire.\n"+
	    "\n\n";
	System.out.print(prt);
	pause(5000);

	prt =
	    "\t\t        The Empire has built an armored \n" +
	    "\t\t         space station, the DEATH STAR, \n" +
	    "\t\t      powerful enough to destory an entire \n" +
	    "\t\t       planet. You, a young rebel, wish to\n" +
	    "\t\t     master the Force, an ancient but powerful\n" +
	    "\t\t   religion, in order to aide the Rebel Alliance.\n" +
	    "\t\t  Your objective: acquire the DEATH STAR's blueprints.\n"+
	    "\t\t        It is only with these that freedom can be  \n" +
	    "\t\t            restored to the galaxy...\n";
	    

	System.out.print(prt);
	pause(5000); 
	
	System.out.println("Greetings, young one! What do you call yourself?");
	name();
	System.out.println("Welcome, " + luke.getName() +".\n");
	pause(1000);

	prt = "You are about to embark on a journey throughout the galaxy, learning the ways of the Force and other vectors to battle the Empire.\n";
	prt += "In order to proceed and follow your destiny to become a physics BOSS, you must apply the laws of the universe (mechanical equations) in every given scenario, and find the missing component correctly.\n";
	System.out.print( prt + "\n" );
	pause(5000);

	prt = "PLEASE NOTE: The point of this game is to help people practice physics!\n";
	prt += "If for some reason our program gives you the wrong answer, you have the option of overriding it.\n";
	prt += "But have caution! The practice is for your own good, so the only person who will suffer most certain death is not you the Jedi, but you the student.\n";
	System.out.print( prt + "\n" );
	pause(5000);

	System.out.println("Good luck! May the Force be with you.");
	pause(2000); 
	//================END OF INTRO================
	
//=======================KINEMATICS=====================
kinSec();
if(gameOver) {
    playAgain();
}
//=====================================================

prt = "Congrats! You are able to defend yourself by sensing with feelings alone, thereby taking your first steps, as Obi-wan Kenobi once said, \"into a larger world.\"";
System.out.println(prt);
pause(3000);

prt = "In order to use the Force and steal the plans, solve the following projectile problems\n";
System.out.print(prt);
pause(1500); 

//===================PROJECTILES=================

projSec();
if (gameOver) {
    playAgain();
}

//==============================================
if( !gameOver ) {
    prt = "Against all odds (3720:1), you succeed and destroy the Death Star, dealing a major defeat to the Empire. Now you are on the path to becoming a Jedi Knight, and mastering the remaining topics in physics.";
    System.out.println(prt);
    pause(1500);
}

System.out.println("\nTO BE CONTINUED");

    }//end of newGame()
    //====================================================

    public void playAgain() {
	System.out.println("\nWould you like to play again? (y/n)");
	boolean b = getYN();
	if( b ) { newGame(); }
	else if( !b ) { System.out.println("Then it has come time for us to part. I wish you luck, " + luke.getName() +". May the Force be with you."); }
    }
    
    public void gameOver() {
	System.out.println("Oh no! You have been overcome by Imperial Forces, assassinated in your attempts to destroy the Death Star and bring justice to the galaxy."); }
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
	String ret = "Find: ";
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
	for(int i = 0; i < find.size(); i++) {
	    System.out.print(find.get(i) + ": ");
	    try {
		userAns = Double.parseDouble( in.readLine() );
	    }
	    catch (IOException e) {}
	    boolean isRight = compareAnswer(q,find.get(i));
	    if( !isRight ) {
		wrongAns();
	    }
	    else {
		System.out.println("Correct!");
	    }
	}
    }//end of getUserAnswer
	   
    //wrongAns() allows user to override game & deducts HP 
    public void wrongAns() {
	System.out.println("Your answer does not match. Would you like to proceed unharmed? (y/n)");
	boolean b = getYN();

	if( !b ) {
	    luke.setHP(luke.getHP() - 15);
	    System.out.println("Your HP has been reduced to " + luke.getHP());
	    if( luke.getHP() <= 0 ) {
		gameOver = true;
		gameOver();
	    }
	    
	}
    }//end of wrongAns()

    //getYN() gets user input
    public boolean getYN() {
	String t = "";
	boolean b;
	try {
	    t = in.readLine();
	}
	catch( IOException e ) {}

	if( t.equals("n") || t.equals("no")) { b = false; }
	else if( t.equals("y") || t.equals("yes")) { b = true; }
	else {
	    System.out.println("Invalid input.");
	    b = getYN();
	}
	return b;
    }

    //getName() gets name of user for Jedi
    public void name() {
	try {
	    luke.setName( in.readLine() );
	}
	catch (IOException e) {}
    }//end of name()

    public void kinSec() { //calls Kinematics questions
	System.out.println("Please enter your answer in the form of a base-10 number."); //for Mr. Holmes
	for( int c = 0; c < kinQs; c++ ) {
	    if (luke.getHP() > 0) {
		Question qk = new Kinematics();
		System.out.println( "Would you like a hint?" );
		if( getYN() ) { System.out.println(hint(qk)); }
		findFind(qk);
		System.out.println(qk);
		getUserAnswer(qk);
	    }
	    else {
		gameOver = true;
	    }
	}
    }//end of kinSec

    public void projSec() { //calls Projectiles questions
	System.out.println("Please enter your answer in the form of a base-10 number."); //for Mr. Holmes	
	for( int c = 0; c < proQs; c++ ) {
	    if (luke.getHP() > 0) {
		Question qp = new Projectiles();
		System.out.println( "Would you like a hint?" );
		if( getYN() ) { System.out.println(hint(qp)); }
		findFind(qp);
		System.out.println(qp);
		getUserAnswer(qp);
	    }
	    else {
		gameOver = true; 
	    }
	}
    }//end of projSec

    public String hint(Question q) {
	String yoda =
	    "__.-._\n" +
	    "'-._\"7'\n" +
	    " /'.-c\n" +
	    " |  /T\n" +
	    " _)_/LI\n";
	String hi = "Greetings, " + luke.getName() +". Here to assist you I am.";
	String kinIntro = "Here are the Kinematic equations at your disposal: \n";
	String kinBody ="~ vf = vi+a*t \n~ d = vi + 1/2*a*t^2 \n~ vf^2 = vi^2 + 2*a*d";
	String proj = "Here are the Projectile equations at your disposal: \n " + kinBody + "\n~ vix = vi*cos(theta) \n viy = vi*sin(theta)";
	if( q instanceof Kinematics ) { return yoda+hi+kinIntro+kinBody; }
	else if( q instanceof Projectiles) { return yoda+hi+proj; }
	else { return yoda; }
    }
	    
    public static void main(String[] args) {
	Game game = new Game();
	game.newGame();

    }//end of main

}//end of Driver
