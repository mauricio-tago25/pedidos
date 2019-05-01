package br.com.apsoo.pedidos.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity //tornar classe para ser elegivel
@Table(name = "TB_ESTADO") // alterar o nome da tabela
@SequenceGenerator(name = "seq_estado")
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ES_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_estado") // o id vai ser gerado automaticamente e ser controlado por seq_estado
    private Integer id;

    @Column(name = "ES_NOME")
    private String nome;

    @JsonBackReference
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>();

    public Estado() {
    }

    public Estado(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return id.equals(estado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
