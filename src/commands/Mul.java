package commands;

/**
 *
 * @author Michal Šimon
 */
public class Mul extends MemoryCommand{
     public Mul(String value) {
        super(value);
    }

    @Override
    public String execute() {
        
        Variable var1 = this.ram.getWorkRegister();
        
        Variable var2 = new Variable(this.value);
        
        this.ram.setWorkRegister(var1.mul(var2));
        
        return null;
    }   
}
