package opgave01.models;

public class GenericVault<E> {

    private E secret;
    private String password;

    public GenericVault(E secret, String password) {
        this.secret = secret;
        this.password = password;
    }


    public E getSecret(String password) {
        if (password.equals(password)) {
            return secret;
        }
        else {
            throw new IllegalArgumentException("Wrong password");
        }
    }
}
