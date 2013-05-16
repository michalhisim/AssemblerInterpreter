package commands;

import java.util.List;

/**
 *
 * @author Michal Šimon
 */
public class Prints extends MemoryCommand {

    public Prints(String value) {
        super(value);
    }

    @Override
    public String execute() {
        Integer n = Integer.parseInt(this.value);

        List<Variable> variables = this.ram.getLast(n);

        if (variables == null) {
            return null;
        }
        
        //System.err.println(variables);
        
        StringBuilder output = new StringBuilder();

        for (Variable v : variables) {
            String result = v.toString();
            
            //System.err.println(result);
            if (result != null) {
                output.append(result + "\n");
            }
        }

        return output.toString();
    }
}
