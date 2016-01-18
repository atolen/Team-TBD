public class Kinematics extends Question {
    private double d; // displacement
    private double vi; // init velocity
    private double vf; // final velocity
    private double a; // acceleration
    private double t; // time

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
