package commands;

import commands.Command;
import interpreter.Memory;

/**
 *
 * @author Michal Šimon
 */
public abstract class MemoryCommand extends Command {

    protected Memory ram = null;

    public MemoryCommand(String value) {
        super(value);
    }

    public void setMemory(Memory ram) {
        this.ram = ram;
    }
}
