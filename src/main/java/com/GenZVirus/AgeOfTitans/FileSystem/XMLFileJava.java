package com.GenZVirus.AgeOfTitans.FileSystem;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.GenZVirus.AgeOfTitans.Util.TitanPlayer;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.world.storage.ServerWorldInfo;

public class XMLFileJava {

	public static String default_xmlFilePath = "AgeOfTitans/playerdata/";
	public static String Player_Name = "PlayerName";

	public XMLFileJava(ServerPlayerEntity player) {
		
		
		String xmlFilePath = default_xmlFilePath + player.getUniqueID().toString() + ".xml";
		Player_Name = player.getName().getUnformattedComponentText();
		try {

			File file = new File(xmlFilePath);
			File parent = file.getParentFile();
			if (!parent.exists() && !parent.mkdirs()) { throw new IllegalStateException("Couldn't create dir: " + parent); }

			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

			Document document = documentBuilder.newDocument();

			// player name element
			Element playername = document.createElement("PlayerName");
			playername.appendChild(document.createTextNode(Player_Name));
			document.appendChild(playername);
			
			// balance element
			Element balance = document.createElement("Balance");
			balance.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(balance);

			// player name element
			Element playerlevel = document.createElement("PlayerLevel");
			playerlevel.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(playerlevel);

			// apples eaten element
			Element applesEaten = document.createElement("ApplesEaten");
			applesEaten.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(applesEaten);

			// player name element
			Element playerPoints = document.createElement("PlayerPoints");
			playerPoints.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(playerPoints);

			// player experience element
			Element playerexp = document.createElement("PlayerExp");
			playerexp.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(playerexp);

			// slot1 element
			Element slot1 = document.createElement("Slot1_Spell_ID");
			slot1.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(slot1);

			// slot2 element
			Element slot2 = document.createElement("Slot2_Spell_ID");
			slot2.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(slot2);

			// slot3 element
			Element slot3 = document.createElement("Slot3_Spell_ID");
			slot3.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(slot3);

			// slot4 element
			Element slot4 = document.createElement("Slot4_Spell_ID");
			slot4.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(slot4);

			// spell1 element
			Element SwordSlash = document.createElement("SwordSlash");
			SwordSlash.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(SwordSlash);

			// spell2 element
			Element ShieldBash = document.createElement("ShieldBash");
			ShieldBash.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(ShieldBash);

			// spell3 element
			Element Berserker = document.createElement("Berserker");
			Berserker.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(Berserker);

			// spell4 element
			Element Chain = document.createElement("Chain");
			Chain.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(Chain);

			// spell5 element
			Element GravityBomb = document.createElement("GravityBomb");
			GravityBomb.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(GravityBomb);

			// spell6 element
			Element Revitalise = document.createElement("Revitalise");
			Revitalise.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(Revitalise);

			// passive1 element
			Element Forcefield = document.createElement("Forcefield");
			Forcefield.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(Forcefield);

			// passive2 element
			Element PressenceOfAGod = document.createElement("PressenceOfAGod");
			PressenceOfAGod.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(PressenceOfAGod);

			// passive3 element
			Element ReaperOfSouls = document.createElement("ReaperOfSouls");
			ReaperOfSouls.appendChild(document.createTextNode(Integer.toString(0)));
			playername.appendChild(ReaperOfSouls);

			// create the xml file
			// transform the DOM Object to an XML File
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(xmlFilePath));

			// If you use
			// StreamResult result = new StreamResult(System.out);
			// the output will be pushed to the standard output ...
			// You can use that for debugging

			transformer.transform(domSource, streamResult);

			System.out.println("Done creating XML File");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

	public static void editElement(UUID UniquePlayerName, String elementTag, String elementTextContent) {
		String xmlFilePath = default_xmlFilePath + UniquePlayerName.toString() + ".xml";
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFilePath);

			// Get root element

			checkFileElement(document, xmlFilePath, elementTag);
			Node element = document.getElementsByTagName(elementTag).item(0);
			element.setTextContent(elementTextContent);
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(xmlFilePath));
			transformer.transform(source, result);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	}

	public static String readElement(UUID UniquePlayerName, String elementTag) {
		String xmlFilePath = default_xmlFilePath + UniquePlayerName.toString() + ".xml";
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFilePath);
			checkFileElement(document, xmlFilePath, elementTag);
			Node element = document.getElementsByTagName(elementTag).item(0);
			return element.getTextContent();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
		return "0";
	}

	public static void checkFileElement(Document document, String xmlFilePath, String elementTag) {
		Node element = document.getElementsByTagName(elementTag).item(0);
		if (element == null) {
			try {
				element = document.createElement(elementTag);
				element.appendChild(document.createTextNode(Integer.toString(0)));
				Node playername = document.getElementsByTagName("PlayerName").item(0);
				playername.appendChild(element);
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource domSource = new DOMSource(document);
				StreamResult streamResult = new StreamResult(new File(xmlFilePath));
				transformer.transform(domSource, streamResult);
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}
		}
	}

	public static void checkFileAndMake(ServerPlayerEntity player) {
		if (player.getServer() instanceof IntegratedServer) {
			if (Minecraft.getInstance().getIntegratedServer() != null)
				default_xmlFilePath = "saves/" + ((ServerWorldInfo) Minecraft.getInstance().getIntegratedServer().getWorlds().iterator().next().getWorldInfo()).getWorldName() + "/AgeOfTitans/playerdata/";
		} else {
			default_xmlFilePath = "AgeOfTitans/playerdata/";
		}
		String xmlFilePath = default_xmlFilePath + player.getUniqueID().toString() + ".xml";
		File file = new File(xmlFilePath);
		boolean found = file.exists();

		if (!found) {
			new XMLFileJava(player);
		}

	}
	
	public static TitanPlayer load(ServerPlayerEntity player) {
		checkFileAndMake(player);
		TitanPlayer titan = new TitanPlayer(player);
		titan.setApples_eaten(Integer.parseInt(readElement(player.getUniqueID(), "ApplesEaten")));
		titan.setBalance(Integer.parseInt(readElement(player.getUniqueID(), "Balance")));
		titan.setBerserkerLevel(Integer.parseInt(readElement(player.getUniqueID(), "Berserker")));
		titan.setChainLevel(Integer.parseInt(readElement(player.getUniqueID(), "Chain")));
		titan.setForcefieldLevel(Integer.parseInt(readElement(player.getUniqueID(), "Forcefield")));
		titan.setGravityBombLevel(Integer.parseInt(readElement(player.getUniqueID(), "GravityBomb")));
		titan.setPlayer_exp(Integer.parseInt(readElement(player.getUniqueID(), "PlayerExp")));
		titan.setPlayer_level(Integer.parseInt(readElement(player.getUniqueID(), "PlayerLevel")));
		titan.setPOAGLevel(Integer.parseInt(readElement(player.getUniqueID(), "PressenceOfAGod")));
		titan.setPoints(Integer.parseInt(readElement(player.getUniqueID(), "PlayerPoints")));
		titan.setRevitaliseLevel(Integer.parseInt(readElement(player.getUniqueID(), "Revitalise")));
		titan.setROSLevel(Integer.parseInt(readElement(player.getUniqueID(), "RepearOfSouls")));
		titan.setShieldBashLevel(Integer.parseInt(readElement(player.getUniqueID(), "ShieldBash")));
		titan.setSlot1_ID(Integer.parseInt(readElement(player.getUniqueID(), "Slot1_Spell_ID")));
		titan.setSlot2_ID(Integer.parseInt(readElement(player.getUniqueID(), "Slot2_Spell_ID")));
		titan.setSlot3_ID(Integer.parseInt(readElement(player.getUniqueID(), "Slot3_Spell_ID")));
		titan.setSlot4_ID(Integer.parseInt(readElement(player.getUniqueID(), "Slot4_Spell_ID")));
		titan.setSwordSlashLevel(Integer.parseInt(readElement(player.getUniqueID(), "SwordSlash")));
		return titan;
	}
	
	public static void save(TitanPlayer player) {
		checkFileAndMake(player.getPlayer());
		editElement(player.getPlayer().getUniqueID(), "ApplesEaten", Integer.toString(player.getApples_eaten()));
		editElement(player.getPlayer().getUniqueID(), "Balance", Integer.toString(player.getBalance()));
		editElement(player.getPlayer().getUniqueID(), "Berserker", Integer.toString(player.getBerserkerLevel()));
		editElement(player.getPlayer().getUniqueID(), "Chain", Integer.toString(player.getChainLevel()));
		editElement(player.getPlayer().getUniqueID(), "Forcefield", Integer.toString(player.getForcefieldLevel()));
		editElement(player.getPlayer().getUniqueID(), "GravityBomb", Integer.toString(player.getGravityBombLevel()));
		editElement(player.getPlayer().getUniqueID(), "PlayerExp", Integer.toString(player.getPlayer_exp()));
		editElement(player.getPlayer().getUniqueID(), "PlayerLevel", Integer.toString(player.getPlayer_level()));
		editElement(player.getPlayer().getUniqueID(), "PressenceOfAGod", Integer.toString(player.getPOAGLevel()));
		editElement(player.getPlayer().getUniqueID(), "PlayerPoints", Integer.toString(player.getPoints()));
		editElement(player.getPlayer().getUniqueID(), "Revitalise", Integer.toString(player.getRevitaliseLevel()));
		editElement(player.getPlayer().getUniqueID(), "RepearOfSouls", Integer.toString(player.getROSLevel()));
		editElement(player.getPlayer().getUniqueID(), "ShieldBash", Integer.toString(player.getShieldBashLevel()));
		editElement(player.getPlayer().getUniqueID(), "Slot1_Spell_ID", Integer.toString(player.getSlot1_ID()));
		editElement(player.getPlayer().getUniqueID(), "Slot2_Spell_ID", Integer.toString(player.getSlot2_ID()));
		editElement(player.getPlayer().getUniqueID(), "Slot3_Spell_ID", Integer.toString(player.getSlot3_ID()));
		editElement(player.getPlayer().getUniqueID(), "Slot4_Spell_ID", Integer.toString(player.getSlot4_ID()));
		editElement(player.getPlayer().getUniqueID(), "SwordSlash", Integer.toString(player.getSwordSlashLevel()));
	}

}
