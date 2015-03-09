﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Utilities.AST;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals
{
    /// <summary>
    /// Represents a static, immutable boolean value.
    /// </summary>
    public class BooleanLiteral : Literal<bool>
    {
        private const string _true = "true";
        private const string _false = "false";

        public override bool IsValid
        {
            get
            {
                return Value.Equals(_true, StringComparison.OrdinalIgnoreCase)
                    || Value.Equals(_false, StringComparison.OrdinalIgnoreCase);
            }
        }

        public BooleanLiteral(string value, TextPosition position)
            : base(value, position)
        {
        }

        public override void Accept(IQLVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(IQLVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override DataType GetType(IDictionary<string, DataType> symbolTable)
        {
            return DataType.Boolean;
        }

        public override bool GetValue()
        {
            if (IsValid)
            {
                return Value.Equals(_true, StringComparison.OrdinalIgnoreCase);
            }
            else
            {
                throw new InvalidOperationException("Cannot return the value of an invalid expressed boolean literal.");
            }
        }
    }
}
