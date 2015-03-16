﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.Validation;
using UvA.SoftCon.Questionnaire.QL;
using UvA.SoftCon.Questionnaire.QL.AST.Model;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.QL
{
    public abstract class ASTChecker : QLVisitor<object>
    {
        protected ValidationReport Report 
        {
            get;
            set;
        }

        public void Validate(QuestionForm form, ValidationReport report)
        {
            Report = report;
            Visit(form);
        }
    }
}
