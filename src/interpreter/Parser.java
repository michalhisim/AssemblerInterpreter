package interpreter;

import commands.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Michal Šimon
 */
public class Parser {

    private String path = "";
    private Pipeline commands = null;
    private HashMap labels = null;
    private Memory ram = null;

    /**
     * @param path
     * @return Parser
     */
    public Parser(String path, Memory ram) {
        this.path = path;
        this.ram = ram;

        this.commands = new Pipeline();
        this.labels = new HashMap<Integer, Integer>();
    }

    public Pipeline parse() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.path));
        String line = null;
        //String ls = System.getProperty("line.separator");

        while ((line = reader.readLine()) != null) {

            String[] parts = line.split("[ ]+"); // rozdělí na pole podle jedné nebo více mezer

            String directive = parts[0];
            String value = line.replace(directive + " ", ""); // odstraní z celého řádku část s direktivou

            directive = directive.toLowerCase();
            
            if ("".equals(value)) {
                value = null;
            }

            MemoryCommand command = null;

            //System.err.println(value);
            
            switch (directive) {
                case "label": {
                    // saves position vector (label name,command position)
                    this.labels.put(Integer.parseInt(value), this.commands.size());

                    continue;
                }
                case "jmp": {
                    Jmp jmp = new Jmp(value);

                    jmp.setCommands(this.commands);
                    jmp.setLabels(this.labels);

                    command = jmp;

                    break;
                }
                case "fjmp": {
                    Fjmp fjmp = new Fjmp(value);

                    fjmp.setCommands(this.commands);
                    fjmp.setLabels(this.labels);

                    command = fjmp;

                    break;
                }
                case "print": {
                    command = new Print(value);

                    break;
                }
                case "prints": {
                    command = new Prints(value);

                    break;
                }
                case "push": {
                    command = new Push(value);

                    break;
                }
                case "load": {
                    command = new Load(value);

                    break;
                }
                case "save": {
                    command = new Save(value);

                    break;
                }
                case "concat": {
                    command = new Concat(value);

                    break;
                }
                case "add": {
                    command = new Add(value);

                    break;
                }
                case "sub": {
                    command = new Sub(value);

                    break;
                }
                case "mul": {
                    command = new Mul(value);

                    break;
                }
                case "div": {
                    command = new Div(value);

                    break;
                }
                case "mod": {
                    command = new Mod(value);

                    break;
                }
                case "uminus": {
                    command = new Uminus(value);

                    break;
                }
                case "and": {
                    command = new And(value);

                    break;
                }
                case "or": {
                    command = new Or(value);

                    break;
                }
                case "gt": {
                    command = new Gt(value);

                    break;
                }
                case "lt": {
                    command = new Lt(value);

                    break;
                }
                case "eq": {
                    command = new Eq(value);

                    break;
                }
                case "not": {
                    command = new Not(value);

                    break;
                }
            }

            if (command != null) {
                command.setMemory(this.ram);
                
                this.commands.add(command);
            }
        }

        return this.commands;
    }
}
