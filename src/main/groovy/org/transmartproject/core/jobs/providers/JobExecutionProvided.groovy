package org.transmartproject.core.jobs.providers

import org.transmartproject.core.doc.Experimental
import org.transmartproject.core.doc.SPI

/**
 * Represents the part of the
 * {@link org.transmartproject.core.jobs.JobExecution} under the control of the
 * provider.
 */
@SPI
@Experimental
interface JobExecutionProvided {

    /**
     * An identifier for the job execution. This must be unique for this job,
     * but it doesn't need to be globally unique for across providers or even
     * jobs.
     *
     * The identifier should match the regex [a-z0-9_]{1,50}.
     *
     * @return the identifier
     */
    String getLocalId()

    /**
     * Requests that this job execution be started.
     *
     * @throws IllegalStateException if the job state is not
     * {@link org.transmartproject.core.jobs.JobExecutionState#CREATED}
     */
    void start() throws IllegalStateException

    /**
     * Requests that this job execution be cancelled. This is not guaranteed to
     * be honored.
     *
     * This method should return immediately.
     *
     * @throws IllegalStateException if the job state is not
     * {@link org.transmartproject.core.jobs.JobExecutionState#RUNNING}
     */
    void requestCancellation() throws IllegalStateException

    /**
     * Get the path the user should be forwarded to in order to see the results.
     *
     * @return the path minus the context path
     * @throws IllegalStateException if the job state is not
     * {@link org.transmartproject.core.jobs.JobExecutionState#FINISHED}.
     */
    String getResultPath() throws IllegalStateException
}
