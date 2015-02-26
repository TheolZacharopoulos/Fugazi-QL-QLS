package org.uva.sea.ql.encoders.service;

import java.io.IOException;

import org.uva.sea.ql.encoders.ast.Questionnaire;

/**
 * Service for parsing questionnaire input files.
 */
public interface QuestionnaireParsingService {

	/**
	 * Parses the input file and creates a questionnaire.
	 * 
	 * @param location
	 *            the location of the input file.
	 * @return The {@link Questionnaire} that was parsed from the input file.
	 */
	Questionnaire parse(String location) throws IOException;

}