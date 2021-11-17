package no.hvl.dat100.jplab11.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		try {
		
			// Oppretter fil og printwriter.
			File utfil = new File(filnavn);
			PrintWriter skriver = new PrintWriter(utfil);
			
			// Skriver til fil.
			skriver.println(samling.toString());
			skriver.close();
			return true;
		
		} catch (FileNotFoundException a) {
			System.out.println("Finner ikke fil");
			return false;
		}
		
	}
}
