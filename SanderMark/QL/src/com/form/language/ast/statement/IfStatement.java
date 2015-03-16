package com.form.language.ast.statement;

import java.util.List;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.error.Error;
import com.form.language.error.QLToken;
import com.form.language.gui.components.FormComponent;
import com.form.language.gui.components.GUIBuilder;
import com.form.language.memory.Context;

public class IfStatement extends Statement {
    private Expression conditions;
    private List<Statement> thenStatements;

    // BooleanExpression, get result and cast to boolean
    public IfStatement(Expression conditions, List<Statement> thenStatements, QLToken tokenInfo) {
	super(tokenInfo);
	this.conditions = conditions;
	this.thenStatements = thenStatements;
    }

    @Override
    public Type getType(Context context) {
	for (Statement s : thenStatements) {
	    s.getType(context);
	}
	if (conditions.getType(context).isBoolType()) {
	    return new BoolType();
	} else {
	    context.addError(new Error(tokenInfo, "The conditions in an if statement should evaluate to a Boolean"));
	    return new ErrorType();
	}
    }

    @Override
    public void initMemory(Context mem) {
    }

    @Override
    public void createGUIComponent(GUIBuilder guiBuilder, FormComponent formGUI, Context rm) {
	guiBuilder.setShowCondition(conditions);
	for (Statement s : this.thenStatements) {
	    s.createGUIComponent(guiBuilder, formGUI, rm);
	}
    };

}