/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.2 */
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
 * @ast node
 * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/lang.ast:13
 * @production Stmt : {@link ASTNode};

 */
public abstract class Stmt extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect Interp
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/Interp.jrag:77
   */
  public void eval(ActivationRecord actRec) throws ReturnException {
		throw new RuntimeException(getClass() + " Just dont implemented(STMT FALLBACK)!");
	}
  /**
   * @declaredat ASTNode:1
   */
  public Stmt() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:13
   */
  protected int numChildren() {
    return 0;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:17
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:21
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:25
   */
  public Stmt clone() throws CloneNotSupportedException {
    Stmt node = (Stmt) super.clone();
    return node;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:36
   */
  @Deprecated
  public abstract Stmt fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:44
   */
  public abstract Stmt treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:52
   */
  public abstract Stmt treeCopy();
/** @apilevel internal */
protected java.util.Set localLookup_String_visited;
  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/NameAnalysis.jrag:92
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab5/A5/src/jastadd/NameAnalysis.jrag:92")
  public IdDecl localLookup(String name) {
    Object _parameters = name;
    if (localLookup_String_visited == null) localLookup_String_visited = new java.util.HashSet(4);
    if (localLookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Stmt.localLookup(String).");
    }
    localLookup_String_visited.add(_parameters);
    IdDecl localLookup_String_value = unknownDecl();
    localLookup_String_visited.remove(_parameters);
    return localLookup_String_value;
  }
  /**
   * @attribute inh
   * @aspect callGraphAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/callGraphAnalysis.jrag:10
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="callGraphAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab5/A5/src/jastadd/callGraphAnalysis.jrag:10")
  public Func enclosingFunction() {
    if (enclosingFunction_visited) {
      throw new RuntimeException("Circular definition of attribute Stmt.enclosingFunction().");
    }
    enclosingFunction_visited = true;
    Func enclosingFunction_value = getParent().Define_enclosingFunction(this, null);
    enclosingFunction_visited = false;
    return enclosingFunction_value;
  }
/** @apilevel internal */
protected boolean enclosingFunction_visited = false;
}
