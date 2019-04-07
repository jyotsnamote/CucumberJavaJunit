package Question5;
import junit.framework.TestCase;


/**
 * 
 */

/**
 * @author Jyotsna
 *
 */


public class CreditCardTest extends TestCase {

	private String card1;

	public CreditCardTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		card1 = "1234567812345670";
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		card1 = "";
	}

	public void testValidateCard() {

		boolean result = CardValidator.validateCard(card1);
		 assertTrue(result);
	}

}
