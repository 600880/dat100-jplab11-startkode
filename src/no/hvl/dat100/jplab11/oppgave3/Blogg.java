package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	// TODO: objektvariable
	Innlegg[] innleggSamling;
	int nesteLedige;

	public Blogg() {
		innleggSamling = new Innlegg[20];
		nesteLedige = 0;
	}

	public Blogg(int lengde) {
		innleggSamling = new Innlegg[lengde];
		nesteLedige = 0;
	}

	public int getAntall() {
		return nesteLedige;
	}
	
	public Innlegg[] getSamling() {
		return innleggSamling;

	}
	
	public int finnInnlegg(Innlegg innlegg) {

		for (int i = 0; i < nesteLedige; i++) {
			if (innleggSamling[i].erLik(innlegg)) {
				return i;
			}	
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for (int i = 0; i < nesteLedige; i++) {
			if (innleggSamling[i].erLik(innlegg)) {
				return true;
			}	
		}
		return false;
	}

	public boolean ledigPlass() {
		return nesteLedige < innleggSamling.length;

	}
	
	public boolean leggTil(Innlegg innlegg) {

		if (finnes(innlegg)) {
			return false;
		}
		innleggSamling[nesteLedige] = innlegg;
		nesteLedige++;
		return true;
	}
	
	public String toString() {
		
		String string = nesteLedige + "\n";
		
		for (int i = 0; i < nesteLedige; i++) {
			string = string + innleggSamling[i].toString();
		}
		
		return string;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		
		Innlegg[] innleggSamling2 = innleggSamling;
		innleggSamling = new Innlegg[innleggSamling.length*2];
		
		for (int i = 0; i < nesteLedige; i++) {
			innleggSamling[i] = innleggSamling2[i];
		}
		
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if (ledigPlass()) {
			return leggTil(innlegg);
		}
		else {
			utvid();
			return leggTil(innlegg);
		}
				
	}
	
	public boolean slett(Innlegg innlegg) {
		
		if (finnes(innlegg)) {
			innleggSamling[finnInnlegg(innlegg)] = null;
			nesteLedige--;
			return true;
		}
		return false;
		
	}
	
	public int[] search(String keyword) {
		
		int[] tab = new int[nesteLedige];
		int j = 0;
		
		for (int i = 0; i < nesteLedige; i++) {
			String s = innleggSamling[i].toString();
			if (s.contains(keyword)) {
				tab[j] = innleggSamling[i].getId();
				j++;
			}
		}
		return tab;

	}
}