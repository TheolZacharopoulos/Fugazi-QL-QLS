﻿using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using QL.Errors;
using QL.Grammars;
using QL.Infrastructure;
using QL.Model;
using QL.Evaluation;


namespace QL
{
    class Program
    {
        static void Main(string[] args)
        {
            while (true)
            {
                Console.WriteLine("Please enter QL syntax commit by Ctrl+Z. Quit by Ctrl+C");
                Console.WriteLine();

                Stream inputStream = Console.OpenStandardInput();

                AstHandler ast = new AstHandler(inputStream);

                if (ast.BuildAST())
                {
                    foreach (QLException e in ast.ASTHandlerExceptions)
                        {
                            Console.WriteLine(e.ToString());
                        }
                }

                ast.CheckType();

                if (ast.ASTHandlerExceptions.Any())
                {
                    foreach (QLError e in ast.ASTHandlerExceptions)
                    {
                        Console.WriteLine(e.ToString());
                    }
                    continue;
                }

                ast.Evaluate();

                if (ast.ASTHandlerExceptions.Any())
                {
                    foreach (QLError e in ast.ASTHandlerExceptions)
                    {
                        Console.WriteLine(e.ToString());
                    }
                    continue;
                }

                Console.Write("Hit <return> to restart");
                Console.ReadLine();
                Console.Clear();
            }
        }
    }
}