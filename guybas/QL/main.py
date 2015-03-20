import pyparsing as pp

import QL.Grammar.grammar as grammar
import QL.config as c
import QL.Grammar.Factory.forms as form_factory
import QL.Runtime.form as runtime_form
import QL.GUI.gui as g

#
# p = grammar.expr.parseString("not 5 + 3 * 2 - 1 == 4")
# print(p[0].pretty_print())

pp.ParserElement.enablePackrat()
formAsParseResults = grammar.form.ignore(grammar.comment).parseFile(c.Config.input_path)
form = form_factory.make_form(formAsParseResults)
# print(form.pretty_print())

form.is_valid_form()

# typeChecker = type_checker.TypeChecker(form)
# typeChecker.is_valid_form()


enriched_form = runtime_form.Form(form)
gui = g.GUI(enriched_form)
gui.generate_gui()
gui.show()