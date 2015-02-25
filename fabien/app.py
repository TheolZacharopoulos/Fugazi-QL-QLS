#!/usr/bin/env python

#from src.gui.app import GUI

from src.QL.parser import Parser
from src.typechecker import *

if __name__ == '__main__':
    parser = Parser()

    with open("tests/forms/simple.txt") as f:
        formText = f.read()
        Form = parser.parse(formText)

        f.close()

    checker = TypeChecker()

    checker.register(DuplicateQuestions())
    checker.register(UndefinedQuestions())
    checker.register(NonBooleanExpressions())


    checker.checkAST(Form)