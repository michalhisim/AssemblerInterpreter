package commands;

/**
 *
 * @author Michal Šimon
 */
public class Mod extends MemoryCommand{
     public Mod(String value) {
        super(value);
    }

    @Override
    public String execute() {
        
        Variable var1 = this.ram.getWorkRegister();
        
        Variable var2 = new Variable(this.value);
        
        this.ram.setWorkRegister(var1.mod(var2));
        
        return null;
    }   
}
