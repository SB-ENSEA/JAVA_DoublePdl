package physics;

import java.util.Scanner;
import static physics.mathz.pi;

public class Sim {

    private static int NbPendulum = 1;

    public Sim(int nbPendulum){this.NbPendulum=nbPendulum;}
    public Sim(){this.NbPendulum = 1;}

    public int getNbPendulum(){return this.NbPendulum;}

    public void setNbPendulum(int NbPendulum){this.NbPendulum = NbPendulum;}

    public double[][] SyncSim(int NbPdl,double[][] ArgsList) {
        this.setNbPendulum(NbPdl);
        double[][] resultList = new double[NbPdl][2];
        Pendulum[] PendulumList = new Pendulum[NbPdl];
        for (int i = 0; i < NbPdl; i++) {
            PendulumList[i].setParams(ArgsList[i]);
        }
        while (PendulumList[NbPdl - 1].getTime() < Pendulum.tTime) {
            for (int i = 0; i < NbPdl; i++){oneSimStep(PendulumList[i]);}
            
        }
        for (int i = 0; i < NbPdl; i++) {
            resultList[i] = PendulumList[i].getAngle();
        }
        return resultList;
    }

    public double[] SyncSim(double[] ArgsList){
        double[] resultList = new double[2];
        Pendulum pdl = new Pendulum();
        pdl.setParams(ArgsList);
        Fullsim(pdl);
        return pdl.getAngle();

    }
    public static void oneSimStep(Pendulum Pdl){
        Pdl.updateVar();
        Pdl.time+=Pdl.tStep;
    }

    public static void Fullsim(Pendulum Pdl) {
        Pdl.time = 0;
        while (Pdl.time < Pdl.tTime) {
            oneSimStep(Pdl);
           /* if (Pdl.IsStopped()) {
                Pdl.time = Pdl.tTime;
            }*/
        }
    }

    public static void LaunchDefaultSim1P(){
        Pendulum Pdl = new Pendulum(0.4*pi,0,1,1,1,1);
        Fullsim(Pdl);
    }

    public static double[] GetSimParams(){
        double[] L = new double[6];
        Scanner scan = new Scanner(System.in);
        System.out.println("Value of theta1 : ");
        L[0]=scan.nextDouble();
        System.out.println("Value of theta2 : ");
        L[1]=scan.nextDouble();
        System.out.println("Value of l1 : ");
        L[2]=scan.nextDouble();
        System.out.println("Value of l2 : ");
        L[3]=scan.nextDouble();
        System.out.println("Value of m1 : ");
        L[4]=scan.nextDouble();
        System.out.println("Value of m2 : ");
        L[5]=scan.nextDouble();
        return L;
    }

    public static void main(String[] args){LaunchDefaultSim1P();}
}
