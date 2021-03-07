/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apuesta;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ber
 */
public class ApuestaTest {

    public ApuestaTest() {
    }

    /**
     * Test01 para el método apuesta. Combrueba que si en método es correcto,
     * cuando se apuesta una cantidad superior a 0 e inferior al dinero
     * disponible, en este caso el valor límite inferior 1. Nos tiene que
     * devolver el dinero disponible que será la diferencia entre el dinero
     * disponible y el apostado.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testApostar01() throws Exception {
        System.out.println("----------------------------------------------------");
        System.out.println("testApostar01:");
        System.out.println("Límite inferior, realiza una apuesta en el que el dinero apostado = 1€ y comprueba que el dinero disponible es correcto");
        int dineroDisponible = 500;
        int dineroApostado = 1;
        Apuesta apuestaUnEuro = new Apuesta(dineroDisponible, 2, 2);
        apuestaUnEuro.apostar(dineroApostado);
                int expResult = (dineroDisponible - dineroApostado);
        int result = apuestaUnEuro.getDinero_disp();
        assertTrue(apuestaUnEuro.getDinero_disp() == (dineroDisponible - dineroApostado));

        System.out.println("----------------------------------------------------");
    }

    /**
     * Test02 para el método apuesta. Combrueba que si en método es correcto,
     * cuando se apuesta una cantidad superior a 0 e inferior al dinero
     * disponible, en este caso el valor límite superior dinero disponible. Nos
     * tiene que devolver el dinero disponible que será la diferencia entre el
     * dinero disponible y el apostado.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testApostar02() throws Exception {
        System.out.println("----------------------------------------------------");
        System.out.println("testApostar02:");
        System.out.println(" Límite superior, realiza una apuesta en el que el dinero apostado = dinero disponible y comprueba que el dinero disponible es correcto");
        int dineroDisponible = 500;
        int dineroApostado = dineroDisponible;
        Apuesta apuestaDisponible = new Apuesta(dineroDisponible, 2, 2);
        apuestaDisponible.apostar(dineroApostado);
        assertTrue("Valor esperado = " + (dineroDisponible - dineroApostado)+" || Valor devuelto = "+ apuestaDisponible.getDinero_disp(), apuestaDisponible.getDinero_disp() == (dineroDisponible - dineroApostado));
        System.out.println("----------------------------------------------------");
    }

    /**
     * Test03 para el método apuesta. Combrueba que salta una excepción en caso
     * de que la cantidad apostada sea inferior a 1 €, en este caso valor límite
     * 0.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testApostar03() throws Exception {
        System.out.println("----------------------------------------------------");
        System.out.println("testApostar03:");
        System.out.println(" Supera límite inferior, el dinero apostado = 0");
        System.out.println(" Valor esperado Excepción");
        int dineroDisponible = 500;
        int dineroApostado = 0;
        Apuesta apuestaCero = new Apuesta(dineroDisponible, 2, 2);
        try {
            apuestaCero.apostar(dineroApostado);
            fail("Deja apostar menos de 1€");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("----------------------------------------------------");
    }

    /**
     * Test04 para el método apuesta. Combrueba que salta una excepción en caso
     * de que el dinero apostado sea superior al dinero disponible, valor límite
     * disponible+1.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testApostar04() throws Exception {
        System.out.println("----------------------------------------------------");
        System.out.println("testApostar04:");
        System.out.println(" Supera el límite superior, dinero apostado = dinero disponible + 1");
        System.out.println(" Valor esperado Excepción");
        int dineroDisponible = 500;
        int dineroApostado = dineroDisponible + 1 ;
        Apuesta apuestaUnEuroMasQueDisponible = new Apuesta(dineroDisponible, 2, 2);
        try {
            apuestaUnEuroMasQueDisponible.apostar(dineroApostado);
            fail("Deja apostar más cantidad que el dinero disponible");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("----------------------------------------------------");
    }

/**
 * Test01 para el método combrar_apuesta. Combrueba que si en método es
 * correcto, cuando el numero de goles locales, tanto de la apuesta como del
 * resulado del partido, es cero como valor límite inferior, se cobra la
 * apuesta. El valor de la cantidad de dinero disponible una vez cobrada la
 * apuesta debe de ser igual al disponible antes de la apuesta más el
 * apostado multiplicado por 10. al dinero disponible se le suma el apostado
 * multiplicado por 10.
 *
 * @throws java.lang.Exception
 */
@Test
public void testCobrar_apuesta01() throws Exception {
    System.out.println("----------------------------------------------------");
    System.out.println("testCobrar_apuesta01:");
    System.out.println(" Limite inferior numero goles = 0. Intenta cobrar la apuesta porque acierta los goles del local y el visitante que seŕan 0");
    int dineroDisponible = 500;
    int dineroApostado = 10;
    int goles = 0;
    Apuesta apuesta = new Apuesta(dineroDisponible, goles, goles);
    apuesta.apostar(dineroApostado);
    apuesta.cobrar_apuesta(goles, goles);
    assertTrue("Valor esperado = " + ((dineroDisponible - dineroApostado) + (dineroApostado * 10)) + " || Valor devuelto = "+ apuesta.getDinero_disp(), apuesta.getDinero_disp() == ((dineroDisponible - dineroApostado) + (dineroApostado * 10)));
    System.out.println("----------------------------------------------------");
}

/**
 * Test02 para el método combrar_apuesta. Combrueba que si en método es
 * correcto, debe saltar una excepción si se intenta cobrar una apuesta y el
 * numero de goles del resultado del equipo local es diferente del apostado,
 * acertando los goles visitante. Se utilizar el valor 0 como límite
 * inferior.
 *
 * @throws java.lang.Exception
 */
@Test
public void testCobrar_apuesta02() throws Exception {
    System.out.println("----------------------------------------------------");
    System.out.println("testCobrar_apuesta02:");
    System.out.println(" Se intenta cobrar una apuesta en la que el resultado del equipo local no es el mismo que que el del la apuesta y sí se acierta el numero de goles visitante");
    System.out.println(" Valor esperado Excepción");
    int dineroDisponible = 500;
    int dineroApostado = 10;
    int golesA = 0;
    int golesB = 1;
    Apuesta apuesta = new Apuesta(dineroDisponible, golesB, golesA);
    apuesta.apostar(dineroApostado);
    try {
        apuesta.cobrar_apuesta(golesA, golesA);
        fail("Intento cobrar la apuesta cuando no acierto los goles del equipo local y si acierto los del visitante");
    } catch (Exception e) {
        System.out.println(e);
    }
    System.out.println("----------------------------------------------------");
}

/**
 * Test03 para el método combrar_apuesta. Combrueba que si en método es
 * correcto, debe saltar una excepción si se intenta cobrar una apuesta y el
 * numero de goles del resultado del equipo visitante es diferente del
 * apostado, acertando los goles locales. Se utilizar el valor 0 como límite
 * inferior.
 *
 * @throws java.lang.Exception
 */
@Test
public void testCobrar_apuesta03() throws Exception {
    System.out.println("----------------------------------------------------");
    System.out.println("testCobrar_apuesta03:");
    System.out.println(" Se intenta cobrar una apuesta en la que el resultado del equipo visitante no es el mismo que que el del la apuesta y sí se acierta el numero de goles locales");
    System.out.println(" Valor esperado Excepción");
    int dineroDisponible = 500;
    int dineroApostado = 10;
    int golesA = 0;
    int golesB = 1;
    Apuesta apuesta = new Apuesta(dineroDisponible, golesA, golesB);
    apuesta.apostar(dineroApostado);
    try {
        apuesta.cobrar_apuesta(golesA, golesA);
        fail("Intento cobrar la apuesta cuando no acierto los goles del equipo visitante y si acierto los del local");
    } catch (Exception e) {
        System.out.println(e);
    }
    System.out.println("----------------------------------------------------");
}

/**
 * Test04 para el método combrar_apuesta. Combrueba que si en método es
 * correcto, debe saltar una excepción si se intenta cobrar una apuesta en
 * el que el numero de goles del resultado del equipo local y visitante es
 * diferente del apostado. Se utilizar el valor 0 como límite inferior.
 *
 * @throws java.lang.Exception
 */
@Test
public void testCobrar_apuesta04() throws Exception {
    System.out.println("----------------------------------------------------");
    System.out.println("testCobrar_apuesta04:");
    System.out.println(" Se intenta cobrar una apuesta en la que no se acierta el resultado del equipo visitante ni del local");
    System.out.println(" Valor esperado Excepción");
    int dineroDisponible = 500;
    int dineroApostado = 10;
    int golesA = 0;
    int golesB = 1;
    Apuesta apuesta = new Apuesta(dineroDisponible, golesB, golesB);
    apuesta.apostar(dineroApostado);
    try {
        apuesta.cobrar_apuesta(golesA, golesA);
        fail("Intento cobrar la apuesta cuando no acierto los goles del equipo visitante no del local");
    } catch (Exception e) {
        System.out.println(e);
    }
    System.out.println("----------------------------------------------------");
}

/**
 * Test05 para el método combrar_apuesta. Combrueba que si en método es
 * correcto, debe saltar una excepción cuando el número de goles del equipo
 * local es negativo (con el valor limite inferior -1) y el numero de los
 * goles del equipo visitante es correcto (con el valor del limite inferior
 * correcto 0)
 *
 * @throws java.lang.Exception
 */
@Test
public void testCobrar_apuesta05() throws Exception {
    System.out.println("----------------------------------------------------");
    System.out.println("testCobrar_apuesta05:");
    System.out.println(" Intenta cobrar la apuesta con el valor de los goles del equipo local = -1 el visitante = 0");
    System.out.println(" Valor esperado Excepción");
    int dineroDisponible = 500;
    int dineroApostado = 10;
    int golesA = 0;
    int golesB = -1;
    Apuesta apuesta = new Apuesta(dineroDisponible, golesA, golesA);
    apuesta.apostar(dineroApostado);
    try {
        apuesta.cobrar_apuesta(golesB, golesA);
        fail("El equipo no puede tener un marcador negativo");
    } catch (Exception e) {
        System.out.println(e);
    }
    System.out.println("----------------------------------------------------");
}

/**
 * Test06 para el método combrar_apuesta. Combrueba que si en método es
 * correcto, debe saltar una excepción cuando el número de goles del equipo
 * visitante es negativo (con el valor limite inferior -1) y el numero de
 * los goles del equipo local es correcto (con el valor del limite inferior
 * correcto 0)
 *
 * @throws java.lang.Exception
 */
@Test
public void testCobrar_apuesta06() throws Exception {
    System.out.println("----------------------------------------------------");
    System.out.println("testCobrar_apuesta06:");
    System.out.println(" Intenta cobrar la apuesta con el valor de los goles del equipo local = 0 el visitante = -1");
    System.out.println(" Valor esperado Excepción");
    int dineroDisponible = 500;
    int dineroApostado = 10;
    int golesA = 0;
    int golesB = -1;
    Apuesta apuesta = new Apuesta(dineroDisponible, golesA, golesA);
    apuesta.apostar(dineroApostado);
    try {
        apuesta.cobrar_apuesta(golesA, golesB);
        fail("El equipo no puede tener un marcador negativo");
    } catch (Exception e) {
        System.out.println(e);
    }
    System.out.println("----------------------------------------------------");
}

/**
 * Test07 para el método combrar_apuesta. Combrueba que si en método es
 * correcto, debe saltar una excepción cuando el número de goles del equipo
 * local y visitante es negativo (con el valor limite inferior -1).
 *
 * @throws java.lang.Exception
 */
@Test
public void testCobrar_apuesta07() throws Exception {
    System.out.println("----------------------------------------------------");
    System.out.println("testCobrar_apuesta07:");
    System.out.println(" Intenta cobrar la apuesta con el valor de los goles del equipo local y del visitante = -1");
    System.out.println(" Valor esperado Excepción");
    int dineroDisponible = 500;
    int dineroApostado = 10;
    int golesA = 0;
    int golesB = -1;
    Apuesta apuesta = new Apuesta(dineroDisponible, golesA, golesA);
    apuesta.apostar(dineroApostado);
    try {
        apuesta.cobrar_apuesta(golesB, golesB);
        fail("El equipo no puede tener un marcador negativo");
    } catch (Exception e) {
        System.out.println(e);
    }
    System.out.println("----------------------------------------------------");
}
}
