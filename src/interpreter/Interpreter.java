package interpreter;

import commands.Command;
import commands.MemoryCommand;
import java.util.List;

/**
 *
 * @author Michal Šimon
 */
public class Interpreter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String source = "../machine-code.asm";

        // firtst argument can be source file
        for (int i = 0; i < args.length; i++) {
            source = args[i];

            break;
        }

        System.out.println("Preprocesing file: " + source);

        Memory ram = new Memory();

        Parser parser = new Parser(source, ram);
        
        Pipeline commands = null;

        try {
            commands = parser.parse();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.print(commands.run());
        //commands.run();
    }
}
