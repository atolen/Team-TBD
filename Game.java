import java.io.*;
import java.util.*;

public class Game {

    //Instance Vars
    private Jedi luke = new Jedi(); //character
    
    //change these constants to choose which topics to focus on
    public final static int kinQs = 1; // Kinematics
    public final static int proQs = 1; // Projectiles

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

	/*prt = "\t\tA long time ago in a galaxy far,\n\t\tfar away...\n\n";
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
	pause(5000);

	prt = "PLEASE NOTE: The point of this game is to help people practice physics!\n";
	prt += "If for some reason our program gives you the wrong answer, you have the option of overriding it.\n";
	prt += "But have caution! The practice is for your own good, so the only person who will suffer most certain death is not you the Jedi, but you the student.\n";
	System.out.print( prt + "\n" );
	pause(5000);

	System.out.println("Good luck! May the Force be with you.");
	pause(2000); 
	//================END OF INTRO================
	
	//==================THE MEAT==================
	
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
pause(1500);

prt = "After crash-landing on the planet below, a barren, desert world called Tatooine, the droids set off in search of civilization but soon quarrel over the way to go. R2 insists that he has a mission to perform, but C-3PO wants no part of such an adventure.\n\n";
System.out.print(prt);
pause(5000);

prt = "The two droids go their separate ways but are soon reunited when they are both captured by Jawas, child-sized scavengers who trade in droids and technological scraps. The Jawas sell the droids to your Owen Lars, your uncle, a moisture farmer on a remote homestead.Owen’s nephew, you, young" + name + ", cleans the droids and, as you do so, stumbles across a bit of the message Princess Leia had hidden inside R2. The holographic message is addressed to “Obi-Wan Kenobi,” and you, fascinated by the princess, wonders if she means Ben Kenobi, a mysterious hermit who lives out in the desert wilds. R2, however, refuses to divulge any more of the message. When you ask your uncle about the identity of Obi-Wan, Owen is reluctant to even discuss the subject, but he does drop one tantalizing hint: Obi-Wan was a friend of your father, whom you never knew. You mention your desire to leave home to attend the Imperial Academy for starpilots, but Uncle Owen is discouraging, much to your frustration.\n\n";
System.out.println(prt);
pause(3000);

prt = "You realize that R2-D2 had slipped away! You set out on a search for the truant droid the next morning with C-3PO, but run into Sandpeople, who knock you out. You awake to just the man you had been searching for: Ben Kenobi. He frightens off the Sandpeople and brings the group back to his humble shelter. There, Ben explains that he was called Obi-Wan back in days when he was a Jedi Knight, one of an ancient order of warriors who fought for peace and justice in the time of the Old Republic, before the coming of the evil Galactic Empire. Further, he informs Luke that Luke’s father was also a Jedi, one of Ben’s closest friends, and that his father was killed by Darth Vader, a former pupil of Ben’s who turned to the dark side of the Force. The Force, Ben explains, is the source of a Jedi’s power. It is an energy field created and sustained by life itself, and it flows through the universe, binding it together. Through training, a Jedi is able to tap into the Force and gain great power and wisdom, but, as the example of Vader shows, there is a seductive, evil path to the Force as well.\n\n";
    System.out.print(prt);
    pause(3000);

    prt = "Ben gives you your father’s lightsaber, the traditional weapon of a Jedi. After viewing the entirety of Leia’s message, Ben says that he intends to join up with the Rebel Alliance challenging the Empire and to bring them the plans hidden in R2’s memory. Ben invites you along but you refrain. It is only after you race home to find your family murdered by the Empire that you resolve to join Ben and become a Jedi.\n\n";
System.out.println(prt);
pause(20000);

prt = "With the droids in tow, Ben and Luke journey to Mos Eisley spaceport in search of a ship to take them to Alderaan, the Princess’s home planet. The pair manages to hire Han Solo, a brash smuggler, and his copilot, the Wookie Chewbacca, to take them to Alderaan without attracting the attention of the Empire.Solo and Chewbacca are surprised when Imperial troops appear and start firing on the ship in an attempt to reclaim the droids, and the Falcon barely makes it off Tatooine and into hyperspace on the way to Alderaan.\n\n";
System.out.print(prt);
pause(3000);

prt = "On the Death Star, meanwhile, Tarkin has decided to break Leia by threatening her home planet, Alderaan, with destruction. Faced with this appalling dilemma, Leia reveals the location of the hidden base, only to have Tarkin proceed with the attack on Alderaan, merely to demonstrate the power of the Death Star.\n\n";
System.out.print(prt);
pause(3000);

prt = "Aboard the Millennium Falcom, Ben feels a massive tremor in the Force. You begin training with your lightsaber.\nSee if you can find the missing component (the null component) in the following kinematics problems:\n\n";
System.out.print(prt);
*/
//=======================KINEMATICS=====================
kinSec();
if (gameOver) {
    playAgain();
}
//=====================================================

/*prt = "Congrats! You are able to defend yourself by sensing with feelings alone, thereby taking your first steps, as Ben says, into “a larger world.” The ship exits hyperspace where Alderaan should be, only to find the planet missing and an asteroid field in its place. Ben realizes the horrible truth when they catch sight of the nearby Death Star, and the Millennium Falcon is quickly captured. The group manages to hide from the guards in Han’s smuggling compartments, but Vader senses the presence of his old master, Obi-Wan.\n";
System.out.println(prt);
pause(30000);

prt = "The ship is unable to escape the Death Star as long as the station’s tractor beam is operational, so Ben goes off alone to deactivate it. In his absence, the others learn that Princess Leia is aboard the station, and you convince them to attempt a rescue. You an Han disguise yourselves as stormtroopers and, with the droids plugged into the station’s computers, break Leia out of her cell. Unfortunately, your activities are soon discovered, and the rescue takes a detour through a massive, monster-infested garbage compactor and several corridors and pitfalls swarming with Imperial troops. Leia is unimpressed with her rescuers’ planning and soon begins to issue the orders, much to Han’s chagrin. As the group fights its way back to the Falcon, Ben stealthily deactivates the tractor beam. On his way to the ship, Ben is confronted by Darth Vader, who is eager to face his old master. Vader and Ben duel with lightsabers, and the fight draws the attention of the guards. Realizing he is trapped, and not wanting to endanger his friends, Ben allows Vader to strike him down, only to disappear before Vader’s stroke hits, merging his consciousness with the Force. You are horrified and lashes out, but the others force him onto the Falcon and make they their escape.\n\n";
System.out.print(prt);
pause(60000);

prt = "The fleeing ship is pursued by Imperial fighters but finally escapes, though Leia is convinced that you are being tracked, as indeed you are. The group travels to the Rebel base, with the Death Star right behind. A quick scan of the blueprints provided by R2 offers one slim chance: the Death Star has an Achilles’ heel. A direct hit on a small, easily overlooked thermal port will destroy the station, if only a fighter can get close enough to target it. You sign up for the desperate assault, but you are disappointed that Han, having received his payment, plans to leave immediately. Watched anxiously by the Rebel command, the fleet of small, single-pilot fighters speeds toward the massive, impregnable Death Star. As the station slowly moves into position to obliterate the Rebels, the pilots maneuver down a narrow trench along the station’s equator, where the thermal port lies hidden. Darth Vader leads the counterattack himself and destroys many of the Rebels, including Luke’s boyhood friend Biggs, in ship-to-ship combat. Finally, it is up to you to make a run at the target, and you are saved from Vader at the last minute by Han Solo, who returns in the nick of time and sends Vader spinning away from the station. Heeding Ben’s disembodied voice, you switches off his computer and uses the Force to guide your aim.\n\n";
System.out.print(prt);
pause(80000); 

prt = "In order to use the Force and take down the Death Star, solve the following projectile problems\n";
System.out.print(prt);
pause(1500); */

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
	//	String t = getYN().toLowerCase();
	/*boolean b = true;
	if( t.equals("n") || t.equals("no")) { b = false; }
	else if( t.equals("y") || t.equals("yes")) { b = true; }
	else {
	    System.out.println("Invalid input");
	    wrongAns();
	    } */
	if( !b ) {
	    luke.setHP(luke.getHP() - 50);
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
	for( int c = 0; c < kinQs; c++ ) {
	    if (luke.getHP() > 0) {
		Question qk = new Kinematics();
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
	for( int c = 0; c < proQs; c++ ) {
	    if (luke.getHP() > 0) {
		Question qp = new Projectiles();
		findFind(qp);
		System.out.println(qp);
		getUserAnswer(qp);
	    }
	    else {
		gameOver = true; 
	    }
	}
    }//end of projSec

    public static void main(String[] args) {
	Game game = new Game();
	game.newGame();

    }//end of main

}//end of Driver
