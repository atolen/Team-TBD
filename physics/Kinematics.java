public class Kinematics extends Question {
    protected Number d;//displacement
    protected Number vi;//init velocity
    protected Number vf;//final velocity
    protected Number a;//acceleration
    protected Number t;//time
      
    /*    protected Number vi = new Double(vars.get("vi").doubleValue()); // init velocity
    protected Number vf = new Double(vars.get("vf").doubleValue()); // final velocity
    protected Number a = new Double(vars.get("a").doubleValue()); // acceleration
    protected Number t = new Double(vars.get("t").doubleValue()); // time */
    //    double dv = vars.get("d").doubleValue();
    //    double vi = vars.get("vi").doubleValue();
    //    double vf = vars.get("vf").doubleValue();
    //    double a = vars.get("a").doubleValue();
    //    double t = vars.get("t").doubleValue();

    public String toString() {
	return vars.toString();
    }
    
    // constructors
    public Kinematics() {
	numVars = 5;
	populate();
	d = vars.get("d");
	vi = vars.get("vi");
	vf = vars.get("vf");
	a = vars.get("a");
	t = vars.get("t");
	
    }

    //populate()
    public void populate() {
	varList.add("d");
	varList.add("vi");
	varList.add("vf");
	varList.add("a");
	varList.add("t");
	assignVals(0,100,0);
    }

    public static void main(String[] args) {
	Kinematics luke = new Kinematics();
	System.out.println(luke);
    }
    
} // close class Kinematics
 
