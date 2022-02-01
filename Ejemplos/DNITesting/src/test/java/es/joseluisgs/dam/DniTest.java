package es.joseluisgs.dam;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Suit Test DNI")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DniTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }

    @Test
    @Order(1)
    @DisplayName("Longitud DNI = 9")
    public void testDniLongitud() {
        String dniTrue = "66666666A";
        String dniFalse1 = "666666A";
        String dniFalse2 = "6666666666A";
        Assertions.assertAll(
                () -> assertTrue(Dni.dniLongitud(dniTrue)),
                () -> assertFalse(Dni.dniLongitud(dniFalse1)),
                () -> assertFalse(Dni.dniLongitud(dniFalse2))
        );
    }

    @Test
    @Order(2)
    @DisplayName("Ultima posición es Letra DNI")
    public void testDniLetra() {
        String dniTrue = "66666666A";
        String dniFalse = "666666669";
        Assertions.assertAll(
                () ->assertTrue(Dni.ultimoIsLetra(dniTrue)),
                () ->assertFalse(Dni.ultimoIsLetra(dniFalse))
        );
    }

    @Test
    @DisplayName("Primeras 8 posiciones del DNI son números")
    public void testDniLetraNumeros() {
        String dni = "66666666A";
        assertTrue(Dni.primerosAreNumber(dni));
    }

    @Test
    @DisplayName("Nos da la Letra de un DNI")
    public void testGetDniLetter() {
        String dniTrue = "12345678J";
        char letraTrue = 'J';
        String dniFalse = "12345678K";
        char letraFalse = 'J';

        Assertions.assertAll(
                () -> assertEquals(letraTrue, Dni.getDniLetter(dniTrue), "Letra de DNI es correcta"),
                () -> assertEquals(letraFalse, Dni.getDniLetter(dniFalse), "Letra de DNI es incorrecta")
        );
    }

    @Test
    @DisplayName("Letra de DNI es correcta")
    public void testDniLetraCorrecta() {
        String dniTrue = "12345678J";
        String dniFalse = "66666666B";
        Assertions.assertAll(
                () -> assertTrue(Dni.isValidLetter(dniTrue), "Letra de DNI es correcta"),
                () -> assertFalse(Dni.isValidLetter(dniFalse), "Letra de DNI es incorrecta")
        );
    }


}
