package cursojava.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.constantes.StatusAluno;

public class PrimeiraClasseJava {

	/**
	 * Método padrão que executa os programas escritos em Java
	 */
	public static void main(String[] args) {
		
		String login = JOptionPane.showInputDialog("Informe o login:");
		String senha = JOptionPane.showInputDialog("Informe a senha:");
		
		if (login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {
			
			JOptionPane.showMessageDialog(null, "Acesso liberado ao sistema! Pressione OK!");
			
			List<Aluno> alunos = new ArrayList<>();		
			
			// Estrutua de dados que representa os elementos por uma chave e um valor associado à chave
			HashMap<String, List<Aluno>> maps = new HashMap<>();
			
			for(int qtd = 1; qtd <= 5; qtd ++) {
				
				// new Aluno() é uma instância da classe Aluno (criação do objeto)
				// aluno1 é uma referência para o objeto
				
				// Entrada de dados com o teclado (Dados do aluno)
				String nome = JOptionPane.showInputDialog("Digite o nome do aluno " + qtd + " :");
				/*String idade = JOptionPane.showInputDialog("Digite a idade do aluno:");
				String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento do aluno:");
				String rg = JOptionPane.showInputDialog("Digite o RG do aluno:");
				String cpf = JOptionPane.showInputDialog("Digite o CPF do aluno:");
				String nomeMae = JOptionPane.showInputDialog("Digite o nome da mãe do aluno:");
				String nomePai = JOptionPane.showInputDialog("Digite o nome do pai do aluno:");
				String dataMatricula = JOptionPane.showInputDialog("Digite a data da matrícula do aluno:");
				String serieMatriculado = JOptionPane.showInputDialog("Digite a série do aluno:");
				String nomeEscola = JOptionPane.showInputDialog("Digite o nome da escola do aluno:");	*/			
				
				Aluno aluno1 = new Aluno();
				
				// Dados do aluno1
				aluno1.setNome(nome);
				/*aluno1.setIdade(Integer.valueOf(idade));
				aluno1.setDataNascimento(dataNascimento);
				aluno1.setRegistroGeral(rg);
				aluno1.setNumeroCpf(cpf);
				aluno1.setNomeMae(nomeMae);
				aluno1.setNomePai(nomePai);
				aluno1.setDataMatricula(dataMatricula);
				aluno1.setSerieMatriculado(serieMatriculado);
				aluno1.setNomeEscola(nomeEscola);*/
				
				for (int pos = 1; pos <= 1; pos++) {
					
					String nomeDisciplina = JOptionPane.showInputDialog("Digite o nome da " + pos + "º disciplina:");
					String notaDisciplina = JOptionPane.showInputDialog("Digite a nota da " + pos + "º disciplina:");
					
					Disciplina disciplina = new Disciplina();
					disciplina.setDisciplina(nomeDisciplina);
					disciplina.setNota(Double.valueOf(notaDisciplina));
					
					aluno1.getDisciplinas().add(disciplina);
				}
				
				int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");
				
				if (escolha == 0) { // Opção SIM = 0
					
					int continuarRemover = 0;
					int posicao = 1;
					
					while (continuarRemover == 0) {
						String disciplinaRemover = JOptionPane.showInputDialog(null, "Informe a disciplina a ser removida [1, 2, 3 ou 4]");
						aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
						posicao ++; // Incremente 1 ao valor atual da variável posicao
						continuarRemover = JOptionPane.showConfirmDialog(null, "Deseja continuar a remover?");
					}			
				}
				
				alunos.add(aluno1);
			}
			
			maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
			
			for (Aluno aluno: alunos) {			
				if (aluno.getAlunoAprovadoString().equalsIgnoreCase(StatusAluno.APROVADO)) {
					maps.get(StatusAluno.APROVADO).add(aluno);
				} else if (aluno.getAlunoAprovadoString().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
					maps.get(StatusAluno.RECUPERACAO).add(aluno);
				} else if (aluno.getAlunoAprovadoString().equalsIgnoreCase(StatusAluno.REPROVADO)) {
					maps.get(StatusAluno.REPROVADO).add(aluno);
				}
			}
			
			System.out.println("Lista dos alunos APROVADOS! :)");
			System.out.println("==============================");
			for (Aluno aluno: maps.get(StatusAluno.APROVADO)) {	
				System.out.println("Nome: " + aluno.getNome());
				System.out.println("Média: " + aluno.getMediaNota());
				System.out.println("--------------------------");
			}
			System.out.println("==============================");
			
			System.out.println("Lista dos alunos REPROVADOS! :(");
			System.out.println("==============================");
			for (Aluno aluno: maps.get(StatusAluno.REPROVADO)) {	
				System.out.println("Nome: " + aluno.getNome());
				System.out.println("Média: " + aluno.getMediaNota());
				System.out.println("--------------------------");
			}
			System.out.println("==============================");
			
			System.out.println("Lista dos alunos em RECUPERAÇÃO! ^ | ^");
			System.out.println("==============================");
			for (Aluno aluno: maps.get(StatusAluno.RECUPERACAO)) {	
				System.out.println("Nome: " + aluno.getNome());
				System.out.println("Média: " + aluno.getMediaNota());
				System.out.println("--------------------------");
			}
			System.out.println("==============================");
		} else {
			JOptionPane.showMessageDialog(null, "Login ou senha inválido(s)! Acesso não autorizado! Pressione OK e tente novamente!");
		}
	}	
}
