// BuiltIn.java -- the data structure for function closures

// Class BuiltIn is used for representing the value of built-in functions
// such as +.  Populate the initial environment with
// (name, new BuiltIn(name)) pairs.

// The object-oriented style for implementing built-in functions would be
// to include the Java methods for implementing a Scheme built-in in the
// BuiltIn object.  This could be done by writing one subclass of class
// BuiltIn for each built-in function and implementing the method apply
// appropriately.  This requires a large number of classes, though.
// Another alternative is to program BuiltIn.apply() in a functional
// style by writing a large if-then-else chain that tests the name of
// of the function symbol.

class BuiltIn extends Node {
    private Node symbol;

    public BuiltIn(Node s)		{ symbol = s; }

    public Node getSymbol()		{ return symbol; }

    // TODO: The method isProcedure() should be defined in
    // class Node to return false.
    public boolean isProcedure()	{ return true; }

    public void print(int n) {
	// there got to be a more efficient way to print n spaces
	for (int i = 0; i < n; i++)
	    System.out.print(' ');
	System.out.println("#{Built-in Procedure");
	symbol.print(n+3);
	for (int i = 0; i < n; i++)
	    System.out.print(' ');
	System.out.println('}');
    }
    
    public Object eval(Environment env){
    	return apply(this, env);
    }
    
    public Object apply(Node args, Environment env){
    	
    	if(args == null) 
    		return null;
    	
    	Node car = args.getCar();
    	Node cdr = args.getCdr();
    	
    	// carries out apply based on symbol name
    	String name = car.getName();
    	
    	// METHODS THAT CALL INTERNAL STRUCTURE
    	// read, write, eval, apply, interaction-environment
    	if( name.equals("read") ){
    		// asks for input
    		// calls parser and returns a parse tree
    		Scanner scanner = new Scanner(System.in);
    		Parser parser = new Parser(scanner);
    		Node root = parser.parseExp();
    		Node next = parser.parseExp();
    		while(next!=null){
    			root.setCdr(next);
    			next = parser.parseExp();
    		}
    		return root;
    	}
    	else if( name.equals("write") ){
    		// does not wait for input
    		// calls pretty-printer
    		Node next = cdr;
    		while(next != null)
    			next.print(0);
    	}
    	else if( name.equals("eval") ){
    		// calls eval()
    		return cdr.eval(env);
    	}
    	else if( name.equals("apply") ){
    		// calls apply()
    		return apply(car);
    	}
    	else if( name.equals("interaction-environment") ){
    		// returns pointer to global env
    		return Main.Environment;
    	}
    	// TESTS
    	// symbol? number? procedure?
    	// returns BooleanLit containing result
    	else if( name.equals("symbol?") ){
    		return new BooleanLit(car.isSymbol());
    	}
    	else if( name.equals("number?") ){
    		return new BooleanLit(car.isNumber() );
    	}
    	else if( name.equals("procedure?") ){
    		return new BooleanLit( car.isProcedure() );
    	}
    	// BINARY OPERATIONS
    	// b+ b- b* b/ b= b<
    	// returns IntLit containing result
    	else if( name.equals("b+") ){
    		if(car.isNumber() && cdr.isNumber())
    			return new IntLit( car.getIntVal() + cdr.getIntVal() );
    		else
    			throw new RuntimeException("Invalid args for binary operator.");
    	}
    	else if( name.equals("b-") ){
    		if(car.isNumber() && cdr.isNumber())
    			return new IntLit( car.getIntVal() - cdr.getIntVal() );
    		else
    			throw new RuntimeException("Invalid args for binary operator.");
    	}
    	else if( name.equals("b*") ){
    		if(car.isNumber() && cdr.isNumber())
    			return new IntLit( car.getIntVal() * cdr.getIntVal() );
    		else
    			throw new RuntimeException("Invalid args for binary operator.");
    	}
    	else if( name.equals("b/") ){
    		if(car.isNumber() && cdr.isNumber())
    			return new IntLit( car.getIntVal() / cdr.getIntVal() );
    		else
    			throw new RuntimeException("Invalid args for binary operator.");
    	}
    	else if( name.equals("b=") ){
    		if(car.isNumber() && cdr.isNumber())
    			return new BooleanLit( car.getIntVal() == cdr.getIntVal() );
    		else
    			throw new RuntimeException("Invalid args for binary operator.");
    	}
    	else if( name.equals("b<") ){
    		if(car.isNumber() && cdr.isNumber())
    			return new BooleanLit( car.getIntVal() < cdr.getIntVal() );
    		else
    			throw new RuntimeException("Invalid args for binary operator.");
    	}
    	// LIST OPERATIONS
    	// car, cdr, cons, set-car!, set-cdr!, null? pair? eq?
    	else if( name.equals("car") ){
    		if(car.isNull()) return null;
    		return car.getCar();
    	}
    	else if( name.equals("cdr") ){
    		if(car.isNull()) return null;
    		return car.getCdr();
    	}
    	else if( name.equals("cons") ){
    		return new Cons(car,cdr);
    	}
    	else if( name.equals("set-car!") ){
    		car.getCar().setCar(cdr);
    		return car;
    	}
    	else if( name.equals("set-cdr!") ){
    		car.getCar().setCdr(cdr);
    		return car;
    	}
    	else if( name.equals("null?") ){
    		return new BooleanLit( car == null );
    	}
    	else if( name.equals("pair?") ){
    		return new BooleanLit( car.isPair() );
    	}
    	else if( name.equals("eq?") ){
    		// tests to see if both args are equal IN MEMORY
    		return new BooleanLit( car == cdr );
    	}
    	// OTHER I/O FUNCTIONS
    	// display, newline
    	else if( name.equals("display") ){
    		// finds all strings and chars in the arg and prints them out
    		String output = "";
    		Node next = cdr;
    		while(next != null){
    			output += next.getName();
    			next = next.getCdr();
    		}
    		return new StrLit(output);
    	}
    	else if( name.equals("newline") ){
    		// prints out a new line
    		return new StrLit("\n");
    	}
    	else {
	        System.out.println("BuiltIn function not found.");
	    }
    	return null;
    }
   
    
    
    public Node apply (Node args) {
    	return null;
    }
}
