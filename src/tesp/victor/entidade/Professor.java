package tesp.victor.entidade;

import java.math.BigDecimal;

public class Professor extends Pessoa {

    private BigDecimal salario;
    public static Double BONUS = 0.1D;

    public Professor(Long id, String nome, String cpf, BigDecimal salario) {
        super(id, nome, cpf);
        this.salario = salario;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString() + "Professor [salario=" + salario + "]";
    }

}
