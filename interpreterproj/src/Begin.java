import java.io.*;

class Begin extends Special {
 
    // TODO: Add any fields needed.

 
    // TODO: Add an appropriate constructor.
	public Begin(Node t){
		
	}
    void print(Node t, int n, boolean p) {
    	  Printer.printBegin(t, n, p);
    }
    
    // takes a list of functions and returns the result of the last one.
    public Object eval(Node args, Environment env){
    	return null;
    }
}
