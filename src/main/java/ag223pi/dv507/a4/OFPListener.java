// Generated from /Users/mnktech/Documents/School/4DV507/main/src/main/java/ag223pi/dv507/a2/OFP.g4 by ANTLR 4.8

package ag223pi.dv507.a4;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OFPParser}.
 */
public interface OFPListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OFPParser#program}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterProgram(OFPParser.ProgramContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#program}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitProgram(OFPParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#main}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterMain(OFPParser.MainContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#main}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitMain(OFPParser.MainContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#mainDeclaration}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterMainDeclaration(OFPParser.MainDeclarationContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#mainDeclaration}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitMainDeclaration(OFPParser.MainDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#function}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterFunction(OFPParser.FunctionContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#function}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitFunction(OFPParser.FunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#functionDeclaration}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(OFPParser.FunctionDeclarationContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#functionDeclaration}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(OFPParser.FunctionDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#parameters}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterParameters(OFPParser.ParametersContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#parameters}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitParameters(OFPParser.ParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#arguments}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterArguments(OFPParser.ArgumentsContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#arguments}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitArguments(OFPParser.ArgumentsContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#dataType}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterDataType(OFPParser.DataTypeContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#dataType}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitDataType(OFPParser.DataTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#id}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterId(OFPParser.IdContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#id}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitId(OFPParser.IdContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#literal}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterLiteral(OFPParser.LiteralContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#literal}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitLiteral(OFPParser.LiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#statement}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterStatement(OFPParser.StatementContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#statement}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitStatement(OFPParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#varDeclaration}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(OFPParser.VarDeclarationContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#varDeclaration}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(OFPParser.VarDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#varInitialization}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterVarInitialization(OFPParser.VarInitializationContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#varInitialization}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitVarInitialization(OFPParser.VarInitializationContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#varAssignment}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterVarAssignment(OFPParser.VarAssignmentContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#varAssignment}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitVarAssignment(OFPParser.VarAssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#printStmt}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(OFPParser.PrintStmtContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#printStmt}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(OFPParser.PrintStmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#whileStmt}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(OFPParser.WhileStmtContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#whileStmt}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(OFPParser.WhileStmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#ifStmt}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterIfStmt(OFPParser.IfStmtContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#ifStmt}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitIfStmt(OFPParser.IfStmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#elseifStmt}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterElseifStmt(OFPParser.ElseifStmtContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#elseifStmt}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitElseifStmt(OFPParser.ElseifStmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#elseStmt}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterElseStmt(OFPParser.ElseStmtContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#elseStmt}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitElseStmt(OFPParser.ElseStmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#returnStmt}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(OFPParser.ReturnStmtContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#returnStmt}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(OFPParser.ReturnStmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#expression}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterExpression(OFPParser.ExpressionContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#expression}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitExpression(OFPParser.ExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#arrayExpression}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterArrayExpression(OFPParser.ArrayExpressionContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#arrayExpression}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitArrayExpression(OFPParser.ArrayExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#functionInvocation}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterFunctionInvocation(OFPParser.FunctionInvocationContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#functionInvocation}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitFunctionInvocation(OFPParser.FunctionInvocationContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#comparisson}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterComparisson(OFPParser.ComparissonContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#comparisson}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitComparisson(OFPParser.ComparissonContext ctx);

	/**
	 * Enter a parse tree produced by {@link OFPParser#calculation}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterCalculation(OFPParser.CalculationContext ctx);

	/**
	 * Exit a parse tree produced by {@link OFPParser#calculation}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitCalculation(OFPParser.CalculationContext ctx);
}