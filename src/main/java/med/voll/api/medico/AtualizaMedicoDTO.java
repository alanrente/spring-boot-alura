package med.voll.api.medico;

import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;

public record AtualizaMedicoDTO(
        String nome,
        String telefone,
        @Valid Endereco endereco
) {
}
