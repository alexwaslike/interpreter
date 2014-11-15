import java.io.*;

class Let extends Special {
 
    // TODO: Add any fields needed.
	
 
    // TODO: Add an appropriate constructor.
	public Let(Node t){}
    void print(Node t, int n, boolean p) {
    	  Printer.printLet(t, n, p);
    }
    
    // calls Environment.define
    // variables created with let have a local scope
    public Object eval(Node args, Environment env){
    	env.define(args.getCar(), args.getCdr());
    	return null;
    }
}
