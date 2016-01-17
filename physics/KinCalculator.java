public class KinCalculator extends Kinematics{

    //finds rightAns
    public double calculate() {
    }

    public void whichFxn() {
    }

    //===============a = (vf - vi)/t DERIVED===============

    //a = (vf - vi)/t >> if vf, vi, t are known
    public double kin1() {
	return (vars.get("vf") - vars.get("vi")) / vars.get("t");
    }

    //vf = vi + at  >> if vi, a, t are known
    public double kin2() {
	return vars.get("vf") + vars.get("a")*vars.get("t");
    }

    //vi = at - vf >> if a, t, vf are known
    public double kin3() {
	return vars.get("a")*vars.get("t") - vars.get("vf");
    }

    //t = (vf - vi)/a >> if vf, vi, a are known
    public double kin4() {
	return (vars.get("vf") - vars.get("vi")) / vars.get("a");
    }
    //=================================================

    //============d = vit + (1/2)at^2 DERIVED=========

    //d = vit + (1/2)at^2 >> if vi, t, a are known
    public float kin5() {
	return vars.get("vi")*vars.get("t") + (1/2)*vars.get("a")*Math.pow(vars.get("t"), 2);
    }
    //================================================
}//end of class KinCalculator
