import java.io.*;

class Quote extends Special {
 
    // TODO: Add any fields needed.
	Node cons;
 
    // TODO: Add an appropriate constructor.
	
	public Quote(Node t){ cons = t;	}

    void print(Node t, int n, boolean p) {
    	Printer.printQuote(t, n, p);
    }
    
    public Object eval(Environment env){
    	// returns whatever it is we're quoting
    	return cons.getCdr();
    }

}
    

