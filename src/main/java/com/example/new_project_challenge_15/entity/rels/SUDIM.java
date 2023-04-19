package com.example.new_project_challenge_15.entity.rels;

import com.example.new_project_challenge_15.entity.Persons;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
@Node
public class SUDIM {
    @Id
    @GeneratedValue
    public Long id;
    public String Label;
    public String Source;
    @Property("Вид связи")
    public String Vid_svyaziey;

    @Property("Дата начала заключения")
    public String Data_nachala;

    @Property("Дата конца заключения")
    public String Data_konca;

    @Property("Статья")
    public String Statya;


    @TargetNode
    private Persons person;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData_nachala() {
        return Data_nachala;
    }

    public void setData_nachala(String data_nachala) {
        this.Data_nachala = data_nachala;
    }

    public String getData_konca() {
        return Data_konca;
    }
    
    public void setData_konca(String data_konca) {
        Data_konca = data_konca;
    }

    public String getStatya() {
        return Statya;
    }

    public void setStatya(String statya) {
        Statya = statya;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getVid_svyaziey() {
        return Vid_svyaziey;
    }

    public void setVid_svyaziey(String vid_svyaziey) {
        Vid_svyaziey = vid_svyaziey;
    }

    public Persons getPerson() {
        return person;
    }

    public void setPerson(Persons person) {
        this.person = person;
    }
}
