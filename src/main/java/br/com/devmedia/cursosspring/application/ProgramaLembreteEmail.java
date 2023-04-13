package br.com.devmedia.cursosspring.application;

import br.com.devmedia.cursosspring.domain.Usuario;
import br.com.devmedia.cursosspring.service.UsuarioServico;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("br.com.devmedia.cursosspring")
public class ProgramaLembreteEmail {

    public static void main(String[] args) {
        Scanner lerDados = new Scanner(System.in);
        Usuario usuario = new Usuario("Marcio", "marcio.lapuma@gmail.com", "mlapuma");

        System.out.println("Deseja recuperar a senha (S/N)?");
        String resposta = lerDados.nextLine();
        if (resposta.equalsIgnoreCase("S")) {
            ApplicationContext context = new AnnotationConfigApplicationContext(ProgramaLembreteEmail.class);
            UsuarioServico usuarioServico = context.getBean(UsuarioServico.class);

            usuarioServico.setUsuario(usuario);
            usuarioServico.lembrarSenhaPorEmail();
        }
    }

}
