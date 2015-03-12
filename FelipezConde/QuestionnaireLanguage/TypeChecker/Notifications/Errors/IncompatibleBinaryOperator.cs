﻿using AST.Helpers;
using AST.Nodes.FormObject;
using AST.Representation;
using Notifications;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TypeChecker.Notifications.Errors
{
    public class IncompatibleBinaryOperator : Error
    {
            private readonly PositionInText position;
            private readonly string op;
            private readonly string leftType;
            private readonly string rightType;

            public IncompatibleBinaryOperator(PositionInText position, string op, string leftType, string rightType)
            {
                this.op = op;
                this.rightType = rightType;
                this.leftType = leftType;
                this.position = position;
            }

            public override string Message()
            {
                return string.Format("Operator \"{0}\" is incompatible with types \"{1}\" and \"{2}\" at {3}",
                        new string[] {
                            op,
                            leftType,
                            rightType,
                            Position.PrettyPrint(position)
                        });
            }

            
    }
}
