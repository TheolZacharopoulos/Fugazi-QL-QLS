from typechecking import Message

from . import CheckerCommon

from .Identifier import typeOfIdentifier
from ..TypeRules import nativeQuestionType



class Checker(CheckerCommon.AbstractBase):
    def __init__(self, resultAlgebra):
        super().__init__(resultAlgebra) 
        self._questionnaire = None


    def visitQuestionnaireBegin(self, questionnaire):
        self._questionnaire = questionnaire


    def visitQuestionStatement(self, node):
        myType = nativeQuestionType(node.type)
        expectedType = typeOfIdentifier(
            node.identifier, self._questionnaire
        )

        if myType != expectedType:
            self._result = self._resultAlgebra.withError(
                self._result,
                Message.Error(
                    'Duplicate definition of question `'\
                   +str(node.identifier)+'` with different type `'\
                   +str(myType)+'` (expected type `'\
                   +str(expectedType)+'`)',
                    node
                )
            )