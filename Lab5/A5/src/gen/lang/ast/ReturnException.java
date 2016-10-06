package lang.ast;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Scanner;
/**
 * @ast class
 * @aspect Interp
 * @declaredat /h/d8/a/dat13mro/git/EDAN65/Lab5/A5/src/jastadd/Interp.jrag:7
 */
public class ReturnException extends Exception {
  
		private int returnValue;

  
		public ReturnException(int returnValue) {
			this.returnValue = returnValue;
		}

  
		public int getReturnValue() {
			return returnValue;
		}


}
