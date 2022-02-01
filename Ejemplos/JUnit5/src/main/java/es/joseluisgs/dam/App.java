package es.joseluisgs.dam;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {

        System.out.println( saludo() );
    }


    public static String saludo() {
        return "Hola 1DAM";
    }

    public static double add(double number1, double number2){
        return number1 + number2;
    }

    public static double subtract(double number1, double number2){
        return number1 - number2;
    }

    public static double multiply(double number1, double number2) {
        return number1 * number2;
    }

    public static double divide(double number1, double number2){
        return number1 / number2;
    }

    public static boolean isBisiesto(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    public static boolean isPrimo(int num) {
        if (num == 2) {
            return true;
        } else if (num <= 1 || num % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(num); i+=2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromo(String cadena) {
        String clean = cadena.replaceAll("\\s+", "").toLowerCase();
        int longitud = clean.length();
        int inicio = 0;
        int fin = longitud - 1;
        while (fin > inicio) {
            char inicioChar = clean.charAt(inicio++);
            char finChar = clean.charAt(fin--);
            if (inicioChar != finChar)
                return false;
        }
        return true;

    }

    public static void burbuja(int[] V){
        int i, j;
        int aux;
        for(i=0;i<V.length-1;i++)
            for(j=0;j<V.length-i-1;j++)
                if(V[j+1]<V[j]){
                    aux=V[j+1];
                    V[j+1]=V[j];
                    V[j]=aux;
                }
    }

    public static int busquedaSecuencial(int[] A, int x){
        int i;
        for(i=0;i<A.length;i++)
            if(A[i]==x)
                return i;
        return -1;
    }
}
