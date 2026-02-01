package com.risotto.pixy;

import com.risotto.pixy.Expr.Binary;
import com.risotto.pixy.Expr.Grouping;
import com.risotto.pixy.Expr.Literal;
import com.risotto.pixy.Expr.Unary;

public class Interpreter implements Expr.Visitor<Object>{

   private Object evaluate(Expr expr) {
    return expr.accept(this);
  }

  @Override
  public Object visitLiteralExpr(Literal expr) {
    return expr.value;
  }
  @Override
  public Object visitGroupingExpr(Grouping expr) {
    return evaluate(expr.expression);
  }

    @Override
    public Object visitUnaryExpr(Unary expr) {
      Object right = evaluate(expr.right);
      switch (expr.operator.type) {
      case MINUS:
        return -(double) right;
      case BANG:
        return !isTruthy(right);
      }
      return null;
    }

    private boolean isTruthy(Object object) {
      if (object == null)
        return false;
      if (object instanceof Boolean)
        return (boolean) object;
      return true;
    }

  @Override
  public Object visitBinaryExpr(Binary expr) {
    Object left = evaluate(expr.left);
    Object right = evaluate(expr.right);

    switch (expr.operator.type) {
    case GREATER:
      return (double) left > (double) right;
    case GREATER_EQUAL:
      return (double) left >= (double) right;
    case LESS:
      return (double) left < (double) right;
    case LESS_EQUAL:
      return (double) left <= (double) right;
    case MINUS:
      return (double) left - (double) right;

    case PLUS:
      if (left instanceof Double && right instanceof Double) {
        return (double) left + (double) right;
      }

      if (left instanceof String && right instanceof String) {
        return (String) left + (String) right;
      }

      break;

    case SLASH:
      return (double) left / (double) right;
    case STAR:
      return (double) left * (double) right;
    case BANG_EQUAL:
      return !isEqual(left, right);
    case EQUAL_EQUAL:
      return isEqual(left, right);
    }
    return null;
  }

  private boolean isEqual(Object left, Object right) {
    if (left == null && right == null)
      return true;
    if (left == null)
      return false;

    return left.equals(right);
  }
  // TODO: detect runtime errors

}
