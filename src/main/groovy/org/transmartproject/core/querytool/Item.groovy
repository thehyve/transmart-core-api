package org.transmartproject.core.querytool

import groovy.transform.Immutable

@Immutable
class Item {

    /**
     * A concept key mapping to a an ontology term.
     */
    String conceptKey

    /**
     * Type of item
     */
    String type

    /**
     * The constraint, or null.
     */
    Constraint constraint
}