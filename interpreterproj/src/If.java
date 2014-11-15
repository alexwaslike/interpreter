import java.io.*;

class If extends Special {
 
    // TODO: Add any fields needed.
	Node cons;
 
    // TODO: Add an appropriate constructor.
	public If(Node t){cons = t;	}
    void print(Node t, int n, boolean p) {
    	  Printer.printIf(t, n, p);
    }
    
    // returns whether the args is true/false.
    public Object eval(Environment env){
    	if( cons.getCar().eval(env) instanceof BooleanLit ){
    		if( (boolean) cons.getCar().eval(env) )
    			return true;
    		return false;
    	}
    	else
    		throw new RuntimeException("Argument not boolean.");
    }
}
