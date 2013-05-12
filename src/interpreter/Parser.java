package interpreter;

import commands.Gt;
import commands.Div;
import commands.Concat;
import commands.Command;
import commands.Add;
import commands.Add;
import commands.And;
import commands.Command;
import commands.Concat;
import commands.Div;
import commands.Eq;
import commands.Load;
import commands.Lt;
import commands.Mod;
import commands.Mul;
import commands.Not;
import commands.Or;
import commands.Print;
import commands.Prints;
import commands.Push;
import commands.Save;
import commands.Sub;
import commands.Uminus;
import interpreter.Memory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michal Šimon
 */
public class Parser {

    private String path = "";
    private List commands = null;
    private Memory ram = null;

    /**
     * @param path
     * @return Parser
     */
    public Parser(String path, Memory ram) {
        this.path = path;
        this.ram = ram;

        this.commands = new ArrayList<Command>();
    }

    public List parse() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.path));
        String line = null;
        //String ls = System.getProperty("line.separator");

        while ((line = reader.readLine()) != null) {

            String[] parts = line.split("[ ]+"); // rozdělí na pole podle jedné nebo více mezer

            String directive = parts[0].toLowerCase();
            String value = line.replace(directive + " ", ""); // odstraní z celého řádku část s direktivou

            if ("".equals(value)) {
                value = null;
            }

            Command command = null;

            switch (directive) {
                case "print": {
                    Print print = new Print(value);

                    print.setMemory(this.ram);

                    command = print;

                    break;
                }
                case "prints": {
                    Prints prints = new Prints(value);

                    prints.setMemory(this.ram);

                    command = prints;

                    break;
                }
                case "push": {
                    Push push = new Push(value);

                    push.setMemory(this.ram);

                    command = push;

                    break;
                }
                case "load": {
                    Load load = new Load(value);

                    load.setMemory(this.ram);

                    command = load;

                    break;
                }
                case "save": {
                    Save save = new Save(value);

                    save.setMemory(this.ram);

                    command = save;

                    break;
                }
                case "concat": {
                    Concat concat = new Concat(value);

                    concat.setMemory(this.ram);

                    command = concat;

                    break;
                }
                case "add": {
                    Add add = new Add(value);

                    add.setMemory(this.ram);

                    command = add;

                    break;
                }
                case "sub": {
                    Sub sub = new Sub(value);

                    sub.setMemory(this.ram);

                    command = sub;

                    break;
                }
                case "mul": {
                    Mul mul = new Mul(value);

                    mul.setMemory(this.ram);

                    command = mul;

                    break;
                }
                case "div": {
                    Div div = new Div(value);

                    div.setMemory(this.ram);

                    command = div;

                    break;
                }
                case "mod": {
                    Mod mod = new Mod(value);

                    mod.setMemory(this.ram);

                    command = mod;

                    break;
                }
                case "uminus": {
                    Uminus uminus = new Uminus(value);

                    uminus.setMemory(this.ram);

                    command = uminus;

                    break;
                }
                case "and": {
                    And and = new And(value);

                    and.setMemory(this.ram);

                    command = and;

                    break;
                }
                case "or": {
                    Or or = new Or(value);

                    or.setMemory(this.ram);

                    command = or;

                    break;
                }
                case "gt": {
                    Gt gt = new Gt(value);

                    gt.setMemory(this.ram);

                    command = gt;

                    break;
                }
                case "lt": {
                    Lt lt = new Lt(value);

                    lt.setMemory(this.ram);

                    command = lt;

                    break;
                }
                case "eq": {
                    Eq eq = new Eq(value);

                    eq.setMemory(this.ram);

                    command = eq;

                    break;
                }
                case "not": {
                    Not not = new Not(value);

                    not.setMemory(this.ram);

                    command = not;

                    break;
                }
            }

            if (command != null) {
                this.commands.add(command);
            }
        }

        return this.commands;
    }
}
