//package physics;
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
    private Double a = new Double(-9.81);//acceleration due to gravity -- y direction
    
    private Double t;//time

    
    //========================METHODS========================
    
    public String toString() {
	return vars.toString();
    }
    
    //constructors
    public Projectiles() {
	numVars = 7;
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
    //              values of vix and viy set to vi times cosine and sine of theta, respectively
    //              theta set to appropriate value based on vix/viy/vi
    public void populate() {
	varList.add("dx");
	varList.add("dy");	
	varList.add("vi");
	varList.add("vix");
	varList.add("viy");
	varList.add("vfy");
	varList.add("theta");	
	varList.add("t");
	assignVals(0,20,0);
	vars.put("a",a);
	if( vars.get("vix") != null && vars.get(theta) != null) { vars.put("vix",proj1(vi,theta)); } // set to vcostheta
	if( vars.get("viy") != null && vars.get(theta) != null) { vars.put("viy",proj2(vi,theta)); } // set to vsintheta

	if( theta != null && vix != null && vi != null ) { vars.put("theta",proj3(vix,vi)); }
	else if( theta != null && viy != null && vi != null ) { vars.put("theta",proj4(viy,vi)); }
	else if( theta != null && vix != null && viy != null ) { vars.put("theta",proj5(viy,vix)); }	
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
	if( vi == null ) {
	    if( vix != null && viy != null ) {
		unknowns.put("vi",pythTheorem(vix,viy));
		vars.put("vi",unknowns.get("vi"));
	    }
	    else if( vfy != null && t != null ) {
		unknowns.put("vi",Kinematics.kin3(a,t,vfy));
		vars.put("vi",unknowns.get("vi"));
	    }

	    else if( t != null ) {
		unknowns.put("vi",Kinematics.kin6(dy,a,t));
		vars.put("vi",unknowns.get("vi"));
	    }

	    else {
		unknowns.put("vi",Kinematics.kin10(vfy,a,dy));
		vars.put("vi",unknowns.get("vi"));
	    }
	    return;
	}
	

	//finding vix
	else if( vix == null && vi != null && theta != null ) { unknowns.put("vix",proj1(vi,theta)); }
	else if( vix == null ) {
	    if( t != null && dx != null ) {
		unknowns.put("vix",Kinematics.kin6(dx,0,t));
		vars.put("vix",unknowns.get("vix"));
	    }
	    return;
	}

	//finding viy
	else if( viy == null && vi != null && theta != null ) { unknowns.put("viy",proj2(vi,theta)); }
	else if( viy == null ) {
	    if( t != null && vfy != null ) {
		unknowns.put("vi",Kinematics.kin3(a,t,vfy));
		vars.put("vi",unknowns.get("vi"));
	    }
	    else if( vfy != null && dy != null ) {
		unknowns.put("vi",Kinematics.kin10(vfy,a,dy));
		vars.put("vi",unknowns.get("vi"));
	    }
	    else {
		unknowns.put("vi",Kinematics.kin6(dy,a,t));
		vars.put("vi",unknowns.get("vi"));
	    }
	    return;
	}
	
	//finding vfy
	else if( vfy == null ) {
	    if( t != null && viy != null) {
		unknowns.put("vfy",Kinematics.kin2(viy,a,t));
		vars.put("vfy",unknowns.get("vfy"));
	    }
	    else if(viy != null && dy != null) {
		unknowns.put("vfy",Kinematics.kin9(viy,a,dy));
		vars.put("vfy",unknowns.get("vfy"));
	    }
	    return;
	}

	//finding dy
	else if( dy == null && viy != null && a != null ) { //kin5,kin12 find d
	    if( t != null ) {
		unknowns.put("dy",Kinematics.kin5(viy,t,a)); //kin5
		vars.put("dy",unknowns.get("dy"));
	    }
	    else {
		unknowns.put("dy",Kinematics.kin12(vfy,viy,a)); //kin12
		vars.put("dy",unknowns.get("dy"));
	    }
	    return;
	}

	//finding dx
	else if( dx == null && vix !=null && t !=null) {
	    unknowns.put("dx", t*vix);
	    vars.put("dx",unknowns.get("dx"));
	    return;
	}

	//finding t
	else if( t == null ) {
	    if( vfy != null ) {
		unknowns.put("t",Kinematics.kin4(vfy,viy,a));
		vars.put("t",unknowns.get("t"));
	    }
	    else {
		unknowns.put("t",Kinematics.kin7(dy,a)); 
		vars.put("t",unknowns.get("t"));
	    }
	    return;
	}
	
	//finding theta
	else if( theta == null && viy != null && vix != null ) {
	    unknowns.put("theta",proj5(viy,vix));
	    vars.put("theta",unknowns.get("theta"));	    
	    return;
	}
	else if( theta == null && vix != null && vi != null ) {
	    unknowns.put("theta",proj3(vix,viy));
	    vars.put("theta",unknowns.get("theta"));
	    return;
	} 
	else if( theta == null && viy != null && vi != null ) {
	    unknowns.put("theta",proj4(viy,vi));
	    vars.put("theta",unknowns.get("theta"));
	    return;
	}
    }
	
    //================FORMULAE==================
    public static double proj1(double vi, double theta) { //find vix
	return vi*Math.cos(Math.toRadians(theta));
    }

    public static double proj2(double vi, double theta) { //find viy
	return vi*Math.sin(Math.toRadians(theta));
    }

    public static double proj3(double vix, double vi) { //find theta >> vix, vi known
	return Math.toDegrees(Math.acos(vix/vi)); //arccos
    }
    
    public static double proj4(double viy, double vi) { //find theta >> viy,vi known
	return Math.toDegrees(Math.asin(viy/vi)); //arcsin
    }

    public static double proj5(double viy, double vix) { //find theta >> viy,vix known
	return Math.toDegrees(Math.atan(viy/vix)); //arctan
    }
    //===========================================
    

    public static void main( String[] args ) {
	Projectiles luke = new Projectiles();
	System.out.println(luke);
	//	System.out.println(luke.calculate());
	
    }
} // close class Projectiles
 
