package it.unipv.sfw.banca.accountable;
import it.unipv.sfw.banca.conti.Conto;

public class Accredito implements Accountable {

	double importo;
	
	public Accredito(double importo) {
		this.importo = importo;
	}
	
	@Override
	public String gestisciImporto(Conto c) {
		c.setSaldo(c.getSaldo() + this.importo);
		return "Accredito eseguito con successo.";
	}

}
