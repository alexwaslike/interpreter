import java.io.*;

class Regular extends Special {
 
    // TODO: Add any fields needed.
	Node cons;
    
    // TODO: Add an appropriate constructor.

    public Regular(Node t){
    	cons = t;
	}
    void print(Node t, int n, boolean p) {
    	  Printer.printRegular(t, n, p);
    }    
    
    public Object eval(Environment env){
    	Node car = cons.getCar();
    	Node args = cons.getCdr();

    	if ( car==null || car.isNull() ){
    		return null;
    	}
    	
    	if (car.isProcedure()) {
    		return car.apply(args, env);
    	}else
    		return car.eval(env);
    	
    }
}
