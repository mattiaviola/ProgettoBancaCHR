package it.unipv.sfw.banca.accountable;
import it.unipv.sfw.banca.conti.Conto;

public class Domiciliazione implements Accountable {
	double importo;
	
	public Domiciliazione(double importo) {
		this.importo = importo;
	}
	
	@Override
	public String gestisciImporto(Conto c) {
		if(c.getSaldo() > this.importo) {
			c.setSaldo(c.getSaldo() - importo);
			return "Domiciliazione eseguita con successo!";
		}else {
			return "Saldo insufficiente! Impossibile eseguire la domiciliazione.";
		}
	}
}
