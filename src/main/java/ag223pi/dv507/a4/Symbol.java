package ag223pi.dv507.a4;

public interface Symbol {

	String getName();

	Scope getScope();

	OFPType getOFPType();
	// int getInsertionOrderNumber(); // index showing insertion order from 0
	// void setInsertionOrderNumber(int i);

	int hashCode();

	boolean equals(Object o);
}
