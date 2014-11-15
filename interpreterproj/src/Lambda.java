import java.io.*;

class Lambda extends Special {
		
    // TODO: Add any fields needed.
	Node cons;
	
	    // TODO: Add an appropriate constructor.
	public Lambda(Node t){
		cons = t;
	}
    void print(Node t, int n, boolean p) {
    	  Printer.printLambda(t, n, p);
  	}
    
    public Object eval(Environment env){
    	return new Closure(cons, env);
    }

}
