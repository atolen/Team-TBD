import java.util.ArrayList;
public class Question {
    
    int numVars; // number of variables in a family of formulae
    float userInput; // user's answer to question
    float rightAns; // correct answer to question
    ArrayList vars; // list of vars
    
    
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

} // close class Question
    


