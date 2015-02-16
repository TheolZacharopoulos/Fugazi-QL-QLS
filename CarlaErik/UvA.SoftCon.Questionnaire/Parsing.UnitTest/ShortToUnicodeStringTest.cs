﻿using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.IO;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;

namespace UvA.SoftCon.Questionnaire.Parsing.UnitTest
{
    /// <summary>
    /// Provides test methods for the <see cref="UvA.SoftCon.Questionnaire.Parsing.ShortToUnicodeString"/> class.
    /// </summary>
    [TestClass]
    public class ShortToUnicodeStringTest
    {
        [TestMethod]
        public void TestShortToUnicodeString()
        {
            // Arrange
            AntlrInputStream inputStream = new AntlrInputStream("{99, 3, 451}");

            QLLexer lexer = new QLLexer(inputStream);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
                
            QLParser parser = new QLParser(tokens);

        }
    }
}
