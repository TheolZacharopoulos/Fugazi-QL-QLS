import QL.AST.Expressions.Operations.equal as e
import QL.Grammar.constants as constants


class LessEqual(e.Equal):

    # get the return _type of the _expression
    def return_type_string(self, type_dict):
        return constants.BOOL
