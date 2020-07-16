package net.matbm.pessoas.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Classe para testar DTO's.
 *
 * @param <DTO> Classe DTO
 * @author Mateus Mercer contato@matbm.net
 * @since 2019
 */
public abstract class DtoTest<DTO> {
    protected Validator validator;
    protected DTO dto;
    private ValidatorFactory validatorFactory;

    @BeforeEach
    public void setUp() {
        if (validatorFactory == null)
            validatorFactory = getDefaultFactory();
        validator = validatorFactory.getValidator();
        dto = validDto();
    }

    private ValidatorFactory getDefaultFactory() {
        return Validation.buildDefaultValidatorFactory();
    }

    @AfterEach
    public void sanitize() {
        dto = validDto();
    }

    @Test
    public void dto_shouldBeValid() {
        shouldPassValidation();
    }

    protected void shouldFailWhenEmpty(Consumer<String> setter) {
        setter.accept(null);
        shouldFailValidation();
        setter.accept("");
        shouldFailValidation();
        setter.accept("   ");
        shouldFailValidation();

        dto = validDto();
    }

    protected void shouldFailValidation(Consumer<DTO> consumer) {
        consumer.accept(dto);
        shouldFailValidation();
        dto = validDto();
    }

    protected void shouldPassValidation(Consumer<DTO> consumer) {
        consumer.accept(dto);
        shouldPassValidation();
        dto = validDto();
    }

    private void shouldFailValidation() {
        var validations = getConstraintViolation();
        assertThat(validations).isNotEmpty();
    }

    private void shouldPassValidation() {
        var validations = getConstraintViolation();
        assertThat(validations).withFailMessage("Validation Errors: " + validations.toString()).isEmpty();
    }

    private Set<ConstraintViolation<DTO>> getConstraintViolation() {
        return validator.validate(dto);
    }

    @Autowired
    public void setValidatorFactory(ValidatorFactory validatorFactory) {
        this.validatorFactory = validatorFactory;
    }

    protected abstract DTO validDto();
}
