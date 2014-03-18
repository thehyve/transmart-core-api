package org.transmartproject.core.jobs

import org.transmartproject.core.doc.Experimental

@Experimental
enum JobExecutionState {

    CREATED,    /* the job has been created, but it has not yet been started */
    RUNNING,    /* the job is running */
    CANCELLED,  /* the job finished due to a cancellation */
    FINISHED,   /* the job finished normally */
    ERRORED,    /* the job finished with an error */
    EXPIRED,    /* the job finished normally, but its results are not available anymore */
    DEFUNCT,    /* the job cannot be found anymore, but its previous state was not FINISHED */

}
