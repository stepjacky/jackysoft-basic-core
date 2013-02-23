package org.jackysoft.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlUtils {
	final static Log logger  = LogFactory.getLog(XmlUtils.class);
	
	public static Element getRootNode(File file) {
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document doc = null;
		try {
			builder = factory.newDocumentBuilder();
			builder.setEntityResolver(new IgnoreDtdValidateResolver());

			doc = builder.parse(file);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return doc==null?null:doc.getDocumentElement();
	}
	
	public static Element getRootNode(byte[] data) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document doc = null;
		try {
			builder = factory.newDocumentBuilder();
			builder.setEntityResolver(new IgnoreDtdValidateResolver());
            InputStream is = new ByteArrayInputStream(data);
			doc = builder.parse(is);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return doc==null?null:doc.getDocumentElement();
	}
	
	 //~ Methods ////////////////////////////////////////////////////////////////

    public static Element getChildElement(Element parent, String childName) {
        NodeList children = parent.getChildNodes();
        int size = children.getLength();

        for (int i = 0; i < size; i++) {
            Node node = children.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                if (childName.equals(element.getNodeName())) {
                    return element;
                }
            }
        }

        return null;
    }

    public static List getChildElements(Element parent, String childName) {
        NodeList children = parent.getChildNodes();
        List list = new ArrayList();
        int size = children.getLength();

        for (int i = 0; i < size; i++) {
            Node node = children.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                if (childName.equals(element.getNodeName())) {
                    list.add(element);
                }
            }
        }

        return list;
    }

    public static String getChildText(Element parent, String childName) {
        Element child = getChildElement(parent, childName);

        if (child == null) {
            return null;
        }

        return getText(child);
    }

    public static String getText(Element node) {
        StringBuffer sb = new StringBuffer();
        NodeList list = node.getChildNodes();

        for (int i = 0; i < list.getLength(); i++) {
            Node child = list.item(i);

            switch (child.getNodeType()) {
            case Node.CDATA_SECTION_NODE:
            case Node.TEXT_NODE:
                sb.append(child.getNodeValue());
            }
        }

        return sb.toString();
    }

    public static String encode(Object string) {
        if (string == null) {
            return "";
        }

        char[] chars = string.toString().toCharArray();
        StringBuffer out = new StringBuffer();

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
            case '&':
                out.append("&amp;");

                break;

            case '<':
                out.append("&lt;");

                break;

            case '>':
                out.append("&gt;");

                break;

            case '\"':
                out.append("&quot;");

                break;

            default:
                out.append(chars[i]);
            }
        }

        return out.toString();
    }

    public static void printIndent(PrintWriter out, int indent) {
        for (int i = 0; i < indent; i++) {
            out.print(XMLizable.INDENT);
        }
    }
    
    public static org.w3c.dom.Document toW3CDocument(org.dom4j.Document d4doc)
    {
    	org.dom4j.io.DOMWriter d4Writer = new org.dom4j.io.DOMWriter();
    	org.w3c.dom.Document wdoc = null ;
    	try
    	{
    		
    		wdoc	= d4Writer.write(d4doc);
    	}
    	catch(DocumentException e)
    	{
    		logger.error("can't cast dom4jDocument to W3CDocument", e);
    		e.printStackTrace();
    	}
    	
    	return wdoc;
    	
    }

}
