package com.gfs.erm.util;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.gfs.erm.dto.FunctionTO;
import com.gfs.erm.dto.MenuTO;
import com.gfs.erm.dto.SubMenuTO;
import com.gfs.erm.dto.SystemTO;
import com.gfs.erm.dto.TabTO;
import com.gfs.erm.web.common.WebConstants;
import com.thoughtworks.xstream.XStream;

public class XMLUtil {
	
	private static String filename = WebConstants.systemConfigPath + "system-constant.xml";
	private static String menufile = WebConstants.systemConfigPath + "system-menu.xml";
	private static String submenufile = WebConstants.systemConfigPath + "system-submenu.xml";
	private static String functionfile = WebConstants.systemConfigPath + "system-fucntion.xml";
	private static String tabfile = WebConstants.systemConfigPath + "system-tab.xml";
	
	private static String getValue(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
	}

	public static void createXML(List<SystemTO> dataList) {
		
		XStream xstream = new XStream();
		String xml = "";
		for (int i = 0; i < dataList.size(); i++) {
			SystemTO data = new SystemTO();
			data = dataList.get(i);
			xml.concat(xstream.toXML(data));
		}
		try {
			writeFile(xml, filename);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<SystemTO> readXML() {
		
		List<SystemTO> data = new ArrayList<SystemTO>();
		try {

			File stocks = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stocks);
			doc.getDocumentElement().normalize();

			NodeList nodes = doc.getElementsByTagName("SystemTO");

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					SystemTO pm = new SystemTO();
					pm.setAuditLog(getValue("auditLog", element));
					

					data.add(pm);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return data;
	}

	public static void writeFile(String xmlSource, String filename)
			throws SAXException, ParserConfigurationException, IOException {
		try{
		// Parse the given input
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new InputSource(
				new StringReader(xmlSource)));

		// Write the parsed document to an xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(filename));
		transformer.transform(source, result);
		}
		catch(Exception e){
			
		}
		finally{
			
		}
	}
	
	public static List<MenuTO> readMenuXML() {
		
		List<MenuTO> data = new ArrayList<MenuTO>();
		try {

			File stocks = new File(menufile);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stocks);
			doc.getDocumentElement().normalize();

			NodeList nodes = doc.getElementsByTagName("MenuTO");

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					MenuTO menu = new MenuTO();
					menu.setId(Long.valueOf(getValue("Id", element)));
					menu.setName(getValue("Name", element));
					menu.setUrl(getValue("Url", element));

					data.add(menu);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return data;
	}
	
	public static void createMenuXML(List<MenuTO> dataList) {
		
		XStream xstream = new XStream();
		String xml = "";
		for (int i = 0; i < dataList.size(); i++) {
			MenuTO data = new MenuTO();
			data = dataList.get(i);
			xml.concat(xstream.toXML(data));
		}
		try {
			writeFile(xml, menufile);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<SubMenuTO> readSubmenuXML() {
		
		List<SubMenuTO> data = new ArrayList<SubMenuTO>();
		try {

			File stocks = new File(submenufile);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stocks);
			doc.getDocumentElement().normalize();

			NodeList nodes = doc.getElementsByTagName("SubMenuTO");

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					SubMenuTO menu = new SubMenuTO();
					menu.setId(Long.valueOf(getValue("Id", element)));
					menu.setName(getValue("Name", element));
					menu.setUrl(getValue("Url", element));
					menu.setMenuId(Long.valueOf(getValue("MenuId", element)));

					data.add(menu);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return data;
	}
	
	public static void createSubMenuXML(List<SubMenuTO> dataList) {
		
		XStream xstream = new XStream();
		String xml = "";
		for (int i = 0; i < dataList.size(); i++) {
			SubMenuTO data = new SubMenuTO();
			data = dataList.get(i);
			xml.concat(xstream.toXML(data));
		}
		try {
			writeFile(xml, submenufile);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<FunctionTO> readFunctionXML() {
		
		List<FunctionTO> data = new ArrayList<FunctionTO>();
		try {

			File stocks = new File(functionfile);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stocks);
			doc.getDocumentElement().normalize();

			NodeList nodes = doc.getElementsByTagName("FunctionTO");

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					FunctionTO menu = new FunctionTO();
					menu.setId(Long.valueOf(getValue("Id", element)));
					menu.setName(getValue("Name", element));
					
					data.add(menu);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return data;
	}
	
	public static void createFucntionXML(List<FunctionTO> dataList) {
		
		XStream xstream = new XStream();
		String xml = "";
		for (int i = 0; i < dataList.size(); i++) {
			FunctionTO data = new FunctionTO();
			data = dataList.get(i);
			xml.concat(xstream.toXML(data));
		}
		try {
			writeFile(xml, functionfile);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<TabTO> readTabXML() {
		
		List<TabTO> data = new ArrayList<TabTO>();
		try {

			File stocks = new File(tabfile);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stocks);
			doc.getDocumentElement().normalize();

			NodeList nodes = doc.getElementsByTagName("TabTO");

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					TabTO menu = new TabTO();
					menu.setId(Long.valueOf(getValue("Id", element)));
					menu.setName(getValue("Name", element));
					menu.setUrl(getValue("Url", element));
					
					data.add(menu);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return data;
	}
	
	public static void createTabXML(List<TabTO> dataList) {
		
		XStream xstream = new XStream();
		String xml = "";
		for (int i = 0; i < dataList.size(); i++) {
			TabTO data = new TabTO();
			data = dataList.get(i);
			xml.concat(xstream.toXML(data));
		}
		try {
			writeFile(xml, tabfile);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
