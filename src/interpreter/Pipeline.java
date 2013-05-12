package interpreter;

import commands.Command;
import java.util.HashMap;

/**
 *
 * @author Michal Šimon
 */
public class Pipeline {

    private HashMap<Integer, Command> line = null;
    private int pointer = 0;
    private int iterator = 0;

    Pipeline() {
        this.line = new HashMap<Integer, Command>();
    }

    public Boolean add(Command c) {

        this.line.put(this.pointer, c);

        this.pointer++;

        return true;
    }

    public Command get() {
        return this.line.get(this.pointer);
    }

    public Command get(int pointer) {
        return this.line.get(pointer);
    }

    public Boolean setPointer(int pointer) {
        if (pointer >= 0 && pointer < this.line.size()) {
            
            //System.out.print("JUMP TO " + pointer + " | jumping: " + this.iterator);
            
            this.iterator = pointer;

            //System.out.print(" -> " + this.iterator + "\n");

            return true;
        } else {
            return false;
        }
    }

    public String run() {
        StringBuilder output = new StringBuilder();
        
        //output.append("--- OUTPUT ---\n");
        
        this.iterator = 0;

        while (this.iterator < this.line.size()) {


            Command c = this.line.get(this.iterator);

            if (c != null) {

                //System.out.print(this.iterator + " / " + this.line.size());
                //System.out.print("\n");

                String result = c.execute();

                if (result != null) {
                    output.append(result);
                    output.append("\n");
                }
            }

            this.iterator++;
        }

        return output.toString();
    }

    public int size() {
        return this.line.size();
    }
}
