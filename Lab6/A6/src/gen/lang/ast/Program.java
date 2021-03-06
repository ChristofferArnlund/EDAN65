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
import java.util.HashSet;
/**
 * @ast node
 * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/lang.ast:1
 * @production Program : {@link ASTNode} ::= <span class="component">{@link Func}*</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/CodeGen.jrag:2
   */
  public void genCode(PrintStream out) {
		//bootstrap
		out.println(".global _start");
		out.println(".data");
		out.println("	ask_message: .ascii \"Plz enter a number: \"");
		out.println("	ask_msg_len: .quad 20");
		out.println("	buf: .skip 1024");
		out.println(".text");
		out.println("_start:");
		out.println("	call main");
		out.println("	movq %rax, %rdi");
		out.println("	movq $60, %rax");
		out.println("	syscall");
		out.println();

		for(Func func : getFuncs()) 
			func.genCode(out);

		genIOCode(out);
	}
  /**
   * @aspect CodeGenIO
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/CodeGenIO.jrag:2
   */
  public void genIOCode(PrintStream out) {
		//read function
		out.println("read:");
		out.println("	pushq %rbp");
		out.println("	movq %rsp, %rbp");
		out.println("	movq $0, %rdi");
		out.println("	movq $buf, %rsi");
		out.println("	movq $1024, %rdx");
		out.println("	movq $0, %rax");
		out.println("	syscall");
		out.println("	movq $0, %rdx");
		out.println("read_atoi_loop:");
		out.println("	cmpq $0, %rax");
		out.println("	jle read_atoi_done");
		out.println("	movzbq (%rsi), %rbx");
		out.println("	cmpq $0x30, %rbx");
		out.println("	jl read_atoi_done");
		out.println("	cmpq $0x39, %rbx");
		out.println("	jg read_atoi_done");
		out.println("	imulq $10, %rdx");
		out.println("	subq $0x30, %rbx");
		out.println("	addq %rbx, %rdx");
		out.println("	incq %rsi");
		out.println("	decq %rax");
		out.println("	jmp read_atoi_loop");
		out.println("read_atoi_done:");
		out.println("	movq %rdx, %rax");
		out.println("	popq %rbp");
		out.println("	ret");
		out.println("");

		out.println("print:");
		out.println("	pushq %rbp");
		out.println("	movq %rsp, %rbp");
		out.println("	### convert integer to string");
		out.println("	movq 16(%rbp), %rax # parameter");
		out.println("	movq $(buf+1023), %rsi # write ptr (start from end of buf)");
		out.println("	movb $0x0a, (%rsi) # insert newline");
		out.println("	movq $1, %rcx # string length");
		out.println("	movq $0xF000000000000000, %r9		#mask");
		out.println("	movq %r9, %r8  				#mask for signbit");
		out.println("	and  %rax, %r8				#maskout signbit");
		out.println("	cmpq %r9, %r8				#check if signed");
		out.println("	jne itoa_loop				#if not signed skip");
		out.println("	not %rax				#invert");
		out.println("	addq $1, %rax				#add one to rax");
		out.println("itoa_loop: # do.. while (at least one iteration)");
		out.println("	movq $10, %rbx");
		out.println("	movq $0, %rdx");
		out.println("	idivq %rbx # divide rdx:rax by 10");
		out.println("	addb $0x30, %dl # remainder + ’0’");
		out.println("	decq %rsi # move string pointer");
		out.println("	movb %dl, (%rsi)");
		out.println("	incq %rcx # increment string length");
		out.println("	cmpq $0, %rax");
		out.println("	jg itoa_loop # produce more digits");
		out.println("itoa_done:");
		out.println("	cmpq %r9, %r8				#check if signed");
		out.println("	jne skip_sign				#if not signed skip");
		out.println("	decq %rsi # move string pointer		#move string pointer");
		out.println("	movb $0x2D, (%rsi) 			#insert - sign");
		out.println("	incq %rcx # increment string length");
		out.println("skip_sign:				#skip to if not signed");
		out.println("	movq $1, %rdi");
		out.println("	movq %rcx, %rdx");
		out.println("	movq $1, %rax");
		out.println("	syscall");
		out.println("	popq %rbp");
		out.println("	ret");

		/*print function
		out.println("print:");
		out.println("	pushq %rbp");
		out.println("	movq %rsp, %rbp");
		out.println("	movq 16(%rbp), %rax");
		out.println("	movq $(buf+1023), %rsi");
		out.println("	movb $0x0a, (%rsi)");
		out.println("	movq $1, %rcx");
		out.println("print_itoa_loop:");
		out.println("	movq $10, %rbx");
		out.println("	movq $0, %rdx");
		out.println("	idivq %rbx");
		out.println("	addb $0x30, %dl");
		out.println("	decq %rsi");
		out.println("	movb %dl, (%rsi)");
		out.println("	incq %rcx");
		out.println("	cmpq $0, %rax");
		out.println("	jg print_itoa_loop");
		out.println("print_itoa_done:");
		out.println("	movq $1, %rdi");
		out.println("	movq %rcx, %rdx");
		out.println("	movq $1, %rax");
		out.println("	syscall");
		out.println("	popq %rbp");
		out.println("	ret");*/
	}
  /**
   * @aspect Interp
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/Interp.jrag:15
   */
  public void eval() {
		IdDecl mainFunc = localLookup("main");
		if(!mainFunc.isUnknown() && mainFunc.isFunction()) 
			mainFunc.function().eval(new ActivationRecord()); //gogo
		else 
			throw new RuntimeException("There is no main function!");
	}
  /**
   * @declaredat ASTNode:1
   */
  public Program() {
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
    children = new ASTNode[1];
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  public Program(List<Func> p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:18
   */
  protected int numChildren() {
    return 1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:22
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    intType_reset();
    boolType_reset();
    unknownDecl_reset();
    unknownFunc_reset();
    unknownType_reset();
    predefinedFunctions_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Program_errors_visited = false;
    Program_errors_computed = false;
    
    Program_errors_value = null;
    Program_unusedVars_visited = false;
    Program_unusedVars_computed = false;
    
    Program_unusedVars_value = null;
    Program_deadFuncs_visited = false;
    Program_deadFuncs_computed = false;
    
    Program_deadFuncs_value = null;
    contributorMap_Program_errors = null;
    contributorMap_Program_unusedVars = null;
    contributorMap_Program_deadFuncs = null;
    contributorMap_IdDecl_idUses = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:52
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:57
   */
  public Program copy() {
    try {
      Program node = (Program) clone();
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
   * @declaredat ASTNode:76
   */
  @Deprecated
  public Program fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:86
   */
  public Program treeCopyNoTransform() {
    Program tree = (Program) copy();
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
   * @declaredat ASTNode:106
   */
  public Program treeCopy() {
    Program tree = (Program) copy();
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
   * @declaredat ASTNode:120
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node);    
  }
  /**
   * Replaces the Func list.
   * @param list The new list node to be used as the Func list.
   * @apilevel high-level
   */
  public void setFuncList(List<Func> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the Func list.
   * @return Number of children in the Func list.
   * @apilevel high-level
   */
  public int getNumFunc() {
    return getFuncList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Func list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Func list.
   * @apilevel low-level
   */
  public int getNumFuncNoTransform() {
    return getFuncListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Func list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Func list.
   * @apilevel high-level
   */
  public Func getFunc(int i) {
    return (Func) getFuncList().getChild(i);
  }
  /**
   * Check whether the Func list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasFunc() {
    return getFuncList().getNumChild() != 0;
  }
  /**
   * Append an element to the Func list.
   * @param node The element to append to the Func list.
   * @apilevel high-level
   */
  public void addFunc(Func node) {
    List<Func> list = (parent == null) ? getFuncListNoTransform() : getFuncList();
    list.addChild(node);
  }
  /** @apilevel low-level 
   */
  public void addFuncNoTransform(Func node) {
    List<Func> list = getFuncListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Func list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setFunc(Func node, int i) {
    List<Func> list = getFuncList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Func list.
   * @return The node representing the Func list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Func")
  public List<Func> getFuncList() {
    List<Func> list = (List<Func>) getChild(0);
    return list;
  }
  /**
   * Retrieves the Func list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Func list.
   * @apilevel low-level
   */
  public List<Func> getFuncListNoTransform() {
    return (List<Func>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the Func list without
   * triggering rewrites.
   */
  public Func getFuncNoTransform(int i) {
    return (Func) getFuncListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Func list.
   * @return The node representing the Func list.
   * @apilevel high-level
   */
  public List<Func> getFuncs() {
    return getFuncList();
  }
  /**
   * Retrieves the Func list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Func list.
   * @apilevel low-level
   */
  public List<Func> getFuncsNoTransform() {
    return getFuncListNoTransform();
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/Errors.jrag:26
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_Program_errors = null;

  protected void survey_Program_errors() {
    if (contributorMap_Program_errors == null) {
      contributorMap_Program_errors = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_Program_errors(this, contributorMap_Program_errors);
    }
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnusedVars.jrag:4
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_Program_unusedVars = null;

  protected void survey_Program_unusedVars() {
    if (contributorMap_Program_unusedVars == null) {
      contributorMap_Program_unusedVars = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_Program_unusedVars(this, contributorMap_Program_unusedVars);
    }
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/deadFuncs.jrag:4
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_Program_deadFuncs = null;

  protected void survey_Program_deadFuncs() {
    if (contributorMap_Program_deadFuncs == null) {
      contributorMap_Program_deadFuncs = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_Program_deadFuncs(this, contributorMap_Program_deadFuncs);
    }
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnusedVars.jrag:8
   */
  protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_IdDecl_idUses = null;

  protected void survey_IdDecl_idUses() {
    if (contributorMap_IdDecl_idUses == null) {
      contributorMap_IdDecl_idUses = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_IdDecl_idUses(this, contributorMap_IdDecl_idUses);
    }
  }

/** @apilevel internal */
protected java.util.Set localLookup_String_visited;
  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/NameAnalysis.jrag:82
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/NameAnalysis.jrag:82")
  public IdDecl localLookup(String name) {
    Object _parameters = name;
    if (localLookup_String_visited == null) localLookup_String_visited = new java.util.HashSet(4);
    if (localLookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Program.localLookup(String).");
    }
    localLookup_String_visited.add(_parameters);
    try {
    		for(int i = 0; i < getNumFunc(); i++) {
    			IdDecl funcName = getFunc(i).getFuncName();			
    			if(funcName.getID().equals(name)) 		
    				return funcName; 
    		}
    		return unknownDecl();
    	}
    finally {
      localLookup_String_visited.remove(_parameters);
    }
  }
/** @apilevel internal */
protected boolean intType_visited = false;
  /** @apilevel internal */
  private void intType_reset() {
    intType_computed = false;
    
    intType_value = null;
    intType_visited = false;
  }
  /** @apilevel internal */
  protected boolean intType_computed = false;

  /** @apilevel internal */
  protected IntType intType_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/TypeAnalysis.jrag:4
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/TypeAnalysis.jrag:4")
  public IntType intType() {
    ASTNode$State state = state();
    if (intType_computed) {
      return intType_value;
    }
    if (intType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.intType().");
    }
    intType_visited = true;
    state().enterLazyAttribute();
    intType_value = new IntType();
    intType_value.setParent(this);
    intType_computed = true;
    state().leaveLazyAttribute();
    intType_visited = false;
    return intType_value;
  }
/** @apilevel internal */
protected boolean boolType_visited = false;
  /** @apilevel internal */
  private void boolType_reset() {
    boolType_computed = false;
    
    boolType_value = null;
    boolType_visited = false;
  }
  /** @apilevel internal */
  protected boolean boolType_computed = false;

  /** @apilevel internal */
  protected BoolType boolType_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/TypeAnalysis.jrag:9
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/TypeAnalysis.jrag:9")
  public BoolType boolType() {
    ASTNode$State state = state();
    if (boolType_computed) {
      return boolType_value;
    }
    if (boolType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.boolType().");
    }
    boolType_visited = true;
    state().enterLazyAttribute();
    boolType_value = new BoolType();
    boolType_value.setParent(this);
    boolType_computed = true;
    state().leaveLazyAttribute();
    boolType_visited = false;
    return boolType_value;
  }
/** @apilevel internal */
protected boolean unknownDecl_visited = false;
  /** @apilevel internal */
  private void unknownDecl_reset() {
    unknownDecl_computed = false;
    
    unknownDecl_value = null;
    unknownDecl_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownDecl_computed = false;

  /** @apilevel internal */
  protected UnknownDecl unknownDecl_value;

  /**
   * @attribute syn
   * @aspect UnknownDecl
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnknownDecl.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnknownDecl.jrag:2")
  public UnknownDecl unknownDecl() {
    ASTNode$State state = state();
    if (unknownDecl_computed) {
      return unknownDecl_value;
    }
    if (unknownDecl_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownDecl().");
    }
    unknownDecl_visited = true;
    state().enterLazyAttribute();
    unknownDecl_value = new UnknownDecl("<Unknown>");
    unknownDecl_value.setParent(this);
    unknownDecl_computed = true;
    state().leaveLazyAttribute();
    unknownDecl_visited = false;
    return unknownDecl_value;
  }
/** @apilevel internal */
protected boolean unknownFunc_visited = false;
  /** @apilevel internal */
  private void unknownFunc_reset() {
    unknownFunc_computed = false;
    
    unknownFunc_value = null;
    unknownFunc_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownFunc_computed = false;

  /** @apilevel internal */
  protected UnknownFunc unknownFunc_value;

  /**
   * @attribute syn
   * @aspect UnknownFunc
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnknownFunc.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownFunc", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnknownFunc.jrag:2")
  public UnknownFunc unknownFunc() {
    ASTNode$State state = state();
    if (unknownFunc_computed) {
      return unknownFunc_value;
    }
    if (unknownFunc_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownFunc().");
    }
    unknownFunc_visited = true;
    state().enterLazyAttribute();
    unknownFunc_value = new UnknownFunc(new IdDecl("<Unknown>"), new List(), new StmtBlock(new List()));
    unknownFunc_value.setParent(this);
    unknownFunc_computed = true;
    state().leaveLazyAttribute();
    unknownFunc_visited = false;
    return unknownFunc_value;
  }
/** @apilevel internal */
protected boolean unknownType_visited = false;
  /** @apilevel internal */
  private void unknownType_reset() {
    unknownType_computed = false;
    
    unknownType_value = null;
    unknownType_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownType_computed = false;

  /** @apilevel internal */
  protected UnknownType unknownType_value;

  /**
   * @attribute syn
   * @aspect UnknownType
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnknownType.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownType", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnknownType.jrag:2")
  public UnknownType unknownType() {
    ASTNode$State state = state();
    if (unknownType_computed) {
      return unknownType_value;
    }
    if (unknownType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownType().");
    }
    unknownType_visited = true;
    state().enterLazyAttribute();
    unknownType_value = new UnknownType("<Unknown>");
    unknownType_value.setParent(this);
    unknownType_computed = true;
    state().leaveLazyAttribute();
    unknownType_visited = false;
    return unknownType_value;
  }
/** @apilevel internal */
protected boolean mainFuncReachable_visited = false;
  /**
   * @attribute syn
   * @aspect deadFuncs
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/deadFuncs.jrag:9
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="deadFuncs", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/deadFuncs.jrag:9")
  public Set<Func> mainFuncReachable() {
    if (mainFuncReachable_visited) {
      throw new RuntimeException("Circular definition of attribute Program.mainFuncReachable().");
    }
    mainFuncReachable_visited = true;
    Set<Func> mainFuncReachable_value = localLookup("main").function().reachable();
    mainFuncReachable_visited = false;
    return mainFuncReachable_value;
  }
/** @apilevel internal */
protected boolean predefinedFunctions_visited = false;
  /** @apilevel internal */
  private void predefinedFunctions_reset() {
    predefinedFunctions_computed = false;
    
    predefinedFunctions_value = null;
    predefinedFunctions_visited = false;
  }
  /** @apilevel internal */
  protected boolean predefinedFunctions_computed = false;

  /** @apilevel internal */
  protected List<Func> predefinedFunctions_value;

  /**
   * @attribute syn
   * @aspect PredefinedFunctions
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/predefinedFunctions.jrag:3
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="PredefinedFunctions", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/predefinedFunctions.jrag:3")
  public List<Func> predefinedFunctions() {
    ASTNode$State state = state();
    if (predefinedFunctions_computed) {
      return predefinedFunctions_value;
    }
    if (predefinedFunctions_visited) {
      throw new RuntimeException("Circular definition of attribute Program.predefinedFunctions().");
    }
    predefinedFunctions_visited = true;
    state().enterLazyAttribute();
    predefinedFunctions_value = predefinedFunctions_compute();
    predefinedFunctions_value.setParent(this);
    predefinedFunctions_computed = true;
    state().leaveLazyAttribute();
    predefinedFunctions_visited = false;
    return predefinedFunctions_value;
  }
  /** @apilevel internal */
  private List<Func> predefinedFunctions_compute() {
  		List<Func> list = new List<Func>();
  		list.add(new Func(new IdDecl("print"), new List().add(new FuncParam(new IdDecl("output"))), new StmtBlock()));
  		list.add(new Func(new IdDecl("read"), new List(), new StmtBlock()));
  		return list;
  	}
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/Errors.jrag:28
   * @apilevel internal
   */
  public Program Define_program(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return this;
  }
  protected boolean canDefine_program(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/NameAnalysis.jrag:19
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    int childIndex = this.getIndexOfChild(_callerNode);
    {
    		for(Func func : predefinedFunctions()) 
    			if(func.getFuncName().getID().equals(name)) 		
    				return func.getFuncName();
    		return localLookup(name);
    	}
  }
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/ParamChecker.jrag:3
   * @apilevel internal
   */
  public Func Define_function(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownFunc();
  }
  protected boolean canDefine_function(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/TypeAnalysis.jrag:5
   * @apilevel internal
   */
  public IntType Define_intType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return intType();
  }
  protected boolean canDefine_intType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/TypeAnalysis.jrag:10
   * @apilevel internal
   */
  public BoolType Define_boolType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return boolType();
  }
  protected boolean canDefine_boolType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnknownDecl.jrag:4
   * @apilevel internal
   */
  public UnknownDecl Define_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownDecl();
  }
  protected boolean canDefine_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/IdUseTypeAnalysis.jrag:4
   * @apilevel internal
   */
  public boolean Define_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == unknownDecl_value) {
      // @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnknownDecl.jrag:10
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
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/IdUseTypeAnalysis.jrag:3
   * @apilevel internal
   */
  public boolean Define_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == unknownDecl_value) {
      // @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnknownDecl.jrag:11
      return false;
    }
    else {
      return getParent().Define_isFunction(this, _callerNode);
    }
  }
  protected boolean canDefine_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnknownFunc.jrag:4
   * @apilevel internal
   */
  public UnknownFunc Define_unknownFunc(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownFunc();
  }
  protected boolean canDefine_unknownFunc(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnknownType.jrag:9
   * @apilevel internal
   */
  public UnknownType Define_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownType();
  }
  protected boolean canDefine_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/VarParamAddressing.jrag:13
   * @apilevel internal
   */
  public boolean Define_isFunctionParam(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  protected boolean canDefine_isFunctionParam(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/VarParamAddressing.jrag:20
   * @apilevel internal
   */
  public int Define_paramIndex(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return 0;
  }
  protected boolean canDefine_paramIndex(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/uniqueIdDeclName.jrag:6
   * @apilevel internal
   */
  public String Define_uniqueNamePrefix(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    {
    		return "<Unknown>";
    	}
  }
  protected boolean canDefine_uniqueNamePrefix(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
/** @apilevel internal */
protected boolean Program_errors_visited = false;
  /**
   * @attribute coll
   * @aspect Errors
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/Errors.jrag:26
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="Errors", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/Errors.jrag:26")
  public Set<ErrorMessage> errors() {
    ASTNode$State state = state();
    if (Program_errors_computed) {
      return Program_errors_value;
    }
    if (Program_errors_visited) {
      throw new RuntimeException("Circular definition of attribute Program.errors().");
    }
    Program_errors_visited = true;
    state().enterLazyAttribute();
    Program_errors_value = errors_compute();
    Program_errors_computed = true;
    state().leaveLazyAttribute();
    Program_errors_visited = false;
    return Program_errors_value;
  }
  /** @apilevel internal */
  private Set<ErrorMessage> errors_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof Program)) {
      node = node.getParent();
    }
    Program root = (Program) node;
    root.survey_Program_errors();
    Set<ErrorMessage> _computedValue = new TreeSet<ErrorMessage>();
    if (root.contributorMap_Program_errors.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_Program_errors.get(this)) {
        contributor.contributeTo_Program_errors(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean Program_errors_computed = false;

  /** @apilevel internal */
  protected Set<ErrorMessage> Program_errors_value;

/** @apilevel internal */
protected boolean Program_unusedVars_visited = false;
  /**
   * @attribute coll
   * @aspect UnusedVars
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnusedVars.jrag:4
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="UnusedVars", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/UnusedVars.jrag:4")
  public Set<IdDecl> unusedVars() {
    ASTNode$State state = state();
    if (Program_unusedVars_computed) {
      return Program_unusedVars_value;
    }
    if (Program_unusedVars_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unusedVars().");
    }
    Program_unusedVars_visited = true;
    state().enterLazyAttribute();
    Program_unusedVars_value = unusedVars_compute();
    Program_unusedVars_computed = true;
    state().leaveLazyAttribute();
    Program_unusedVars_visited = false;
    return Program_unusedVars_value;
  }
  /** @apilevel internal */
  private Set<IdDecl> unusedVars_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof Program)) {
      node = node.getParent();
    }
    Program root = (Program) node;
    root.survey_Program_unusedVars();
    Set<IdDecl> _computedValue = new HashSet<IdDecl>();
    if (root.contributorMap_Program_unusedVars.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_Program_unusedVars.get(this)) {
        contributor.contributeTo_Program_unusedVars(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean Program_unusedVars_computed = false;

  /** @apilevel internal */
  protected Set<IdDecl> Program_unusedVars_value;

/** @apilevel internal */
protected boolean Program_deadFuncs_visited = false;
  /**
   * @attribute coll
   * @aspect deadFuncs
   * @declaredat /home/marcus/git/EDAN65/Lab6/A6/src/jastadd/deadFuncs.jrag:4
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="deadFuncs", declaredAt="/home/marcus/git/EDAN65/Lab6/A6/src/jastadd/deadFuncs.jrag:4")
  public Set<Func> deadFuncs() {
    ASTNode$State state = state();
    if (Program_deadFuncs_computed) {
      return Program_deadFuncs_value;
    }
    if (Program_deadFuncs_visited) {
      throw new RuntimeException("Circular definition of attribute Program.deadFuncs().");
    }
    Program_deadFuncs_visited = true;
    state().enterLazyAttribute();
    Program_deadFuncs_value = deadFuncs_compute();
    Program_deadFuncs_computed = true;
    state().leaveLazyAttribute();
    Program_deadFuncs_visited = false;
    return Program_deadFuncs_value;
  }
  /** @apilevel internal */
  private Set<Func> deadFuncs_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof Program)) {
      node = node.getParent();
    }
    Program root = (Program) node;
    root.survey_Program_deadFuncs();
    Set<Func> _computedValue = new TreeSet<Func>();
    if (root.contributorMap_Program_deadFuncs.containsKey(this)) {
      for (ASTNode contributor : root.contributorMap_Program_deadFuncs.get(this)) {
        contributor.contributeTo_Program_deadFuncs(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean Program_deadFuncs_computed = false;

  /** @apilevel internal */
  protected Set<Func> Program_deadFuncs_value;

}
