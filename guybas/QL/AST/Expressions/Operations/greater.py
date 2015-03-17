import QL.AST.Expressions.Operations.binary_expression as b
import QL.Grammar.constants as constants
import QL.AST.Expressions.Operations.equal as e


class Greater(e.Equal):

    # get the return _type of the _expression
    def return_type_string(self, type_dict):
        return constants.BOOL
