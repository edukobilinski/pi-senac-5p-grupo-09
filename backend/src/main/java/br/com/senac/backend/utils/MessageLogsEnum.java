package br.com.senac.backend.utils;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public enum MessageLogsEnum {

    /*
     * D: Debug
     * E: Error
     * I: Info
     *
     * RSC: Resource
     * SRV: Service
     */

    RSC_0001D("RSC_0001D", "Request Received! "),
    RSC_0002D("RSC_0002D", "Request Processed! "),
    RSC_0003D("RSC_0003D", "Object Created! "),
    RSC_0004D("RSC_0004D", "Object Deleted! "),
    RSC_0005D("RSC_0005D", "Object Updated! "),
    SRV_0001D("SRV_0001D", "Service Layer Processed Ok "),

    SRV_0001E("SRV_0001E", "Resource not found. Id "),
    SRV_0002E("SRV_0002E", "Data Integrity Violation Exception: "),
    SRV_0003E("SRV_0003E", "Resource not found, List Empty. Id ");

    private String code;
    private String description;

    MessageLogsEnum(String description) {
        this(description, description);
    }

    MessageLogsEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String logContext(String classe, String thread) {
        return code + " - " + classe + " - " + thread + " - " + description + " - " + LocalDateTime.now().toString();
    }

    public String getObjDescription(String objDescription) {
        return code + " - " + description + objDescription;
    }

    public String getDescriptionAndException(String e) {
        return code + " - " + description + e;
    }
}
