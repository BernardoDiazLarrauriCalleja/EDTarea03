/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apuesta;

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
     * Test01 para el método apuesta. Comprueba que si en método es correcto,
     * cuando se apuesta una cantidad superior a 0 e inferior al dinero
     * disponible, en este caso el valor límite inferior 1. Nos tiene que
     * devolver el dinero disponible que será la diferencia entre el dinero
     * disponible y el apostado.
     *
     *
     */
    @Test
    public void testApostar01() {
        System.out.println("----------------------------------------------------");
        System.out.println("testApostar01 - Clase Válida - Caminio 2/3");
        System.out.println(" Límite inferior. Dinero apostado = 1€");
        int dinero_disp = 500;
        int dinero = 1;
        int cantidad_goles_local = 0;
        int cantidad_goles_visit = 0;
        Apuesta apuestaUnEuro = new Apuesta(dinero_disp, cantidad_goles_local, cantidad_goles_visit);
        try {
            apuestaUnEuro.apostar(dinero);
            int expResult = (dinero_disp - dinero);
            int result = apuestaUnEuro.getDinero_disp();
            if (result == expResult){
                System.out.println("Ok");
            } else {
                System.out.println("*** Error Valor Esperado");
            }
            assertTrue("*** Límite inferior. dinero=1", result == expResult);
        } catch (Exception e) {
            System.out.println("*** Error Excepción: " + e.getMessage());
        }
        System.out.println("----------------------------------------------------");
    }

    /**
     * Test02 para el método apuesta. Comprueba que si en método es correcto,
     * cuando se apuesta una cantidad superior a 0 e inferior al dinero
     * disponible, en este caso el valor límite superior dinero disponible. Nos
     * tiene que devolver el dinero disponible que será la diferencia entre el
     * dinero disponible y el apostado.
     *
     */
    @Test
    public void testApostar02() {
        System.out.println("----------------------------------------------------");
        System.out.println("testApostar02 - Clase Válida - Caminio 2/3");
        System.out.println(" Límite superior. dinero=dinero _disp");
        int dinero_disp = 500;
        int dinero = dinero_disp;
        int cantidad_goles_local = 0;
        int cantidad_goles_visit = 0;
        Apuesta apuestaDisponible = new Apuesta(dinero_disp, cantidad_goles_local, cantidad_goles_visit);
        try {
            apuestaDisponible.apostar(dinero);
            int expResult = (dinero_disp - dinero);
            int result = apuestaDisponible.getDinero_disp();
            if (result == expResult){
                System.out.println("Ok:");
            } else {
                System.out.println("*** Error Valor Esperado");
            }
            assertTrue("*** Límite Superior. Apuesta el dinero disponible", result == expResult);
        } catch (Exception e) {
            System.out.println("*** Error Excepción: " + e.getMessage());
        }
        System.out.println("----------------------------------------------------");
    }

    /**
     * Test03 para el método apuesta. Comprueba que salta una excepción en caso
     * de que la cantidad apostada sea inferior a 1 €, en este caso valor límite
     * 0.
     *
     */
    @Test
    public void testApostar03() {
        System.out.println("----------------------------------------------------");
        System.out.println("testApostar03 - Clase no Válida - Camino 3/3");
        System.out.println(" Supera límite inferior. dinero = 0");
        int dinero_disp = 500;
        int dinero = 0;
        int cantidad_goles_local = 0;
        int cantidad_goles_visit = 0;
        Apuesta apuestaCero = new Apuesta(dinero_disp, cantidad_goles_local, cantidad_goles_visit);
        try {
            apuestaCero.apostar(dinero_disp);
             System.out.println("*** Error: Deja apostar menos de 1€.");
             fail("*** Deja apostar menos de 1€");

        } catch (Exception e) {
            System.out.println("Ok: " + e.getMessage());
        }
        System.out.println("----------------------------------------------------");
    }

    /**
     * Test04 para el método apuesta. Comprueba que salta una excepción en caso
     * de que el dinero apostado sea superior al dinero disponible, valor límite
     * disponible+1.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testApostar04() throws Exception {
        System.out.println("----------------------------------------------------");
        System.out.println("testApostar04 - Clase no Válilda - Camino 1/3");
        System.out.println(" Supera el límite superior. dinero = dinero_disp + 1");
        int dinero_disp = 500;
        int dinero = dinero_disp + 1;
        int cantidad_goles_local = 0;
        int cantidad_goles_visit = 0;
        Apuesta apuestaUnEuroMasQueDisponible = new Apuesta(dinero_disp, cantidad_goles_local, cantidad_goles_visit);
        try {
            apuestaUnEuroMasQueDisponible.apostar(dinero);
            System.out.println("*** Error: Deja apostar más cantidad que el dinero disponible");
            fail("*** Deja apostar más cantidad que el dinero disponible");
        } catch (Exception e) {
            System.out.println("Ok: " + e.getMessage());
        }
        System.out.println("----------------------------------------------------");
    }

    /**
     * Test01 para el método combrar_apuesta. Comprueba que si en método es
     * correcto, cuando el método comprobar resultado es true y el parametro de 
     * entrada número de goles del equipo local y visitante es cero (limite inferior)
     * se cobra la apuesta y el parámetro de salida, la nueva cantidad de dinero
     * disponible será igual al dinero apostado * 10 + el dinero disponible que no
     * se había apostado.
     *
     */
    @Test
    public void testCobrar_apuesta01() {
        System.out.println("----------------------------------------------------");
        System.out.println("testCobrar_apuesta01. Clase Válida. Camino 1/2.");
        System.out.println("Limite inferior. numero goles = 0 y comprobar_resultado= true");
        int dinero_disp = 500;
        int dinero = 10;
        int cantidad_goles_local = 0;
        int cantidad_goles_visit = 0;
        int goles = 0;
        Apuesta apuesta = new Apuesta(dinero_disp, cantidad_goles_local, cantidad_goles_visit);
        try {
            apuesta.apostar(dinero);
            apuesta.cobrar_apuesta(cantidad_goles_local, cantidad_goles_visit);
            int result = apuesta.getDinero_disp();
            int expResult = (dinero_disp - dinero) + (dinero * 10);
            if ((apuesta.comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == true) && result == expResult){
                System.out.println("Ok");
            } else {
                System.out.println("*** Error Valor Esperado");
            }
            assertTrue("*** Acierta apuesta con goles = 0. ***", result == expResult);
        } catch (Exception e) {
            System.out.println("*** Error Excepción: " + e.getMessage());
        }
        System.out.println("----------------------------------------------------");
    }

    /**
     * Test02 para el método combrar_apuesta. Comprueba que si en método es
     * correcto, cuando el método comprobar resultado es false, porque no se aciertan
     * los goles del equipo local, no se cobra la apuesta.
     *
     */
    @Test
    public void testCobrar_apuesta02() {
        System.out.println("----------------------------------------------------");
        System.out.println("testCobrar_apuesta02. Clase no válida. Camino 2/2.");
        System.out.println("Limite inferior. comprobar_resultado= false. Apuesta.cantidad_goles_local <> cobrar_apuesta.cantidad_goles_local = 0");
        int dinero_disp = 500;
        int dinero = 10;
        int cantidad_goles_local = 1;
        int cantidad_goles_visit = 0;
        Apuesta apuesta = new Apuesta(dinero_disp, cantidad_goles_local, cantidad_goles_visit);
        try {
            apuesta.apostar(dinero);
            // Añadimos un gol en local
            apuesta.cobrar_apuesta(cantidad_goles_local - 1, cantidad_goles_visit);
            int result = apuesta.getDinero_disp();
            int expResult = (dinero_disp - dinero) + (dinero * 10);
            if ((apuesta.comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) && result == expResult){
                System.out.println("Ok");
            } else {
                System.out.println("*** Error Valor Esperado");
            }
            assertTrue("*** Acierta apuesta con goles = 0. ***", result == expResult);
        } catch (Exception e) {
            System.out.println("Ok: " + e.getMessage());
        }
        System.out.println("----------------------------------------------------");
    }
    
    /**
     * Test03 para el método combrar_apuesta. Comprueba que si en método es
     * correcto, cuando el método comprobar resultado es false porque no se aciertan
     * los goles del visitante, no se cobra la apuesta.
     *
     */
    @Test
    public void testCobrar_apuesta03() {
        System.out.println("----------------------------------------------------");
        System.out.println("testCobrar_apuesta03. Clase no válida. Camino 2/2.");
        System.out.println("Límite inferior. comprobar_resultado= false. Apuesta.cantidad_goles_visit <> cobrar_apuesta.cantidad_goles_visit = 0");
        int dinero_disp = 500;
        int dinero = 10;
        int cantidad_goles_local = 0;
        int cantidad_goles_visit = 1;
        Apuesta apuesta = new Apuesta(dinero_disp, cantidad_goles_local, cantidad_goles_visit);
        try {
            apuesta.apostar(dinero);
            // Añadimos un gol en local
            apuesta.cobrar_apuesta(cantidad_goles_local, cantidad_goles_visit -1);
            int result = apuesta.getDinero_disp();
            int expResult = (dinero_disp - dinero) + (dinero * 10);
            if ((apuesta.comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) && result == expResult){
                System.out.println("Ok");
            } else {
                System.out.println("*** Error Valor Esperado");
            }
            assertTrue("*** Acierta apuesta con goles = 0. ***", result == expResult);
        } catch (Exception e) {
            System.out.println("Ok: " + e.getMessage());
        }
        System.out.println("----------------------------------------------------");
    }
    
     /**
     * Test04 para el método combrar_apuesta. Comprueba que si en método es
     * correcto, cuando el método comprobar resultado es false porque no se aciertan
     * ni los los goles del visitante ni del local, no se cobra la apuesta.
     *
     */
    @Test
    public void testCobrar_apuesta04() {
        System.out.println("----------------------------------------------------");
        System.out.println("testCobrar_apuesta04. Clase no válida. Camino 2/2.");
        System.out.println("Límite inferior. comprobar_resultado= false. Apuesta.cantidad_goles_visit <> cobrar_apuesta.cantidad_goles_visit = 0");
        System.out.println("Límite inferior. Apuesta.cantidad_goles_visit <> cobrar_apuesta.cantidad_goles_visit = 0");
        int dinero_disp = 500;
        int dinero = 10;
        int cantidad_goles_local = 1;
        int cantidad_goles_visit = 1;
        Apuesta apuesta = new Apuesta(dinero_disp, cantidad_goles_local, cantidad_goles_visit);
        try {
            apuesta.apostar(dinero);
            // Añadimos un gol en local
            apuesta.cobrar_apuesta(cantidad_goles_local -1, cantidad_goles_visit -1);
            int result = apuesta.getDinero_disp();
            int expResult = (dinero_disp - dinero) + (dinero * 10);
            if ((apuesta.comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) && result == expResult){
                System.out.println("Ok");
            } else {
                System.out.println("*** Error Valor Esperado");
            }
            assertTrue("*** Acierta apuesta con goles = 0. ***", result == expResult);
        } catch (Exception e) {
            System.out.println("Ok: " + e.getMessage());
        }
        System.out.println("----------------------------------------------------");
    }
    
    /**
     * Test05 para el método combrar_apuesta. Combrueba que si en método es
     * correcto, cuando se introduce un número negativo de los goles locales a la
     * hora de cobrar la apuesta, salta la excepción del método comprobar.
     *
     */
    @Test
    public void testCobrar_apuesta05() {
        System.out.println("----------------------------------------------------");
        System.out.println("testCobrar_apuesta05. Clase no válida. Camino 2/2.");
        System.out.println("Limite inferior. comprobar_resultado= false. Apuesta.cantidad_goles_local <> cobrar_apuesta.cantidad_goles_local = -1");
        int dinero_disp = 500;
        int dinero = 10;
        int cantidad_goles_local = 0;
        int cantidad_goles_visit = 0;
        Apuesta apuesta = new Apuesta(dinero_disp, cantidad_goles_local, cantidad_goles_visit);
        try {
            apuesta.apostar(dinero);
            // Añadimos un gol en local
            apuesta.cobrar_apuesta(cantidad_goles_local - 1, cantidad_goles_visit);
            int result = apuesta.getDinero_disp();
            int expResult = (dinero_disp - dinero) + (dinero * 10);
            if ((apuesta.comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) && result == expResult){
                System.out.println("Ok");
            } else {
                System.out.println("*** Error Valor Esperado");
            }
            assertTrue("*** Acierta apuesta con goles = 0. ***", result == expResult);
        } catch (Exception e) {
            System.out.println("Ok: " + e.getMessage());
        }
        System.out.println("----------------------------------------------------");
    }
    
    /**
     * Test06 para el método combrar_apuesta. Comprueba que si en método es
     * correcto, cuando se introduce un número negativo de los goles visitantes a la
     * hora de cobrar la apuesta, salta la excepción del método comprobar.
     *
     */
    @Test
    public void testCobrar_apuesta06() {
        System.out.println("----------------------------------------------------");
        System.out.println("testCobrar_apuesta06. Clase no válida. Camino 2/2.");
        System.out.println("Límite inferior. comprobar_resultado= false. Apuesta.cantidad_goles_visit <> cobrar_apuesta.cantidad_goles_visit = -1");
        int dinero_disp = 500;
        int dinero = 10;
        int cantidad_goles_local = 0;
        int cantidad_goles_visit = 0;
        Apuesta apuesta = new Apuesta(dinero_disp, cantidad_goles_local, cantidad_goles_visit);
        try {
            apuesta.apostar(dinero);
            // Añadimos un gol en local
            apuesta.cobrar_apuesta(cantidad_goles_local, cantidad_goles_visit -1);
            int result = apuesta.getDinero_disp();
            int expResult = (dinero_disp - dinero) + (dinero * 10);
            if ((apuesta.comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) && result == expResult){
                System.out.println("Ok");
            } else {
                System.out.println("*** Error Valor Esperado");
            }
            assertTrue("*** Acierta apuesta con goles = 0. ***", result == expResult);
        } catch (Exception e) {
            System.out.println("Ok: " + e.getMessage());
        }
        System.out.println("----------------------------------------------------");
    }
    
     /**
     * Test07 para el método combrar_apuesta. Comprueba que si en método es
     * correcto, cuando se introduce un número negativo de los goles tanto locales
     * como visitantes, salta la excepción del método comprobar.
     *
     */
    @Test
    public void testCobrar_apuesta07() {
        System.out.println("----------------------------------------------------");
        System.out.println("testCobrar_apuesta07. Clase no válida. Camino 2/2.");
        System.out.println("Supera Límite inferior. comprobar_resultado= false. Apuesta.cantidad_goles_visit <> cobrar_apuesta.cantidad_goles_visit = -1 ");
        System.out.println("Supera Límite inferior. Apuesta.cantidad_goles_visit <> cobrar_apuesta.cantidad_goles_visit = -1 ");
        int dinero_disp = 500;
        int dinero = 10;
        int cantidad_goles_local = 0;
        int cantidad_goles_visit = 0;
        Apuesta apuesta = new Apuesta(dinero_disp, cantidad_goles_local, cantidad_goles_visit);
        try {
            apuesta.apostar(dinero);
            // Añadimos un gol en local
            apuesta.cobrar_apuesta(cantidad_goles_local -1, cantidad_goles_visit -1);
            int result = apuesta.getDinero_disp();
            int expResult = (dinero_disp - dinero) + (dinero * 10);
            if ((apuesta.comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) && result == expResult){
                System.out.println("Ok");
            } else {
                System.out.println("*** Error Valor Esperado");
            }
            assertTrue("*** Acierta apuesta con goles = 0. ***", result == expResult);
        } catch (Exception e) {
            System.out.println("Ok: " + e.getMessage());
        }
        System.out.println("----------------------------------------------------");
    }
   
}
