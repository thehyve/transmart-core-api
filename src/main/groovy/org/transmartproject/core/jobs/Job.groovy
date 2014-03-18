package org.transmartproject.core.jobs

import org.transmartproject.core.doc.Experimental
import org.transmartproject.core.exceptions.InvalidArgumentsException

@Experimental
interface Job {

    /**
     * The name of the job. This must be unique among the provider's jobs.
     *
     * Does not exceed 50 code units and can only contain the characters
     * [a-zA-Z0-9_].
     *
     * @return the job name
     */
    String getName()

    /**
     * The name of this job's provider.
     *
     * Does not exceed 50 code units and can only contain the characters
     * [a-z0-9_].
     *
     * @return name of the job provider.
     */
    String getProviderName()

    /**
     * A user friendly name for this job. Should be reasonably short; not a
     * description.
     *
     * @return a user readable name for the job
     */
    String getUserReadableName()

    /**
     * Get the path the user should be forwarded to in order to fill in the
     * parameters and be able to start a job.
     *
     * @return the path minus the context path
     */
    String getInitialPath()

    /**
     * Creates a new instance of this job. The newly created job instance will
     * be started on the {@link JobExecutionState#CREATED} state. You will have
     * to call {@link JobExecution#start()} to actually schedule the execution
     * to be started.
     *
     * @param parameters the job parameters. These are job specific
     * @return the resulting job execution
     * @throws InvalidArgumentsException if parameters are invalid or missing
     * for this job
     */
    JobExecution createJobExecution(Map<String, Serializable> parameters)
            throws InvalidArgumentsException
}
