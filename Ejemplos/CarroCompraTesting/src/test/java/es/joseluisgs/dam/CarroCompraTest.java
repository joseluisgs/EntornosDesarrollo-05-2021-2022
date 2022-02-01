package es.joseluisgs.dam;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Carro Compra Test Suite")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarroCompraTest {
    static int [] cantidades;
    static float [] precios;
    static float descuento;
    static float subTotal;
    static float total;
    static float iva;
    static float descuentoAplicado;
    static float ivaAplicado;

    @BeforeAll
    public static void setUp() {
        cantidades = new int[] {1, 2, 1};
        precios = new float[] {10.00f, 25.50f, 32.30f};
        descuento = 10.00f;
        iva = 21.00f;
        subTotal = 93.30f;
        total = 101.60f;
        descuentoAplicado = 9.33f;
        ivaAplicado = 17.63f;
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }

    @Test
    @Order(1)
    @DisplayName("Longitud del carro no es cero")
    public void longitudCarroNoCeroTest() {
        Assertions.assertAll(
                () -> assertTrue(CarroCompra.isLogintudNoCero(cantidades, precios), "Son iguales"),
                () -> assertFalse(CarroCompra.isLogintudNoCero(new int[] {}, new float[] {}), "Es cero la longitud"),
                () -> assertFalse(CarroCompra.isLogintudNoCero(new int[] {1,2}, new float[] {10.00f})),
                () -> assertFalse(CarroCompra.isLogintudNoCero(new int[] {1}, new float[] {10.00f, 25.50f}))
        );
    }

    @Test
    @DisplayName("Los precios son mayores que 0")
    public void isPreciosValidosTest() {
        Assertions.assertAll(
                () -> assertTrue(CarroCompra.isPreciosValidos(precios), "Son correctos"),
                () -> assertFalse(CarroCompra.isPreciosValidos(new float[] {0.0f, 1.0f, 2.0f})),
                () -> assertFalse(CarroCompra.isPreciosValidos(new float[] {1.0f, -1.0f, 2.0f}))
        );
    }

    @Test
    @DisplayName("Las cantidades son mayores que 0")
    public void isCantidadesValidasTest() {
        Assertions.assertAll(
                () -> assertTrue(CarroCompra.isCantidadesValidas(cantidades), "Son correctos"),
                () -> assertFalse(CarroCompra.isCantidadesValidas(new int[] {0, 1, 2})),
                () -> assertFalse(CarroCompra.isCantidadesValidas(new int[] {1, -1, 2}))
        );
    }

    @Test
    @DisplayName("El subTotal calculado es correcto y mayor que 0")
    public void getSubTotalTest() {
        Assertions.assertAll(
                () -> assertFalse(CarroCompra.getSubTotal(cantidades, precios) <=0),
                () -> assertEquals(subTotal, CarroCompra.getSubTotal(cantidades, precios))
        );
    }

    @Test
    @DisplayName("El descuento calculado es correcto y mayor que 0")
    public void isDescuentoValido() {
        Assertions.assertAll(
                () -> assertTrue(CarroCompra.isDescuentoValido(descuento)),
                () -> assertTrue(CarroCompra.isDescuentoValido(0)),
                () -> assertFalse(CarroCompra.isDescuentoValido(-22.0f))
        );
    }

    @Test
    @DisplayName("El descuento aplicado es correcto y mayor que 0")
    public void getDescuentoAplicadoTest() {
        assertEquals(descuentoAplicado, CarroCompra.getDescuentoAplicado(subTotal, descuento), 0.001f);
        assertFalse(CarroCompra.getDescuentoAplicado(subTotal, descuento) <= 0);
    }

    // No es neceario porque no estoy pidiendo el IVA por pantalla
    @Test
    @DisplayName("El impuesto IVA es correcto y mayor que 0")
    public void isImpuestoValidoTest() {
        Assertions.assertAll(
                () -> assertTrue(CarroCompra.isImpuestoValido(iva)),
                () -> assertFalse(CarroCompra.isImpuestoValido(0)),
                () -> assertFalse(CarroCompra.isImpuestoValido(-22.0f))
        );
    }

    @Test
    @DisplayName("El impuesto aplicado es correcto y mayor que 0")
    public void getIvaAplicadoTest() {
        Assertions.assertAll(
                () -> assertEquals(ivaAplicado, CarroCompra.getIvaAplicado(subTotal, descuentoAplicado, iva), 0.001f),
                () -> assertFalse(CarroCompra.getIvaAplicado(subTotal, descuentoAplicado, iva) <= 0.0f)
        );
    }

    @Test
    @DisplayName("El total calculado es correcto y mayor que 0")
    public void getPrecioTotalTest() {
        float precioConDescuento = subTotal - descuentoAplicado;
        Assertions.assertAll(
                () -> assertEquals(total, CarroCompra.getPrecioTotal(precioConDescuento, ivaAplicado), 0.001f),
                () -> assertFalse(CarroCompra.getPrecioTotal(precioConDescuento, ivaAplicado) <= 0.0f)
        );
    }

    @Test
    @DisplayName("El redondeo a dos decimales es correcto")
    public void redondeoTest() {
        Assertions.assertAll(
                () -> assertEquals(20.26f, CarroCompra.redondeo(20.26f), 0.00f),
                () -> assertEquals(20.26f, CarroCompra.redondeo(20.256f), 0.00f),
                () -> assertEquals(20.25f, CarroCompra.redondeo(20.255f), 0.00f),
                () -> assertEquals(20.25f, CarroCompra.redondeo(20.254f), 0.00f)
        );

    }



}
