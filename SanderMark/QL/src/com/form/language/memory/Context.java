package com.form.language.memory;

import java.util.Iterator;
import java.util.List;

import com.form.language.ast.expression.Expression;
import com.form.language.ast.expression.literal.IdLiteral;
import com.form.language.ast.type.ErrorType;
import com.form.language.ast.type.Type;
import com.form.language.ast.values.GenericValue;
import com.form.language.error.Error;
import com.form.language.error.ErrorCollector;
import com.form.language.gui.components.QuestionComponent;

public class Context {
    private IdValues memory;
    private ConditionalCollection ifConditions;
    private IdReferences idReferences;
    private IdCollection globalIdList;
    private ErrorCollector errors;
    private IdDeclarations declarations;

    public Context() {
	this.memory = new IdValues();
	this.ifConditions = new ConditionalCollection();
	this.idReferences = new IdReferences();
	this.globalIdList = new IdCollection();
	this.declarations = new IdDeclarations();
	this.errors = new ErrorCollector();
    }

    public void addDependantQuestion(Expression condition, QuestionComponent question) {
	this.ifConditions.add(condition, question);
    }

    public List<QuestionComponent> getDependantQuestions(Expression exp) {
	return this.ifConditions.get(exp);
    }

    public void addReference(IdCollection references, Expression value) {
	this.idReferences.putAll(references, value);
    }

    public Iterator<Expression> getReferencingExpressions(String id) {
	List<Expression> dependencies = idReferences.get(id);
	return dependencies.iterator();
    }

    public void setValue(String key, GenericValue<?> value) {
	this.memory.put(key, value);
    }

    public GenericValue<?> getValue(String s) {
	return this.memory.get(s);
    }

    public void addId(IdLiteral id) {
	if (id.IsReference()) {
	    this.globalIdList.addId(id);
	}
	this.declarations.put(id.name, id);
    }

    public Type getIdType(IdLiteral id) {
	IdLiteral declaration = this.declarations.get(id.name);
	if (declaration == null) {
	    this.addError(new Error(id.tokenInfo, "Undeclared variable reference"));
	    return new ErrorType();
	}
	return declaration.getType(this);
    }

    public Boolean hasErrors() {
	return !errors.isEmpty();
    }

    public void addError(Error e) {
	this.errors.add(e);
    }

    public String getErrors() {
	return errors.toString();
    }
}