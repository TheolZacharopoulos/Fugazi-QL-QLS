﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.Common.AST.Building;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.Grammar;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Building
{
    internal class QuestionReferenceVisitor : QLSBaseVisitor<QuestionReference>
    {
        public override QuestionReference VisitQuestionReference(QLSParser.QuestionReferenceContext context)
        {
            Identifier id = new Identifier(context.ID().GetText(), context.GetTextPosition());
            var styleAttributes = new List<StyleAttribute>();

            foreach (var styleAttributeContext in context.style_attr())
            {
                styleAttributes.Add(styleAttributeContext.Accept(new StyleAttributeVisitor()));
            }

            return new QuestionReference(id, styleAttributes, context.GetTextPosition());
        }
    }
}
