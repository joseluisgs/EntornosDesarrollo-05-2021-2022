package es.joseluisgs.dam;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Dni
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        String dni = "12345678A";

        System.out.println(dniLongitud(dni));
        System.out.println(ultimoIsLetra(dni));

        System.out.println(getDniLetter(dni));
    }

    public static boolean dniLongitud(String dni) {
        return dni.length() == 9;
    }

    public static boolean ultimoIsLetra(String dni) {
        return Character.isLetter(dni.charAt(8));
    }

    public static boolean primerosAreNumber(String dni) {
        for (int i = 0; i < 8; i++) {
            if (!Character.isDigit(dni.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidLetter(String dni) {
        return dni.charAt(8) == getDniLetter(dni);
    }

    public static char getDniLetter(String dni) {
        String letras="TRWAGMYFPDXBNJZSQVHLCKE";
        int numero = 0;
        for (int i = 0; i < 8; i++) {
            numero += Character.getNumericValue(dni.charAt(i));
        }
        int resto = numero % 23;
        return letras.charAt(resto);
    }
}
