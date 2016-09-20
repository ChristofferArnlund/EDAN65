/* This file was generated with JastAdd2 (http://jastadd.org) version 2.2.2 */
package lang.ast;
import java.io.PrintStream;
/**
 * @ast node
 * @declaredat /Users/juliusbarendt/Desktop/A/A3-MinTree/src/jastadd/Lang.ast:3
 * @production Node : {@link ASTNode};

 */
public abstract class Node extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public Node() {
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
  public Node clone() throws CloneNotSupportedException {
    Node node = (Node) super.clone();
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
  public abstract Node fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:44
   */
  public abstract Node treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:52
   */
  public abstract Node treeCopy();
/** @apilevel internal */
protected boolean localMin_visited = false;
  /**
   * @attribute syn
   * @aspect MinValue
   * @declaredat /Users/juliusbarendt/Desktop/A/A3-MinTree/src/jastadd/MinValue.jrag:3
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MinValue", declaredAt="/Users/juliusbarendt/Desktop/A/A3-MinTree/src/jastadd/MinValue.jrag:3")
  public int localMin() {
    if (localMin_visited) {
      throw new RuntimeException("Circular definition of attribute Node.localMin().");
    }
    localMin_visited = true;
    int localMin_value = 0;
    localMin_visited = false;
    return localMin_value;
  }
/** @apilevel internal */
protected boolean nbrOfMinValues_visited = false;
  /**
   * @attribute syn
   * @aspect MinValue
   * @declaredat /Users/juliusbarendt/Desktop/A/A3-MinTree/src/jastadd/MinValue.jrag:24
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MinValue", declaredAt="/Users/juliusbarendt/Desktop/A/A3-MinTree/src/jastadd/MinValue.jrag:24")
  public int nbrOfMinValues() {
    if (nbrOfMinValues_visited) {
      throw new RuntimeException("Circular definition of attribute Node.nbrOfMinValues().");
    }
    nbrOfMinValues_visited = true;
    int nbrOfMinValues_value = 0;
    nbrOfMinValues_visited = false;
    return nbrOfMinValues_value;
  }
  /**
   * @attribute inh
   * @aspect MinValue
   * @declaredat /Users/juliusbarendt/Desktop/A/A3-MinTree/src/jastadd/MinValue.jrag:14
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="MinValue", declaredAt="/Users/juliusbarendt/Desktop/A/A3-MinTree/src/jastadd/MinValue.jrag:14")
  public int globalMin() {
    if (globalMin_visited) {
      throw new RuntimeException("Circular definition of attribute Node.globalMin().");
    }
    globalMin_visited = true;
    int globalMin_value = getParent().Define_globalMin(this, null);
    globalMin_visited = false;
    return globalMin_value;
  }
/** @apilevel internal */
protected boolean globalMin_visited = false;
}
