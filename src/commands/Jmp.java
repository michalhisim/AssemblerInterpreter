package commands;

import interpreter.Pipeline;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Michal Šimon
 */
public class Jmp extends MemoryCommand {

    private Pipeline commands = null;
    private HashMap labels = null;

    public Jmp(String value) {
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

        Integer label = Integer.parseInt(value);

        int pointer = (int) this.labels.get(label);

        this.commands.setPointer(pointer-1);

        return null;
    }
}
