﻿using AST;
using Nodes = AST.Nodes;
using AST.Nodes.Expressions;
using Evaluation;
using Evaluation.Values;
using QLGui.ValueVisitors;
using System.Collections.Generic;
using System.Windows;
using ASTFormObject = AST.Nodes.FormObjects;
using AST.Nodes.Interfaces;
using Types = AST.Types;
using QLGui.FormObjects;

namespace QLGui.Controllers
{
    public class MainController
    {
        private ASTResult astTree;
        private MainWindow window;
        private SymbolTable symbolTable;
        public EventUpdateValue EventUpdateValue { get; set; }

        public MainController(MainWindow mainWindow, ASTResult ast)
        {
            window = mainWindow;
            astTree = ast;

            symbolTable = new SymbolTable();
        }

        public UIElement ProcessBody()
        {
            SubController nodeBodyProcessor = new SubController(symbolTable);
            nodeBodyProcessor.EventUpdateValue += UpdateValue;

            symbolTable = nodeBodyProcessor.Register(symbolTable);

            return nodeBodyProcessor.ProcessBody(astTree.RootNode.GetBody(), window.GetRootElement());
        }

        private void UpdateValue(string id, Value value)
        {
            symbolTable.SetUpdateValue(new Id(id, new PositionInText()), value);

            window.DeleteElements();

            ProcessBody();
        }
    }
}