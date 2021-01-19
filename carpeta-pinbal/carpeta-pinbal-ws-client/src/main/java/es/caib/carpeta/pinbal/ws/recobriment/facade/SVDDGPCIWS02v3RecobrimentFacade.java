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
import es.caib.carpeta.pinbal.ws.recobriment.datosespecificos.SVDDGPCIWS02v3PeticionDatosEspecificos;
import es.caib.carpeta.pinbal.ws.recobriment.datosespecificos.SVDDGPCIWS02v3RespuestaDatosEspecificos;
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
public class SVDDGPCIWS02v3RecobrimentFacade
        extends RecobrimentFacade<
        SVDDGPCIWS02v3PeticionDatosEspecificos, SVDDGPCIWS02v3RespuestaDatosEspecificos> {

        
    public SVDDGPCIWS02v3RecobrimentFacade(String app) {
        super(app);
    }

    /**
     *
     * @param datosEspecificosPeticion
     * @return
     */
    @Override
    protected Element datosEspecificos2Element(SVDDGPCIWS02v3PeticionDatosEspecificos datosEspecificosPeticion) {

        Element elementDatosEspecificos;

        try {
            XmlManager<SVDDGPCIWS02v3PeticionDatosEspecificos> manager
                    = new XmlManager<SVDDGPCIWS02v3PeticionDatosEspecificos>(SVDDGPCIWS02v3PeticionDatosEspecificos.class);

            XmlSchema xmlSchemaAnnotation = manager.getXmlSchemaAnnotation();

            System.out.println("NAMESPACE: " + xmlSchemaAnnotation.namespace());
            System.out.println("LOCATION: " + xmlSchemaAnnotation.location());

            elementDatosEspecificos = manager.generateElement(datosEspecificosPeticion);
            return elementDatosEspecificos;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SVDDGPCIWS02v3RecobrimentFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(SVDDGPCIWS02v3RecobrimentFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    protected RespuestaClientAdapter<SVDDGPCIWS02v3RespuestaDatosEspecificos> peticionSincronaEspecifica(
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
                SVDDGPCIWS02v3PeticionDatosEspecificos datosEspecificosPeticion) {
        
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
    
    
   private SVDDGPCIWS02v3PeticionDatosEspecificos establecerDatosEspecificosPeticion(Integer oonsultaAnioNacimiento, String consultaNumeroSoporte){
    
        SVDDGPCIWS02v3PeticionDatosEspecificos datosEspecificos = new SVDDGPCIWS02v3PeticionDatosEspecificos();
        
        es.caib.scsp.esquemas.SVDDGPCIWS02v3.peticion.datosespecificos.Consulta consulta = new es.caib.scsp.esquemas.SVDDGPCIWS02v3.peticion.datosespecificos.Consulta();
        
        consulta.setAnioNacimiento(oonsultaAnioNacimiento);
        consulta.setNumeroSoporte(consultaNumeroSoporte);
        
        datosEspecificos.setConsulta(consulta);
        
        return datosEspecificos;
    }
    
    private SVDDGPCIWS02v3PeticionDatosEspecificos establecerDatosEspecificosPeticion(){
        return null;
    }
   
    
     public RespuestaClientAdapter<SVDDGPCIWS02v3RespuestaDatosEspecificos> peticionSincrona(
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
                String idSolicitud, String idTransmision
                ) {
        
        
        SVDDGPCIWS02v3PeticionDatosEspecificos datosEspecificosPeticion = 
                establecerDatosEspecificosPeticion();
        
        
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
    
    
    public RespuestaClientAdapter<SVDDGPCIWS02v3RespuestaDatosEspecificos> peticionSincrona(
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
                Integer oonsultaAnioNacimiento, String consultaNumeroSoporte
                ) {
        
        
        SVDDGPCIWS02v3PeticionDatosEspecificos datosEspecificosPeticion = 
                establecerDatosEspecificosPeticion(oonsultaAnioNacimiento, consultaNumeroSoporte);
        
        
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
    protected SVDDGPCIWS02v3RespuestaDatosEspecificos element2DatosEspecificos(Element elementDatosEspecificos) {
        
        SVDDGPCIWS02v3RespuestaDatosEspecificos datosEspecificos;
        try {
            XmlManager<SVDDGPCIWS02v3RespuestaDatosEspecificos> manager
                    = new XmlManager<SVDDGPCIWS02v3RespuestaDatosEspecificos>(SVDDGPCIWS02v3RespuestaDatosEspecificos.class);
            datosEspecificos = manager.generateItem(elementDatosEspecificos);
            
            return datosEspecificos;
            
        } catch (JAXBException ex) {
            Logger.getLogger(SVDDGPCIWS02v3RecobrimentFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SVDDGPCIWS02v3RecobrimentFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


}
