package it.unipv.sfw.banca.conti;
import it.unipv.sfw.banca.*;

public class ContoDeposito extends Conto{
	public ContoDeposito(Persona p, String iban) {
		super(p, iban);
	}
	
	public String operazione(double importo) {
		if(importo <= 0) {
			return "Impossibile prelevare da un conto deposito. Inserisci un importo valido!";
		}else { 
			super.setSaldo(super.getSaldo() + importo);
			return "Deposito effettuato con successo.";
		}
	}
}
