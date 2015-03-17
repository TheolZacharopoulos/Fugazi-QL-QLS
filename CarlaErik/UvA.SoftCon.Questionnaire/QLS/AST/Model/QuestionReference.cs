﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    public class QuestionReference : QLSNode
    {
        public Identifier Id
        {
            get;
            private set;
        }

        public IEnumerable<StyleAttribute> StyleAttributes
        {
            get;
            private set;
        }

        internal QuestionReference(Identifier id, IEnumerable<StyleAttribute> styleAttributes, TextPosition position)
            : base(position)
        {
            Id = id;
            StyleAttributes = styleAttributes;
        }

        public override T Accept<T>(IQLSVisitor<T> visitor)
        {
            return visitor.VisitQuestionReference(this);
        }
    }
}
