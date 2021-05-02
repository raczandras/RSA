package hu.andras;
import java.math.BigInteger;
import java.util.ArrayList;

public class EA {
    public ArrayList<BigInteger> x = new ArrayList<>();
    public int count = 1;

    public BigInteger EA(BigInteger n1, BigInteger n2) {
        if (n1.equals(BigInteger.ZERO))
            return n2;
        return EA(n2.remainder(n1), n1);
    }

    public BigInteger EEA(BigInteger n1, BigInteger n2) {
        x.add(BigInteger.ONE);
        x.add(BigInteger.ZERO);
        x.add((x.get(x.size() - 1).multiply(n1.divide(n2)).add(x.get(x.size() - 2))));
        BigInteger s;
        while (!(n1.remainder(n2).equals(BigInteger.ZERO))) {
            s = n1;
            n1 = n2;
            n2 = s.remainder(n2);
            count++;
            x.add((x.get(x.size() - 1).multiply(n1.divide(n2)).add(x.get(x.size() - 2))));
        }
        return x.get(x.size() - 2).multiply(BigInteger.valueOf((long) Math.pow(-1, count)));
    }
}
