package ag223pi.dv507.a4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ag223pi.dv507.a4.OFPParser.FunctionContext;
import ag223pi.dv507.a4.OFPParser.FunctionDeclarationContext;
import ag223pi.dv507.a4.OFPParser.IfStmtContext;
import ag223pi.dv507.a4.OFPParser.MainContext;
import ag223pi.dv507.a4.OFPParser.ParametersContext;
import ag223pi.dv507.a4.OFPParser.ProgramContext;
import ag223pi.dv507.a4.OFPParser.VarDeclarationContext;
import ag223pi.dv507.a4.OFPParser.VarInitializationContext;
import ag223pi.dv507.a4.OFPParser.WhileStmtContext;

public class SymbolTable extends OFPBaseListener {
    GlobalScope g;
    Scope currentScope;
    StringBuilder str = new StringBuilder();
    HashMap<String, VariableSymbol> variables = new HashMap<String, VariableSymbol>();
    HashMap<String, FunctionSymbol> functions = new HashMap<String, FunctionSymbol>();
    int indent = 0;
    int duplicates = 0;

    public GlobalScope getGlobalScope() {
        return this.g;
    }

    public int getDuplicateCount() {
        return this.duplicates;
    }

    public HashMap<String, VariableSymbol> getVariables() {
        return this.variables;
    }

    public HashMap<String, FunctionSymbol> getFunctions() {
        return this.functions;
    }

    @Override
    public void enterProgram(ProgramContext ctx) {
        str.append("--- SYMBOL TABLE ---");
        str.append(System.getProperty("line.separator"));

        GlobalScope global = GlobalScope.getInstance();
        this.g = global;
        this.currentScope = global;
    }

    @Override
    public void enterMain(MainContext ctx) {
        String name = "main";
        FunctionSymbol function = new FunctionSymbol(name, OFPType.VOIDFUNCTION, currentScope, ctx);
        this.currentScope.define(function);
        this.functions.put(name, function);
        BlockScope main = new BlockScope(name, currentScope);
        this.currentScope = main;
        this.g.nest(main);
        this.str.append("- enter scope: " + main.getName() + " - " + function.getOFPType().toString().toLowerCase());
        this.str.append(System.getProperty("line.separator"));
        this.indent = 1;
    }

    @Override
    public void exitMain(MainContext ctx) {
        this.str.append("- exit scope: " + this.currentScope.getName());
        this.str.append(System.getProperty("line.separator"));
        this.str.append(System.getProperty("line.separator"));
        this.currentScope = g;
        this.indent = 0;
    }

    @Override
    public void enterFunctionDeclaration(FunctionDeclarationContext ctx) {
        List<Scope> scopes = currentScope.getNestedScopes();
        OFPType returnType = OFPType.getByName(ctx.getChild(0).getText());
        String name = ctx.getChild(1).getText();
        boolean duplicate = false;

        for (Scope s : scopes) {
            if (name.equals(s.getName())) {
                duplicate = true;
            }
        }

        if (!duplicate) {
            BlockScope function = new BlockScope(name, this.currentScope);
            FunctionSymbol f = new FunctionSymbol(name, returnType, this.currentScope, ctx);
            this.functions.put(name, f);
            this.currentScope.define(f);
            this.currentScope.nest(function);
            this.currentScope = function;
            for (int i = 0; i < this.indent; i++) {
                this.str.append('\t');
            }
            this.str.append("- enter scope: " + function.getName() + " - " + f.getOFPType().toString().toLowerCase());
            this.str.append(System.getProperty("line.separator"));
            this.indent = this.indent + 1;

        } else {
            this.duplicates = this.duplicates + 1;
            System.out.println("Duplicate variable encountered!!");
        }
    }

    @Override
    public void exitFunction(FunctionContext ctx) {
        this.str.append("- exit scope: " + this.currentScope.getName());
        this.str.append(System.getProperty("line.separator"));
        this.str.append(System.getProperty("line.separator"));
        this.currentScope = this.currentScope.getEnclosingScope();
        this.indent = this.indent - 1;
    }

    @Override
    public void enterWhileStmt(WhileStmtContext ctx) {
        BlockScope block = new BlockScope("while", this.currentScope);
        this.currentScope.nest(block);
        this.currentScope = block;
        this.str.append(System.getProperty("line.separator"));
        for (int i = 0; i < this.indent; i++) {
            this.str.append('\t');
        }
        this.str.append("- enter scope: " + block.getName());
        this.str.append(System.getProperty("line.separator"));
        this.indent = this.indent + 1;
    }

    @Override
    public void enterIfStmt(IfStmtContext ctx) {
        BlockScope block = new BlockScope("if", this.currentScope);
        this.currentScope.nest(block);
        this.currentScope = block;
        str.append(System.getProperty("line.separator"));
        for (int i = 0; i < this.indent; i++) {
            this.str.append('\t');
        }
        str.append("- enter scope: " + block.getName());
        str.append(System.getProperty("line.separator"));
        this.indent = this.indent + 1;
    }

    @Override
    public void exitWhileStmt(WhileStmtContext ctx) {
        this.indent = this.indent - 1;
        for (int i = 0; i < this.indent; i++) {
            this.str.append('\t');
        }
        this.str.append("- exit scope: " + this.currentScope.getName());
        this.str.append(System.getProperty("line.separator"));
        this.str.append(System.getProperty("line.separator"));
        this.currentScope = this.currentScope.getEnclosingScope();
    }

    @Override
    public void exitIfStmt(IfStmtContext ctx) {
        this.indent = this.indent - 1;
        for (int i = 0; i < this.indent; i++) {
            this.str.append('\t');
        }
        this.str.append("- exit scope: " + this.currentScope.getName());
        this.str.append(System.getProperty("line.separator"));
        this.str.append(System.getProperty("line.separator"));
        this.currentScope = this.currentScope.getEnclosingScope();
    }

    @Override
    public void enterParameters(ParametersContext ctx) {
        ArrayList<String> params = new ArrayList<>();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (!ctx.getChild(i).getText().equals(",")) {
                params.add(ctx.getChild(i).getText());
            }
        }

        String functionName = this.currentScope.getName();
        FunctionSymbol function = (FunctionSymbol) this.currentScope.getEnclosingScope().getSymbol(functionName);

        for (int i = 0; i < params.size(); i++) {
            if (i % 2 == 0) {
                OFPType type = OFPType.getByName(params.get(i));
                String name = params.get(i + 1);

                VariableSymbol var = new VariableSymbol(name, type, null, currentScope);
                this.variables.put(name, var);
                this.currentScope.define(var);
                function.setParameters(var);

                for (int j = 0; j < this.indent; j++) {
                    this.str.append('\t');
                }
                str.append(type.getValue() + " " + name);
                str.append(System.getProperty("line.separator"));
            }
        }

    }

    /**
     * Add a new VariableSymbol (if not a duplicate identifier is used)
     */
    @Override
    public void enterVarDeclaration(VarDeclarationContext ctx) {
        OFPType type = OFPType.getByName(ctx.getChild(0).getText());
        String name = ctx.getChild(1).getText();

        if (!currentScope.checkForDuplicate(name)) {
            VariableSymbol var = new VariableSymbol(name, type, null, currentScope);
            this.variables.put(name, var);
            currentScope.define(var);

            for (int i = 0; i < this.indent; i++) {
                this.str.append('\t');
            }
            this.str.append(type.getValue() + " " + name);
            this.str.append(System.getProperty("line.separator"));
        } else {
            this.duplicates = this.duplicates + 1;
            System.out.println("Duplicate variable encountered!!");
        }

    }

    /**
     * Add a new VariableSymbol (if not a duplicate identifier is used)
     */
    @Override
    public void enterVarInitialization(VarInitializationContext ctx) {
        OFPType type = OFPType.getByName(ctx.getChild(0).getText());
        String name = ctx.getChild(1).getText();

        if (!currentScope.checkForDuplicate(name)) {
            VariableSymbol var = new VariableSymbol(name, type, null, currentScope);
            this.variables.put(name, var);
            currentScope.define(var);

            for (int i = 0; i < this.indent; i++) {
                this.str.append('\t');
            }
            str.append(type.getValue() + " " + name);
            str.append(System.getProperty("line.separator"));
        } else {
            this.duplicates = this.duplicates + 1;
            System.out.println("Duplicate variable encountered!!" + name);
        }

    }

    /**
     * End of Symbol Table creation
     */
    @Override
    public void exitProgram(ProgramContext ctx) {
        this.str.append("--- END OF SYMBOL TABLE ---");
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return this.str.toString();
    }

}
