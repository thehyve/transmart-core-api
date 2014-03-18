package org.transmartproject.core.jobs.providers

import org.transmartproject.core.doc.Experimental
import org.transmartproject.core.doc.SPI
import org.transmartproject.core.exceptions.NoSuchResourceException
import org.transmartproject.core.jobs.JobExecution

/**
 * Entry point for interactions of job providers with the runtime.
 */
@SPI
@Experimental
interface JobsRegistry {

    void registerJobProvider(JobProvider jobProvider)

    Set<JobProvider> getProviders()

    JobProvider getJobProvider(String name) throws NoSuchResourceException
}
