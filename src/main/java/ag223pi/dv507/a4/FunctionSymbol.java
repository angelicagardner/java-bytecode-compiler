package ag223pi.dv507.a4;

import java.util.*;

import org.antlr.v4.runtime.tree.ParseTree;

public class FunctionSymbol implements Symbol {
    private final String name;
    private OFPType type;
    private Scope scope;
    private HashMap<String, Symbol> parameters;
    private HashMap<String, Symbol> symbols;
    private String functionBody;
    private ParseTree ctx;

    FunctionSymbol(String name, OFPType type, Scope scope, ParseTree ctx) {
        this.name = name;
        this.type = type;
        this.scope = scope;
        this.parameters = new LinkedHashMap<>();
        this.symbols = new LinkedHashMap<>();
        this.ctx = ctx;
    }

    public void setFunctionBody(String body) {
        this.functionBody = body;
    }

    public String getFunctionBody() {
        return this.functionBody;
    }

    public boolean define(Symbol s) {

        if (getSymbol(s.getName()) != null) {
            return false;
        } else {
            symbols.put(s.getName(), s);
            return true;
        }

    }

    public Symbol getSymbol(String name) {

        Symbol s = null;
        if (symbols.containsKey(name)) {
            s = symbols.get(name);
        }

        return s;

    }

    public ParseTree getCTX() {
        return this.ctx;
    }

    public void setParameters(Symbol s) {
        parameters.put(s.getName(), s);
    }

    public boolean checkParameter(String s) {
        return parameters.containsKey(s);
    }

    public List<? extends Symbol> getParameters() {
        return new ArrayList<>(parameters.values());
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
        return this.type;
    }

}
