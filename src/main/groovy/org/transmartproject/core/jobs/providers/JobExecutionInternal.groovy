package org.transmartproject.core.jobs.providers

import org.transmartproject.core.doc.Experimental
import org.transmartproject.core.doc.SPI
import org.transmartproject.core.jobs.JobExecution
import org.transmartproject.core.jobs.JobExecutionState

/**
 * Extends {@link JobExecution} with methods for internal consumption.
 */
@SPI
@Experimental
interface JobExecutionInternal extends JobExecution {

    void setState(JobExecutionState newState) throws IllegalStateException

    void setLatestStepDescription(String newDescription) throws IllegalStateException
}
