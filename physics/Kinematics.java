public class Kinematics extends Question {
    private Comparable d; // displacement
    private Comparable vi; // init velocity
    private Comparable vf; // final velocity
    private Comparable a; // acceleration
    private Comparable t; // time

    // constructors
    public Kinematics() {
	populate();
     	chooseVar(0, 100, 1);	
    }

    //populate()
    public void populate() {
	vars.add(d);
	vars.add(vi);
	vars.add(vf);
	vars.add(a);
	vars.add(t);
    }

    public static void main(String[] args) {
	Kinematics Luke = new Kinematics();
    }
    
} // close class Kinematics
