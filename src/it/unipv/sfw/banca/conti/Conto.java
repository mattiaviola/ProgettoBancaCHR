package it.unipv.sfw.banca.conti;
import java.util.ArrayList;

import it.unipv.sfw.banca.Persona;
import it.unipv.sfw.banca.accountable.Accountable;

public abstract class Conto {
	private Persona intestatario;
	private String iban;
	private double saldo;
	private ArrayList<Accountable> accountable;
	
	public Conto(Persona p, String iban) {
		this.intestatario = p;
		this.iban = iban;
		this.saldo = 0;
		this.accountable = new ArrayList<Accountable>();
	}
	
	@Override
	public String toString() {
		return "Conto di: " + this.intestatario + " - IBAN: " + this.iban + " - Saldo: " + this.saldo;
	}

	public Persona getIntestatario() {
		return intestatario;
	}

	public void setIntestatario(Persona intestatario) {
		this.intestatario = intestatario;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public ArrayList<Accountable> getAccountable() {
		return accountable;
	}

	public void setAccountable(ArrayList<Accountable> accountable) {
		this.accountable = accountable;
	}
	
	public abstract boolean operazione(double importo);
}
