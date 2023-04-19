package com.example.new_project_challenge_15.entity.rels;

import com.example.new_project_challenge_15.entity.Company;
import com.example.new_project_challenge_15.entity.Persons;
import org.springframework.data.neo4j.core.schema.*;
import org.springframework.security.core.parameters.P;

import java.util.List;

@RelationshipProperties
public class ESF_5and10 {
    @Id
    @GeneratedValue
    public Long id;
    public String Label;
    public String Source;
    @Property("Вид связи")
    public String Vid_svyaziey;
    @Property("Общая сумма ЭСФ")
    public String obshaya_summa;
    @Property("ЭСФ за 2019 год")
    public String esf_2019;
    @Property("ЭСФ за 2020 год")
    public String esf_2020;

    @Property("ЭСФ за 2021 год")
    public String esf_2021;

    @Property("ЭСФ за 2022 год")
    public String esf_2022;

    @TargetNode
    @Property("Company")

    private Company company;

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

    public String getVid_svyaziey() {
        return Vid_svyaziey;
    }

    public void setVid_svyaziey(String vid_svyaziey) {
        Vid_svyaziey = vid_svyaziey;
    }

    public String getObshaya_summa() {
        return obshaya_summa;
    }

    public void setObshaya_summa(String obshaya_summa) {
        this.obshaya_summa = obshaya_summa;
    }

    public String getEsf_2019() {
        return esf_2019;
    }

    public void setEsf_2019(String esf_2019) {
        this.esf_2019 = esf_2019;
    }

    public String getEsf_2020() {
        return esf_2020;
    }

    public void setEsf_2020(String esf_2020) {
        this.esf_2020 = esf_2020;
    }

    public String getEsf_2021() {
        return esf_2021;
    }

    public void setEsf_2021(String esf_2021) {
        this.esf_2021 = esf_2021;
    }

    public String getEsf_2022() {
        return esf_2022;
    }

    public void setEsf_2022(String esf_2022) {
        this.esf_2022 = esf_2022;
    }

}
