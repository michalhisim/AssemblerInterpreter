package commands;

import interpreter.Pipeline;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Michal Šimon
 */
public class Fjmp extends MemoryCommand {

    private Pipeline commands = null;
    private HashMap labels = null;

    public Fjmp(String value) {
        super(value);
    }

    public void setCommands(Pipeline commands) {
        this.commands = commands;
    }

    public void setLabels(HashMap labels) {
        this.labels = labels;
    }

    @Override
    public String execute() {

        Variable v = this.ram.getWorkRegister();

        if ((boolean) v.get() == false) {
            Integer label = Integer.parseInt(value);

            int pointer = (int) this.labels.get(label);

            this.commands.setPointer(pointer-1);
        }

        return null;
    }
}
