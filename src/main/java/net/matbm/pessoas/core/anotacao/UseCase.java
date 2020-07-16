package net.matbm.pessoas.core.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Usado para representar um UseCase no sistema.
 * Facilita frameworks de dependency injection na hora do scan.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    String value() default "";
}
