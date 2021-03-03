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
//
//    public ApuestaTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getDinero_disp method, of class Apuesta.
//     */
//    @Test
//    public void testGetDinero_disp() {
//        System.out.println("getDinero_disp");
//        Apuesta instance = new Apuesta();
//        int expResult = 0;
//        int result = instance.getDinero_disp();
//        assertEquals(expResult, result);
//         TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setDinero_disp method, of class Apuesta.
//     */
//    @Test
//    public void testSetDinero_disp() {
//        System.out.println("setDinero_disp");
//        int dinero_disp = 0;
//        Apuesta instance = new Apuesta();
//        instance.setDinero_disp(dinero_disp);
//         TODO review the generated test code and removenn the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test para el método Apostar. Si el método es correcto, si partiendo de un dinero
//     * disponible de 500 euros, no nos deja apostar 501 euro.
//     */
//

    @Test
    public void testApostar() throws Exception
    {
        System.out.println("Test de prueba para combrobar que pasa cuando se apuesta mas dinero del dinero disponibles");
        int dineroDisponible = 500;
        int dineroApostado = 501;
        Apuesta masDineroQueDisponible = new Apuesta(dineroDisponible,2,2);
        masDineroQueDisponible.setDinero_disp(dineroApostado);
        try
        {
         masDineroQueDisponible.apostar(dineroApostado);
         fail("Se intenta apostar mas dinero que el dinero disponible");
        }
        catch (Exception e)
        {
          System.out.println(e);
          assertTrue(masDineroQueDisponible.getDinero_disp() == dineroDisponible);
        }
        
    }

//    /**
//     * Test of comprobar_resultado method, of class Apuesta.
//     */
//    @Test
//    public void testComprobar_resultado() throws Exception {
//        System.out.println("comprobar_resultado");
//        int local = 0;
//        int visitante = 0;
//        Apuesta instance = new Apuesta();
//        boolean expResult = false;
//        boolean result = instance.comprobar_resultado(local, visitante);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of cobrar_apuesta method, of class Apuesta.
//     */
//    @Test
//    public void testCobrar_apuesta() throws Exception {
//        System.out.println("cobrar_apuesta");
//        int cantidad_goles_local = 0;
//        int cantidad_goles_visit = 0;
//        Apuesta instance = new Apuesta();
//        instance.cobrar_apuesta(cantidad_goles_local, cantidad_goles_visit);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
