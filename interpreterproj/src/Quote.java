import java.io.*;

class Quote extends Special {
 
    // TODO: Add any fields needed.
 
 
    // TODO: Add an appropriate constructor.
	
	public Quote(Node t){	}

    void print(Node t, int n, boolean p) {
    	Printer.printQuote(t, n, p);
    }
    
    public Object eval(Node args, Environment env){
    	// returns whatever it is we're quoting
    	return args.getCdr();
    }

}
    

