package Core;

import Controllers.UsersController;
import Core.Exceptions.*;
import Entities.User;
import Properties.UserProperty;
import Services.UserService;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.TextField;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

public class Security {

    public static String hashPassword(String pass, String salt){
        String salted = pass  + "{" + salt + "}";
        byte[] digest = hashSHA512(salted.getBytes());
        for (int i= 1; i< 5000; i++){
            byte[] bytes = new byte[0];
            try {
                String digsalt = new String(digest,"ISO-8859-1");
                digsalt += salted;
                bytes = digsalt.getBytes("ISO-8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            digest = hashSHA512(bytes);
        }
        return DatatypeConverter.printBase64Binary(digest);
    }

    private static byte[] hashSHA512(byte[] inputBytes) {
        byte[] digestedBytes = new byte[0];
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(inputBytes);
            digestedBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return digestedBytes;
    }

    public static void checkPassword(String input, User u) throws WrongPasswordException {
        String inputHashed = hashPassword(input, u.getSalt());
        if (!inputHashed.equals(u.getPassword()))
            throw new WrongPasswordException("Mot de passe incorrect");
    }

    public static boolean emailValid(String email)throws EmailInvalidException, EmailUsedException{
        if (!email.matches("^([a-z]|[A-Z])([a-z]|[A-z]|[0-9])*@[a-z].*\\.[a-z]*$")) {
            throw new EmailInvalidException("Entrez une adressse email valide");
        }
        UserService us = new UserService();
        try {
            us.findLogin(email);
            throw new EmailUsedException("L'adresse email est deja utilisée");
        } catch (UserNotFoundException ignored) {
        }
        return true;
    }

    public static boolean usernameValid(String username) throws UsernameInvalidException, UsernameUsedException {
        if (!username.matches("^([a-z]|[A-Z]).*$")) {
            throw new UsernameInvalidException("Le nom d'utilisateur doit commencer par une lettre");
        }
        UserService us = new UserService();
        try {
            us.findLogin(username);
            throw new UsernameUsedException("Le nom d'utilisateur est deja utilisé");
        } catch (UserNotFoundException ignored) {
        }
        return true;
    }

    public static String generateSalt() {
        byte[] b = new byte[32];
        new Random().nextBytes(b);
        b = Base64.getEncoder().encode(b);
        String bytes64 = null;
        try {
            bytes64 = new String(b, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String salt = bytes64.replace('+', '.');
        salt = salt.replaceFirst("=+$", "");
        return salt;
    }

    public static void checkRemembered() {
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader("./src/assets/remembered.txt"));
            String c;
            while ((c = in.readLine()) != null) {
                System.out.println(c);
                User u = new UserService().findUser(Integer.parseInt(c));
                if(u != null)
                    new UsersController().authenticate(u);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
