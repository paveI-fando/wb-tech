package by.bsuir.fando;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.xml.sax.SAXException;

import by.bsuir.fando.bl.Validator;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
		File xml = new File(args[0]);
		File xsd = new File(args[1]);
		try {
			if(Validator.validateXMLByXSD(xml, xsd) == true) {
				System.out.print("Xml file is valid. Press enter to exit...");
			} else {
				System.out.print("Xml file is not valid. Press enter to exit...");
			}
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
			}
		catch (SAXException e) {
			System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
				}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
			} catch (Exception e) {
		System.out.println(e);
		}finally {
			in.nextLine();
		    in.close();
		}
	}

}
