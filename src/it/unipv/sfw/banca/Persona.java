package it.unipv.sfw.banca;

public class Persona {
	private String nome, cognome, codice_fiscale;
	
	public Persona(String nome, String cognome, String codice_fiscale) {
		this.nome = nome;
		this.cognome = cognome;
		this.codice_fiscale = codice_fiscale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}
}