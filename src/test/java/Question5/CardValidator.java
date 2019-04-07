package Question5;
/**
 * 
 */

/**
 * @author Jyotsna
 *
 */


public class CardValidator {
	
	public static boolean validateCard(String str) {
		 boolean alter = false;
		 int data = str.length();
		  int total = 0,value;
		  while(data-- > 0) {
		    value = Integer.parseInt(str.substring(data, data + 1));
		    if (alter) {
		      value *= 2;
		      if (value > 9) value -= 9;
		    }
		    total += value;
		    alter = !alter; 
		  }
		  return (total % 10) == 0;
		}
}