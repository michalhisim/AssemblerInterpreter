package commands;

/**
 *
 * @author Michal Šimon
 */
public class Sub extends MemoryCommand{
     public Sub(String value) {
        super(value);
    }

    @Override
    public String execute() {
        
        Variable var1 = this.ram.getWorkRegister();
        
        Variable var2 = new Variable(this.value);
        
        this.ram.setWorkRegister(var1.sub(var2));
        
        return null;
    }   
}
