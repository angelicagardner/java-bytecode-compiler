package ag223pi.dv507.a4;

import org.objectweb.asm.Type;

public class VariableSymbol implements Symbol {

    private String name;
    private OFPType ofpType;
    private Type type;
    private Scope scope;
    private boolean init = false;
    private Object value;

    VariableSymbol(String name, OFPType ofpType, Type type, Scope scope) {
        this.name = name;
        this.ofpType = ofpType;
        this.scope = scope;
        this.type = type;

        switch (ofpType) {
        case STRING:
            this.value = "";
            break;
        case INT:
            this.value = 0;
            break;
        case INTARRAY:
            this.value = null;
            break;
        }
    }

    VariableSymbol(String name, OFPType ofpType, Scope scope, boolean init) {
        this.name = name;
        this.ofpType = ofpType;
        this.scope = scope;
        this.init = true;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Symbol)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return name.equals(((Symbol) obj).getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Scope getScope() {
        return this.scope;
    }

    @Override
    public OFPType getOFPType() {
        return this.ofpType;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isInitialized() {
        return this.init;
    }

}
