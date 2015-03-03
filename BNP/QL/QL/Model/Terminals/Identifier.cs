﻿using System;
using QL.Errors;

namespace QL.Model.Terminals
{
    public class Identifier : BinaryTreeElementBase, ITerminal<string>, ITerminalType
    {
        public string Value { get; private set; }
        
        public Identifier()
        { }

        public Identifier(string value)
        {
            Value = value;
        }

        public void SetValue(object value)
        {
            Value = value.ToString();
        }

        public ITerminalType ResolveValue()
        {
            throw new NotImplementedException();
        }

        public override bool Equals(object obj)
        {
            if (obj is Identifier) return Equals(obj as Identifier);
            return false;
        }

        public bool Equals(Identifier obj)
        {
            return Value == obj.Value;
        }

        public override int GetHashCode()
        {
            return (Value != null ? Value.GetHashCode() : 0);
        }

        public override string ToString()
        {
            return string.IsNullOrWhiteSpace(Value) ? "undefined" : Value;
        }
        public override Type GetReturnType()
        {
            return GetType();
        }
    }
}
