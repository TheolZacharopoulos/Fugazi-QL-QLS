﻿using System;
using QL.Model;

namespace QL.Exceptions.Errors
{
    public class QLError : QLException
    {
        /* Base class for all QL Errors
         */
        public QLError()
        {
        }

        public QLError(string message)
            : base(message)
        { }

        public QLError(string message, SourceLocation sourceLocation)
            : base(message)
        {
            SourceLocation = sourceLocation;
        }

        public QLError(string message, Exception inner)
            : base(message, inner)
        {
        }

        public QLError(string message, ElementBase source)
            : base(message, source)
        {
        }
    }
}
