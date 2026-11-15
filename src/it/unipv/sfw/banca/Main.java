package it.unipv.sfw.banca;
import it.unipv.sfw.banca.accountable.*;
import it.unipv.sfw.banca.conti.*;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("--- 1. CREAZIONE BANCA E PERSONE ---");
        Banca miaBanca = new Banca("JavaBank", "IT");
        
        Persona p1 = new Persona("Mario", "Rossi", "RSSMRA80A01H501U");
        Persona p2 = new Persona("Giulia", "Bianchi", "BNCGLI90B41H501Z");

        System.out.println("\n--- 2. ATTIVAZIONE CONTI ---");
        
        System.out.println(miaBanca.attivaConto(p1, TipoConto.CONTO_CORRENTE));
        System.out.println(miaBanca.attivaConto(p1, TipoConto.CONTO_DEPOSITO));
        System.out.println(miaBanca.attivaConto(p2, TipoConto.CONTO_WEB));
        
        ContoCorrente cc = (ContoCorrente) miaBanca.getConto("IBAN1");
        ContoDeposito cd = (ContoDeposito) miaBanca.getConto("IBAN2");
        ContoWeb cw = (ContoWeb) miaBanca.getConto("IBAN3");

        System.out.println("\n--- 3. TEST CONTO CORRENTE ---");
        System.out.println(miaBanca.operazione(cc, 1000.0));
        System.out.println(miaBanca.operazione(cc, -200.0));
        System.out.println("Saldo CC atteso 800 -> Attuale: " + cc.getSaldo());

        System.out.println("\n--- 4. TEST CONTO DEPOSITO (Polimorfismo e vincoli) ---");
        System.out.println(miaBanca.operazione(cd, 500.0));
        
        System.out.println(miaBanca.operazione(cd, -100.0)); 
        System.out.println("Saldo CD atteso 500 -> Attuale: " + cd.getSaldo());

        System.out.println("\n--- 5. TEST CONTO WEB (Sicurezza) ---");
     
        System.out.println(cw.operazione(300.0)); 
        
        System.out.println(cw.cambiaPassword("nuovaPassword123"));
        cw.login("nuovaPassword123");
        System.out.println(miaBanca.operazione(cw, 1500.0));
        System.out.println("Saldo CW atteso 1500 -> Attuale: " + cw.getSaldo());

        System.out.println("\n--- 6. TEST ACCOUNTABLE E FINE MESE ---");
        Accountable stipendio = new Accredito(1500.0);
        Accountable bollettaLuce = new Domiciliazione(80.0);
        Accountable abbonamentoTv = new Domiciliazione(15.0);

        miaBanca.aggiungiAccountable(cc, stipendio);
        miaBanca.aggiungiAccountable(cc, bollettaLuce);
        miaBanca.aggiungiAccountable(cw, abbonamentoTv);

        System.out.println("Esecuzione operazioni di fine mese...");
        
        System.out.println(miaBanca.operazioneFineMese()); 

        System.out.println("Saldo post fine mese CC atteso 2220 -> Attuale: " + cc.getSaldo());
        System.out.println("Saldo post fine mese CW atteso 1485 -> Attuale: " + cw.getSaldo());

        System.out.println("\n--- 7. RESOCONTO FINALE BANCA ---");
        System.out.println("Totale liquidità in banca: " + miaBanca.totaleSaldi());
        
        System.out.println("\nElenco conti attivi:");
        for (Conto c : miaBanca.getConti()) {
            System.out.println(c.toString()); 
        }
    }
}