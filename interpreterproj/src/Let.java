import java.io.*;

class Let extends Special {
 
    // TODO: Add any fields needed.
	Node cons;
 
    // TODO: Add an appropriate constructor.
	public Let(Node t){ cons = t; }
    void print(Node t, int n, boolean p) {
    	  Printer.printLet(t, n, p);
    }
    
    // calls Environment.define
    // variables created with let have a local scope
    public Object eval(Environment env){
    	env.define(cons.getCar(), cons.getCdr());
    	return null;
    }
}
