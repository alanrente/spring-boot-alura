package med.voll.api.controller;

import med.voll.api.medico.DadosCadastroMedico;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @GetMapping
    static String listar() {
        return "medicos";
    }

    @PostMapping
    static void cadastrar(@RequestBody DadosCadastroMedico dados) {
        System.out.println(dados);
    }

}
