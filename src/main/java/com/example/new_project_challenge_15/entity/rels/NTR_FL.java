package com.example.new_project_challenge_15.entity.rels;

import com.example.new_project_challenge_15.entity.Company;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
@Node
public class NTR_FL {
    @Id
    @GeneratedValue
    public Long id;
    public String Label;
    public String Source;
    @Property("Вид связи")
    public String Vid_svyaziey;
    @Property("Дата")
    public String data;
    @Property("Номер сделки")
    public String nomer_sdelki;
    @Property("Тип сделки")
    public String type_sdelki;
    @TargetNode
    private Company company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNomer_sdelki() {
        return nomer_sdelki;
    }

    public void setNomer_sdelki(String nomer_sdelki) {
        this.nomer_sdelki = nomer_sdelki;
    }

    public String getType_sdelki() {
        return type_sdelki;
    }

    public void setType_sdelki(String type_sdelki) {
        this.type_sdelki = type_sdelki;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
