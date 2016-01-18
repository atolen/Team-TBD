public class Kinematics extends Question {
    private Number d; // displacement
    private Number vi; // init velocity
    private Number vf; // final velocity
    private Number a; // acceleration
    private Number t; // time

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
