package edu.icet.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//annotation use under method
@Retention(RetentionPolicy.RUNTIME)//logic run time
public @interface AuditTime {
}
