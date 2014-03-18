package org.transmartproject.core.jobs

import org.transmartproject.core.doc.Experimental
import org.transmartproject.core.exceptions.InvalidArgumentsException
import org.transmartproject.core.exceptions.NoSuchResourceException

@Experimental
interface JobsResource {

    Set<Job> getJobs()

    Job getJobByName(String providerName, String jobName) throws NoSuchResourceException

    /**
     * Search for job executions. Returned ordered by last modification.
     *
     * @param params map with the following keys: <code>job</code>,
     * <code>user</code>, <code>limit</code>, <code>page</code>.
     * @return
     */
    List<JobExecution> searchJobExecution(Map params) throws InvalidArgumentsException

    // move to Job?
    JobExecution getJobExecution(String providerName,
                                 String jobName,
                                 String jobExecutionId)

    JobExecution getJobExecution(Long globalId)

}
