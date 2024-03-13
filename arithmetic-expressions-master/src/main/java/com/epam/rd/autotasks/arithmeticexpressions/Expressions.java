package com.epam.rd.autotasks.arithmeticexpressions;


public class Expressions {

    public static Variable var(String name, int value) {
        return new Variable(name, value);
    }

    public static Expression val(int value) {
        return new Expression() {
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                if (value < 0)
                {
                    String val = String.valueOf(value);
                    return "(" + val + ")";
                }
                return String.valueOf(value);
            }
        };
    }

    public static Expression sum(Expression... members){
        return new Expression() {
            public int sum()
            {
                int sum1 = 0;
                for (Expression expression : members)
                {
                    sum1 += expression.evaluate();
                }
                return sum1;
            }

            public String sumString()
            {
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                for (int i = 0; i < members.length - 1; i++)
                {
                    sb.append(members[i].toExpressionString()).append(" ").append("+").append(" ");
                }
                sb.append(members[members.length-1].toExpressionString());
                sb.append(")");
                return sb.toString();
            }

            @Override
            public int evaluate() {
                return sum();
            }

            @Override
            public String toExpressionString() {
                return sumString();
            }
        };
    }

    public static Expression product(Expression... members){
        return new Expression() {

            public int product()
            {
                int product1 = 1;
                for (Expression expression : members)
                {
                    product1 *= expression.evaluate();
                }
                return product1;
            }

            public String productString()
            {
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                for (int i = 0; i < members.length - 1; i++)
                {
                    sb.append(members[i].toExpressionString()).append(" ").append("*").append(" ");
                }
                sb.append(members[members.length-1].toExpressionString());
                sb.append(")");
                return sb.toString();

            }
            @Override
            public int evaluate() {
                return product();
            }

            @Override
            public String toExpressionString() {
                return productString();
            }
        };
    }

    public static Expression difference(Expression minuend, Expression subtrahend){
        return new Expression() {

            public int difference() {
                return minuend.evaluate() - subtrahend.evaluate();
            }

            public String differenceString()
            {
                StringBuilder sb = new StringBuilder();
                sb.append("(").append(minuend.toExpressionString()).append(" ").append("-").
                        append(" ").append(subtrahend.toExpressionString()).append(")");
                return sb.toString();
            }

            @Override
            public int evaluate() {
                return difference() ;
            }

            @Override
            public String toExpressionString() {
                return differenceString();
            }
        };
    }

    public static Expression fraction(Expression dividend, Expression divisor)
    {
        return new Expression() {
            public int fraction()
            {
                return dividend.evaluate() / divisor.evaluate();
            }

            public String fractionString()
            {
                StringBuilder sb = new StringBuilder();
                sb.append("(").append(dividend.toExpressionString()).append(" ").
                        append("/").append(" ").append(divisor.toExpressionString()).append(")");
                return sb.toString();
            }
            @Override
            public int evaluate() {
                return fraction();
            }

            @Override
            public String toExpressionString() {
                return fractionString();
            }
        };
    }

}
