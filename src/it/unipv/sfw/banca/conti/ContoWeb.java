package it.unipv.sfw.banca.conti;
import it.unipv.sfw.banca.*;

public class ContoWeb extends Conto{
	private String password;
	private boolean loggato, defaultPsw;
	
	public ContoWeb(Persona p, String iban) {
		super(p, iban);
		this.password = "changeme";
		this.defaultPsw = true;
		this.loggato = false;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggato() {
		return loggato;
	}

	public void setLoggato(boolean loggato) {
		this.loggato = loggato;
	}

	public boolean isDefaultPsw() {
		return defaultPsw;
	}

	public void setDefaultPsw(boolean defaultPsw) {
		this.defaultPsw = defaultPsw;
	}
	
	public boolean login(String psw) {
		if(this.password == psw) {
			this.loggato = true;
			return true;
		}else {
			return false;
		}
	}
	
	public String cambiaPassword(String psw) {
		setPassword(psw);
		return "Password cambiata con successo!";
	}
	
	public String operazione(double importo) {
		if(this.loggato == false) {
			return "Prima di fare operazioni devi fare il login!";
		}else {
			if(importo > 0) {
				super.setSaldo(super.getSaldo() + importo);
				return "Deposito effettuato con successo.";
			}else if(importo < 0) {
				if(importo <= super.getSaldo()) {
					super.setSaldo(super.getSaldo() - importo);
					return "Prelievo effettuato con successo.";
				}
			}
		}
		return "Impossibile completare l'operazione. Prova ad inserire un importo valido!";
	}
}
