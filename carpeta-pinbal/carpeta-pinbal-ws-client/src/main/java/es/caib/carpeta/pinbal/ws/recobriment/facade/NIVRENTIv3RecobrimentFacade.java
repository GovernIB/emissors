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
package es.caib.carpeta.pinbal.ws.recobriment.facade;

import es.caib.pinbal.ws.recobriment.Consentimiento;
import es.caib.pinbal.ws.recobriment.TipoDocumentacion;
import es.caib.scsp.pinbal.ws.recobriment.facade.RecobrimentFacade;
import es.caib.scsp.pinbal.ws.recobriment.facade.RespuestaClientAdapter;
import es.caib.carpeta.pinbal.ws.recobriment.datosespecificos.VDISFWS01v2PeticionDatosEspecificos;
import es.caib.carpeta.pinbal.ws.recobriment.datosespecificos.VDISFWS01v2PeticionDatosEspecificos;
import es.caib.carpeta.pinbal.ws.recobriment.datosespecificos.VDISFWS01v2RespuestaDatosEspecificos;
import es.caib.carpeta.pinbal.ws.recobriment.datosespecificos.VDISFWS01v2RespuestaDatosEspecificos;
import es.caib.scsp.utils.xml.XmlManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;

/**
 *
 * @author gdeignacio
 */
public class NIVRENTIv3RecobrimentFacade
        extends RecobrimentFacade<
        VDISFWS01v2PeticionDatosEspecificos, VDISFWS01v2RespuestaDatosEspecificos> {

    
     
    
    
    public NIVRENTIv3RecobrimentFacade(String app) {
        super(app);
    }

    /**
     *
     * @param datosEspecificosPeticion
     * @return
     */
    @Override
    protected Element datosEspecificos2Element(VDISFWS01v2PeticionDatosEspecificos datosEspecificosPeticion){
        
        Element elementDatosEspecificos;
        
        try {
            
            Logger.getLogger(NIVRENTIv3RecobrimentFacade.class.getName()).log(Level.INFO, datosEspecificosPeticion.toString());
            
            XmlManager<VDISFWS01v2PeticionDatosEspecificos> manager
                    = new XmlManager<VDISFWS01v2PeticionDatosEspecificos>(VDISFWS01v2PeticionDatosEspecificos.class);
            
              XmlSchema xmlSchemaAnnotation = manager.getXmlSchemaAnnotation();
  
            System.out.println("NAMESPACE: " + xmlSchemaAnnotation.namespace());
            System.out.println("LOCATION: " + xmlSchemaAnnotation.location());
            
            elementDatosEspecificos = manager.generateElement(datosEspecificosPeticion);
            return elementDatosEspecificos;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(NIVRENTIv3RecobrimentFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(NIVRENTIv3RecobrimentFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
            
 
    }

    @Override
    protected RespuestaClientAdapter<VDISFWS01v2RespuestaDatosEspecificos> peticionSincronaEspecifica(
                String codigoEstado, String codigoEstadoSecundario, 
                String literalError, String literalErrorSec, Integer tiempoEstimadoRespuesta, 
                String codigoCertificado, String idPeticion, 
                String numElementos, String timeStamp, String nifEmisor, 
                String nombreEmisor, String nifFuncionario, 
                String nombreCompletoFuncionario, String seudonimo, String codProcedimiento, 
                String nombreProcedimiento, String codigoUnidadTramitadora, Consentimiento consentimiento, 
                String finalidad, String idExpediente, 
                String identificadorSolicitante, String nombreSolicitante, 
                String unidadTramitadora, String apellido1, String apellido2, 
                String documentacion, String nombre, String nombreCompleto, 
                TipoDocumentacion tipoDocumentacion, String fechaGeneracion, 
                String idSolicitud, String idTransmision, 
                VDISFWS01v2PeticionDatosEspecificos datosEspecificosPeticion) {
        
        return this.peticionSincrona(
                codigoEstado,
                codigoEstadoSecundario,
                literalError,
                literalErrorSec,
                tiempoEstimadoRespuesta,
                codigoCertificado,
                idPeticion,
                numElementos,
                timeStamp,
                nifEmisor,
                nombreEmisor,
                nifFuncionario,
                nombreCompletoFuncionario,
                seudonimo,
                codProcedimiento,
                nombreProcedimiento,
                codigoUnidadTramitadora,
                consentimiento,
                finalidad,
                idExpediente,
                identificadorSolicitante,
                nombreSolicitante,
                unidadTramitadora,
                apellido1,
                apellido2,
                documentacion,
                nombre,
                nombreCompleto,
                tipoDocumentacion,
                fechaGeneracion,
                idSolicitud,
                idTransmision,
                datosEspecificosPeticion
        );
    }
    
    
    private VDISFWS01v2PeticionDatosEspecificos establecerDatosEspecificosPeticion(
            Integer ejercicio
    ){
       
        
        VDISFWS01v2PeticionDatosEspecificos datosEspecificos = new VDISFWS01v2PeticionDatosEspecificos();
       
        datosEspecificos.setEjercicio(ejercicio);
        
        return datosEspecificos;
    }
    
    
    public RespuestaClientAdapter<VDISFWS01v2RespuestaDatosEspecificos> peticionSincrona(
                String codigoEstado, String codigoEstadoSecundario, 
                String literalError, String literalErrorSec, Integer tiempoEstimadoRespuesta, 
                String codigoCertificado, String idPeticion, 
                String numElementos, String timeStamp, String nifEmisor, 
                String nombreEmisor, String nifFuncionario, 
                String nombreCompletoFuncionario, String seudonimo, String codProcedimiento, 
                String nombreProcedimiento, 
                String codigoUnidadTramitadora, Consentimiento consentimiento, 
                String finalidad, String idExpediente, 
                String identificadorSolicitante, String nombreSolicitante, 
                String unidadTramitadora, String apellido1, String apellido2, 
                String documentacion, String nombre, String nombreCompleto, 
                TipoDocumentacion tipoDocumentacion, String fechaGeneracion, 
                String idSolicitud, String idTransmision,
                Integer ejercicio
                ) {
        
        
        VDISFWS01v2PeticionDatosEspecificos datosEspecificosPeticion = 
                establecerDatosEspecificosPeticion(ejercicio);
        
        
        return this.peticionSincronaEspecifica(
                codigoEstado,
                codigoEstadoSecundario,
                literalError,
                literalErrorSec,
                tiempoEstimadoRespuesta,
                codigoCertificado,
                idPeticion,
                numElementos,
                timeStamp,
                nifEmisor,
                nombreEmisor,
                nifFuncionario,
                nombreCompletoFuncionario,
                seudonimo,
                codProcedimiento,
                nombreProcedimiento,
                codigoUnidadTramitadora,
                consentimiento,
                finalidad,
                idExpediente,
                identificadorSolicitante,
                nombreSolicitante,
                unidadTramitadora,
                apellido1,
                apellido2,
                documentacion,
                nombre,
                nombreCompleto,
                tipoDocumentacion,
                fechaGeneracion,
                idSolicitud,
                idTransmision,
                datosEspecificosPeticion
        );
    }

    @Override
    protected VDISFWS01v2RespuestaDatosEspecificos element2DatosEspecificos(Element elementDatosEspecificos) {
        
        VDISFWS01v2RespuestaDatosEspecificos datosEspecificos;
        try {
            XmlManager<VDISFWS01v2RespuestaDatosEspecificos> manager
                    = new XmlManager<VDISFWS01v2RespuestaDatosEspecificos>(VDISFWS01v2RespuestaDatosEspecificos.class);
            datosEspecificos = manager.generateItem(elementDatosEspecificos);
            
            return datosEspecificos;
            
        } catch (JAXBException ex) {
            Logger.getLogger(NIVRENTIv3RecobrimentFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NIVRENTIv3RecobrimentFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


}
