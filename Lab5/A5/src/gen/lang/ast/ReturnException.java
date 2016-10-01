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
import java.util.HashSet;
/**
 * @ast class
 * @aspect Interp
 * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/Interp.jrag:4
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
