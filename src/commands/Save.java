package commands;

/**
 *
 * @author Michal Šimon
 */
public class Save extends MemoryCommand{
     public Save(String value) {
        super(value);
    }

    @Override
    public String execute() {
        
        Integer id = Integer.parseInt(this.value);
        
        Variable var = this.ram.getWorkRegister();
        
        this.ram.push(id, var);
        
        return null;
    }   
}
