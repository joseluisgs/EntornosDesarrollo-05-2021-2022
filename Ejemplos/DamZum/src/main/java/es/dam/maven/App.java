package es.dam.maven;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        float saldo = 500.00f;
        System.out.println("Dime el la cantidad a transferir");
        float cantidad = leerFloat();
        System.out.println("Dime el telefono");
        Scanner sc = new Scanner(System.in);
        String telf = sc.nextLine();

        float salida = transferir(saldo, cantidad, telf);

        switch ((int) salida) {
            case -1: {
                System.err.println("Cantidad no está entre [0,50-500]");
                break;
            }
            case -2: {
                System.err.println("Cantidad mayor que saldo");
                break;
            }
            case -3: {
                System.err.println("Telefono incorrecto");
                break;
            }
            default: {
                saldo = salida;
                System.out.println("Transferencia realizada. Tu saldo actual es: " + saldo + "€");
            }

        }

    }

    public static boolean cantidadIntervalo(float cantidad) {
        return (0.50f <= cantidad) && (cantidad <= 500.00f);
    }

    public static float getNuevoSaldo(float saldo, float cantidad) {
        return saldo-cantidad;
    }

    public static boolean cantidadCorrecta(float cantidad, float saldo) {
        return cantidad <= saldo;
    }

    public static boolean telefonoCorrecto(String telefono) {
        if(telefono.length()!= 9)
            return false;
        if(telefono.charAt(0)!= '6')
            return false;

        for(char c: telefono.toCharArray()) {
            if(!Character.isDigit(c))
                return false;
        }

        return true;
    }

    public static float transferir(float saldo, float cantidad, String telf) {
        if(cantidadIntervalo(cantidad)) {
            if (cantidadCorrecta(cantidad, saldo)) {
                if(telefonoCorrecto(telf)) {
                    return getNuevoSaldo(saldo, cantidad);
                } else {
                    return -3;
                }

            } else {
                return -2;
            }
        } else {
            return -1;
        }

    }

    public static float leerFloat() {
        boolean ok = true;
        float cantidad = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                cantidad = sc.nextFloat();
                ok = true;
            } catch (Exception ex) {
                System.err.println("No es una cantidad válida");
                ok = false;
                sc.next();
            }
        } while(!ok);
        return cantidad;
    }
}
