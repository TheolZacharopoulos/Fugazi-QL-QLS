﻿using AST.Nodes.Expressions;
using AST.Nodes.Expressions.Binary;
using AST.Nodes.Expressions.Unary;
using AST.ASTVisitors;
using Notifications;
using System.Collections.Generic;
using TypeChecker.Notifications.Errors;
using Types = AST.Types;

namespace TypeChecker.Collectors
{
    public class ExpressionTypeCollector : BaseVisitor<Types.Type>
    {
        private readonly Dictionary<Id, Types.Type> idToType;
        private List<INotification> collectedNotifications = new List<INotification>();

        public ExpressionTypeCollector(Dictionary<Id, Types.Type> idToType)
        {
            this.idToType = idToType;
        }

        public IList<INotification> GetCollectedNotifications()
        { return collectedNotifications; }

        public void ClearCollectedNotifications()
        { collectedNotifications = new List<INotification>(); }

        #region Id
        public override Types.Type Visit(Id node)
        {
            return idToType[node];
        }

        #endregion
        #region Binary
        public override Types.Type Visit(AST.Nodes.Expressions.Binary.And node)
        {
            return VisitBinaryExpectedType(node, new Types.BoolType());
        }

        public override Types.Type Visit(Or node)
        {
            return VisitBinaryExpectedType(node, new Types.BoolType());
        }

        public override Types.Type Visit(Equal node)
        {
            return VisitBinary(node);
        }

        public override Types.Type Visit(NotEqual node)
        {
            return VisitBinary(node);
        }

        public override Types.Type Visit(GreaterThan node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public override Types.Type Visit(GreaterThanOrEqual node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public override Types.Type Visit(LessThan node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public override Types.Type Visit(LessThanOrEqual node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public override Types.Type Visit(Add node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public override Types.Type Visit(Subtract node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public override Types.Type Visit(Multiply node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public override Types.Type Visit(Divide node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }
        #endregion
        #region Unary
        public override Types.Type Visit(Negate node)
        {
            return VisitUnaryExpectedType(node, new Types.BoolType());
        }

        public override Types.Type Visit(Priority node)
        {
            return VisitUnary(node);
        }
        #endregion

        private Types.Type VisitBinaryExpectedType(Binary node, Types.Type expectedType)
        {
            Types.Type left = node.Left().Accept(this);
            Types.Type right = node.Right().Accept(this);

            if (!left.IsEqual(expectedType) && right.IsEqual(expectedType))
            {
                collectedNotifications.Add(new IncompatibleBinaryOperator(node.GetPosition(), node.ToString(), left.GetString(), right.GetString()));
            }

            return expectedType;
        }
        private Types.Type VisitBinary(Binary node)
        {
            Types.Type left = node.Left().Accept(this);
            Types.Type right = node.Right().Accept(this);

            if (!left.IsEqual(right))
            {
                collectedNotifications.Add(new IncompatibleBinaryOperator(node.GetPosition(), node.ToString(), left.GetString(), right.GetString()));
            }

            return left;
        }
        private Types.Type VisitUnary(Unary node)
        {
            return node.GetChildExpression().Accept(this);
        }
        private Types.Type VisitUnaryExpectedType(Unary node, Types.Type expectedType)
        {
            Types.Type childType = node.GetChildExpression().Accept(this);

            if (childType.IsEqual(expectedType))
            {
                collectedNotifications.Add(new IncompatibleUnaryOperator(node.GetPosition(), node.ToString(), childType.GetString()));
            }

            return expectedType;
        }
    }
}
