package physics;

import static physics.mathz.*;

public class Pendulum {

    protected double theta1;
    protected double theta2;
    protected double l1 = 1;
    protected double l2 = 1;
    protected double m1 = 1;
    protected double m2 = 1;

    private double dtheta1;
    private double dtheta2;

    private double p1;
    private double p2;

    private double dp1;
    private double dp2;

    static double time = 0;



    static final double tTime = 10.0; //total time of the sim
    static final int tPrecision =100;//number of time steps during the total time

    private double A21=0;
    static double deltatheta;
    static final double tStep = tTime/tPrecision;

    static final double g =9.81;

    public Pendulum(){
        setAngle(0,0);
        setLength(1,1);
        setMass(1,1);
    }

    public Pendulum(double theta1,double theta2){
        setAngle(theta1,theta2);
        setLength(1,1);
        setMass(1,1);
    }

    public Pendulum(double theta1, double theta2, double l1 ,double l2, double m1,double m2){
        setAngle(theta1,theta2);
        setLength(l1,l2);
        setMass(m1,m2);
    }


    public double[] getAngle(){return new double[]{this.theta1,this.theta2};}

    public double[] getdAngle(){return new double[]{this.dtheta1,this.dtheta2};}

    public double[] getmvt(){return new double[]{this.p1,this.p2};}

    public double[] getdmvt(){return new double[]{this.dp1,this.dp2};}

    public double getTime(){return time;}

    public void setTime(double time){Pendulum.time=time;}

    public double[] getState(){return new double[]{this.getAngle()[0],this.getAngle()[1],this.time};}

    public boolean IsStopped(){
        if(this.getAngle()[0]<(0.1*pi) & this.getAngle()[1]<(0.1*pi)  & this.getdAngle()[1]==0 & this.getdAngle()[0]==0 & time>5*tStep){
            //System.out.println("steady state reached !");
            return true;
        }
        return false;
    }

    public void setAngle(double theta1,double theta2){this.theta1=theta1; this.theta2=theta2;}
    public void setLength(double l1,double l2){this.l1=l1; this.l2=l2;}
    public void setMass(double m1,double m2){this.m1=m1;this.m2=m2;}
    public void setParams(double[] Params){
        this.setAngle(Params[0],Params[1]);
        this.setLength(Params[2],Params[3]);
        this.setMass(Params[4],Params[5]);
    }

    public void updateVar(){

        theta1+= dtheta1*tStep;
        theta2+= dtheta2*tStep;
        p1+= dp1*tStep;
        p2+= dp2*tStep;

        deltatheta = theta1-theta2;
        double den = (m1+m2*sqrd(sin(deltatheta)));
        A21=(sin(2*deltatheta)*(sqrd(p1)*m2*sqrd(l2) - 2*p1*p2*m2*l1*l2*cos(deltatheta) + sqrd(p2)*(m1+m2)*sqrd(l2))/(2*sqrd(l1)*sqrd(l2)*den)) - (p1*p2*sin(deltatheta)/(l1*l2*den));


        dtheta1=(p1*l1-p2*l2*cos(deltatheta))/(sqrd(l1)*l2*den);
        dtheta2=(p2*(m1+m2)*l1 - p1*m2*l2*cos(deltatheta))/(m2*l1*sqrd(l2)*den);
        dp1= -(m1+m2)*g*l1*sin(theta1) + A21;
        dp2= -m2*g*l2*sin(theta2) - A21;



    }
}
