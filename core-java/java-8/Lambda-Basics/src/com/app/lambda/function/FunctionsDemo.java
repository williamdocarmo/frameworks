package com.app.lambda.function;

import java.lang.reflect.Method;

public class FunctionsDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		String packageName = "java.util.function";
		String classesList = "BiConsumer,BiFunction,BinaryOperator,BiPredicate,BooleanSupplier,Consumer,DoubleBinaryOperator,DoubleConsumer,DoubleFunction,DoublePredicate,DoubleSupplier,DoubleToIntFunction,DoubleToLongFunction,DoubleUnaryOperator,Function,IntBinaryOperator,IntConsumer,IntFunction,IntPredicate,IntSupplier,IntToDoubleFunction,IntToLongFunction,IntUnaryOperator,LongBinaryOperator,LongConsumer,LongFunction,LongPredicate,LongSupplier,LongToDoubleFunction,LongToIntFunction,LongUnaryOperator,ObjDoubleConsumer,ObjIntConsumer,ObjLongConsumer,Predicate,Supplier,ToDoubleBiFunction,ToDoubleFunction,ToIntBiFunction,ToIntFunction,ToLongBiFunction,ToLongFunction,UnaryOperator";
		String[] classes = classesList.split(",");
		for (String c : classes) {
			Class clazz = Class.forName(packageName + "." + c);
			Method[] methods = clazz.getDeclaredMethods();
			for (Method m : methods) {
				boolean notDefault = !m.isDefault();
				String methodname = m.getName();
				boolean notLambda = !methodname.contains("lambda");
				if (notDefault && notLambda) {
					String classname = c;
					String returnType = m.getReturnType().getSimpleName();
					String input = "";
					if (m.getParameterCount() != 0) {
						Class[] parameterTypes = m.getParameterTypes();
						for (Class p : parameterTypes) {
							input += "," + p.getSimpleName();
						}
					}
					if (input.startsWith(","))
						input = input.substring(1, input.length());
					System.out.println(c + ": " + returnType + " " + methodname + " ( " + input + " )");
				}
			}
			System.out.println();
		}
	}

}
