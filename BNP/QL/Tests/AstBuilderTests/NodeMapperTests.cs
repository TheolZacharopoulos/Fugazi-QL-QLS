﻿using System;
using System.Collections;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using QL.Grammars;
using QL.Model;

namespace Tests.AstBuilderTests
{
    [TestClass]
    public class AstBuilderTests : QLTestBase
    {
        protected QLListener Listener;

        [TestMethod]
        public void ControlBlockChildrenAssignment()
        {
            string input = @"form ExampleBlock {
                if (3==-11){}
	            else {
                     if (3==12)
                        {}
                     else {};
                     };
                }
            ";
            Build(input);

            Listener = new QLListener();

            Parser.AddParseListener(Listener);
            var formBlock = Parser.formBlock();
            Listener.AstExists();

        }
    }
}
