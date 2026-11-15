package it.unipv.sfw.banca.conti;
import it.unipv.sfw.banca.*;

public class ContoCorrente extends Conto{
	public ContoCorrente(Persona p, String iban) {
		super(p, iban);
	}
	
	public boolean operazione(double importo) {
		if(importo > 0) {
			super.setSaldo(super.getSaldo() + importo);
			return true;
		}else if(importo < 0) {
			if(importo <= super.getSaldo()) {
				super.setSaldo(super.getSaldo() - importo);
				return true;
			}
		}
		return false;
	}
}
