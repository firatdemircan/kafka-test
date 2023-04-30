package org.fdemircan.core.feigns.models;

import lombok.Data;
import org.apache.kafka.common.protocol.types.Field;

@Data
public class KafkaSendModel {

    private String myName;
    private String myCode;

}
