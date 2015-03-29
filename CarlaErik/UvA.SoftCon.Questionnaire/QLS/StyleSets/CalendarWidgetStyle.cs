﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.QLS.StyleSets
{
    public class CalendarWidgetStyle : WidgetStyle
    {
        public static CalendarWidgetStyle Default
        {
            get
            {
                return new CalendarWidgetStyle();
            }
        }

        public override object CreateWidgetControl(IWidgetFactory factory)
        {
            return factory.CreateCalendarWidget();
        }
    }
}
