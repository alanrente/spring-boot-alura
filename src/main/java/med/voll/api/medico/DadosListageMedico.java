package med.voll.api.medico;

public record DadosListageMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {
    public DadosListageMedico(MedicoEntity medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
