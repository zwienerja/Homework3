import java.math.BigInteger;
import java.util.Random;

public class Homework3 {

    public static void main(String[] args) {

        int length = 2048;
        BigInteger d, e, p, q, n;
        Random rannum = new Random();

        p = BigInteger.probablePrime(length, rannum);
        q = BigInteger.probablePrime(length, rannum);
        n = p.multiply(q);

        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = new BigInteger(phi.bitLength(), rannum);

        while (e.compareTo(BigInteger.ONE) <= 0 || e.compareTo(phi) >= 0 || !e.gcd(phi).equals(BigInteger.ONE));
            d = e.modInverse(phi);

        BigInteger m = new BigInteger("123456789");
        BigInteger r = m.modPow(e, n);
        BigInteger m2 = r.modPow(d, n);

        int outputBit = p.bitLength()+q.bitLength();
        System.out.println(outputBit);
        System.out.println(m);
        System.out.println(m2);
    }
}
