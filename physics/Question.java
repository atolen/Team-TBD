package physics;
import java.util.*;
public abstract class Question {
    
    protected int numVars; // number of variables in a family of formulae
    protected ArrayList<String> varList = new ArrayList(); // list of vars
    protected Map<String,Double> vars = new HashMap(); // dict of vars
    protected Map<String,Double> unknowns = new HashMap(); // stores unknows + correct answers, to later compare w/ user input
    protected Map<String,Double> userInput = new HashMap(); // user's answer to question

    //manually populates Map "vars" w/ class-specific instance vars
    public abstract void populate();
	    
    //precond: lo < hi
    //postcond: returns random Double within specified range
    public static Double randomNum( int lo, int hi ) {
	//     offset + rand int on interval [lo,hi]
        return (lo + ( (hi-lo+1) * Math.random() ));
    }

    // overloaded randomNum() -- scientific notation (sort of)
    public static Double randomNum( int lo, int hi, int pow ) {
	//     offset + rand int on interval [lo,hi]
	double rand = (lo + ( (hi-lo+1) * Math.random() )) * Math.pow(10,pow);
	Double retNum = new Double(rand);
        return retNum;
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

    //assignVals() -- assigns random values to all but one varible
    //               populates HashMap
    public void assignVals( int lo, int hi, int pow ) {
	shuffle();
	for ( int i = 1; i < varList.size(); i++ ) {
	    vars.put(varList.get(i), randomNum(lo,hi,pow));
	}
	vars.put(varList.get(0), null);
    }
    
    //assignVals() -- assigns random values to all but specified # of vars
    //                populates vars with random Doubles
    public void assignVals( int lo, int hi, int pow, int difficulty ) {
	shuffle();
	for ( int i = difficulty; i < varList.size(); i++ ) {
	    vars.put(varList.get(i), randomNum(lo,hi,pow));
	}
	addKeys();
    }

    //addKeys() -- copies keys from unknowns into userInput (both HashMaps)
    //             populates userInput && unknowns with key-null pairings
    public void addKeys() {
	for( String key : vars.keySet() ) {
	    if( vars.get(key) == null ) {
		unknowns.put(key,null);
		vars.put(key,null);
	    }
	}
    }

    //compare() -- returns true if user input within 15% of computer-generated answer
    public boolean compare(String key) {
	return (unknowns.get(key) * 1.15 >= userInput.get(key) && unknowns.get(key) * 0.85 <= userInput.get(key));
    }

} // close class Question
    

