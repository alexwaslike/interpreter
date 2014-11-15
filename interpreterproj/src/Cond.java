import java.io.*;

class Cond extends Special {
 
    // TODO: Add any fields needed.
	private String condName;
 
    // TODO: Add an appropriate constructor.
	public Cond(Node t){

	}
	
    void print(Node t, int n, boolean p) { 
    	Printer.printCond(t, n, p);
    }
    
    public Object eval(Environment env){
    	return condName;
    }
}
