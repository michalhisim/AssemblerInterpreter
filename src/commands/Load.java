package commands;

/**
 *
 * @author Michal Šimon
 */
public class Load extends MemoryCommand{
     public Load(String value) {
        super(value);
    }

    @Override
    public String execute() {
        
        Integer id = Integer.parseInt(this.value);
        
        Variable var = this.ram.get(id);
        
        this.ram.setWorkRegister(var);
        
        //System.out.println(var.get().toString());
        
        return null;
    }   
}
