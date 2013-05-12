package interpreter;

import commands.Variable;
import java.util.HashMap;

/**
 *
 * @author Michal Šimon
 */
public class Memory {

    private HashMap<Integer, Variable> ram = null;
    
    private final Integer WORK_REGISTER = 0;
    
    private Integer counter = 1;

    Memory() {
        this.ram = new HashMap<Integer, Variable>();
    }
    
    public Variable get(){
        return this.ram.get(this.counter-1);
    }
    
    public Variable get(Integer id){
        return this.ram.get(id);
    }
    
    public int add(Variable var){
        this.ram.put(counter++, var);
        
        return counter;
    }
    
    public void push(Integer id, Variable var){
        this.ram.put(id, var);
    }
    
    public Variable getWorkRegister(){
        return this.get(WORK_REGISTER);
    }
    
    public void setWorkRegister(Variable var){
        
        this.ram.put(WORK_REGISTER, var);
    }
}
