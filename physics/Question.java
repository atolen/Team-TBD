import java.util.*;
public abstract class Question {
    
    protected int numVars; // number of variables in a family of formulae
    protected float userInput; // user's answer to question
    protected float rightAns; // correct answer to question
    protected ArrayList vars; // list of vars

    //manually populates AL "vars" w/ class-specific instance vars
    public abstract void populate();
    
    //precond: lo < hi
    //postcond: returns random int within specified range
    public static int randomNum( int lo, int hi ) {
	//     offset + rand int on interval [lo,hi]
        return (int)(lo + ( (hi-lo+1) * Math.random() ));
    }

    // overloaded randomNum() -- scientific notation (sort of)
    public static double randomNum( int lo, int hi, int pow ) {
	//     offset + rand int on interval [lo,hi]
        return (lo + ( (hi-lo+1) * Math.random() )) * Math.pow(10,pow);
    }
    
    
    //shuffle elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
	for( int i = al.size()-1; i > 0; i--) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }

    //chooseVar() -- assigns random values to all but one varible
    public static void chooseVar(int lo, int hi, int pow) {
	shuffle( vars );
	for (int i = 1; i < vars.size(); i++) {
	    vars[i].set(randomNum(lo, hi, pow));
	}
    }

} // close class Question
    


