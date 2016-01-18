public class KinCalculator extends Kinematics {

    //finds rightAns
    public double KinCalculator() {
	return 0.0;
    }

    public void whichFxn() {
    }

    //===============a = (vf - vi)/t DERIVED===============

    //a = (vf - vi)/t >> if vf, vi, t are known
    public double kin1() {
	return (vars.get("vf").doubleValue() - vars.get("vi").doubleValue() / vars.get("t").doubleValue());
    }

    //vf = vi + at  >> if vi, a, t are known
    public double kin2() {
	return vars.get("vf").doubleValue() + vars.get("a").doubleValue()*vars.get("t").doubleValue();
    }

    //vi = at - vf >> if a, t, vf are known
    public double kin3() {
	return vars.get("a").doubleValue()*vars.get("t").doubleValue() - vars.get("vf").doubleValue();
    }

    //t = (vf - vi)/a >> if vf, vi, a are known
    public double kin4() {
	return (vars.get("vf").doubleValue() - vars.get("vi").doubleValue()) / vars.get("a").doubleValue();
    }
    //=================================================

    //============d = vit + (1/2)at^2 DERIVED=========

    //d = vit + (1/2)at^2 >> if vi, t, a are known
    public double kin5() {
	return vars.get("vi").doubleValue()*vars.get("t").doubleValue() + (1/2)*vars.get("a").doubleValue()*Math.pow(vars.get("t").doubleValue(), 2);
    }
    //================================================
    
}//end of class KinCalculator
