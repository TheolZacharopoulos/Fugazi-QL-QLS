﻿using Antlr4.Runtime;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Building;
using UvA.SoftCon.Questionnaire.QLS.Grammar;

namespace UvA.SoftCon.Questionnaire.QLS
{
    public class QLSController
    {
        public StyleSheet ParseQLFile(FileInfo qlFile)
        {
            if (qlFile == null) { throw new ArgumentNullException("qlFile"); }
            if (!qlFile.Exists) { throw new FileNotFoundException("Could not find file " + qlFile.FullName + "."); }

            using (var reader = qlFile.OpenText())
            {
                return ParseQLSStream(reader);
            }
        }

        public StyleSheet ParseQLSString(string ql)
        {
            if (ql == null) { throw new ArgumentNullException("ql"); }

            using (var reader = new StringReader(ql))
            {
                return ParseQLSStream(reader);
            }
        }

        public StyleSheet ParseQLSStream(TextReader reader)
        {
            if (reader == null) { throw new ArgumentNullException("reader"); }

            var inputStream = new AntlrInputStream(reader);

            var lexer = new QLSLexer(inputStream);

            var tokens = new CommonTokenStream(lexer);

            var parser = new QLSParser(tokens);

            var visitor = new StyleSheetVisitor();

            //return visitor.Visit(parser.form());
            throw new NotImplementedException();
        }
    }
}
