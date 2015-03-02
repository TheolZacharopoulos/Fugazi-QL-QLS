
import unittest

from src.QL.parser import Parser
from src.Typechecker.errors import ParseError

# Simple tests that check if the parser does not crash on valid input
class ParseTests(unittest.TestCase):
    def setUp(self):
        self.parser = Parser()

    def testEmptyFile(self):
        formText = "   \t   \r\n   \n \n "
        parsed = self.parser.parse(formText)

        self.assertEquals(parsed, [])

    def testEmptyForm(self):
        formText = "form taxOfficeExample {}"
        parsed = self.parser.parse(formText)

        self.assertEquals(parsed.__class__.__name__, "Form")
        self.assertEquals(len(parsed.block), 0)

    def testNonClosingForm(self):
        formText = "form taxOfficeExample {"
        self.assertRaises(ParseError, self.parser.parse, formText)

    # Parser does not accept multiple forms in single file
    def testMultipleForms(self):
        formText = "form taxOfficeExample {} form taxExampleB {}"
        self.assertRaises(ParseError, self.parser.parse, formText)

    def testSimpleForm(self):
        with open("tests/forms/simple.txt", "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.block), 4)

            file.close()

    def testSkipComments(self):
        with open("tests/forms/comments.txt", "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.block), 1)

            file.close()

    def testTypes(self):
        with open("tests/forms/types.txt", "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.block), 5)

            file.close()


    def testUndefinedType(self):
        with open("tests/forms/undefinedType.txt", "r") as file:
            self.assertRaises(ParseError, self.parser.parse, file.read())

            file.close()


    def testIfBlocks(self):
        with open("tests/forms/simpleIf.txt", "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.block), 2)

            file.close()

    def testIfElse(self):
        with open("tests/forms/ifElse.txt", "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.block), 1)

            file.close()

    def testNestedIfBlocks(self):
        with open("tests/forms/nestedIf.txt", "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.block), 1)

            self.assertEquals(parsed.block[0].__class__.__name__, "Branch")
            self.assertEquals(len(parsed.block[0].ifChildren), 2)

            file.close()


    def testExpressions(self):
        with open("tests/forms/expressions.txt", "r") as file:
            parsed = self.parser.parse(file.read())

            self.assertEquals(parsed.__class__.__name__, "Form")
            self.assertEquals(len(parsed.block), 13)

            file.close()
