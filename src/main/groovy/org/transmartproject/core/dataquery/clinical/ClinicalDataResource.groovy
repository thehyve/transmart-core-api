package org.transmartproject.core.dataquery.clinical

import org.transmartproject.core.dataquery.Patient
import org.transmartproject.core.dataquery.TabularResult
import org.transmartproject.core.doc.Experimental
import org.transmartproject.core.exceptions.InvalidArgumentsException
import org.transmartproject.core.querytool.QueryResult

@Experimental
public interface ClinicalDataResource {

    @Experimental
    TabularResult<ClinicalVariableColumn, PatientRow> retrieveData(QueryResult patientSet,
                                                                   List<ClinicalVariable> variables)

    @Experimental
    TabularResult<ClinicalVariableColumn, PatientRow> retrieveData(List<QueryResult> patientSets,
                                                                   List<ClinicalVariable> variables)

    @Experimental
    TabularResult<ClinicalVariableColumn, PatientRow> retrieveData(Set<Patient> patients,
                                                                   List<ClinicalVariable> ontologyTerms)

    @Experimental
    ClinicalVariable createClinicalVariable(Map<String, Object> parameters,
                                            String type) throws InvalidArgumentsException

    /**
     * Returns the number of patients from the patient set for which the system has clinical data.
     * @param patientSet    The patientset to query.
     * @return The number of patients from the patient set for which the system has clinical data. 
     */
    int getPatientCountWithClinicalData(QueryResult patientSet)
}
