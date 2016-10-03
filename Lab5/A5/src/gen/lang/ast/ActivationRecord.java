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
/**
 * @ast class
 * @aspect ActivationRecord
 * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/ActivationRecord.jrag:7
 */
public class ActivationRecord extends java.lang.Object {
  
		private Map<String, Integer> map;

  
		public ActivationRecord() {
			map = new HashMap<String, Integer>();
		}

  

		public void put(String name, int value) {
			map.put(name, value);
		}

  

		public int get(String name) {;
			return map.get(name);
		}


}
