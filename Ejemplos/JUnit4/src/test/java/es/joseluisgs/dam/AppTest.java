package es.joseluisgs.dam;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @BeforeClass
    public static void setupAll() {
        System.out.println("Preparando las cosas comunes a todos los test. No soy Obligatorio");
    }

    @AfterClass
    public static void finishAll() {
        System.out.println("Aquí va todo lo que hacemos después de todos los test. No soy Obligatorio");
    }

    @Before
    public void setUp() {
        System.out.println("Me ejecuto antes de cada test. No soy Obligatorio");
    }

    @After
    public void setDown() {
        System.out.println("Me ejecuto después de cada test. No soy Obligatorio");
    }


    // Un test por cada cosa que quiera probar
    @Test
    public void shouldAnswerWithTrue() {
        // True siempre es igual a true :)
        System.out.println("True == True");
        assertTrue( true );
    }

    @Test
    public void shouldAnswerWithEquals() {
        // True siempre es igual a true :)
        System.out.println("7 == 7");
        assertEquals(7, 7);
    }

    @Test
    public void shouldAnswerWithArrayEquals() {
        // Arrange, preparamos el test
        int[] v = {1,2,3,4,5};
        int[] expected = {1,2,3,4,5};
        // Actuamos, en este caso no hacemos nada
        System.out.println("array == array");

        // Comprobamos resulatdos, Asserts
        assertArrayEquals(v, expected);
    }

    @Test
    public void saludoTest() {
        // Preparo
        String expected = "Hola 1DAM";
        // Actuo
        String res = App.saludo();
        // Compruebo
        assertEquals(expected, res);
    }

    @Test
    public void addTest() {
        double number1 = 4.0;
        double number2 = 2.0;
        double expResult = 6.0;
        double result = App.add(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void subtractTest() {
        double number1 = 4.0;
        double number2 = 2.0;
        double expResult = 2.0;
        double result = App.subtract(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void multiplyTest() {
        double number1 = 4.0;
        double number2 = 3.0;
        double expResult = 12.0;
        double result = App.multiply(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of divide method, of class JUnit.
     */
    @Test
    public void divideTest() {
        double number1 = 18.0;
        double number2 = 2.0;
        double expResult = 9.0;
        double result = App.divide(number1, number2);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void isBisiestoTest() {
        assertTrue("Año 4", App.isBisiesto(4));
        assertFalse("Año 100", App.isBisiesto(100));
        assertTrue("Año 400", App.isBisiesto(400));
        assertFalse("Año 207", App.isBisiesto(2007));
        assertTrue("Año 2008", App.isBisiesto(2008));
    }

    @Test
    public void isPrimoTest() {
        assertTrue("2", App.isPrimo(2));
        assertFalse("-1", App.isPrimo(-1));
        assertTrue("1", App.isPrimo(11));
        assertTrue("17", App.isPrimo(17));
        assertFalse("18", App.isPrimo(18));
        assertFalse("15", App.isPrimo(15));
    }

    @Test
    public void isPalindromoTest() {
        assertTrue("sarabaras", App.isPalindromo("sarabaras"));
        assertFalse("cacadelavaca", App.isPalindromo("cacadelavaca"));
    }

    @Test
    public void burbujaTest() {
        int[] V = {5, 7, 8, 2};
        int[] expected = {2, 5, 7, 8};
        App.burbuja(V);
        assertArrayEquals("Iguales", expected, V);
    }

    @Test
    public void busquedaSecuencialTest() {
        int[] V = {5, 7, 8, 2};
        int expetedTrue = App.busquedaSecuencial(V,2);
        int expetedFalse = App.busquedaSecuencial(V,99);

        assertNotEquals("Lo encuetra", -1, expetedTrue);
        assertEquals("No Lo encuetra", -1, expetedFalse);

    }
}
