form SomeForm {
	"Who said the logic is the cement of our civilization with which we ascended from chaos using reason as our guide?"
	questionOne   string

	"What's the answer to life the universe and everything?"
	questionTwo   integer

	"Are you happy today?"
	questionThree bool

	if (questionThree) {
		"Why are you happy today?" questionFour string
		"Grade your happiness?"    questionFive integer
	}

	if (questionTwo > 5) {
		"Question 2 is bigger than 5?"
		questionSix bool
	}

	if (questionTwo < 5) {
		"Question 2 is less than 5?"
		questionSeven bool
	}

	if (questionTwo >= 5) {
		"Question 2 is equal to or bigger than 5?"
		questionEight bool
	}

	if (questionTwo <= 5) {
		"Question 2 is equals to or less than 5?"
		questionNine bool
	}

	if (questionTwo == 0) {
		"(If-Else) Question 2 is equals to 0?"
		questionTen bool
	} else {
		"(If-Else) Question 2 is not equals to 0?"
		questionTenElse bool
	}

	if (questionTwo == 0) {
		"(IF-ElseIf-Else) Question 2 is equals to 0?"
		questionTenAndHalf bool
	} else if (questionTwo == 1) {
		"(IF-ElseIf-Else) Question 2 is equals to 1?"
		questionTenAndHalfElseIf bool
	} else {
		"(IF-ElseIf-Else) Question 2 is not equals to 0?"
		questionTenAndHalfElse bool
	}

	if (1+1 == 2) {
		"is 1+1=2?"
		questionEleven bool
	}

	if (1-1 == 0) {
		"is 1-1=0?"
		questionTwelve bool
	}

	if (1*2 == 2) {
		"is 1*2=2?"
		questionThirteen bool
	}

	if (4/2 == 2) {
		"is 4/2=2?"
		questionFourteen bool
	}

	// if (questionOne == "surak"){
	// 	"How do you feel?"
	// 	questionFifteen string
	// }

	"Calculated field" questionSixteen integer = questionTwo * 2
}
