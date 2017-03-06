/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package xmlparse;
import java.io.File;
import java.io.FileWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParse{
    public static void main(String[] args){
        
        try{
            HttpURLConnectionExample http = new HttpURLConnectionExample();
            System.out.println("Testing 1 - Send Http GET request");
            String text = http.sendGet();
            File inputFile = new File("input.txt");
            FileWriter fw = new FileWriter(inputFile);
            fw.write(text);
            fw.close();
            
            DocumentBuilderFactory dbFactory 
               = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" 
               + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("message");
            System.out.println("----------------------------");
            for (int temp = 0; temp < 1; temp++) {
               Node nNode = nList.item(temp);
               System.out.println("\nCurrent Element :" 
                  + nNode.getNodeName());
               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                  Element eElement = (Element) nNode;
                  System.out.println("Name : " 
                     + eElement
                     .getElementsByTagName("name")
                     .item(0)
                     .getTextContent());
                  System.out.println("Grades : " 
                  + eElement
                     .getElementsByTagName("grade")
                     .item(0)
                     .getTextContent());
                  }
            }
                    
        }    
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}