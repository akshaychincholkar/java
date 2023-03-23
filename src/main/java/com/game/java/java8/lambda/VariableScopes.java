package com.game.java.java8.lambda;
@FunctionalInterface
interface VariableScopesSum{
    abstract public int sum(int a,int b);
}

public class VariableScopes {
    int objectVariable;
    static int classVariable;

    public static void main(String[] args) {
    final int finalVariable = 1;
    int scopeVariable = 1;
    VariableScopes variableScopes = new VariableScopes();
    VariableScopesSum variableScopesSum = (a,b)->{
//        finalVariable++; // will throw compilation error
//        scopeVariable++; // it will act as final variable and can't be incremented / updated
        variableScopes.objectVariable ++; // object variable can be incremented / updated
        classVariable ++; // static / class variable can be updated

      return a+b+finalVariable + scopeVariable + variableScopes.objectVariable + classVariable;
    };
        System.out.println(" Total value :"+variableScopesSum.sum(1,1));
    }
}
