package lang.ast;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.HashSet;
/**
 * @ast class
 * @aspect NameAnalysis
 * @declaredat /home/marcus/git/EDAN65/Lab3/A3/src/jastadd/NameAnalysis.jrag:5
 */
public class SymbolTable extends java.lang.Object {
  
		private static final SymbolTable BOTTOM = new SymbolTable() {
			@Override
			public boolean declare(String name) {
				throw new UnsupportedOperationException("Cant add name to bottom of stack");
			}
		
			@Override
			public boolean lookup(String name) {
				return false;
			}
		};

  

		private final SymbolTable tail;

  
		private final Set<String> names = new HashSet<String>();

  
		
		public SymbolTable() {
			tail = BOTTOM;
		}

  

		public SymbolTable(SymbolTable tail) {
			this.tail = tail;
		}

  

		public boolean declare(String name) {
			return names.add(name);
		}

  
	
		public boolean lookup(String name) {
			return names.contains(name) || tail.lookup(name);
		}

  

		public SymbolTable push() {
			return new SymbolTable(this);
		}


}
