package commands;

/**
 *
 * @author Michal Šimon
 */
public class Not extends MemoryCommand{
     public Not(String value) {
        super(value);
    }

    @Override
    public String execute() {
        
        Variable var = this.ram.getWorkRegister();
        
        this.ram.setWorkRegister(var.not());
        
        return null;
    }   
}
