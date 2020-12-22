/*
 * Copyright 2020 gdeignacio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.caib.carpeta.pinbal.ws.recobriment.client;

import es.caib.scsp.pinbal.ws.recobriment.client.DadesConnexioRecobriment;
import es.caib.scsp.pinbal.ws.recobriment.facade.RespuestaClientAdapter;
import es.caib.carpeta.pinbal.ws.recobriment.datosespecificos.CDISFWS01v2RespuestaDatosEspecificos;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author gdeignacio
 */
public class AEAT103Iv3ClientTest {
    
    
    private AEAT103Iv3Client client;
    
    public AEAT103Iv3ClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        
        String app = "es.caib.carpeta.";
        DadesConnexioRecobriment dadesConnexio = new DadesConnexioRecobriment(app);
        System.setProperty(app  + "pinbal.client.username", "$carpeta_pinbal");
        System.setProperty(app  + "pinbal.client.password", "carpeta_pinbal");
        System.setProperty(app  + "pinbal.client.baseURL", "https://proves.caib.es/pinbal");
        
        client = new AEAT103Iv3Client(app);
        
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of dummy method, of class AEAT103Iv3Client.
     */
    @Test
    public void testDummy() {
        System.out.println("dummy");
        
        client.dummy();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of peticionSincrona method, of class AEAT103Iv3Client.
     */
    @Test
    public void testPeticionSincrona() {
        //System.out.println("peticionSincrona");
        
        //RespuestaClientAdapter<AEAT103Iv3RespuestaDatosEspecificos> expResult = null;
        //RespuestaClientAdapter<AEAT103Iv3RespuestaDatosEspecificos> result = client.peticionSincrona();
        
        //System.out.println("APELLIDO  " + result.getTransmisionesClient().get(0).getDatosEspecificos().getResultado().getApellido1());
        
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class AEAT103Iv3Example.
     */
    /*
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        AEAT103Iv3Client.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
*/
    
}
