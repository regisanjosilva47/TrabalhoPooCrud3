package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Cadastro;


public class CadastroFormPanel extends JPanel {
    private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);

    private Cadastro cadastro;
    private AppFrame frame;

    private GridBagLayout layout;
    private GridBagConstraints constraints;

    private JTextField idTxt;
    private JTextField nomeTxt;
    private JTextField idadeTxt;
    private JTextField emailTxt;
    private JTextField enderecoTxt;
    private JTextField cepTxt;
    private JTextField telefoneTxt;
    private JTextField usuarioTxt;
    private JPasswordField senhaTxt;
    private JComboBox<String> cursoMenu;
    private JTextArea observacaoTxt;
    private JRadioButton ativoSimRb;
    private JRadioButton ativoNaoRb;
    private JButton salvarBtn;
    private JButton cancelarBtn;

    public CadastroFormPanel(AppFrame appFrame) {
        frame = appFrame;
        frame.setLocationRelativeTo(null);
        cadastro = null;

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        setLayout(layout);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                if (cadastro == null) {
                    idTxt.setText("");
                    nomeTxt.setText("");
                    idadeTxt.setText("");
                    emailTxt.setText("");
                    enderecoTxt.setText("");
                    cepTxt.setText("");
                    telefoneTxt.setText("");
                    usuarioTxt.setText("");
                    senhaTxt.setText("");
                    observacaoTxt.setText("");
                    ativoSimRb.setSelected(false);
                    ativoNaoRb.setSelected(false);
                } else {
                    idTxt.setText(String.valueOf(cadastro.getId()));
                    nomeTxt.setText(cadastro.getNome());
                    idadeTxt.setText(String.valueOf(cadastro.getIdade()));
                    emailTxt.setText(cadastro.getEmail());
                    enderecoTxt.setText(cadastro.getEndereco());
                    cepTxt.setText(cadastro.getCep());
                    telefoneTxt.setText(cadastro.getTelefone());
                    usuarioTxt.setText(cadastro.getUsuario());
                    senhaTxt.setText(cadastro.getSenha());
                    cursoMenu.setSelectedItem(cadastro.getCurso());
                    observacaoTxt.setText(cadastro.getObservacao());
                    if (cadastro.getAtivo().equals("Sim")) {
                        ativoSimRb.setSelected(true);
                        ativoNaoRb.setSelected(false);
                    } else {
                        ativoSimRb.setSelected(false);
                        ativoNaoRb.setSelected(true);
                    }
                }
            }
        });

        criarForm();
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    private void criarForm() {
        JLabel rotulo;

        rotulo = new JLabel("Id");
        adicionarComponente(rotulo, 0, 0);
        idTxt = new JTextField(30);
        idTxt.setEditable(false);
        idTxt.setDocument(new MaxCharDocument(50));
        adicionarComponente(idTxt, 0, 1);

        rotulo = new JLabel("Nome");
        adicionarComponente(rotulo, 1, 0);
        nomeTxt = new JTextField(30);
        nomeTxt.setDocument(new MaxCharDocument(50));
        adicionarComponente(nomeTxt, 1, 1);

        rotulo = new JLabel("Idade");
        adicionarComponente(rotulo, 2, 0);
        idadeTxt = new JTextField(5);
        idadeTxt.setDocument(new MaxCharDocument(3));
        adicionarComponente(idadeTxt, 2, 1);

        rotulo = new JLabel("E-mail");
        adicionarComponente(rotulo, 3, 0);
        emailTxt = new JTextField(30);
        emailTxt.setDocument(new MaxCharDocument(50));
        adicionarComponente(emailTxt, 3, 1);

        rotulo = new JLabel("Endereço");
        adicionarComponente(rotulo, 4, 0);
        enderecoTxt = new JTextField(30);
        enderecoTxt.setDocument(new MaxCharDocument(15));
        adicionarComponente(enderecoTxt, 4, 1);

        rotulo = new JLabel("CEP");
        adicionarComponente(rotulo, 5, 0);
        cepTxt = new JTextField(10);
        cepTxt.setDocument(new MaxCharDocument(10));
        adicionarComponente(cepTxt, 5, 1);

        rotulo = new JLabel("Telefone");
        adicionarComponente(rotulo, 6, 0);
        telefoneTxt = new JTextField(15);
        telefoneTxt.setDocument(new MaxCharDocument(15));
        adicionarComponente(telefoneTxt, 6, 1);

        rotulo = new JLabel("Usuário");
        adicionarComponente(rotulo, 7, 0);
        usuarioTxt = new JTextField(15);
        usuarioTxt.setDocument(new MaxCharDocument(15));
        adicionarComponente(usuarioTxt, 7, 1);

        rotulo = new JLabel("Senha");
        adicionarComponente(rotulo, 8, 0);
        senhaTxt = new JPasswordField(15);
        senhaTxt.setDocument(new MaxCharDocument(15));
        adicionarComponente(senhaTxt, 8, 1);

        rotulo = new JLabel("Curso");
        adicionarComponente(rotulo, 9, 0);
        String[] cursos = {"Selecione seu Curso", "Ciencia da Coputação", "Sistema da Informação", "Educação fisica", "filosofia", "Matemática" };
        cursoMenu = new JComboBox<>(cursos);
        adicionarComponente(cursoMenu, 9, 1);

        rotulo = new JLabel("Observação");
        adicionarComponente(rotulo, 10, 0);
        observacaoTxt = new JTextArea(5, 30);
        observacaoTxt.setDocument(new MaxCharDocument(15));
        observacaoTxt.setLineWrap(true);
        JScrollPane observacaoScrollPane = new JScrollPane(observacaoTxt);
        adicionarComponente(observacaoScrollPane, 10, 1);

        rotulo = new JLabel("Ativo");
        adicionarComponente(rotulo, 11, 0);
        ativoSimRb = new JRadioButton("Sim");
        ativoNaoRb = new JRadioButton("Não");
        adicionarComponente(ativoSimRb, 11, 1);
        adicionarComponente(ativoNaoRb, 12, 1);

        salvarBtn = new JButton("Salvar");
        cancelarBtn = new JButton("Cancelar");

        salvarBtn.setDefaultCapable(true);
        cancelarBtn.setDefaultCapable(true);

        
        salvarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarCadastro();
            }
        });
        cancelarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.mostrarListaCadastros();
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(salvarBtn);
        buttonsPanel.add(cancelarBtn);

        adicionarComponente(buttonsPanel, 13, 1);
    }

    private void adicionarComponente(JComponent componente, int linha, int coluna) {
        constraints.gridx = coluna;
        constraints.gridy = linha;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = FIELD_INSETS;
        layout.setConstraints(componente, constraints);
        add(componente);
    }

    private void salvarCadastro() {
        
        String nome = nomeTxt.getText();
        String idade = idadeTxt.getText();
        String email = emailTxt.getText();
        String endereco = enderecoTxt.getText();
        String cep = cepTxt.getText();
        String telefone = telefoneTxt.getText();
        String usuario = usuarioTxt.getText();
        String senha = new String(senhaTxt.getPassword());
        String curso = (String) cursoMenu.getSelectedItem();
        String observacao = observacaoTxt.getText();
        String ativo = ativoSimRb.isSelected() ? "Sim" : "Não";

        
        if (nome.isEmpty() || idade.isEmpty()||  email.isEmpty() || endereco.isEmpty() || cep.isEmpty() || telefone.isEmpty() || usuario.isEmpty() || senha.isEmpty() || curso.equals("Selecione seu Curso") || observacao.isEmpty() || ativo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}