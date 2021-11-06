package ag223pi.dv507.a4;

import java.util.*;

public interface Scope {

     /**
      * Will return "global", the function name or "block" if the scope comes from a
      * conditional.
      */
     String getName();

     /**
      * Returns either the global scope or the name of the outer function. If it's
      * the global scope, it will return null.
      */
     Scope getEnclosingScope();

     /**
      * Defines a symbol in the scope by mapping IDs to symbol records. Throws
      * exception if the Symbol name (identifier) is already in this scope. Preservs
      * the insertion order.
      */
     boolean define(Symbol s);

     /**
      * If idenfitier is defined within this specific scope, get it's symbol record.
      * Otherwise, it checks the parent scope. Otherwise, it returns null.
      * 
      * @param name Symbol name
      * @return The symbol (if found) or null
      */
     Symbol getSymbol(String name);

     /**
      * Checks identifier is defined within this specific scope, not parent scope.
      * 
      * @param name Symbol name
      * @return True if symbol exists, otherwise false
      */
     boolean checkForDuplicate(String name);

     /**
      * Return the symbols defined within this scope.
      */
     List<? extends Symbol> getAllSymbols();

     /**
      * Number of symbols in this specific scope
      */
     int getNumberOfSymbols();

     /**
      * Add a nested scope to this scope.
      */
     void nest(Scope scope);

     /**
      * Returns a list of scopes nested within this scope.
      */
     List<Scope> getNestedScopes();

     /**
      * Returns a list of outer scopes. If it's the global scope, it returns null.
      */
     List<Scope> getParentScopes();

     /**
      * Print method that displays the content (name and type of each symbol)
      */
     String toString();

}
