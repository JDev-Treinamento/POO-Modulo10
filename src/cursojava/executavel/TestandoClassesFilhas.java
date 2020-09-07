package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Secretario;

public class TestandoClassesFilhas {
	
	public static void main(String[] args) {
		
		Aluno aluno = new Aluno();
		aluno.setNome("Alex JDev - Treinamento");
		aluno.setNomeEscola("JDev - Treinamento");
		
		Diretor diretor = new Diretor();
		diretor.setRegistroGeral("96459285");
		diretor.setNome("Egidio");
		
		Secretario secretario = new Secretario();
		secretario.setExperiencia("Administração");
		secretario.setNumeroCpf("92547816542");
		
		System.out.println(aluno);
		System.out.println(diretor);
		System.out.println(secretario);
		
	}

}
