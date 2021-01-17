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
import es.caib.carpeta.pinbal.ws.recobriment.datosespecificos.CDISFWS01v2PeticionDatosEspecificos;
import es.caib.carpeta.pinbal.ws.recobriment.datosespecificos.CDISFWS01v2RespuestaDatosEspecificos;
import es.caib.scsp.utils.xml.XmlManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;

/**
 *
 * @author gdeignacio
 */
public class CDISFWS01v2RecobrimentFacade
        extends RecobrimentFacade<
        CDISFWS01v2PeticionDatosEspecificos, CDISFWS01v2RespuestaDatosEspecificos> {

    public CDISFWS01v2RecobrimentFacade(String app) {
        super(app);
    }

    /**
     *
     * @param datosEspecificosPeticion
     * @return
     */
    @Override
    protected Element datosEspecificos2Element(CDISFWS01v2PeticionDatosEspecificos datosEspecificosPeticion){
        
        Element elementDatosEspecificos;
        
        try {
            XmlManager<CDISFWS01v2PeticionDatosEspecificos> manager
                    = new XmlManager<CDISFWS01v2PeticionDatosEspecificos>(CDISFWS01v2PeticionDatosEspecificos.class);
            elementDatosEspecificos = manager.generateElement(datosEspecificosPeticion);
            return elementDatosEspecificos;
        } catch (JAXBException ex) {
            Logger.getLogger(CDISFWS01v2RecobrimentFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CDISFWS01v2RecobrimentFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
            
 
    }

    @Override
    protected RespuestaClientAdapter<CDISFWS01v2RespuestaDatosEspecificos> peticionSincronaEspecifica(
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
                CDISFWS01v2PeticionDatosEspecificos datosEspecificosPeticion) {
        
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
    
    
    private CDISFWS01v2PeticionDatosEspecificos establecerDatosEspecificosPeticion(
            String datosTitularApellido1,
            String datosTitularApellido2,
            String titularDatosVia,
            String titularLocalidad,
            String titularProvincia,
            String titularNacimientoFecha,
            String titularNacimientoPais,
            String titularNacimientoProvincia,
            String titularNacimientoLocalidad,
            String titularFechaCaducidad,
            String titularIdentificador,
            String titularNacionalidad,
            String titularNomMadre,
            String titularNomPadre,
            String titularNombre,
            String titularNumSoporte,
            String titularSexo,
            String solicitanteCodOrganizacion,
            String solicitanteNombreOrganizacion,
            String solicitanteApellido1,
            String solicitanteApellido2,
            String solicitanteIdFuncionario,
            String solicitanteNombre,
            String solicitanteNumFuncionario,
            String solicitanteTelefono,
            String solicitanteTipo,
            String solicitudNumSoporte
    ) {

        CDISFWS01v2PeticionDatosEspecificos datosEspecificos = new CDISFWS01v2PeticionDatosEspecificos();
        
        es.caib.scsp.esquemas.CDISFWS01v2.peticion.datosespecificos.DatosTitular datosTitular = new es.caib.scsp.esquemas.CDISFWS01v2.peticion.datosespecificos.DatosTitular();
        
        datosTitular.setApellido1(datosTitularApellido1);
        datosTitular.setApellido2(datosTitularApellido2);
        
        es.caib.scsp.esquemas.CDISFWS01v2.peticion.datosespecificos.DatosDireccionType datosDireccion = new es.caib.scsp.esquemas.CDISFWS01v2.peticion.datosespecificos.DatosDireccionType();
        datosDireccion.setDatosVia(titularDatosVia);
        datosDireccion.setLocalidad(titularLocalidad);
        datosDireccion.setProvincia(titularProvincia);
        datosTitular.setDatosDireccion(datosDireccion);
        
        es.caib.scsp.esquemas.CDISFWS01v2.peticion.datosespecificos.DatosNacimientoType datosNacimiento = new es.caib.scsp.esquemas.CDISFWS01v2.peticion.datosespecificos.DatosNacimientoType();
        datosNacimiento.setFecha(titularNacimientoFecha);
        datosNacimiento.setProvincia(titularNacimientoProvincia);
        datosNacimiento.setLocalidad(titularNacimientoLocalidad);
        datosTitular.setDatosNacimiento(datosNacimiento);
        datosTitular.setFechaCaducidad(titularFechaCaducidad);
        datosTitular.setIdentificador(titularIdentificador);
        datosTitular.setNacionalidad(titularNacionalidad);
        datosTitular.setNomMadre(titularNomMadre);
        datosTitular.setNomPadre(titularNomPadre);
        datosTitular.setNombre(titularNombre);
        datosTitular.setNumSoporte(titularNumSoporte);
        datosTitular.setSexo(titularSexo);
        datosEspecificos.setDatosTitular(datosTitular);
        
        es.caib.scsp.esquemas.CDISFWS01v2.peticion.datosespecificos.SolicitanteDatos solicitanteDatos = new es.caib.scsp.esquemas.CDISFWS01v2.peticion.datosespecificos.SolicitanteDatos();
        es.caib.scsp.esquemas.CDISFWS01v2.peticion.datosespecificos.Organizacion organizacion = new es.caib.scsp.esquemas.CDISFWS01v2.peticion.datosespecificos.Organizacion();
        
        organizacion.setCodOrganizacion(solicitanteCodOrganizacion);
        organizacion.setNombreOrganizacion(solicitanteNombreOrganizacion);
        solicitanteDatos.setApellido1(solicitanteApellido1);
        solicitanteDatos.setApellido2(solicitanteApellido2);
        solicitanteDatos.setIdFuncionario(solicitanteIdFuncionario);
        solicitanteDatos.setNombre(solicitanteNombre);
        solicitanteDatos.setNumFuncionario(solicitanteNumFuncionario);
        solicitanteDatos.setOrganizacion(organizacion);
        solicitanteDatos.setTelefono(solicitanteTelefono);
        solicitanteDatos.setTipo(solicitanteTipo);
        datosEspecificos.setSolicitanteDatos(solicitanteDatos);
    
        // Solicitud
        es.caib.scsp.esquemas.CDISFWS01v2.peticion.datosespecificos.Solicitud solicitud = new es.caib.scsp.esquemas.CDISFWS01v2.peticion.datosespecificos.Solicitud();
        solicitud.setNumSoporte(solicitudNumSoporte); 
        datosEspecificos.setSolicitud(solicitud);

        return datosEspecificos;

    }
    
    
    public RespuestaClientAdapter<CDISFWS01v2RespuestaDatosEspecificos> peticionSincrona(
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
            String datosTitularApellido1,
            String datosTitularApellido2,
            String titularDatosVia,
            String titularLocalidad,
            String titularProvincia,
            String titularNacimientoFecha,
            String titularNacimientoPais,
            String titularNacimientoProvincia,
            String titularNacimientoLocalidad,
            String titularFechaCaducidad,
            String titularIdentificador,
            String titularNacionalidad,
            String titularNomMadre,
            String titularNomPadre,
            String titularNombre,
            String titularNumSoporte,
            String titularSexo,
            String solicitanteCodOrganizacion,
            String solicitanteNombreOrganizacion,
            String solicitanteApellido1,
            String solicitanteApellido2,
            String solicitanteIdFuncionario,
            String solicitanteNombre,
            String solicitanteNumFuncionario,
            String solicitanteTelefono,
            String solicitanteTipo,
            String solicitudNumSoporte
                ) {
        
        
        CDISFWS01v2PeticionDatosEspecificos datosEspecificosPeticion = 
                establecerDatosEspecificosPeticion(
                   datosTitularApellido1,
                   datosTitularApellido2,
                   titularDatosVia,
                   titularLocalidad,
                   titularProvincia,
                   titularNacimientoFecha,
                   titularNacimientoPais,
                   titularNacimientoProvincia,
                   titularNacimientoLocalidad,
                   titularFechaCaducidad,
                   titularIdentificador,
                   titularNacionalidad,
                   titularNomMadre,
                   titularNomPadre,
                   titularNombre,
                   titularNumSoporte,
                   titularSexo,
                   solicitanteCodOrganizacion,
                   solicitanteNombreOrganizacion,
                   solicitanteApellido1,
                   solicitanteApellido2,
                   solicitanteIdFuncionario,
                   solicitanteNombre,
                   solicitanteNumFuncionario,
                   solicitanteTelefono,
                   solicitanteTipo,
                   solicitudNumSoporte
                );
        
        
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
    protected CDISFWS01v2RespuestaDatosEspecificos element2DatosEspecificos(Element elementDatosEspecificos) {
        
        CDISFWS01v2RespuestaDatosEspecificos datosEspecificos;
        try {
            XmlManager<CDISFWS01v2RespuestaDatosEspecificos> manager
                    = new XmlManager<CDISFWS01v2RespuestaDatosEspecificos>(CDISFWS01v2RespuestaDatosEspecificos.class);
            datosEspecificos = manager.generateItem(elementDatosEspecificos);
            
            return datosEspecificos;
            
        } catch (JAXBException ex) {
            Logger.getLogger(CDISFWS01v2RecobrimentFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CDISFWS01v2RecobrimentFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


}
