import QL.AST.Expressions.Operations.binary_expression as b
import QL.Grammar.constants as constants


class Or(b.BinaryExpression):

    # get the return _type of the _expression
    def return_type_string(self, type_dict):
        return constants.NUMBER
