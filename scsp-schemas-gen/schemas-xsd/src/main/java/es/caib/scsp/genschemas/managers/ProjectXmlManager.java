/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.caib.scsp.genschemas.managers;

import es.caib.scsp.pom._4_0.Project;
import javax.xml.bind.JAXBException;
import org.apache.maven.pom._4_0.Model;
import es.caib.scsp.utils.xml.XmlManager;

/**
 *
 * @author gdeignacio
 */
@Deprecated
public class ProjectXmlManager extends XmlManager<Project> {

    public ProjectXmlManager() throws JAXBException {
        super(Project.class);
    }
    
}
