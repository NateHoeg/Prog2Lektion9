package opgave01;

import opgave01.models.GenericVault;
import opgave01.models.IntegerVault;
import opgave01.models.StringVault;

public class Opgave01 {
    public static void main(String[] args) {
        IntegerVault integerVault = new IntegerVault(42, "My password");
        System.out.println(integerVault.getSecret("My password"));
        StringVault stringVault = new StringVault("My secret", "Weak password");
        System.out.println(stringVault.getSecret("Weak password"));
        GenericVault<Integer> genereicIntVault = new GenericVault<>(100, "Generic password");
        System.out.println(genereicIntVault.getSecret("Generic password"));
    }
}
