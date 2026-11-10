package it.unipv.sfw.banca;

public abstract class Conto {
	private Persona intestatario;
	private String iban;
	private double saldo;
	
	public abstract Persona getIntestatario();
	public abstract String getIban();
	public abstract double getSaldo();
	public abstract void setIntestatario(Persona p);
	public abstract void setIban(String i);
	public abstract void setSaldo(double s);
	
	public abstract boolean preleva(double importo);
	public abstract boolean deposita(double importo);
}
