package commands;

/**
 *
 * @author Michal Šimon
 */
public class Variable {

    final String INTEGER = "I";
    final String FLOAT = "F";
    final String STRING = "S";
    final String BOOLEAN = "B";
    protected Object value = null;
    protected String type = null;

    Variable(String value, String type) {
        this(type + value);
    }

    Variable(String variable) {
        String type = variable.substring(0, 1);

        String value = variable.replace(type, ""); // odstraní z celého řádku část s typem

        if ("".equals(value)) {
            value = null;
        }

        switch (type) {
            case "I": {
                this.value = new Integer(value);
                this.type = INTEGER;

                break;
            }
            case "F": {
                this.value = new Float(value);
                this.type = INTEGER;

                break;
            }
            case "S": {
                this.value = value;
                this.type = STRING;

                break;
            }
            case "B": {
                this.value = new Boolean(value);
                this.type = BOOLEAN;

                break;
            }
            default: {
                this.value = variable;
                this.type = STRING;
            }
        }

        //System.out.println(this.value.toString());

    }

    public Object get() {
        return this.value;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    public Variable add(Variable var) {

        if (this.type == INTEGER && var.getType() == INTEGER) {
            return new Variable(new Integer((Integer) this.value + (Integer) var.get()).toString(), INTEGER);
        } else if (this.type == FLOAT && var.getType() == FLOAT) {
            return new Variable(new Float((Float) this.value + (Float) var.get()).toString(), FLOAT);
        } else if (this.type == FLOAT && var.getType() == INTEGER) {
            return new Variable(new Float((Float) this.value + (Integer) var.get()).toString(), FLOAT);
        } else if (this.type == INTEGER && var.getType() == FLOAT) {
            return new Variable(new Float((Integer) this.value + (Float) var.get()).toString(), FLOAT);
        } else if (this.type == STRING && var.getType() == STRING) {
            return new Variable((String) ((String) this.value + (String) var.get()), STRING);
        }

        return null;
    }

    public Variable sub(Variable var) {
        if (this.type == INTEGER && var.getType() == INTEGER) {
            return new Variable(new Integer((Integer) this.value - (Integer) var.get()).toString(), INTEGER);
        } else if (this.type == FLOAT && var.getType() == FLOAT) {
            return new Variable(new Float((Float) this.value - (Float) var.get()).toString(), FLOAT);
        } else if (this.type == FLOAT && var.getType() == INTEGER) {
            return new Variable(new Float((Float) this.value - (Integer) var.get()).toString(), FLOAT);
        } else if (this.type == INTEGER && var.getType() == FLOAT) {
            return new Variable(new Float((Integer) this.value - (Float) var.get()).toString(), FLOAT);
        }

        return null;
    }

    public Variable mul(Variable var) {
        if (this.type == INTEGER && var.getType() == INTEGER) {
            return new Variable(new Integer((Integer) this.value * (Integer) var.get()).toString(), INTEGER);
        } else if (this.type == FLOAT && var.getType() == FLOAT) {
            return new Variable(new Float((Float) this.value * (Float) var.get()).toString(), FLOAT);
        } else if (this.type == FLOAT && var.getType() == INTEGER) {
            return new Variable(new Float((Float) this.value * (Integer) var.get()).toString(), FLOAT);
        } else if (this.type == INTEGER && var.getType() == FLOAT) {
            return new Variable(new Float((Integer) this.value * (Float) var.get()).toString(), FLOAT);
        }

        return null;
    }

    public Variable div(Variable var) {
        if ((var.getType() == INTEGER || var.getType() == FLOAT) && var.get() == 0) {
            return null;
        }

        if (this.type == INTEGER && var.getType() == INTEGER) {
            return new Variable(new Integer((Integer) this.value / (Integer) var.get()).toString(), INTEGER);
        } else if (this.type == FLOAT && var.getType() == FLOAT) {
            return new Variable(new Float((Float) this.value / (Float) var.get()).toString(), FLOAT);
        } else if (this.type == FLOAT && var.getType() == INTEGER) {
            return new Variable(new Float((Float) this.value / (Integer) var.get()).toString(), FLOAT);
        } else if (this.type == INTEGER && var.getType() == FLOAT) {
            return new Variable(new Float((Integer) this.value / (Float) var.get()).toString(), FLOAT);
        }

        return null;
    }

    public Variable mod(Variable var) {

        if (this.type == INTEGER && var.getType() == INTEGER) {
            return new Variable(new Integer((int) this.value % (int) var.get()).toString(), INTEGER);
        }
        //Modulo exists only for Ints
        /* else if (this.type == FLOAT && var.getType() == FLOAT) {
            return new Variable(new Float((Float) this.value % (Float) var.get()).toString(), FLOAT);
        } else if (this.type == FLOAT && var.getType() == INTEGER) {
            return new Variable(new Float((Float) this.value % (Integer) var.get()).toString(), FLOAT);
        } else if (this.type == INTEGER && var.getType() == FLOAT) {
            return new Variable(new Float((Integer) this.value % (Float) var.get()).toString(), FLOAT);
        }*/

        return null;
    }

    public Variable uminus() {

        if (this.type == INTEGER) {
            return new Variable(new Integer(((Integer) this.value) * (-1)).toString(), INTEGER);
        } else if (this.type == FLOAT) {
            return new Variable(new Float(((Float) this.value) * (-1)).toString(), FLOAT);
        }

        return null;
    }

    public Variable and(Variable var) {

        if (this.type == BOOLEAN && var.getType() == BOOLEAN) {
            return new Variable(new Boolean((boolean) this.value && (boolean) var.get()).toString(), BOOLEAN);
        }

        return null;
    }

    public Variable or(Variable var) {

        if (this.type == BOOLEAN && var.getType() == BOOLEAN) {
            return new Variable(new Boolean((boolean) this.value || (boolean) var.get()).toString(), BOOLEAN);
        }

        return null;
    }

    public Variable gt(Variable var) {

        if (this.type == INTEGER && var.getType() == INTEGER) {
            return new Variable(new Boolean((int) this.value > (int) var.get()).toString(), BOOLEAN);
        } else if (this.type == FLOAT && var.getType() == FLOAT) {
            return new Variable(new Boolean((Float) this.value > (Float) var.get()).toString(), BOOLEAN);
        } else if (this.type == FLOAT && var.getType() == INTEGER) {
            return new Variable(new Boolean((Float) this.value > (Integer) var.get()).toString(), BOOLEAN);
        } else if (this.type == INTEGER && var.getType() == FLOAT) {
            return new Variable(new Boolean((Integer) this.value > (Float) var.get()).toString(), BOOLEAN);
        }


        return null;
    }

    public Variable lt(Variable var) {

        if (this.type == INTEGER && var.getType() == INTEGER) {
            return new Variable(new Boolean((int) this.value < (int) var.get()).toString(), BOOLEAN);
        } else if (this.type == FLOAT && var.getType() == FLOAT) {
            return new Variable(new Boolean((Float) this.value < (Float) var.get()).toString(), BOOLEAN);
        } else if (this.type == FLOAT && var.getType() == INTEGER) {
            return new Variable(new Boolean((Float) this.value < (Integer) var.get()).toString(), BOOLEAN);
        } else if (this.type == INTEGER && var.getType() == FLOAT) {
            return new Variable(new Boolean((Integer) this.value < (Float) var.get()).toString(), BOOLEAN);
        }


        return null;
    }

    public Variable eq(Variable var) {

        if (this.type == INTEGER && var.getType() == INTEGER) {
            return new Variable(new Boolean((int) this.value == (int) var.get()).toString(), BOOLEAN);
        } else if (this.type == FLOAT && var.getType() == FLOAT) {
            return new Variable(new Boolean((Float) this.value == (Float) var.get()).toString(), BOOLEAN);
        } else if (this.type == FLOAT && var.getType() == INTEGER) {
            return new Variable(new Boolean((float) this.value == (int) var.get()).toString(), BOOLEAN);
        } else if (this.type == INTEGER && var.getType() == FLOAT) {
            return new Variable(new Boolean((int) this.value == (float) var.get()).toString(), BOOLEAN);
        } else if (this.type == STRING && var.getType() == STRING) {
            return new Variable(new Boolean((String) this.value == (String) var.get()).toString(), BOOLEAN);
        }

        return null;
    }

    public Variable not() {

        if (this.type == BOOLEAN) {
            
            Boolean v = (boolean) this.value;
            
            if (v) {
                return new Variable("false", BOOLEAN);
            } else {
                return new Variable("true", BOOLEAN);
            }
        }

        return null;
    }
}
