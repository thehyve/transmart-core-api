package org.transmartproject.core.jobs.providers

import groovy.transform.Immutable
import org.transmartproject.core.doc.Experimental
import org.transmartproject.core.doc.SPI

@Immutable
@SPI
@Experimental
class JobDescriptor {
    /**
     * The name of this job.
     * This should match the regex [0-9a-z_]{1,50}
     */
    String name

    /**
     * A user readable name for this job, to be displayed to the user.
     */
    String userReadableName
}
