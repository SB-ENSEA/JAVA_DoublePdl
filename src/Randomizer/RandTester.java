package Randomizer;
import physics.mathz;

import java.util.Arrays;


//Tester for randomizer methods, the goal is to "prove" experimentally that our randomizing methods are following known laws
public class  RandTester {

    static float[] RdTesterBool(int iter) {
        float[] RdResult = new float[iter];
        for (int i = 0; i < iter; i++) {
            RdResult[i] = mathz.Bool2Int(Random.RandomizerAng1());
        }
        float mean = MeanTesterBool(RdResult);
        float var = VarTesterBool(RdResult);
        return new float[]{mean,var};
    }

    static float MeanTesterBool(float[] RdResult){
        return Mean(RdResult);
    }

    static float VarTesterBool(float[] RdResult){
        float mean = Mean(RdResult);
        for (int i = 0; i < RdResult.length; i++) {
            RdResult[i]=mathz.sqrd(RdResult[i] - mean);
        }
        return Mean(RdResult);
    }

    static float Mean(boolean[] RdResult){
        int[] List = mathz.Bool2Int(RdResult);
        return (float)Arrays.stream(List).sum()/List.length;
    }

    static float Mean(int[] RdResult){
        float f = 0;
        f = (float)Arrays.stream(RdResult).sum()/RdResult.length;
        return f;
    }

    static float Mean(float[] RdResult){
        float sum = 0;
        for (float f : RdResult) {
            sum+=f;
        }
        return sum/RdResult.length;
    }


}