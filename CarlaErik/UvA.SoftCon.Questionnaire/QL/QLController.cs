﻿using Antlr4.Runtime;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Building;
using UvA.SoftCon.Questionnaire.QL.Grammar;

namespace UvA.SoftCon.Questionnaire.QL
{
    public class QLController
    {
        public QuestionForm ParseQLFile(FileInfo qlFile)
        {
            if(qlFile == null) { throw new ArgumentNullException("qlFile"); }
            if(!qlFile.Exists) { throw new FileNotFoundException("Could not find file " + qlFile.FullName + "."); }

            using (var reader = qlFile.OpenText())
            {
                return ParseQLStream(reader);
            }
        }

        public QuestionForm ParseQLString(string ql)
        {
            if (ql == null) { throw new ArgumentNullException("ql"); }

            using (var reader = new StringReader(ql))
            {
                return ParseQLStream(reader);
            }
        }

        public QuestionForm ParseQLStream(TextReader reader)
        {
            if (reader == null) { throw new ArgumentNullException("reader"); }

            var inputStream = new AntlrInputStream(reader);

            var lexer = new QLLexer(inputStream);

            var tokens = new CommonTokenStream(lexer);

            var parser = new QLParser(tokens);

            var visitor = new FormVisitor();

            return visitor.Visit(parser.form());
        }
    }
}