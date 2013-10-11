package org.transmartproject.core.dataquery.vcf

class VcfValuesImpl implements VcfValues {
    String chromosome
    Long position
    String rsId
    String mafAllele
    Double maf
    Double qualityOfDepth
    String ref
    String alt
    Map<String, String> additionalInfo
}
