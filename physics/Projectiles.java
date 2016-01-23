package physics;
public class Projectiles extends Question {
    private Double dx;//displacement in x direction
    private Double dy;//displacement in y direction
    
    private Double vi;//init velocity
    private Double vix;//init velocity -- x component
    private Double viy;//init velocity -- y component

    //assume objects don't accelerate in x direction
    private Double vfy;//final velocity -- y direction

    private Double theta;//angle at which object is thrown
    //                    positive x axis used as reference frame

    //assume objects don't accelerate in x direction
    private Double a = new Double(9.81);//acceleration due to gravity -- y direction
    
    private Double t;//time

    
    //========================METHODS========================
    
    public String toString() {
	return vars.toString();
    }
    
    //constructors
    public Projectiles() {
	numVars = 9;
	populate();
	dx = vars.get("dx");
	dy = vars.get("dy");
	vi = vars.get("vi");
	vix = vars.get("vix");
	viy = vars.get("viy");
	vfy = vars.get("vfy");
	theta = vars.get("theta");
	a = vars.get("a");
	t = vars.get("t");
    }

    //populate() -- postcond: assigns random values to variables
    //              values of vix and viy set to the cosine and sine of vi, respectively
    public void populate() {
	varList.add("dx");
	varList.add("dy");	
	varList.add("vi");
	varList.add("vix");
	varList.add("viy");
	varList.add("vfy");
	varList.add("theta");	
	varList.add("t");
	varList.add("a");
	assignVals(0,10,0);
	if( vars.get("vix") != null && vars.get(theta) != null) { vars.put("vix",proj1()); } // set to vcostheta
	if( vars.get("viy") != null && vars.get(theta) != null) { vars.put("viy",proj2()); } // set to vsintheta

    }

    
    //========================CALCULATOR========================
    
    //finds rightAns
    public String calculate() {
       	while( vars.containsValue(null) )
	    solve();
	return unknowns.toString();
    }
  
    public void solve() {

	//finging vi
	if( vi == null && vix != null && viy != null ) { unknowns.put("vi",pythTheorem(vix,viy)); }

	//finding vix
	else if( vix == null && vi != null && theta != null ) { unknowns.put("vix",proj1()); }
	else if( vix == null ) {
	    if( t != null && dx != null) {
		unknowns.put("vix",dx/t);
		vars.put("vix",unknowns.get("vix"));
	    }
	    return;
	}

	//finding viy
	else if( viy == null && vi != null && theta != null ) { unknowns.put("viy",proj2()); }
	else if( viy == null) {
	    if( t != null) {
		if(vfy != null) {
		    unknowns.put("viy",Kinematics.kin3(a,t,vfy));
		    vars.put("viy",Kinematics.kin3(a,t,vfy));
		}
		else {
		    unknowns.put("viy",Kinematics.kin6(dy,a,t)); //kin6
		    vars.put("viy",unknowns.get("viy"));
		}
	    }
	    else {
		unknowns.put("viy",Kinematics.kin10(vfy,a,dy)); //kin10
		vars.put("viy",unknowns.get("viy"));
	    }
	    return;
	}

	//finding vfy
	else if( vfy == null ) {
	    if( t != null ) {
		unknowns.put("vfy",Kinematics.kin2(viy,a,t));
		vars.put("vfy",unknowns.get("vfy"));
	    }
	    else {
		unknowns.put("vfy",Kinematics.kin9(viy,a,dy));
		vars.put("vfy",unknowns.get("vfy"));
	    }
	    return;
	}


	//finding theta
	else if( theta == null && vix != null && vi != null ) { unknowns.put("theta",proj3()); }
	else if( theta == null && viy != null && vi != null ) { unknowns.put("theta",proj4()); }
	else if( theta == null && viy != null && vix != null ) { unknowns.put("theta",proj5()); }
    }
	
    //==========EQUATIONS=============    
    public double proj1() { //find vix
	return vi*Math.cos(Math.toRadians(theta));
    }

    public double proj2() { //find viy
	return vi*Math.sin(Math.toRadians(theta));
    }

    public double proj3() { //find theta >> vix, vi known
	return Math.toDegrees(Math.acos(vix/vi)); //arccos
    }

    public double proj4() { //find theta >> viy,vi known
	return Math.toDegrees(Math.asin(viy/vi)); //arcsin
    }

    public double proj5() { //find theta >> viy,vix known
	return Math.toDegrees(Math.atan(viy/vix)); //arctan
    }
    //============================================
    

    public static void main( String[] args ) {
	Projectiles luke = new Projectiles();
	System.out.println(luke);
	System.out.println(luke.calculate());
    } 
    
} // close class Projectiles
 
