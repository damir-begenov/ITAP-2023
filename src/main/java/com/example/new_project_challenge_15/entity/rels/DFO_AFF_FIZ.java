package com.example.new_project_challenge_15.entity.rels;

import com.example.new_project_challenge_15.entity.Company;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
@Node
public class DFO_AFF_FIZ {
    @Id
    @GeneratedValue
    public Long id;
    public String Label;
    public String Source;
    @Property("Вид связи")
    public String Vid_svyaziey;
    @Property("Дата начала аффилированности")
    public String Data_nachalo_affilirovannosti;
    @Property("Тип аффилированности")
    public String Type_affilirovannosti;
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

    public String getData_nachalo_affilirovannosti() {
        return Data_nachalo_affilirovannosti;
    }

    public void setData_nachalo_affilirovannosti(String data_nachalo_affilirovannosti) {
        Data_nachalo_affilirovannosti = data_nachalo_affilirovannosti;
    }

    public String getType_affilirovannosti() {
        return Type_affilirovannosti;
    }

    public void setType_affilirovannosti(String type_affilirovannosti) {
        Type_affilirovannosti = type_affilirovannosti;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
