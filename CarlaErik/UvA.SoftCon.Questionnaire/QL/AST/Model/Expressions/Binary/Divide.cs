﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Common.AST;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Binary
{
    public class Divide : BinaryExpression
    {
        internal Divide(Operation operation, Expression left, Expression right, TextPosition position)
            : base(operation, left, right, position) {}

        public override T Accept<T>(IQLVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override DataType GetType(IDictionary<string, DataType> symbolTable)
        {
            return DataType.Integer;
        }

        public override bool OperandTypesAreValid(DataType leftType, DataType rightType)
        {
            return (leftType == DataType.Integer && rightType == DataType.Integer);
        }
    }
}
