﻿using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.QL;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.QL
{
    /// <summary>
    /// Checks whether literal values are valid within the bounds of their types.
    /// </summary>
    public class LiteralChecker : ASTChecker
    {
        private const string invalidLiteralMessage = "Invalid value '{0}' for literal of type '{1}'.";

        public override object Visit(IntegerLiteral literal)
        {
            if (!literal.IsValid)
            {
                Report.AddError(literal.Position, invalidLiteralMessage, literal.Value, StringEnum.GetStringValue(literal.GetType(null)));
            }
            return null;
        }

        public override object Visit(DateLiteral literal)
        {
            if (!literal.IsValid)
            {
                Report.AddError(literal.Position, invalidLiteralMessage, literal.Value, StringEnum.GetStringValue(literal.GetType(null)));
            }
            return null;
        }
    }
}
