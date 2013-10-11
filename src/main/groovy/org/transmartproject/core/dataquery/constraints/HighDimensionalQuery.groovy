package org.transmartproject.core.dataquery.constraints

import org.transmartproject.core.dataquery.acgh.ChromosomalSegment
import org.transmartproject.core.dataquery.acgh.Region
import org.transmartproject.core.ontology.OntologyTerm

class HighDimensionalQuery {

    /**
     * Constraints that are common to all high dimensional data.
     */
    CommonHighDimensionalQueryConstraints common

    Set<ChromosomalSegment> segments

    OntologyTerm term
}
