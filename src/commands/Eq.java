package commands;

/**
 *
 * @author Michal Šimon
 */
public class Eq extends MemoryCommand{
     public Eq(String value) {
        super(value);
    }

    @Override
    public String execute() {
        
        Variable var1 = this.ram.getWorkRegister();
        
        Variable var2 = new Variable(this.value);
        
        this.ram.setWorkRegister(var1.eq(var2));
        
        return null;
    }   
}
