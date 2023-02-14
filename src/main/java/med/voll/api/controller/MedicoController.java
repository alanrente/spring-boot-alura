package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListageMedico;
import med.voll.api.medico.MedicoEntity;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @GetMapping
    public Page<DadosListageMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {

        /*
        * Paginação, ordenação e qtd por página, são definidos na URL com os atributos:
        * - size: para qtd por página;
        * - page: para a página (padrão "0") e
        * - sort: passando o nome do atributo desejado na ordenação (ex: "sort=nome", por padrão é crescente mas podemos inverter ex: "sort=nome,desc")
        *   Exemplo da url http://localhost:8080/medicos?size=10&page=0&sort=nome
        *   também podemos utilizar a anotação @PageableDefault passando para elas um padrão, caso não venha os mesmos na url ex: @PageableDefault(size = 10, sort = {"nome"})
        */
        return repository.findAll(paginacao).map(DadosListageMedico::new);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {

        System.out.println(dados);

        repository.save(new MedicoEntity(dados));
    }

}
