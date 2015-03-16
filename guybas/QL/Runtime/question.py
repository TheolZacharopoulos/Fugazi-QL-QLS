import QL.AST.Statements.question as ast_q
import QL.Tools.exceptions as e
import QL.GUI.Elements.factory as gui_elements_f


class Question:
    def __init__(self, ast_question, order, condition):
        if not isinstance(ast_question, ast_q.Question):
            raise e.QException("Input must be an Question Object!")

        self.order = order
        self.gui_element = None
        self.ast = ast_question
        self.condition = condition

    def set_gui_element(self, gui):
        e_factory = gui_elements_f.Factory(self, gui)
        el = e_factory.get_gui_element()
        self.gui_element = el.get_row()

    def get_order(self):
        return self.order

    def get_gui_element(self):
        return self.gui_element

    def get_ast(self):
        return self.ast

    def get_condition(self):
        return self.condition