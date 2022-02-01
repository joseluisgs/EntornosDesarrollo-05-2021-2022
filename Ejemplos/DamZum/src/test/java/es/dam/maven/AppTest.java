package es.dam.maven;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * float transferir(float saldo, float cantidad, String destino)
     * X: (saldo-cantidad) -- OK
     * -1: 0.50<= cantidad <= saldo -- OK
     * -2: cantidad>saldo --> cantidad <= saldo -- OK
     * -3: destino[8] == 6 && ddestino.length == 9 -- OK
     */
    @Test
    public void transferirTest() {
        // Caso correcto
        float saldo = 500.00f;
        float cantidad = 300.00f;
        String telf = "666666666";

        assertEquals(200, App.transferir(saldo, cantidad, telf));

        // Caso Cantidad en intervalo
        saldo = 500.00f;
        float c1 = 0.49f;
        float c2 = 500.01f;
        telf = "666666666";
        assertEquals(-1, App.transferir(saldo, c1, telf));
        assertEquals(-1, App.transferir(saldo, c2, telf));

        // Caso Cantidad mayor que saldo
        saldo = 300.00f;
        float c3 = 400.00f;
        telf = "666666666";
        assertEquals(-2, App.transferir(saldo, c3, telf));

        // Caso Cantidad mayor que saldo
        saldo = 500.00f;
        cantidad = 300.00f;
        telf = "766666666";
        assertEquals(-3, App.transferir(saldo, c3, telf));
    }

    @Test
    public void getNuevoSaldoTest() {
        float saldo = 500.00f;
        float cantidad = 300.00f;

        assertEquals(200, App.getNuevoSaldo(saldo, cantidad));
        assertNotEquals(100, App.getNuevoSaldo(saldo, cantidad));

    }

    @Test
    void cantidadIntervaloTest() {
       float cantidadTrue = 100f;
        float cantidadC1 = 0.51f;
        float cantidadC2 = 0.50f;
        float cantidadC3 = 0.49f;
        float cantidadC4 = 499.99f;
        float cantidadC5 = 500.00f;
        float cantidadC6 = 500.01f;

        Assertions.assertAll(
                () -> assertTrue(App.cantidadIntervalo(cantidadTrue)),
                () -> assertTrue(App.cantidadIntervalo(cantidadC1)),
                () -> assertTrue(App.cantidadIntervalo(cantidadC2)),
                () -> assertFalse(App.cantidadIntervalo(cantidadC3)),
                () -> assertTrue(App.cantidadIntervalo(cantidadC4)),
                () -> assertTrue(App.cantidadIntervalo(cantidadC5)),
                () -> assertFalse(App.cantidadIntervalo(cantidadC6))
        );
    }

    @Test
    public void cantidadCorrectaTest() {
        float saldo = 300.00f;

        Assertions.assertAll(
                () -> assertTrue(App.cantidadCorrecta(300.00f, saldo)),
                () -> assertTrue(App.cantidadCorrecta(299.99f, saldo)),
                () -> assertFalse(App.cantidadCorrecta(300.01f, saldo))
        );
    }

    @Test
    public void telefonoCorrectoTest() {
        String c1 = "666666666";
        String c2 = "766666666";
        String c3 = "6666666666";
        String c4 = "66666666";
        String c5 = "6666A6666";

        Assertions.assertAll(
                () -> assertTrue(App.telefonoCorrecto(c1)),
                () -> assertFalse(App.telefonoCorrecto(c2)),
                () -> assertFalse(App.telefonoCorrecto(c3)),
                () -> assertFalse(App.telefonoCorrecto(c4)),
                () -> assertFalse(App.telefonoCorrecto(c5))
        );
    }
}
