import java.util.ArrayList;
import java.math.*;
public abstract class Question {
    
    int numVars; // number of variables in a family of formulae
    float userInput; // user's answer to question
    float rightAns; // correct answer to question
    ArrayList vars; // list of vars
    
    
    //precond: lo < hi
    //postcond: returns random floating point number within specified range
    public static int randomNum( int lo, int hi ) {
	//     offset + rand int on interval [lo,hi]
        return (int)(lo + ( (hi-lo+1) * Math.random() ));
	
    }
    
} // close class Question
    


