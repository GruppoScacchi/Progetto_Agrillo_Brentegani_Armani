import org.junit.Assert;
import org.junit.Test;


public class ScacchieraTest {
	
	@Test
	public void testCheckPedina() {

		Scacchiera scacchiera = new Scacchiera();
		Assert.assertFalse(scacchiera.CheckPedina(scacchiera.PezziNeri.get(13), 2, 4) == true);
	}

	@Test
	public void testCheckMovePedone() {

		Scacchiera scacchiera = new Scacchiera();
		Assert.assertTrue(scacchiera.CheckMovePedone(scacchiera.PezziNeri.get(1), 2, 0) == true);
	}

	@Test
	public void testCheckMoveRe() {

		Scacchiera scacchiera = new Scacchiera();
		scacchiera.scacchiera[2][4]= scacchiera.scacchiera[1][4];
		scacchiera.scacchiera[1][4]= new Vuoto();
		Assert.assertTrue(scacchiera.CheckMoveRe(scacchiera.PezziNeri.get(0), 1, 4) == true);
	}

	@Test
	public void testCheckMoveAlfiere() {

		Scacchiera scacchiera = new Scacchiera();
		scacchiera.scacchiera[2][3]= scacchiera.scacchiera[1][3];
		scacchiera.scacchiera[1][3]= new Vuoto();
		Assert.assertTrue(scacchiera.CheckMoveAlfiere(scacchiera.PezziNeri.get(13), 3, 5) == true);	
	}

	@Test
	public void testCheckMoveCavallo() {

		Scacchiera scacchiera = new Scacchiera();
		Assert.assertTrue(scacchiera.CheckMoveCavallo(scacchiera.PezziNeri.get(11), 2, 2) == true);	
	}

	@Test
	public void testCheckMoveTorre() {

		Scacchiera scacchiera = new Scacchiera();
		scacchiera.scacchiera[2][0]= scacchiera.scacchiera[1][0];
		scacchiera.scacchiera[1][0]= new Vuoto();
		Assert.assertTrue(scacchiera.CheckMoveTorre(scacchiera.PezziNeri.get(9), 1, 0) == true);	
	}

	@Test
	public void testCheckMoveRegina() {

		Scacchiera scacchiera = new Scacchiera();
		scacchiera.scacchiera[2][4]= scacchiera.scacchiera[1][4];
		scacchiera.scacchiera[1][4]= new Vuoto();
		Assert.assertTrue(scacchiera.CheckMoveRegina(scacchiera.PezziNeri.get(15), 1, 4) == true);
	}


	@Test
	public void testScaccoMatto() {

		Scacchiera scacchiera = new Scacchiera();
		scacchiera.scacchiera[1][5]= scacchiera.scacchiera[7][3];
		Pedina p = scacchiera.PezziBianchi.get(15);
		p.setCoordinate(1, 5);
		scacchiera.PezziBianchi.set(15, p);
		scacchiera.scacchiera[7][3]= new Vuoto();
		
		scacchiera.scacchiera[4][2]= scacchiera.scacchiera[7][5];
		Pedina p2 = scacchiera.PezziBianchi.get(14);
		p2.setCoordinate(4, 2);
		scacchiera.PezziBianchi.set(14, p2);
		scacchiera.scacchiera[7][5]= new Vuoto();
		Assert.assertTrue(scacchiera.ScaccoMatto(scacchiera.scacchiera[1][5], scacchiera.PezziNeri.get(0)) == true);

	}

}
