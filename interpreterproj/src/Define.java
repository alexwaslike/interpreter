import java.io.*;

class Define extends Special {
 
    // TODO: Add any fields needed.

 
    // TODO: Add an appropriate constructor.
	public Define(Node t){

	}
    void print(Node t, int n, boolean p) {
    	  Printer.printDefine(t, n, p);
    }
    
    // calls Environment.define
    // variables created with define have a global scope
    public Object eval(Node args, Environment env){
    	env.define(args.getCar(), args.getCdr());
    	return null;
    }
}
