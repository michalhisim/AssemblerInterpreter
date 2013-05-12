package commands;

/**
 *
 * @author Michal Šimon
 */
public class Print extends MemoryCommand {
    
    public Print(String value) {
        super(value);
    }

    @Override
    public String execute() {
        Integer id = Integer.parseInt(this.value);
        
        Variable var = this.ram.get(id);
        
        if(var == null){
            return null;
        }
        
        return var.toString();
    }
}
