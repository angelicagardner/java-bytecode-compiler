package ag223pi.dv507.a4;

import java.util.*;

public final class GlobalScope implements Scope {
    private static GlobalScope INSTANCE;
    private HashMap<String, Symbol> symbols;
    private List<Scope> scopes;

    // private constructor
    private GlobalScope() {
        this.symbols = new LinkedHashMap<String, Symbol>();
        this.scopes = new ArrayList<>();
    }

    public static GlobalScope getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GlobalScope();
        }
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Global Scope";
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("- " + getName());
        for (Scope child : scopes) {
            str.append("\n-" + child.toString());
        }
        return str.toString();
    }

    /**
     * Returns null because it's the global scope
     */
    @Override
    public Scope getEnclosingScope() {
        return null;
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
        }
        return s;

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
        this.scopes.add(scope);
    }

    @Override
    public List<Scope> getNestedScopes() {
        return this.scopes;
    }

    @Override
    public List<Scope> getParentScopes() {
        return null;
    }

    @Override
    public boolean checkForDuplicate(String name) {
        return symbols.containsKey(name);
    }
}
