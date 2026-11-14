package it.unipv.sfw.banca.conti;
import it.unipv.sfw.banca.*;

public class ContoCorrente extends Conto{
	public ContoCorrente(Persona p, String iban) {
		super(p, iban);
	}
	
	public String operazione(double importo) {
		if(importo > 0) {
			super.setSaldo(super.getSaldo() + importo);
			return "Deposito effettuato con successo.";
		}else if(importo < 0) {
			if(importo <= super.getSaldo()) {
				super.setSaldo(super.getSaldo() - importo);
				return "Prelievo effettuato con successo.";
			}
		}
		return "Impossibile completare l'operazione. Prova ad inserire un importo valido!";
	}
}
