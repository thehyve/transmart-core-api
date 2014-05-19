package org.transmartproject.core.querytool

import groovy.transform.Immutable

@Immutable
class ConstraintByVcf implements Constraint {

    /**
     * The position to put a condition on
     */
    String position

    /**
     * The type of comparison
     */
    Type type

    /**
     * The value to compare with
     */
    Value value

    enum Value {
        WILDCARD,
        MUTATED
    }

    enum Type {
        STATUS,
        VALUE,
        ZYGOSITY
    }
}