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
package es.caib.scsp.schemas;

//import es.caib.pinbal.scsp.XmlHelper;
import es.caib.pinbal.scsp.XmlHelper;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.CodeSource;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.commons.io.IOUtils;

//import org.apache.commons.io.IOUtils;

/**
 *
 * @author gdeignacio
 */
public class GenProject {
    
     public static void main(String args[]) throws Exception {
         
         
         CodeSource src = XmlHelper.class.getProtectionDomain().getCodeSource();

         System.out.println(src);
         
         if (src == null) {
             return;
         }

         URL jar = src.getLocation();
         ZipInputStream zip = new ZipInputStream(jar.openStream());
         while (true) {
             ZipEntry e = zip.getNextEntry();
             if (e == null) {
                 break;
             }
             if (e.isDirectory()) continue;
             String name = e.getName();
             if (name.startsWith("schemas/")) {
                 System.out.println(name);
             }
         }
        
        
         
     /*
         Enumeration<URL> enume = XmlHelper.class.getClassLoader().
                
         while (enume.hasMoreElements()){
             System.out.println(enume.nextElement());
         }
       */
     
         
         InputStream is = XmlHelper.class.getClassLoader().getResourceAsStream("schemas/AEAT102v2/peticion.xsd");

         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         IOUtils.copy(is, baos);
         is.close();
         baos.close();
         
         
          //System.out.println(baos.toString());
     
     }
}
