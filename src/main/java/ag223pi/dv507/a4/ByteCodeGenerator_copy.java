package ag223pi.dv507.a4;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.antlr.v4.runtime.tree.ParseTree;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

import ag223pi.dv507.a4.OFPParser.ArrayExpressionContext;
import ag223pi.dv507.a4.OFPParser.CalculationContext;
import ag223pi.dv507.a4.OFPParser.ComparissonContext;
import ag223pi.dv507.a4.OFPParser.FunctionContext;
import ag223pi.dv507.a4.OFPParser.FunctionInvocationContext;
import ag223pi.dv507.a4.OFPParser.IdContext;
import ag223pi.dv507.a4.OFPParser.IfStmtContext;
import ag223pi.dv507.a4.OFPParser.LiteralContext;
import ag223pi.dv507.a4.OFPParser.MainContext;
import ag223pi.dv507.a4.OFPParser.PrintStmtContext;
import ag223pi.dv507.a4.OFPParser.ProgramContext;
import ag223pi.dv507.a4.OFPParser.ReturnStmtContext;
import ag223pi.dv507.a4.OFPParser.VarAssignmentContext;
import ag223pi.dv507.a4.OFPParser.VarDeclarationContext;
import ag223pi.dv507.a4.OFPParser.VarInitializationContext;
import ag223pi.dv507.a4.OFPParser.WhileStmtContext;

import org.objectweb.asm.Type;

public class ByteCodeGenerator_copy extends OFPBaseVisitor<String> implements Opcodes {

    ClassWriter cw;
    GeneratorAdapter mg;
    ArrayList<String> stored_locals;
    OFPType currentType;
    String className;
    HashMap<String, VariableSymbol> variables;
    HashMap<String, FunctionSymbol> functions;
    HashMap<String, Scope> scopes;
    FunctionSymbol currentFunction;
    VariableSymbol currentVariable;
    GlobalScope globalScope;

    ByteCodeGenerator_copy(String progName, HashMap<String, VariableSymbol> variables,
            HashMap<String, FunctionSymbol> functions, GlobalScope g) {
        cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        cw.visit(V1_7, ACC_PUBLIC, progName, null, "java/lang/Object", null);
        stored_locals = new ArrayList<>();
        stored_locals.add(""); // Index should start from 1
        this.className = progName;
        this.variables = variables;
        this.functions = functions;
        this.globalScope = g;
    }

    public byte[] toByteArray() {
        return cw.toByteArray();
    }

    private void visitFunctionBody(FunctionSymbol f) {
        ParseTree ctx = f.getCTX();

        for (int i = 2; i < ctx.getChildCount(); i++) {
            visit(ctx.getChild(i));
        }
    }

    private int newVariable(ParseTree ctx) {
        String variableName = ctx.getChild(1).getText();
        OFPType ofpType = OFPType.getByName(ctx.getChild(0).getText());
        Type type = null;
        switch (ofpType) {
        case INT:
            type = Type.INT_TYPE;
            break;
        case FLOAT:
            type = Type.FLOAT_TYPE;
            break;
        case CHAR:
            type = Type.CHAR_TYPE;
            break;
        case INTARRAY:
            type = Type.getType(Object.class);
            break;
        case FLOATARRAY:
            type = Type.getType(Object.class);
            break;
        case STRING:
            type = Type.getType(Object.class);
            break;
        }
        VariableSymbol v = new VariableSymbol(variableName, ofpType, type, null);

        currentFunction.define(v);
        currentVariable = v;

        variables.put(variableName, v);
        return mg.newLocal(type);
    }

    @Override
    public String visitProgram(ProgramContext ctx) {
        Method m = Method.getMethod("void <init> ()");
        mg = new GeneratorAdapter(ACC_PUBLIC, m, null, null, cw);
        mg.loadThis();
        mg.invokeConstructor(Type.getType(Object.class), m);
        mg.returnValue();
        mg.endMethod();

        ParseTree main = null;

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof OFPParser.MainContext) {
                main = ctx.getChild(i);
            } else {
                visit(ctx.getChild(i));
            }
        }

        visit(main);

        cw.visitEnd();

        return "";
    }

    @Override
    public String visitMain(MainContext ctx) {
        Method main = Method.getMethod("void main (String[])");
        mg = new GeneratorAdapter(ACC_PUBLIC + ACC_STATIC, main, null, null, cw);

        FunctionSymbol f = functions.get("main");
        currentFunction = f;

        for (int i = 1; i < ctx.getChildCount(); i++) {
            visit(ctx.getChild(i));
        }

        mg.returnValue();
        mg.endMethod();

        return "";
    }

    @Override
    public String visitVarDeclaration(VarDeclarationContext ctx) {
        System.out.println(ctx.getText());

        return "";
    }

    @Override
    public String visitVarInitialization(VarInitializationContext ctx) {

        int index = newVariable(ctx);

        for (int i = 3; i < ctx.getChildCount(); i++) {
            visit(ctx.getChild(i));
        }

        mg.storeLocal(index);

        return "";
    }

    @Override
    public String visitVarAssignment(VarAssignmentContext ctx) {
        String variableName = ctx.getChild(0).getText();
        currentVariable = this.variables.get(variableName);

        System.out.println(currentVariable.getOFPType());
        System.out.println(stored_locals.contains(variableName));

        for (int i = 2; i < ctx.getChildCount(); i++) {
            visit(ctx.getChild(i));
        }

        // stored_locals.add(variableName);

        // mg.storeLocal(index);

        // int index = new ArrayList<String>(variables.keySet()).indexOf(variableName);
        // mg.loadLocal(index);

        return "";

    }

    @Override
    public String visitCalculation(CalculationContext ctx) {
        String calculation = "";
        Queue<ParseTree> q = new LinkedList<>();
        q.add(ctx);
        while (!q.isEmpty()) {
            ParseTree node = q.remove();
            if (node.getChildCount() > 1) {
                for (int i = 0; i < node.getChildCount(); i++) {
                    q.add(node.getChild(i));
                }
            } else {
                if (node.getChildCount() == 1) {
                    visit(node.getChild(0));
                } else {
                    calculation = node.getText();
                }
            }
        }
        if (!(calculation == "")) {
            if (calculation.equals("*")) {
                mg.math(GeneratorAdapter.MUL, Type.INT_TYPE);
            } else if (calculation.equals("/")) {
                mg.math(GeneratorAdapter.DIV, Type.INT_TYPE);
            } else if (calculation.equals("+")) {
                mg.math(GeneratorAdapter.ADD, Type.INT_TYPE);
            } else if (calculation.equals("-")) {
                mg.math(GeneratorAdapter.DIV, Type.INT_TYPE);
            }
            calculation = "";
        }

        return "";
    }

    @Override
    public String visitLiteral(LiteralContext ctx) {
        OFPType ofpType = currentVariable.getOFPType();
        String value = ctx.getText();

        switch (ofpType) {
        case INT:
            mg.push(Integer.parseInt(value));
            currentVariable.setValue(Integer.parseInt(value));
            break;
        case CHAR:
            char c = value.charAt(1);
            mg.push(c);
            currentVariable.setValue(c);
            break;
        case FLOAT:
            mg.push(Float.parseFloat(value));
            currentVariable.setValue(Float.parseFloat(value));
            break;
        case STRING:
            mg.push(value);
            currentVariable.setValue(value);
            break;
        }

        return "";
    }

    @Override
    public String visitId(IdContext ctx) {
        int pos = new ArrayList<String>(variables.keySet()).indexOf(ctx.getText());
        mg.loadLocal(pos);
        currentVariable = variables.get(ctx.getText());

        return "";
    }

    /**
     * e.g. int[] arr = new int[10]; float[] f = {9.5, 1.0, 2.2}
     */
    @Override
    public String visitArrayExpression(ArrayExpressionContext ctx) {
        if (ctx.getText().contains("new")) {
            int length = Integer
                    .parseInt(ctx.getText().substring(ctx.getText().indexOf("[") + 1, ctx.getText().indexOf("]")));
            mg.push(length);
            switch (currentVariable.getOFPType()) {
            case INTARRAY:
                mg.newArray(Type.INT_TYPE);
                break;
            case FLOATARRAY:
                mg.newArray(Type.FLOAT_TYPE);
                break;
            }
            mg.dup();
            switch (currentVariable.getOFPType()) {
            case INTARRAY:
                currentVariable.setValue(new int[length]);
                break;
            case FLOATARRAY:
                currentVariable.setValue(new float[length]);
                break;
            }
        } else if (ctx.getText().contains("[")) {
            String arrName = ctx.getText().substring(0, ctx.getText().indexOf("["));
            currentVariable = variables.get(arrName);
            int index = new ArrayList<>(variables.keySet()).indexOf(arrName) + 1;
            int i = Integer
                    .parseInt(ctx.getText().substring(ctx.getText().indexOf("[") + 1, ctx.getText().indexOf("]")));
            mg.loadLocal(index);
            mg.push(i);
            mg.arrayLoad(Type.FLOAT_TYPE);
        } else {
            int length = 0;

            for (int i = 0; i < ctx.getChildCount(); i++) {
                if (!(ctx.getChild(i).getText().equals("{")) && !(ctx.getChild(i).getText().equals(","))
                        && !(ctx.getChild(i).getText().equals("}"))) {
                    length++;
                }
            }

            mg.push(length);
            switch (currentVariable.getOFPType()) {
            case INTARRAY:
                mg.newArray(Type.INT_TYPE);
                break;
            case FLOATARRAY:
                mg.newArray(Type.FLOAT_TYPE);
                break;
            }
            mg.dup();

            int n = 0;
            switch (currentVariable.getOFPType()) {
            case INTARRAY:
                int[] iArr = new int[length];
                for (int i = 0; i < ctx.getChildCount(); i++) {
                    if (!(ctx.getChild(i).getText().equals("{")) && !(ctx.getChild(i).getText().equals(","))
                            && !(ctx.getChild(i).getText().equals("}"))) {
                        int integer = Integer.parseInt(ctx.getChild(i).getText());
                        iArr[n] = integer;
                        mg.push(n);
                        mg.push(integer);
                        switch (currentVariable.getOFPType()) {
                        case INTARRAY:
                            mg.arrayStore(Type.INT_TYPE);
                            break;
                        case FLOATARRAY:
                            mg.arrayStore(Type.FLOAT_TYPE);
                            break;
                        }
                        mg.dup();
                        n++;
                    }
                }
                currentVariable.setValue(iArr);
                break;
            case FLOATARRAY:
                float[] fArr = new float[length];
                for (int i = 0; i < ctx.getChildCount(); i++) {
                    if (!(ctx.getChild(i).getText().equals("{")) && !(ctx.getChild(i).getText().equals(","))
                            && !(ctx.getChild(i).getText().equals("}"))) {
                        float f = Float.parseFloat(ctx.getChild(i).getText());
                        fArr[n] = f;
                        mg.push(n);
                        mg.push(f);
                        switch (currentVariable.getOFPType()) {
                        case INTARRAY:
                            mg.arrayStore(Type.INT_TYPE);
                            break;
                        case FLOATARRAY:
                            mg.arrayStore(Type.FLOAT_TYPE);
                            break;
                        }
                        mg.dup();
                        n++;
                    }
                }
                currentVariable.setValue(fArr);
                break;
            }
        }

        return "";
    }

    /**
     * e.g. println(f);
     */
    @Override
    public String visitPrintStmt(PrintStmtContext ctx) {
        mg.getStatic(Type.getType(System.class), "out", Type.getType(PrintStream.class));

        for (int i = 1; i < ctx.getChildCount(); i++) {
            visit(ctx.getChild(i));
        }

        OFPType ofpType = currentVariable.getOFPType();
        String type = "";
        switch (ofpType) {
        case FLOAT:
            type = "(float)";
            break;
        case FLOATARRAY:
            type = "(float)";
            break;
        case INT:
            type = "(int)";
            break;
        case INTARRAY:
            type = "(int)";
            break;
        case CHAR:
            type = "(char)";
            break;
        case STRING:
            type = "(String)";
            break;
        }

        if (ctx.getChild(0).getText().equals("print")) {
            mg.invokeVirtual(Type.getType(PrintStream.class), Method.getMethod("void print " + type));
        } else {
            mg.invokeVirtual(Type.getType(PrintStream.class), Method.getMethod("void println " + type));
        }

        return "";
    }

    @Override
    public String visitWhileStmt(WhileStmtContext ctx) {

        return "";
    }

    @Override
    public String visitIfStmt(IfStmtContext ctx) {

        return "";
    }

    @Override
    public String visitComparisson(ComparissonContext ctx) {

        return "";
    }

    /**
     * e.g. return sum;
     */
    @Override
    public String visitReturnStmt(ReturnStmtContext ctx) {

        for (int i = 1; i < ctx.getChildCount(); i++) {
            visit(ctx.getChild(i));
        }

        return "";
    }

    /**
     * Functions other than void main()
     */
    @Override
    public String visitFunction(FunctionContext ctx) {

        OFPType ofpType = OFPType.getByName(ctx.getChild(0).getChild(0).getText());
        Type type = null;
        switch (ofpType) {
        case INT:
            type = Type.INT_TYPE;
            break;
        case FLOAT:
            type = Type.FLOAT_TYPE;
            break;
        case INTARRAY:
            type = Type.INT_TYPE;
            break;
        case FLOATARRAY:
            type = Type.FLOAT_TYPE;
            break;
        case VOIDFUNCTION:
            type = Type.VOID_TYPE;
            break;
        }
        String functionName = ctx.getChild(0).getChild(1).getText();

        FunctionSymbol f = new FunctionSymbol(functionName, ofpType, null, ctx);

        String functionBody = "";

        // Set parameters and Function body
        if (ctx.getChild(0).getChild(3) instanceof OFPParser.ParametersContext) {
            StringBuilder parameters = new StringBuilder();
            parameters.append("(");

            for (int i = 0; i < ctx.getChild(0).getChild(3).getChildCount(); i++) {
                if (ctx.getChild(0).getChild(3).getChild(i) instanceof OFPParser.DataTypeContext) {
                    parameters.append(ctx.getChild(0).getChild(3).getChild(i).getText());
                    OFPType t = OFPType.getByName(ctx.getChild(0).getChild(3).getChild(i).getText());
                    f.setParameters(
                            new VariableSymbol(ctx.getChild(0).getChild(3).getChild(i + 1).getText(), t, type, null));
                    if (!(i + 2 == ctx.getChild(0).getChild(3).getChildCount())) {
                        parameters.append(", ");
                    }
                }
            }

            parameters.append(")");

            functionBody = type + " " + functionName + parameters.toString();
        } else {
            functionBody = type + " " + functionName + "()";
        }

        f.setFunctionBody(functionBody);
        functions.put(functionName, f);

        return "";
    }

    /**
     * e.g. getSum(15,20);
     */
    @Override
    public String visitFunctionInvocation(FunctionInvocationContext ctx) {
        FunctionSymbol f = functions.get(ctx.getText().substring(0, ctx.getText().indexOf("(")));
        currentFunction = f;
        Method func = Method.getMethod(f.getFunctionBody());

        mg = new GeneratorAdapter(ACC_PRIVATE + ACC_STATIC, func, null, null, cw);

        // Set argument values
        if (ctx.getChild(2) instanceof OFPParser.ArgumentsContext) {
            ArrayList<String> arguments = new ArrayList<>();
            List<? extends Symbol> parameters = f.getParameters();

            for (int i = 0; i < ctx.getChild(2).getChildCount(); i++) {
                if (!(ctx.getChild(2).getChild(i).getText().equals(","))) {
                    arguments.add(ctx.getChild(2).getChild(i).getText());
                }
            }

            for (int i = 0; i < parameters.size(); i++) {
                OFPType ofpType = parameters.get(i).getOFPType();
                VariableSymbol v;
                int index;
                switch (ofpType) {
                case INT:
                    int n = Integer.parseInt(arguments.get(i));
                    index = mg.newLocal(Type.INT_TYPE);
                    v = new VariableSymbol(parameters.get(i).getName(), OFPType.INT, Type.INT_TYPE, null);
                    f.define(v);
                    variables.put(parameters.get(i).getName(), v);
                    mg.storeLocal(index);
                    v.setValue(n);
                    break;
                case FLOAT:
                    float fl = Float.parseFloat(arguments.get(i));
                    index = mg.newLocal(Type.FLOAT_TYPE);
                    v = new VariableSymbol(parameters.get(i).getName(), OFPType.FLOAT, Type.FLOAT_TYPE, null);
                    f.define(v);
                    variables.put(parameters.get(i).getName(), v);
                    mg.storeLocal(index);
                    v.setValue(fl);
                    break;
                case CHAR:
                    char c = arguments.get(i).charAt(0);
                    index = mg.newLocal(Type.CHAR_TYPE);
                    v = new VariableSymbol(parameters.get(i).getName(), OFPType.CHAR, Type.CHAR_TYPE, null);
                    f.define(v);
                    variables.put(parameters.get(i).getName(), v);
                    mg.storeLocal(index);
                    v.setValue(c);
                    break;
                case STRING:
                    index = mg.newLocal(Type.getType(Object.class));
                    v = new VariableSymbol(parameters.get(i).getName(), OFPType.STRING, Type.getType(Object.class),
                            null);
                    f.define(v);
                    variables.put(parameters.get(i).getName(), v);
                    mg.storeLocal(index);
                    v.setValue(parameters.get(i));
                    break;
                }
            }
        }

        // Visit function
        visitFunctionBody(f);

        mg.returnValue();
        mg.endMethod();

        currentFunction = functions.get("main");

        return "";
    }

}