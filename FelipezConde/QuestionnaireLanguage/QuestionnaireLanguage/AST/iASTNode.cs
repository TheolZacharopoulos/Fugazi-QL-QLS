﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.AST
{
    public interface iASTNode
    {
       // Parent Properties
      //  iASTNode setParent();
      //  iASTNode getParent();
      //  iASTNode removeParent();
        
        //Child Properties
      //  iASTNode getChild(int i);
        void AddChild(iASTNode node);
      //  iASTNode removeChild(int i);

    }
}