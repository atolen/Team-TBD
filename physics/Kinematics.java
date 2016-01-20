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
	String retStr = "";
	while( vars.containsValue(null)) {
		retStr += whichFxn() + "\n";
	}
	return retStr;
    }

    public void whichFxn() {
	if( d == null && !(vi == null) && !(a == null) ) { //kin5,kin12 find d
	    if( !(t == null) )
		unknowns.put("d",kin5());
	    else
		unknows.put("d",kin12());
	    return;
	}

	//===============================================================
	else if( d == null && !(vi == null)) 
	if( (vars.get("d") == null) ) {//kin5, kin12 find d
	    //	    if (vars.containsKey("vi") && vars.containsKey("a")) {
	    if(!(vars.get("t") == null)) {//kin5
		    vars.put("d",kin5());
		}
	    else if(!(vars.get("vf") == null)) {//kin12
		    vars.put("d",kin12());
		}
	}

	else if( vars.get("vi") == null ) {//kin3, kin6, kin10 find vi
	    // if(vars.containsKey("a")) {
	    if(vars.containsKey("t")) {
		if(vars.containsKey("vf")) {//kin3 
		    return kin3();
		}
		else if(vars.containsKey("d")) {//kin6
		    return kin6();
		}
	    }
	    else if(vars.containsKey("vf") && containsKey("d")) {//kin10
		return kin10();
	    }
	}	    
	
       
	else if( !(vars.containsKey("vf")) ) {//kin2, kin9 find vf
	    if( vars.containsKey("t") && !vars.containsKey("d"))
		return kin2();
	    else
		return kin9();
	}

	else if( !(vars.containsKey("a")) ){//kin1, kin8, kin11 find a
	}

	else if( !(vars.containsKey("t")) ){//kin4, kin7 find t
	}
    }

    //===============a = (vf - vi)/t DERIVED===============

    //a = (vf - vi)/t >> if vf, vi, t are known
    public double kin1() {
	return (vf - vi) / t;
    }

    //vf = vi + at  >> if vi, a, t are known
    public double kin2() {
	return vi + (a*t);
    }

    //vi = at - vf >> if a, t, vf are known
    public double kin3() {
	return a*t - vf;
    }

    //t = (vf - vi)/a >> if vf, vi, a are known
    public double kin4() {
	return (vf - vi) / a;
    }
    //=================================================

    //============d = vit + (0.5)at^2 DERIVED=========

    //d = vit + (0.5)at^2 >> if vi, t, a are known
    public double kin5() {
	return (vi*t) + ((0.5)*a*Math.pow(t,2));
    }

    //vi = (d - (0.5)at^2)/t >> if d, a, t are known
    public double kin6() {
	return (d - 0.5*a*Math.pow(t,2)) / t;
    }

    //t = sqrt(2d/a) >> if d, a are known, vi == 0
    public double kin7() {
	return Math.sqrt((2*d)/a);
    }

    //a = (2(d - vit))/t^2 >> if d, vi, t are known
    public double kin8() {
	return (2*(d - vi*t)) / Math.pow(vi,2);
    }
    //================================================

    //============vf^2 = vi^2 + 2ad DERIVED=========

    //vf = sqrt(vi^2 + 2ad) >> if vi, a, d are known
    public double kin9() {
	return Math.sqrt(Math.pow(vi,2) + 2*a*d);
    }

    //vi = sqrt(vf^2 - 2ad) >> if vf, a, d are known
    public double kin10() {
	return Math.sqrt(Math.pow(vf,2) - 2*a*d);
    }

    //a = (vf^2 - vi^2) / 2d >> if vf, vi, d are known
    public double kin11() {
	return (Math.pow(vf,2) - Math.pow(vi,2)) / (2*d);
    }

    //d = (vf^2 - vi^2) / 2a >> if vf, vi, a are known
    public double kin12() {
	return (Math.pow(vf,2) - Math.pow(vi,2)) / (2*a);
    }
    //================================================


    public static void main( String[] args ) {
	Kinematics luke = new Kinematics();
	System.out.println(luke);
    }
    
} // close class Kinematics
 
