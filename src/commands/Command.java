package commands;

/**
 *
 * @author Michal Šimon
 */
public abstract class Command {

    protected String value = null;

    public Command(String value) {
        this.value = value;
    }

    public abstract String execute();
}
