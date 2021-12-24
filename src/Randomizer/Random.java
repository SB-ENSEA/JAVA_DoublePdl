package Randomizer;
import physics.Sim;
import static physics.mathz.pi;

//Static Randomizing methods
public class Random {

    //Because there is no energy loss in our system, our pdl will move indefinitely. We get a snapshot of the Pdl parameters when
    //the pendulum reaches the total time tTime .


    //We first analyse the angles of our pendulum at the end time.
    //The goal of any randomizing process using angles is that our mean on a 1/0 question is 0.5
    //We also need to estimate the effects of the other arguments on the draw

    static protected boolean RandomizerAng1(){
        double[] Theta = ArgsMakerTheta();
        boolean res = false;
        Sim simu = new Sim();
        double[] ArgsList = new double[]{Theta[0],Theta[1],1.0,1.0,1.0,1.0};
        double[] ResultList = new double[]{0,0};
        ResultList = simu.SyncSim(ArgsList);
        if(ResultList[0]>0){res = true;} //we first simply see if the first angle is positive or negative
        return res;
    }
    //Using ArgsMakerTheta : around 0.5, Var around 0.25 =>Centered Bernoulli distribution
    //Problem : even with a relatively high number of draws, the mean is still highly variable between tries => Correlation problem ?

    static private double[] ArgsMakerTheta(){
        double[] Args = new double[2];
        long ref = System.nanoTime();
        Args[0] =( ((ref % 1000) / 1000.0) + 0.1 * ((ref % 10000) / 10000.0) + 0.01 * ((ref % 100000) / 100000.0) ) * 2 * pi;
        Args[1] = - Args[0];
        return Args;
    }
    //ArgsMakerTheta is where we need to de-correlate our theta between two draws, We use the system time (System.nanoTime) to create the first four digits of our angle:

    //static private double[] ArgsMakerLength(){;}

    static private double[]ArgsMakerThetaPdl(){return  new double[2];}
    //New idea : We use a first pendulum draw to completely de-correlate our arguments. This will effectively double the

    public static void main(String[] args) {
        float[] Results = RandTester.RdTesterBool(100000);
        System.out.println("Mean :" + Results[0]);
        System.out.println("Var :" + Results[1]);

    }
}