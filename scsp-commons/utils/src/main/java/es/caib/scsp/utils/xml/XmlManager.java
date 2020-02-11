/*
 * Copyright 2016 gdeignacio.
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
package es.caib.scsp.utils.xml;

import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

/**
 *
 * @author gdeignacio
 * @param <T>
 */
public class XmlManager<T> {

    private final Class<T> clazz;

    private final JAXBContext jaxbContext;

    public XmlManager(Class<T> clazz) throws JAXBException {

        this.clazz = clazz;
        this.jaxbContext = JAXBContext.newInstance(clazz);
    }

    public JAXBContext getContext() {
        return this.jaxbContext;
    }
    
    public XmlSchema getXmlSchemaAnnotation(){
        
        XmlSchema xmlSchemaAnnotation;
        
        xmlSchemaAnnotation = clazz.getAnnotation(XmlSchema.class);
        
        if (xmlSchemaAnnotation!=null) return xmlSchemaAnnotation;
        
        xmlSchemaAnnotation = clazz.getPackage().getAnnotation(XmlSchema.class);
        
        if (xmlSchemaAnnotation!=null) return xmlSchemaAnnotation;
        
        if (clazz.getSuperclass()==null) return null;
        
        xmlSchemaAnnotation = clazz.getSuperclass().getAnnotation(XmlSchema.class);
        
        if (xmlSchemaAnnotation!=null) return xmlSchemaAnnotation;
        
        xmlSchemaAnnotation = clazz.getSuperclass().getPackage().getAnnotation(XmlSchema.class);
        
        if (xmlSchemaAnnotation!=null) return xmlSchemaAnnotation;
        
        return null;
    }

    private ByteArrayOutputStream marshalToByteArrayOutputStream(T item) throws JAXBException {

        return XmlManager.this.marshalToByteArrayOutputStream(item, Boolean.TRUE);

    }

    private ByteArrayOutputStream marshalToByteArrayOutputStream(T item, boolean formattedOutput) throws JAXBException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formattedOutput);

        jaxbMarshaller.marshal(item, baos);

        return baos;
    }

    private Element marshalToElement(T item) throws JAXBException, ParserConfigurationException{
        return XmlManager.this.marshalToElement(item, Boolean.TRUE);
    }
    
    private Element marshalToElement(T item, boolean formattedOutput) throws JAXBException, ParserConfigurationException {

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formattedOutput);

        jaxbMarshaller.marshal(item, new DOMResult(document));

        //JAXB.marshal(datosEspecificos, new DOMResult(document));
        Element element = document.getDocumentElement();
        
        //jaxbMarshaller.marshal(item, new DOMResult(document));
 
        return element;
    }
    
    private T unmarshal(InputStream is) throws JAXBException {

       Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
       return jaxbUnmarshaller.unmarshal(new StreamSource(is), clazz).getValue();

    }
    
    
    private T unmarshal(String xml) throws JAXBException {

       Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
       return jaxbUnmarshaller.unmarshal(new StreamSource(new StringReader(xml)), clazz).getValue();

    }
    
    private T unmarshal(Element element) throws JAXBException{
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return jaxbUnmarshaller.unmarshal(element, clazz).getValue();
    }
    
    public Element generateElement(T item) throws JAXBException, ParserConfigurationException{
        Element el;
        el = marshalToElement(item);
        return el;
    }
    
    public DataHandler generateXml(T item) throws JAXBException {

        byte[] b = marshalToByteArrayOutputStream(item).toByteArray();
        String mimetype = "application/xml";
        DataSource ds = new ByteArrayDataSource(b, mimetype);
        return new DataHandler(ds);

    }

    public DataHandler generateXml(List<T> items) throws JAXBException {

        byte[] b = generateXmlString(items).getBytes();
        String mimetype = "text/plain";
        DataSource ds = new ByteArrayDataSource(b, mimetype);
        return new DataHandler(ds);

    }

    public DataHandler generateFlatXml(List<T> items) throws JAXBException {

        byte[] b = generateFlatXmlString(items).getBytes();
        String mimetype = "text/plain";
        DataSource ds = new ByteArrayDataSource(b, mimetype);
        return new DataHandler(ds);

    }

    public T generateItem(DataHandler document) throws JAXBException, IOException {
        return unmarshal(document.getInputStream());
    }
    
    public T generateItem(InputStream is) throws JAXBException, IOException {
        return unmarshal(is);
    }
    
    public T generateItem(String xml) throws JAXBException, IOException {
        return unmarshal(xml);
    }
    
    public T generateItem(Element element) throws JAXBException{
        return unmarshal(element);
    }

    public byte[] generateXmlByteArray(T item) throws JAXBException {

        return marshalToByteArrayOutputStream(item).toByteArray();

    }

    public String generateFlatXmlString(T item) throws JAXBException {

        return XmlManager.this.marshalToByteArrayOutputStream(item, Boolean.FALSE).toString();

    }

    public String generateFlatXmlString(List<T> items) throws JAXBException {

        StringBuilder mensajes = new StringBuilder();
        for (T item : items) {
            mensajes.append(generateFlatXmlString(item));
            mensajes.append(IOUtils.LINE_SEPARATOR);
        }
        return mensajes.toString();

    }

    public String generateXmlString(T item) throws JAXBException {

        return marshalToByteArrayOutputStream(item).toString();

    }

    public String generateXmlString(List<T> items) throws JAXBException {

        StringBuilder mensajes = new StringBuilder();
        for (T item : items) {
            mensajes.append(generateXmlString(item));
        }
        return mensajes.toString();

    }
    
    
    public boolean validateItem(T item, DataHandler xsd) throws JAXBException{
        
        return XmlValidation.validateXMLSchema(xsd, generateXml(item));
    
    }

}
