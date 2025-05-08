package W_2.decorator;

public class EncryptedPrinter extends BasicPrinter {
    public EncryptedPrinter(Printer wrappee) {
        super(wrappee);
    }

    public String encrypt(String s, Boolean encrypting) {
        int shift = encrypting ? 3 : -3;
        StringBuilder encrypted = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shift) % 26 + base);
            }
            encrypted.append(c);
        }
        return encrypted.toString();
    }

    @Override
    public void print(String s){
        wrappee.print(encrypt(s, true));
        // uncomment to prove decrypt works
        // System.out.print("ENCRYPTED:  " + encrypt(s, true) + "\nDECRYPTED:  " + encrypt(encrypt(s, true), false) + "\nORIGINAL:   " + s);
    }
}
