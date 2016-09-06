package lang;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.runners.ParentRunner;

import lang.ast.LangParser;
import lang.ast.LangParser.SyntaxError;
import lang.ast.LangParser.Terminals;
import lang.ast.LangScanner;

public class RecursiveDescentCompiler extends RDPTemplate{
	public static void main(String args[]) {
		if (args.length != 1) {
			System.err.println("You must specify a source file on the command line!");
			System.exit(1);
		}

		try {
			RecursiveDescentCompiler comp = new RecursiveDescentCompiler();
			comp.parse(new LangScanner(new FileReader(args[0])));
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void parseProgram() {
			if(peek() == Terminals.EOF){
				error("No program");
			} else {
				stmt();
			}
	}
	
	private void stmt(){
		int a = peek();
		if(a == Terminals.FOR){
			forStmt();
		} else if(a == Terminals.IF){
			ifStmt();
		} else if(a == Terminals.ID){
			assign();
		} else {
			error("Not a valid statement");
		}
	}
	
	private void forStmt(){
		int a = peek();
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
	
	private void ifStmt(){
		accept(Terminals.IF);
		expr();
		accept(Terminals.THEN);
		stmt();
		accept(Terminals.FI);
		
	}
	private void assign(){
		accept(Terminals.ID);
		accept(Terminals.ASSIGN);
		expr();
	}
	private void expr(){
		int a = peek();
		if(a==Terminals.ID || a==Terminals.NUMERAL){
			accept();
		} else if(a == Terminals.NOT){
			expr();
		} else {
			error("Not valid expr: " + peek());
		}
	}
}
