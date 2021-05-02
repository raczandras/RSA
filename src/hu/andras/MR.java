package hu.andras;
import java.math.BigInteger;

public class MR {
    private  BigInteger d;
    private int r=0;
    private int count = 0;


    private FME fme = new FME();

    public boolean MR(BigInteger n){
        getRandD(n);

        if((fme.FME(BigInteger.TWO,d,n).equals(BigInteger.valueOf(1)))&&(fme.FME(BigInteger.TEN,d,n).equals(BigInteger.valueOf(1)))&&(fme.FME(BigInteger.valueOf(5),d,n).equals(BigInteger.valueOf(1)))){
            count++;
        }

        for(int i = 0; i< r; i++){
            if(fme.FME(BigInteger.TWO, d.multiply(BigInteger.valueOf((long) Math.pow(2,i))),n).equals(BigInteger.valueOf(-1))){
                count++;
            }
            if(fme.FME(BigInteger.TEN, (d.multiply(BigInteger.valueOf((long) Math.pow(2,i)))),n).equals(BigInteger.valueOf(-1))){
                count++;
            }
            if(fme.FME(BigInteger.valueOf(5), (d.multiply(BigInteger.valueOf((long) Math.pow(2,i)))),n).equals(BigInteger.valueOf(-1))){
                count++;
            }
        }

        return count >= 3;
    }

    public void getRandD(BigInteger n){

        if(!((n.remainder(BigInteger.TWO)).equals(BigInteger.ZERO))){
            n = n.subtract(BigInteger.ONE);
        }

        while (((n.remainder(BigInteger.TWO)).equals(BigInteger.ZERO))){
            n = n.divide(BigInteger.TWO);
            r++;
        }
        d = n;
    }
}
