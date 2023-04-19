package com.example.new_project_challenge_15.entity.rels;

import com.example.new_project_challenge_15.entity.Company;
import com.example.new_project_challenge_15.entity.Persons;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
@Node
public class FOUNDER_HIST {
    @Id
    @GeneratedValue
    public Long id;
    public String Label;
    public String Source;
    @Property("ИИН/БИН")
    public String IIN_BIN;

    @Property("БИН/ИИН работадателя")
    public String IINBIN_rabotadatelya;

    @Property("Наименование типа должности на русском")
    public String NAME_tipa_dolzhnosty;

    @Property("Дата начала")
    public String Data_nachalo;

    @Property("Дата конца")
    public String data_okonchanya;

    @Property("Вид связи")
    public String Vid_svyaziey;

    @TargetNode
    private Company company;

    public String getData_okonchanya() {
        return data_okonchanya;
    }

    public void setData_okonchanya(String data_okonchanya) {
        this.data_okonchanya = data_okonchanya;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

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

    public String getIIN_BIN() {
        return IIN_BIN;
    }

    public void setIIN_BIN(String IIN_BIN) {
        this.IIN_BIN = IIN_BIN;
    }

    public String getIINBIN_rabotadatelya() {
        return IINBIN_rabotadatelya;
    }

    public void setIINBIN_rabotadatelya(String IINBIN_rabotadatelya) {
        this.IINBIN_rabotadatelya = IINBIN_rabotadatelya;
    }

    public String getNAME_tipa_dolzhnosty() {
        return NAME_tipa_dolzhnosty;
    }

    public void setNAME_tipa_dolzhnosty(String NAME_tipa_dolzhnosty) {
        this.NAME_tipa_dolzhnosty = NAME_tipa_dolzhnosty;
    }

    public String getData_nachalo() {
        return Data_nachalo;
    }

    public void setData_nachalo(String Data_nachalo) {
        this.Data_nachalo = Data_nachalo;
    }

    public String getVid_svyaziey() {
        return Vid_svyaziey;
    }

    public void setVid_svyaziey(String vid_svyaziey) {
        Vid_svyaziey = vid_svyaziey;
    }
}
