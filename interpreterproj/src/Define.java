import java.io.*;

class Define extends Special {
 
    // TODO: Add any fields needed.
	Node cons;
 
    // TODO: Add an appropriate constructor.
	public Define(Node t){
		cons = t;
	}
    void print(Node t, int n, boolean p) {
    	  Printer.printDefine(t, n, p);
    }
    
    // calls Environment.define
    // variables created with define have a global scope
    public Object eval(Environment env){
    	env.define(cons.getCar(), cons.getCdr());
    	return null;
    }
}
