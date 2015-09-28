
import java.util.*;

import javax.swing.JOptionPane;

public class Scacchiera {

    public Pedina[][] scacchiera;
    public ArrayList<Pedina> PezziNeri;
    public ArrayList<Pedina> PezziBianchi;

    public Scacchiera() {

        PezziNeri = new ArrayList<>();
        PezziBianchi = new ArrayList<>();

        PezziNeri.add(new Re(0, 4, Colore.Nero, Pezzo.Re));
        PezziNeri.add(new Pedone(1, 0, Colore.Nero, Pezzo.Pedone));
        PezziNeri.add(new Pedone(1, 1, Colore.Nero, Pezzo.Pedone));
        PezziNeri.add(new Pedone(1, 2, Colore.Nero, Pezzo.Pedone));
        PezziNeri.add(new Pedone(1, 3, Colore.Nero, Pezzo.Pedone));
        PezziNeri.add(new Pedone(1, 4, Colore.Nero, Pezzo.Pedone));
        PezziNeri.add(new Pedone(1, 5, Colore.Nero, Pezzo.Pedone));
        PezziNeri.add(new Pedone(1, 6, Colore.Nero, Pezzo.Pedone));
        PezziNeri.add(new Pedone(1, 7, Colore.Nero, Pezzo.Pedone));
        PezziNeri.add(new Torre(0, 0, Colore.Nero, Pezzo.Torre));
        PezziNeri.add(new Torre(0, 7, Colore.Nero, Pezzo.Torre));
        PezziNeri.add(new Cavallo(0, 1, Colore.Nero, Pezzo.Cavallo));
        PezziNeri.add(new Cavallo(0, 6, Colore.Nero, Pezzo.Cavallo));
        PezziNeri.add(new Alfiere(0, 2, Colore.Nero, Pezzo.Alfiere));
        PezziNeri.add(new Alfiere(0, 5, Colore.Nero, Pezzo.Alfiere));
        PezziNeri.add(new Regina(0, 3, Colore.Nero, Pezzo.Regina));

        PezziBianchi.add(new Re(7, 4, Colore.Bianco, Pezzo.Re));
        PezziBianchi.add(new Pedone(6, 0, Colore.Bianco, Pezzo.Pedone));
        PezziBianchi.add(new Pedone(6, 1, Colore.Bianco, Pezzo.Pedone));
        PezziBianchi.add(new Pedone(6, 2, Colore.Bianco, Pezzo.Pedone));
        PezziBianchi.add(new Pedone(6, 3, Colore.Bianco, Pezzo.Pedone));
        PezziBianchi.add(new Pedone(6, 4, Colore.Bianco, Pezzo.Pedone));
        PezziBianchi.add(new Pedone(6, 5, Colore.Bianco, Pezzo.Pedone));
        PezziBianchi.add(new Pedone(6, 6, Colore.Bianco, Pezzo.Pedone));
        PezziBianchi.add(new Pedone(6, 7, Colore.Bianco, Pezzo.Pedone));
        PezziBianchi.add(new Torre(7, 0, Colore.Bianco, Pezzo.Torre));
        PezziBianchi.add(new Torre(7, 7, Colore.Bianco, Pezzo.Torre));
        PezziBianchi.add(new Cavallo(7, 1, Colore.Bianco, Pezzo.Cavallo));
        PezziBianchi.add(new Cavallo(7, 6, Colore.Bianco, Pezzo.Cavallo));
        PezziBianchi.add(new Alfiere(7, 2, Colore.Bianco, Pezzo.Alfiere));
        PezziBianchi.add(new Alfiere(7, 5, Colore.Bianco, Pezzo.Alfiere));
        PezziBianchi.add(new Regina(7, 3, Colore.Bianco, Pezzo.Regina));

        scacchiera = new Pedina[][]{{PezziNeri.get(9), PezziNeri.get(11), PezziNeri.get(13), PezziNeri.get(15), PezziNeri.get(0), PezziNeri.get(14), PezziNeri.get(12), PezziNeri.get(10)},
        {PezziNeri.get(1), PezziNeri.get(2), PezziNeri.get(3), PezziNeri.get(4), PezziNeri.get(5), PezziNeri.get(6), PezziNeri.get(7), PezziNeri.get(8)},
        {new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto()},
        {new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto()},
        {new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto()},
        {new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto(), new Vuoto()},
        {PezziBianchi.get(1), PezziBianchi.get(2), PezziBianchi.get(3), PezziBianchi.get(4), PezziBianchi.get(5), PezziBianchi.get(6), PezziBianchi.get(7), PezziBianchi.get(8)},
        {PezziBianchi.get(9), PezziBianchi.get(11), PezziBianchi.get(13), PezziBianchi.get(15), PezziBianchi.get(0), PezziBianchi.get(14), PezziBianchi.get(12), PezziBianchi.get(10)}};
    }

    public boolean CheckPedina(Pedina pedina, int newX, int newY) {

        switch (pedina.getType()) {

            case Pedone:
                return CheckMovePedone(pedina, newX, newY);
            case Re:
                return CheckMoveRe(pedina, newX, newY);
            case Alfiere:
                return CheckMoveAlfiere(pedina, newX, newY);
            case Cavallo:
                return CheckMoveCavallo(pedina, newX, newY);
            case Torre:
                return CheckMoveTorre(pedina, newX, newY);
            case Regina:
                return CheckMoveRegina(pedina, newX, newY);

            default:
                return false;

        }
    }

    public boolean CheckMovePedone(Pedina pedone, int newX, int newY) {

        if ((pedone.getColore() == Colore.Bianco && newX == pedone.getX() - 1)
                || (pedone.getColore() == Colore.Nero && newX == pedone.getX() + 1)) {
            return MovePedone(pedone, newX, newY);
        } else {
            return false;
        }
    }

    boolean cambio = true;
    public boolean MovePedone(Pedina pedone, int newX, int newY) {

        if ((pedone.getColore() == Colore.Bianco && (newY == pedone.getY() - 1 || newY == pedone.getY() + 1) && scacchiera[newX][newY].getColore() == Colore.Nero)
                || (pedone.getColore() == Colore.Nero && (newY == pedone.getY() - 1 || newY == pedone.getY() + 1) && scacchiera[newX][newY].getColore() == Colore.Bianco)) {
        	
        	if (cambio) {
	            if (newX == 0 || newX == 7) {
	                pedone.setTypePedina(ScegliNuovaPedina());
	            }
        	}
            return true;
        } else if ((pedone.getColore() == Colore.Bianco && newY == pedone.getY() && scacchiera[newX][newY].getType() == null)
                || (pedone.getColore() == Colore.Nero && newY == pedone.getY() && scacchiera[newX][newY].getType() == null)) {
			
        	if (cambio) {
	            if (newX == 0 || newX == 7) {
	                pedone.setTypePedina(ScegliNuovaPedina());
	            }
        	}
            return true;
        } else {
            return false;
        }
    }

    public boolean CheckMoveRe(Pedina re, int newX, int newY) {

        if ((newX == re.getX() || newX == re.getX() + 1 || newX == re.getX() - 1)
                && (newY == re.getY() || newY == re.getY() + 1 || newY == re.getY() - 1)) {
            return MoveRe(re, newX, newY);
        } else {
            return false;
        }
    }

    public boolean MoveRe(Pedina re, int newX, int newY) {

    	if (scacchiera[newX][newY].getType() == null) {
    		return true;
    	}
    	else if ((re.getColore() == Colore.Bianco && scacchiera[newX][newY].getColore() != Colore.Bianco)
                || (re.getColore() == Colore.Nero && scacchiera[newX][newY].getColore() != Colore.Nero)) //{
        
        {
            return true;
        }

        return false;
    }

    public boolean CheckMoveAlfiere(Pedina alfiere, int newX, int newY) {

        int x = alfiere.getX();
        int y = alfiere.getY();

        if (Math.abs(newX - x) == Math.abs(newY - y)) {
            return MoveAlfiere(alfiere, newX, newY);
        }
        return false;
    }

    public boolean MoveAlfiere(Pedina alfiere, int newX, int newY) {

        int x = alfiere.getX();
        int y = alfiere.getY();

        int stradaLibera = 0;
        int limite = newX - x;
        limite = Math.abs(limite);

        if ((alfiere.getColore() == Colore.Bianco && scacchiera[newX][newY].getColore() != Colore.Bianco)
                || (alfiere.getColore() == Colore.Nero && scacchiera[newX][newY].getColore() != Colore.Nero)) {
            if (newX > x && newY > y) {
                for (int n = 1; n < limite; n++) {
                    if (scacchiera[x + n][y + n].getType() == null) {
                        stradaLibera++;
                    }
                }
                if (stradaLibera == limite - 1) {
					
                    return true;
                }
            } else if (newX < x && newY < y) {
                for (int n = 1; n < limite; n++) {
                    if (scacchiera[x - n][y - n].getType() == null) {
                        stradaLibera++;
                    }
                }
                if (stradaLibera == limite - 1) {
					
                    return true;
                }
            } else if (newX > x && newY < y) {
                for (int n = 1; n < limite; n++) {
                    if (scacchiera[x + n][y - n].getType() == null) {
                        stradaLibera++;
                    }
                }
                if (stradaLibera == limite - 1) {
				
                    return true;
                }
            } else if (newX < x && newY > y) {
                for (int n = 1; n < limite; n++) {
                    if (scacchiera[x - n][y + n].getType() == null) {
                        stradaLibera++;
                    }
                }
                if (stradaLibera == limite - 1) {
					
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean CheckMoveCavallo(Pedina cavallo, int newX, int newY) {
        if ((((newX == cavallo.getX() + 1 || newX == cavallo.getX() - 1) && (newY == cavallo.getY() + 2 || newY == cavallo.getY() - 2))
                || ((newX == cavallo.getX() + 2 || newX == cavallo.getX() - 2) && (newY == cavallo.getY() + 1 || newY == cavallo.getY() - 1)))) {
            return MoveCavallo(cavallo, newX, newY);
        } else {
            return false;
        }
    }

    public boolean MoveCavallo(Pedina cavallo, int newX, int newY) {

        if ((cavallo.getColore() == Colore.Bianco && scacchiera[newX][newY].getColore() != Colore.Bianco)
                || (cavallo.getColore() == Colore.Nero && scacchiera[newX][newY].getColore() != Colore.Nero)) {
			
            return true;
        } else {
            return false;
        }
    }

    public boolean CheckMoveTorre(Pedina torre, int newX, int newY) {

        int x = torre.getX();
        int y = torre.getY();

        for (int n = 1; n <= 7; n++) {
            if ((newX == x && newY == y + n)
                    || (newX == x && newY == y - n)
                    || (newX == x + n && newY == y)
                    || (newX == x - n && newY == y)) {
                return MoveTorre(torre, newX, newY);
            }
        }
        return false;
    }

    public boolean MoveTorre(Pedina torre, int newX, int newY) {

        int x = torre.getX();
        int y = torre.getY();

        int stradaLibera = 0;
        int limiteX = newX - x;
        int limiteY = newY - y;
        limiteX = ValoreAssoluto(limiteX);
        limiteY = ValoreAssoluto(limiteY);

        if ((torre.getColore() == Colore.Bianco && scacchiera[newX][newY].getColore() != Colore.Bianco)
                || (torre.getColore() == Colore.Nero && scacchiera[newX][newY].getColore() != Colore.Nero)) {
            if (newX == x && newY > y) {
                for (int n = 1; n < limiteY; n++) {
                    if (scacchiera[x][y + n].getType() == null) {
                        stradaLibera++;
                    }
                }
                if (stradaLibera == limiteY - 1) {
					
                    return true;
                }
            } else if (newX == x && newY < y) {
                for (int n = 1; n < limiteY; n++) {
                    if (scacchiera[x][y - n].getType() == null) {
                        stradaLibera++;
                    }
                }
                if (stradaLibera == limiteY - 1) {
					
                    return true;
                }
            } else if (newX > x && newY == y) {
                for (int n = 1; n < limiteX; n++) {
                    if (scacchiera[x + n][y].getType() == null) {
                        stradaLibera++;
                    }
                }
                if (stradaLibera == limiteX - 1) {
					
                    return true;
                }
            } else if (newX < x && newY == y) {
                for (int n = 1; n < limiteX; n++) {
                    if (scacchiera[x - n][y].getType() == null) {
                        stradaLibera++;
                    }
                }
                if (stradaLibera == limiteX - 1) {
					
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;

    }

    public boolean CheckMoveRegina(Pedina regina, int newX, int newY) {

        int x = regina.getX();
        int y = regina.getY();

        for (int n = 1; n <= 7; n++) {
            if (((newX == x && newY == y + n)
                    || (newX == x && newY == y - n)
                    || (newX == x + n && newY == y)
                    || (newX == x - n && newY == y)) //controllo a 90°
                    || ((newX == x + n && newY == y + n)
                    || (newX == x - n && newY == y - n)
                    || (newX == x + n && newY == y - n)
                    || (newX == x - n && newY == y + n))) //controllo a 45°
            {
                return MoveRegina(regina, newX, newY);
            }
        }
        return false;

    }

    public boolean MoveRegina(Pedina regina, int newX, int newY) {

        int x = regina.getX();
        int y = regina.getY();

        int stradaLibera = 0;
        int limiteX = newX - x;
        int limiteY = newY - y;
        limiteX = ValoreAssoluto(limiteX);
        limiteY = ValoreAssoluto(limiteY);

        if ((regina.getColore() == Colore.Bianco && scacchiera[newX][newY].getColore() != Colore.Bianco)
                || (regina.getColore() == Colore.Nero && scacchiera[newX][newY].getColore() != Colore.Nero)) {
            if (newX == x && newY > y) {
                for (int n = 1; n < limiteY; n++) {
                    if (scacchiera[x][y + n].getType() == null) {
                        stradaLibera++;
                    }
                }
                if (stradaLibera == limiteY - 1) {
					
                    return true;
                }
            } else if (newX == x && newY < y) {
                for (int n = 1; n < limiteY; n++) {
                    if (scacchiera[x][y - n].getType() == null) {
                        stradaLibera++;
                    }
                }
                if (stradaLibera == limiteY - 1) {
					
                    return true;
                }
            } else if (newX > x && newY == y) {
                for (int n = 1; n < limiteX; n++) {
                    if (scacchiera[x + n][y].getType() == null) {
                        stradaLibera++;
                    }
                }
                if (stradaLibera == limiteX - 1) {
				
                    return true;
                }
            } else if (newX < x && newY == y) {
                for (int n = 1; n < limiteX; n++) {
                    if (scacchiera[x - n][y].getType() == null) {
                        stradaLibera++;
                    }
                }
                if (stradaLibera == limiteX - 1) {
					
                    return true;
                }
            } else if (newX > x && newY > y) {
                for (int n = 1; n < limiteX; n++) {
                    if (scacchiera[x + n][y + n].getType() == null) {
                        stradaLibera++;
                    }
                }
                if (stradaLibera == limiteX - 1) {
					
                    return true;
                }
            } else if (newX < x && newY < y) {
                for (int n = 1; n < limiteX; n++) {
                    if (scacchiera[x - n][y - n].getType() == null) {
                        stradaLibera++;
                    }
                }
                if (stradaLibera == limiteX - 1) {
					
                    return true;
                }
            } else if (newX > x && newY < y) {
                for (int n = 1; n < limiteX; n++) {
                    if (scacchiera[x + n][y - n].getType() == null) {
                        stradaLibera++;
                    }
                }
                if (stradaLibera == limiteX - 1) {
					
                    return true;
                }
            } else if (newX < x && newY > y) {
                for (int n = 1; n < limiteX; n++) {
                    if (scacchiera[x - n][y + n].getType() == null) {
                        stradaLibera++;
                    }
                }
                if (stradaLibera == limiteX - 1) {
					
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;

    }

    public int ValoreAssoluto(int valore) {

        return Math.abs(valore);
    }

    public void setVoid(int x, int y) {
        scacchiera[x][y] = new Vuoto();
    }
    
    public void setPosition(Pedina pezzo, int x, int y) {
        scacchiera[x][y] = pezzo;
    }

    public Pedina getPosition(int x, int y) {  
        return this.scacchiera[x][y];
    }

    public boolean ScaccoFatto(Pedina pedina, Pedina pedina2) {
    	cambio = false;
    	return CheckPedina(pedina, pedina2.getX(), pedina2.getY());
    }

    public boolean ScaccoSubito(Pedina re) {
    	cambio = false;
        if (re.getColore() == Colore.Bianco) {
            for (Pedina pedina : PezziNeri)
            {
                if (ScaccoFatto(pedina, re) == true) {
                    return true;
                }
            }
        } else if (re.getColore() == Colore.Nero) {
            for (Pedina pedina : PezziBianchi)
            {
                if (ScaccoFatto(pedina, re) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean ScaccoMatto(Pedina pedina, Pedina re) {
    	cambio = false;
        int scaccoCounter = -1;
        boolean ostacolo = false;
        
            for (int i = -1; i <= 1; i++) {
                for (int k = -1; k <= 1; k++) {
                    if ((re.getX() + i >= 0 && re.getX() + i <= 7) && (re.getY() + k >= 0 && re.getY() + k <= 7)) {
                    	if (CheckMoveRe((Re)re, re.getX() + i, re.getY() + k) == true) {
                    		Pedina reCopia = new Re(re.getX() + i, re.getY() + k, re.getColore(), Pezzo.Re);
                    		Pedina cancellato = scacchiera[reCopia.getX()][reCopia.getY()];
                    		scacchiera[reCopia.getX()][reCopia.getY()] = reCopia;
	                        if (ScaccoSubito(reCopia) == true) {
	                            scaccoCounter++;
	                        }
	                        scacchiera[reCopia.getX()][reCopia.getY()] = cancellato;
                    	}
                    	else {
                    		scaccoCounter++;
                    	}
                    } else scaccoCounter++;
                }
            }
        
        if (scaccoCounter == 8 && ScaccoSubito(re)) { 
            if (pedina.getColore() == Colore.Bianco) {
                    for (Pedina salvatore : PezziNeri)
                            if (salvatore.equals(pedina) && salvatore.getType() != Pezzo.Re && CheckPedina(salvatore, pedina.getX(), pedina.getY()))
                                    return false;
                    Caselle(pedina, re);
                    for (Coordinate casella : Caselle) {
                            for (Pedina salvatore : PezziNeri) {
                                    if(salvatore.equals(pedina) && salvatore.getType() != Pezzo.Re && CheckPedina(salvatore, casella.getX(), casella.getY()))
                                            return false;
                            }
                    }
            }
            else if (pedina.getColore() == Colore.Nero) {
                    for (Pedina salvatore : PezziBianchi)
                            if (salvatore.equals(pedina) && salvatore.getType() != Pezzo.Re && CheckPedina(salvatore, pedina.getX(), pedina.getY()))
                                    return false;
                    Caselle(pedina, re);
                    for (Coordinate casella : Caselle) {
                            for (Pedina salvatore : PezziBianchi) {
                                    if(salvatore.equals(pedina) && salvatore.getType() != Pezzo.Re && CheckPedina(salvatore, casella.getX(), casella.getY()))
                                            return false;
                            }
                    }
            }
            
            return true;
        } 
        return false;
    }

    public Pezzo ScegliNuovaPedina() {

        System.out.print("Inserisci il pezzo con cui sostituire il pedone (tutto in minuscolo): ");

    
        String pezzo = JOptionPane.showInputDialog(null, "Inserisci pezzo da inserire:");
        
        switch (pezzo) {
            case "pedone":
                return Pezzo.Pedone;
            case "regina":
                return Pezzo.Regina;
            case "alfiere":
                return Pezzo.Alfiere;
            case "torre":
                return Pezzo.Torre;
            case "cavallo":
                return Pezzo.Cavallo;
            default:
            	JOptionPane.showMessageDialog(null, "ERRORE_INSERIMENTO");
                return ScegliNuovaPedina();
        }
    }

   
    public Pedina Elimina(Pedina pedina, int newX, int newY) {

        if (pedina.getColore() == Colore.Bianco) {
            for (Pedina eliminato : PezziNeri) {
                if (eliminato.getX() == newX && eliminato.getY() == newY) {
                    PezziNeri.remove(eliminato);
                    return eliminato;
                }
            }
        } else if (pedina.getColore() == Colore.Nero) {
            for (Pedina eliminato : PezziBianchi) {
                if (eliminato.getX() == newX && eliminato.getY() == newY) {
                    PezziBianchi.remove(eliminato);
                    return eliminato;
                }
            }
        }
        return null;
    }
    
    public void Aggiungi(Pedina pedina) {
        if (pedina.getColore() == Colore.Bianco)
            PezziBianchi.add(pedina);
        else PezziNeri.add(pedina); 
    }
	
	public ArrayList<Coordinate> Caselle = new ArrayList<>();
	
	public void Caselle(Pedina pedina, Pedina re) {
		
		switch (pedina.getType()) {
			case Torre: {
				if (pedina.getX() == re.getX()) {
					if (pedina.getY() < re.getY()) {
						for (int i = pedina.getY() + 1; i < re.getY(); i++) {
							Coordinate coordinata = new Coordinate(pedina.getX(), i);
							Caselle.add(coordinata);
						}
					}
					else {
						for (int i = pedina.getY() - 1; i > re.getY(); i--) {
							Coordinate coordinata = new Coordinate(pedina.getX(), i);
							Caselle.add(coordinata);
						}						
					}
				}
				else {
					if (pedina.getX() < re.getX()) {
						for (int i = pedina.getX() + 1; i < re.getX(); i++) {
							Coordinate coordinata = new Coordinate(i, pedina.getY());
							Caselle.add(coordinata);
						}
					}
					else {
						for (int i = pedina.getX() - 1; i > re.getX(); i--) {
							Coordinate coordinata = new Coordinate(i, pedina.getY());
							Caselle.add(coordinata);
						}						
					}					
				}
			}
			case Alfiere: {
				if (pedina.getX() < re.getX() && pedina.getY() < re.getY()) {
					for (int i = pedina.getX() + 1; i < re.getX(); i++) {
						Coordinate coordinata = new Coordinate(i, i);
						Caselle.add(coordinata);
					}
				}
				else if (pedina.getX() > re.getX() && pedina.getY() > re.getY()) {
					for (int i = pedina.getX() - 1; i > re.getX(); i--) {
						Coordinate coordinata = new Coordinate(i, i);
						Caselle.add(coordinata);
					}					
				}
				else if (pedina.getX() < re.getX() && pedina.getY() > re.getY()) {
					for (int i = pedina.getX() + 1; i < re.getX(); i++) {
						Coordinate coordinate = new Coordinate(i, -i);
						Caselle.add(coordinate);
					}
				}
				else {
					for (int i = pedina.getX() - 1; i > re.getX(); i--) {
						Coordinate coordinate = new Coordinate(-i, i);
						Caselle.add(coordinate);
					}					
				}
			}
			case Regina: {
				if (pedina.getX() == re.getX()) {
					if (pedina.getY() < re.getY()) {
						for (int i = pedina.getY() + 1; i < re.getY(); i++) {
							Coordinate coordinata = new Coordinate(pedina.getX(), i);
							Caselle.add(coordinata);
						}
					}
					else {
						for (int i = pedina.getY() - 1; i > re.getY(); i--) {
							Coordinate coordinata = new Coordinate(pedina.getX(), i);
							Caselle.add(coordinata);
						}						
					}
				}
				else if (pedina.getY() == re.getY()) {
					if (pedina.getX() < re.getX()) {
						for (int i = pedina.getX() + 1; i < re.getX(); i++) {
							Coordinate coordinata = new Coordinate(i, pedina.getY());
							Caselle.add(coordinata);
						}
					}
					else {
						for (int i = pedina.getX() - 1; i > re.getX(); i--) {
							Coordinate coordinata = new Coordinate(i, pedina.getY());
							Caselle.add(coordinata);
						}						
					}					
				}
				else if (pedina.getX() < re.getX() && pedina.getY() < re.getY()) {
					for (int i = pedina.getX() + 1; i < re.getX(); i++) {
						Coordinate coordinata = new Coordinate(i, i);
						Caselle.add(coordinata);
					}
				}
				else if (pedina.getX() > re.getX() && pedina.getY() > re.getY()) {
					for (int i = pedina.getX() - 1; i > re.getX(); i--) {
						Coordinate coordinata = new Coordinate(i, i);
						Caselle.add(coordinata);
					}					
				}
				else if (pedina.getX() < re.getX() && pedina.getY() > re.getY()) {
					for (int i = pedina.getX() + 1; i < re.getX(); i++) {
						Coordinate coordinate = new Coordinate(i, -i);
						Caselle.add(coordinate);
					}
				}
				else {
					for (int i = pedina.getX() - 1; i > re.getX(); i--) {
						Coordinate coordinate = new Coordinate(-i, i);
						Caselle.add(coordinate);
					}					
				}				
			}
		}
	}

}