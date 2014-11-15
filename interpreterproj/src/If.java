import java.io.*;

class If extends Special {
 
    // TODO: Add any fields needed.
	
 
    // TODO: Add an appropriate constructor.
	public If(Node t){	}
    void print(Node t, int n, boolean p) {
    	  Printer.printIf(t, n, p);
    }
    
    // returns whether the args is true/false.
    public Object eval(Node args, Environment env){
    	if( args.eval(args, env) instanceof BooleanLit ){
    		if( (boolean) args.eval(args, env) )
    			return true;
    		return false;
    	}
    	else
    		throw new RuntimeException("Argument not boolean.");
    }
}
