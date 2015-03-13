package symboltable

import (
	"strconv"
	"strings"
)

const (
	// AnswerYes is the string value for boolean true
	AnswerYes = "Yes"
	// AnswerNo is the string value for boolean false
	AnswerNo = "No"
)

// BoolQuestion stores the answer of question which type is integer numeric
type BoolQuestion struct {
	value bool
}

// BoolQuestionType constant used for type comparison internally in interpreter
// and frontend
const BoolQuestionType = "bool"

// From takes the input from Frontend and stores locally - String
func (s *BoolQuestion) From(str string) error {
	val, err := strconv.Atoi(str)
	if val == 1 || str == AnswerYes || strings.ToLower(str) == AnswerYes {
		s.value = true
	} else {
		s.value = false
	}
	return err
}

// String prints in human form the content of the question - String
func (s BoolQuestion) String() string {
	if s.value {
		return AnswerYes
	}
	return AnswerNo
}

// Value converts underlying String into primitive String
func (s BoolQuestion) Value() interface{} {
	return s.value
}
