/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.2 */
package lang.ast;
import java.io.PrintStream;
/**
 * @ast node
 * @declaredat /home/marcus/Lab3/Lab3/A3-MinTree/src/jastadd/Lang.ast:4
 * @production Pair : {@link Node} ::= <span class="component">Left:{@link Node}</span> <span class="component">Right:{@link Node}</span>;

 */
public class Pair extends Node implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/marcus/Lab3/Lab3/A3-MinTree/src/jastadd/PrettyPrint.jadd:21
   */
  public void prettyPrint(PrintStream out, String ind) {
		out.print(ind);
		out.println("Pair");
		getLeft().prettyPrint(out, ind + INDENTATION);
		getRight().prettyPrint(out, ind + INDENTATION);
	}
  /**
   * @declaredat ASTNode:1
   */
  public Pair() {
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
    children = new ASTNode[2];
  }
  /**
   * @declaredat ASTNode:13
   */
  public Pair(Node p0, Node p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:18
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:22
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:26
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:30
   */
  public Pair clone() throws CloneNotSupportedException {
    Pair node = (Pair) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:35
   */
  public Pair copy() {
    try {
      Pair node = (Pair) clone();
      node.parent = null;
      if (children != null) {
        node.children = (ASTNode[]) children.clone();
      }
      return node;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " + getClass().getName());
    }
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:54
   */
  @Deprecated
  public Pair fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:64
   */
  public Pair treeCopyNoTransform() {
    Pair tree = (Pair) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) children[i];
        if (child != null) {
          child = child.treeCopyNoTransform();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:84
   */
  public Pair treeCopy() {
    Pair tree = (Pair) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) getChild(i);
        if (child != null) {
          child = child.treeCopy();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:98
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Left child.
   * @param node The new node to replace the Left child.
   * @apilevel high-level
   */
  public void setLeft(Node node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Left child.
   * @return The current node used as the Left child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Left")
  public Node getLeft() {
    return (Node) getChild(0);
  }
  /**
   * Retrieves the Left child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Left child.
   * @apilevel low-level
   */
  public Node getLeftNoTransform() {
    return (Node) getChildNoTransform(0);
  }
  /**
   * Replaces the Right child.
   * @param node The new node to replace the Right child.
   * @apilevel high-level
   */
  public void setRight(Node node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Right child.
   * @return The current node used as the Right child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Right")
  public Node getRight() {
    return (Node) getChild(1);
  }
  /**
   * Retrieves the Right child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Right child.
   * @apilevel low-level
   */
  public Node getRightNoTransform() {
    return (Node) getChildNoTransform(1);
  }
/** @apilevel internal */
protected boolean localMin_visited = false;
  /**
   * @attribute syn
   * @aspect MinValue
   * @declaredat /home/marcus/Lab3/Lab3/A3-MinTree/src/jastadd/MinValue.jrag:4
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MinValue", declaredAt="/home/marcus/Lab3/Lab3/A3-MinTree/src/jastadd/MinValue.jrag:4")
  public int localMin() {
    if (localMin_visited) {
      throw new RuntimeException("Circular definition of attribute Node.localMin().");
    }
    localMin_visited = true;
    try {
    		int leftLM = getLeft().localMin();
    		int rightLM = getRight().localMin();
    		return leftLM < rightLM ? leftLM : rightLM;
    	}
    finally {
      localMin_visited = false;
    }
  }
/** @apilevel internal */
protected boolean nbrOfMinValues_visited = false;
  /**
   * @attribute syn
   * @aspect MinValue
   * @declaredat /home/marcus/Lab3/Lab3/A3-MinTree/src/jastadd/MinValue.jrag:25
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MinValue", declaredAt="/home/marcus/Lab3/Lab3/A3-MinTree/src/jastadd/MinValue.jrag:25")
  public int nbrOfMinValues() {
    if (nbrOfMinValues_visited) {
      throw new RuntimeException("Circular definition of attribute Node.nbrOfMinValues().");
    }
    nbrOfMinValues_visited = true;
    int nbrOfMinValues_value = getLeft().nbrOfMinValues() + getRight().nbrOfMinValues();
    nbrOfMinValues_visited = false;
    return nbrOfMinValues_value;
  }
}
