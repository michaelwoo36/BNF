import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class GrammarMain {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to random sentence generator");
		System.out.println("what is the name of the grammar file");
		File grammarTxt = new File(input.next());
		Scanner inputTxt = new Scanner(grammarTxt);
		List <String> list = new ArrayList<String>();
		while(inputTxt.hasNextLine()) {
			list.add(inputTxt.nextLine());
		}
		GrammarSolver object = new GrammarSolver(list);
		System.out.println("available symbols to generate are:");
		System.out.println(object.getSymbols());
		System.out.println("Which symbol do you want to generate, press return to quit");
		//input.nextLine();
		String symbolAnswer = input.next();
		System.out.println("How many times?");
		int numAnswer = input.nextInt();
		//input.nextLine();
		String []master = object.generate(symbolAnswer, numAnswer);
		for(String i : master) {
			System.out.println(i);
		}
	}

}
//pn, adj, iv