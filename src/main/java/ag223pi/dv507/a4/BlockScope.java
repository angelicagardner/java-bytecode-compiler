package ag223pi.dv507.a4;

import java.util.*;

public class BlockScope implements Scope {
    private HashMap<String, Symbol> symbols;
    private final String name;
    private List<Scope> scopes;
    private Scope parent;
    private List<Scope> parents;

    BlockScope(String name, Scope parent) {
        this.name = name;
        this.symbols = new LinkedHashMap<>();
        this.scopes = new ArrayList<>();
        this.parent = parent;
        this.parents = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Scope getEnclosingScope() {
        return parent;
    }

    @Override
    public boolean define(Symbol s) {

        if (getSymbol(s.getName()) != null) {
            return false;
        } else {
            symbols.put(s.getName(), s);
            return true;
        }

    }

    @Override
    public Symbol getSymbol(String name) {

        Symbol s = null;
        if (symbols.containsKey(name)) {
            s = symbols.get(name);
        } else {
            if (this.parent.getSymbol(name) != null) {
                s = this.parent.getSymbol(name);
            }
        }

        return s;

    }

    @Override
    public boolean checkForDuplicate(String symbolName) {
        return symbols.containsKey(symbolName);
    }

    @Override
    public List<? extends Symbol> getAllSymbols() {
        return new ArrayList<>(symbols.values());
    }

    @Override
    public int getNumberOfSymbols() {
        return symbols.size();
    }

    @Override
    public void nest(Scope scope) {
        scopes.add(scope);
    }

    @Override
    public List<Scope> getNestedScopes() {
        return this.scopes;
    }

    @Override
    public List<Scope> getParentScopes() {
        return this.parents;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("-\t" + getName());
        for (Symbol symbol : this.symbols.values()) {
            str.append("\n\t" + symbol.getOFPType().toString().toLowerCase());
            str.append(" " + symbol.getName());
        }
        for (Scope child : this.scopes) {
            str.append("\n--" + child.toString());
        }
        return str.toString();
    }

}
