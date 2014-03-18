package org.transmartproject.core.jobs

import org.transmartproject.core.doc.Experimental
import org.transmartproject.core.users.User

@Experimental
public interface JobExecution {

    /**
     * A global identifier for this job execution. This is unique across all
     * providers and jobs.
     *
     * @return a global identifier for this job execution
     */
    Long getId()

    /**
     * An identifier for the job execution. This must be unique for this job,
     * but it doesn't need to be globally unique for across providers or even
     * jobs.
     *
     * This should match the regex [a-z0-9_]{1,50}.
     *
     * @return the identifier
     */
    String getLocalId()

    /**
     * Convenience method returning the equivalent of
     * <code>"${user.username}-${job.providerName}-${job.name}-${id}"</code>.
     *
     * @return the job id enriched with the username, job name and its provider
     */
    String getFriendlyId()

    /**
     * The user that started this job execution.
     * @return
     */
    User getUser()

    /**
     * The job this job execution is an instance of.
     *
     * @return the job for this job execution
     */
    Job getJob()

    /**
     * Fetch the parameters this job was created with. May be <code>null</code>.
     *
     * @return the parameters this job execution was created with.
     */
    Map<String, Serializable> getParameters()

    /**
     * Get the current state of this job execution.
     *
     * @return the state of this job execution
     */
    JobExecutionState getState()

    /**
     * Get a description of the step currently running or, if the job is not
     * running anymore, the last step before it finished.
     *
     * Should be a user friendly string. Can be null if no step has been run yet
     * or if the job provider does not provide this information.
     *
     * @return a user friendly description of the last step run.
     */
    String getLatestStepDescription()

    /**
     * Requests that this job execution be started.
     *
     * This method should return quickly.
     *
     * The status should transition into {@link JobExecutionState#RUNNING} or
     * {@link JobExecutionState#ERRORED}, though it may take an unspecified
     * amount of time for this to occur.
     *
     * @throws IllegalStateException if the job state is not
     * {@link JobExecutionState#CREATED}
     */
    void start() throws IllegalStateException

    /**
     * Requests that this job execution be cancelled. This is not guaranteed to
     * be honored.
     *
     * This method should return quickly.
     *
     * If the cancellation is successful, the state may change into
     * {@link JobExecutionState#CANCELLED}, though it may take an unspecified
     * amount of time for this to occur, if at all.
     *
     * @throws IllegalStateException if the job state is not
     * {@link JobExecutionState#RUNNING}
     */
    void requestCancellation() throws IllegalStateException

    /**
     * Get the path the user should be forwarded to in order to see the results.
     *
     * @throws IllegalStateException if the job state is not
     * {@link JobExecutionState#FINISHED}.
     */
    String getResultPath() throws IllegalStateException
}
