package myParser;
import java.io.FileNotFoundException;
import java.io.FileReader;

import lang.ast.LangParser.Terminals;
import lang.ast.LangScanner;

public class RecursiveDescentCompiler extends RDPTemplate {
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Wrong usage should specify source file");
			System.exit(1);
		}
		try {
			RecursiveDescentCompiler rdc = new RecursiveDescentCompiler();
			LangScanner scanner = new LangScanner(new FileReader(args[0]));
			rdc.parse(scanner);
		} catch (FileNotFoundException e) {
			System.out.println("Source file not found");
			System.exit(1);
		}
	}

	@Override
	public void parseProgram() {
		if(peek() != Terminals.EOF) {
			stmt();
		} else {
			error("Empty program");
		}
	}
	
	private void stmt() {
		switch(peek()) {
			case Terminals.FOR: 
				forStmt();
			break;
			case Terminals.IF:
				ifStmt();
			break;
			case Terminals.ID:
				assignment();
			break;
			default:
				error("Expected stmt got: " + peek());
			break;
		}
	}
	
	private void forStmt() {
		accept(Terminals.FOR); 
		accept(Terminals.ID);
		accept(Terminals.ASSIGN);
		expr();
		accept(Terminals.UNTIL);
		expr();
		accept(Terminals.DO);
		stmt();
		accept(Terminals.OD);
	}
	
	private void ifStmt() {
		accept(Terminals.IF);
		expr();
		accept(Terminals.THEN);
		stmt();
		accept(Terminals.FI);
	}
	
	private void assignment() {
		accept(Terminals.ID);
		accept(Terminals.ASSIGN);
		expr();
	}
	
	private void expr() {
		switch(peek()) {
			case Terminals.ID: 
				accept(Terminals.ID);
			break;
			case Terminals.NUMERAL:
				accept(Terminals.NUMERAL);
			break;
			case Terminals.NOT:
				accept(Terminals.NOT);
				expr();
			break;
			default:
				error("Expected expr got: " + peek());
			break;
		}
	}
}
