package it.unipv.sfw.banca.conti;
import it.unipv.sfw.banca.*;

public class ContoDeposito extends Conto{
	public ContoDeposito(Persona p, String iban) {
		super(p, iban);
	}
	
	public boolean operazione(double importo) {
		if(importo <= 0) {
			return false;
		}else { 
			super.setSaldo(super.getSaldo() + importo);
			return true;
		}
	}
}
