package interpreter;

import commands.Variable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Michal Šimon
 */
public class Memory {

    private HashMap<Integer, Variable> ram = null;
    private List<Integer> last = null;
    private final Integer WORK_REGISTER = 0;
    private Integer counter = 1;

    Memory() {
        this.ram = new HashMap<Integer, Variable>();
        this.last = new ArrayList<Integer>();
    }

    public Variable get() {
        return this.ram.get(this.counter - 1);
    }

    public Variable get(Integer id) {
        return this.ram.get(id);
    }

    public List<Variable> getLast(Integer n) {
        List output = new ArrayList<Variable>();

        int size = this.last.size();

        int j = 0;

        for (Integer i : this.last) {
            j++;

            if (size - n <= j) {
                Variable v = this.get(i);
                if (v != null) {
                    output.add(v);
                }
            }
        }

        return output;
    }

    public int add(Variable var) {
        this.ram.put(this.counter++, var);

        this.logLast(counter);

        return this.counter;
    }

    public void push(Integer id, Variable var) {
        this.ram.put(id, var);
        this.logLast(id);
        this.counter++;
    }

    public Variable getWorkRegister() {
        return this.get(WORK_REGISTER);
    }

    public void setWorkRegister(Variable var) {

        this.ram.put(WORK_REGISTER, var);
    }
    
    private void logLast(Integer id){
        this.last.remove(id);
        this.last.add(id);
    }
}
