import java.util.*;
public class GrammarSolver {
	Map <String, String[]> grammars = new TreeMap<String, String[]>();
	
	GrammarSolver(List<String>grammar){
		if(grammar.size() == 0) {
			throw new IllegalArgumentException("grammar list is empty");
		}
		for(String i: grammar) {
			i.trim();
			String [] splitProduct = i.split("::=");
			String [] barSplit = splitProduct[1].split("[|]");
			grammars.put(splitProduct[0], barSplit);
		}
	}
	
	boolean grammarContains(String symbol) {
		
		return grammars.containsKey(symbol);
	}
	
	
	String[] generate(String symbol, int times) {
		
		if(times < 0 || !grammarContains(symbol)) {
			throw new IllegalArgumentException();
		}
		else {
			
			String [] master = new String[times];
			
			for(int i = 0; i < times; i++) {
				master[i] = test(symbol);
			}
			return master;
		}
		
	}
	
	private String test(String symbol) {
		
		Random num = new Random();
		String [] nonTermValues = grammars.get(symbol);
		if(nonTermValues == null) {
			return symbol + " ";
		}
		String [] splitTerminals;
		
		if(nonTermValues.length > 1) {
			splitTerminals = nonTermValues[num.nextInt((nonTermValues.length))].split("[ \t]+");
		}
		else {
			splitTerminals = nonTermValues[0].split("[ \t]+");
			
		
		}
		String gather = "";
		for(String i : splitTerminals) {
				 if(i.equals("")) {
					 continue;
				 }
				 else {
					 gather += test(i);
				 }
		}
		return gather;
		
		
	}
	String getSymbols() {
		String nonTerm = "";
		for(String i: grammars.keySet()) {
			
			nonTerm += i + ", ";
		}
		return "[" + nonTerm + "]";
	}
}
