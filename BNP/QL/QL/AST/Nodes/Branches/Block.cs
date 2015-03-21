﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Model
{
    public class Block: ElementBase
    {
        public IList<ElementBase> Children { get; set; }

        public Block()
        {
            Children = new List<ElementBase>();
        }


    }
}