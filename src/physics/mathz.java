package physics;

import java.lang.Math;

public class mathz {

    static public final double pi = Math.PI;

    public static double sqrd(double a){return Math.pow(a,2);}

    public static float sqrd(float a){return (float) Math.pow(a,2);}

    public static double cos(double a){return Math.cos(a);}

    public static double sin(double a){return Math.sin(a);}

    public static int Bool2Int(boolean bool){
        if(bool){return 1;}
        else{return 0;}
    }

    public static int[] Bool2Int(boolean[] bool){
        int[] res = new int[bool.length];
        for (int i = 0; i < bool.length; i++){
            if(bool[i]){res[i]=1;}
            else{res[i]=0;}
        }
        return res;
    }

    public static void main(String[] args){System.out.println(cos(pi));}
}

