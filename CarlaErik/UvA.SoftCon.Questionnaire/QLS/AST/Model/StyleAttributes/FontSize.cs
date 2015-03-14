﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes
{
    public class FontSize : StyleAttribute
    {
        public int Size
        {
            get;
            private set;
        }

        internal FontSize(int size, TextPosition position)
            :base(position)
        {
            Size = size;
        }

        public override string ToString()
        {
            return String.Format("{0}pt", Size);
        }
    }
}
