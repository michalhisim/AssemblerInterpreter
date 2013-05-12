package commands;

/**
 *
 * @author Michal Šimon
 */
public class Push extends MemoryCommand{

    public Push(String value) {
        super(value);
    }

    @Override
    public String execute() {
        
        Variable var = new Variable(this.value);
        
        this.ram.setWorkRegister(var);
        
        return null;
    }
}
