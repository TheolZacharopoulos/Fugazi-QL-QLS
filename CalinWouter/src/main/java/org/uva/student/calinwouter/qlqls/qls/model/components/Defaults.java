package org.uva.student.calinwouter.qlqls.qls.model.components;

import lombok.Data;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Data
public class Defaults {
    private final Map<TypeDescriptor, Map<String, Object>> defaultStyleSheetSettings;

    public Defaults(Map defaultStyleSheetSettings) {
        this.defaultStyleSheetSettings = (Map<TypeDescriptor, Map<String, Object>>)
                defaultStyleSheetSettings;
    }
}
