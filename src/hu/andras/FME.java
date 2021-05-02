package hu.andras;
import java.math.BigInteger;
import java.util.ArrayList;

public class FME {
    public BigInteger FME(BigInteger n, BigInteger power, BigInteger mod){

        BigInteger final_mod = BigInteger.ONE;
        ArrayList<BigInteger> mods = new ArrayList<>();
        ArrayList<BigInteger> powersOfTwo = powersOfTwo(power);
        mods.add(n.remainder(mod));
        BigInteger currentMod;

        for(BigInteger i = BigInteger.ZERO; i.compareTo(powersOfTwo.get(powersOfTwo.size()-1))<0; i = i.add(BigInteger.ONE)){
            currentMod = mods.get(mods.size()-1);
            currentMod = currentMod.multiply(currentMod);
            currentMod = currentMod.remainder(mod);
            mods.add(currentMod);
        }

        for (BigInteger integer : powersOfTwo) {
            final_mod = final_mod.multiply(mods.get(integer.intValue()));
        }

        return final_mod.mod(mod);
    }

    public ArrayList<BigInteger> powersOfTwo(BigInteger n) {
        ArrayList<BigInteger> s = new ArrayList<>();
        ArrayList<BigInteger> powers = new ArrayList<>();

        while (n.compareTo(BigInteger.valueOf(0)) > 0) {
            s.add(n.remainder(BigInteger.TWO));
            n = n.divide(BigInteger.TWO);
        }
        for(int i = 0; i< s.size(); i++){
            if(s.get(i).equals(BigInteger.ONE))
                powers.add(BigInteger.valueOf(i));
        }

        return powers;
    }
}
