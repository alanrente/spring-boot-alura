package med.voll.api.medico;

public record DadosListageMedico(String nome, String email, String crm, Especialidade especialidade) {
    public DadosListageMedico(MedicoEntity medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
