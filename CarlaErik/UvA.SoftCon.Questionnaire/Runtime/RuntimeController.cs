﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types;
using UvA.SoftCon.Questionnaire.Runtime.Validation;
using UvA.SoftCon.Questionnaire.Runtime.Validation.ErrorReporting;

namespace UvA.SoftCon.Questionnaire.Runtime
{
    public class RuntimeController
    {
        public ValidationReport Validate(QuestionForm form)
        {
            if (form == null) { throw new ArgumentNullException("form"); }

            var validator = new QLValidator();

            return validator.Validate(form);
        }

        public IDictionary<string, Value> Interpretet(QuestionForm form, IDictionary<string, Value> context)
        {
            if (form == null) { throw new ArgumentNullException("form"); }
            if (context == null) { throw new ArgumentNullException("context"); }

            var interpreter = new Interpreter();

            interpreter.Interpretet(form, context);

            return interpreter.AvailableQuestions;
        }
    }
}
