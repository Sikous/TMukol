import java.util.*;

// TM
public class TMhl implements java.io.Serializable {

    // atributy
    private String startStav, soucasnyStav, soucasnySymbol, stav, zapisSymbol, presun;
    private int soucasnyBlok, startovaciBlok;
    private ArrayList<String> vstup, paskaAbecedy, vstupniAbeceda, stavecky;
    private HashMap<String, HashMap<String, HashMap<String, String>>> prechody;

    // metody
    public String getStartState() {
        return startStav;
    }

    public String getCurrentState() {
        return soucasnyStav;
    }

    public String getCurrentSymbol() {
        return soucasnySymbol;
    }

    public String getToState() {
        return stav;
    }

    public String getWriteSymbol() {
        return zapisSymbol;
    }

    public String getMoveTo() {
        return presun;
    }

    public int getCurrentCell() {
        return soucasnyBlok;
    }

    public int getStartCell() {
        return startovaciBlok;
    }

    public ArrayList<String> getInput() {
        return vstup;
    }

    public ArrayList<String> getTapeAlphabet() {
        return paskaAbecedy;
    }

    public ArrayList<String> getInputAlphabet() {
        return vstupniAbeceda;
    }

    public ArrayList<String> getStates() {
        return stavecky;
    }

    public HashMap<String, HashMap<String, HashMap<String, String>>> getTransitions() {
        return prechody;
    }

    public void setStartState(String start) {
        startStav = start;
    }

    public void setCurrentState(String current) {
        soucasnyStav = current;
    }

    public void setStartCell(int start) {
        startovaciBlok = start;
    }

    public void setCurrentCell(int current) {
        soucasnyBlok = current;
    }

    // konstruktor
    public TMhl() {
        vstup = new ArrayList<String>();
        paskaAbecedy = new ArrayList<String>();
        vstupniAbeceda = new ArrayList<String>();
        stavecky = new ArrayList<String>();
        prechody = new HashMap<String, HashMap<String, HashMap<String, String>>>();
        soucasnyStav = startStav;
        soucasnyBlok = 1;
        startovaciBlok = 1;
    }

    // presun
    public void processSymbol() {
        if ((!(soucasnyStav.equals("prijat"))) && (!(soucasnyStav.equals("odmitnut")))) {
            soucasnySymbol = (String) vstup.get(soucasnyBlok);
            stav = prechody.get(soucasnyStav).get(soucasnySymbol).get("prepni");
            zapisSymbol = prechody.get(soucasnyStav).get(soucasnySymbol).get("zapis");
            presun = prechody.get(soucasnyStav).get(soucasnySymbol).get("posun");
            soucasnyStav = stav;
            if ((soucasnyStav.equals("prijat")) || (soucasnyStav.equals("odmitnut"))) {
                // nic nerobi
            } else {
                vstup.set(soucasnyBlok, zapisSymbol);
                if (presun.equals("vlevo")) {
                    if (soucasnyBlok >= 0) {
                        soucasnyBlok = soucasnyBlok - 1;
                    }
                }
                if (presun.equals("vpravo")) {
                    if (soucasnyBlok < vstup.size()) {
                        soucasnyBlok = soucasnyBlok + 1;
                    }
                }
                if (presun.equals("neutral")) {
                    // stoji a kouka
                }
            }
        }
    }
}