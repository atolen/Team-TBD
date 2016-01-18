public class Kinematics extends Question {
    private Comparable d; // displacement
    private Comparable vi; // init velocity
    private Comparable vf; // final velocity
    private Comparable a; // acceleration
    private Comparable t; // time

    public String toString() {
	return vars.toString();
    }
    
    // constructors
    public Kinematics() {
	numVars = 5;
	populate();
	
    }

    //populate()
    public void populate() {
	varList.add("d");
	varList.add("vi");
	varList.add("vf");
	varList.add("a");
	varList.add("t");
	chooseVar(0,100,1);
    }

    public static void main(String[] args) {
	Kinematics luke = new Kinematics();
	System.out.println(luke);
    }
    
} // close class Kinematics
