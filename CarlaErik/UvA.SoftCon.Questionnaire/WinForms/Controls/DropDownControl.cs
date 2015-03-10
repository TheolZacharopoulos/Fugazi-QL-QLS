﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class DropDownControl : QuestionControl
    {
        public DropDownControl(Question astQuestion)
            : base(astQuestion)
        {
            InitializeComponent();

            QuestionLabel.Text = Label;
            YesNoDropDownBox.Enabled = !astQuestion.IsComputed;
        }

        public override Value GetValue()
        {
            if (YesNoDropDownBox.SelectedValue != null)
            {
                return new BooleanValue(YesNoDropDownBox.SelectedValue == "Yes");
            }
            else
            {
                return new Undefined();
            }
        }

        public override void SetValue(Value value)
        {
            if (!value.IsUndefined)
            {
                if (value.DataType == DataType.Boolean)
                {
                    if (((BooleanValue)value).Val)
                    {
                        YesNoDropDownBox.SelectedText = "Yes";
                    }
                    else
                    {
                        YesNoDropDownBox.SelectedText = "No";
                    }
                }
                else
                {
                    throw new ArgumentException("Parameter value must be of datatype 'bool'.");
                }
            }
            else
            {
                YesNoDropDownBox.SelectedIndex = -1;
            }
        }

        private void YesNoDropDownBox_SelectedValueChanged(object sender, EventArgs e)
        {
            OnQuestionAnswered(new EventArgs());
        }
    }
}
