package com.example.new_project_challenge_15.entity.rels;

import com.example.new_project_challenge_15.entity.Company;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
@Node
public class GOSZAKUP {
    @Id
    @GeneratedValue
    public Long id;
    public String Label;
    public String Source;
    @Property("Вид связи")
    public String Vid_svyaziey;
    @Property("ИИН-БИН поставщика")
    public String IINBIN_postavshika;
    @Property("БИН заказчика")
    public String BIN_zakazchika;
    @Property("Итоговая сумма, без НДС")
    public String itog_summa;
    @TargetNode
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public String getIINBIN_postavshika() {
        return IINBIN_postavshika;
    }

    public void setIINBIN_postavshika(String IINBIN_postavshika) {
        this.IINBIN_postavshika = IINBIN_postavshika;
    }

    public String getBIN_zakazchika() {
        return BIN_zakazchika;
    }

    public void setBIN_zakazchika(String BIN_zakazchika) {
        this.BIN_zakazchika = BIN_zakazchika;
    }

    public String getItog_summa() {
        return itog_summa;
    }

    public void setItog_summa(String itog_summa) {
        this.itog_summa = itog_summa;
    }
}
