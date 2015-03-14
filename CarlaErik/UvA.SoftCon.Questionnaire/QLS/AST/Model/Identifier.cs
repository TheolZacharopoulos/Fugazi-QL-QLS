﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    /// <summary>
    /// A name that refers to a question in the QL AST.
    /// </summary>
    public class Identifier : QLSNode
    {
        public string Name
        {
            get;
            private set;
        }

        internal Identifier(string name, TextPosition position)
            : base(position)
        {
            Name = name;
        }

        public override void Accept(IQLSVisitor visitor)
        {
            visitor.VisitIdentifier(this);
        }

        public override T Accept<T>(IQLSVisitor<T> visitor)
        {
            return visitor.VisitIdentifier(this);
        }

        public override string ToString()
        {
            return Name;
        }
    }
}
