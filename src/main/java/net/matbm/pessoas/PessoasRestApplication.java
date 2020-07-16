package net.matbm.pessoas;

import net.matbm.pessoas.core.anotacao.UseCase;
import net.matbm.pessoas.dataprovider.anotacao.Dataprovider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
// Anotações de component customizadas ;)
@ComponentScan(
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Dataprovider.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = UseCase.class)
        }
)
public class PessoasRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PessoasRestApplication.class, args);
    }

}
