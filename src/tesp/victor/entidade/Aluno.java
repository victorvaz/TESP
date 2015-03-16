package tesp.victor.entidade;

import java.util.Date;

public class Aluno extends Pessoa {

    private Long matricula;
    private Date dataAniversario;

    public Aluno(Long id, String nome, String cpf, Long matricula, Date dataAniversario) {
        super(id, nome, cpf);
        this.matricula = matricula;
        this.dataAniversario = dataAniversario;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public Date getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(Date dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public static boolean verificaMatricula(String matricula) {
        if (matricula == null) {
            return false;
        } else if (matricula.trim().equals("")) {
            return false;
        } else if (matricula.length() != 8) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Aluno [matricula=" + matricula + ", dataAniversario="
                + dataAniversario + "]";
    }

}
