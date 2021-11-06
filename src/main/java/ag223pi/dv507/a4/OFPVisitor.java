// Generated from /Users/mnktech/Documents/School/4DV507/main/src/main/java/ag223pi/dv507/a2/OFP.g4 by ANTLR 4.8

package ag223pi.dv507.a4;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link OFPParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface OFPVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link OFPParser#program}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(OFPParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#main}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(OFPParser.MainContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#mainDeclaration}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainDeclaration(OFPParser.MainDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#function}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(OFPParser.FunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#functionDeclaration}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(OFPParser.FunctionDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#parameters}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(OFPParser.ParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#arguments}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(OFPParser.ArgumentsContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#dataType}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(OFPParser.DataTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#id}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(OFPParser.IdContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#literal}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(OFPParser.LiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#statement}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(OFPParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#varDeclaration}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(OFPParser.VarDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#varInitialization}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarInitialization(OFPParser.VarInitializationContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#varAssignment}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssignment(OFPParser.VarAssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#printStmt}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(OFPParser.PrintStmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#whileStmt}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(OFPParser.WhileStmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#ifStmt}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(OFPParser.IfStmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#elseifStmt}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseifStmt(OFPParser.ElseifStmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#elseStmt}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStmt(OFPParser.ElseStmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#returnStmt}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(OFPParser.ReturnStmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#expression}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(OFPParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#arrayExpression}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpression(OFPParser.ArrayExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#functionInvocation}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionInvocation(OFPParser.FunctionInvocationContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#comparisson}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisson(OFPParser.ComparissonContext ctx);

	/**
	 * Visit a parse tree produced by {@link OFPParser#calculation}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculation(OFPParser.CalculationContext ctx);
}