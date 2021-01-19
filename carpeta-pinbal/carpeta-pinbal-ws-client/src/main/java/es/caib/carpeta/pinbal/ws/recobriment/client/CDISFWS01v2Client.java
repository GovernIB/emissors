package es.caib.carpeta.pinbal.ws.recobriment.client;


import es.caib.pinbal.ws.recobriment.Consentimiento;
import es.caib.pinbal.ws.recobriment.TipoDocumentacion;
import java.util.logging.Level;
import java.util.logging.Logger;
import es.caib.scsp.pinbal.ws.recobriment.facade.RespuestaClientAdapter;
import es.caib.carpeta.pinbal.ws.recobriment.datosespecificos.CDISFWS01v2RespuestaDatosEspecificos;
import es.caib.carpeta.pinbal.ws.recobriment.facade.CDISFWS01v2RecobrimentFacade;


/**
 *
 * @author gdeignacio
 */
public class CDISFWS01v2Client {
    
    private static String APP = "es.caib.carpeta.";
    
     // Estado

    private String codigoEstado = null;
    private String codigoEstadoSecundario = null;
    private String literalError = null;
    private String literalErrorSec = null;
    private Integer tiempoEstimadoRespuesta = null;

    //Atributos

    private String codigoCertificado = "CDISFWS01";
    private String idPeticion = null;
    private String numElementos = "1";
    private String timeStamp = null;

    //Emisor (obtingut de la documentació SCSP del servei)

    private String nifEmisor = "S2816015H";
    private String nombreEmisor = "DGP";

    //Funcionario

    private String nifFuncionario = "43083795B";
    private String nombreCompletoFuncionario = "Gabriel Francisco Ramis de Ayreflor Conrado";
    private String seudonimo = null;

    //Procedimiento

    private String codProcedimiento = "CODSVDR_GBA_20121107";
    private String nombreProcedimiento = "PRUEBAS DE INTEGRACION PARA GOBIERNO DE BALEARES";
   
    //Solicitante
    private String codigoUnidadTramitadora = null;
    private Consentimiento consentimiento = Consentimiento.SI;
    private String finalidad = "Baremacions per el proces d'escolaritzacio";
    private String idExpediente = "";//"Q9WREU";
    private String identificadorSolicitante = "S0711001H";
    private String nombreSolicitante = "Conselleria d'Educació";
    private String unidadTramitadora = "Servei d'escolarització";

    //Titular
    private String apellido1 = "";
    private String apellido2 = "";
    private String documentacion = "78206333P";
    private String nombre = "";
    private String nombreCompleto = "";
    private TipoDocumentacion tipoDocumentacion = TipoDocumentacion.NIF;

    // Transmision

    private String fechaGeneracion = "";
    private String idSolicitud = "";
    private String idTransmision = "";

    
    // Datos Especificos
    // PeticionDatosEspecificos
    
    // Fin datos especificos
    
  
    
    protected static final Logger LOG = Logger.getLogger(CDISFWS01v2Client.class.getName());

    private CDISFWS01v2RecobrimentFacade facade;
    
    public CDISFWS01v2Client(){
        this(APP);
    }
    
    public CDISFWS01v2Client(String app){
        this.facade = new CDISFWS01v2RecobrimentFacade(app);
    }
    
    public void dummy(){
        _dummy();
    }
    
    private static void _dummy() {
        LOG.log(Level.INFO, "Invoking dummy...");
    }
   
    
    
    public RespuestaClientAdapter<CDISFWS01v2RespuestaDatosEspecificos> peticionSincrona(){
        
        RespuestaClientAdapter<CDISFWS01v2RespuestaDatosEspecificos> respuestaClient =
            facade.peticionSincrona(codigoEstado, codigoEstadoSecundario, literalError, literalErrorSec, tiempoEstimadoRespuesta, codigoCertificado, idPeticion, numElementos, timeStamp, nifEmisor, nombreEmisor, nifFuncionario, nombreCompletoFuncionario, seudonimo, codProcedimiento, nombreProcedimiento, codigoUnidadTramitadora, consentimiento, finalidad, idExpediente, identificadorSolicitante, nombreSolicitante, unidadTramitadora, apellido1, apellido2, documentacion, nombre, nombreCompleto, tipoDocumentacion, fechaGeneracion, idSolicitud, idTransmision);
        return respuestaClient;
    }
    
    
    public static void main(String args[]) throws Exception {
        
     

    }

}
