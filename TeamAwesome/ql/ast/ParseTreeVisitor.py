# Generated from java-escape by ANTLR 4.5
from antlr4 import *
from ..parser.QLVisitor import QLVisitor
from ..parser.QLParser import QLParser
from . import Nodes
from ..CustomTypes import *

# This class defines a complete generic visitor for a parse tree produced by QLParser.
class ParseTreeVisitor(QLVisitor):

    # Visit a parse tree produced by QLParserRoot.
    def visitRoot(self, ctx):
        statements = [self.visit(child) for child in ctx.getChildren()]
        return Nodes.Root(statements)

    # Visit a parse tree produced by QLParser#form.
    def visitForm_statement(self, ctx):
        identifier = self.visit(ctx.name)
        statements = [self.visit(statement) for statement in ctx.statements]
        lineNumber = ctx.start.line
        return Nodes.FormStatement(identifier, statements, lineNumber)

    # Visit a parse tree produced by QLParser
    def visitQuestion_statement(self, ctx):
        identifier = self.visit(ctx.name)
        text = ctx.text.getText()[1:-1]
        question_type = ctx.qtype.getText()
        
        expr = self.visit(ctx.expression) if ctx.expression != None else None

        lineNumber = ctx.start.line

        return Nodes.QuestionStatement(identifier, text, question_type, lineNumber, expr = expr)

    # Visit a parse tree produced by QLParser#if_statement.
    def visitIf_statement(self, ctx):
        expr = self.visit(ctx.expression)
        statements = [self.visit(statement) for statement in ctx.statements]
        lineNumber = ctx.start.line
        return Nodes.IfStatement(expr, statements, lineNumber)

    # Visit a parse tree produced by QLParser#boolean.
    def visitBoolean(self, ctx):
        return ctx.getText() == 'true';

    # Visit a parse tree produced by QLParser#question_type.
    def visitQuestion_type(self, ctx):
        return ctx.getText()

    # Visit a parse tree produced by QLParser#string.
    def visitString(self, ctx):
        return ctx.getText()[1:-1]

    # Visit a parse tree produced by QLParser#integer.
    def visitInteger(self, ctx):
        return int(ctx.getText())

    # Visit a parse tree produced by QLParser#money.
    def visitMoney(self, ctx): # TODO
        return Money(ctx.getText())

    # Visit a parse tree produced by QLParser#identifier.
    def visitIdentifier(self, ctx): # TODO
        lineNumber = ctx.start.line
        return Identifier(ctx.getText(), lineNumber)
    
    # Visit a parse tree produced by QLParser#atom.
    def visitAtom(self, ctx):
        lineNumber = ctx.start.line
        return Nodes.AtomicExpression(self.visitChildren(ctx), lineNumber)

    # Visit a parse tree produced by QLParser#expr.
    def visitExpr(self, ctx):
        # no operator in expression (atom)
        if ctx.op == None:
            return self.visitChildren(ctx.left)

        lineNumber = ctx.start.line
        op = ctx.op.text
        right = self.visit(ctx.right)

        # unary (rightside) operator
        if ctx.left == None:
            return Nodes.UnaryExpression(op, right, lineNumber)

        left = self.visit(ctx.left)

        return Nodes.BinaryExpression(left, op, right, lineNumber)