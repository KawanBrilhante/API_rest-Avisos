package br.tc.tceac.administracao;

import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;
import java.util.Objects;

public class ConteudoAvisos {

    @Id @GeneratedValue
    private Long id;
    private String titulo;
    private String mensagem;

    public ConteudoAvisos() {}

    public ConteudoAvisos(String titulo, String mensagem) {
        this.titulo = titulo;
        this.mensagem = mensagem;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof ConteudoAvisos))
            return false;
        ConteudoAvisos conteudo = (ConteudoAvisos) o;
        return Objects.equals(this.id, conteudo.id) && Objects.equals(this.titulo, conteudo.titulo)
                && Objects.equals(this.mensagem, conteudo.mensagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.titulo, this.mensagem);
    }

    @Override
    public String toString() {
        return "ConteudoAvisos{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
