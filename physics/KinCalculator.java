public class KinCalculator extends Kinematics {
    double d = vars.get("d").doubleValue();
    double vi = vars.get("vi").doubleValue();
    double vf = vars.get("vf").doubleValue();
    double a = vars.get("a").doubleValue();
    double t = vars.get("t").doubleValue();
    
    //finds rightAns
    public double KinCalculator() {
	return 0.0;
    }

    public void whichFxn() {
    }

    //===============a = (vf - vi)/t DERIVED===============

    //a = (vf - vi)/t >> if vf, vi, t are known
    public double kin1() {
	return (vf - vi / t);
    }

    //vf = vi + at  >> if vi, a, t are known
    public double kin2() {
	return vf + a*t;
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

    //t = sqrt(2d/a) >>if d, a are known, vi == 0
    public double kin7() {
	return Math.sqrt(2*d/a);
    }
    //================================================
    
    
}//end of class KinCalculator
