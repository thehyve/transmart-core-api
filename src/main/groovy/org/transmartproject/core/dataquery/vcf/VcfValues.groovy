package org.transmartproject.core.dataquery.vcf

interface VcfValues {
    String getChromosome()
    Long getPosition()
    String getRsId()
    String getMafAllele()
    Double getMaf()
    Double getQualityOfDepth()
    String getRef()
    String getAlt()
    Map<String, String> getAdditionalInfo()
}
