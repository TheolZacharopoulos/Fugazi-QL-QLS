package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;

import java.util.LinkedList;
import java.util.List;

public class TypeCheckResults {
    private final List<String> errors, warnings;

    private void addError(String s) {
        this.errors.add(s);
    }

    public void addErrorTypeIsNotOfType(TypeDescriptor typeDescriptor) {
        addError("Type is not of type: " + typeDescriptor + ".");
    }

    private void addWarning(final String s) {
        this.warnings.add(s);
    }

    public TypeCheckResults() {
        this.errors = new LinkedList<String>();
        this.warnings = new LinkedList<String>();
    }

    public void addNotDeclaredError(final String identifier) {
        addError(identifier + " is not declared.");
    }

    public void addTwoQuestionsSameTypeError(final String variable) {
        addError("Two questions with the same identifier and a different type was found for variable: " + variable);
    }

    public void addLabelFoundTwiceWarning(final String fieldLabel) {
        addWarning("Label " + fieldLabel + " found twice.");
    }
}
