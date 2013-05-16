package commands;

/**
 *
 * @author Michal Šimon
 */
public class Div extends MemoryCommand{
     public Div(String value) {
        super(value);
    }

    @Override
    public String execute() {
        
        Variable var1 = this.ram.getWorkRegister();
        
        //Variable var2 = new Variable(this.value);
        Variable var2 = this.ram.get(Integer.parseInt(this.value));
        
        this.ram.setWorkRegister(var1.div(var2));
        
        return null;
    }   
}
