package commands;

/**
 *
 * @author Michal Šimon
 */
public class Concat extends MemoryCommand{
     public Concat(String value) {
        super(value);
    }

    @Override
    public String execute() {
        
        Variable var1 = this.ram.getWorkRegister();
        
        Variable var2 = new Variable(this.value);
        
        this.ram.setWorkRegister(var1.add(var2));
        
        return null;
    }   
}
