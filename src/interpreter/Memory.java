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
    private final Integer WORK_REGISTER = 0;
    private Integer counter = 1;

    Memory() {
        this.ram = new HashMap<Integer, Variable>();
    }

    public Variable get() {
        return this.ram.get(this.counter - 1);
    }

    public Variable get(Integer id) {
        return this.ram.get(id);
    }

    public List<Variable> getLast(Integer n) {
        List output = new ArrayList<Variable>();

        for (; n > 0; n--) {

            Variable v = this.get(this.counter - n);

            if (v != null) {
                output.add(v);
            }
        }

        return output;
    }

    public int add(Variable var) {
        this.ram.put(this.counter++, var);

        return this.counter;
    }

    public void push(Integer id, Variable var) {
        this.ram.put(id, var);
        this.counter++;
    }

    public Variable getWorkRegister() {
        return this.get(WORK_REGISTER);
    }

    public void setWorkRegister(Variable var) {

        this.ram.put(WORK_REGISTER, var);
    }
}
