package org.transmartproject.core.jobs.providers

import org.transmartproject.core.doc.Experimental
import org.transmartproject.core.doc.SPI
import org.transmartproject.core.exceptions.InvalidArgumentsException
import org.transmartproject.core.exceptions.NoSuchResourceException
import org.transmartproject.core.jobs.Job
import org.transmartproject.core.jobs.JobExecution

@SPI
@Experimental
interface JobProvider {

    /**
     * The name for this provider.
     * This should match the regex [0-9a-z_]{1,50}.
     *
     * @return the name for this provider
     */
    String getName()

    /**
     * Gets a set of all the jobs that this provider makes available, in some
     * details about them, in the form of {@link JobDescriptor}s.
     * @return the set of job descriptors
     */
    Set<JobDescriptor> getJobDescriptors()

    /**
     * Fetch the job descriptor for a given job. Right now, this only provides
     * the user readable name as extra information.
     *
     * @param jobName the name of the job
     * @return the job descriptor
     * @throws NoSuchResourceException if the provider has no job with such name
     */
    JobDescriptor getDescriptorForJob(String jobName)
            throws NoSuchResourceException

    /**
     * Gets the path corresponding to {@link Job#getInitialPath()}.
     *
     * @param jobName the name of the job
     * @return a page location, minus the context path
     * @throws InvalidArgumentsException if the jobName does not match a job
     * that this provider makes available
     */
    String getJobInitialPath(String jobName) throws InvalidArgumentsException

    /**
     * Creates a new job execution and returns the part of the
     * {@link JobExecution} object that is managed by the provider.
     *
     * @param parameters the job execution parameters
     * @param jobName the name of the job
     * @return the partial {@link JobExecution} object
     * @throws InvalidArgumentsException if the parameters map includes bad
     * or missing parameters
     */
    JobExecutionProvided createExecution(Map<String, Serializable> parameters,
                                         String jobName)
            throws InvalidArgumentsException

    /**
     * A {@link JobExecutionProvided} object. The implementation doesn't have to
     * provide always the same object, but, depending on the circumstances, it
     * may be convenient to canonicalize the mapping.
     *
     * @param jobName the name of the job
     * @param id the id of the job execution
     * @return the partial {@link JobExecution} object
     * @throws NoSuchResourceException if the provider doesn't know about
     * this job or it has already finished. It's possible that for some reason
     * the state as seen by the job provider becomes inconsistent with the
     * state seen by {@link JobExecutionsManager}, which would think . In this
     * case, this method should throw this exception; the caller may then
     * synchronize its state by marking the job execution as
     * {@link org.transmartproject.core.jobs.JobExecutionState#DEFUNCT}.
     */
    JobExecutionProvided getExecution(String jobName, String id)
            throws NoSuchResourceException
}
