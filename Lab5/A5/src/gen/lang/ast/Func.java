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
 * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/lang.ast:2
 * @production Func : {@link ASTNode} ::= <span class="component">FuncName:{@link IdDecl}</span> <span class="component">FuncParams:{@link FuncParam}*</span> <span class="component">{@link StmtBlock}</span>;

 */
public class Func extends ASTNode<ASTNode> implements Cloneable, Comparable<Func> {
  /**
   * @aspect FuncComparable
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/FuncComparable.jrag:3
   */
  
		public int compareTo(Func otherFunc) {
			return getFuncName().getID().compareTo(otherFunc.getFuncName().getID());
		}
  /**
   * @aspect Interp
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/Interp.jrag:36
   */
  public int eval(ActivationRecord actRec) {
		if(getFuncName().getID().equals("print"))
			System.out.println(actRec.get("output"));
		try{
			getStmtBlock().eval(actRec);
		} catch (ReturnException e) {
			return e.getReturnValue(); //return the returnvalue
		}
		return 0; //return default 0
	}
  /**
   * @declaredat ASTNode:1
   */
  public Func() {
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
    children = new ASTNode[3];
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  public Func(IdDecl p0, List<FuncParam> p1, StmtBlock p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:20
   */
  protected int numChildren() {
    return 3;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:24
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    reachable_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:29
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Func_functionCalls_visited = false;
    Func_functionCalls_computed = false;
    
    Func_functionCalls_value = null;
    contributorMap_Func_functionCalls = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public Func clone() throws CloneNotSupportedException {
    Func node = (Func) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public Func copy() {
    try {
      Func node = (Func) clone();
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
   * @declaredat ASTNode:62
   */
  @Deprecated
  public Func fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public Func treeCopyNoTransform() {
    Func tree = (Func) copy();
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
   * @declaredat ASTNode:92
   */
  public Func treeCopy() {
    Func tree = (Func) copy();
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
   * @declaredat ASTNode:106
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the FuncName child.
   * @param node The new node to replace the FuncName child.
   * @apilevel high-level
   */
  public void setFuncName(IdDecl node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the FuncName child.
   * @return The current node used as the FuncName child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="FuncName")
  public IdDecl getFuncName() {
    return (IdDecl) getChild(0);
  }
  /**
   * Retrieves the FuncName child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the FuncName child.
   * @apilevel low-level
   */
  public IdDecl getFuncNameNoTransform() {
    return (IdDecl) getChildNoTransform(0);
  }
  /**
   * Replaces the FuncParams list.
   * @param list The new list node to be used as the FuncParams list.
   * @apilevel high-level
   */
  public void setFuncParamsList(List<FuncParam> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the FuncParams list.
   * @return Number of children in the FuncParams list.
   * @apilevel high-level
   */
  public int getNumFuncParams() {
    return getFuncParamsList().getNumChild();
  }
  /**
   * Retrieves the number of children in the FuncParams list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the FuncParams list.
   * @apilevel low-level
   */
  public int getNumFuncParamsNoTransform() {
    return getFuncParamsListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the FuncParams list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the FuncParams list.
   * @apilevel high-level
   */
  public FuncParam getFuncParams(int i) {
    return (FuncParam) getFuncParamsList().getChild(i);
  }
  /**
   * Check whether the FuncParams list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasFuncParams() {
    return getFuncParamsList().getNumChild() != 0;
  }
  /**
   * Append an element to the FuncParams list.
   * @param node The element to append to the FuncParams list.
   * @apilevel high-level
   */
  public void addFuncParams(FuncParam node) {
    List<FuncParam> list = (parent == null) ? getFuncParamsListNoTransform() : getFuncParamsList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addFuncParamsNoTransform(FuncParam node) {
    List<FuncParam> list = getFuncParamsListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the FuncParams list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setFuncParams(FuncParam node, int i) {
    List<FuncParam> list = getFuncParamsList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the FuncParams list.
   * @return The node representing the FuncParams list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="FuncParams")
  public List<FuncParam> getFuncParamsList() {
    List<FuncParam> list = (List<FuncParam>) getChild(1);
    return list;
  }
  /**
   * Retrieves the FuncParams list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the FuncParams list.
   * @apilevel low-level
   */
  public List<FuncParam> getFuncParamsListNoTransform() {
    return (List<FuncParam>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the FuncParams list without
   * triggering rewrites.
   */
  public FuncParam getFuncParamsNoTransform(int i) {
    return (FuncParam) getFuncParamsListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the FuncParams list.
   * @return The node representing the FuncParams list.
   * @apilevel high-level
   */
  public List<FuncParam> getFuncParamss() {
    return getFuncParamsList();
  }
  /**
   * Retrieves the FuncParams list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the FuncParams list.
   * @apilevel low-level
   */
  public List<FuncParam> getFuncParamssNoTransform() {
    return getFuncParamsListNoTransform();
  }
  /**
   * Replaces the StmtBlock child.
   * @param node The new node to replace the StmtBlock child.
   * @apilevel high-level
   */
  public void setStmtBlock(StmtBlock node) {
    setChild(node, 2);
  }
  /**
   * Retrieves the StmtBlock child.
   * @return The current node used as the StmtBlock child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="StmtBlock")
  public StmtBlock getStmtBlock() {
    return (StmtBlock) getChild(2);
  }
  /**
   * Retrieves the StmtBlock child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the StmtBlock child.
   * @apilevel low-level
   */
  public StmtBlock getStmtBlockNoTransform() {
    return (StmtBlock) getChildNoTransform(2);
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/callGraphAnalysis.jrag:5
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_Func_functionCalls = null;

  protected void survey_Func_functionCalls() {
    if (contributorMap_Func_functionCalls == null) {
      contributorMap_Func_functionCalls = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_Func_functionCalls(this, contributorMap_Func_functionCalls);
    }
  }

/** @apilevel internal */
protected ASTNode$State.Cycle reachable_cycle = null;
  /** @apilevel internal */
  private void reachable_reset() {
    reachable_computed = false;
    reachable_initialized = false;
    reachable_value = null;
    reachable_cycle = null;
  }
  /** @apilevel internal */
  protected boolean reachable_computed = false;

  /** @apilevel internal */
  protected Set<Func> reachable_value;
  /** @apilevel internal */
  protected boolean reachable_initialized = false;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="Reachability", declaredAt="/home/marcus/git/EDAN65/Lab5/A5/src/jastadd/Reachability.jrag:4")
  public Set<Func> reachable() {
    if (reachable_computed) {
      return reachable_value;
    }
    ASTNode$State state = state();
    if (!reachable_initialized) {
      reachable_initialized = true;
      reachable_value = new TreeSet<Func>();
    }
    if (!state.inCircle() || state.calledByLazyAttribute()) {
      state.enterCircle();
      do {
        reachable_cycle = state.nextCycle();
        Set<Func> new_reachable_value = reachable_compute();
        if ((new_reachable_value == null && reachable_value != null) || (new_reachable_value != null && !new_reachable_value.equals(reachable_value))) {
          state.setChangeInCycle();
        }
        reachable_value = new_reachable_value;
      } while (state.testAndClearChangeInCycle());
      reachable_computed = true;
      state.startLastCycle();
      Set<Func> $tmp = reachable_compute();

      state.leaveCircle();
    } else if (reachable_cycle != state.cycle()) {
      reachable_cycle = state.cycle();
      if (state.lastCycle()) {
        reachable_computed = true;
        Set<Func> new_reachable_value = reachable_compute();
        return new_reachable_value;
      }
      Set<Func> new_reachable_value = reachable_compute();
      if ((new_reachable_value == null && reachable_value != null) || (new_reachable_value != null && !new_reachable_value.equals(reachable_value))) {
        state.setChangeInCycle();
      }
      reachable_value = new_reachable_value;
    } else {
    }
    return reachable_value;
  }
  /** @apilevel internal */
  private Set<Func> reachable_compute() {
  		Set<Func> reachable = new TreeSet<Func>();
  		for(Func func : functionCalls()) {
  			reachable.add(func);
  			reachable.addAll(func.reachable());
  		}
  		return reachable;
  	}
/** @apilevel internal */
protected boolean isUnknownFunc_visited = false;
  /**
   * @attribute syn
   * @aspect UnknownFunc
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/UnknownFunc.jrag:9
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UnknownFunc", declaredAt="/home/marcus/git/EDAN65/Lab5/A5/src/jastadd/UnknownFunc.jrag:9")
  public boolean isUnknownFunc() {
    if (isUnknownFunc_visited) {
      throw new RuntimeException("Circular definition of attribute Func.isUnknownFunc().");
    }
    isUnknownFunc_visited = true;
    boolean isUnknownFunc_value = false;
    isUnknownFunc_visited = false;
    return isUnknownFunc_value;
  }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/NameAnalysis.jrag:64
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab5/A5/src/jastadd/NameAnalysis.jrag:64")
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Func.lookup(String).");
    }
    lookup_String_visited.add(_parameters);
    IdDecl lookup_String_value = getParent().Define_lookup(this, null, name);
    lookup_String_visited.remove(_parameters);
    return lookup_String_value;
  }
/** @apilevel internal */
protected java.util.Set lookup_String_visited;
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/CircularDefinitions.jrag:9
   * @apilevel internal
   */
  public boolean Define_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  protected boolean canDefine_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/IdUseTypeAnalysis.jrag:3
   * @apilevel internal
   */
  public boolean Define_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getFuncNameNoTransform()) {
      // @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/IdUseTypeAnalysis.jrag:5
      return true;
    }
    else {
      return getParent().Define_isFunction(this, _callerNode);
    }
  }
  protected boolean canDefine_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/IdUseTypeAnalysis.jrag:4
   * @apilevel internal
   */
  public boolean Define_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getFuncNameNoTransform()) {
      // @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/IdUseTypeAnalysis.jrag:6
      return false;
    }
    else {
      return getParent().Define_isVariable(this, _callerNode);
    }
  }
  protected boolean canDefine_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/NameAnalysis.jrag:19
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getFuncNameNoTransform()) {
      // @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/NameAnalysis.jrag:61
      return lookup(name);
    }
    else {
      int childIndex = this.getIndexOfChild(_callerNode);
      {
      		for(int i = 0; i < getNumFuncParams(); i++) {
      			IdDecl decl = getFuncParams(i).getIdDecl();
      			if(decl.getID().equals(name))
      				return decl;
      		}
      		return lookup(name);
      	}
    }
  }
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/ParamChecker.jrag:3
   * @apilevel internal
   */
  public Func Define_function(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getFuncNameNoTransform()) {
      // @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/ParamChecker.jrag:9
      return this;
    }
    else {
      return getParent().Define_function(this, _callerNode);
    }
  }
  protected boolean canDefine_function(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/callGraphAnalysis.jrag:11
   * @apilevel internal
   */
  public Func Define_enclosingFunction(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getStmtBlockNoTransform()) {
      // @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/callGraphAnalysis.jrag:14
      return this;
    }
    else {
      return getParent().Define_enclosingFunction(this, _callerNode);
    }
  }
  protected boolean canDefine_enclosingFunction(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/uniqueIdDeclName.jrag:6
   * @apilevel internal
   */
  public String Define_uniqueNamePrefix(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    {
    		return "";	
    	}
  }
  protected boolean canDefine_uniqueNamePrefix(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
/** @apilevel internal */
protected boolean Func_functionCalls_visited = false;
  /**
   * @attribute coll
   * @aspect callGraphAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/callGraphAnalysis.jrag:5
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="callGraphAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab5/A5/src/jastadd/callGraphAnalysis.jrag:5")
  public Set<Func> functionCalls() {
    ASTNode$State state = state();
    if (Func_functionCalls_computed) {
      return Func_functionCalls_value;
    }
    if (Func_functionCalls_visited) {
      throw new RuntimeException("Circular definition of attribute Func.functionCalls().");
    }
    Func_functionCalls_visited = true;
    state().enterLazyAttribute();
    Func_functionCalls_value = functionCalls_compute();
    Func_functionCalls_computed = true;
    state().leaveLazyAttribute();
    Func_functionCalls_visited = false;
    return Func_functionCalls_value;
  }
  /** @apilevel internal */
  private Set<Func> functionCalls_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof Func)) {
      node = node.getParent();
    }
    Func root = (Func) node;
    root.survey_Func_functionCalls();
    Set<Func> _computedValue = new TreeSet<Func>();
    if (root.contributorMap_Func_functionCalls.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_Func_functionCalls.get(this)) {
        contributor.contributeTo_Func_functionCalls(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean Func_functionCalls_computed = false;

  /** @apilevel internal */
  protected Set<Func> Func_functionCalls_value;

  protected void collect_contributors_Program_deadFuncs(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/marcus/git/EDAN65/Lab5/A5/src/jastadd/deadFuncs.jrag:11
    if (!program().mainFuncReachable().contains(this) && !this.getFuncName().getID().equals("main")) {
      {
        Program target = (Program) (program());
        java.util.Set<ASTNode> contributors = _map.get(target);
        if (contributors == null) {
          contributors = new java.util.LinkedHashSet<ASTNode>();
          _map.put((ASTNode) target, contributors);
        }
        contributors.add(this);
      }
    }
    super.collect_contributors_Program_deadFuncs(_root, _map);
  }
  protected void contributeTo_Program_deadFuncs(Set<Func> collection) {
    super.contributeTo_Program_deadFuncs(collection);
    if (!program().mainFuncReachable().contains(this) && !this.getFuncName().getID().equals("main")) {
      collection.add(this);
    }
  }
}
