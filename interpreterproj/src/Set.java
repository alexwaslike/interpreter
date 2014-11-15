import java.io.*;

class Set extends Special {
 
    // TODO: Add any fields needed.
	Node cons;
 
    // TODO: Add an appropriate constructor.
	public Set(Node t){
		cons = t;
	}
	
    void print(Node t, int n, boolean p) {
    	Printer.printSet(t, n, p);
    }
    
    // calls Environment.assign
    public Object eval(Environment env){
    	env.assign(cons.getCar(), cons.getCdr());
    	return null;
    }
}
