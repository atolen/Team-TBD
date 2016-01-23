package physics;
public class Projectiles extends Question {
    private Double dx;//displacement in x direction
    private Double dy;//displacement in y direction
    
    private Double vi;//init velocity
    private Double vix;//init velocity -- x component
    private Double viy;//init velocity -- y component

    //assume objects don't accelerate in x direction
    private Double vfy;//final belocity -- y direction

    private Double angle;//angle at which object is thrown
    //                   positive x axis used as reference frame

    //assume objects don't accelerate in x direction
    private Double ay;//acceleration -- y component
    
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
	angle = vars.get("angle");
	ay = vars.get("ay");
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
	varList.add("angle");	
	varList.add("ay");
	varList.add("t");
	assignVals(0,20,0);
	vars.put("vix",Math.cos(vars.get("vi")));
	vars.put("viy",Math.sin(vars.get("vi")));
    }

    
    //========================CALCULATOR========================
    
    //finds rightAns
    public String calculate() {
       	while( vars.containsValue(null)) 
	    whichFxn();
	return unknowns.toString();
    }

    public void whichFxn() {
	if( d == null && !(vi == null) && a != null ) { //proj5,proj12 find d
	    if( t != null ) {
		unknowns.put("d",proj5()); //proj5
		vars.put("d",proj5());
	    }
	    else {
		unknowns.put("d",proj12()); //proj12
		vars.put("d",proj12());
	    }
	    return;
	}

	else if( vi == null ) {
	    if( t != null ) {
		if( vf != null ) {
		    unknowns.put("vi",proj3()); //proj3
		    vars.put("vi",proj3());
		}
		else {
		    unknowns.put("vi",proj6()); //proj6
		    vars.put("vi",proj6());
		}
	    }
	    else {
		unknowns.put("vi",proj10()); //proj10
		vars.put("vi",proj10());
	    }
	    return;
	}

	else if( vf == null ) {
	    if( t != null ) {
		unknowns.put("vf",proj2());
		vars.put("vf",proj2());
	    }
	    else {
		unknowns.put("vf",proj9());
		vars.put("vf",proj9());
	    }
	    return;
	}

	else if( a == null ) {
	    if( vi != null && t != null ) {
		if( d == null ) {
		    unknowns.put("a",proj1());
		    vars.put("a",proj1());
		}
		else {
		    unknowns.put("a",proj8());
		    vars.put("a",proj8());
		}
	    }
	    else {
		unknowns.put("a",proj11());
		vars.put("a",proj11());
	    }
	    return;
	}
	    
	else { // t unknown
	    if( vf != null ) {
		unknowns.put("t",proj4());
		vars.put("t",proj4());
	    }
	    else {
		unknowns.put("t",proj7());
		vars.put("t",proj7());
	    }
	    return;
	}
    }

    //===============a = (vf - vi)/t DERIVED===============

    //a = (vf - vi)/t >> if vf, vi, t are known
    public double proj1() {
	return (vf - vi) / t;
    }

    //vf = vi + at  >> if vi, a, t are known
    public double proj2() {
	return vi + (a*t);
    }

    //vi = at - vf >> if a, t, vf are known
    public double proj3() {
	return a*t - vf;
    }

    //t = (vf - vi)/a >> if vf, vi, a are known
    public double proj4() {
	return (vf - vi) / a;
    }

    //============d = vit + (0.5)at^2 DERIVED=========

    //d = vit + (0.5)at^2 >> if vi, t, a are known
    public double proj5() {
	return (vi*t) + ((0.5)*a*Math.pow(t,2));
    }

    //vi = (d - (0.5)at^2)/t >> if d, a, t are known
    public double proj6() {
	return (d - 0.5*a*Math.pow(t,2)) / t;
    }

    //t = sqrt(2d/a) >> if d, a are known, vi == 0
    public double proj7() {
	return Math.sqrt((2*d)/a);
    }

    //a = (2(d - vit))/t^2 >> if d, vi, t are known
    public double proj8() {
	return (2*(d - vi*t)) / Math.pow(vi,2);
    }
    //================================================

    //============vf^2 = vi^2 + 2ad DERIVED=========

    //vf = sqrt(vi^2 + 2ad) >> if vi, a, d are known
    public double proj9() {
	return Math.sqrt(Math.pow(vi,2) + 2*a*d);
    }

    //vi = sqrt(vf^2 - 2ad) >> if vf, a, d are known
    public double proj10() {
	return Math.sqrt(Math.pow(vf,2) - 2*a*d);
    }

    //a = (vf^2 - vi^2) / 2d >> if vf, vi, d are known
    public double proj11() {
	return (Math.pow(vf,2) - Math.pow(vi,2)) / (2*d);
    }

    //d = (vf^2 - vi^2) / 2a >> if vf, vi, a are known
    public double proj12() {
	return (Math.pow(vf,2) - Math.pow(vi,2)) / (2*a);
    }
    //================================================


    public static void main( String[] args ) {
	Projectiles luke = new Projectiles();
	System.out.println(luke);
	System.out.println(luke.calculate());
    }
    */
} // close class Projectiles
 
