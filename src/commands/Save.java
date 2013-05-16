package commands;

/**
 *
 * @author Michal Šimon
 */
public class Save extends MemoryCommand {

    public Save(String value) {
        super(value);
    }

    @Override
    public String execute() {

        Integer id;

        try {
            id = Integer.parseInt(this.value);
        } catch (Exception e) {
            System.err.println(this.value + " Not valid value");

            return null;
        }

        Variable var = this.ram.getWorkRegister();

        this.ram.push(id, var);

        return null;
    }
}
