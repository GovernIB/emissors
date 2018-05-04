/*
 * Copyright 2018 gdeignacio.
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
package es.caib.scsp.xml.ns.jaxb;

import com.google.common.base.CaseFormat;
import com.sun.java.xml.ns.jaxb.NameXmlTransformRule;
import com.sun.java.xml.ns.jaxb.NameXmlTransformType;
import com.sun.java.xml.ns.jaxb.PackageType;
import com.sun.java.xml.ns.jaxb.SchemaBindings;
import es.caib.scsp.genschemas.managers.XjbBindingsXmlManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.xml.bind.JAXBException;

/**
 *
 * @author gdeignacio
 */
public class XjbBindingsUtils {

    public static XjbBindings getXjbBindings() throws JAXBException, IOException {

        XjbBindings xjbBindings = new XjbBindings();
        InputStream bindingsInputStream = xjbBindings.getClass().getClassLoader().getResourceAsStream("jaxb/templates/bindings.xjb.template");
        XjbBindingsXmlManager manager = new XjbBindingsXmlManager();

        xjbBindings = manager.generateItem(bindingsInputStream);

        return xjbBindings;

    }
    
    private static final String SCHEMA_SCOPE = "schemas";
    private static final String SOAP_SCOPE = "soap";
    private static final String WSDL_SCOPE = "wsdl";
    

    public static XjbBindings getXjbBindings(String key, List<String> xsds, String scope) throws JAXBException, IOException {

        System.out.println("key " + key + ": " + xsds);
        
        XjbBindings xjbBindings = getXjbBindings();
        
        for (String xsd : xsds) {
            
            XjbBindings xsdBindings = new XjbBindings();

            xsdBindings.setSchemaLocation("../../schemas/" + key + "/" + xsd);
            //xsdBindings.setNode("//xs:schema");

            if (WSDL_SCOPE.equals(scope)) {
                if (xsd.endsWith("xsd")) continue;
            } else if (SOAP_SCOPE.equals(scope)) {
                if (xsd.endsWith("wsdl")) continue;
                if (!xsd.startsWith("soap")) continue;
                //include.appendChild(doc.createTextNode("soap*.xsd"));
            } else if (SCHEMA_SCOPE.equals(scope)) {
                
                if (xsd.endsWith("wsdl")) continue;
                if (xsd.startsWith("soap")) continue;
                if (xsd.contains("comun")) continue;
                
                if (xsd.contains("datos-especificos")) {

                    
                    SchemaBindings schemaBindings = new SchemaBindings();
                    
                    PackageType packageType = new PackageType();
                    String packageName = "es.caib.scsp.esquemas." + key + ".datosspecificos";
    
                    packageType.getName().add(packageName);
                    schemaBindings.setPackage(packageType);   
                    
                    
                    
                    NameXmlTransformType nameXmlTransform = new NameXmlTransformType();

                    
                    NameXmlTransformRule typeNameXmlTransformRule = new NameXmlTransformRule();
                    typeNameXmlTransformRule.setPrefix("Type_" + key
                            + CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, xsd.replace(".", "_")).toLowerCase());

                    nameXmlTransform.setTypeName(typeNameXmlTransformRule);
                    
                    
                    NameXmlTransformRule elementNameXmlTransformRule = new NameXmlTransformRule();
                    elementNameXmlTransformRule.setPrefix("Element_" + key
                            + CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, xsd.replace(".", "_")).toLowerCase());

                    nameXmlTransform.setElementName(elementNameXmlTransformRule);
                    schemaBindings.setNameXmlTransform(nameXmlTransform);
                    
                    
                    
                    xsdBindings.getGlobalBindingsOrSchemaBindingsOrClazz().add(schemaBindings);
                    
                    
                    /*
                    XjbBindings nodeBindings = new XjbBindings();
                    String clazzName = CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, xsd.split("\\.")[0]);

                    //String xpath = "//xs:element[@name='" + clazzName + "']";
                    String xpath = "//xs:element[@name='DatosEspecificos']";

                    //String xpath = "//xs:schema";
                    nodeBindings.setNode(xpath);

                    com.sun.java.xml.ns.jaxb.Class clazz = new com.sun.java.xml.ns.jaxb.Class();

                    clazz.getName().add(clazzName + "Element");

                    nodeBindings.getGlobalBindingsOrSchemaBindingsOrClazz().add(clazz);
                    xsdBindings.getGlobalBindingsOrSchemaBindingsOrClazz().add(nodeBindings);
                    */

                }

                /*
                if (xsd.contains("comun")) {
                    
                    SchemaBindings schemaBindings = new SchemaBindings();
                    PackageType packageType = new PackageType();
                    String packageName = "es.caib.scsp.esquemas." + key + ".comun";
                    packageType.getName().add(packageName);
                    schemaBindings.setPackage(packageType);   
                    xsdBindings.getGlobalBindingsOrSchemaBindingsOrClazz().add(schemaBindings);
                
                }
                */

            } else {
                //include.appendChild(doc.createTextNode("*.xsd"));
            }
            
            xjbBindings.getGlobalBindingsOrSchemaBindingsOrClazz().add(xsdBindings);

        }

        //xjbBindings = getXjbBindings();
        return xjbBindings;

    }

/*
    <jxb:bindings schemaLocation="xsd/CommonTypes.xsd">
        <jxb:bindings node="//xs:complexType[@name='AnXSDType']">
            <jxb:class name="AnXSDTypeFromCommonTypes"/>
        </jxb:bindings>
    </jxb:bindings>
    <jxb:bindings schemaLocation="xsd/EvenMoreCommonTypes.xsd">
        <jxb:bindings node="//xs:complexType[@name='AnXSDType']">
            <jxb:class name="AnXSDTypeFromEvenMoreCommonTypes"/>
        </jxb:bindings>
    </jxb:bindings>
 */   
    
}
