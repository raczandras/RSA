package hu.andras;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RSA rsa = new RSA();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        rsa.Key_gen();

        System.out.println("lehetséges parancsok: enc = titkosítás | dec = visszafejtés | exit = kilépés \n");

        while(true){
            System.out.print("\nÜzenet (szám): ");
            BigInteger message = scanner.nextBigInteger();

            System.out.print("Parancs: ");
            String choice = scanner1.nextLine();

            switch (choice) {
                case "dec" -> {
                    BigInteger m = rsa.decrypt(message);
                    if (message.equals(rsa.encrypt(m))) {
                        System.out.println("A Visszafejtett üzenet: " + m);
                    }
                }
                case "enc" -> {
                    BigInteger c = rsa.encrypt(message);
                    if (message.equals(rsa.decrypt(c))) {
                        System.out.println("A titkosított üzenet: " + c);
                    }
                }
                case "exit" -> System.exit(0);
                default -> System.out.println("Ismeretlen parancs. \nlehetséges parancsok: enc = titkosítás | dec = visszafejtés | exit = kilépés \n");
            }
        }
    }
}
