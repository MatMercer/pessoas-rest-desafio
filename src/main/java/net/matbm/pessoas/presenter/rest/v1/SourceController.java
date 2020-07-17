package net.matbm.pessoas.presenter.rest.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
@RequiredArgsConstructor
public class SourceController {

    @GetMapping(value = "/", produces = "text/html")
    public String redirect() {
        return "redirect:source";
    }

    @GetMapping(value = "/source", produces = "text/html")
    public ResponseEntity<String> source() {
        try {
            var file = new ClassPathResource("source.html");
            var stream = file.getInputStream();
            var bytes = stream.readAllBytes();

            return ResponseEntity.ok(new String(bytes, 0, bytes.length, StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            return ResponseEntity.ok("source.html não encontrado");
        } catch (IOException e) {
            return ResponseEntity.ok("falha ao ler source.html");
        }
    }
}
