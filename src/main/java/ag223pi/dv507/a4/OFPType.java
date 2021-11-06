package ag223pi.dv507.a4;

import java.util.*;

public enum OFPType {
    VOIDFUNCTION("void"), INT("int"), BOOLEAN("bool"), CHAR("char"), FLOAT("float"), STRING("string"),
    INTARRAY("int[]"), FLOATARRAY("float[]"), CHARARRAY("char[]");

    private static final HashMap<String, OFPType> MAP = new HashMap<String, OFPType>();

    private String value;

    private OFPType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static OFPType getByName(String name) {
        return MAP.get(name);
    }

    static {
        for (OFPType field : OFPType.values()) {
            MAP.put(field.getValue(), field);
        }
    }
}
