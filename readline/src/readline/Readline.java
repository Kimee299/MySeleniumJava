/**
 * 
 */
package readline;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * @author DELL
 *
 */
public class Readline {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        list.add(a);
        System.out.println(list);
        

	}

}
