import java.io.*;

class Begin extends Special {
 
    // TODO: Add any fields needed.
	Node cons;
 
    // TODO: Add an appropriate constructor.
	public Begin(Node t){
		cons = t;
	}
    void print(Node t, int n, boolean p) {
    	  Printer.printBegin(t, n, p);
    }
    
    // takes a list of functions and returns the result of the last one.
    public Object eval(Environment env){
    	return null;
    }
}
