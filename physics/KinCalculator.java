public class KinCalculator extends Kinematics {
    double d = vars.get("d").doubleValue();
    double vi = vars.get("vi").doubleValue();
    double vf = vars.get("vf").doubleValue();
    double a = vars.get("a").doubleValue();
    double t = vars.get("t").doubleValue();
    
    //finds rightAns
    public double calculate() {
	return 0.0;
    }

    public void whichFxn() {
	if( !(vars.containsKey("d")) ) {//kin5, kin12 find d
	    }

	else if( !(vars.containsKey("vi")) ) {//kin3, kin6, kin10 find vi
	    }
       
	else if( !(vars.containsKey("vf")) ) {//kin2, kin9 find vf
	    }

	else if( !(vars.containsKey("a")) ){//kin1, kin8, kin11 find a
	    }

	else if( !(vars.containsKey("t")) ){//kin4, kin7 find t
	}
    }

    //===============a = (vf - vi)/t DERIVED===============

    //a = (vf - vi)/t >> if vf, vi, t are known
    public double kin1() {
	return (vf - vi / t);
    }

    //vf = vi + at  >> if vi, a, t are known
    public double kin2() {
	return vi + a*t;
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
	return vi*t + (0.5)*a*Math.pow(t, 2);
    }

    //vi = (d - (0.5)at^2)/t >> if d, a, t are known
    public double kin6() {
	return d - 0.5*a*Math.pow((t),2) / t;
    }

    //t = sqrt(2d/a) >> if d, a are known, vi == 0
    public double kin7() {
	return Math.sqrt(2*d/a);
    }

    //a = (2(d - vit))/t^2
    public double kin8() {
	return (2*(d - vi*t)) / Math.pow(vi,2);
    }
    //================================================

    //============vf^2 = vi^2 + 2ad DERIVED=========

    //vf = sqrt(vi^2 +2ad) >> if vi, a, d are known
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
	Kinematics q = new KinCalculator();
	System.out.println(q);
	//q.kin1();
    }

}//end of class KinCalculator
