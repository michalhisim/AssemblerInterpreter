package commands;

/**
 *
 * @author Michal Šimon
 */
public class Uminus extends MemoryCommand{
     public Uminus(String value) {
        super(value);
    }

    @Override
    public String execute() {
        
        Variable var1 = this.ram.getWorkRegister();
        
        this.ram.setWorkRegister(var1.uminus());
        
        return null;
    }   
}
