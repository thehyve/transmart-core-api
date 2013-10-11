package org.transmartproject.core.dataquery.constraints

import org.transmartproject.core.dataquery.acgh.ChromosomalSegment
import org.transmartproject.core.dataquery.acgh.Region

class ACGHRegionQuery extends HighDimensionalQuery {

    /**
     * If not null, limit the query to the given set of regions.
     */
    Set<Region> regions

}
