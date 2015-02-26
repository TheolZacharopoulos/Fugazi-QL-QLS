package org.uva.sea.ql.encoders.model;

import org.uva.sea.ql.encoders.ast.Question;

public class UIQuestion {

	private final Question question;

	private Object value;

	public UIQuestion(Question question) {
		this.question = question;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
		System.out.println(question.getName() + " " + value);
	}

	public Question getQuestion() {
		return question;
	}

}