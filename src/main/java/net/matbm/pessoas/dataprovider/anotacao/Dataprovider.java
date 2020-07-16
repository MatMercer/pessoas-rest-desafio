package net.matbm.pessoas.dataprovider.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Usado para representar um Dataprovider no sistema.
 * Facilita frameworks de dependency injection na hora do scan.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Dataprovider {
    String value() default "";
}
