package it.unipv.sfw.banca;
import it.unipv.sfw.banca.conti.*;
import java.util.ArrayList;
import it.unipv.sfw.banca.accountable.*;

public class Banca {
	private String nome, radiceIban;
	private ArrayList<Conto> conti;
	
	public Banca(String nome, String radiceIban) {
		this.nome = nome;
		this.radiceIban = radiceIban;
		this.conti = new ArrayList<Conto>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRadiceIban() {
		return radiceIban;
	}

	public void setRadiceIban(String radiceIban) {
		this.radiceIban = radiceIban;
	}

	public ArrayList<Conto> getConti() {
		return conti;
	}

	public void setConti(ArrayList<Conto> conti) {
		this.conti = conti;
	}
	
	public String attivaConto(Persona p, TipoConto tipo) {
		switch(tipo) {
			case CONTO_CORRENTE:
				conti.add(new ContoCorrente(p, this.radiceIban + "-" + this.conti.size()));
				return "Conto attivato correttamente.";
			case CONTO_WEB:
				conti.add(new ContoWeb(p, this.radiceIban + "-" + this.conti.size()));
				return "Conto attivato correttamente.";
			case CONTO_DEPOSITO:
				conti.add(new ContoDeposito(p, this.radiceIban + "-" + this.conti.size()));
				return "Conto attivato correttamente.";
			default:
				return "Impossibile attivare il conto.";
		}
	}
	
	public double totaleSaldi() {
		double somma = 0;
		for(Conto c: conti) {
			somma += c.getSaldo();
		}
		return somma;
	}
	
	public Conto getConto(String iban) {
		for(Conto c: conti) {
			if(c.getIban().equals(iban)) {
				return c;
			}
		}
		return null;
	}
	
	public String operazione(Conto c, double importo) {
		for(Conto conto: conti) {
			if(c.getIban().equals(conto.getIban())) {
				if(conto.operazione(importo)) {
					return "Operazione effettuata con successo.";
				}
			}
		}
		return "Impossibile eseguire l'operazione.";
	}
	
	public String aggiungiAccountable(Conto c, Accountable a) {
		for(Conto conto: conti) {
			if(c.getIban().equals(conto.getIban())) {
				c.getAccountable().add(a);
				return "Accountable aggiunto con successo";
			}
		}
		return "Impossibile aggiungere l'Accountable.";
	}
	
	public String operazioneFineMese() {
		for(Conto c: conti) {
			for(Accountable a: c.getAccountable()) {
				a.gestisciImporto(c);
			}
		}
		return "Operazioni di fine mese eseguite.";
	}
}
