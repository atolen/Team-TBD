import java.util.*;
public abstract class Question {
    
    protected int numVars; // number of variables in a family of formulae
    protected float userInput; // user's answer to question
    protected float rightAns; // correct answer to question
    protected ArrayList<String> varList = new ArrayList(); // list of vars
    protected Map<String,Comparable> vars = new HashMap(); // dict of vars

    //manually populates Map "vars" w/ class-specific instance vars
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
    
    
    //shuffle elements of AL "varList"
    public void shuffle() {
	int randomIndex;
	for( int i = numVars-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    varList.set( i, varList.set( randomIndex, varList.get(i) ) );
	}
    }

    //chooseVar() -- assigns random values to all but one varible
    //               populates HashMap
    public void chooseVar( int lo, int hi, int pow ) {
	shuffle();
	for ( int i = 1; i < varList.size(); i++ ) {
	    vars.put(varList.get(i), randomNum(lo,hi,pow));
	}
	vars.put(varList.get(0),null);
    } 
    
} // close class Question
    

