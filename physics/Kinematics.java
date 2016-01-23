package physics;
public class Kinematics extends Question {
    private Double d;//displacement
    private Double vi;//init velocity
    private Double vf;//final velocity
    private Double a;//acceleration
    private Double t;//time
      
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
	assignVals(0,10,0);
    }

    
    //========================CALCULATOR========================

    //finds rightAns
    public String calculate() {
       	while( vars.containsValue(null)) 
	    whichFxn();
	return unknowns.toString();
    }

    public void whichFxn() {
	if( d == null && !(vi == null) && a != null ) { //kin5,kin12 find d
	    if( t != null ) {
		unknowns.put("d",kin5(vi,t,a)); //kin5
		vars.put("d",unknowns.get("d"));
	    }
	    else {
		unknowns.put("d",kin12(vf,vi,a)); //kin12
		vars.put("d",unknowns.get("d"));
	    }
	    return;
	}

	else if( vi == null ) {
	    if( t != null ) {
		if( vf != null ) {
		    unknowns.put("vi",kin3(a,t,vf)); //kin3
		    vars.put("vi",unknowns.get("vi"));
		}
		else {
		    unknowns.put("vi",kin6(d,a,t)); //kin6
		    vars.put("vi",unknowns.get("vi"));
		}
	    }
	    else {
		unknowns.put("vi",kin10(vf,a,d)); //kin10
		vars.put("vi",unknowns.get("vi"));
	    }
	    return;
	}

	else if( vf == null ) {
	    if( t != null ) {
		unknowns.put("vf",kin2(vi,a,t));
		vars.put("vf",unknowns.get("vf"));
	    }
	    else {
		unknowns.put("vf",kin9(vi,a,d));
		vars.put("vf",unknowns.get("vf"));
	    }
	    return;
	}

	else if( a == null ) {
	    if( vi != null && t != null ) {
		if( d == null ) {
		    unknowns.put("a",kin1(vf,vi,d));
		    vars.put("a",unknowns.get("a"));
		}
		else {
		    unknowns.put("a",kin8(d,vi,t));
		    vars.put("a",unknowns.get("a"));
		}
	    }
	    else {
		unknowns.put("a",kin11(vf,vi,d));
		vars.put("a",unknowns.get("a"));
	    }
	    return;
	}
	    
	else { // t unknown
	    if( vf != null ) {
		unknowns.put("t",kin4(vf,vi,a));
		vars.put("t",unknowns.get("t"));
	    }
	    else {
		unknowns.put("t",kin7(d,a));
		vars.put("t",unknowns.get("t"));
	    }
	    return;
	}
    }

    //===============a = (vf - vi)/t DERIVED===============

    //a = (vf - vi)/t >> if vf, vi, t are known
    public static double kin1(double vf, double vi, double t) {
	return (vf - vi) / t;
    }

    //vf = vi + at  >> if vi, a, t are known
    public static double kin2(double vi, double a, double t) {
	return vi + (a*t);
    }

    //vi = at - vf >> if a, t, vf are known
    public static double kin3(double a, double t, double vf) {
	return a*t - vf;
    }

    //t = (vf - vi)/a >> if vf, vi, a are known
    public static double kin4(double vf, double vi, double a) {
	return (vf - vi) / a;
    }

    //============d = vit + (0.5)at^2 DERIVED=========

    //d = vit + (0.5)at^2 >> if vi, t, a are known
    public static double kin5(double vi, double t, double a) {
	return (vi*t) + ((0.5)*a*Math.pow(t,2));
    }

    //vi = (d - (0.5)at^2)/t >> if d, a, t are known
    public static double kin6(double d, double a, double t) {
	return (d - 0.5*a*Math.pow(t,2)) / t;
    }

    //t = sqrt(2d/a) >> if d, a are known, vi == 0
    public static double kin7(double d, double a) {
	return Math.sqrt((2*d)/a);
    }

    //a = (2(d - vit))/t^2 >> if d, vi, t are known
    public static double kin8(double d, double vi, double t) {
	return (2*(d - vi*t)) / Math.pow(vi,2);
    }
    //================================================

    //============vf^2 = vi^2 + 2ad DERIVED=========

    //vf = sqrt(vi^2 + 2ad) >> if vi, a, d are known
    public static double kin9(double vi, double a, double d) {
	return Math.sqrt(Math.pow(vi,2) + 2*a*d);
    }

    //vi = sqrt(vf^2 - 2ad) >> if vf, a, d are known
    public static double kin10(double vf, double a, double d) {
	return Math.sqrt(Math.pow(vf,2) - 2*a*d);
    }

    //a = (vf^2 - vi^2) / 2d >> if vf, vi, d are known
    public static double kin11(double vf, double vi, double d) {
	return (Math.pow(vf,2) - Math.pow(vi,2)) / (2*d);
    }

    //d = (vf^2 - vi^2) / 2a >> if vf, vi, a are known
    public static double kin12(double vf, double vi, double a) {
	return (Math.pow(vf,2) - Math.pow(vi,2)) / (2*a);
    }
    //================================================


    public static void main( String[] args ) {
	Kinematics luke = new Kinematics();
	System.out.println(luke);
	System.out.println(luke.calculate());
    }
    
} // close class Kinematics
 
